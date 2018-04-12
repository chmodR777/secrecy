<%@	page contentType="text/html; charset=UTF-8"	%>
<%
	String path	= request.getContextPath();	
	String loginMess = request.getParameter("p_LoginState");
	if (loginMess == null) {
		loginMess = "";
	}
%>
<html>
<head>
<link href="<%=path%>/css/css.css" type=text/css rel=stylesheet>
<title>保密教育管理系统</title>
<syntc:ScriptsCommon />

<script	language=javascript>
function funonload() {
	document.loginFrm.txtUserCode.focus();
}

function mysubmit() {
	var	v_user = document.loginFrm.txtUserCode.value;
	var	v_pwd = document.loginFrm.txtUserPwd.value;
	if (v_user == null || v_user == "") {
		alert("请输入用户名！");
		return;
	}
	if (v_pwd == null || v_pwd == "") {
		alert("请输入密码！");
		return;
	}
	document.loginFrm.action="<%=path%>/Login.do";
	document.loginFrm.submit();
}

function checksubmit() {
	if (event.keyCode == 13) {
		mysubmit();
	}	
}

function myclear() {
	document.loginFrm.txtUserCode.value	= "";	
	document.loginFrm.txtUserPwd.value = "";
}
</script>
</head>


<body topmargin="50" leftmargin="0"	onkeydown="checksubmit()" onload="funonload()">
<form name="loginFrm" action="Login.do"	method="post">
<center>
<br>
<div align="center"	valign="center">
<table cellpadding="0" cellspacing="0" topmargin="0" leftmargin="0"	border=0 width=730>
	<!-- 头部 -->
	<tr>
		<td>
			<table cellpadding="0" cellspacing="0" topmargin="0" leftmargin="0"	border=0 width=100%>
				<tr>
					<td	width=280 align=left><img src="<%=path%>/images/login/head.gif" border=0></td>
					<td	bgcolor="#ffffff" background ="<%=path%>/images/login/headbg.gif">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td>
			<table cellpadding="0" cellspacing="0" topmargin="0" leftmargin="0"	border=0 width=100%>
				<tr>
					<!-- 中左 -->
					<td	width=280 align=left><img src="<%=path%>/images/login/left.gif"	border=0></td>
					<td>
						<table cellpadding="0" cellspacing="0" topmargin="0" leftmargin="0"	border=0 width=100%>
							<tr>
								<!-- 中部 -->
								<td	width=115 align=left><img src="<%=path%>/images/login/bar1.gif" border=0></td>
								<!-- 中右 -->
								<td align=center valign=top>
									<table cellpadding="0" cellspacing="0" topmargin="0" leftmargin="0"	border=0 width=70%>
										<tr>
											<td colspan=2 height=30>&nbsp;</td>
										</tr>
										<tr>
											<td colspan=2 align=center><% if (!loginMess.equals("")) { %><font color=red>用户名或密码错误！</font><% } %></td>
										</tr>
										<tr>
											<td colspan=2 height=25>&nbsp;</td>
										</tr>
										<tr>
											<td	align="center" nowrap height=30>用户名：</td>
											<td	align="right" nowrap><INPUT	TYPE="text"	NAME="txtUserCode" size="10" style="width:120" value=""></td>
										</tr>
										<tr>
											<td	align="center" nowrap height=30>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
											<td	align="right" nowrap><INPUT	TYPE="password"	NAME="txtUserPwd" size="12" style="width:120" value=""></td>
										</tr>
										<tr>
											<td></td>
											<td	align="right" nowrap height=30>
												<INPUT TYPE="button" VALUE=" 登录 " onclick="mysubmit()">&nbsp;
												<INPUT TYPE="button" VALUE=" 清除 " onclick="myclear()">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td	width=11 bgcolor="#ffffff" valign=bottom align=right><img src="<%=path%>/images/login/bow.gif" border=0></td>
					<td	width=11 background="<%=path%>/images/login/bg.gif"></td>
				</tr>
			</table>
		</td>
	</tr>

	<!-- 下部 -->	
	<tr>
		<td	width=100% height=11 background="<%=path%>/images/login/bg.gif"></td>
	<tr>
		<td	height=20>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">tk开发小组 版权所有 2018</td>
	</tr>
</table>
</div>
</form>
</body>
</html>

