<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title>操作失败</title>
<syntc:ScriptsCommon />

</head>

<body  bgcolor=#a2adee>
<br>
<br>
<br>
<br>
<br>
<br>
<table width="80%" border="0" cellspacing="0" cellpadding="0" align="center" >
<tr>
	<td valign=top width=100><img src="images/info.jpg"></td>
	<td>
		<font color=#3752BD size=2>
		<strong>警告</strong>
		<br><br>
		操作失败，请稍候再试，<br>
		或与系统管理员联系。<br><br>
		</font>

<table width="20" border="0" cellspacing="0" cellpadding="0"  ><tr><td>
<syntc:TableHeader />
<syntc:ReturnButton />
<syntc:TableFoot />
</td></tr></table>


	</td>
</tr>
</table>
</body>
</html>
