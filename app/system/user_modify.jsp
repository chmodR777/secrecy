<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>用户信息修改页面</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="系统管理 >> 用户管理 >> 修改" />
<syntc:FuncHeader header="用户修改" showall="yes"/>
<br>

<syntc:TableTitle header="">
<syntc:TableHeader />
<syntc:SaveButton/>
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res = (ResultObj)request.getAttribute("res");

String strUSER_ID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strUSER_CODE = StringUtil.convertNull(res.getCell("C_CODE", 1));
String strUSER_NAME = StringUtil.convertNull(res.getCell("C_NAME", 1));
String strSEX = StringUtil.convertNull(res.getCell("C_SEX", 1));
String strTEL = StringUtil.convertNull(res.getCell("C_TEL", 1));
String strDEP = StringUtil.convertNull(res.getCell("C_DEP", 1));
String strROLETYPE = StringUtil.convertNull(res.getCell("C_ROLETYPE", 1));
String strREMARK = StringUtil.convertNull(res.getCell("C_REMARK", 1)).replaceAll("<br>", "\r");

String orgOptionList = (String) request.getAttribute("orgOptionList");
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>用户名(数字,字母,下划线)：</td>
	<td class="input" width="30%">
      <input type="text" name="txtUSER_CODE" value="<%=strUSER_CODE %>">
      <input type="hidden" name="txtUSER_ID" value="<%=strUSER_ID %>">
      <font color="red">*</font>
    </td>
	<td class="item" width="20%" nowrap>姓名：</td>
	<td class="input" width="30%">
      <input type="text" name="txtUSER_NAME" value="<%=strUSER_NAME %>">
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>性别：</td>
	<td class="input">
      <select name="txtSEX">
        <option value="">--请选择--</option>
        <option value="1" <%if (strSEX.equals("1")) {%>selected<%}%>>男</option>
        <option value="0" <%if (strSEX.equals("0")) {%>selected<%}%>>女</option>
      </select>
    </td>
    <td class="item" nowrap>联系电话：</td>
	<td class="input">
      <input type="text" name="txtTEL" value="<%=strTEL %>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>所在组织：</td>
    <td class="input">
  	  <select name="txtORG">
  	    <option value="">--请选择--</option>
       	<%=orgOptionList%>
      </select>
    </td>
    <td class="item" nowrap>是否管理员：</td>
	<td class="input">
      <select name="txtRoleType">
        <option value="1" <%if (strROLETYPE.equals("1")) {%>selected<%}%>>是</option>
        <option value="0" <%if (strROLETYPE.equals("0")) {%>selected<%}%>>否</option>
      </select><font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>备注：</td>
	<td class="input" colspan="3">
      <textarea name="txtREMARK" rows="3" cols="64"><%=strREMARK %></textarea>
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkUserCode(value){
	var reg = "^\\w+$";
	var flag = value.match(reg);
	return flag;
}
function checkSubmit() {
    if (chkLthNul(form1.txtUSER_CODE, "用户名", 32)) {
        return false;
    }else{
    	if(null == checkUserCode(form1.txtUSER_CODE.value)){
			alert("用户名只能为数字，字母，下划线!");
			return false;
    	}
    }
    if (chkLthNul(form1.txtUSER_NAME, "姓名", 32)) {
        return false;
    }
    maxLength = form1.txtTEL.len;
    if (chkLth(form1.txtTEL, "联系电话", 32)) {
        return false;
    }
    maxLength = form1.txtREMARK.len;
    if (chkLth(form1.txtREMARK, "备注", 1024)) {
        return false;
    }
    return true;
}

function funSave() {
    if (checkSubmit()) {
        document.form1.action = "UserModifySave.do";
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "UserManage.do";
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