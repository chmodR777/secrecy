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
 * CLASS      �� InitPoolLisener
 * DESC       :  ��ݿ�l�ӳؼ���
 * VERSION    �� 0.00
 * DATE       �� 2006/07/04
 * AUTHOR     �� jinghuizhen@hotmail.com
 * HISTORY    �� 2006/07/04 0.00 ���
 */

package com.syntc.util;

import com.syntc.util.ConnectionPool;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;


public class InitPoolLisener implements javax.servlet.ServletContextListener {
    private java.util.Timer timer;

    public InitPoolLisener() {
        timer = new java.util.Timer(true);
    }

    public void contextDestroyed(javax.servlet.ServletContextEvent event) {
        System.out.println("destory");
        timer.cancel();
    }


    public void contextInitialized(javax.servlet.ServletContextEvent event) {
        try {

          FileInputStream propFile = new FileInputStream(event.getServletContext().getRealPath("/")+
                    "init.properties"); 

            Properties p = new Properties();
            p.load(propFile);
            String databasedriver = p.getProperty("databasedriver").trim();
            String databaseurl = p.getProperty("databaseurl").trim();
            String username = p.getProperty("username").trim();
            String password = p.getProperty("password").trim();

            String sinitconnectnum = p.getProperty("initconnectnum").trim();
            String smaxconnectnum = p.getProperty("maxconnectnum").trim();
            int initconnectnum = Integer.parseInt(sinitconnectnum);
            int maxconnectnum = Integer.parseInt(smaxconnectnum);

            boolean waitflag = Boolean.valueOf(p.getProperty("waitflag").trim()).booleanValue();
            ConnectionPool connectionPool = new ConnectionPool(databasedriver, databaseurl, username, password, initconnectnum, maxconnectnum, waitflag);
            System.out.println("SQL Server CONNECTED " + databaseurl + " ��");
        } catch (SQLException e) {
            System.out.println("ConnectionPool init error!!");
        } catch (FileNotFoundException e) {
            System.out.println("init.properties file not found in "+event.getServletContext().getRealPath("//")+"!!");
        } catch (IOException e) {
            System.out.println("read init.properties error!!");
        }

       timer.schedule(new java.util.TimerTask() {
       public void run() {
         System.out.print("FREE CONNECTIONS : ");
         System.out.println(ConnectionPool.getAvailableConnections()) ;
            }
        }, 0, 1000000);



    }

}

