<html>
<head>
<title>top</title>
<%@ include file="/com/begin.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<style type=text/css>
td {
	FONT-SIZE: 9pt
}
a {
	COLOR: #000000; TEXT-DECORATION: underline
}
a:hover {
	COLOR: #e78a29; TEXT-DECORATION: none
}
</style>
<script	language="JavaScript">
var cur_pro_id="";
function funChangePro(proid){
	if(cur_pro_id != proid){
		cur_pro_id = proid;
		document.form_top.submit();
	}
}

function funClearProid(){
	cur_pro_id = "#";
}

</script>
</head>

<body text=#000000 leftMargin=0 topMargin=0	onload="javascript:scroll(0,93);" marginheight= "0" marginwidth="0">
<form name="form_top" action="Menu.do" method="post" target="leftFrame">
<input type="hidden" name="sh_xmxz" value="open">
<input type="hidden" name="sh_zbht" value="close">
<input type="hidden" name="sh_tjbb" value="close">
<input type="hidden" name="sh_wzgl" value="close">
<input type="hidden" name="sh_xtgl" value="close">
<input type="hidden" name="sh_sjjs" value="close">
<input type="hidden" name="sh_fgzd" value="close">
<input type="hidden" name="sh_dxal" value="close">
</form>

<table cellSpacing=0 cellPadding=0 width="100%" border=0>
	<tr>
		<td height=70 style="background-image:url(images/frame/top_02.png);background-repeat:no-repeat;height=100%;">&nbsp;</td>
	</tr>
</table>
<table cellSpacing=0 cellPadding=0 width="100%" border=0>
	<tr>
		<td width="70%" background="images/frame/topbar_01.jpg" height=22>
		<table cellSpacing=0 cellPadding=0 width="100%" border=0>
			<tr>
				<td nowrap>
				<div align=center><img height=16 src="images/frame/bar_00.gif" width=16></div>
				</td>
				<td nowrap>『当前用户：<%=UserBean.getUserName()%> － <%=UserBean.getUserCode()%>』</td>
			</tr>
		</table>
		</td>
		<td width="100%" background="images/frame/topbar_01.jpg">
		<table cellSpacing=0 cellPadding=0 align=right border=0>
			<tr>
				<td width=24><img height=16 src="images/frame/bar_01.gif" width=16></td>
				<td width=40 nowrap><a href="white.htm" target=mainFrame>首页</a></td>
				<td width=24><img height=16 src="images/frame/bar_06.gif" width=16></td> 
				<td width=40 nowrap><a 
					onclick="if (!window.confirm('您确认要退出系统吗？')){return false;}"
					href="login.jsp" target=_top>退出</a></td>
				<td width=24><img id=indent style="CURSOR: hand"
					onclick="if(parent.topset.rows!='22,*'){parent.topset.rows='22,*';window.scroll(0,93);document.all.indent.src='images/frame/bar_70.gif';}else{parent.topset.rows='93,*';document.all.indent.src='images/frame/bar_07.gif';};"
					height=16 src="images/frame/bar_07.gif" width=16 name=indent></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>
