<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title>接收单位选择</title>
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
<syntc:TableTitle header="现有接受单位" >
<syntc:TableHeader />
<syntc:ButtonBase	caption="关	闭"	width="40" onclick="window.close()" />
<syntc:TableFoot />
</syntc:TableTitle>

<syntc:HtmlTable>
  <tr class="title">
    <th class=nm>单位名称</th>
  </tr>
<%
if(res.size() > 1){
	for(int i=1;i<res.size();i++) {
		String str_jsdwName = StringUtil.convertNull(res.getCell("jsdw_name",i));

%>
	<tr>
    <td nowrap class="nm"
				style="cursor:hand;" 
				onMouseOver='this.bgColor=colorHot'
				onMouseOut ='this.bgColor=colorNm'
			  onclick="funSetCompany('<%=str_jsdwName%>')">
				<%=str_jsdwName%></td>
  </tr>
<%
	}
}
else{%>
	<syntc:DataIsNull cols="1" />
<%}%>

</syntc:HtmlTable>

</form>

</body>


<script	language="JavaScript">
function funSetCompany(name){
  window.returnValue=name;
  window.close();
}
</script>
</html>
