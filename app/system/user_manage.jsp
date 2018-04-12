<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html> 
<head>
<title></title>
</head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<%
	ResultObj res = (ResultObj) request.getAttribute("res");
	String orgOptionList = (String) request.getAttribute("orgOptionList");

	// 查询条件-用户名
	String p_UserCode = StringUtil.getRequestData(request.getParameter("txtUserCode"), "");
	// 查询条件-姓名
	String p_UserName = StringUtil.getRequestData(request.getParameter("txtUserName"), "");
	// 查询条件-性别
	String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"), "");
	// 查询条件-联系电话
	String p_Tel = StringUtil.getRequestData(request.getParameter("txtTel"), "");
	// 查询条件-所在组织
	String p_Org = StringUtil.getRequestData(request.getParameter("txtOrg"), "");
	// 查询条件-备注
	String p_Remark = StringUtil.getRequestData(request.getParameter("txtRemark"), "");
%>
<syntc:TitleHeader header="系统管理	>> 用户管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="UserManage.do">
<syntc:FuncHeader header="用户管理" showall="yes"/>
<br>
<syntc:TableTitle header="请输入用户查询的条件">
<syntc:TableHeader />
<syntc:QueryButton/>
<syntc:TableFoot />
</syntc:TableTitle>
<div id="queryPage">
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>用户名：</td>
	<td class="input" width="30%">
      <input type="text" name="txtUserCode" value="<%=p_UserCode%>">
    </td>
	<td class="item" width="20%" nowrap>姓名：</td>
	<td class="input" width="30%">
      <input type="text" name="txtUserName" value="<%=p_UserName%>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>性别：</td>
	<td class="input">
      <select name="txtSex">
        <option value="">--请选择--</option>
        <option value="1" <%if (p_Sex.equals("1")) {%>selected<%}%>>男</option>
        <option value="0" <%if (p_Sex.equals("0")) {%>selected<%}%>>女</option>
      </select>
    </td>
    <td class="item" nowrap>联系电话：</td>
	<td class="input">
      <input type="text" name="txtTel" value="<%=p_Tel%>">
    </td>
  </tr>
  <tr>
    <td class="item" width="20%" nowrap>所在组织：</td>
	<td class="input" width="30%">
      <select name="txtOrg">
		<option value="">--请选择--</option>
       	<%=orgOptionList%>
      </select>
    </td>
    <td class="item" width="20%" nowrap>备注：</td>
	<td class="input" width="30%">
      <input type="text" name="txtRemark" value="<%=p_Remark%>">
    </td>
  </tr> 
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="用户列表" >
<syntc:TableHeader />
<syntc:NewButton/>
<syntc:ModifyButton/>
<syntc:DeleteButton/>
<syntc:TableFoot />
</syntc:TableTitle>   
      <!-- 列表例子 -->
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap width="1%">操作</th>
		  <th class="nm" nowrap>用户名</th>
          <th class="nm" nowrap>姓名</th>
          <th class="nm" nowrap>性别</th>
          <th class="nm" nowrap>联系电话</th>
          <th class="nm" nowrap>所在组织</th>
        </tr>
<%
if(res.size() > 1){
	for (int i = 1; i < res.size(); i++) {
		//取得id
		String str_id = StringUtil.convertNull(res.getCell("C_ID", i));
		//取得用户编号
		String str_userCode = StringUtil.convertNull(res.getCell("C_CODE", i));
		//取得姓名
		String str_userName = StringUtil.convertNull(res.getCell("C_NAME", i));
		//取得性别
		String str_sexCode = StringUtil.convertNull(res.getCell("C_SEX", i));
		String str_sex = "&nbsp;";
		if ("1".equals(str_sexCode)) {
			str_sex = "男";
		} else if ("0".equals(str_sexCode)) {
			str_sex = "女";
		}
		//取得联系电话
		String str_tel = StringUtil.convertNull(res.getCell("C_TEL", i));
		if (str_tel.length() == 0) {
			str_tel = "&nbsp;";
		}
		//取得所在部门
		String str_dep = StringUtil.convertNull(res.getCell("C_ORG", i));
		if (str_dep.length() == 0) {
			str_dep = "&nbsp;";
		}
		//是否管理员
		String str_roletype = StringUtil.convertNull(res.getCell("C_ROLETYPE", i));
		if("1".equals(str_roletype)){
			str_roletype = "&nbsp;&nbsp;<font color=red>(管理员)</font>";
		} else {
			str_roletype = "";
		}
%>
        <tr>
		  <td class="nm" nowrap><input type="radio" name="rad" value="<%=str_id%>"></td>
		  <td class="nm" nowrap><%=str_userCode%><%=str_roletype %></td>
          <td class="nm" nowrap><%=str_userName%></td>
          <td class="nm" nowrap><%=str_sex%></td>
          <td class="nm" nowrap><%=str_tel%></td>
          <td class="nm" nowrap><%=str_dep%></td>
        </tr>
<%		}
	}
%>
</syntc:HtmlTable>
<syntc:listfooter/>
</form>
<syntc:TitleFoot />    
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">
function funNew(){
	document.form1.action = "UserAdd.do";
	document.form1.submit();
}

function funModify(){
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "UserModify.do?user_id=" + radValue;
        document.form1.submit();
    }
}

function funDelele(){
	if (checkRadioValue('rad')) {
        if (confirm("您确认要删除数据吗？")) {
            var radValue = getRadioValue(document.getElementsByName('rad'));
            document.form1.action = "UserDel.do?user_id=" + radValue;
            document.form1.submit();
        }
    }
}
function funQuery(){
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
</SCRIPT>

