<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>用户权限编辑页面</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="系统管理 >> 权限管理 >> 编辑权限" />
<syntc:FuncHeader header="编辑权限" showall="yes"/>
<br>

<syntc:TableTitle header="用户信息">
<syntc:TableHeader />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res = (ResultObj)request.getAttribute("res");

String strUSER_ID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strUSER_CODE = StringUtil.convertNull(res.getCell("C_CODE", 1));
String strUSER_NAME = StringUtil.convertNull(res.getCell("C_NAME", 1));
String strSEX = StringUtil.convertNull(res.getCell("C_SEX", 1));
if("1".equals(strSEX)){
	strSEX = "男";
}else if("0".equals(strSEX)){
	strSEX = "女";
} else {
	strSEX = "&nbsp;";
}
String strTEL = StringUtil.convertNull(res.getCell("C_TEL", 1));
if (strTEL.length() == 0) {
	strTEL = "&nbsp;";
}
String strORG = StringUtil.convertNull(res.getCell("C_ORG", 1));
if (strORG.length() == 0) {
	strORG = "&nbsp;";
}

List<String> list = (List<String>)request.getAttribute("list");
//具有菜单权限标志
boolean b_flag = false;
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>用户名：</td>
	<td class="input" width="30%"><%=strUSER_CODE %>
      <input type="hidden" name="txtUSER_ID" len="10" value="<%=strUSER_ID %>">
    </td>
	<td class="item" width="20%" nowrap>姓名：</td>
	<td class="input" width="30%"><%=strUSER_NAME %>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>性别：</td>
	<td class="input"><%=strSEX %>
    </td>
    <td class="item" nowrap>联系电话：</td>
	<td class="input"><%=strTEL %>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>所在组织：</td>
	<td class="input"><%=strORG %>
    </td>
    <td class="item" nowrap>&nbsp;</td>
	<td class="input">&nbsp;
    </td>
  </tr>
