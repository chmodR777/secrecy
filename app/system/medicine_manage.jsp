<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html> 
<head>
<title></title>
</head>
<body topmargin=0 leftmargin=0>
<%
	ResultObj res = (ResultObj) request.getAttribute("res");
	
	// 查询条件-年月
	String p_Month = StringUtil.getRequestData(request.getParameter("txtMonth"), "");
%>
<syntc:TitleHeader header="邮药信息管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="MedicineManage.do">
<syntc:FuncHeader header="邮药信息管理" showall="yes"/>
<br>
<syntc:TableTitle header="请输入用户查询的条件">
<syntc:TableHeader />
<syntc:QueryButton/>
<syntc:TableFoot />
</syntc:TableTitle>
<div id="queryPage">
<syntc:HtmlTable>
  <tr>
    <td class="item" nowrap>年月：</td>
	<td class="input" colspan="3" nowrap>
      <input type="text" name="txtMonth" value="<%=p_Month%>">
    </td>
  </tr>
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="邮药信息列表" >
<syntc:TableHeader />
<syntc:ButtonBase caption="导入邮药信息" width="75" onclick="funImportConsultInfo();" />
<syntc:TableFoot />
</syntc:TableTitle>   
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap width="70%">年月</th>
          <th class="nm" nowrap width="30%">&nbsp;</th>
        </tr>
<%
if (res.size() > 1) {
	for (int i = 1; i < res.size(); i++) {
		//年月
		String str_Month = StringUtil.convertNull(res.getCell("C_MONTH", i));
		if (str_Month.length() == 0) {
			str_Month = "&nbsp;";
		}
%>
        <tr>
		  <td class="nm" nowrap><%=str_Month%></td>
          <td class="nm" nowrap><a href="#" onclick="funExportMedicineInfo('<%=str_Month%>')">导出邮药信息</a></td>
        </tr>
<%		
	}
}
%>
</syntc:HtmlTable>
<syntc:listfooter/>
</form>
<syntc:TitleFoot />  

<SCRIPT LANGUAGE="JavaScript">
function funQuery(){
	document.form1.action = "MedicineManage.do";
	document.form1.submit();
}

function funImportConsultInfo() {
	document.form1.action = "Medicine_jsp.do";
    document.form1.submit();
}

function funExportMedicineInfo(month) {
	document.form1.action = "MedicineExport.do?month=" + month;
    document.form1.submit();
}
</SCRIPT>  
</body>
</html>