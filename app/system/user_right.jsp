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
String orgOptionList = (String) request.getAttribute("orgOptionList");

	//查询条件-用户名
	String p_UserCode = StringUtil.getRequestData(request.getParameter("txtUserCode"), "");
	// 查询条件-姓名
	String p_UserName = StringUtil.getRequestData(request.getParameter("txtUserName"), "");
	// 查询条件-性别
	String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"), "");
	// 查询条件-联系电话
	String p_Tel = StringUtil.getRequestData(request.getParameter("txtTel"), "");
	// 查询条件-所在部门
	String p_Dep = StringUtil.getRequestData(request.getParameter("txtDep"), "");
%>
<syntc:TitleHeader header="系统管理	>> 权限管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="UserRight.do">
<syntc:FuncHeader header="权限管理" showall="yes"/>
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
	<td class="item" width="20%" nowrap>&nbsp;</td>
	<td class="input" width="30%">&nbsp;</td>
  </tr> 
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="用户列表" >
<syntc:TableHeader />
<syntc:TableFoot />
</syntc:TableTitle>   
      <!-- 列表例子 -->
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap>用户名</th>
          <th class="nm" nowrap>姓名</th>
          <th class="nm" nowrap>性别</th>
          <th class="nm" nowrap>联系电话</th>
          <th class="nm" nowrap>所在组织</th>
          <th class="nm" nowrap width="1%">&nbsp;</th>
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
		//取得用户类型
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
		String str_org = StringUtil.convertNull(res.getCell("C_ORG", i));
		if (str_org.length() == 0) {
			str_org = "&nbsp;";
		}
%>
        <tr>
		  <td class="nm" nowrap><%=str_userCode%></td>
          <td class="nm" nowrap><%=str_userName%></td>
          <td class="nm" nowrap><%=str_sex%></td>
          <td class="nm" nowrap><%=str_tel%></td>
          <td class="nm" nowrap><%=str_org%></td>
          <td class="nm" nowrap><a href="#" onclick="uptRight('<%=str_id%>')">编辑权限</a></td>
        </tr>
<%		}
	}
%>
</syntc:HtmlTable>
<syntc:listfooter/>
</form>
<syntc:TitleFoot />  
<SCRIPT LANGUAGE="JavaScript">
function uptRight(userid){
	document.form1.action = "UserRightUpt.do?user_id="+userid;
	document.form1.submit();
}

function funQuery(){
	document.form1.action = "UserRight.do";
	document.form1.submit();
}
</SCRIPT>  
</body>
</html>
