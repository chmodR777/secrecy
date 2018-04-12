////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
//
// ALL RIGHTS RESERVED BY SYNTC CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/*
 * CLASS      ： Connection
 * VERSION    ： 0.00
 * DATE       ： 2006/07/04
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/04 0.00 作成
 */
package com.syntc.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.DriverManager;

/**
 * 用来 preallocating, recycling, and managing
 * JDBC connections 的基类
 */
public class ConnectionPool implements Runnable {

    /**Database Driver.*/
    private String str_Driver;
    
    /**Connection URL.*/
    private String str_Url;
    
    /**User Name.*/
    private String str_UserName;
    
    /**Password.*/
    private String str_PassWord;
    
    /**Maxmimum Connection Number.*/
    private int i_MaxConnections;
    
    /**Wait flag which indicate that no available connection.*/
    private boolean b_WaitIfBusy;
    
    /**Available Connection.*/
    private static Vector v_AvailableConnections;
    
    /**Busy flag.*/
    private Vector v_BusyConnections;
    
    /**Flag which indicate that a connection is making.*/
    private boolean b_ConnectionPending = false;

    //数据库连接池
    private static ConnectionPool cp_ConnectionPool = null;

    /**
     * 取得可以使用空闲状态的数据库连接个数
     * 详细说明
     * @param NONE
     * @return 可以使用的连接个数据
     * @exception NONE
     */
    public static int getAvailableConnections(){
        return v_AvailableConnections.size();
    }

    /**
     * 取得处于使用状态的连接个数
     * 详细说明
     * @param NONE
     * @return 可以使用的连接个数据
     * @exception NONE
     */
    public int getBusyConnections(){
        return this.v_BusyConnections.size();
    }

    /**
     * 取得数据库连接池
     * 详细说明
     * @param NONE
     * @return 当前连接的数据库连接池
     * @exception NullPointerException 数据库连接池没有被实例化
     */
    public static ConnectionPool getConnectionPool () throws NullPointerException {
        synchronized (cp_ConnectionPool) {
            if (cp_ConnectionPool == null)  {
                throw new NullPointerException ("连接池没有被实例化!");
            }
            return cp_ConnectionPool;
        }
    }

    /**
     * 初始化数据库连接池
     * 详细说明
     * @param str_Driver Database Driver
     * @param str_Url Connection URL
     * @param str_UserName user name
     * @param str_PassWord str_PassWord
     * @param initialConnections initial connections number
     * @param i_MaxConnections maxmimum connection number
     * @param b_WaitIfBusy wait flag which indicate when no available connection is in the pool
     * @throws SQLException
     */
    public ConnectionPool(String p_str_Driver, 
                          String p_str_Url,
                          String p_str_UserName,
                          String p_str_PassWord,
                          int p_initialConnections,
                          int p_i_MaxConnections,
                          boolean p_b_WaitIfBusy)
            throws SQLException {

        this.str_Driver = p_str_Driver;
        this.str_Url = p_str_Url;
        this.str_UserName = p_str_UserName;
        this.str_PassWord = p_str_PassWord;
        this.i_MaxConnections = p_i_MaxConnections;
        this.b_WaitIfBusy   = p_b_WaitIfBusy;

        if (p_initialConnections > p_i_MaxConnections) {
        	p_initialConnections = p_i_MaxConnections;
        }

        v_AvailableConnections = new Vector(p_initialConnections);
        v_BusyConnections   = new Vector();
        
        for(int i=0; i<p_initialConnections; i++) {
            v_AvailableConnections.addElement( makeNewConnection() );
        }

        cp_ConnectionPool = this;

    }

    /**
     * 从数据库连接池中取得可以使用的连接
     * 详细说明
     * If available connection exists, return a available connection.
     * If available connection doesn't exist and the pool's all connection number has not reach the maxmimum connection number, then make a new connection , and return it.
     * If available connection doesn't exist and the pool's all connection number has not reach the maxmimum connection number,
     * if the b_WaitIfBusy parameter equals false,throws a exception indicated maxmimum connection limited ，else wait for a available connection.
     * @return a available connection
     * @throws SQLException
     */
    public synchronized Connection getConnection()
            throws SQLException {
        if (!v_AvailableConnections.isEmpty()) {
            Connection existingConnection = (Connection)v_AvailableConnections.lastElement();
            int lastIndex = v_AvailableConnections.size() - 1;
            v_AvailableConnections.removeElementAt(lastIndex);

            ///////////////////////////////////////////////////////////////////
            // If connection on available list is closed (e.g.,
            // it timed out), then remove it from available list
            // and repeat the process of obtaining a connection.
            // Also wake up threads that were waiting for a
            // connection because maxConnection limit was reached.
			///////////////////////////////////////////////////////////////////

            if (existingConnection.isClosed()) {

				// Freed up a spot for anybody waiting
                notifyAll(); 

                return(getConnection());

            } else {

                v_BusyConnections.addElement(existingConnection);

                return(existingConnection);

            }
        } 
		else {
			///////////////////////////////////////////////////////////////////
            // Three possible cases:
            // 1) You haven't reached i_MaxConnections limit.   So
            //    establish one in the background if there isn't
            //    already one pending, then wait for
            //    the next available connection (whether or not
            //    it was the newly established one).
            // 2) You reached i_MaxConnections limit and b_WaitIfBusy
            //    flag is false. Throw SQLException in such a case.
            // 3) You reached i_MaxConnections limit and b_WaitIfBusy
            //    flag is true. Then do the same thing as in second
            //    part of step 1: wait for next available connection.
			///////////////////////////////////////////////////////////////////

            if ((totalConnections() < i_MaxConnections) &&
                !b_ConnectionPending) {

                makeBackgroundConnection();

            } else if (!b_WaitIfBusy)   {

                throw new SQLException("Connection limit reached");

            }

			///////////////////////////////////////////////////////////////////
            // Wait for either a new connection to be established
            // (if you called makeBackgroundConnection) or for
            // an existing connection to be freed up.
			///////////////////////////////////////////////////////////////////
            try {
					wait();

            } 
			catch(InterruptedException ie) {

				//EMPTY

			}
                
				// Someone freed up a connection, so try again.
                return(getConnection());
        }
    }

