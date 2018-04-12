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
 * CLASS      ： DBOperate
 * DESC       :  数据库基础操作类
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */
package com.syntc.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

import com.syntc.constants.CommonConstants;
import com.syntc.util.ResultObj;

public class DBOperate {
  /**
   * 数据库连接对象
   */
  private int rows;
  private int cols;
  private String strMsg = ""; //调试信息
  private Connection Con = null;
  private Vector v_SQL = null;

  /**
   * 批处理数据库操作时执行SQL语句序号
   */
  private int iSqlLineNo = 0;
  private boolean PRIN_CHEK = true; //true :打印 false :不打印

/**
 * 设置调试错误信息
 * 详细说明
 * @param 错误信息
 * @return void
 * @exception NONE
 */
  public void setDebugMsg(String p_str_Msg) {
    strMsg = p_str_Msg;
  }

/**
 * 取得调试错误信息
 * 详细说明
 * @param void
 * @return 取得错误的调试信息
 * @exception NONE
 */
  public String getDebugMsg() {
    return this.strMsg;
  }

  public DBOperate() {

  }

/**
 * 在控制台打出调试信息,如果当前是可以进行调试的状态
 * 详细说明
 * @param void
 * @return void
 * @exception NONE
 */
  private void DebugMsg(String strMsg) {
    if (PRIN_CHEK) {
      System.out.println(
          "----------- 数据库调试信息 -----------");
      System.out.println(strMsg);

      int i_size = this.v_SQL.size();
      for (int i = 0; i < i_size; i++) {
        System.out.println( (String) v_SQL.get(i));
      }

      System.out.println("----------- 调试信息结束 -----------");
    }
  }


/**
 * 建立数据库连接 如果是通过 WEBSPHERE 进行的数据库连接修改这个位置即可.
 * 详细说明
 * @param void
 * @return void
 * @exception NONE
 */
  private void myOpen() {
    try {

        // 建立数据库连接
        this.Con = ConnectionPool.getConnectionPool().getConnection();

        // 禁止自动提交
        this.Con.setAutoCommit(false);

        if (this.Con == null) {
          System.out.println("取得连接失败! myOpen");
        }

    }
    catch (SQLException ex) {
      this.Con = null;
    }
    catch (Exception ex) {
      this.Con = null;
    }

  }

  public void Open() {

  }

/**
 * 数据库查询.返回记录数
 * 详细说明
 * @param void
 * @return void
 * @exception NONE
 */
  public int getMaxRecord(String strSql) {
    this.myOpen();
    int max = 0;
    Statement stmt = null;
    try {
      stmt = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                 ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = stmt.executeQuery(strSql);
      while (rs.next()) {
        max++;
      }
      return max;
    }
    catch (SQLException ex) { 
	  // 数据库操作失败
      this.DebugMsg("getMaxRecord is error: " + ex.toString());

    }
    finally {
      this.myClose();
      return max;
    }

  }

/**
 * 数据库查询.数据库查询,根据传递参数进行数据库查询操作。
 * 详细说明
 * @param stSql String SQL查询语句 IN
 * @return ResultObj 取得的查询结果
 * @exception NONE
 */
  public ResultObj Query(String stSql) {
    this.myOpen();
    ResultObj obResult = new ResultObj();

    if (this.Con == null) {
      obResult.setStatus( -1);
      return (obResult);
    }

    try {
      // 执行数据库查询操作
      obResult = queryExecute(stSql, this.Con);

      this.myClose();
      if (obResult.getRows() > 1) { 
		// 数据库操作正常且存在符合查询条件的记录
        obResult.setStatus(0);
      }
      if (obResult.getRows() == 1) {
		// 数据库操作正常但没有符合查询条件的记录
        obResult.setStatus(1);
      }
    }
    catch (SQLException ex) { 
	  // 数据库操作失败
      this.setSQL(stSql);
      obResult.setStatus( -1);
      System.out.println("ex.toString()1 = " + ex.toString());
      this.setDebugMsg(ex.toString());
      this.DebugMsg(ex.toString());
      this.myClose();
    }
    catch (Exception ex) {
      this.setDebugMsg(ex.toString());
      System.out.println("ex.toString()2 = " + ex.toString());
      obResult.setStatus( -1);
      this.myClose();
    }

    return (obResult);
  }

/**
 * 执行查询数据库操作
 * 详细说明
 * @param sql SQL语句
 * @param con 数据库连接对象
 * @return Result对象
 * @exception java.sql.SQLException
 */
  private ResultObj queryExecute(String sql, Connection con) throws
      SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    ResultObj result = new ResultObj();
    rows = 0;

    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery(sql);

