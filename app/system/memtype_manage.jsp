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
%>
<syntc:TitleHeader header="系统管理	>> 会员类别管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="UserManage.do">
<syntc:FuncHeader header="会员类别管理" showall="yes"/>
<br>
<syntc:TableTitle header="会员类别列表" >
<syntc:TableHeader />
<syntc:NewButton/>
<syntc:ModifyButton/>
<syntc:DeleteButton/>
<syntc:TableFoot />
</syntc:TableTitle>   
      <!-- 列表例子 -->
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap width="10%">操作</th>
		  <th class="nm" nowrap width="30%">会员类别名称</th>
          <th class="nm" nowrap width="30%">院方承担比例(%)</th>
          <th class="nm" nowrap width="30%">标准积分</th>
        </tr>
<%
if(res.size() > 1){
	for (int i = 1; i < res.size(); i++) {
		//取得id
		String str_id = StringUtil.convertNull(res.getCell("C_ID", i));
		//取得会员类别名称
		String str_typeName = StringUtil.convertNull(res.getCell("C_TYPENAME", i));
		//取得院方承担比例
		String str_percent = StringUtil.convertNull(res.getCell("C_PERCENT", i));
		if (str_percent.length() > 0) {
			str_percent = common.removeTailZero(str_percent);
		}
		//取得标准积分
		String str_score = StringUtil.convertNull(res.getCell("C_SCORE", i));
    
%>
        <tr>
		  <td class="nm"><input type="radio" name="rad" value="<%=str_id%>"></td>
		  <td class="nm"><%=str_typeName%></td>
          <td class="nm"><%=str_percent%></td>
          <td class="nm"><%=str_score%></td>
        </tr>
<%		}
	}
%>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />    
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">
function funNew(){
	document.form1.action = "MemTypeAdd.do";
	document.form1.submit();
}

function funModify(){
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "MemTypeModify.do?type_id=" + radValue;
        document.form1.submit();
    }
}

function funDelele(){
	if (checkRadioValue('rad')) {
        if (confirm("您确认要删除数据吗？")) {
            var radValue = getRadioValue(document.getElementsByName('rad'));
            document.form1.action = "MemTypeDel.do?type_id=" + radValue;
            document.form1.submit();
        }
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
</SCRIPT>

