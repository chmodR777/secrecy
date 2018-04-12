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
 * CLASS      �� DBOperate
 * DESC       :  ���ݿ����������
 * VERSION    �� 0.00
 * DATE       �� 2006/07/05
 * AUTHOR     �� jinghuizhen@hotmail.com
 * HISTORY    �� 2006/07/05 0.00 ����
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
   * ���ݿ����Ӷ���
   */
  private int rows;
  private int cols;
  private String strMsg = ""; //������Ϣ
  private Connection Con = null;
  private Vector v_SQL = null;

  /**
   * ���������ݿ����ʱִ��SQL������
   */
  private int iSqlLineNo = 0;
  private boolean PRIN_CHEK = true; //true :��ӡ false :����ӡ

/**
 * ���õ��Դ�����Ϣ
 * ��ϸ˵��
 * @param ������Ϣ
 * @return void
 * @exception NONE
 */
  public void setDebugMsg(String p_str_Msg) {
    strMsg = p_str_Msg;
  }

/**
 * ȡ�õ��Դ�����Ϣ
 * ��ϸ˵��
 * @param void
 * @return ȡ�ô���ĵ�����Ϣ
 * @exception NONE
 */
  public String getDebugMsg() {
    return this.strMsg;
  }

  public DBOperate() {

  }

/**
 * �ڿ���̨���������Ϣ,�����ǰ�ǿ��Խ��е��Ե�״̬
 * ��ϸ˵��
 * @param void
 * @return void
 * @exception NONE
 */
  private void DebugMsg(String strMsg) {
    if (PRIN_CHEK) {
      System.out.println(
          "----------- ���ݿ������Ϣ -----------");
      System.out.println(strMsg);

      int i_size = this.v_SQL.size();
      for (int i = 0; i < i_size; i++) {
        System.out.println( (String) v_SQL.get(i));
      }

      System.out.println("----------- ������Ϣ���� -----------");
    }
  }