      ResultSetMetaData rsmd = rs.getMetaData();
      cols = rsmd.getColumnCount();

      String s[] = new String[cols];
      for (int i = 1; i <= cols; i++) {
        s[i - 1] = rsmd.getColumnLabel(i);
      }
      result.add(s);
      rows++;

      while (rs.next()) {
        s = new String[cols];
        for (int i = 1; i <= cols; i++) {
          s[i - 1] = Helper(rs, rsmd.getColumnType(i), i);

        }
        result.add(s);
        rows++;
      }

      result.setCols(cols);
      result.setRows(rows);

      rs.close();
      stmt.close();
    }
    catch (SQLException e1) {
      System.out.println("ex.toString " + e1.toString());
      System.out.println("错误SQL  ： " + sql);
    }
    finally {
      try {
        stmt.close();
      }
      catch (SQLException e) {
        System.out.println("游标关闭失败 ： " + e.getMessage());
      }
    }
    return (result);
  }

  protected String Helper(ResultSet rs, int dataType, int col) throws
      SQLException {
    String retValue = null;
    Integer intObj;

    switch (dataType) {
      case Types.DATE:
        java.sql.Date date = rs.getDate(col);
        if (date != null)
          retValue = date.toString();
        break;
      case Types.TIME:
        java.sql.Time time = rs.getTime(col);
        if (time != null)
          retValue = time.toString();
        break;
      case Types.TIMESTAMP:
        java.sql.Timestamp timestamp = rs.getTimestamp(col);
        if (timestamp != null)
          retValue = timestamp.toString();
        break;
      case Types.CHAR:
      case Types.VARCHAR:
      case Types.LONGVARCHAR:
        retValue = rs.getString(col);
        break;
      case Types.NUMERIC:
      case Types.DECIMAL:
        java.math.BigDecimal numeric = rs.getBigDecimal(col);
        if (numeric != null)
          retValue = numeric.toString();
        break;
      case Types.BIT:
        boolean bit = rs.getBoolean(col);
        Boolean boolObj = new Boolean(bit);
        retValue = boolObj.toString();
        break;
      case Types.TINYINT:
        byte tinyint = rs.getByte(col);
        intObj = new Integer(tinyint);
        retValue = intObj.toString();
        break;
      case Types.SMALLINT:
        short smallint = rs.getShort(col);
        intObj = new Integer(smallint);
        retValue = intObj.toString();
        break;
      case Types.INTEGER:
        int integer = rs.getInt(col);
        intObj = new Integer(integer);
        retValue = intObj.toString();
        break;
      case Types.BIGINT:
        long bigint = rs.getLong(col);
        Long longObj = new Long(bigint);
        retValue = longObj.toString();
        break;
      case Types.REAL:
        float real = rs.getFloat(col);
        Float floatObj = new Float(real);
        retValue = floatObj.toString();
        break;
      case Types.FLOAT:
      case Types.DOUBLE:
        double longreal = rs.getDouble(col);
        Double doubleObj = new Double(longreal);
        retValue = doubleObj.toString();
        break;
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
        byte[] binary = rs.getBytes(col);
        if (binary != null)
          retValue = new String(binary);
        break;
    }
    if (retValue == null) {
      retValue = "";
    }
    return retValue;
  }

