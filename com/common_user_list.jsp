<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />
</head>
<body topmargin=0 leftmargin=0 >


<!-- 通用导航条	-->
<syntc:TitleHeader header="人员选择 >> 人员列表" />
<%
	ResultObj res = (ResultObj)request.getAttribute("res");

%>
<form	name="form1" action="" method="post">
<br>
<br>

<!-- 按钮定义例子	-->
<syntc:TableTitle header="选择人员" >
<syntc:TableHeader/>
<!--syntc:ReturnButton/-->
<syntc:ButtonBase	caption="返 回"	width="40" onclick="myback()"/>
<syntc:TableFoot/>
</syntc:TableTitle>
<syntc:HtmlTable id="tableid">
<tr class="title">
  <th class="nm" width="100%">姓名</th>
</tr>
<%
	if(res.size() > 1){
	for(int i=1; i<res.size();i++){
		//取得code
		String str_userCode = StringUtil.convertNull(res.getCell("user_code",i));
		//取得姓名
		String str_userName = StringUtil.convertNull(res.getCell("user_name",i));
%>
<tr>
  <td width="100%" class=nm style="cursor:hand;" 
				onMouseOver='this.bgColor=colorHot'
				onMouseOut ='this.bgColor=colorNm' onclick="myselect('<%=str_userName%>')"><%=str_userName%>
  </td>   
</tr> 
<% }
}else{
%>
<syntc:DataIsNull cols="2"/>
<% } %>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<SCRIPT LANGUAGE="JavaScript">
var colorHot = "#ffeedd";
var colorNm = "#ffffff";
function myselect(name){
  window.returnValue=name;
  window.close();
}
function myback(){
	location.href="CommonSelDep.do";
}
</SCRIPT>
</html>
