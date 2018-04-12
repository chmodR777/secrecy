<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.syntc.util.*" %>
<%@ page import="com.syntc.common.bean.*" %>
<%@ page import="com.syntc.constants.CommonConstants" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<jsp:useBean id="common" scope="session" class="com.syntc.common.bean.Common"/>
<jsp:useBean id="rsObj" scope="page" class="com.syntc.util.ResultObj"/>
<jsp:useBean id="pageObj" scope="page" class="com.syntc.util.RowSet" />
<jsp:useBean id="UserBean" scope="session" class="com.syntc.common.bean.UserBean" />

<%
	String path_root = request.getContextPath();
	//session 设置为半小时
	session.setMaxInactiveInterval( 30*60*1 );

    String str_LoginUserCode = UserBean.getUserCode();
    
	//如果session超时，重新登陆 @@wp need change 

	if(str_LoginUserCode.equals("no code")){
%>
<SCRIPT LANGUAGE="JavaScript">
<!--
	alert("Session超时，请重新登录！");
	parent.parent.location.href="<%=path_root%>/login.jsp";
	
//-->
</SCRIPT>
<% 	
	} 
%>