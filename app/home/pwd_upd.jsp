<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />
</head>
<body topmargin=0 leftmargin=0 >

<!-- 通用导航条 -->
<syntc:TitleHeader header="个人密码修改" />
<form name="form1" action="" method="post">
<syntc:FuncHeader header="个人密码修改" showall="yes"/>
<br>
<table width="80%" align="left">
<tr>
	<td>
		<syntc:TableTitle header="">
		<syntc:TableHeader/>
		<syntc:SaveButton/>
		<syntc:TableFoot/>
		</syntc:TableTitle>
		<syntc:HtmlTable>
		  <tr>
			<td class="item" width="30%" >旧密码：</td>
			<td class=nm>
			  <input type="password" name="pwd_old" value="">
			  <font color="red">*</font>
			</td>
		  </tr>
		  <tr>
			<td class="item">新密码：</td>
			<td class=nm>
			  <input type="password" name="pwd" value="">
			  <font color="red">*</font>
			</td>
		  </tr>
		  <tr>
			<td class="item">确认密码：</td>
			<td class=nm>
			  <input type="password" name="pwd_confirm" value="">
			  <font color="red">*</font>
			</td>
		  </tr>
		</syntc:HtmlTable>

	</td>
</tr>
</table>
</form>
<syntc:TitleFoot />
</body>

<script language="JavaScript">

function funSave(){
	if(checkSubmit())	
	{
	    //提交方法
		document.form1.action="PwdSave.do";
		document.form1.submit();
	}
	return;	

}
function checkSubmit(){
	var frm = document.form1;
	
	if( chkLthNul( frm.pwd_old,"旧密码",32) ){
		return false;
    }
	if( chkLthNul( frm.pwd,"新密码",32) ){
		return false;
    }
	if( chkLthNul( frm.pwd_confirm,"确认密码",32) ){
		return false;
    }
	if(frm.pwd.value!=frm.pwd_confirm.value){
		alert("[新密码]与[确认密码]不一致！");
        frm.pwd.select();
	    return false;
	}
	return true;
}
</script>

<SCRIPT LANGUAGE="JavaScript">
<!--
<%
//页面上的人员信息
String strIfBug = StringUtil.convertNull((String)request.getParameter("ifBug"));

if("1".equals(strIfBug)){
%>
	alert("旧密码不正确，请重新输入！");
<%
}

%>
//-->
</SCRIPT>

</html>
