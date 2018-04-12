<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>修改文章信息</title></head>
<body topmargin=0 leftmargin=0 onload="initHTML();">
<%
	String articleTypeOptionList = (String) request.getAttribute("articleTypeOptionList");
	String str_ArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
	String headerStr = "文章管理	>> ";
	if (str_ArticleType.equals("71")) {
		headerStr += "上级精神";
	} else if (str_ArticleType.equals("75")) {
		headerStr += "法规制度";
	} else if (str_ArticleType.equals("79")) {
		headerStr += "典型案例";
	}
	headerStr += ">> 修改";
%>
<form name="form1" method="post">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="<%=headerStr%>" />
<syntc:FuncHeader header="文章信息修改" showall="yes"/>
<br>

<syntc:TableTitle header="文章信息">
<syntc:TableHeader />
<syntc:SaveButton/>
<syntc:ButtonBase caption="返 回" onclick="funReturn();" />
<syntc:TableFoot />
</syntc:TableTitle>
<%
ResultObj res = (ResultObj)request.getAttribute("res");

String strID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strTitle = StringUtil.convertNull(res.getCell("C_TITLE", 1));
String strType = StringUtil.convertNull(res.getCell("C_TYPE", 1));;
String strContent = StringUtil.convertNull(res.getCell("C_CONTENT", 1));
%>
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>标题：</td>
	<td class="input" width="30%" nowrap>
      <input type="text" name="strTitle" value="<%=strTitle%>">
      <font color="red">*</font>
    </td>
	<td class="item" width="20%" nowrap>类别：</td>
	<td class="input" width="30%" nowrap>
      <select name="strType">
        <option value="">--请选择--</option>
        <%=articleTypeOptionList%>
      </select>
      <font color="red">*</font>
    </td>
  </tr>
  <tr>
    <td class="item" nowrap>内容：</td>
    <td class="input" colspan="3">
      <textarea name="strContent" rows="25" cols="120"><%=strContent%></textarea>
      <font color="red">*</font>
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
function checkSubmit() {
	if (chkLthNul(form1.strTitle, "标题", 128)) {
        return false;
    }
    if (chkNul(form1.strType, "类别")) {
    	return false;
    }
    if (chkLthNul(form1.strContent, "内容", 15000)) {
        return false;
    }
    return true;
}

function funSave() {
    if (checkSubmit()) {
        document.form1.action = "ArticleModifySave.do?article_type=<%=str_ArticleType%>&article_id=<%=strID%>";
        document.form1.submit();
    }
}

function funReturn() {
    document.form1.action = "ArticleManage.do?article_type=<%=str_ArticleType%>";
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