    /**
     * 详细说明
     *   You can't just make a new connection in the foreground
     *  when none are available, since this can take several
     *  seconds with a slow network connection. Instead,
     *  start a thread that establishes a new connection,
     *  then wait. You get woken up either when the new connection
     *  is established or if someone finishes with an existing
     *  connection.
	 * @return void
     * @throws none
     */
    private void makeBackgroundConnection() {

        b_ConnectionPending = true;

        try {

            Thread connectThread = new Thread(this);
            connectThread.start();

        } catch(OutOfMemoryError oome) {
            // Give up on new connection
        }
    }

    /**
     * 详细说明
     *   Reserved。Make a new connection when connection number has not reach the maxmimm number.
     *   Caution: don't use this method directly, invoke {@link #getConnection() } to get a new database connection.
	 * @return void
     * @exception Exception
     */
    public void run() {
        try {
            Connection connection = makeNewConnection();
            synchronized(this) {
                v_AvailableConnections.addElement(connection);
                b_ConnectionPending = false;
                notifyAll();
            }
        } catch(Exception e) { 
			///////////////////////////////////////////////////////////////////
			// SQLException or OutOfMemory
            // Give up on new connection and wait for existing one
            // to free up.
        }
    }

    /**
     * 详细说明
     * This explicitly makes a new connection. Called in
     * the foreground when initializing the ConnectionPool,
     * and called in    the background when running.
     * @return newly created database connection
     * @throws SQLException
     */
    private Connection makeNewConnection()
            throws SQLException {
        try {

            // Load database str_Driver if not already loaded
            Class.forName(str_Driver);

            // Establish network connection to database
            Connection connection =
                    DriverManager.getConnection(str_Url, str_UserName, str_PassWord);

            return(connection);
        } 
		catch(ClassNotFoundException cnfe) {
			///////////////////////////////////////////////////////////////////
            // Simplify try/catch blocks of people using this by
            // throwing only one exception type.
            throw new SQLException("Can't find class for str_Driver: " +
                                   str_Driver);
        }
    }

    /**
     * 详细说明
     * Release all connection.
     * And notify other thread to have a opportiny get a connection.
     * @param connection databse connection
     * @return void
     * @throws SQLException
     */
    public synchronized void free(Connection connection) {

      if (this.isElement(v_BusyConnections,connection)){
        v_BusyConnections.removeElement(connection);
      }else{
         System.out.println("occor connection is not business!!!!");
      }
      if (!this.isElement(v_AvailableConnections,connection)){
            v_AvailableConnections.addElement(connection);
        }else{
            System.out.println("occor refree  connection !!!");
            System.out.println("v_AvailableConnections:"+v_AvailableConnections.size());
            System.out.println("v_BusyConnections:"+v_BusyConnections.size());
        }
        // Wake up threads that are waiting for a connection
        notifyAll();
    }

    private boolean isElement(Vector vec,Connection conn){
       for (int i=0 ; i<vec.size() ;i++ ){
          Connection  temp = (Connection)vec.get(i);
          if (temp == conn){
             return true;
          }
       }
       return false;
    }

    /**
     * 详细说明
     * All connection.
     * @param connection databse connection
     * @return all connction.
     * @throws SQLException
     */
    public synchronized int totalConnections() {
        return(v_AvailableConnections.size() +
               v_BusyConnections.size());
    }

    /**
     * 详细说明
     *  Close all the connections. Use with caution:
     *  be sure no connections are in use before
     *  calling. Note that you are not <I>required</I> to
     *  call this when done with a ConnectionPool, since
     *  connections are guaranteed to be closed when
     *  garbage collected. But this method gives more control
     *  regarding when the connections are closed.
     * @param void
     * @return void
     * @throws SQLException
     */
    public synchronized void closeAllConnections() {
        closeConnections(v_AvailableConnections);
        v_AvailableConnections = new Vector();
        closeConnections(v_BusyConnections);
        v_BusyConnections   = new Vector();
    }

    /**
     * 详细说明
     *  Close database connection.
     * @param connections connections
     * @return void
     * @throws SQLException
     */
    private void closeConnections(Vector connections) {
        try {
            for(int i=0; i<connections.size(); i++) {
                Connection connection =
                      (Connection)connections.elementAt(i);
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch(SQLException sqle) {
            // Ignore errors; garbage collect anyhow
        }
    }

    /**
     * 详细说明
     *  Pool's information.
     * @param connections connections
     * @@return connection pool information
     * @throws SQLException
     */
    public synchronized String toString() {
        String info =
                "ConnectionPool(" + str_Url + "," + str_UserName + ")" +
                ", available=" + v_AvailableConnections.size() +
                ", busy=" + v_BusyConnections.size() +
                ", max=" + i_MaxConnections;
        return(info);
    }
}
