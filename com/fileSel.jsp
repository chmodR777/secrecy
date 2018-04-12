<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head>
<title>文件列表</title>
</head>
<%
//页面上的人员信息
String strFunctionCode = StringUtil.convertNull((String)request.getParameter("functionCode"));
//消息信息
String strIfConfirm = StringUtil.convertNull((String)request.getParameter("ifConfirm"));
%>
<frameset rows="0,*" border="0" frameborder="1" framespacing="0">
	<!-- Info Frame -->
	<frame src="/com/blank.html" name="header" scrolling="no" frameborder="0" noresize>
	
	<!-- Input Frame -->
	<frame src="CommonFileRecord.do?functionCode=<%=strFunctionCode%>&ifConfirm=<%=strIfConfirm%>" name="detail" frameborder="0">
</frameset>
<noframes>
ssss
</noframes>
</body>
</html>
