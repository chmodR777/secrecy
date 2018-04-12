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
	String str_ArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	// 查询条件-标题
	String p_Title = StringUtil.getRequestData(request.getParameter("txtTitle"), "");
	int num = Integer.parseInt(str_ArticleType);
	String header1Str = "";
	String header2Str = (String) optionItemMap.get(str_ArticleType);
	if (num >= 71 && num <= 74) {
		header1Str = "上级精神";
	} else if (num >= 75 && num <= 78) {
		header1Str = "法规制度";
	} else if (num >= 79 && num <= 89) {
		header1Str = "典型案例";
	}
	header1Str += "	>> ";
	header1Str += header2Str;
%>
<syntc:TitleHeader header="<%=header1Str%>" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="ArticleList.do">
<syntc:FuncHeader header="<%=header2Str%>" showall="yes"/>
<br>
<syntc:TableTitle header="请输入用户查询的条件">
<syntc:TableHeader />
<syntc:QueryButton/>
<syntc:TableFoot />
</syntc:TableTitle>
<div id="queryPage">
<syntc:HtmlTable>
  <tr>
    <td class="item" width="20%" nowrap>标题：</td>
	<td class="input" width="30%">
      <input type="text" name="txtTitle" value="<%=p_Title%>">
    </td>
  </tr>
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="文章列表" >
<syntc:TableHeader />
<syntc:TableFoot />
</syntc:TableTitle>   
      <!-- 列表例子 -->
      <syntc:HtmlTable>
        <tr class="title">
		  <th class="nm" nowrap>标题</th>
		  <th class="nm" nowrap width="1%">&nbsp;</th>
        </tr>
<%
if(res.size() > 1){
	for (int i = 1; i < res.size(); i++) {
		//取得id
		String str_id = StringUtil.convertNull(res.getCell("C_ID", i));
		//取得标题
		String str_title = StringUtil.convertNull(res.getCell("C_TITLE", i));
%>
        <tr>
		  <td class="nm" nowrap><%=str_title%></td>
		  <td class="nm" nowrap><a href="#" onclick="viewArticle('<%=str_id%>')">查看</a></td>
        </tr>
<%		}
	}
%>
</syntc:HtmlTable>
<syntc:listfooter/>
</form>
<syntc:TitleFoot />    
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">
function funQuery(){
	document.form1.action = "ArticleList.do?article_type=<%=str_ArticleType%>";
	document.form1.submit();
}
function viewArticle(articleid){
	document.form1.action = "ArticleView.do?article_type=<%=str_ArticleType%>&article_id=" + articleid;
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
</SCRIPT>

