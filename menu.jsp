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
	//取得用户菜单权限
	UserBean user = (UserBean)request.getSession().getAttribute("UserBean");
	
	Map<String,String> map = user.getUserRightMap();


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
<%
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_sjjs"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("21"))){
%>
  <tr onClick="oc('sjjs');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">上级精神</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_sjjs"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("22"))){
%>
  <tr id="sub_sjjs" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=72');">
    <td class="m2">&nbsp;</td>
    <td class="m2">首长批示</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("23"))){
%>
  <tr id="sub_sjjs" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=73');">
    <td class="m2">&nbsp;</td>
    <td class="m2">领导讲话</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("24"))){
%>
	<tr id="sub_sjjs" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=74');">
    <td class="m2">&nbsp;</td>
    <td class="m2">通知通告</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_fgzd"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("25"))){
%>
  <tr onClick="oc('fgzd');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">法规制度</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_fgzd"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("26"))){
%>
  <tr id="sub_fgzd" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=76');">
    <td class="m2">&nbsp;</td>
    <td class="m2">上级政策</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("27"))){
%>
  <tr id="sub_fgzd" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=77');">
    <td class="m2">&nbsp;</td>
    <td class="m2">本级法规</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("28"))){
%>
	<tr id="sub_fgzd" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=78');">
    <td class="m2">&nbsp;</td>
    <td class="m2">内部资料</td>
    <td class="m2">&nbsp;</td>
  </tr>
 <%
	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_dxal"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("29"))){
%>
  <tr onClick="oc('dxal');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">典型案例</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_dxal"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("30"))){
%>
  <tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=80');">
    <td class="m2">&nbsp;</td>
    <td class="m2">被敌策反卖密</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("31"))){
%>
  <tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=81');">
    <td class="m2">&nbsp;</td>
    <td class="m2">违规联网泄密</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("32"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=82');">
    <td class="m2">&nbsp;</td>
    <td class="m2">载体转网失秘</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("33"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=83');">
    <td class="m2">&nbsp;</td>
    <td class="m2">管控不利丢密</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("34"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=84');">
    <td class="m2">&nbsp;</td>
    <td class="m2">手机违规传密</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("35"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=85');">
    <td class="m2">&nbsp;</td>
    <td class="m2">学术研究宣密</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("36"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=86');">
    <td class="m2">&nbsp;</td>
    <td class="m2">退休退役带密</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("37"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=87');">
    <td class="m2">&nbsp;</td>
    <td class="m2">上网无意炫密</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("38"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=88');">
    <td class="m2">&nbsp;</td>
    <td class="m2">违规传递漏密</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	if("TRUE".equals(map.get("39"))){
%>
	<tr id="sub_dxal" style="display:<%=str_display%>;" onClick="gourl('ArticleList.do?article_type=89');">
    <td class="m2">&nbsp;</td>
    <td class="m2">载体转网失秘</td>
    <td class="m2">&nbsp;</td>
  </tr> 
<%
	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_xsjl"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("40"))){
%>
  <tr onClick="oc('xsjl');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">学习交流</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_xsjl"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("41"))){
%>
  <tr id="sub_xsjl" style="display:<%=str_display%>;" onClick="gourl('ArticleStatusManage.do?article_type=91');">
    <td class="m2">&nbsp;</td>
    <td class="m2">在线投稿</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("42"))){
%>
	<tr id="sub_xsjl" style="display:<%=str_display%>;" onClick="gourl('ArticleStatusManage.do?article_type=92');">
    <td class="m2">&nbsp;</td>
    <td class="m2">经验分享</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("1"))){
%>
  <tr onClick="gourl('PatientManage.do');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">患者信息管理</td>
    <td class="m1">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("2"))){
%>
  <tr onClick="gourl('Query_Info.do');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">患者信息查询</td>
    <td class="m1">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("3"))){
%>
  <tr onClick="gourl('ConsultManage.do');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">咨询信息管理</td>
    <td class="m1">&nbsp;</td>
  </tr>

<%
	}
	if("TRUE".equals(map.get("4"))){
%>
  <tr onClick="gourl('MedicineManage.do');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">邮药信息管理</td>
    <td class="m1">&nbsp;</td>
  </tr>
<%
	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_zbht"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}

	if("TRUE".equals(map.get("5"))){
%>
  <tr onClick="oc('zbht');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">综合统计图表</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_zbht"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("6"))){
%>
  <tr id="sub_zbht" style="display:<%=str_display%>;" onClick="gourl('PicCakeChart.do?flag=1');">
    <td class="m2">&nbsp;</td>
    <td class="m2">饼状统计图</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("7"))){
%>
  <tr id="sub_zbht" style="display:<%=str_display%>;" onClick="gourl('PicLineXYChart.do?flag=1');">
    <td class="m2">&nbsp;</td>
    <td class="m2">折线统计图</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("8"))){
%>
  <tr id="sub_zbht" style="display:<%=str_display%>;" onClick="gourl('PicBarChart.do?flag=1');">
    <td class="m2">&nbsp;</td>
    <td class="m2">柱形统计图1</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("9"))){
%>
  <tr id="sub_zbht" style="display:<%=str_display%>;" onClick="gourl('PicBar2Chart.do?flag=1');">
    <td class="m2">&nbsp;</td>
    <td class="m2">柱形统计图2</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_tjbb"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("10"))){
%>
  <tr onClick="oc('tjbb');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">系统管理</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_tjbb"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("15"))){
%>
  <tr id="sub_tjbb" style="display:<%=str_display%>;" onClick="gourl('OrgManage.do');">
    <td class="m2">&nbsp;</td>
    <td class="m2">组织管理</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("11"))){
%>
  <tr id="sub_tjbb" style="display:<%=str_display%>;" onClick="gourl('UserManage.do');">
    <td class="m2">&nbsp;</td>
    <td class="m2">用户管理</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("12"))){
%>
	<tr id="sub_tjbb" style="display:<%=str_display%>;" onClick="gourl('UserRight.do');">
    <td class="m2">&nbsp;</td>
    <td class="m2">权限管理</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("13"))){
%>
  <tr id="sub_tjbb" style="display:<%=str_display%>;" onClick="gourl('MemTypeManage.do');">
    <td class="m2">&nbsp;</td>
    <td class="m2">会员类别管理</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("14"))){
%>
  <tr id="sub_tjbb" style="display:<%=str_display%>;" onClick="gourl('BackUp_jsp.do');">
    <td class="m2">&nbsp;</td>
    <td class="m2">系统备份与恢复</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_wzgl"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("16"))){
%>
  <tr onClick="oc('wzgl');">
    <td class="m1l"><img src="images/menus/m4.jpg"></td>
    <td class="m1">文章管理</td>
    <td class="m1"><img src="images/menus/<%=str_imgname%>.gif" id="oc_wzgl"></td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("17"))){
%>
  <tr id="sub_wzgl" style="display:<%=str_display%>;" onClick="gourl('ArticleManage.do?article_type=71');">
    <td class="m2">&nbsp;</td>
    <td class="m2">上级精神</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("18"))){
%>
  <tr id="sub_wzgl" style="display:<%=str_display%>;" onClick="gourl('ArticleManage.do?article_type=75');">
    <td class="m2">&nbsp;</td>
    <td class="m2">法规制度</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("19"))){
%>
	<tr id="sub_wzgl" style="display:<%=str_display%>;" onClick="gourl('ArticleManage.do?article_type=79');">
    <td class="m2">&nbsp;</td>
    <td class="m2">典型案例</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
	if("TRUE".equals(map.get("20"))){
%>
  <tr id="sub_wzgl" style="display:<%=str_display%>;" onClick="gourl('ArticleStatusManage.do?article_type=90');">
    <td class="m2">&nbsp;</td>
    <td class="m2">学习交流</td>
    <td class="m2">&nbsp;</td>
  </tr>
<%
	}
%>
  <tr onClick="gourl('PwdUpt.do');">
    <td class="m1l"><img src="images/menus/m2.jpg"></td>
    <td class="m1">个人密码修改</td>
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
	if (lineArray.length > 1){
		for (var i = 0; i < lineArray.length; i ++) {
			lineArray[i].style.display=subdisplay;
		}
	} else {
			lineArray.style.display=subdisplay;
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

