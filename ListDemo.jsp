<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%--
/**
 * 
 * Created on      2006-6-8
 * <p>Title:       一览页面及共通部分处理/p>
 * <p>Description: 一览列表页面</p>
 * <p>Copyright:   Copyright (c) 2006</p>
 * <p>Company:     沈阳NTC计算机工程有限公司</p>
 * <p>Department:  软件二部</p>
 * @author:        jinghuizhen@hotmail.com
 * @version:       1.0
 * history:
 * 2006-6-8 创建
 */
--%>
<HTML>
<HEAD>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="opal" %>
<TITLE>一览页面共通处理</TITLE>
</HEAD>
<opal:ScriptsCommon/>
<BODY>
<FORM METHOD=POST ACTION="" NAME="form1">
<table id="table1" border="0" width="100%">
	<tr>
		<!-- 标题例子 -->
		<opal:Header header="财富库结构定义 >> 目录设置 >> 在这里定义内容标题"/>		
	</tr>
    <tr>
        <td colSpan="2" height="10">
        <img height="1" src="clear.gif" width="1"></td>
    </tr>
    <tr>
        <td><img height="1" src="clear.gif" width="1"></td>
        <td>
        <table cellSpacing="1" cellPadding="1" width="100%" border="0" id="table2">
            <tr>
			    <!-- 如果需要操作列表数据,那么可以提供这个选择 -->
			    <opal:CheckAllBox/>
                <td align="right">
                    <table border="0" id="table3">
                        <tr>
                            <td><table height="20" border="0" align="left" cellpadding="0" cellspacing="0"></td>
                        </tr>
                        <tr>
						
						<td NOWRAP>
						<!-- 按钮定义例子 -->
						<opal:NewButton/>
						<opal:DeleteButton/>
						<opal:ModifyButton/>
						<opal:SaveButton/>
						<opal:QueryButton/>
						<opal:SubmitButton/>
						<!-- 其它按钮定义			
						<opal:CancelButton/>
						<opal:NextButton/>
						<opal:PreButton/> -->
						<opal:ReturnButton/>
						<opal:ButtonBase caption="自定义" width="50" onclick="alert('i set it myselft');"/></td>
						</tr>
                    </table>
                 </td>
            </tr>
        </table>
    </tr>
</table>

<BR><BR>
<!-- 列表例子 -->
<TABLE cellSpacing=0 borderColorDark=#e4e4e4 cellPadding=5 width="100%" 
      align=center borderColorLight=#7b9ebd border=1>
<TR CLASS="TITLE">
    <TH>操作</TH>
    <TH>属性1</TH>
    <TH>属性2</TH>
    <TH>属性3</TH>
    <TH>属性4</TH>
    <TH>属性5</TH>
	<TH>属性6</TH>
	<TH>属性7</TH>
</TR>

<TR id="ListRow">
    <TD><INPUT TYPE="checkbox" NAME="chk1" value="1"></TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>NNNNNNNNNN</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>YYYY/MM/DD</TD>
</TR>

<TR id="ListRow">
    <TD><INPUT TYPE="checkbox" NAME="chk2" value="2"></TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>NNNNNNNNNN</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>YYYY/MM/DD</TD>
</TR>

<TR id="ListRow">
    <TD><INPUT TYPE="checkbox" NAME="chk3"  value="3"></TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>NNNNNNNNNN</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>XXXXXXXXXX</TD>
    <TD>YYYY/MM/DD</TD>
</TR>
</TABLE>

<!-- 分页处理部分 -->
<TABLE width="100%" border="0" cellpadding="1" cellspacing="1" class="blue" valign="buttom">
    <TR>
        <TD align="right">
            <!-- 每页  --><INPUT TYPE="hidden" name="txtPageSize" class=tx value="20" style="width:25px; background-color:transparent ;border:none;color:blue" readonly><!--  记录 -->
            共 <font color=blue><b>1</b></font> 页
            当前
            <input type="text" name="page" value="1" class=tx size=3 style="color:blue" id=Page02>
            <input type="button" name="go" class=bt value="GO" onclick="btnGo()">页
            &nbsp;&nbsp;本页 <font color=blue><b>3</b></font> 条记录
            [<a href="javascript:go(1)">首 页</a>]
            [<a href="javascript:go()">上一页</a>]
            [<a href="javascript:go()">下一页</a>]
            [<a href="javascript:go()">最后一页</a>]
                 每页显示记录
            <select name="selPageSize" onchange="onSelectChange();">
                <option value="20"selected>20</option>
                <option >50</option>
                <option >100</option>
                <option  >200</option>
            </select>
        </TD>
       
    </TR>
</TABLE>
<!-- 当前页的数据数 --> <INPUT TYPE="hidden" name="hdnCurRecCount" value="3" >
</FORM>
</BODY>


<SCRIPT LANGUAGE="JavaScript">
<!--
function funSubmit(){
	alert("submit function ");
}

function funCancel(){
	alert("funCancel function ");
}

function funNew(){
	alert("funNew function ");
}

function funModify(){
	alert("funModify function ");
}

function funDelele(){
	alert("funDelele function ");
}

function funSave(){
	alert("funSave function ");
}

function funQuery(){
	alert("funQuery function ");
}

function funPre(){
	alert("funPre function ");
}

function funNext(){
	alert("funNext function ");
}


//全部选择
function btnSelectAll(){
    var parmObjName;
    var li_Num;
    var i;
    li_Num = parseInt(document.form1.hdnCurRecCount.value);
    if (document.form1.chkCheckAll.checked==true){
        for( i = 1; i <= li_Num ; i++ ){
            parmObjName = "chk" + i;
            eval("document.form1.chk"+i+".checked = true");
        }
    }else{
        for( i = 1; i <= li_Num ; i++ ){
            parmObjName = "chk" + i;
            document.form1.elements[parmObjName].checked = false;
        }
    }
}
//-->
</SCRIPT>
</HTML>
