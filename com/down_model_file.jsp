<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<%@ page import="com.syntc.constants.CommonConstants"%>
<%@ page import="com.syntc.common.bean.Common"%>
<%@ include file="/com/begin.jsp"%>
<%
try
{
  com.syntc.util.StringUtil stringUtil = new com.syntc.util.StringUtil();
	//得到文件id
	String str_name = request.getParameter("fileName");

	//取得文件路径
	String str_filepath = request.getRealPath("\\") + "\\model_file\\" + str_name;

	//取得文件原始名
	String str_fileOriName = stringUtil.getRequestData(request.getParameter("fileDownName"));

	common.downLoad(str_filepath,str_fileOriName,response,false);
	
}
catch(Exception e)
{
	System.out.println(e);
	out.print("<SCRIPT language=javascript> history.back(-1); </SCRIPT>");
}
%>