/**
 * �������ݿ����� �����ͨ�� WEBSPHERE ���е����ݿ������޸����λ�ü���.
 * ��ϸ˵��
 * @param void
 * @return void
 * @exception NONE
 */
  private void myOpen() {
    try {

        // �������ݿ�����
        this.Con = ConnectionPool.getConnectionPool().getConnection();

        // ��ֹ�Զ��ύ
        this.Con.setAutoCommit(false);

        if (this.Con == null) {
          System.out.println("ȡ������ʧ��! myOpen");
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
 * ���ݿ��ѯ.���ؼ�¼��
 * ��ϸ˵��
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
	  // ���ݿ����ʧ��
      this.DebugMsg("getMaxRecord is error: " + ex.toString());

    }
    finally {
      this.myClose();
      return max;
    }

  }

/**
 * ���ݿ��ѯ.���ݿ��ѯ,���ݴ��ݲ����������ݿ��ѯ������
 * ��ϸ˵��
 * @param stSql String SQL��ѯ��� IN
 * @return ResultObj ȡ�õĲ�ѯ���
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
      // ִ�����ݿ��ѯ����
      obResult = queryExecute(stSql, this.Con);

      this.myClose();
      if (obResult.getRows() > 1) { 
		// ���ݿ���������Ҵ��ڷ��ϲ�ѯ�����ļ�¼
        obResult.setStatus(0);
      }
      if (obResult.getRows() == 1) {
		// ���ݿ����������û�з��ϲ�ѯ�����ļ�¼
        obResult.setStatus(1);
      }
    }
    catch (SQLException ex) { 
	  // ���ݿ����ʧ��
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
 * ִ�в�ѯ���ݿ����
 * ��ϸ˵��
 * @param sql SQL���
 * @param con ���ݿ����Ӷ���
 * @return Result����
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
      System.out.println("����SQL  �� " + sql);
    }
    finally {
      try {
        stmt.close();
      }
      catch (SQLException e) {
        System.out.println("�α�ر�ʧ�� �� " + e.getMessage());
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
 * ִ�����ݿ�ĸ��²���
 * ��ϸ˵��
 * @param sql SQL���
 * @param con ���ݿ����Ӷ���
 * @exception java.sql.SQLException
 */
  private void Update(String sql, Connection con) throws SQLException {

    try{
        System.out.println("**********************************************");
        System.out.println("ִ��SQL " + sql);
        System.out.println("**********************************************");
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
    }
    catch(SQLException e){

        System.out.println("**********************************************");
        System.out.println("����SQL " + sql);
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

  //���ô洢���� j: ΪҪ����Ĳ��� ��j=0 �Ǵ���û����в���
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
        // �ر����ݿ�����
        ConnectionPool.getConnectionPool().free(this.Con); // �ر����ݿ�����
    }
    catch (Exception ex) {
      this.Con = null;
    }
  }

  public void Close() {
	  //EMPTY
  }

/**
 * ���ݿ����������,���������ݿ������ȫ���ɹ����ύ��������������״̬��
 * ��ϸ˵��
 *  ���� 0��ȫ����������������������ȷ�ύ����һ�㣩<br>
 *  ����-1��δ�ܽ�����ȷ�����ݿ����ӡ���������<br>
 *  ����-2���������е�һ������δ��������������ż����<br>
 *  ����-3��δ����ȷִ�л��˲��������ǳ�������<br>
 *  ����-4��δ����ȷִ���ύ���������ǳ�������<br>
 *
 * @param Vector vSql SQL��伯�� IN<br>
 *
 * @return int ������<br>
 */
  public int doTransaction(Vector vSqls) {
    this.myOpen();
    // ��������
    int iSize;

    if (this.Con == null) { // ��Ч�����ݿ�����
      return ( -1);
    }

    try {
      // ���������ݿ����
      iSize = vSqls.size();
      for (this.iSqlLineNo = 0; this.iSqlLineNo < iSize; this.iSqlLineNo++) {
        Update( (String) vSqls.get(this.iSqlLineNo), this.Con);

      }
    }
    catch (SQLException ex) { // ���ݿ����ʧ��
      this.setSQL(vSqls);
      
      try {
        this.Con.rollback(); // ����
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
    catch (Exception ex) { // ϵͳ�쳣�����޷��������ݿ����
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
    finally { // �������ݿ��������������
      try {
        this.Con.commit();
        this.myClose(); // �ύ
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
   * ִ��DDL����
   * ��ϸ˵��
   *  ���� ִ�����ݿ�DDL����
   *
   * @param DDL SQL<br>
   * @return boolean ������<br>
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
   * ����ִ�е�sql���
   */
  private void setSQL(String sql) {
    if (this.v_SQL == null) {
      this.v_SQL = new Vector();
    }
    this.v_SQL.add(sql);
  }

  /**
   * ����ִ�е�sql���
   */
  private void setSQL(Vector sql) {
    if (this.v_SQL == null) {
      this.v_SQL = new Vector();
    }
    this.v_SQL = sql;
  }

  	/**
   	* ���ݿ��ѯ.���ݿ��ѯ,���ݴ��ݲ����������ݿ��ѯ����������ָ������LIST��
   	* ��ϸ˵�� (Add By Ds 2006-07-13)
   	* @param p_strSQL String SQL��ѯ���
   	* @param p_strSQL String ָ������LIST��������
   	* @return List ָ�������LIST
   	* @exception Exception
   	*/
	public List query(String p_strSQL, String p_strClassName)
		throws Exception
	{
	    // ���巵�ر���
	    List lstRet = new ArrayList();
	    
	    // ִ�в�ѯ
	    ResultObj rs_Rslt = this.Query(p_strSQL);
	    
	    // �����ѯ�ɹ�
	    if (CommonConstants.CLDEF_DB_OK == rs_Rslt.getStatus()) {
	    
	        // ת��ResultObj����������List
	        lstRet = this.formatRsToObjectList(rs_Rslt, p_strClassName);
	        
	    // �����ѯʧ��
	    }else{
	        
	        // ����LOG����
	        CommonLog log = new CommonLog();
	        
	        // дLOG
	    	log.writeTrace( 
	    	        CommonConstants.CLDEF_LOG_TYPE_INFO,
		    		"com.syntc.util.DBOperate",
		    		"QUERY(" + p_strClassName + ")",
		    		"NG. SQL = " + p_strSQL );
	    }
	    
	    // ���ز�ѯ���
	    return lstRet;
	}

  	/**
   	* ���ݿ��ѯ.���ݿ��ѯ,���ݴ��ݲ����������ݿ��ѯ��������ѯ������õ�ָ������
   	* ��ϸ˵�� (Add By Ds 2006-07-13)
   	* @param p_strSQL String SQL��ѯ���
   	* @param p_strSQL String ָ������LIST��������
   	* @param p_objRet Object ָ�����ض��� IN/OUT
   	* @return none
   	* @exception Exception
   	*/
	public void query(String p_strSQL, String p_strClassName, Object p_objRet)
		throws Exception
	{
	    // ִ�в�ѯ
	    ResultObj rs_Rslt = this.Query(p_strSQL);
	    
	    // �����ѯ�ɹ�
	    if (CommonConstants.CLDEF_DB_OK == rs_Rslt.getStatus()) {
	    
	        // ת��ResultObj����������List
	        this.formatRsToObjectSingle(rs_Rslt, p_strClassName, p_objRet);
	        
	    // �����ѯʧ��
	    }else{
	        
	        // ����LOG����
	        CommonLog log = new CommonLog();
	        
	        // дLOG
	    	log.writeTrace( 
	    	        CommonConstants.CLDEF_LOG_TYPE_INFO,
		    		"com.syntc.util.DBOperate",
		    		"QUERY(" + p_strClassName + ")",
		    		"NG. SQL = " + p_strSQL );
	    }
	}

  	/**
   	* ��ѯ�����ת��.����ѯ�����ת����ָ�����͵Ķ���LIST��
   	* ��ϸ˵�� (Add By Ds 2006-07-13)
   	* @param p_rs ResultObj ��ѯ�����
   	* @param p_strClassName String ָ���������ƣ�package.class��
   	* @return List ָ�������LIST
   	* @exception Exception
   	*/
	public List formatRsToObjectList(ResultObj p_rs, String p_strClassName)
		throws Exception{
		
	    // ���巵��ֵ
		List lstRet = new ArrayList();
		
		// �������
		Class clsRetObj     = Class.forName(p_strClassName);		// ����LIST��������
		Method[] arrMethods = clsRetObj.getDeclaredMethods();		// �������͵�ȫ������
		List lstMethods     = new ArrayList();						// �������͵Ŀ�SET����LIST
		List lstRsFields    = new ArrayList();						// �������͵Ŀ�SET������Ӧ�ֶ�LIST
		
		// ѭ���鿴ÿ������
		for(int i=0; i<arrMethods.length; i++){
		    
		    // ȡ�õ�ǰ��������
			String strMethodName = arrMethods[i].getName();

			// �����ǰ�����ǿɷ��ʵģ�������Setter����
			//if( arrMethods[i].isAccessible() && "set".equals(strMethodName.substring(0, 3)) ){
			if( "set".equals(strMethodName.substring(0, 3)) ){

			    // ȡ�÷����Ĳ����б�
			    Class[] arrPara = arrMethods[i].getParameterTypes();
			    
			    // �����������ֻ��һ����������String���͵�
			    if( arrPara != null && arrPara.length == 1 && arrPara[0] == String.class ){

			        // ��ӷ��� �� ��SET����LIST
			        lstMethods.add(arrMethods[i]);
			        
			        // ����ֶ����� �� ��SET������Ӧ�ֶ�LIST
			        lstRsFields.add(strMethodName.substring(3, strMethodName.length()));
			    }
			}
		}

		// �����ѯ�������
		if (CommonConstants.CLDEF_DB_OK == p_rs.getStatus()) {

			// ѭ�������ѯ���
			for (int i=1; i<p_rs.getRows(); i++) {
			    
			    // �������ض�������
				Object objVal = clsRetObj.newInstance();
				
				// ѭ�������SET����
				for(int j=0; j<lstMethods.size(); j++){

				    // ȡ�õ�ǰ������
					Method method = (Method)lstMethods.get(j);
					
					// ȡ�ò�ѯ�����Ӧֵ
					Object para = p_rs.getCell((String)lstRsFields.get(j), i);
					
					// ִ�е�ǰ����
					method.invoke(objVal, new Object[]{para});
				}
				
				// ��Ӷ��󵽷���LIST
				lstRet.add(objVal);
			}
		}
		
		// ����ת�����LIST
		return lstRet;
	}

  	/**
   	* ��ѯ�����ת��.����ѯ�����ת����ָ�����͵Ķ���
   	* ��ϸ˵�� (Add By Ds 2006-07-13)
   	* @param p_rs ResultObj ��ѯ�����
   	* @param p_strClassName String ָ���������ƣ�package.class��
   	* @param p_objRet Object ָ�����ض��� IN/OUT
   	* @return none
   	* @exception Exception
   	*/
	public void formatRsToObjectSingle(ResultObj p_rs, String p_strClassName, Object p_objRet)
		throws Exception{
		
		// �������
		Class clsRetObj     = Class.forName(p_strClassName);		// ����LIST��������
		Method[] arrMethods = clsRetObj.getDeclaredMethods();		// �������͵�ȫ������
		List lstMethods     = new ArrayList();						// �������͵Ŀ�SET����LIST
		List lstRsFields    = new ArrayList();						// �������͵Ŀ�SET������Ӧ�ֶ�LIST
		
		// ѭ���鿴ÿ������
		for(int i=0; i<arrMethods.length; i++){
		    
		    // ȡ�õ�ǰ��������
			String strMethodName = arrMethods[i].getName();
			
			// �����ǰ�����ǿɷ��ʵģ�������Setter����
			//if( arrMethods[i].isAccessible() && "set".equals(strMethodName.substring(0, 3)) ){
			if( "set".equals(strMethodName.substring(0, 3)) ){
			    
			    // ȡ�÷����Ĳ����б�
			    Class[] arrPara = arrMethods[i].getParameterTypes();
			    
			    // �����������ֻ��һ����������String���͵�
			    if( arrPara != null && arrPara.length == 1 && arrPara[0] == String.class ){
			        
			        // ��ӷ��� �� ��SET����LIST
			        lstMethods.add(arrMethods[i]);
			        
			        // ����ֶ����� �� ��SET������Ӧ�ֶ�LIST
			        lstRsFields.add(strMethodName.substring(3, strMethodName.length()));
			    }
			}
		}

		// �����ѯ�������
		if (CommonConstants.CLDEF_DB_OK == p_rs.getStatus()) {

			// ѭ�������ѯ���
			if( p_rs.getRows() > 0 ) {
			    
				// ѭ�������SET����
				for(int j=0; j<lstMethods.size(); j++){

				    // ȡ�õ�ǰ������
					Method method = (Method)lstMethods.get(j);
					
					// ȡ�ò�ѯ�����Ӧֵ
					Object para = p_rs.getCell((String)lstRsFields.get(j), 1);
					
					// ִ�е�ǰ����
					method.invoke(p_objRet, new Object[]{para});
				}
			}
		}
		
	}
}
