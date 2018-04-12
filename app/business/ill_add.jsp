<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>添加病例信息</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<%
	String str_PatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
	String hosTypeOptionList = (String) request.getAttribute("hosTypeOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
%>
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="患者信息管理 >> 病历信息管理 >> 新建" />
<syntc:FuncHeader header="病历信息新建" showall="yes"/>
<br>
<syntc:TableTitle header="患者信息">
<syntc:TableHeader />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res_patient = (ResultObj) request.getAttribute("res_patient");

//会员编号
String str_MemCode = StringUtil.convertNull(res_patient.getCell("C_MEMCODE", 1));
if (str_MemCode.length() == 0) {
	str_MemCode = "&nbsp;";
}
//姓名
String str_Name = StringUtil.convertNull(res_patient.getCell("C_NAME", 1));
if (str_Name.length() == 0) {
	str_Name = "&nbsp;";
}
//性别
String str_Sex = StringUtil.convertNull(res_patient.getCell("C_SEX", 1));
if (str_Sex.length() == 0) {
	str_Sex = "&nbsp;";
} else {
	if (optionItemMap.containsKey(str_Sex)) {
		str_Sex = (String) optionItemMap.get(str_Sex);
	} else {
		str_Sex = "&nbsp;";
	}
}
//年龄
String str_Age = StringUtil.convertNull(res_patient.getCell("C_AGE", 1));
if (str_Age.length() == 0) {
	str_Age = "&nbsp;";
}
//所在地区
String str_Province = StringUtil.convertNull(res_patient.getCell("C_PROVINCE", 1));
String str_City = StringUtil.convertNull(res_patient.getCell("C_CITY", 1));
String str_Area = "";
if (str_Province != null && str_Province.length() > 0) {
	if (optionItemMap.containsKey(str_Province)) {
		str_Area = (String) optionItemMap.get(str_Province);
	}
}
if (str_City != null && str_City.length() > 0) {
	if (str_Area.length() > 0) {
		if (optionItemMap.containsKey(str_City)) {
			str_Area = str_Area + "-" + (String) optionItemMap.get(str_City);
		}
	}
}
if (str_Area.length() == 0) {
	str_Area = "&nbsp;";
}

//手机
String str_Mobile = StringUtil.convertNull(res_patient.getCell("C_MOBILE", 1));
if (str_Mobile.length() == 0) {
	str_Mobile = "&nbsp;";
}
//媒体方式
String str_MediaType = StringUtil.convertNull(res_patient.getCell("C_MEDIATYPE", 1));
if (str_MediaType.length() == 0) {
	str_MediaType = "&nbsp;";
} else {
	if (optionItemMap.containsKey(str_MediaType)) {
		str_MediaType = (String) optionItemMap.get(str_MediaType);
	} else {
		str_MediaType = "&nbsp;";
	}
}
//合同单位
String str_Company = StringUtil.convertNull(res_patient.getCell("C_COMPANY", 1));
if (str_Company.length() == 0) {
	str_Company = "&nbsp;";
} else {
	if (optionItemMap.containsKey(str_Company)) {
		str_Company = (String) optionItemMap.get(str_Company);
	} else {
		str_Company = "&nbsp;";
	}
}
//会员类别
String str_MemType = StringUtil.convertNull(res_patient.getCell("C_TYPENAME", 1));
if (str_MemType.length() == 0) {
	str_MemType = "&nbsp;";
}
//身份证号
String str_IDCard = StringUtil.convertNull(res_patient.getCell("C_IDCARD", 1));
if (str_IDCard.length() == 0) {
	str_IDCard = "&nbsp;";
}
//累计积分
String str_TotalScore = common.removeTailZero(StringUtil.convertNull(res_patient.getCell("TOTALSCORE", 1)));
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>会员编号：</td>
	<td class="input" width="30%" nowrap><%=str_MemCode%></td>
	<td class="item" width="20%" nowrap>姓名：</td>
	<td class="input" width="30%" nowrap><%=str_Name%></td>
  </tr>
  <tr>
    <td class="item" nowrap>性别：</td>
	<td class="input" nowrap><%=str_Sex%></td>
    <td class="item" nowrap>年龄：</td>
	<td class="input" nowrap><%=str_Age%></td>
  </tr>
  <tr>
    <td class="item" nowrap>所在地区：</td>
	<td class="input" nowrap><%=str_Area%></td>
    <td class="item" nowrap>手机：</td>
	<td class="input" nowrap><%=str_Mobile%></td>
  </tr>
  <tr>
    <td class="item" nowrap>媒体方式：</td>
	<td class="input" nowrap><%=str_MediaType%></td>
    <td class="item" nowrap>合同单位：</td>
	<td class="input" nowrap><%=str_Company%></td>
  </tr>
  <tr>
    <td class="item" nowrap>会员类别：</td>
	<td class="input" nowrap><%=str_MemType%></td>
    <td class="item" nowrap>身份证号：</td>
	<td class="input" nowrap><%=str_IDCard%></td>
  </tr>
  <tr>
    <td class="item" nowrap>累计积分：</td>
	<td class="input" nowrap><%=str_TotalScore%></td>
  </tr>
</syntc:HtmlTable>
<br>
<syntc:TableTitle header="病历信息">
<syntc:TableHeader />
<syntc:SaveButton/>
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>

<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>挂号编号：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="strCode">
      <font color="red">*</font>
    </td>
	<td class="item" width="20%" nowrap>就诊类别：</td>
	<td class="input" width="30%" nowrap>
      <select name="strType">
        <option value="">--请选择--</option>
        <%=hosTypeOptionList%>
      </select>
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>就诊金额：</td>
	<td class="input">
      <input type="text" name="strMoney">
      <font color="red">*</font>
    </td>
    <td class="item" nowrap>就诊时间：</td>
	<td class="input">
      <syntc:DateImg element="strDate" value=""/>
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>病历：</td>
    <td class="input" colspan="3">
      <textarea name="strIll" rows="15" cols="90"></textarea>
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkSubmit() {
    if (chkLthNul(form1.strCode, "挂号编号", 32)) {
        return false;
    }
    if (chkNul(form1.strType, "就诊类别")) {
    	return false;
    }
    if (chkNul(form1.strMoney, "就诊金额")) {
    	return false;
    }
    if (!NumValCheck(form1.strMoney, 2, 999999999, -999999999)) {
    	return false;
    }
    if (chkNul(form1.strDate, "就诊时间")) {
    	return false;
    }
    if (chkLth(form1.strIll, "病历", 4096)) {
        return false;
    }
    return true;
}

function funSave() {
    if (checkSubmit()) {
        document.form1.action = "IllAddSave.do?patient_id=<%=str_PatientID%>";
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "IllManage.do?patient_id=<%=str_PatientID%>";
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