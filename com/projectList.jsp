<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title>项目列表</title>
<syntc:ScriptsCommon />

<script	language="JavaScript">
var colorHot = "#ffeedd";
var colorNm = "#ffffff";
</script>
</head>
<body topmargin=18 leftmargin=18 >
<%
ResultObj res = (ResultObj)request.getAttribute("res");
%>

<form name="form1" action="" method="post">
<input type="hidden" name="actname1" value="">
<syntc:TableTitle header="项目列表" >
<syntc:TableHeader />
<td nowrap>&nbsp;</td>
<td nowrap aligh=right width=120>年度：
<select name=proyear1 style="font-size:11px" onchange="funSetYear()">
<%
	String strProYear = "";
	strProYear = StringUtil.convertNull(request.getParameter("proyear1"));
	if (strProYear.length() == 0) {
		java.util.Date now = new java.util.Date();
		strProYear = String.valueOf(now.getYear() + 1900);
	}

	for(int i=2007;i<=2015;i++){
		String theYear = String.valueOf(i);%>
	<option value="<%=theYear%>" <%if(strProYear.equals(theYear)){%>selected<%}%>><%=theYear%></option>
<%}%>
</select>
</td>
<td width=30 nowrap>&nbsp;</td>
<syntc:ButtonBase caption="关 闭"	width="40" onclick="window.close()" />
<syntc:TableFoot />
</syntc:TableTitle>

<syntc:HtmlTable>
  <tr class="title">
    <th class=nm nowrap width=80>分类</th>
    <th class=nm nowrap >项目名称</th>
	<th class=nm nowrap width=80>责任处室</th>
  </tr>
<%
if(res.size() > 1){
	for(int i=1;i<res.size();i++) {
		//取得项目编号
		String str_proID = StringUtil.convertNull(res.getCell("pro_id",i));
		//取得项目类型
		String str_proType = StringUtil.convertNull(res.getCell("pro_type",i),"&nbsp;");
		//取得项目名称
		String str_proName = StringUtil.convertNull(res.getCell("pro_name",i),"&nbsp;");
		//取得责任处室
		String str_depName = StringUtil.convertNull(res.getCell("dep_name",i),"&nbsp;");
%>
  <tr style="cursor:hand;"
				onMouseOver='this.bgColor=colorHot'
				onMouseOut ='this.bgColor=colorNm'
			  onclick="funClick('<%=str_proID%>','<%=str_proName%>')">
		<td class=nm><%=str_proType%></td>
    <td class=nm><%=str_proName%></td>
		<td class=nm><%=str_depName%></td>
  </tr>
<%
	}
}
else{
%>
	<syntc:DataIsNull cols="3" />
<%}%>

</syntc:HtmlTable>

</form>

</body>


<script	language="JavaScript">
function funSetYear(){
	document.form1.actname1.value="setyear1";
	document.form1.action="ProjectList.do";
	document.form1.submit();
}

function funClick(str_proID, str_proName){
    var arrayReturn = new Array(str_proID, str_proName);
    window.returnValue = arrayReturn;
    window.close();
}
</script>
</html>