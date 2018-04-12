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
	String hosTypeOptionList = (String) request.getAttribute("hosTypeOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	
	// 查询条件-挂号编号
	String p_Code = StringUtil.getRequestData(request.getParameter("txtCode"), "");
	// 查询条件-就诊类别
	String p_Type = StringUtil.getRequestData(request.getParameter("txtType"), "");
	// 查询条件-就诊金额
	String p_MoneyMin = StringUtil.getRequestData(request.getParameter("txtMoneyMin"), "");
	String p_MoneyMax = StringUtil.getRequestData(request.getParameter("txtMoneyMax"), "");
	// 查询条件-就诊时间
	String p_DateMin = StringUtil.getRequestData(request.getParameter("txtDateMin"), "");
	String p_DateMax = StringUtil.getRequestData(request.getParameter("txtDateMax"), "");
	// 查询条件-院方承担比例
	String p_PercentMin = StringUtil.getRequestData(request.getParameter("txtPercentMin"), "");
	String p_PercentMax = StringUtil.getRequestData(request.getParameter("txtPercentMax"), "");
	// 查询条件-积分
	String p_ScoreMin = StringUtil.getRequestData(request.getParameter("txtScoreMin"), "");
	String p_ScoreMax = StringUtil.getRequestData(request.getParameter("txtScoreMax"), "");
	// 查询条件-病例
	String p_Ill = StringUtil.getRequestData(request.getParameter("txtIll"), "");
%>
<syntc:TitleHeader header="患者信息管理 >> 病历信息管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="PatientManage.do">
<syntc:FuncHeader header="病历信息管理" showall="yes"/>
<br>
<syntc:TableTitle header="请输入用户查询的条件">
<syntc:TableHeader />
<syntc:QueryButton/>
<syntc:TableFoot />
</syntc:TableTitle>
<div id="queryPage">
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>挂号编号：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="txtCode" value="<%=p_Code%>">
    </td>
	<td class="item" width="20%" nowrap>就诊类别：</td>
	<td class="input" width="30%" nowrap>
      <select name="txtType">
        <option value="">--请选择--</option>
        <%=hosTypeOptionList%>
      </select>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>就诊金额：</td>
	<td class="input" nowrap>
      <input type="text" name="txtMoneyMin" size="10" value="<%=p_MoneyMin%>">－<input type="text" name="txtMoneyMax" size="10" value="<%=p_MoneyMax%>">
    </td>
    <td class="item" nowrap>就诊时间：</td>
	<td class="input" nowrap>
      <syntc:DateImg element="txtDateMin" value="<%=p_DateMin%>"/>－<syntc:DateImg element="txtDateMax" value="<%=p_DateMax%>"/>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>院方承担比例(%)：</td>
	<td class="input" nowrap>
      <input type="text" name="txtPercentMin" size="10" value="<%=p_PercentMin%>">－<input type="text" name="txtPercentMax" size="10" value="<%=p_PercentMax%>">
    </td>
    <td class="item" nowrap>积分：</td>
	<td class="input" nowrap>
      <input type="text" name="txtScoreMin" size="10" value="<%=p_ScoreMin%>">－<input type="text" name="txtScoreMax" size="10" value="<%=p_ScoreMax%>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>病历：</td>
	<td class="input" nowrap>
      <input type="text" name="txtIll" value="<%=p_Ill%>">
    </td>
  </tr>
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="患者信息">
<syntc:TableHeader />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res_patient = (ResultObj) request.getAttribute("res_patient");

String str_PatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
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
<syntc:TableTitle header="病历信息列表" >
<syntc:TableHeader />
<syntc:NewButton/>
<syntc:ModifyButton/>
<syntc:DeleteButton/>
<syntc:ButtonBase caption="导出查询结果" width="75" onclick="funExportQueryResult();" />
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>   
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap width="1%">操作</th>
		  <th class="nm" nowrap>挂号编号</th>
          <th class="nm" nowrap>就诊类别</th>
          <th class="nm" nowrap>就诊金额</th>
          <th class="nm" nowrap>就诊时间</th>
          <th class="nm" nowrap>院方承担比例(%)</th>
          <th class="nm" nowrap>积分</th>
		  <th class="nm" nowrap>操作人</th>
		  <th class="nm" nowrap>操作时间</th>
        </tr>
<%
if (res.size() > 1) {
	for (int i = 1; i < res.size(); i++) {
		//ID
		String str_ID = StringUtil.convertNull(res.getCell("C_ID", i));
		//挂号编号
		String str_Code = StringUtil.convertNull(res.getCell("C_CODE", i));
		if (str_Code.length() == 0) {
			str_Code = "&nbsp;";
		}
		//就诊类别
		String str_Type = StringUtil.convertNull(res.getCell("C_TYPE", i));
		if (str_Type.length() == 0) {
			str_Type = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(str_Type)) {
				str_Type = (String) optionItemMap.get(str_Type);
			} else {
				str_Type = "&nbsp;";
			}
		}
		//就诊金额
		String str_Money = StringUtil.convertNull(res.getCell("C_MONEY", i));
		if (str_Money.length() == 0) {
			str_Money = "&nbsp;";
		} else {
			str_Money = common.removeTailZero(str_Money);
		}
		//就诊时间
		String str_Date = StringUtil.convertNull(res.getCell("C_DATE", i));
		if (str_Date.length() == 0) {
			str_Date = "&nbsp;";
		}
		//院方承担比例(%)
		String str_Percent = StringUtil.convertNull(res.getCell("C_PERCENT", i));
		if (str_Percent.length() == 0) {
			str_Percent = "&nbsp;";
		} else {
			str_Percent = common.removeTailZero(str_Percent);
		}
		//积分
		String str_Score = common.removeTailZero(StringUtil.convertNull(res.getCell("SCORE", i)));
		//操作人
		String str_UserName = StringUtil.convertNull(res.getCell("USERNAME", i));
		if (str_UserName.length() == 0) {
			str_UserName = "&nbsp;";
		}
		//操作时间
		String str_OperTime = StringUtil.convertNull(res.getCell("C_OPERTIME", i));
		if (str_OperTime.length() == 0) {
			str_OperTime = "&nbsp;";
		} else {
			str_OperTime = str_OperTime.substring(0, 19);
		}
%>
        <tr>
		  <td class="nm" nowrap><input type="radio" name="rad" value="<%=str_ID%>"></td>
		  <td class="nm" nowrap><%=str_Code%></td>
          <td class="nm" nowrap><%=str_Type%></td>
          <td class="nm" nowrap><%=str_Money%></td>
          <td class="nm" nowrap><%=str_Date%></td>
          <td class="nm" nowrap><%=str_Percent%></td>
          <td class="nm" nowrap><%=str_Score%></td>
		  <td class="nm" nowrap><%=str_UserName%></td>
          <td class="nm" nowrap><%=str_OperTime%></td>
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
function funNew(){
	document.form1.action = "IllAdd.do?patient_id=<%=str_PatientID%>";
	document.form1.submit();
}

function funModify(){
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "IllModify.do?patient_id=<%=str_PatientID%>&ill_id=" + radValue;
        document.form1.submit();
    }
}

function funDelele(){
	if (checkRadioValue('rad')) {
        if (confirm("您确认要删除数据吗？")) {
            var radValue = getRadioValue(document.getElementsByName('rad'));
            //清空查询条件
            form1.txtCode.value = "";
            form1.txtType.value = "";
            form1.txtMoneyMin.value = "";
            form1.txtMoneyMax.value = "";
            form1.txtDateMin.value = "";
            form1.txtDateMax.value = "";
            form1.txtPercentMin.value = "";
            form1.txtPercentMax.value = "";
            form1.txtScoreMin.value = "";
            form1.txtScoreMax.value = "";
            form1.txtIll.value = "";
            document.form1.action = "IllDel.do?patient_id=<%=str_PatientID%>&ill_id=" + radValue;
            document.form1.submit();
        }
    }
}

function funQuery(){
	document.form1.action = "IllManage.do?patient_id=<%=str_PatientID%>";
	document.form1.submit();
}

function funReturn() {
	document.form1.action = "PatientManage.do";
    document.form1.submit();
}

function funExportQueryResult() {
	document.form1.action = "IllExport.do?patient_id=<%=str_PatientID%>";
    document.form1.submit();
}
</SCRIPT>  
</body>
</html>