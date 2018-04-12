<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>导入咨询信息</title></head>
<body topmargin=0 leftmargin=0>
<form name="form1" method="post" enctype="multipart/form-data">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="咨询信息管理 >> 导入咨询信息" />
<syntc:FuncHeader header="导入咨询信息" showall="yes"/>
<br>
<syntc:TableTitle header="">
<syntc:TableHeader />
<syntc:ButtonBase caption="导 入" onclick="funImport();" />
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>

<syntc:HtmlTable>
  <tr>
    <td class="item" nowrap>年月：</td>
	<td class="input" colspan="3">
      <syntc:DateImg element="strMonth" value=""/>
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>导入文件：</td>
    <td class="input" colspan="3">
      <input type="file" name="strFile" size="50">
      <font color="red">*</font>
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkSubmit() {
	if (chkNul(form1.strMonth, "年月")) {
    	return false;
    }
    if (chkNul(form1.strFile, "导入文件")) {
    	return false;
    }
    return true;
}

function funImport() {
    if (checkSubmit()) {
    	var strMonth = form1.strMonth.value;
    	document.form1.action = "ConsultImportSave.do?strMonth=" + strMonth;
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "ConsultManage.do";
    document.form1.submit();
}
</script>
</html>