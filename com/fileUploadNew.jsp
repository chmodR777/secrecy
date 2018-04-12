<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<HTML>
<HEAD><TITLE>文件上传新建页面</TITLE></HEAD>
<syntc:ScriptsCommon />
<BODY>
<form name="form1" method="post">
<table id="table1" border="0" width="100%">
  <tr>
    <syntc:Header header="共通页面 >> 文件上传"/>
  </tr>
  <tr>
    <td colSpan="2" height="10">
      <img height="1" src="clear.gif" width="1">
	</td>
  </tr>
  <tr>
    <syntc:Title header="单击该连接返回项目信息页面" onclick="myclick()" />
  </tr>
  <tr>
    <td>
	  <img height="1" src="clear.gif" width="1">
	</td>
    <td>
	  <table cellSpacing="1" cellPadding="1" width="100%" border="0" id="table2">
	    <tr>
		  <td align="right">
			<table border="0" id="table3" height="20" border="0" align="right" cellpadding="0" cellspacing="0">
			  <tr>
			    <td>
				</td>
			  </tr>
			  <tr>
			    <td nowrap>
					<syntc:SubmitButton/>
					<syntc:ReturnButton/>
				</td>
			  </tr>
			</table>
		  </td>
		</tr>
	  </table>
	</td>
  </tr>
</table>
<table cellspacing=0 bordercolordark=#e4e4e4 cellpadding=5 width="100%"
      align=center bordercolorlight=#7b9ebd border=1>
  <tr>
    <td width="15%" class="item">文件名称：
	</td>
	<td width="35%" class="input">
	  <input type="file" name="file_original_name" len="400" onchange="setFileName(this,form1.file_original_name)">
	  <font color="red">*</font>
	</td>
    <td width="15%" class="item">文件编号：
	</td>
	<td width="35%" class="input">
	  <input type="text" name="file_code" value="" len="20">
	</td>
  </tr>
  <tr>
	<td class="item">文件说明：
	</td>
	<td class="input" colspan="3">
      <textarea name="remark" rows="3" cols="65" len="2048"></textarea>
	</td>
  </tr>
</table>
</form>
</BODY>
<script language="JavaScript">
function funSubmit(){
	if(checkSubmit())
	{
		document.form1.action="FileUploadAdd.do";
		document.form1.submit();
	}

	return;
}

function checkSubmit(){
	var v_maxLength = 0;

    v_maxLength = form1.elements["file_original_name"].len;
	if( isBlankByHint( form1.elements["file_original_name"].value ,"文件名称") ){
		form1.elements["file_original_name"].focus();
		return false;
    }
	if( isLengthOut( form1.elements["file_original_name"].value,
		"文件名称长度最大为"+v_maxLength+"位,请重新输入！\n注意：一个汉字占2位",v_maxLength ) ){
		form1.elements["file_original_name"].focus();
		return false;
	}

    v_maxLength = form1.elements["file_code"].len;
    if( isLengthOut( form1.elements["file_code"].value,
		"文件编号长度最大为"+v_maxLength+"位,请重新输入！\n注意：一个汉字占2位",v_maxLength ) ){
		form1.elements["file_code"].focus();
		return false;
	}

    v_maxLength = form1.elements["remark"].len;
    if( isLengthOut( form1.elements["remark"].value,
		"文件说明长度最大为"+v_maxLength+"位,请重新输入！\n注意：一个汉字占2位",v_maxLength ) ){
		form1.elements["remark"].focus();
		return false;
	}

	return true;
}

function myclick() {
    alert("未定义");
}
</script>
</html>