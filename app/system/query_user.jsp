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
	String p_ILL_TypeOptionList = (String) request.getAttribute("p_ILL_TypeOptionList");
	String sexOptionList = (String) request.getAttribute("sexOptionList");
	String mediaTypeOptionList = (String) request.getAttribute("mediaTypeOptionList");
	String companyOptionList = (String) request.getAttribute("companyOptionList");
	String provinceOptionList = (String) request.getAttribute("provinceOptionList");
	String cityOptionList = (String) request.getAttribute("cityOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	Map provinceCityMap = (Map) request.getAttribute("provinceCityMap");
	
	
	//查询条件-会员编号
	String USER_ID = StringUtil.getRequestData(request.getParameter("USER_ID"),"");
	//查询条件-姓名
	String User_Name = StringUtil.getRequestData(request.getParameter("User_Name"),"");
	//查询条件-年龄
	String User_Age_From = StringUtil.getRequestData(request.getParameter("User_Age_From"),"");
	String User_Age_To = StringUtil.getRequestData(request.getParameter("User_Age_To"),"");
	//查询条件-身份证号
	String User_Card = StringUtil.getRequestData(request.getParameter("User_Card"),"");
	//查询条件-手机
	String User_Mobile = StringUtil.getRequestData(request.getParameter("User_Mobile"),"");
	//查询条件-合同单位
	String User_Depart = StringUtil.getRequestData(request.getParameter("User_Depart"),"");
	//查询条件-累计积分起始
	String User_Sunm_Beg = StringUtil.getRequestData(request.getParameter("User_Sunm_Beg"),"");
	//查询条件-累计积分结束
	String User_Sunm_End = StringUtil.getRequestData(request.getParameter("User_Sunm_End"),"");
	//查询条件-挂号编号
	String Ill_ID = StringUtil.getRequestData(request.getParameter("Ill_ID"),"");
	//查询条件-就诊金额起始
	String User_Money_From = StringUtil.getRequestData(request.getParameter("User_Money_From"),"");
	//查询条件-就诊金额结束
	String User_Money_To = StringUtil.getRequestData(request.getParameter("User_Money_To"),"");
	//查询条件-院方比例起始
	String User_Hos_From = StringUtil.getRequestData(request.getParameter("User_Hos_From"),"");
	//查询条件-院方比例结束
	String User_Hos_To = StringUtil.getRequestData(request.getParameter("User_Hos_To"),"");
	//查询条件-单次积分起始
	String User_Single_From = StringUtil.getRequestData(request.getParameter("User_Single_From"),"");
	//查询条件-单次积分结束
	String User_Single_To = StringUtil.getRequestData(request.getParameter("User_Single_To"),"");
	//查询条件-病历
	String User_ILL = StringUtil.getRequestData(request.getParameter("User_ILL"),"");
	// 查询条件-起始时间
	String User_DATE_From = StringUtil.getRequestData(request.getParameter("User_DATE_From"), "");
	//查询条件-结束时间
	String User_DATE_To = StringUtil.getRequestData(request.getParameter("User_DATE_To"), "");
%>
<syntc:TitleHeader header="患者信息查询" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="Query_Info.do">
<syntc:FuncHeader header="患者信息查询" showall="yes"/>
<br>
<syntc:TableTitle header="请输入用户查询的条件">
<syntc:TableHeader />
<syntc:QueryButton/>
<syntc:TableFoot />
</syntc:TableTitle>
<div id="queryPage">
<syntc:HtmlTable>
  <tr>
    <td class="item" width="5%" nowrap>会员编号：</td>
	<td class="input" width="20%" nowrap>
      <input type="text" name="USER_ID" value="<%=USER_ID %>">
    </td>
	<td class="item" width="5%" nowrap>姓名：</td>
	<td class="input" width="20%" nowrap>
      <input type="text" name="User_Name" value="<%=User_Name %>">
    </td>
    <td class="item" width="5%" nowrap>性别：</td>
	<td class="input" width="20%" nowrap>
      <select name="USER_Sex">
      <option value="">--请选择--</option>
      <%=sexOptionList%>
      </select>
    </td>
    <td class="item" width="5%" nowrap>手机：</td>
	<td class="input" width="20%" nowrap>
      <input type="text" name="User_Mobile" value="<%=User_Mobile %>">
    </td>
  </tr>
  <tr>
	<td class="item" nowrap>所在地区：</td>
	<td class="input" nowrap>
	<select name="User_PROVINCE" onchange="javascript:getCityOptionList(this.options[this.selectedIndex].value);">
        <option value="">--请选择--</option>
        <%=provinceOptionList%>
      </select>
      <select name="User_CITY">
        <option value="">--请选择--</option>
        <%=cityOptionList%>
      </select>
    </td>
    <td class="item" nowrap>媒体方式：</td>
	<td class="input" nowrap>
      <select name="USER_Media">
      <option value="">--请选择--</option>
        <%=mediaTypeOptionList%>
      </select>
    </td>
    <td class="item" nowrap>身份证号：</td>
	<td class="input" nowrap>
      <input type="text" name="User_Card" value="<%=User_Card %>">
    </td>
	<td class="item" nowrap>合同单位：</td>
	<td class="input" nowrap>
      <select name="User_Depart">
      <option value="">--请选择--</option>
        <%=companyOptionList%>
      </select>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>会员类别：</td>
	<td class="input" nowrap>
      <select name="USER_Type">
      <option value="">--请选择--</option>
       	<%=memTypeOptionList%>
      </select>
    </td>
    <td class="item" nowrap>累计积分：</td>
	<td class="input" nowrap>
      <input type="text" name="User_Sunm_Beg" value="<%=User_Sunm_Beg %>" size="6">－<input type="text" name="User_Sunm_End" value="<%=User_Sunm_End %>" size="6">
    </td>
	<td class="item" nowrap>挂号编号：</td>
	<td class="input" nowrap>
      <input type="text" name="Ill_ID" value="<%=Ill_ID %>">
    </td>
    <td class="item" nowrap>就诊类别：</td>
	<td class="input" nowrap>
      <select name="ILL_Type">
      <option value="">--请选择--</option>
       	<%=p_ILL_TypeOptionList%>
      </select>
    </td>
  </tr>
  <tr>

  </tr>
  <tr>
    <td class="item" nowrap>就诊金额：</td>
	<td class="input" nowrap>
      <input type="text" name="User_Money_From"  value="<%=User_Money_From %>" size="6">－<input type="text" name="User_Money_To" value="<%=User_Money_To %>" size="6">
    </td>
	<td class="item">院方承担比例(%)：</td>
	<td class="input" nowrap>
      <input type="text" name="User_Hos_From" value="<%=User_Hos_From %>" size="6">－<input type="text" name="User_Hos_To" value="<%=User_Hos_To %>" size="6">
    </td>
    <td class="item" nowrap>积分：</td>
	<td class="input" nowrap>
      <input type="text" name="User_Single_From" value="<%=User_Single_From %>" size="6">－<input type="text" name="User_Single_To" value="<%=User_Single_To %>" size="6">
    </td>
    <td class="item" nowrap>病历：</td>
	<td class="input" nowrap>
      <input type="text" name="User_ILL" value="<%=User_ILL %>">
    </td>
  </tr>
  
  <tr>
    <td class="item" nowrap>年龄：</td>
	<td class="input" nowrap>
      <input type="text" name="User_Age_From" value="<%=User_Age_From %>" size="6">－<input type="text" name="User_Age_To" value="<%=User_Age_To %>" size="6">
    </td>
    <td class="item" nowrap>就诊时间：</td>
	<td class="input" nowrap colspan="3">
      <syntc:DateImg element="User_DATE_From" value="<%=User_DATE_From %>"/>－<syntc:DateImg element="User_DATE_To" value="<%=User_DATE_To %>"/>
    </td>
    <td class="item" nowrap>&nbsp;</td>
	<td class="input" nowrap>&nbsp;</td>
  </tr>
  
</syntc:HtmlTable> 
</div>
<br>

<syntc:TableTitle header="患者信息列表" >
<syntc:TableHeader />
<syntc:ButtonBase caption="导出查询结果" width="75" onclick="download();" />
<syntc:TableFoot />
</syntc:TableTitle>   
      <!-- 列表例子 -->
      <syntc:HtmlTable>
        <tr class="title">
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
          <th class="nm" nowrap>挂号编号</th>
          <th class="nm" nowrap>就诊类别</th>
          <th class="nm" nowrap>就诊金额</th>
          <th class="nm" nowrap>就诊时间</th>
          <th class="nm">院方承担比例(%)</th>
          <th class="nm" nowrap>积分</th>
        </tr>
       
<%

if(res!=null){
	for (int i = 1; i < res.size(); i++) {
		//会员编号
		String C_MEMCODE = StringUtil.convertNull(res.getCell("C_MEMCODE", i));
		
		//取得姓名
		String C_NAME = StringUtil.convertNull(res.getCell("C_NAME", i));
		//性别
		String C_SEX = StringUtil.convertNull(res.getCell("C_SEX", i));
		if (C_SEX.length() == 0) {
			C_SEX = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(C_SEX)) {
				C_SEX = (String) optionItemMap.get(C_SEX);
			} else {
				C_SEX = "&nbsp;";
			}
		}
		//取得用户年龄
		String C_AGE = StringUtil.convertNull(res.getCell("C_AGE", i));
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
		//累计积分
		String SUM_MENOY = StringUtil.convertNull(res.getCell("MONEY", i));
		//挂号编号
		String C_CODE = StringUtil.convertNull(res.getCell("C_CODE", i));
		//就诊类别
		String C_TYPE = StringUtil.convertNull(res.getCell("C_TYPE", i));
		if (C_TYPE.length() == 0) {
			C_TYPE = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(C_TYPE)) {
				C_TYPE = (String) optionItemMap.get(C_TYPE);
			} else {
				C_TYPE = "&nbsp;";
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
		String C_DATE = StringUtil.convertNull(res.getCell("C_DATE", i));
		//院方承担比例(%)
		String str_Percent = StringUtil.convertNull(res.getCell("C_PERCENT", i));
		if (str_Percent.length() == 0) {
			str_Percent = "&nbsp;";
		} else {
			str_Percent = common.removeTailZero(str_Percent);
		}
		//积分
		String S_MONEY = StringUtil.convertNull(res.getCell("S_MONEY", i));
%>
		  <tr>
		  <td class="nm" nowrap><%=C_MEMCODE%> <% if(C_MEMCODE=="") %><%="&nbsp;"%></td>
		  <td class="nm" nowrap><%=C_NAME%> <% if(C_NAME=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=C_SEX%></td>
          <td class="nm" nowrap><%=C_AGE%> <% if(C_AGE=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=str_Area%> </td>
          <td class="nm" nowrap><%=str_Mobile%> <% if(str_Mobile=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=str_MediaType%> </td>
          <td class="nm" nowrap><%=str_Company%></td>
          <td class="nm" nowrap><%=str_MemType%> <% if(str_MemType=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=SUM_MENOY%> <% if(SUM_MENOY=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=C_CODE%> <% if(C_CODE=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=C_TYPE%></td>
          <td class="nm" nowrap><%=str_Money%></td>
          <td class="nm" nowrap><%=C_DATE%> <% if(C_DATE=="") %><%="&nbsp;"%></td>
          <td class="nm" nowrap><%=str_Percent%></td>
          <td class="nm" nowrap><%=S_MONEY%> <% if(S_MONEY=="") %><%="&nbsp;"%></td>
        </tr>
<%		}
	}
%>
</syntc:HtmlTable>
<syntc:listfooter/>
</form>
<syntc:TitleFoot />   

<SCRIPT LANGUAGE="JavaScript">
function funQuery(){
	document.form1.action = "Query_Info.do";
	document.form1.submit();
}

function download(){
	document.form1.action = "Query_Download.do";
	document.form1.submit();
}


function getCityOptionList(province) {
	//清空市下拉列表
	document.form1.User_CITY.length = 0; 
	document.form1.User_CITY.options[0] = new Option("--请选择--", "");
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
			document.form1.User_CITY.options[document.form1.User_CITY.length] = new Option('<%=cityInfo[1]%>', '<%=cityInfo[0]%>');
			<%
			}
			%>
		}	
	<%		
		}
	%>
}
</SCRIPT> 
</body>
</html>