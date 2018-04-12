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
 * CLASS      ： RowSet
 * DESC       :  分页处理类
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */
package com.syntc.util;

/**
 * 说明：比较通用的数据库分页汇总程序；
 * 注意：SQL 语句有一定的格式要求，
 *		 除了支持任何形式的嵌套，支持集合计算union 的使用，
 *		 但不支持INTERSECT，MINUS集合运算。
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
  /**结果集对象(所有记录)*/
  private ResultObj rsObj;

  /**结果集对象(当前页)*/
  private ResultObj CurPageResultObj;

  /**java.sql.Connection对象*/
  protected Connection Conn;

  /**java.sql.ResultSet对象*/
  protected ResultSet rs;

  /**结果集对象的字段信息*/
  protected ResultSetMetaData RSMD;

  /**总页数*/
  protected int iPageCount = 0;

  /**当前页*/
  protected int iCurPage = 0;

  /**每页记录数*/
  protected int iPageSize = 0;

  /**记录数*/
  protected int iRecordCount = 0;

  /**查询用的SQL语句*/
  protected String sSql = "";

  protected int iRowCount = 0;

  protected boolean bNeedSearch = true;

  private javax.naming.InitialContext ctx = null;
  private javax.sql.DataSource ds = null;

  public RowSet() {
  }

  //得到所有记录
  public ResultObj getRsObj() {
    return this.rsObj;
  }

  /**
   * 根据所指定的查询条件和页号取相应页的数据库
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

  /*设置SQL语句*/
  public void setSql(String sSql) {
    if (this.sSql.equals(sSql) == false) {
      this.sSql = sSql;
      this.bNeedSearch = true;
    }
  }

  /**取得页数*/
  public int getPageCount() {
    return this.iPageCount;
  }

  /**取得当前页号*/
  public int getCurPage() {
    return this.iCurPage;
  }

  /**取得第一页结果集*/
  public ResultObj getFirstPage() {
    return queryPage(this.sSql, 1);
  }

  /**取得最后一页结果集*/
  public ResultObj getLastPage() {
    return queryPage(this.sSql, this.iPageCount);
  }

  /**取得上一页结果集*/
  public ResultObj getPrevPage() {
    if (this.iCurPage > 1)
      this.iCurPage = this.iCurPage - 1;
    return queryPage(this.sSql, this.iCurPage);
  }

  /**取得下一页结果集*/
  public ResultObj getNextPage() {
    if (this.iCurPage < this.iPageCount)
      this.iCurPage = this.iCurPage + 1;
    return queryPage(this.sSql, this.iCurPage);
  }

  /*取得指定页结果集*/
  public ResultObj goPage(int iPageNo) {
    return this.queryPage(this.sSql, iPageNo);
  }

  /*取得查询结果中的记录个数*/
  public int getRecordCount() {
    return this.iRecordCount;
  }

  /*设置每页显示记录数*/
  public void setPageSize(int pagesize) {
    this.iPageSize = pagesize;
  }

  /*取得sql语句*/
  public String getSql() {
    return this.sSql;
  }

  /*判断是否是第一页*/
  public boolean isFirstPage() {
    if (this.iCurPage <= 1)
      return true;
    else
      return false;
  }

  /*判断是否是最后一页*/
  public boolean isLastPage() {
    if (this.iCurPage == this.iPageCount)
      return true;
    else
      return false;
  }

  /**设置重新查询*/
  public void setNeedSearch() {
    this.bNeedSearch = true;
  }
  
  protected void open() {
    try {
      // 建立数据库连接
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

    // 变量定义
    ResultObj result = new ResultObj();

    if (this.Conn == null) { // 无效的数据库连接
      result.setStatus( -1);
      return result;
    }

    try {
      // 执行数据库查询操作
      result = queryExecute(sql, this.Conn);

      if (result.getRows() > 1) { // 数据库操作正常且存在符合查询条件的记录
        result.setStatus(0);
      }
      if (result.getRows() == 1) { // 数据库操作正常但没有符合查询条件的记录
        result.setStatus(1);
      }
    }
    catch (SQLException ex) { // 数据库操作失败
      result.setStatus( -1);
    }
    catch (Exception ex) {
      result.setStatus( -1);
    }

    return result;
  }

  /**
   * 执行查询数据库操作
   *
   * @param sql SQL语句
   * @param conn 数据库连接对象
   * @return Result对象
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
   * 得到当前页所有记录指定列的汇总结果
   * 如果此列不是数字，汇总结果为“0”
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
          //数字格式错误
        }
        catch (Exception ex) {
          //未知异常
        }
      }
    }
    return bigDecimal;
  }

  /**
   * 得到所有记录指定列的汇总结果
   * 如果此列不是数字，汇总结果为“0”
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

  /**得到int类型的汇总*/
  public int getIntSum(int col) {
    return this.getSum(col).intValue();
  }

  /**得到long类型的汇总*/
  public long getLongSum(int col) {
    return this.getSum(col).longValue();
  }

  /**得到float类型的汇总*/
  public float getFloatSum(int col) {
    return this.getSum(col).floatValue();
  }

  /**得到double类型的汇总*/
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
      // 关闭数据库连接
        ConnectionPool.getConnectionPool().free(this.Conn);
    }
    catch (Exception ex) {
      this.Conn = null;
    }

    return;
  }
}
