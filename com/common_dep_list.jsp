<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />
</head>
<body topmargin=0 leftmargin=0>


<!-- 通用导航条	-->
<syntc:TitleHeader header="人员选择 >> 部门列表" />
<%
	ResultObj res = (ResultObj)request.getAttribute("res");
%>
<form	name="form1" action="" method="post" >
<br>
<br>

<!-- 按钮定义例子	-->
<syntc:TableTitle header="选择部门" >
<syntc:TableHeader/>
<syntc:ButtonBase	caption="关 闭"	width="40" onclick="myclose()"/>
<syntc:TableFoot/>
</syntc:TableTitle>
<syntc:HtmlTable id="tableid">
<tr class="title">
  <th class="nm">部门名称</th>
</tr>
<%
	if(res.size() > 1){
	for(int i=1; i<res.size();i++){
		//取得部门id
		String str_depID = StringUtil.convertNull(res.getCell("dep_code",i));
		//取得部门名称
		String str_depName = StringUtil.convertNull(res.getCell("dep_name",i));
%>
<tr>
  <td width="100%" class=nm style="cursor:hand;"
				onMouseOver='this.bgColor=colorHot'
				onMouseOut ='this.bgColor=colorNm' onclick="goPersonList('<%=str_depID%>')"><%=str_depName%>
  </td>   
</tr> 
<% }
}else{
%>
<syntc:DataIsNull cols="1"/>
<% } %>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>

<SCRIPT LANGUAGE="JavaScript">
var colorHot = "#ffeedd";
var colorNm = "#ffffff";
function goPersonList(code){
	location.href="CommonSelUser.do?code="+code;
}
function myclose(){
	window.close();
}

</SCRIPT>
</html>