/**
 * 执行数据库的更新操作
 * 详细说明
 * @param sql SQL语句
 * @param con 数据库连接对象
 * @exception java.sql.SQLException
 */
  private void Update(String sql, Connection con) throws SQLException {

    try{
        System.out.println("**********************************************");
        System.out.println("执行SQL " + sql);
        System.out.println("**********************************************");
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
    }
    catch(SQLException e){

        System.out.println("**********************************************");
        System.out.println("错误SQL " + sql);
        System.out.println("*DBOperate.Update DEBUG INFO ");
        System.out.println(e.toString() );
        System.out.println("**********************************************");

        throw e;
    }
    catch(Exception e){
       System.out.println("Update Error toString : " + e.toString());
    }

  }

  public void Update(String sql) {
    this.doTransaction(sql);
  }

  public boolean Callproc(String proc, String value[]) {
    try {
      this.myOpen();
      if (Con == null)
        throw new Exception("don't open Connection");
      CallableStatement stmt = Con.prepareCall(proc);
      if (value != null) {
        for (int i = 1; i <= value.length; i++)
          stmt.setString(i, value[i - 1]);
      }
      stmt.execute();
      stmt.close();
      this.myClose();
      return true;
    }
    catch (SQLException e) {
      this.setDebugMsg(e.toString());
      this.DebugMsg(e.toString());
      this.myClose();
      return false;

    }
    catch (Exception e) {
      this.setDebugMsg(e.toString());
      this.DebugMsg(e.toString());
      this.myClose();
      return false;
    }

  }

  //调用存储过称 j: 为要输出的参数 当j=0 是代表没输出有参数
  public int CallprocOut(String proc, String invalue[], int j) {
    try {

      this.myOpen();
      if (Con == null)
        throw new Exception("don't open Connection");
      CallableStatement stmt = Con.prepareCall(proc);
      if (invalue != null) {
        for (int i = 1; i <= invalue.length; i++)
          stmt.setString(i, invalue[i - 1]);

      }
      if (j != 0) {
        stmt.registerOutParameter(j, java.sql.Types.INTEGER);
      }
      stmt.execute();
      int k = stmt.getInt(j);
      stmt.close();
      this.myClose();
      return k;
    }
    catch (SQLException e) {
      this.DebugMsg(e.toString());
      this.myClose();
      return -1;

    }
    catch (Exception e) {
      this.DebugMsg(e.toString());
      this.myClose();
      return -1;
    }

  }


  private void myClose() {

    try {
        // 关闭数据库连接
        ConnectionPool.getConnectionPool().free(this.Con); // 关闭数据库连接
    }
    catch (Exception ex) {
      this.Con = null;
    }
  }

  public void Close() {
	  //EMPTY
  }

