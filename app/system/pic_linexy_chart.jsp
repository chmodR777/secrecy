<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>综合信息统计</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="综合统计图表 >> 折线统计图" />
<syntc:FuncHeader header="折线统计图" showall="yes"/>
<br>

<syntc:TableTitle header="">
<syntc:TableHeader />
<syntc:ButtonBase caption="统   计" width="40" onclick="compute()"/>
<syntc:TableFoot />
</syntc:TableTitle>
<%
	String flag = (String)request.getAttribute("flag");
	String startYear = (String)request.getAttribute("startYear");
	String startMonth = (String)request.getAttribute("startMonth");
	String endYear = (String)request.getAttribute("endYear");
	String endMonth = (String)request.getAttribute("endMonth");

	String[] cntItem = (String[])request.getAttribute("cntItem");

	String chartPath = request.getSession().getServletContext().getContextPath()+"/chart";
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%">开始年份：
    </td>
	<td class="input" width="30%">
	  <select name="txtStartYear">
	    <option value="">--请选择--</option>
	    <option value="1988" <% if("1988".equals(startYear)){ %>selected<% } %>>1988</option>
	    <option value="1989" <% if("1989".equals(startYear)){ %>selected<% } %>>1989</option>
	    <option value="1990" <% if("1990".equals(startYear)){ %>selected<% } %>>1990</option>
	    <option value="1991" <% if("1991".equals(startYear)){ %>selected<% } %>>1991</option>
	    <option value="1992" <% if("1992".equals(startYear)){ %>selected<% } %>>1992</option>
	    <option value="1993" <% if("1993".equals(startYear)){ %>selected<% } %>>1993</option>
	    <option value="1994" <% if("1994".equals(startYear)){ %>selected<% } %>>1994</option>
	    <option value="1995" <% if("1995".equals(startYear)){ %>selected<% } %>>1995</option>
	    <option value="1996" <% if("1996".equals(startYear)){ %>selected<% } %>>1996</option>
	    <option value="1997" <% if("1997".equals(startYear)){ %>selected<% } %>>1997</option>
	    <option value="1998" <% if("1998".equals(startYear)){ %>selected<% } %>>1998</option>
	    <option value="1999" <% if("1999".equals(startYear)){ %>selected<% } %>>1999</option>
	    <option value="2000" <% if("2000".equals(startYear)){ %>selected<% } %>>2000</option>
	    <option value="2001" <% if("2001".equals(startYear)){ %>selected<% } %>>2001</option>
	    <option value="2002" <% if("2002".equals(startYear)){ %>selected<% } %>>2002</option>
	    <option value="2003" <% if("2003".equals(startYear)){ %>selected<% } %>>2003</option>
	    <option value="2004" <% if("2004".equals(startYear)){ %>selected<% } %>>2004</option>
	    <option value="2005" <% if("2005".equals(startYear)){ %>selected<% } %>>2005</option>
	    <option value="2006" <% if("2006".equals(startYear)){ %>selected<% } %>>2006</option>
	    <option value="2007" <% if("2007".equals(startYear)){ %>selected<% } %>>2007</option>
	    <option value="2008" <% if("2008".equals(startYear)){ %>selected<% } %>>2008</option>
	    <option value="2009" <% if("2009".equals(startYear)){ %>selected<% } %>>2009</option>
	    <option value="2010" <% if("2010".equals(startYear)){ %>selected<% } %>>2010</option>
	    <option value="2011" <% if("2011".equals(startYear)){ %>selected<% } %>>2011</option>
	    <option value="2012" <% if("2012".equals(startYear)){ %>selected<% } %>>2012</option>
	    <option value="2013" <% if("2013".equals(startYear)){ %>selected<% } %>>2013</option>
	    <option value="2014" <% if("2014".equals(startYear)){ %>selected<% } %>>2014</option>
	    <option value="2015" <% if("2015".equals(startYear)){ %>selected<% } %>>2015</option>
	    <option value="2016" <% if("2016".equals(startYear)){ %>selected<% } %>>2016</option>
	    <option value="2017" <% if("2017".equals(startYear)){ %>selected<% } %>>2017</option>
	    <option value="2018" <% if("2018".equals(startYear)){ %>selected<% } %>>2018</option>
	    <option value="2019" <% if("2019".equals(startYear)){ %>selected<% } %>>2019</option>
	    <option value="2020" <% if("2020".equals(startYear)){ %>selected<% } %>>2020</option>
	  </select><font color="red">*</font>
	</td>
    <td class="item" width="20%">开始月份：
    </td>
	<td class="input" width="30%">
	  <select name="txtStartMonth">
	    <option value="">--请选择--</option>
	    <option value="01" <% if("01".equals(startMonth)){ %>selected<% } %>>01</option>
	    <option value="02" <% if("02".equals(startMonth)){ %>selected<% } %>>02</option>
	    <option value="03" <% if("03".equals(startMonth)){ %>selected<% } %>>03</option>
	    <option value="04" <% if("04".equals(startMonth)){ %>selected<% } %>>04</option>
	    <option value="05" <% if("05".equals(startMonth)){ %>selected<% } %>>05</option>
	    <option value="06" <% if("06".equals(startMonth)){ %>selected<% } %>>06</option>
	    <option value="07" <% if("07".equals(startMonth)){ %>selected<% } %>>07</option>
	    <option value="08" <% if("08".equals(startMonth)){ %>selected<% } %>>08</option>
	    <option value="09" <% if("09".equals(startMonth)){ %>selected<% } %>>09</option>
	    <option value="10" <% if("10".equals(startMonth)){ %>selected<% } %>>10</option>
	    <option value="11" <% if("11".equals(startMonth)){ %>selected<% } %>>11</option>
	    <option value="12" <% if("12".equals(startMonth)){ %>selected<% } %>>12</option>
	  </select><font color="red">*</font>
	</td>
  </tr>
  <tr>
    <td class="item" width="20%">结束年份：
    </td>
	<td class="input" width="30%">
	  <select name="txtEndYear">
	  	<option value="">--请选择--</option>
	  	<option value="1988" <% if("1988".equals(endYear)){ %>selected<% } %>>1988</option>
	    <option value="1989" <% if("1989".equals(endYear)){ %>selected<% } %>>1989</option>
	    <option value="1990" <% if("1990".equals(endYear)){ %>selected<% } %>>1990</option>
	    <option value="1991" <% if("1991".equals(endYear)){ %>selected<% } %>>1991</option>
	    <option value="1992" <% if("1992".equals(endYear)){ %>selected<% } %>>1992</option>
	    <option value="1993" <% if("1993".equals(endYear)){ %>selected<% } %>>1993</option>
	    <option value="1994" <% if("1994".equals(endYear)){ %>selected<% } %>>1994</option>
	    <option value="1995" <% if("1995".equals(endYear)){ %>selected<% } %>>1995</option>
	    <option value="1996" <% if("1996".equals(endYear)){ %>selected<% } %>>1996</option>
	    <option value="1997" <% if("1997".equals(endYear)){ %>selected<% } %>>1997</option>
	    <option value="1998" <% if("1998".equals(endYear)){ %>selected<% } %>>1998</option>
	    <option value="1999" <% if("1999".equals(endYear)){ %>selected<% } %>>1999</option>
	    <option value="2000" <% if("2000".equals(endYear)){ %>selected<% } %>>2000</option>
	    <option value="2001" <% if("2001".equals(endYear)){ %>selected<% } %>>2001</option>
	    <option value="2002" <% if("2002".equals(endYear)){ %>selected<% } %>>2002</option>
	    <option value="2003" <% if("2003".equals(endYear)){ %>selected<% } %>>2003</option>
	    <option value="2004" <% if("2004".equals(endYear)){ %>selected<% } %>>2004</option>
	    <option value="2005" <% if("2005".equals(endYear)){ %>selected<% } %>>2005</option>
	    <option value="2006" <% if("2006".equals(endYear)){ %>selected<% } %>>2006</option>
	    <option value="2007" <% if("2007".equals(endYear)){ %>selected<% } %>>2007</option>
	    <option value="2008" <% if("2008".equals(endYear)){ %>selected<% } %>>2008</option>
	    <option value="2009" <% if("2009".equals(endYear)){ %>selected<% } %>>2009</option>
	    <option value="2010" <% if("2010".equals(endYear)){ %>selected<% } %>>2010</option>
	    <option value="2011" <% if("2011".equals(endYear)){ %>selected<% } %>>2011</option>
	    <option value="2012" <% if("2012".equals(endYear)){ %>selected<% } %>>2012</option>
	    <option value="2013" <% if("2013".equals(endYear)){ %>selected<% } %>>2013</option>
	    <option value="2014" <% if("2014".equals(endYear)){ %>selected<% } %>>2014</option>
	    <option value="2015" <% if("2015".equals(endYear)){ %>selected<% } %>>2015</option>
	    <option value="2016" <% if("2016".equals(endYear)){ %>selected<% } %>>2016</option>
	    <option value="2017" <% if("2017".equals(endYear)){ %>selected<% } %>>2017</option>
	    <option value="2018" <% if("2018".equals(endYear)){ %>selected<% } %>>2018</option>
	    <option value="2019" <% if("2019".equals(endYear)){ %>selected<% } %>>2019</option>
	    <option value="2020" <% if("2020".equals(endYear)){ %>selected<% } %>>2020</option>
	  </select><font color="red">*</font>
	</td>
    <td class="item" width="20%">结束月份：
    </td>
	<td class="input" width="30%">
	  <select name="txtEndMonth">
	  	<option value="">--请选择--</option>
	    <option value="01" <% if("01".equals(endMonth)){ %>selected<% } %>>01</option>
	    <option value="02" <% if("02".equals(endMonth)){ %>selected<% } %>>02</option>
	    <option value="03" <% if("03".equals(endMonth)){ %>selected<% } %>>03</option>
	    <option value="04" <% if("04".equals(endMonth)){ %>selected<% } %>>04</option>
	    <option value="05" <% if("05".equals(endMonth)){ %>selected<% } %>>05</option>
	    <option value="06" <% if("06".equals(endMonth)){ %>selected<% } %>>06</option>
	    <option value="07" <% if("07".equals(endMonth)){ %>selected<% } %>>07</option>
	    <option value="08" <% if("08".equals(endMonth)){ %>selected<% } %>>08</option>
	    <option value="09" <% if("09".equals(endMonth)){ %>selected<% } %>>09</option>
	    <option value="10" <% if("10".equals(endMonth)){ %>selected<% } %>>10</option>
	    <option value="11" <% if("11".equals(endMonth)){ %>selected<% } %>>11</option>
	    <option value="12" <% if("12".equals(endMonth)){ %>selected<% } %>>12</option>
	  </select><font color="red">*</font>
	</td>
  </tr>
  <tr>
	<td class="item" width="20%">统计项：</td>
    <td class="input" colspan="3">
    <%
    	if(null != cntItem){
    		String flag1 = "";
    		String flag2 = "";
    		String flag3 = "";
    		String flag4 = "";
    		String flag5 = "";
    		String flag6 = "";
    		for(int i=0; i<cntItem.length; i++){
    			if("1".equals(cntItem[i])){
    				flag1 = "checked";
    			}else if("2".equals(cntItem[i])){
    				flag2 = "checked";
    			}else if("3".equals(cntItem[i])){
    				flag3 = "checked";
    			}else if("4".equals(cntItem[i])){
    				flag4 = "checked";
    			}else if("5".equals(cntItem[i])){
    				flag5 = "checked";
    			}else if("6".equals(cntItem[i])){
    				flag6 = "checked";
    			}
    		}
    %>
      	&nbsp;&nbsp;咨询量<input type="checkbox" name="cntItem" value="1" <%=flag1 %>>
      	&nbsp;&nbsp;邮药量<input type="checkbox" name="cntItem" value="2" <%=flag2 %>>
      	&nbsp;&nbsp;初诊量<input type="checkbox" name="cntItem" value="3" <%=flag3 %>>
      	&nbsp;&nbsp;复诊量<input type="checkbox" name="cntItem" value="4" <%=flag4 %>>
      	&nbsp;&nbsp;总就诊量<input type="checkbox" name="cntItem" value="5" <%=flag5 %>>
      	&nbsp;&nbsp;住院量<input type="checkbox" name="cntItem" value="6" <%=flag6 %>><font color="red">*</font>
    <%
    	}else{
    %>
    	&nbsp;&nbsp;咨询量<input type="checkbox" name="cntItem" value="1" >
      	&nbsp;&nbsp;邮药量<input type="checkbox" name="cntItem" value="2" >
      	&nbsp;&nbsp;初诊量<input type="checkbox" name="cntItem" value="3" >
      	&nbsp;&nbsp;复诊量<input type="checkbox" name="cntItem" value="4" >
      	&nbsp;&nbsp;总就诊量<input type="checkbox" name="cntItem" value="5" >
      	&nbsp;&nbsp;住院量<input type="checkbox" name="cntItem" value="6" ><font color="red">*</font>
    <%
    	}
    %>
    </td>
  </tr>
<% if("2".equals(flag)){ %>
  <tr>
	<td class="input" colspan="4">
      <img alt="" src="<%=chartPath %>/PicLineXYChart.jpg">
    </td>
  </tr>
<% } %>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkSubmit() {
    if (chkNul(form1.txtStartYear, "统计开始年份")) {
        return false;
    }
    if (chkNul(form1.txtStartMonth, "统计开始月份")) {
        return false;
    }
    if (chkNul(form1.txtEndYear, "统计结束年份")) {
        return false;
    }
    if (chkNul(form1.txtEndMonth, "统计结束月份")) {
        return false;
    }
    var item = document.form1.cntItem;
    if(!checkChkBox(item)){
        alert("统计项不能为空,请选择.");
    	return false;
    }
    return true;
}
function checkChkBox(obj){
	var flag = false;
	for(var i=0; i<obj.length;i++){
		if(obj[i].checked){
			flag = true;
		}
	}
	return flag;
}
function compute(){
	if (checkSubmit()) {
		document.form1.action = "PicLineXYChart.do?flag=2";
	    document.form1.submit();
	}
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