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
 * CLASS      ： Common
 * VERSION    ： 0.00
 * DESC       : OPAL 系统共同部品 BEAN
 * DATE       ： 2006/07/07
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/07 0.00 作成
 */
package com.syntc.common.bean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.constants.CommonConstants;
import com.syntc.util.DBOperate;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class Common {
	private String str_SelectOption = "<OPTION VALUE = ''>-- 请选择 --</OPTION>";

	/**
	 * 详细说明 对数值进行格式化输出
	 * 
	 * @param 字符串类型数值
	 * @return String 格式化后的数值
	 * @exception none
	 */
	public String getFormatNumber(String p_strNumber) {
		String strRtn = "";
		DecimalFormat df = new DecimalFormat("###,##0.00");
		double RtnNumber = 0.0000;

		if (p_strNumber.equals(""))
			strRtn = "0.0000";
		else {
			RtnNumber = Double.parseDouble(p_strNumber);
			strRtn = df.format(RtnNumber + 0.0000001);
		}

		return strRtn;
	}

	/**
	 * 详细说明 对数值进行格式化输出
	 * 
	 * @param DOUBLE
	 *            类型数值
	 * @return String 格式化后的数值
	 * @exception none
	 */
	public String getFormatNumber(double p_d_Number) {
		String strRtn = "";
		DecimalFormat df = new DecimalFormat("###,##0.00");
		strRtn = df.format(p_d_Number + 0.0000001);
		return strRtn;
	}

	/**
	 * 详细说明 根据SQL语句取得返回值,将简单查询时都使用数据库查询进行抽象化
	 * 
	 * @param SQL语句
	 * @return String 查询结果.如果查询失败返回 ""
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public String getViewByID(String p_strSQL) {
		String str_SQL;
		String str_nameView = "";

		ResultObj res = new ResultObj();
		DBOperate dboperate = new DBOperate();
		str_SQL = p_strSQL;

		dboperate.Open();
		res = dboperate.Query(str_SQL);
		dboperate.Close();

		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			if (res.getRows() > 1) {
				str_nameView = res.getCell(0, 1);
			}
		}

		return str_nameView;
	}

	/**
	 * 详细说明 取得数据库服务器时间
	 * 
	 * @param none
	 * @return String 当前数据库服务器时间 格式为 yyyymmddhh24miss
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public String getServerDateTime() {
		String str_ColumName = "";
		String str_SQL;

		str_SQL = "select to_char(sysdate,'yyyymmddhh24miss') as Today" + "  from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "00000000000000";
		}

		return str_ColumName;
	}

	/**
	 * 详细说明 取得数据库服务器时间
	 * 
	 * @param none
	 * @return String 当前数据库服务器时间 格式为 YYYYMMDD
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public String getServerDate() {
		String str_ColumName = "";
		String str_SQL;

		str_SQL = "select to_char(sysdate,'yyyy-mm-dd') as Today" + "  from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/**
	 * 详细说明 取得日期格式的字符串的年
	 * 
	 * @param 年月字符串必须符合ORACLE
	 *            日期格式 YYYY-MM-DD
	 * @return int 当前数据库服务器时间 格式为 YYYY
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public int getYearOfDate(String p_str_Date) {
		String str_ColumName = "";
		String str_SQL;

		str_SQL = " select to_char(to_date('" + p_str_Date + "','yyyy-mm-dd'),'yyyy') as result" + "   from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900";
		}

		return Integer.parseInt(str_ColumName);
	}

	/**
	 * 详细说明 取得日期格式的字符串的月
	 * 
	 * @param 年月字符串必须符合ORACLE
	 *            日期格式 YYYY-MM-DD
	 * @return int 当前数据库服务器时间 格式为 MM
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public int getMonthOfDate(String p_str_Date) {
		String str_ColumName = "";
		String str_SQL;

		str_SQL = " select to_char(to_date('" + p_str_Date + "','yyyy-mm-dd'),'mm') as result " + "   from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "00";
		}

		return Integer.parseInt(str_ColumName);
	}

	/**
	 * 详细说明 取得日期格式的字符串的日
	 * 
	 * @param none
	 * @return int 年月字符串必须符合ORACLE 日期格式 YYYY-MM-DD
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public int getDayOfDate(String p_str_Date) {
		String str_ColumName = "";
		String str_SQL;

		str_SQL = " select to_char(to_date('" + p_str_Date + "','yyyy-mm-dd'),'dd') as result " + "   from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "00";
		}

		return Integer.parseInt(str_ColumName);
	}

	/**
	 * 详细说明 根据接收的SQL语句，产生一个<option></option> 列表的字符串<br>
	 * 要求：第一个字段为id值，第2个为显示名(Label)<br>
	 * SELECT col_value,col_name FROM tbl_fund_info 系统将col_value 作为列表得 VALUE,将
	 * col_name 做为类表得显示内容
	 * 
	 * @param String
	 *            类型SQL语句, 默认选择的项
	 * @return 下拉的OPTION HTML代码
	 * @exception none
	 * @author jinghuizhen@hotmail.com
	 * @since 2006-07-07
	 */
	public String getSortOptionList(String p_str_SQL, String p_str_Select) {
		if (p_str_SQL == null || p_str_SQL.equals("")) {
			return new String("");
		}
		if (p_str_Select == null) {
			p_str_Select = "";
		}
		StringBuffer sb_HTML = new StringBuffer();
		DBOperate conn = new DBOperate(); // 数据库连接
		ResultObj res = new ResultObj(); // 记录集

		// 连接数据库
		conn.Open();

		// 执行查询语句
		res = conn.Query(p_str_SQL);

		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			String str_value = null;
			String str_lable = null;
			sb_HTML = new StringBuffer();

			// ///////////////////////////////////////////////////////////////////
			// 根据SQL 语句从数据库中取得数据的值和对应的内容,并且生成
			// 下拉列表的内容.
			for (int i = 1; i < res.getRows(); i++) {
				str_value = res.getCell(0, i);
				str_lable = res.getCell(1, i);
				sb_HTML.append("<option value='" + str_value + "'");
				if ((!p_str_Select.equals("") && str_value != null && str_value.equals(p_str_Select))) {
					sb_HTML.append(" selected ");
				}
				sb_HTML.append(">");
				sb_HTML.append(str_lable);
				sb_HTML.append("</option>");
			}

		} else if (CommonConstants.CLDEF_DB_OK != res.getStatus()) {
			sb_HTML = new StringBuffer();
		}

		conn.Close();

		return sb_HTML.toString();
	}

	/**
	 * <br>
	 * ［功 能］ 设置汉字的参数<br>
	 * ［说 明］ 解决传递参数时汉字乱码的问题<br>
	 * ［参 数］ 转换的汉字<br>
	 * ［返 回］ 传递的汉字字符串 <br>
	 * ［更新履历］ 2005/08/27 甄景辉<br>
	 * 
	 */
	public String getRequestData(HttpServletRequest request, String strPass) {
		String str_Rtn = ""; // 返回值
		str_Rtn = request.getParameter(strPass);
		if (str_Rtn == null) {
			str_Rtn = "";
		} else {
			try {
				str_Rtn = new String(str_Rtn.getBytes("8859_1"), "UTF-8");
			} catch (Exception e) {
				System.out.println("getRequestData Error " + e.toString());
			}
		} // end if(str_Rtn == null )
		return str_Rtn;
	} // Function getRequestData end

	/**
	 * <br>
	 * [功 能] 解析字符串<br>
	 * [说 明] 解析以％u开头的字符串<br>
	 * [参 数] 待转的字符串<br>
	 * [返 回] 中文字符串<br>
	 * [更新履历] 2006/8/2 zhangqiang<br>
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		// 保证缓冲区的容量至少等于指定的最小数
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			// 在指定索引处开始查找，返回在该字符串中指定子字符串第一次出现处的索引
			pos = src.indexOf("%", lastPos);
			// ％出现在第一个字符
			if (pos == lastPos) {
				// 返回指定索引处的字符
				if (src.charAt(pos + 1) == 'u') {
					// 取子串转为16进制数
					ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * <br>
	 * [功 能] 将unicode编码转为字符串<br>
	 * [说 明] unicode －》正常中文<br>
	 * [参 数] 待转的字符串<br>
	 * [返 回] 中文字符串<br>
	 * [更新履历] 2006/8/2 zhangqiang<br>
	 */
	public static String unicode2Chr(String str) {
		if (str != null && !"".equals(str) && !"null".equals(str)) {
			String st = "";
			String t = "";
			int i = 0;
			for (i = 1; i <= str.length() / 4; i++) {
				t = str.substring(4 * i - 4, 4 * i - 2);
				t = str.substring(4 * i - 2, 4 * i).concat(t);
				st = st.concat("%u").concat(t);
			}
			st = unescape(st);
			return (st);
		} else
			return ("");
	}

	/**
	 * 详细说明 根据接收的SQL语句，产生一个..<br>.. 列表显示的字符串<br>
	 * 
	 * @param String
	 *            类型SQL语句, 默认选择的项
	 * @return 页面
	 *         <td>的HTML代码
	 * @exception none
	 * @author lizhonghua@syntc.com.cn
	 * @since 2006-09-18
	 */
	public String getShowList(String p_str_SQL) {
		if (p_str_SQL == null || p_str_SQL.equals("")) {
			return new String("");
		}

		StringBuffer sb_HTML = new StringBuffer();
		DBOperate conn = new DBOperate(); // 数据库连接
		ResultObj res = new ResultObj(); // 记录集

		// 连接数据库
		conn.Open();

		// 执行查询语句
		res = conn.Query(p_str_SQL);

		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			String str_value = null;

			sb_HTML = new StringBuffer();
			// ///////////////////////////////////////////////////////////////////
			// 根据SQL 语句从数据库中取得数据的值和对应的内容,并且生成
			// 页面显示HTML.
			for (int i = 1; i < res.getRows(); i++) {
				str_value = res.getCell(0, i);

				sb_HTML.append(str_value);
				if (i != res.getRows() - 1) {

					sb_HTML.append("<br>");
				}
			}

		} else if (CommonConstants.CLDEF_DB_OK != res.getStatus()) {
			sb_HTML = new StringBuffer();
		}

		conn.Close();

		return sb_HTML.toString();
	}

	/*
	 * 取得下周的星期一(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周一
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getMonDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " - 6 + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = " - 1 + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = " - 2 + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = " - 3 + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = " - 4 + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " - 5 + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/*
	 * 取得下周的星期二(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周二
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getTuesDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " - 5 + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 1 + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = "  + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = " - 1 + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = " - 2 + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = " - 3 + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " - 4 + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/*
	 * 取得下周的星期三(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周三
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getWednesDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " - 4 + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 2 + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = " + 1 + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = "  + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = " - 1 + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = " - 2 + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " - 3 + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/*
	 * 取得下周的星期四(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周四
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getThursDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " - 3 + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 3 + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = " + 2 + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = " + 1 + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = "  + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = " - 1 + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " - 2 + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/*
	 * 取得下周的星期五(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周五
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getFriDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " - 2 + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 4 + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = " + 3 + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = " + 2 + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = " + 1 + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = "  + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " - 1 + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/*
	 * 取得下周的星期六(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周六
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getSaturDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " - 1 + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 5 + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = " + 4 + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = " + 3 + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = " + 2 + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = " + 1 + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/*
	 * 取得下周的星期日(去掉＋7 则为当前周的星期几) 格式 @parm 星期几 @return String yyyy-mm-dd 格式的周日
	 * 
	 * java.util.Calendar
	 * 
	 * public static final int SUNDAY 1 public static final int MONDAY 2 public
	 * static final int TUESDAY 3 public static final int WEDNESDAY 4 public
	 * static final int THURSDAY 5 public static final int FRIDAY 6 public
	 * static final int SATURDAY 7
	 */
	public String getSunDayOfDate(String str_CurrentDay, int i_DayOfWeek) {
		String str_ColumName = "";
		String str_SQL;
		String str_CalculateSQL = "";

		switch (i_DayOfWeek) {
		case 1: {
			str_CalculateSQL = " + 7";
			break;
		}
		case 2: {
			str_CalculateSQL = " + 6 + 7";
			break;
		}
		case 3: {
			str_CalculateSQL = " + 5 + 7";
			break;
		}
		case 4: {
			str_CalculateSQL = " + 4 + 7";
			break;
		}
		case 5: {
			str_CalculateSQL = " + 3 + 7";
			break;
		}
		case 6: {
			str_CalculateSQL = " + 2 + 7";
			break;
		}
		case 7: {
			str_CalculateSQL = " + 1 + 7";
			break;
		}
		}

		str_SQL = "select to_char(to_date('" + str_CurrentDay + "','yyyy-mm-dd') " + str_CalculateSQL
				+ ",'yyyy-mm-dd') as result from dual";

		str_ColumName = this.getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01";
		}

		return str_ColumName;
	}

	/**
	 * 
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 * 
	 * @param s
	 *            原文件名
	 * 
	 * @return 重新编码后的文件名
	 * 
	 */

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0){
						k += 256;
					}
					sb.append("%" + Integer.toHexString(k).
					toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * [功能描述]文件下载 [参 数]filePath 文件路径 [参 数]response HttpServletResponse [参
	 * 数]isOnLine 是否在线打开 [返 回]无 [更新履历]2006/10/25 lizhonghua<br>
	 */
	public void downLoad(String filePath, String fileNameShow, HttpServletResponse response, boolean isOnLine)
			throws Exception {

		// fileNameShow = new String(fileNameShow.getBytes("8859_1"), "UTF-8");
		fileNameShow = toUtf8String(fileNameShow); 
		File f = new File(filePath);
		if (!f.exists()) {
			response.sendError(404, "File not found!");
			return;
		}

		BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));

		byte[] buf = new byte[1024];
		int len = 0;

		response.reset(); // 非常重要
		if (isOnLine) { // 在线打开方式
			URL u = new URL("file:///" + filePath);
			response.setContentType(u.openConnection().getContentType());
			response.setHeader("Content-Disposition", "inline; filename=" + fileNameShow);
			// 文件名应该编码成UTF-8
		} else { // 纯下载方式
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileNameShow);
		}
		OutputStream out = response.getOutputStream();
		while ((len = br.read(buf)) > 0)
			out.write(buf, 0, len);
		br.close();
		out.close();
	}

	/**
	 * [功能描述]替换特殊字符 [参 数]要替换的字符串 [返 回]替换后的字符串 [更新履历]2006-12-29 by zhangqiang
	 */
	public static String toRepalaceSign(String p_strValue) {
		// 替换半角空格
		String str_Temp = p_strValue.replaceAll(" ", "&nbsp;&nbsp;");
		// 替换全角空格
		str_Temp = str_Temp.replaceAll("　", "&nbsp;&nbsp;&nbsp;&nbsp;");
		// 替换空
		// str_Temp = str_Temp.replaceAll("","&nbsp;");
		// 替换<
		str_Temp = str_Temp.replaceAll("<", "&lt;");
		// 替换>
		str_Temp = str_Temp.replaceAll(">", "&gt;");
		// 替换‘
		// str_Temp = str_Temp.replaceAll("\'","&apos;");
		// 替换“”
		str_Temp = str_Temp.replaceAll("\"", "&quot");
		// 替换回车
		str_Temp = str_Temp.replaceAll("\r", "<br>");
		// 替换换行
		str_Temp = str_Temp.replaceAll("\n", "");

		return str_Temp;
	}

	// ////////////////////////////////////
	// 实例函数，创建下拉列表
	// ////////////////////////////////////
	/**
	 * [功 能] 取得单位下拉列表 [说 明] 单位下拉菜单<br>
	 * [参 数] 单位编号<br>
	 * [返 回] 下拉列表框的HTML代码 <br>
	 * [更新履历] 2007/04/03 zhangqiang<br>
	 */
	public String getCompany(String p_code) {
		StringBuffer sb_SQL = new StringBuffer("");
		sb_SQL.append(" SELECT t.jsdw_id,");
		sb_SQL.append("        t.jsdw_name ");
		sb_SQL.append("   FROM tb_take_over_company t ");

		// 返回下拉列表的HTML
		return new String(str_SelectOption + this.getSortOptionList(sb_SQL.toString(), p_code));
	}

	/**
	 * [功 能] 取得是否下拉列表 [说 明] 是否下拉菜单<br>
	 * [参 数] 编号<br>
	 * [返 回] 下拉列表框的HTML代码 <br>
	 * [更新履历] 2007/04/03 zhangqiang<br>
	 */
	public String getYesOrNo(String p_code) {
		StringBuffer sb_SQL = new StringBuffer("");
		sb_SQL.append(" SELECT t.code,");
		sb_SQL.append("        t.name ");
		sb_SQL.append("   FROM tb_type t ");

		// 返回下拉列表的HTML
		return new String(str_SelectOption + this.getSortOptionList(sb_SQL.toString(), p_code));
	}

	/**
	 * [功 能] 取得内部人员类型下拉列表 [说 明] 人员类型下拉菜单<br>
	 * [参 数] 编号<br>
	 * [返 回] 下拉列表框的HTML代码 <br>
	 * [更新履历] 2007/04/03 zhangqiang<br>
	 */
	public String getUserType(String p_code) {
		StringBuffer sb_SQL = new StringBuffer("");
		sb_SQL.append(" SELECT t.code,");
		sb_SQL.append("        t.name ");
		sb_SQL.append("   FROM tb_user_type t ");
		sb_SQL.append("  WHERE t.code <> 'out' ");

		// 返回下拉列表的HTML
		return new String(str_SelectOption + this.getSortOptionList(sb_SQL.toString(), p_code));
	}

	/**
	 * [功 能] 取得性别下拉列表 [说 明] 性别下拉菜单<br>
	 * [参 数] 编号<br>
	 * [返 回] 下拉列表框的HTML代码 <br>
	 * [更新履历] 2007/04/03 zhangqiang<br>
	 */
	public String getSex(String p_code) {
		StringBuffer sb_SQL = new StringBuffer("");
		sb_SQL.append(" SELECT t.code,");
		sb_SQL.append("        t.name ");
		sb_SQL.append("   FROM tb_sex t ");

		// 返回下拉列表的HTML
		return new String(str_SelectOption + this.getSortOptionList(sb_SQL.toString(), p_code));
	}

	/**
	 * [功 能] 取得子项目下拉列表 [说 明] 项目相关的子项目<br>
	 * [参 数] 项目编号<br>
	 * [返 回] 下拉列表框的HTML代码 <br>
	 * [更新履历] 2007/04/06 zhangqiang<br>
	 */
	public String getSubPro(String p_proid) {
		StringBuffer sb_SQL = new StringBuffer("");
		sb_SQL.append(" SELECT t.sub_pro_id,");
		sb_SQL.append("        t.sub_pro_name ");
		sb_SQL.append("   FROM tb_sub_pro t ");
		sb_SQL.append("  WHERE t.pro_id = '" + p_proid + "'");

		// 返回下拉列表的HTML
		return new String(str_SelectOption + this.getSortOptionList(sb_SQL.toString(), p_proid));
	}

	// ////////////////////////////////////
	// 新增加的函数，在下面定义即可
	// ////////////////////////////////////
	/**
	 * [功能描述] 取得施工放线参加者串 [参 数1] 工程id<br>
	 * [参 数2] 放线id<br>
	 * [返 回] 参加者字符串，以“,”分割 <br>
	 * [更新履历] 2007-03-23 zhangqiang<br>
	 */
	public String getSGFXPerson(String p_proID, String p_fxID) {
		String str_temp = "&nbsp;";
		if (null == p_proID || "".equals(p_proID)) {
			return str_temp = "&nbsp;";
		}
		if (null == p_fxID || "".equals(p_fxID)) {
			return str_temp = "&nbsp;";
		}

		DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		StringBuffer sb_SQL = new StringBuffer();

		sb_SQL.append("SELECT sgfx_person_name");
		sb_SQL.append("  FROM tb_sgfx_person");
		sb_SQL.append(" WHERE pro_id = '" + p_proID + "'");
		sb_SQL.append("   AND sgfx_id = '" + p_fxID + "'");

		conn.Open();

		res = conn.Query(sb_SQL.toString());
		// 查到结果
		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			for (int i = 1; i < res.size(); i++) {
				if (i == res.size() - 1) {
					str_temp = str_temp + res.getCell("sgfx_person_name", i);
				} else {
					str_temp += res.getCell("sgfx_person_name", i) + ",";
				}

			}
			// 没有结果
		} else {
			return str_temp = "&nbsp;";
		}

		conn.Close();

		return str_temp;
	}

	/**
	 * [功能描述]取得最大编号 [参 数1]字段名 [参 数2]表名 [返 回]当前最大编号＋1 [更新履历]2007-03-23 zhangqiang<br>
	 */
	public String getMaxSeq(String p_column, String p_table) {
		String str_seq = "";
		if (null == p_column || "".equals(p_column)) {
			return str_seq;
		}
		if (null == p_table || "".equals(p_table)) {
			return str_seq;
		}
		DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		StringBuffer sb_SQL = new StringBuffer();

		sb_SQL.append("SELECT MAX(" + p_column + ") as " + p_column);
		sb_SQL.append("  FROM " + p_table);

		res = conn.Query(sb_SQL.toString());

		// 查到结果
		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			// 如果有记录，则构造最大值+1
			int i_temp = Integer.parseInt(res.getCell(p_column, 1));
			i_temp++;
			str_seq = "" + i_temp;
		} else if (CommonConstants.CLDEF_DB_OK2 == res.getStatus()) {
			// 如果没有值，则取1
			str_seq = "1";
			return str_seq;
		} else {
			// 异常情况，返回空
			return str_seq;
		}
		return str_seq;
	}

	/**
	 * [功能描述]取得工程名称 [参 数]工程编号 [返 回]工程名 [更新履历]2007-03-26 by zhangqiang
	 */
	public String getProjectName(String p_proID) {
		String str_temp = "";

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT pro_name");
		sb_SQL.append("  FROM tb_project");
		sb_SQL.append(" WHERE pro_id = '" + p_proID + "'");

		str_temp = this.getViewByID(sb_SQL.toString());

		return str_temp;
	}

	/**
	 * [功能描述]取得用户姓名 [参 数]用户编号 [返 回]姓名 [更新履历]2007-04-05 by zhangqiang
	 */
	public String getUserName(String p_userCode) {
		String str_temp = "";

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT user_name ");
		sb_SQL.append("  FROM tb_user ");
		sb_SQL.append(" WHERE user_code = '" + p_userCode + "'");

		str_temp = this.getViewByID(sb_SQL.toString());

		return str_temp;
	}

	/**
	 * [功能描述]取得格式化后的时间 [参 数]未格式化的时间 [返 回]格式化后的时间 [更新履历]add by zhangqiang
	 */
	public String getFormatTime(String p_time) {
		String str_temp = "";

		if (null == p_time || "".equals(p_time)) {
			return str_temp;
		}
		DateFormat df = DateFormat.getDateInstance();

		try {
			Date date = df.parse(p_time);
			str_temp = new SimpleDateFormat("yyyy-MM-dd").format(date);
		} catch (ParseException pe) {
			pe.printStackTrace();
			str_temp = "&nbsp;";
		}
		return str_temp;
	}

	/**
	 * [功能描述]取得是否确认输出信息 [参 数]确认标志 [返 回]确认返回图片字符串 [更新履历]2007-03-28 by zhangqiang
	 */
	public String getIsConfirm(String p_flag) {
		String str_temp = "";
		// 已经确认
		if (CommonConstants.CONFIRM_YES.equals(p_flag)) {
			str_temp = "<img src=\"images/confirmYES.GIF\" style=\"cursor:hand\">";
		} else if (CommonConstants.CONFIRM_NO.equals(p_flag)) {
			str_temp = "<img src=\"images/confirmNO.GIF\" style=\"cursor:hand\">";
		} else {
			str_temp = "&nbsp;";
		}
		return str_temp;
	}

	/**
	 * [功能描述]取得文件保存名 [参 数]文件id [返 回]文件保存名 [更新履历]add by zhangqiang
	 */
	public String getFileName(String p_fileID) {
		String str_temp = "";

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT file_save_name");
		sb_SQL.append("  FROM tb_file");
		sb_SQL.append(" WHERE file_id = '" + p_fileID + "'");

		str_temp = this.getViewByID(sb_SQL.toString());
		return str_temp;
	}

	/**
	 * [功能描述]取得文件原始名 [参 数]文件id [返 回]文件保存名 [更新履历]add by zhangqiang
	 */
	public String getOriName(String p_fileID) {
		String str_temp = "";

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT file_original_name");
		sb_SQL.append("  FROM tb_file");
		sb_SQL.append(" WHERE file_id = '" + p_fileID + "'");

		str_temp = this.getViewByID(sb_SQL.toString());

		// 取得文件保存名
		String str_fileName = this.getFileName(p_fileID);
		// 取得文家后缀
		String str_extra = str_fileName.substring(str_fileName.length() - 3, str_fileName.length());
		// 组合成新文件名
		str_temp = str_temp + "." + str_extra;

		return str_temp;
	}

	/**
	 * 详细说明 对数值字符串进行格式化输出,去掉小数点后没用的零
	 * 
	 * @param String
	 *            类型数值
	 * @return String 格式化后的数值
	 * @exception none
	 * @author yangli
	 */
	public static String TrimDecEnd(String str) {
		int len = str.length();
		if (len == 0) {
			return str;
		}
		DecimalFormat format = (DecimalFormat) NumberFormat.getPercentInstance();
		format.applyPattern("#####0.####");

		return format.format(Double.parseDouble(str));
	}

	/**
	 * 详细说明 判断部门编号是否重复
	 * 
	 * @param String
	 *            部门编号
	 * @return Boolean 是否重复
	 * @exception none
	 * @author yangli
	 */
	public boolean depCodeRep(String depCode) {
		boolean isRep = true;
		DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		StringBuffer sb_SQL = new StringBuffer("");
		sb_SQL = new StringBuffer("");
		sb_SQL.append("SELECT dep_code");
		sb_SQL.append("  FROM tb_dep");
		sb_SQL.append("  WHERE dep_code = '" + depCode + "'");
		res = conn.Query(sb_SQL.toString());
		if (CommonConstants.CLDEF_DB_OK == res.getStatus() && res.getRows() > 1) {
			isRep = false;
		}
		return isRep;
	}

	/**
	 * [功能描述]取得排迁专业名称 [参 数]排迁专业编号 [返 回]排迁专业名称 [更新履历]2007-03-26 by rr
	 */
	public String getSubPqName(String p_subPqID) {
		String str_temp = "";

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT pq_name");
		sb_SQL.append("  FROM tb_sub_paiqian");
		sb_SQL.append(" WHERE sub_pq_id = '" + p_subPqID + "'");

		str_temp = this.getViewByID(sb_SQL.toString());

		return str_temp;
	}

	/**
	 * [功能描述]校验用户编号是否重复 [参 数]用户编号 [返 回]用户编号重复返回true,不重复返回false [更新履历]add by
	 * zhangqiang
	 */
	public boolean checkUserCode(String p_userCode) {
		boolean b_flag = false;
		if (null == p_userCode || "".equals(p_userCode)) {
			return b_flag;
		}
		StringBuffer sb_SQL = new StringBuffer();

		sb_SQL.append("SELECT user_code ");
		sb_SQL.append("  FROM tb_user ");
		sb_SQL.append(" WHERE user_code = '" + p_userCode + "'");

		String str_userCode = this.getViewByID(sb_SQL.toString());

		if ("".equals(str_userCode)) {
			b_flag = false;
			return b_flag;
		} else {
			b_flag = true;
		}
		return b_flag;
	}

	/**
	 * 详细说明 计算百分比
	 * 
	 * @param String 分子
	 * @param String 分母
	 * @return Boolean 是否重复
	 * @exception none
	 * @author rr
	 */
	public static String getPercent(String strC,String strM) {
        float f_C = 0;
        float f_M = 0;
        String str_C = "";
        String str_M = "";
        int iPer = 0;

        if (strM == null || strC == null || "".equals(strC) || "".equals(strM) || "0".equals(strM))
        {
            return "";
        }
        str_C = TrimDecEnd(strC);
        str_M = TrimDecEnd(strM);
        f_C = Float.parseFloat(str_C);
        f_M = Float.parseFloat(str_M);
        iPer = (f_M==0.0?0:Math.round(f_C*100/f_M)); 
        return String.valueOf(iPer)+"％";
    
    }
	
	/**
	 * 获取指定类别的选项Map
	 * key-选项ID value-选项NAME
	 * 
	 * @param types 类别
	 * @return Map
	 * @author ld
	 */
	public Map<String,String> getOptionItemMap(String types) {
		// 结果集对象
		ResultObj res = new ResultObj();
		// 数据库连接对象
		DBOperate conn = new DBOperate();
		Map<String,String> optionItemMap = new HashMap<String,String>();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		if (types.length() > 0) {
			String[] typeArray = types.split(",");
			for (int i = 0; i < typeArray.length; i++) {
				if (i == 0) {
					sb_SQL.append("AND (t_optionitem.C_TYPE = '" + typeArray[i] + "' ");
				} else {
					sb_SQL.append("OR t_optionitem.C_TYPE = '" + typeArray[i] + "' ");
				}
			}
			sb_SQL.append(") ");
		}
		sb_SQL.append("ORDER BY t_optionitem.C_TYPE ASC, t_optionitem.C_ORDER ASC ");
		
		// 执行查询
		res = conn.Query(sb_SQL.toString());
		
		if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
			for (int i = 1; i < res.size(); i++) {
				optionItemMap.put(StringUtil.convertNull(res.getCell("C_ID", i)), 
						StringUtil.convertNull(res.getCell("C_NAME", i)));
			}
		}
		
		return optionItemMap;
	}
	
	/**
	 * 获取省市Map
	 * key-省ID value-城市List
	 * 
	 * @return Map
	 * @author ld
	 */
	public Map<String,List<String[]>> getProvinceCityMap() {
		// 结果集对象
		ResultObj res = new ResultObj();
		// 数据库连接对象
		DBOperate conn = new DBOperate();
		Map<String,List<String[]>> provinceCityMap = new HashMap<String,List<String[]>>();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME, ");
		sb_SQL.append("t_optionitem.C_PARENTID ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'city' ");
		sb_SQL.append("ORDER BY t_optionitem.C_PARENTID ASC, t_optionitem.C_ORDER ASC ");
		
		// 执行查询
		res = conn.Query(sb_SQL.toString());
		
		if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
			String parentID;
			List<String[]> cityList = new ArrayList<String[]>();
			String[] cityInfo;
			for (int i = 1; i < res.size(); i++) {
				parentID = StringUtil.convertNull(res.getCell("C_PARENTID", i));
				cityList = new ArrayList<String[]>();
				if (provinceCityMap.containsKey(parentID)) {
					cityList = (List<String[]>) provinceCityMap.get(parentID);
				}
				cityInfo = new String[2];
				cityInfo[0] = StringUtil.convertNull(res.getCell("C_ID", i));
				cityInfo[1] = StringUtil.convertNull(res.getCell("C_NAME", i));
				cityList.add(cityInfo);
				provinceCityMap.put(parentID, cityList);
			}
		}
		
		return provinceCityMap;
	}
	
	/**
	 * 去掉小数点后多余的0
	 * 
	 * @param b
	 * @return String
	 * @author ld
	 */
	public String removeTailZero(String b) {
		String s = b;
		int i, len = s.length();
		if (s.indexOf(".") == -1)
			return s;
		for (i = 0; i < len; i++)
			if (s.charAt(len - 1 - i) != '0')
				break;
		if (s.charAt(len - i - 1) == '.')
			return s.substring(0, len - i - 1);
		return s.substring(0, len - i);
	}

	/**
	 * 获取会员类别下拉列表
	 * 
	 * @param p_MemType
	 * @return String
	 * @author ld
	 */
	public String getMemTypeOptionList(String p_MemType) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_memtype.C_ID, ");
		sb_SQL.append("t_memtype.C_TYPENAME ");
		sb_SQL.append("FROM t_memtype ");
		sb_SQL.append("ORDER BY t_memtype.C_SCORE ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_MemType);
	}
	
	/**
	 * 获取组织下拉列表
	 * 
	 * @param p_Org
	 * @return String
	 * @author ld
	 */
	public String getOrgOptionList(String p_Org) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_org.C_ID, ");
		sb_SQL.append("t_org.C_NAME ");
		sb_SQL.append("FROM t_org ");
		sb_SQL.append("ORDER BY t_org.C_NAME ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_Org);
	}
	
	/**
	 * 获取性别下拉列表
	 * 
	 * @param p_Sex
	 * @return String
	 * @author ld
	 */
	public String getSexOptionList(String p_Sex) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'sex' ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_Sex);
	}
	
	/**
	 * 获取媒体方式下拉列表
	 * 
	 * @param p_MediaType
	 * @return String
	 * @author ld
	 */
	public String getMediaTypeOptionList(String p_MediaType) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'mediaType' ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_MediaType);
	}
	
	/**
	 * 获取合同单位下拉列表
	 * 
	 * @param p_Company
	 * @return String
	 * @author ld
	 */
	public String getCompanyOptionList(String p_Company) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'company' ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_Company);
	}
	
	/**
	 * 获取所在地区-省下拉列表
	 * 
	 * @param p_Province
	 * @return String
	 * @author ld
	 */
	public String getProvinceOptionList(String p_Province) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'province' ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_Province);
	}
	
	/**
	 * 获取所在地区-市下拉列表
	 * 
	 * @param p_Province
	 * @param p_City
	 * @return String
	 * @author ld
	 */
	public String getCityOptionList(String p_Province, String p_City) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'city' ");
		sb_SQL.append("AND t_optionitem.C_PARENTID = " + p_Province + " ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_City);
	}
	
	/**
	 * 获取就诊类别下拉列表
	 * 
	 * @param p_HosType
	 * @return String
	 * @author ld
	 */
	public String getHosTypeOptionList(String p_HosType) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'hosType' ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_HosType);
	}
	
	/**
	 * 将传入的流文件写入response中，此方法会在结束时关闭流文件
	 * 
	 * @param realName
	 * @param response
	 * @param bis
	 * @author ld
	 */
	public void writeStreamToResponse(String realName, HttpServletResponse response, InputStream bis) {
		try {
			// 设置响应头和下载保存的文件名
			String extendName = null;
			String mimeType = null;
			int pos = realName.lastIndexOf(".");
			if (pos >= 0 && (pos + 1) < realName.length()) {
				extendName = realName.substring(pos + 1);
			}
			if (extendName != null && extendName.equals("xls"))
				mimeType = "text/html";
			if (mimeType == null)
				mimeType = "APPLICATION/OCTET-STREAM";

			response.setContentType(mimeType);
			// 如果realName是中文时，需要对中文名称进行encode才能正确显示
			response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(realName, "UTF-8") + "\"");

			byte[] data = new byte[1024];

			int length;
			OutputStream out = response.getOutputStream();

			do {
				length = bis.read(data);
				if (length != -1) {
					out.write(data, 0, length);
				}
			} while (length > 0);

			out.flush();
			data = null;
		} catch (IOException ex) {
			response.setContentType("text/html");
			response.setHeader("Content-Disposition", "");
			System.out.println("writeStreamToResponse Error " + ex.getMessage());
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
				System.out.println("writeStreamToResponse Error " + ex.getMessage());
			}
		}
	}
	
	/**
	 * 获取数据库服务器时间(1900-01-01 00:00:00)
	 * 
	 * @author ld
	 */
	public String getServerDate_MySQL() {
		String str_ColumName = "";
		String str_SQL = "SELECT NOW() ";

		str_ColumName = getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900-01-01 00:00:00";
		}

		return str_ColumName;
	}
	
	/**
	 * 获取系统当前时间的年
	 * 
	 * @author ld
	 */
	public int getYear() {
		String str_ColumName = "";
		String str_SQL = "SELECT EXTRACT(YEAR FROM NOW()) ";

		str_ColumName = getViewByID(str_SQL);

		if ("".equals(str_ColumName)) {
			str_ColumName = "1900";
		}

		return Integer.parseInt(str_ColumName);
	}
	
	/**
	 * 获取指定类别的选项Map
	 * key-选项NAME value-选项ID
	 * 
	 * @param types 类别
	 * @return Map
	 * @author ld
	 */
	public Map getOptionItemMap1(String types) {
		// 结果集对象
		ResultObj res = new ResultObj();
		// 数据库连接对象
		DBOperate conn = new DBOperate();
		Map<String,String> optionItemMap = new HashMap<String,String>();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		if (types.length() > 0) {
			String[] typeArray = types.split(",");
			for (int i = 0; i < typeArray.length; i++) {
				if (i == 0) {
					sb_SQL.append("AND (t_optionitem.C_TYPE = '" + typeArray[i] + "' ");
				} else {
					sb_SQL.append("OR t_optionitem.C_TYPE = '" + typeArray[i] + "' ");
				}
			}
			sb_SQL.append(") ");
		}
		sb_SQL.append("ORDER BY t_optionitem.C_TYPE ASC, t_optionitem.C_ORDER ASC ");
		
		// 执行查询
		res = conn.Query(sb_SQL.toString());
		
		if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
			for (int i = 1; i < res.size(); i++) {
				optionItemMap.put(StringUtil.convertNull(res.getCell("C_NAME", i)), 
						StringUtil.convertNull(res.getCell("C_ID", i)));
			}
		}
		
		return optionItemMap;
	}
	
	/**
	 * 获取文章类别下拉列表
	 * 
	 * @param p_Type
	 * @return String
	 * @author ld
	 */
	public String getArticleTypeOptionList(String p_Type, String p_ParentID) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'articleType' ");
		sb_SQL.append("AND t_optionitem.C_PARENTID = ").append(p_ParentID).append(" ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_Type);
	}
	
	/**
	 * 获取文章状态下拉列表
	 * 
	 * @return String
	 * @author ld
	 */
	public String getArticleStatusOptionList(String p_Status) {
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT t_optionitem.C_ID, ");
		sb_SQL.append("t_optionitem.C_NAME ");
		sb_SQL.append("FROM t_optionitem ");
		sb_SQL.append("WHERE t_optionitem.C_STATUS = '1' ");
		sb_SQL.append("AND t_optionitem.C_TYPE = 'articleStatus' ");
		sb_SQL.append("ORDER BY t_optionitem.C_ORDER ASC ");
		
		return getSortOptionList(sb_SQL.toString(), p_Status);
	}
}
