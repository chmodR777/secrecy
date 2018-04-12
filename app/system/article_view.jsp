<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>查看文章信息</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<%
	String str_ArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	String headerStr = "";
	int num = Integer.parseInt(str_ArticleType);
	if (num >= 71 && num <= 74) {
		headerStr = "上级精神";
	} else if (num >= 75 && num <= 78) {
		headerStr = "法规制度";
	} else if (num >= 79 && num <= 89) {
		headerStr = "典型案例";
	}
	headerStr += "	>> ";
	headerStr += (String) optionItemMap.get(str_ArticleType);
	headerStr += ">> 查看";
%>
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="<%=headerStr%>" />
<syntc:FuncHeader header="文章信息查看" showall="yes"/>
<br>

<syntc:TableTitle header="文章信息">
<syntc:TableHeader />
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res = (ResultObj)request.getAttribute("res");

String strID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strTitle = StringUtil.convertNull(res.getCell("C_TITLE", 1));
String strContent = StringUtil.convertNull(res.getCell("C_CONTENT", 1));
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>标题：</td>
	<td class="input" width="30%" nowrap colspan="3">
      <input type="text" name="strTitle" value="<%=strTitle%>" readonly="true">
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>内容：</td>
    <td class="input" colspan="3">
      <textarea name="strContent" rows="25" cols="120" readonly="true"><%=strContent%></textarea>
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function funReturn() {
    document.form1.action = "ArticleList.do?article_type=<%=str_ArticleType%>";
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