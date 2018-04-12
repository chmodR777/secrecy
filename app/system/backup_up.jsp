<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>

<html>
<head><title>系统备份与恢复</title></head>

<body topmargin=0 leftmargin=0 >

<%
String res = (String) request.getAttribute("res"); 
%>
<form name="form1" method="post"  enctype="multipart/form-data">
<syntc:ScriptsCommon />
<syntc:TitleHeader header="系统管理 >> 系统备份与恢复 " />
<syntc:FuncHeader header="系统备份与恢复" showall="yes"/>
<br>

<syntc:TableTitle header="">
<syntc:TableHeader />
<syntc:ButtonBase caption="备 份" onclick="backup();" />
<syntc:ButtonBase caption="恢 复" onclick="backup_e();" />
<syntc:TableFoot />
</syntc:TableTitle>
<syntc:HtmlTable>
  <tr>
    <td class="item" nowrap>恢复文件：</td>
	<td class="input">
     <input type="file" id="file" name="file" size="50">
    </td>
  </tr>
</syntc:HtmlTable>
</form>
<syntc:TitleFoot />
</body>
<script language="JavaScript">
var res = "<%=res%>";
if(res =="success"){
	alert("备份成功！");
	
}

if(res =="error"){
	alert("备份失败！");
	
}

if(res =="re_success"){
	alert("恢复成功，请重启服务器！");
	
}

if(res =="re_error"){
	alert("恢复失败！");
	
}
function bitLength(str){
	if(str==null || str == "") return 0;
	var len = 0;
	for(var i=0; i < str.length; i++){
		//非汉字

		if(str.substring(i,i+1).charCodeAt(0) < 0x4e00){
			len ++;
		 	continue;
		}
		//汉字
		len += 2;
	}
	return len;
}

function backup() {
    document.form1.action = "BackUp.do";
    document.form1.submit();
}

function check_e_Submit() {
	
	var strName = document.getElementById("file").value;
    if (bitLength(strName) <= 0) {
      alert("[恢复文件]不能为空，请输入！");
   	  document.getElementById("file").focus();
      return false;
    }
	strLen = strName.length;
	strSQL = strName.substr (strLen-4,4);
	if (".sql" != strSQL.toLowerCase ()){
			alert("请输入正确的恢复文件！");
			 return false;
		}else{
			 return true;
		}
   
}


function backup_e() {
   var fileName = document.getElementById("file").value;
   if (check_e_Submit()) {
       document.form1.action = "BackUp_Back.do?file="+fileName;
       document.form1.submit();
   }
}
</script>
</html>