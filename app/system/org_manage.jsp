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
<syntc:TitleHeader header="系统管理	>> 组织管理" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="OrgManage.do">
<syntc:FuncHeader header="组织管理" showall="yes"/>
<br>
<syntc:TableTitle header="组织列表" >
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
		  <th class="nm" nowrap width="99%">组织名称</th>
        </tr>
<%
if(res.size() > 1){
	for (int i = 1; i < res.size(); i++) {
		//取得id
		String str_id = StringUtil.convertNull(res.getCell("C_ID", i));
		//取得会员类别名称
		String str_name = StringUtil.convertNull(res.getCell("C_NAME", i));
%>
        <tr>
		  <td class="nm"><input type="radio" name="rad" value="<%=str_id%>"></td>
		  <td class="nm"><%=str_name%></td>
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
	document.form1.action = "OrgAdd.do";
	document.form1.submit();
}

function funModify(){
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "OrgModify.do?org_id=" + radValue;
        document.form1.submit();
    }
}

function funDelele(){
	if (checkRadioValue('rad')) {
        if (confirm("您确认要删除数据吗？")) {
            var radValue = getRadioValue(document.getElementsByName('rad'));
            document.form1.action = "OrgDel.do?org_id=" + radValue;
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

