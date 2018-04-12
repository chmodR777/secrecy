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
	String memTypeOptionList = (String) request.getAttribute("memTypeOptionList");
	String sexOptionList = (String) request.getAttribute("sexOptionList");
	String mediaTypeOptionList = (String) request.getAttribute("mediaTypeOptionList");
	String companyOptionList = (String) request.getAttribute("companyOptionList");
	String provinceOptionList = (String) request.getAttribute("provinceOptionList");
	String cityOptionList = (String) request.getAttribute("cityOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	Map provinceCityMap = (Map) request.getAttribute("provinceCityMap");
	
	// 查询条件-会员编号
	String p_MemCode = StringUtil.getRequestData(request.getParameter("txtMemCode"), "");
	// 查询条件-姓名
	String p_Name = StringUtil.getRequestData(request.getParameter("txtName"), "");
	// 查询条件-年龄
	String p_AgeMin = StringUtil.getRequestData(request.getParameter("txtAgeMin"), "");
	String p_AgeMax = StringUtil.getRequestData(request.getParameter("txtAgeMax"), "");
	// 查询条件-所在地区-省
	String p_Province = StringUtil.getRequestData(request.getParameter("txtProvince"), "");
	// 查询条件-手机
	String p_Mobile = StringUtil.getRequestData(request.getParameter("txtMobile"), "");
	// 查询条件-身份证号
	String p_IDCard = StringUtil.getRequestData(request.getParameter("txtIDCard"), "");
	// 查询条件-累计积分
	String p_TotalScoreMin = StringUtil.getRequestData(request.getParameter("txtTotalScoreMin"), "");
	String p_TotalScoreMax = StringUtil.getRequestData(request.getParameter("txtTotalScoreMax"), "");
%>
<syntc:TitleHeader header="患者信息管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="PatientManage.do">
<syntc:FuncHeader header="患者信息管理" showall="yes"/>
<br>
<syntc:TableTitle header="请输入用户查询的条件">
<syntc:TableHeader />
<syntc:QueryButton/>
<syntc:TableFoot />
</syntc:TableTitle>
<div id="queryPage">
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>会员编号：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="txtMemCode" value="<%=p_MemCode%>">
    </td>
	<td class="item" width="20%" nowrap>姓名：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="txtName" value="<%=p_Name%>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>性别：</td>
	<td class="input" nowrap>
      <select name="txtSex">
        <option value="">--请选择--</option>
        <%=sexOptionList%>
      </select>
    </td>
    <td class="item" nowrap>年龄：</td>
	<td class="input" nowrap>
      <input type="text" name="txtAgeMin" size="10" value="<%=p_AgeMin%>">－<input type="text" name="txtAgeMax" size="10" value="<%=p_AgeMax%>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>所在地区：</td>
	<td class="input" nowrap>
      <select name="txtProvince" onchange="javascript:getCityOptionList(this.options[this.selectedIndex].value);">
        <option value="">--请选择--</option>
        <%=provinceOptionList%>
      </select>
	  <select name="txtCity">
        <option value="">--请选择--</option>
        <%=cityOptionList%>
      </select>
    </td>
    <td class="item" nowrap>手机：</td>
	<td class="input" nowrap>
      <input type="text" name="txtMobile" value="<%=p_Mobile%>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>媒体方式：</td>
	<td class="input" nowrap>
      <select name="txtMediaType">
        <option value="">--请选择--</option>
        <%=mediaTypeOptionList%>
      </select>
    </td>
    <td class="item" nowrap>合同单位：</td>
	<td class="input" nowrap>
      <select name="txtCompany">
        <option value="">--请选择--</option>
        <%=companyOptionList%>
      </select>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>会员类别：</td>
	<td class="input" nowrap>
      <select name="txtMemType">
		<option value="">--请选择--</option>
       	<%=memTypeOptionList%>
      </select>
    </td>
    <td class="item" nowrap>身份证号：</td>
	<td class="input" nowrap>
      <input type="text" name="txtIDCard" value="<%=p_IDCard%>">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>累计积分：</td>
	<td class="input" nowrap>
      <input type="text" name="txtTotalScoreMin" size="10" value="<%=p_TotalScoreMin%>">－<input type="text" name="txtTotalScoreMax" size="10" value="<%=p_TotalScoreMax%>">
    </td>
  </tr>
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="患者信息列表" >
<syntc:TableHeader />
<syntc:NewButton/>
<syntc:ModifyButton/>
<syntc:DeleteButton/>
<syntc:ButtonBase caption="导出查询结果" width="75" onclick="funExportQueryResult();" />
<syntc:ButtonBase caption="病历信息管理" width="75" onclick="funIllManage();" />
<syntc:TableFoot />
</syntc:TableTitle>   
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap width="1%">操作</th>
		  <th class="nm" nowrap>会员编号</th>
          <th class="nm" nowrap>姓名</th>
          <th class="nm" nowrap>性别</th>
          <th class="nm" nowrap>年龄</th>
          <th class="nm" nowrap>所在地区</th>
          <th class="nm" nowrap>手机</th>
		  <th class="nm" nowrap>媒体方式</th>
		  <th class="nm" nowrap>合同单位</th>
		  <th class="nm" nowrap>会员类别</th>
		  <th class="nm" nowrap>累计积分</th>
        </tr>
<%
if (res.size() > 1) {
	for (int i = 1; i < res.size(); i++) {
		//ID
		String str_ID = StringUtil.convertNull(res.getCell("C_ID", i));
		//会员编号
		String str_MemCode = StringUtil.convertNull(res.getCell("C_MEMCODE", i));
		if (str_MemCode.length() == 0) {
			str_MemCode = "&nbsp;";
		}
		//姓名
		String str_Name = StringUtil.convertNull(res.getCell("C_NAME", i));
		if (str_Name.length() == 0) {
			str_Name = "&nbsp;";
		}
		//性别
		String str_Sex = StringUtil.convertNull(res.getCell("C_SEX", i));
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
		String str_Age = StringUtil.convertNull(res.getCell("C_AGE", i));
		if (str_Age.length() == 0) {
			str_Age = "&nbsp;";
		}
		//所在地区
		String str_Province = StringUtil.convertNull(res.getCell("C_PROVINCE", i));
		String str_City = StringUtil.convertNull(res.getCell("C_CITY", i));
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
		String str_Mobile = StringUtil.convertNull(res.getCell("C_MOBILE", i));
		if (str_Mobile.length() == 0) {
			str_Mobile = "&nbsp;";
		}
		//媒体方式
		String str_MediaType = StringUtil.convertNull(res.getCell("C_MEDIATYPE", i));
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
		String str_Company = StringUtil.convertNull(res.getCell("C_COMPANY", i));
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
		String str_MemType = StringUtil.convertNull(res.getCell("C_TYPENAME", i));
		if (str_MemType.length() == 0) {
			str_MemType = "&nbsp;";
		}
		//累计积分
		String str_TotalScore = common.removeTailZero(StringUtil.convertNull(res.getCell("TOTALSCORE", i)));
%>
        <tr>
		  <td class="nm" nowrap><input type="radio" name="rad" value="<%=str_ID%>"></td>
		  <td class="nm" nowrap><%=str_MemCode%></td>
          <td class="nm" nowrap><%=str_Name%></td>
          <td class="nm" nowrap><%=str_Sex%></td>
          <td class="nm" nowrap><%=str_Age%></td>
          <td class="nm" nowrap><%=str_Area%></td>
          <td class="nm" nowrap><%=str_Mobile%></td>
		  <td class="nm" nowrap><%=str_MediaType%></td>
          <td class="nm" nowrap><%=str_Company%></td>
          <td class="nm" nowrap><%=str_MemType%></td>
          <td class="nm" nowrap><%=str_TotalScore%></td>
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
	document.form1.action = "PatientAdd.do";
	document.form1.submit();
}

function funModify(){
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "PatientModify.do?patient_id=" + radValue;
        document.form1.submit();
    }
}

function funDelele(){
	if (checkRadioValue('rad')) {
        if (confirm("您确认要删除数据吗？")) {
            var radValue = getRadioValue(document.getElementsByName('rad'));
            //清空查询条件
            form1.txtMemCode.value = "";
            form1.txtName.value = "";
            form1.txtSex.value = "";
            form1.txtAgeMin.value = "";
            form1.txtAgeMax.value = "";
            form1.txtProvince.value = "";
            form1.txtCity.value = "";
            form1.txtMobile.value = "";
            form1.txtMediaType.value = "";
            form1.txtCompany.value = "";
            form1.txtMemType.value = "";
            form1.txtIDCard.value = "";
            form1.txtTotalScoreMin.value = "";
            form1.txtTotalScoreMax.value = "";
            document.form1.action = "PatientDel.do?patient_id=" + radValue;
            document.form1.submit();
        }
    }
}

function funQuery(){
	document.form1.action = "PatientManage.do";
	document.form1.submit();
}

function funIllManage() {
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "IllManage.do?patient_id=" + radValue;
        document.form1.submit();
    }
}

function getCityOptionList(province) {
	//清空市下拉列表
	document.all.txtCity.length = 0; 
	document.all.txtCity.options[0] = new Option("--请选择--", "");
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
			document.all.txtCity.options[document.all.txtCity.length] = new Option('<%=cityInfo[1]%>', '<%=cityInfo[0]%>');
			<%
			}
			%>
		}	
	<%		
		}
	%>
}

function funExportQueryResult() {
	document.form1.action = "PatientExport.do";
    document.form1.submit();
}
</SCRIPT>  
</body>
</html>