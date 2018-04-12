<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>修改患者信息</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="患者信息管理 >> 修改" />
<syntc:FuncHeader header="患者信息修改" showall="yes"/>
<br>

<syntc:TableTitle header="">
<syntc:TableHeader />
<syntc:SaveButton/>
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res = (ResultObj)request.getAttribute("res");

String strID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strMemCode = StringUtil.convertNull(res.getCell("C_MEMCODE", 1));
String strName = StringUtil.convertNull(res.getCell("C_NAME", 1));
String strMobile = StringUtil.convertNull(res.getCell("C_MOBILE", 1));
String strIDCard = StringUtil.convertNull(res.getCell("C_IDCARD", 1));
String strAge = StringUtil.convertNull(res.getCell("C_AGE", 1));

String memTypeOptionList = (String) request.getAttribute("memTypeOptionList");
String sexOptionList = (String) request.getAttribute("sexOptionList");
String mediaTypeOptionList = (String) request.getAttribute("mediaTypeOptionList");
String companyOptionList = (String) request.getAttribute("companyOptionList");
String provinceOptionList = (String) request.getAttribute("provinceOptionList");
String cityOptionList = (String) request.getAttribute("cityOptionList");
Map provinceCityMap = (Map) request.getAttribute("provinceCityMap");

String userRoleType = UserBean.getRoleType();
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>会员编号：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="strMemCode" value="<%=strMemCode%>">
      <input type="hidden" name="strID" value="<%=strID%>">
      <font color="red">*</font>
    </td>
	<td class="item" width="20%" nowrap>姓名：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="strName" value="<%=strName%>">
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>性别：</td>
	<td class="input">
      <select name="strSex">
        <option value="">--请选择--</option>
        <%=sexOptionList%>
      </select>
      <font color="red">*</font>
    </td>
    <td class="item" nowrap>年龄：</td>
	<td class="input">
      <input type="text" name="strAge" value="<%=strAge%>">
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>所在地区：</td>
	<td class="input">
      <select name="strProvince" onchange="javascript:getCityOptionList(this.options[this.selectedIndex].value);">
        <option value="">--请选择--</option>
        <%=provinceOptionList%>
      </select>
	  <select name="strCity">
        <option value="">--请选择--</option>
        <%=cityOptionList%>
      </select>
      <font color="red">*</font>
    </td>
    <td class="item" nowrap>手机：</td>
	<td class="input">
	  <input type="text" name="strMobile" value="<%=strMobile%>">
	  <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>媒体方式：</td>
	<td class="input">
	  <select name="strMediaType">
        <option value="">--请选择--</option>
        <%=mediaTypeOptionList%>
      </select>
	  <font color="red">*</font>
    </td>
    <td class="item" nowrap>合同单位：</td>
	<td class="input">
      <select name="strCompany">
        <option value="">--请选择--</option>
        <%=companyOptionList%>
      </select>
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>会员类别：</td>
	<td class="input">
      <%if (userRoleType.equals("1")) { %>
	  	<select name="strMemType">
	       	<%=memTypeOptionList%>
	    </select>
	  <%} else { %>
	  	<select name="strMemType" disabled="disabled">
	       	<%=memTypeOptionList%>
	    </select>
	  <%} %>
      <font color="red">*</font>
    </td>
    <td class="item" nowrap>身份证号：</td>
	<td class="input">
      <input type="text" name="strIDCard" value="<%=strIDCard%>">
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkSubmit() {
	var maxLength = 32;
    if (chkLthNul(form1.strMemCode, "会员编号", maxLength)) {
        return false;
    }
    if (chkLthNul(form1.strName, "姓名", maxLength)) {
        return false;
    }
    if (chkNul(form1.strSex, "性别")) {
    	return false;
    }
    if (chkNul(form1.strAge, "年龄")) {
    	return false;
    }
    if (!NumValCheck(form1.strAge, 0, 9999, 0)) {
    	return false;
    }
    if (chkNul(form1.strProvince, "所在地区-省")) {
    	return false;
    }
    if (form1.strProvince.options[form1.strProvince.selectedIndex].value == 14 && chkNul(form1.strCity, "所在地区-市")) {
    	return false;
    }
	if (chkLthNul(form1.strMobile, "手机", maxLength)) {
	    return false;
	}
	if (chkNul(form1.strMediaType, "媒体方式")) {
    	return false;
    }
	if (chkNul(form1.strCompany, "合同单位")) {
    	return false;
    }
	<%if (userRoleType.equals("1")) { %>
	if (chkNul(form1.strMemType, "会员类别")) {
    	return false;
    }
	<%} else { %>
	if (bitLength(form1.strMemType.value) <= 0) {
	    alert("[会员类别]不能为空，请输入！");
	    return false;
	}
	<%} %>
    if (chkLth(form1.strIDCard, "身份证号", maxLength)) {
        return false;
    }
    return true;
}

function funSave() {
    if (checkSubmit()) {
        document.form1.action = "PatientModifySave.do";
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "PatientManage.do";
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

function getCityOptionList(province) {
	//清空市下拉列表
	document.all.strCity.length = 0; 
	document.all.strCity.options[0] = new Option("--请选择--", "");
	<%
		Iterator iter = provinceCityMap.keySet().iterator();
		String provinceID;
		while (iter.hasNext()) {
			provinceID = (String) iter.next();
	%>
		if (province == <%=provinceID%>) {
			<%
			List cityList = (List) provinceCityMap.get(provinceID);
			String[] cityInfo;
			for (int i = 0; i < cityList.size(); i++) {
				cityInfo = (String[]) cityList.get(i);
			%>
			document.all.strCity.options[document.all.strCity.length] = new Option('<%=cityInfo[1]%>', '<%=cityInfo[0]%>');
			<%
			}
			%>
		}	
	<%		
		}
	%>
}
</script>
</html>