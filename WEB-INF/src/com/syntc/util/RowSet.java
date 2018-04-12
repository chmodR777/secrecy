///////////////////////////////////////////////////////////// 
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
 * CLASS      �� RowSet
 * DESC       :  ��ҳ������
 * VERSION    �� 0.00
 * DATE       �� 2006/07/05
 * AUTHOR     �� jinghuizhen@hotmail.com
 * HISTORY    �� 2006/07/05 0.00 ����
 */
package com.syntc.util;

/**
 * ˵�����Ƚ�ͨ�õ����ݿ��ҳ���ܳ���
 * ע�⣺SQL �����һ���ĸ�ʽҪ��
 *		 ����֧���κ���ʽ��Ƕ�ף�֧�ּ��ϼ���union ��ʹ�ã�
 *		 ����֧��INTERSECT��MINUS�������㡣
 * history:  2003-05-27 NEW by ZL
 *       modified by ZHEN 2004-3-30
 *
 **/

import com.syntc.util.ResultObj;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;

public class RowSet {
  /**���������(���м�¼)*/
  private ResultObj rsObj;

  /**���������(��ǰҳ)*/
  private ResultObj CurPageResultObj;

  /**java.sql.Connection����*/
  protected Connection Conn;

  /**java.sql.ResultSet����*/
  protected ResultSet rs;

  /**�����������ֶ���Ϣ*/
  protected ResultSetMetaData RSMD;

  /**��ҳ��*/
  protected int iPageCount = 0;

  /**��ǰҳ*/
  protected int iCurPage = 0;

  /**ÿҳ��¼��*/
  protected int iPageSize = 0;

  /**��¼��*/
  protected int iRecordCount = 0;

  /**��ѯ�õ�SQL���*/
  protected String sSql = "";

  protected int iRowCount = 0;

  protected boolean bNeedSearch = true;

  private javax.naming.InitialContext ctx = null;
  private javax.sql.DataSource ds = null;

  public RowSet() {
  }

  //�õ����м�¼
  public ResultObj getRsObj() {
    return this.rsObj;
  }

  /**
   * ������ָ���Ĳ�ѯ������ҳ��ȡ��Ӧҳ�����ݿ�
   */
  private ResultObj queryPage(String sql, int pageNo) {
    this.CurPageResultObj = new ResultObj();
    try {
      if (bNeedSearch == true) {
        this.open();
        this.rsObj = this.query(sql);
        this.close();

        //the row of SQL result
        this.iRowCount = this.rsObj.getRows();
        this.iRecordCount = this.iRowCount - 1;

        //get the page Count
        this.iPageCount = (iRecordCount + iPageSize - 1) / iPageSize;

        this.bNeedSearch = false;
      }

      if (pageNo < 1) pageNo = 1;
      if (pageNo > iPageCount) pageNo = iPageCount;
      int lastRow = pageNo * iPageSize;
      if (lastRow > iRecordCount) lastRow = iRecordCount;
      int firstRow = (pageNo - 1) * iPageSize + 1;

      int index = 0;
      if (rsObj.getStatus() > -1) {
        this.CurPageResultObj.add( (String[]) rsObj.get(0));
        index++;
        if (rsObj.getStatus() == 0) {
          for (int i = firstRow; i <= lastRow; i++) {
            this.CurPageResultObj.add( (String[]) rsObj.get(i));
            index++;
          }
        }
      }
      if (index == 0)this.CurPageResultObj.setStatus( -1);
      if (index == 1)this.CurPageResultObj.setStatus(1);
      if (index > 1)this.CurPageResultObj.setStatus(0);
      this.CurPageResultObj.setRows(index);
      this.CurPageResultObj.setCols(rsObj.getCols());
      this.iCurPage = pageNo;
    }
    catch (Exception ex) {
      //System.out.println( ex.toString() );
    }
    return this.CurPageResultObj;
  }