/**
 * 数据库批处理操作,批处理数据库操作，全部成功后提交，否则回退至最初状态。
 * 详细说明
 *  　　 0：全部操作均正常结束，且正确提交。（一般）<br>
 *  　　-1：未能建立正确的数据库连接。（罕见）<br>
 *  　　-2：批处理中的一个操作未能正常结束。（偶尔）<br>
 *  　　-3：未能正确执行回退操作。（非常罕见）<br>
 *  　　-4：未能正确执行提交操作。（非常罕见）<br>
 *
 * @param Vector vSql SQL语句集合 IN<br>
 *
 * @return int 处理结果<br>
 */
  public int doTransaction(Vector vSqls) {
    this.myOpen();
    // 变量定义
    int iSize;

    if (this.Con == null) { // 无效的数据库连接
      return ( -1);
    }

    try {
      // 批处理数据库操作
      iSize = vSqls.size();
      for (this.iSqlLineNo = 0; this.iSqlLineNo < iSize; this.iSqlLineNo++) {
        Update( (String) vSqls.get(this.iSqlLineNo), this.Con);

      }
    }
    catch (SQLException ex) { // 数据库操作失败
      this.setSQL(vSqls);
      
      try {
        this.Con.rollback(); // 回退
        this.setDebugMsg(ex.toString());
        return ( -2);
      }
      catch (SQLException ex1) {
        this.setDebugMsg(ex1.toString());

        return ( -3);
      }
      catch (Exception ex1) {
        this.setDebugMsg(ex1.toString());
        return ( -3);
      }
    }
    catch (Exception ex) { // 系统异常导致无法进行数据库操作
      try {
        this.Con.rollback();
        this.setDebugMsg(ex.toString());
        return ( -2);
      }
      catch (SQLException ex1) {
        this.setDebugMsg(ex1.toString());
        return ( -3);
      }
      catch (Exception ex1) {
        this.setDebugMsg(ex1.toString());
        return ( -3);
      }
    }
    finally { // 所有数据库操作均正常结束
      try {
        this.Con.commit();
        this.myClose(); // 提交
      }
      catch (SQLException ex) {
        this.myClose();
        this.setDebugMsg(ex.toString());
        System.out.println("**********************************************");
        System.out.println("*DBOperate DEBUG INFO ");
        System.out.println(ex.toString() );
        System.out.println("**********************************************");

        return ( -4);
      }
      catch (Exception ex) {
        this.myClose();
        this.setDebugMsg(ex.toString());
        System.out.println("**********************************************");
        System.out.println("*DBOperate DEBUG INFO ");
        System.out.println(ex.toString() );
        System.out.println("**********************************************");

        return ( -4);
      }
    }

    return (0);
  }

  /**
   *
   * @param sql
   * @return
   */
  public int doTransaction(String sql) {
    Vector vSqls = new Vector();
    vSqls.addElement(sql);
    return this.doTransaction(vSqls);
  }

  /**
   * 执行DDL语言
   * 详细说明
   *  　　 执行数据库DDL语言
   *
   * @param DDL SQL<br>
   * @return boolean 处理结果<br>
   */
  public boolean executeDDL(String p_str_SQL ){
	  boolean b_Rtn = true;
	  Statement stmt = null;
	  try{
		  myOpen();
		  
		  stmt=this.Con.createStatement();
		  
		  b_Rtn = stmt.execute( p_str_SQL );
		  
		  stmt.close();
		  myClose();
	}catch(Exception ex){
		myClose();		
		this.setDebugMsg(ex.toString());
	}	  
	  
	return b_Rtn;
  }
  
  /**
   * 设置执行的sql语句
   */
  private void setSQL(String sql) {
    if (this.v_SQL == null) {
      this.v_SQL = new Vector();
    }
    this.v_SQL.add(sql);
  }

  /**
   * 设置执行的sql语句
   */
  private void setSQL(Vector sql) {
    if (this.v_SQL == null) {
      this.v_SQL = new Vector();
    }
    this.v_SQL = sql;
  }

  	/**
   	* 数据库查询.数据库查询,根据传递参数进行数据库查询操作，返回指定对象LIST。
   	* 详细说明 (Add By Ds 2006-07-13)
   	* @param p_strSQL String SQL查询语句
   	* @param p_strSQL String 指定返回LIST对象类型
   	* @return List 指定对象的LIST
   	* @exception Exception
   	*/
	public List query(String p_strSQL, String p_strClassName)
		throws Exception
	{
	    // 定义返回变量
	    List lstRet = new ArrayList();
	    
	    // 执行查询
	    ResultObj rs_Rslt = this.Query(p_strSQL);
	    
	    // 如果查询成功
	    if (CommonConstants.CLDEF_DB_OK == rs_Rslt.getStatus()) {
	    
	        // 转换ResultObj到对象类型List
	        lstRet = this.formatRsToObjectList(rs_Rslt, p_strClassName);
	        
	    // 如果查询失败
	    }else{
	        
	        // 创建LOG对象
	        CommonLog log = new CommonLog();
	        
	        // 写LOG
	    	log.writeTrace( 
	    	        CommonConstants.CLDEF_LOG_TYPE_INFO,
		    		"com.syntc.util.DBOperate",
		    		"QUERY(" + p_strClassName + ")",
		    		"NG. SQL = " + p_strSQL );
	    }
	    
	    // 返回查询结果
	    return lstRet;
	}

  	/**
   	* 数据库查询.数据库查询,根据传递参数进行数据库查询操作，查询结果设置到指定对象。
   	* 详细说明 (Add By Ds 2006-07-13)
   	* @param p_strSQL String SQL查询语句
   	* @param p_strSQL String 指定返回LIST对象类型
   	* @param p_objRet Object 指定返回对象 IN/OUT
   	* @return none
   	* @exception Exception
   	*/
	public void query(String p_strSQL, String p_strClassName, Object p_objRet)
		throws Exception
	{
	    // 执行查询
	    ResultObj rs_Rslt = this.Query(p_strSQL);
	    
	    // 如果查询成功
	    if (CommonConstants.CLDEF_DB_OK == rs_Rslt.getStatus()) {
	    
	        // 转换ResultObj到对象类型List
	        this.formatRsToObjectSingle(rs_Rslt, p_strClassName, p_objRet);
	        
	    // 如果查询失败
	    }else{
	        
	        // 创建LOG对象
	        CommonLog log = new CommonLog();
	        
	        // 写LOG
	    	log.writeTrace( 
	    	        CommonConstants.CLDEF_LOG_TYPE_INFO,
		    		"com.syntc.util.DBOperate",
		    		"QUERY(" + p_strClassName + ")",
		    		"NG. SQL = " + p_strSQL );
	    }
	}

  	/**
   	* 查询结果集转换.将查询结果集转换成指定类型的对象LIST。
   	* 详细说明 (Add By Ds 2006-07-13)
   	* @param p_rs ResultObj 查询结果集
   	* @param p_strClassName String 指定类型名称（package.class）
   	* @return List 指定对象的LIST
   	* @exception Exception
   	*/
	public List formatRsToObjectList(ResultObj p_rs, String p_strClassName)
		throws Exception{
		
	    // 定义返回值
		List lstRet = new ArrayList();
		
		// 定义变量
		Class clsRetObj     = Class.forName(p_strClassName);		// 返回LIST对象类型
		Method[] arrMethods = clsRetObj.getDeclaredMethods();		// 对象类型的全部方法
		List lstMethods     = new ArrayList();						// 对象类型的可SET方法LIST
		List lstRsFields    = new ArrayList();						// 对象类型的可SET方法对应字段LIST
		
		// 循环查看每个方法
		for(int i=0; i<arrMethods.length; i++){
		    
		    // 取得当前方法名称
			String strMethodName = arrMethods[i].getName();

			// 如果当前方法是可访问的，并且是Setter方法
			//if( arrMethods[i].isAccessible() && "set".equals(strMethodName.substring(0, 3)) ){
			if( "set".equals(strMethodName.substring(0, 3)) ){

			    // 取得方法的参数列表
			    Class[] arrPara = arrMethods[i].getParameterTypes();
			    
			    // 如果方法参数只有一个，并且是String类型的
			    if( arrPara != null && arrPara.length == 1 && arrPara[0] == String.class ){

			        // 添加方法 到 可SET方法LIST
			        lstMethods.add(arrMethods[i]);
			        
			        // 添加字段名称 到 可SET方法对应字段LIST
			        lstRsFields.add(strMethodName.substring(3, strMethodName.length()));
			    }
			}
		}

		// 如果查询结果正常
		if (CommonConstants.CLDEF_DB_OK == p_rs.getStatus()) {

			// 循环处理查询结果
			for (int i=1; i<p_rs.getRows(); i++) {
			    
			    // 创建返回对象类型
				Object objVal = clsRetObj.newInstance();
				
				// 循环处理可SET方法
				for(int j=0; j<lstMethods.size(); j++){

				    // 取得当前处理方法
					Method method = (Method)lstMethods.get(j);
					
					// 取得查询结果对应值
					Object para = p_rs.getCell((String)lstRsFields.get(j), i);
					
					// 执行当前方法
					method.invoke(objVal, new Object[]{para});
				}
				
				// 添加对象到返回LIST
				lstRet.add(objVal);
			}
		}
		
		// 返回转换结果LIST
		return lstRet;
	}

  	/**
   	* 查询结果集转换.将查询结果集转换成指定类型的对象。
   	* 详细说明 (Add By Ds 2006-07-13)
   	* @param p_rs ResultObj 查询结果集
   	* @param p_strClassName String 指定类型名称（package.class）
   	* @param p_objRet Object 指定返回对象 IN/OUT
   	* @return none
   	* @exception Exception
   	*/
	public void formatRsToObjectSingle(ResultObj p_rs, String p_strClassName, Object p_objRet)
		throws Exception{
		
		// 定义变量
		Class clsRetObj     = Class.forName(p_strClassName);		// 返回LIST对象类型
		Method[] arrMethods = clsRetObj.getDeclaredMethods();		// 对象类型的全部方法
		List lstMethods     = new ArrayList();						// 对象类型的可SET方法LIST
		List lstRsFields    = new ArrayList();						// 对象类型的可SET方法对应字段LIST
		
		// 循环查看每个方法
		for(int i=0; i<arrMethods.length; i++){
		    
		    // 取得当前方法名称
			String strMethodName = arrMethods[i].getName();
			
			// 如果当前方法是可访问的，并且是Setter方法
			//if( arrMethods[i].isAccessible() && "set".equals(strMethodName.substring(0, 3)) ){
			if( "set".equals(strMethodName.substring(0, 3)) ){
			    
			    // 取得方法的参数列表
			    Class[] arrPara = arrMethods[i].getParameterTypes();
			    
			    // 如果方法参数只有一个，并且是String类型的
			    if( arrPara != null && arrPara.length == 1 && arrPara[0] == String.class ){
			        
			        // 添加方法 到 可SET方法LIST
			        lstMethods.add(arrMethods[i]);
			        
			        // 添加字段名称 到 可SET方法对应字段LIST
			        lstRsFields.add(strMethodName.substring(3, strMethodName.length()));
			    }
			}
		}

		// 如果查询结果正常
		if (CommonConstants.CLDEF_DB_OK == p_rs.getStatus()) {

			// 循环处理查询结果
			if( p_rs.getRows() > 0 ) {
			    
				// 循环处理可SET方法
				for(int j=0; j<lstMethods.size(); j++){

				    // 取得当前处理方法
					Method method = (Method)lstMethods.get(j);
					
					// 取得查询结果对应值
					Object para = p_rs.getCell((String)lstRsFields.get(j), 1);
					
					// 执行当前方法
					method.invoke(p_objRet, new Object[]{para});
				}
			}
		}
		
	}
}
