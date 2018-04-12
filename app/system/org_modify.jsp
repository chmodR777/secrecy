<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>组织修改页面</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="系统管理 >> 组织管理 >> 修改" />
<syntc:FuncHeader header="组织修改" showall="yes"/>
<br>

<syntc:TableTitle header="">
<syntc:TableHeader />
<syntc:SaveButton/>
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res = (ResultObj)request.getAttribute("res");

String str_ID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strORG_NAME = StringUtil.convertNull(res.getCell("C_NAME", 1));
%>
<syntc:HtmlTable>
   <tr>
    <td class="item" width="20%" nowrap>组织名称：</td>
	<td class="input" width="30%">
      <input type="text" name="txtORG_NAME" len="256" value="<%=strORG_NAME %>">
      <input type="hidden" name="txtORG_ID"  value="<%=str_ID %>">
      <font color="red">*</font>
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkSubmit() {
    var maxLength = form1.txtORG_NAME.len;
    if (chkLthNul(form1.txtORG_NAME, "组织名称", maxLength)) {
        return false;
    }
		
    return true;
}

function funSave() {
    if (checkSubmit()) {
        document.form1.action = "OrgModifySave.do";
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "OrgManage.do";
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
</script>
</html>