  /*����SQL���*/
  public void setSql(String sSql) {
    if (this.sSql.equals(sSql) == false) {
      this.sSql = sSql;
      this.bNeedSearch = true;
    }
  }

  /**ȡ��ҳ��*/
  public int getPageCount() {
    return this.iPageCount;
  }

  /**ȡ�õ�ǰҳ��*/
  public int getCurPage() {
    return this.iCurPage;
  }

  /**ȡ�õ�һҳ�����*/
  public ResultObj getFirstPage() {
    return queryPage(this.sSql, 1);
  }

  /**ȡ�����һҳ�����*/
  public ResultObj getLastPage() {
    return queryPage(this.sSql, this.iPageCount);
  }

  /**ȡ����һҳ�����*/
  public ResultObj getPrevPage() {
    if (this.iCurPage > 1)
      this.iCurPage = this.iCurPage - 1;
    return queryPage(this.sSql, this.iCurPage);
  }

  /**ȡ����һҳ�����*/
  public ResultObj getNextPage() {
    if (this.iCurPage < this.iPageCount)
      this.iCurPage = this.iCurPage + 1;
    return queryPage(this.sSql, this.iCurPage);
  }

  /*ȡ��ָ��ҳ�����*/
  public ResultObj goPage(int iPageNo) {
    return this.queryPage(this.sSql, iPageNo);
  }

  /*ȡ�ò�ѯ����еļ�¼����*/
  public int getRecordCount() {
    return this.iRecordCount;
  }

  /*����ÿҳ��ʾ��¼��*/
  public void setPageSize(int pagesize) {
    this.iPageSize = pagesize;
  }

  /*ȡ��sql���*/
  public String getSql() {
    return this.sSql;
  }

  /*�ж��Ƿ��ǵ�һҳ*/
  public boolean isFirstPage() {
    if (this.iCurPage <= 1)
      return true;
    else
      return false;
  }

  /*�ж��Ƿ������һҳ*/
  public boolean isLastPage() {
    if (this.iCurPage == this.iPageCount)
      return true;
    else
      return false;
  }

  /**�������²�ѯ*/
  public void setNeedSearch() {
    this.bNeedSearch = true;
  }
  
  protected void open() {
    try {
      // �������ݿ�����
        this.Conn = ConnectionPool.getConnectionPool().getConnection();
        this.Conn.setAutoCommit(false);
    }
    catch (SQLException ex) {
      this.Conn = null;
    }
    catch (Exception ex) {
      this.Conn = null;
    }
  }

  protected ResultObj query(String sql) {

    // ��������
    ResultObj result = new ResultObj();

    if (this.Conn == null) { // ��Ч�����ݿ�����
      result.setStatus( -1);
      return result;
    }

    try {
      // ִ�����ݿ��ѯ����
      result = queryExecute(sql, this.Conn);

      if (result.getRows() > 1) { // ���ݿ���������Ҵ��ڷ��ϲ�ѯ�����ļ�¼
        result.setStatus(0);
      }
      if (result.getRows() == 1) { // ���ݿ����������û�з��ϲ�ѯ�����ļ�¼
        result.setStatus(1);
      }
    }
    catch (SQLException ex) { // ���ݿ����ʧ��
      result.setStatus( -1);
    }
    catch (Exception ex) {
      result.setStatus( -1);
    }

    return result;
  }

  /**
   * ִ�в�ѯ���ݿ����
   *
   * @param sql SQL���
   * @param conn ���ݿ����Ӷ���
   * @return Result����
   * @exception java.sql.SQLException
   */
  //do select
  protected ResultObj queryExecute(String sql, Connection conn) throws
      SQLException {
    ResultObj result = new ResultObj();
    int iRows = 0;
    int iCols = 0;
    Statement stmt = conn.createStatement();
    this.rs = stmt.executeQuery(sql);

    this.RSMD = rs.getMetaData();

    iCols = RSMD.getColumnCount();

    String sArr[] = new String[iCols];
    for (int i = 1; i <= iCols; i++) {
      sArr[i - 1] = RSMD.getColumnLabel(i);
    }
    result.add(sArr);
    iRows++;

    while (rs.next()) {
      sArr = new String[iCols];
      for (int i = 1; i <= iCols; i++) {
        sArr[i - 1] = Helper(rs, RSMD.getColumnType(i), i);
      }
      result.add(sArr);
      iRows++;
    }

    result.setCols(iCols);
    result.setRows(iRows);

    rs.close();
    stmt.close();

    return result;
  }

