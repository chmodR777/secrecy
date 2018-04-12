<%@ page contentType="text/html; charset=UTF-8" %>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<style type="text/css">
<!--
.nu{
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #FFFFFF;
}
.mw {
	background-color: #6D7DDE;
}
.m1l {
	background-color: #A2ADEE;
	cursor:hand;
	vertical-align: middle;
	height: 27px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #C0C8F2;
	padding-left: 13px;}
.m1 {
	background-color: #A2ADEE;
	font-family: "宋体;SimSun";
	font-size: 14px;
	font-weight: bold;
	color: 2C40AE;
	cursor:hand;
	vertical-align: middle;
	height: 27px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #C0C8F2;
}
.m2 {
	background-color: #DADFF9;
	font-family: "宋体;SimSun";
	font-size: 14px;
	color: 2C40AE;
	cursor:hand;
	vertical-align: middle;
	height: 27px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #C0C8F2;
	padding-top: 3px;
}
body{
  overflow-x: hidden;
}
-->
</style>
</head>

<%

	String str_display;
	String str_imgname;
	String str_sh;

	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_xmxz"),"open");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}

%>

<body topmargin=0 leftmargin=0 bgcolor=#A2ADEE>
<form name="formmenu" action="" method="post" target="mainFrame">
  <table width="200" border=0 cellpadding="0" cellspacing="0" align=right>
  <tr class=mw>
    <td width=50 height=3 ><img src="images/clear.gif"></td>
    <td><img src="images/clear.gif"></td>
    <td width=40><img src="images/clear.gif"></td>
  </tr>
  <tr>
    <td class="mw" colspan=3 nowrap height=27>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/menus/welcom.jpg"></td>
  </tr>
  <tr onClick="gourl('OutList.do');">
    <td class="m1l"><img src="images/menus/mo1.jpg"></td>
    <td class="m1">计划和进展上传</td>
    <td class="m1">&nbsp;</td>
  </tr>
  <tr onClick="gourl('FileModelDown.do?file_type=3');">
    <td class="m1l"><img src="images/menus/m3.jpg"></td>
    <td class="m1">模板下载</td>
    <td class="m1">&nbsp;</td>
  </tr>
  <tr onClick="gourl('PwdUpt.do');">
    <td class="m1l"><img src="images/menus/m11.jpg"></td>
    <td class="m1">用户设置</td>
    <td class="m1">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#A2ADEE" colspan=3 height=10><img src="images/clear.gif"></td>
  </tr>
	</table>
</form>
</body>

<script language="JavaScript">
function oc(folderid){
	// 设置打开关闭图标
	var ocid="oc_"+folderid;
	var subdisplay;
	var bopen;
	var oc = document.all(ocid);
	var imgname="";
	imgname = oc.src;
	if (imgname.substr(imgname.length-18,18)=="images/menus/o.gif"){
		s_status = "close";
		oc.src="images/menus/c.gif";
		subdisplay="none";
	}else{
		s_status = "open";
		oc.src="images/menus/o.gif";
		subdisplay="";
	}


	// 显示或隐藏子菜单
	var subid="sub_"+folderid;
	var lineArray = document.all(subid);
	for (var i = 0; i < lineArray.length; i ++) {
		lineArray[i].style.display=subdisplay;
	}

	// 在top中保存当前的设置
	var sh_name="sh_"+folderid;

	var sh = parent.document.frames.item('ttop').form_top.elements(sh_name);
	sh.value=s_status;

}

function gourl(vurl){
	document.formmenu.action=vurl;
	document.formmenu.submit();

}
</script>

</html>
