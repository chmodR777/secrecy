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
	String articleTypeOptionList = (String) request.getAttribute("articleTypeOptionList");
	String str_ArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
	// 查询条件-标题
	String p_Title = StringUtil.getRequestData(request.getParameter("txtTitle"), "");
	// 查询条件-类别
	String p_Type = StringUtil.getRequestData(request.getParameter("txtType"), "");
	String header1Str = "文章管理	>> ";
	String header2Str = "";
	if (str_ArticleType.equals("71")) {
		header2Str = "上级精神";
	} else if (str_ArticleType.equals("75")) {
		header2Str = "法规制度";
	} else if (str_ArticleType.equals("79")) {
		header2Str = "典型案例";
	}
	header1Str = header1Str + header2Str;
%>
<syntc:TitleHeader header="<%=header1Str%>" />

<form name="form1" action="" method="post">
<syntc:ScriptsCommon />
<input type="hidden" name="state">
<input type="hidden" name="actname" value="ArticleManage.do">
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
    <td class="item" width="20%" nowrap>类别：</td>
	<td class="input" width="30%">
      <select name="txtType">
        <option value="">--请选择--</option>
        <%=articleTypeOptionList%>
      </select>
    </td>
  </tr>
</syntc:HtmlTable> 
</div>
<br>
<syntc:TableTitle header="文章列表" >
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
		  <th class="nm" nowrap>标题</th>
          <th class="nm" nowrap>类别</th>
        </tr>
<%
if(res.size() > 1){
	for (int i = 1; i < res.size(); i++) {
		//取得id
		String str_id = StringUtil.convertNull(res.getCell("C_ID", i));
		//取得标题
		String str_title = StringUtil.convertNull(res.getCell("C_TITLE", i));
		//取得类别
		String str_type = StringUtil.convertNull(res.getCell("C_NAME", i));
%>
        <tr>
		  <td class="nm" nowrap><input type="radio" name="rad" value="<%=str_id%>"></td>
		  <td class="nm" nowrap><%=str_title%></td>
          <td class="nm" nowrap><%=str_type%></td>
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
function funNew(){
	document.form1.action = "ArticleAdd.do?article_type=<%=str_ArticleType%>";
	document.form1.submit();
}

function funModify(){
	if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        document.form1.action = "ArticleModify.do?article_type=<%=str_ArticleType%>&article_id=" + radValue;
        document.form1.submit();
    }
}

function funDelele(){
	if (checkRadioValue('rad')) {
        if (confirm("您确认要删除数据吗？")) {
            var radValue = getRadioValue(document.getElementsByName('rad'));
            document.form1.action = "ArticleDel.do?article_type=<%=str_ArticleType%>&article_id=" + radValue;
            document.form1.submit();
        }
    }
}
function funQuery(){
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
</SCRIPT>