</syntc:HtmlTable>
<br>
<syntc:TableTitle header="权限列表" >
<syntc:TableHeader />
<syntc:SaveButton/>
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>
<syntc:HtmlTable>
<tr class="title">
	<th class="nm" nowrap width="20%">选择</th>
	<th class="nm" nowrap width="30%">菜单名称</th>
    <th class="nm" nowrap width="50%">功能描述</th>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("21".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	<input type="checkbox" name="menuid" id="m21" value="21" onclick="chkAllSub('m21')" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">上级精神</td>
    <td class="input" width="50%">上级精神(一级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("22".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m21_1" value="22" onclick="chkItsParent('m21',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首长批示</td>
    <td class="input" width="50%">首长批示(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("23".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m21_2" value="23" onclick="chkItsParent('m21',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;领导讲话</td>
    <td class="input" width="50%">领导讲话(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("24".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m21_3" value="24" onclick="chkItsParent('m21',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通知通告</td>
    <td class="input" width="50%">通知通告(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("25".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	<input type="checkbox" name="menuid" id="m25" value="25" onclick="chkAllSub('m25')" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">法规制度</td>
    <td class="input" width="50%">法规制度(一级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("26".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m25_1" value="26" onclick="chkItsParent('m25',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上级政策</td>
    <td class="input" width="50%">上级政策(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("27".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m25_2" value="27" onclick="chkItsParent('m25',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本级法规</td>
    <td class="input" width="50%">本级法规(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("28".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m25_3" value="28" onclick="chkItsParent('m25',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内部资料</td>
    <td class="input" width="50%">内部资料(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("29".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	<input type="checkbox" name="menuid" id="m29" value="29" onclick="chkAllSub('m29')" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">典型案例</td>
    <td class="input" width="50%">典型案例(一级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("30".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_1" value="30" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;被敌策反卖密</td>
    <td class="input" width="50%">被敌策反卖密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("31".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_2" value="31" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;违规联网泄密</td>
    <td class="input" width="50%">违规联网泄密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("32".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_3" value="32" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;载体转网失秘</td>
    <td class="input" width="50%">载体转网失秘(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("33".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_4" value="33" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管控不利丢密</td>
    <td class="input" width="50%">管控不利丢密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("34".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_5" value="34" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机违规传密</td>
    <td class="input" width="50%">手机违规传密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("35".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_6" value="35" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学术研究宣密</td>
    <td class="input" width="50%">学术研究宣密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("36".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_7" value="36" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退休退役带密</td>
    <td class="input" width="50%">退休退役带密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("37".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_8" value="37" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上网无意炫密</td>
    <td class="input" width="50%">上网无意炫密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("38".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_9" value="38" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;随意租传享密</td>
    <td class="input" width="50%">随意租传享密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("39".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>		
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m29_10" value="39" onclick="chkItsParent('m29',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;违规传递漏密</td>
    <td class="input" width="50%">违规传递漏密(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("10".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	<input type="checkbox" name="menuid" id="m6" value="10" onclick="chkAllSub('m6')" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">系统管理</td>
    <td class="input" width="50%">系统管理(一级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("15".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m6_5" value="15" onclick="chkItsParent('m6',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;组织管理</td>
    <td class="input" width="50%">组织管理(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("11".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m6_1" value="11" onclick="chkItsParent('m6',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户管理</td>
    <td class="input" width="50%">用户管理(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("12".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m6_2" value="12" onclick="chkItsParent('m6',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权限管理</td>
    <td class="input" width="50%">权限管理(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("14".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m6_4" value="14" onclick="chkItsParent('m6',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统备份与恢复</td>
    <td class="input" width="50%">系统备份与恢复(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("16".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	<input type="checkbox" name="menuid" id="m7" value="16" onclick="chkAllSub('m7')" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">文章管理</td>
    <td class="input" width="50%">文章管理(一级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("17".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m7_1" value="17" onclick="chkItsParent('m7',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上级精神</td>
    <td class="input" width="50%">上级精神(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("18".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m7_2" value="18" onclick="chkItsParent('m7',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法规制度</td>
    <td class="input" width="50%">法规制度(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("19".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m7_3" value="19" onclick="chkItsParent('m7',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;典型案例</td>
    <td class="input" width="50%">典型案例(二级菜单)</td>
</tr>
<tr>
	<td class="item" width="20%" nowrap>
	<%
		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("120".equals(list.get(i))){
				b_flag = true;
			}
		}
	%>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menuid" id="m7_4" value="20" onclick="chkItsParent('m7',this)" <%if(b_flag){ %>checked<%} %>></td>
	<td class="input" width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学习交流</td>
    <td class="input" width="50%">学习交流(二级菜单)</td>
</tr>
</syntc:HtmlTable> 
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function funSave() {
    document.form1.action = "UserRightSave.do";
    document.form1.submit();
}

function funReturn() {
    document.form1.action = "UserRight.do";
    document.form1.submit();
}

function initHTML(){
	<%
	    String str_PopMsg = StringUtil.convertNull((String)request.getAttribute("pop_Msg"));
	    if (!str_PopMsg.equals("")){
	%>
	    alert("<%=str_PopMsg%>");
	<%
	    }
	%>
}

//选择所有子菜单
function chkAllSub(id){
	var parent = document.getElementById(id);
	if(parent.checked){
		if("m5" == id){
			document.getElementById("m5_1").checked = true;
			document.getElementById("m5_2").checked = true;
			document.getElementById("m5_3").checked = true;
			document.getElementById("m5_4").checked = true;
		}
		if("m6" == id){
			document.getElementById("m6_1").checked = true;
			document.getElementById("m6_2").checked = true;
			document.getElementById("m6_4").checked = true;
			document.getElementById("m6_5").checked = true;
		}
		if("m7" == id){
			document.getElementById("m7_1").checked = true;
			document.getElementById("m7_2").checked = true;
			document.getElementById("m7_3").checked = true;
			document.getElementById("m7_4").checked = true;
		}
		if("m21" == id){
			document.getElementById("m21_1").checked = true;
			document.getElementById("m21_2").checked = true;
			document.getElementById("m21_3").checked = true;
		}
		if("m25" == id){
			document.getElementById("m25_1").checked = true;
			document.getElementById("m25_2").checked = true;
			document.getElementById("m25_3").checked = true;
		}
		if("m29" == id){
			document.getElementById("m29_1").checked = true;
			document.getElementById("m29_2").checked = true;
			document.getElementById("m29_3").checked = true;
			document.getElementById("m29_4").checked = true;
			document.getElementById("m29_5").checked = true;
			document.getElementById("m29_6").checked = true;
			document.getElementById("m29_7").checked = true;
			document.getElementById("m29_8").checked = true;
			document.getElementById("m29_9").checked = true;
			document.getElementById("m29_10").checked = true;
		}
	}else{
		if("m5" == id){
			document.getElementById("m5_1").checked = false;
			document.getElementById("m5_2").checked = false;
			document.getElementById("m5_3").checked = false;
			document.getElementById("m5_4").checked = false;
		}
		if("m6" == id){
			document.getElementById("m6_1").checked = false;
			document.getElementById("m6_2").checked = false;
			document.getElementById("m6_4").checked = false;
			document.getElementById("m6_5").checked = false;
		}
		if("m7" == id){
			document.getElementById("m7_1").checked = false;
			document.getElementById("m7_2").checked = false;
			document.getElementById("m7_3").checked = false;
			document.getElementById("m7_4").checked = false;
		}
		if("m21" == id){
			document.getElementById("m21_1").checked = false;
			document.getElementById("m21_2").checked = false;
			document.getElementById("m21_3").checked = false;
		}
		if("m25" == id){
			document.getElementById("m25_1").checked = false;
			document.getElementById("m25_2").checked = false;
			document.getElementById("m25_3").checked = false;
		}
		if("m29" == id){
			document.getElementById("m29_1").checked = false;
			document.getElementById("m29_2").checked = false;
			document.getElementById("m29_3").checked = false;
			document.getElementById("m29_4").checked = false;
			document.getElementById("m29_5").checked = false;
			document.getElementById("m29_6").checked = false;
			document.getElementById("m29_7").checked = false;
			document.getElementById("m29_8").checked = false;
			document.getElementById("m29_9").checked = false;
			document.getElementById("m29_10").checked = false;
		}
	}
}
//选择他的父菜单
function chkItsParent(parent,node){
	if(node.checked){
		if("m5" == parent){
			document.getElementById("m5").checked = true;
		}
		if("m6" == parent){
			document.getElementById("m6").checked = true;
		}
		if("m7" == parent){
			document.getElementById("m7").checked = true;
		}
		if("m21" == parent){
			document.getElementById("m21").checked = true;
		}
		if("m25" == parent){
			document.getElementById("m25").checked = true;
		}
		if("m29" == parent){
			document.getElementById("m29").checked = true;
		}
	}else{
		if("m5" == parent){
			if(document.getElementById("m5_1").checked==false &&
			   document.getElementById("m5_2").checked==false &&
			   document.getElementById("m5_3").checked==false &&
			   document.getElementById("m5_4").checked==false){
			   document.getElementById("m5").checked = false;
			}
		}
		if("m6" == parent){
			if(document.getElementById("m6_1").checked==false &&
			   document.getElementById("m6_2").checked==false &&
			   document.getElementById("m6_3").checked==false &&
			   document.getElementById("m6_4").checked==false){
			   document.getElementById("m6").checked = false;
			}
		}
		if("m7" == parent){
			if(document.getElementById("m7_1").checked==false &&
			   document.getElementById("m7_2").checked==false &&
			   document.getElementById("m7_3").checked==false &&
			   document.getElementById("m7_4").checked==false){
			   document.getElementById("m7").checked = false;
			}
		}
		if("m21" == parent){
			if(document.getElementById("m21_1").checked==false &&
			   document.getElementById("m21_2").checked==false &&
			   document.getElementById("m21_3").checked==false){
			   document.getElementById("m21").checked = false;
			}
		}
		if("m25" == parent){
			if(document.getElementById("m25_1").checked==false &&
			   document.getElementById("m25_2").checked==false &&
			   document.getElementById("m25_3").checked==false){
			   document.getElementById("m25").checked = false;
			}
		}
		if("m29" == parent){
			if(document.getElementById("m29_1").checked==false &&
			   document.getElementById("m29_2").checked==false &&
			   document.getElementById("m29_3").checked==false &&
			   document.getElementById("m29_4").checked==false &&
			   document.getElementById("m29_5").checked==false &&
			   document.getElementById("m29_6").checked==false &&
			   document.getElementById("m29_7").checked==false &&
			   document.getElementById("m29_8").checked==false &&
			   document.getElementById("m29_9").checked==false &&
			   document.getElementById("m29_10").checked==false){
			   document.getElementById("m29").checked = false;
			}
		}
	}
}
</script>
</html>