  public boolean isNumberCol(int col) {
    boolean isNumber = false;
    int dataType;
    try {
      dataType = this.RSMD.getColumnType(col + 1);
    }
    catch (SQLException ex) {
      return false;
    }
    catch (Exception ex) {
      return false;
    }
    switch (dataType) {
      case Types.NUMERIC:
      case Types.DECIMAL:
        isNumber = true;
        break;
      case Types.TINYINT:

        //byte tinyint = rs.getByte(col);
        //intObj = new Integer(tinyint);
        //retValue = intObj.toString();
        //isNumber = true;
        break;
      case Types.SMALLINT:
        isNumber = true;
        break;
      case Types.INTEGER:
        isNumber = true;
        break;
      case Types.BIGINT:
        isNumber = true;
        break;
      case Types.REAL:
        isNumber = true;
        break;
      case Types.FLOAT:
      case Types.DOUBLE:
        isNumber = true;
        break;
    }
    return isNumber;
  }

  /**
   * �õ���ǰҳ���м�¼ָ���еĻ��ܽ��
   * ������в������֣����ܽ��Ϊ��0��
   * @param col
   * @return
   */
  public BigDecimal getCurPageSum(int col) {
    BigDecimal bigDecimal = new BigDecimal("0");
    if (this.CurPageResultObj != null && this.CurPageResultObj.getStatus() == 0) {
      String sTmp = "0";
      for (int i = 1; i < this.CurPageResultObj.getRows(); i++) {
        try {
          sTmp = this.CurPageResultObj.getCell(col, i).trim();
          bigDecimal = bigDecimal.add(new BigDecimal(sTmp));
        }
        catch (NumberFormatException ex) {
          //���ָ�ʽ����
        }
        catch (Exception ex) {
          //δ֪�쳣
        }
      }
    }
    return bigDecimal;
  }

  /**
   * �õ����м�¼ָ���еĻ��ܽ��
   * ������в������֣����ܽ��Ϊ��0��
   * @param col
   * @return
   */
  public BigDecimal getSum(int col) {
    BigDecimal bigDecimal = new BigDecimal("0");
    if (rsObj != null && rsObj.getStatus() == 0) {
      String sTmp = "0";
      for (int i = 1; i < rsObj.getRows(); i++) {
        try {
          sTmp = rsObj.getCell(col, i).trim();
          bigDecimal = bigDecimal.add(new BigDecimal(sTmp));
        }
        catch (NumberFormatException ex) {
        }
        catch (Exception ex) {
        }
      }
    }
    return bigDecimal;
  }

  /**�õ�int���͵Ļ���*/
  public int getIntSum(int col) {
    return this.getSum(col).intValue();
  }

  /**�õ�long���͵Ļ���*/
  public long getLongSum(int col) {
    return this.getSum(col).longValue();
  }

  /**�õ�float���͵Ļ���*/
  public float getFloatSum(int col) {
    return this.getSum(col).floatValue();
  }

  /**�õ�double���͵Ļ���*/
  public double getDoubleSum(int col) {
    return this.getSum(col).doubleValue();
  }

  protected String Helper(ResultSet rs, int dataType, int col) throws
      SQLException {
    String retValue = null;
    Integer intObj;
    // ask for data depending on the datatype
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

  protected void close() {
    try {
      // �ر����ݿ�����
        ConnectionPool.getConnectionPool().free(this.Conn);
    }
    catch (Exception ex) {
      this.Conn = null;
    }

    return;
  }
}
