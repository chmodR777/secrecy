<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>会员类别修改页面</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="系统管理 >> 会员类别管理 >> 修改" />
<syntc:FuncHeader header="会员类别修改" showall="yes"/>
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
String strTYPE_NAME = StringUtil.convertNull(res.getCell("C_TYPENAME", 1));
String strPERCENT = StringUtil.convertNull(res.getCell("C_PERCENT", 1));
if (strPERCENT.length() > 0) {
	strPERCENT = common.removeTailZero(strPERCENT);
}
String strSCORE = StringUtil.convertNull(res.getCell("C_SCORE", 1));
%>
<syntc:HtmlTable>
   <tr>
    <td class="item" width="20%" nowrap>会员类别名称：</td>
	<td class="input" width="30%">
      <input type="text" name="txtTYPE_NAME" len="64" value="<%=strTYPE_NAME %>">
      <input type="hidden" name="txtTYPE_ID"  value="<%=str_ID %>">
      <font color="red">*</font>
    </td>
	<td class="item" width="20%" nowrap>院方承担比例(%)：</td>
	<td class="input" width="30%">
      <input type="text" name="txtPERCENT" onkeypress="OnNumDotKeypress()" value="<%=strPERCENT %>" onfocus="this.style.imeMode='disabled'">
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>标准积分：</td>
	<td class="input">
      <input type="text" name="txtSCORE" onkeypress="OnNumKeypress()" value="<%=strSCORE %>" onfocus="this.style.imeMode='disabled'">
      <font color="red">*</font>
    </td>
    <td class="item" nowrap>&nbsp;</td>
	<td class="input">&nbsp;
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function chkNatureNum(num){
	var r = /^\+?[1-9][0-9]*$/;　　//正整数     
    return r.test(num);
}
function checkSubmit() {
    var maxLength = form1.txtTYPE_NAME.len;
    if (chkLthNul(form1.txtTYPE_NAME, "会员类别名称", maxLength)) {
        return false;
    }
    if (chkNul(form1.txtPERCENT, "院方承担比例")) {
    	return false;
    }
    if (!NumValCheck(form1.txtPERCENT, 2, 100, 0)) {
    	return false;
    }
	if (chkNul(form1.txtSCORE, "标准积分")) {
    	return false;
    }
    if (!NumValCheck(form1.txtSCORE, 0, 999999999, 0)) {
    	return false;
    }
		
    return true;
}

function funSave() {
    if (checkSubmit()) {
        document.form1.action = "MemTypeModifySave.do";
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "MemTypeManage.do";
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