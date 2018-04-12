<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />
</head>
<body topmargin=0 leftmargin=0 >


<!-- 通用导航条	-->
<syntc:TitleHeader header="文件履历查看 >> 文件列表" />

<%
	ResultObj res = (ResultObj)request.getAttribute("res");
	//取得是否有确认列
	String str_confirm = (String)request.getAttribute("confirm");
%>
<form	name="form1" action="" method="post">
<input type="hidden" name="state">
<input type="Hidden" name="actname" value="">
<br>
<!-- 按钮定义例子	-->
<syntc:TableTitle header="查看文件" >
<syntc:TableHeader/>
<syntc:ButtonBase	caption="关 闭"	width="40" onclick="myclose()"/>
<syntc:TableFoot/>
</syntc:TableTitle>
<syntc:HtmlTable id="tableid">
<tr class="title">
  <th class="nm" width="20%">文件名</th>
  <th class="nm" width="10%">上传人</th>
  <th class="nm" width="15%">上传时间</th>
<%
	if("yes".equals(str_confirm)){
%>
  <th class="nm" width="15%">是否确认</th>
  <th class="nm" width="10%">确认人</th>
  <th class="nm" width="15%">确认时间</th>
<%
	}	
%>
  <th class="nm" >备注</th>

</tr>
<%
	for(int i=1; i<res.size();i++){
		//取得文件id
		String str_fileID = StringUtil.convertNull(res.getCell("file_id",i));
		//取得文件名
		String str_fileName = StringUtil.convertNull(res.getCell("file_original_name",i),"&nbsp;");
		
		//文件名称处理
		str_fileName = "<a href=\"#\" name=\"mainPlan\" class=\"detail\" sytle=\"cursor:hand\" onclick=\"downFile('"+str_fileID+"');return false;\">" + str_fileName +"</a>";

		//取得上传人
		String str_createdName = StringUtil.convertNull(res.getCell("created_name",i),"&nbsp;");
		//取得上传时间
		String str_createdTime = StringUtil.convertNull(res.getCell("created_time",i),"&nbsp;");
		//取得是否确认
		String str_ifConfirm = StringUtil.convertNull(res.getCell("if_confirm",i),"0");
		//取得确认人
		String str_confirmName = StringUtil.convertNull(res.getCell("confirm_name",i),"&nbsp;");
		//取得确认时间
		String str_confirmTime = StringUtil.convertNull(res.getCell("confirm_time",i),"&nbsp;");
		//取得备注
		String str_remark = StringUtil.convertNull(res.getCell("remark",i),"&nbsp;");
		
%>
<tr>
  <td width="20%" class=nm><%=str_fileName%>
  </td>  
  <td width="10%" class=nm><%=str_createdName%>
  </td> 
  <td width="10%" class=nm><%=str_createdTime%>
  </td> 
<%
	if("yes".equals(str_confirm)){
%>
  <td width="10%" class=nmc><%=common.getIsConfirm(str_ifConfirm)%>
  </td> 
  <td width="10%" class=nm><%=str_confirmName%>
  </td> 
  <td width="10%" class=nm><%=str_confirmTime%>
  </td> 
<%
	}	
%>
  <td class=nm><%=str_remark%>
  </td> 
</tr> 
<% } %>
</syntc:HtmlTable>
<syntc:listfooter />
</form>
<syntc:TitleFoot />
</body>
<SCRIPT LANGUAGE="JavaScript">
function myclose(){
	window.close();
}
//下载文件
function downFile(fileid){
	location.href = "com/downfile.jsp?fileid="+fileid;
}
</SCRIPT>
</html>
