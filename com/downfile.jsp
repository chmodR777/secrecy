<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<%@ page import="com.syntc.constants.CommonConstants"%>
<%@ page import="com.syntc.common.bean.Common"%>
<%
try
{
	com.syntc.common.bean.Common common = new com.syntc.common.bean.Common();
	//得到文件id
	String str_id = request.getParameter("fileid");
	//取得文件路径
	String str_filepath = CommonConstants.UPLOADPAH + "\\" + common.getFileName(str_id);

	//取得文件原始名
	String str_fileOriName = common.getOriName(str_id);

	common.downLoad(str_filepath,str_fileOriName,response,false);
	
}
catch(Exception e)
{
	System.out.println(e);
	out.print("<SCRIPT language=javascript> history.back(-1); </SCRIPT>");
}
%>
