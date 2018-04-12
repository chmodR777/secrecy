<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title>组织实施部门选择</title>
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
<input type="hidden" name="state">
<input type="hidden" name="actname" value="CommonZDCQDepList.do">

<syntc:TableTitle header="当前存在的组织实施部门" >
<syntc:TableHeader />
<syntc:ButtonBase	caption="关	闭"	width="40" onclick="window.close()" />
<syntc:TableFoot />
</syntc:TableTitle>

<syntc:HtmlTable>
  <tr class="title">
    <th class=nm>组织实施部门</th>
	<tr>
<%
if(res.size() > 1){
	for(int i=1;i<res.size();i++) {
		String strCQ_SECTION = StringUtil.convertNull(res.getCell("cq_section",i));

%>
	<tr>
    <td nowrap class="nm"
				style="cursor:hand;"
				onMouseOver='this.bgColor=colorHot'
				onMouseOut ='this.bgColor=colorNm'
			  onclick="funSetSection('<%=strCQ_SECTION%>')">
				<%=strCQ_SECTION%></td>
  </tr>
<%
	}
}
else{%>
	<syntc:DataIsNull cols="1" />
<%}%>

</syntc:HtmlTable>
<syntc:listfooter/>
</form>

</body>


<script	language="JavaScript">
function funSetSection(strCQ_SECTION){
  window.returnValue=strCQ_SECTION;
  window.close();
}
</script>
</html>