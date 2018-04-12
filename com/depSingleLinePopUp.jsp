<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%--
/**
 * 
 * Created on      2005-8-30
 * <p>Title:       公司部门POPUP/p>
 * <p>Description: 公司部门POPUP</p>
 * <p>Copyright:   Copyright (c) 2005</p>
 * <p>Company:     沈阳NTC计算机工程有限公司</p>
 * <p>Department:  软件二部</p>
 * @author:        RR
 * @version:       1.0
 * history:
 * 2005-8-17 创建
 */
--%>
<%@ include file="/com/begin.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%String path = request.getContextPath();%>

<HTML>
<HEAD>
<SCRIPT LANGUAGE="JavaScript">
<!--
var folderclose = new Image();
	folderclose.src = '<%=path%>/images/menus/folderclose.gif';
var folderopen	= new Image();
	folderopen.src = '<%=path%>/images/menus/folderopen.gif';
//展开对象的全部child
function expand(idName)
{  
	var parentID = document.getElementById(idName+'Sub');
	if ( parentID ){
		parentID.style.display = 'block';

		var allChildren = parentID.getElementsByTagName('div');
		for(i=0;i<allChildren.length;i++){
			allChildren[i].style.display = 'block';
		}

		var allImg = parentID.getElementsByTagName('img');
		for(i=0;i<allImg.length;i++){
			if ( allImg[i].src.indexOf('folderclose') != -1 )
				allImg[i] = folderopen;
		}

	}
	
	var tmp = document.getElementById('aMenu');
	fixScroll(tmp);
	//var inner = document.getElementById('inner');
	//var aMenu = document.getElementById('aMenu');
	//if (aMenu.offsetHeight > inner.clientHeight) {
	//} else {
	//    inner.style.overflow = 'auto';
	    //inner.style.overflow = 'hidden';
	//}
}
//-->
</SCRIPT>
<TITLE>公司选择列表</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<LINK href="/css/menus.css" type="text/css" rel="stylesheet">
<SCRIPT type=text/javascript src="/CodeScript/menu_popup.js"></SCRIPT>
</HEAD>
<%
String form = opalCommon.getRequestData(request,"form");
String input = opalCommon.getRequestData(request,"input");
String inputName = opalCommon.getRequestData(request,"inputname");
String refun = opalCommon.getRequestData(request,"refunction");
String allChildren = opalCommon.getRequestData(request,"allChildren");
if ( allChildren == null ){
	allChildren = "";
}

String strLoginUser = ""; //系统登录用户
String strOrgID = "";     //用户所属的组织

//取得用户所在的公司
//用户控制用户的权限
//1.验证登录用户是否合法,如果不合法,将页面跳转到登录页面
/*
UserSession US = (UserSession) session.getAttribute("UserBean");

// 用户验证

if (US == null) {
	response.sendRedirect(Constants.CLDEF_LOGIN_PAGE + "?errmsg=" +
						  java.net.URLEncoder.encode("登录超时，请重新登录！"));
	return;
}

//取得系统登录用户
strLoginUser = US.getUserID();
strOrgID = US.getOrgID();
*/
//测试用户
strOrgID = "1";
%>

<BODY topmargin="12" onload="expand('x');">
<FORM METHOD=POST ACTION="<%=request.getRequestURL()%>" name="form1">
<input type="hidden" name="form" value="<%=form%>">
<input type="hidden" name="input" value="<%=input%>">
<input type="hidden" name="inputname" value="<%=inputName%>">
<input type="hidden" name="refunction" value="<%=refun%>">
<input type="hidden" name="allChildren" value="<%=allChildren%>">
<!-- Favorite Bar Starts Here -->
<DIV class="outer" style="position:absolute; top:4px; left:10px; WIDTH: 300px; HEIGHT: 480px; " >
	<DIV class="inner" style="WIDTH:300px; HEIGHT: 480px" id='inner'>
		<DIV class=favMenu id=aMenu>
			<DIV class=topFolder id="x"><B>公司列表</B>
			</DIV>

	<DIV class=sub id=xSub>
<%
com.opal.util.Tree tree = null;
com.opal.util.TreeNode node = null;
java.util.Vector vector = new Vector();
StringBuffer sb_SQL = new StringBuffer();

com.opal.util.DBOperate operate = new com.opal.util.DBOperate();
com.opal.util.ResultObj res     = new com.opal.util.ResultObj();

sb_SQL.append(" select LEVEL,SECTION_CODE,SEC_NAME,SEC_PARENT_ID");
sb_SQL.append("  from FINANCE.V_SECTION_FOR_OPAL@FIN_LINK ");
//sb_SQL.append(" where SEC_TYPE='0'");
//sb_SQL.append("  AND  SYSDATE>=VAILDTIME_FROM AND SYSDATE<=VAILDTIME_TO  ");
sb_SQL.append(" connect by prior SECTION_CODE = SEC_PARENT_ID");
sb_SQL.append(" start with  SECTION_CODE ='10' " );

res = operate.Query( sb_SQL.toString() );

for ( int i=1; i<res.getRows() ; i++ ){
	String value = res.getCell("SECTION_CODE",i);
	String name  = res.getCell("SEC_NAME",i);
	String level = res.getCell("level",i);

	node = new com.opal.util.TreeNode( value,name, Integer.parseInt(level),true );
	vector.add( node );
}

tree = new com.opal.util.Tree( vector );
String str_html = tree.draw("","","subFolder","subFolder","subItem",path+"/images/menus","no");
out.println( str_html );
%>
		</DIV>
		</DIV>
	</DIV>
</DIV>
<INPUT TYPE="hidden" name="txtNumber" value="<%=res.getRows()-1%>">
</FORM>
<div style="position:absolute; top:500px; left:50px; width:300px; height:25px;">

<INPUT TYPE="button" value=" 确定 " onclick="fun_setValue();">
<INPUT TYPE="button" value=" 关闭 " onclick="window.close();">
</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
<!--
function fun_setValue()
{
    var objElement = document.getElementsByTagName("input");
	var strValue='';
	var catoNumber = parseInt(eval(document.form1.txtNumber.value));
	var parm,obj;
    var chkNum=0;
    var para = new Array();
    for (var i=0; i<objElement.length; i++)
	{
        if (objElement[i].type == 'checkbox')
        {
            if ( objElement[i].checked == false || objElement[i].value.length <1 ){
                continue;
            }else{
                para[0] = objElement[i].value;
                para[1] = eval("document.form1.hdn_"+objElement[i].name+".value");
                strValue = strValue+','+objElement[i].value;
                chkNum++;
            }
        }
	}
	if ( strValue.length >0 )
	{
		strValue = strValue.substring(0,strValue.length);
	}

	//opener.<%=form%>.<%=input%>.value = strValue;
<%
	if ( inputName != null && !inputName.trim().equals("") )
	{
		out.println("\tfun_setName();");
	}
	if ( refun != null && !refun.trim().equals("") )
	{
		out.println("\topener."+refun+"();");
	}

%>
	if(chkNum==0){
        alert("请选择部门！");
        return;
    }else if(chkNum>1){
        alert("只能选择一个部门！");
        return;
    }
    parent.window.returnValue = para;//para[0]为部门编号；para[1]为业务线代码
    parent.window.close();
}

function fun_setName()
{
    var strValueAll='';
	var catoNumber = eval(document.form1.txtNumber.value);
	var parm,obj;
	for ( var i=0; i<catoNumber ;i++)
	{
		parm='document.form1.chk'+i;
		obj = eval(parm);
		if ( obj.checked == false || obj.value.length <1 )
			continue;
		strValue = fun_getName(obj);
		strValueAll += ',['+strValue.substring(0,strValue.length)+']';
	}

	if ( strValueAll.length >0 )
	{
		strValueAll = strValueAll.substring(1,strValueAll.length);
	}

	//opener.<%=form%>.<%=inputName%>.value = strValueAll;
}
//选中全部公司
function fun_setAll()
{
	var catoNumber = eval(document.form1.txtNumber.value);
	var parm,obj;
	for ( var i=1; i<=catoNumber ;i++)
	{
		parm='document.form1.chb'+i;
		obj = eval(parm);
		obj.checked = document.form1.che_bt.checked;
	}
	return;
}

var selectedItem = null;

var targetWin;

document.onclick = handleClick;
//document.ondblclick = handleDC;
document.onmouseover = handleOver;
document.onmouseout = handleOut;
document.onmousedown = handleDown;
document.onmouseup = handleUp;
document.write(writeSubPadding(10));  //write the stylesheet for the sub. Getting the indention right

function handleClick() {
	el = window.event.srcElement;
	//alert(el.tagName);
	if ( el.tagName=='INPUT')
	{
		fun_check(el);
		return;
	}
	el = getReal(window.event.srcElement, "tagName", "DIV");

	//是否展开 子菜单
	if ((el.className == "topFolder") || (el.className == "subFolder")) {
		if ( document.all[el.id + "Sub"] )
		{
			el.sub = eval(el.id + "Sub");
		}else
		{
			alert('无子公司！');
			return;
		}
		if ( el.sub )
		{
			if (el.sub.style.display == null) el.sub.style.display = "none";
			if (el.sub.style.display != "block") { //hidden
				if (el.parentElement.openedSub != null) {
					var opener = eval(el.parentElement.openedSub + ".opener");
					hide(el.parentElement.openedSub);
					if (opener.className == "topFolder")
						outTopItem(opener);
				}
				el.sub.style.display = "block";
				el.sub.parentElement.openedSub = el.sub.id;
				el.sub.opener = el;
			}
			else {
				if (el.sub.openedSub != null) hide(el.sub.openedSub);
				else hide(el.sub.id);
			}
		}
	}
	
	if ( el.className == "subFolder" ) {
		if (selectedItem != null)
			restoreSubItem(selectedItem);
		highlightSubItem(el);
		if ((el.href != null) && (el.href != "")) {
			if ((el.target == null) || (el.target == "")) {
				if (window.opener == null) {
					if (document.all.tags("BASE").item(0) != null)
						window.open(el.href, document.all.tags("BASE").item(0).target);
					else 
						window.location = el.href;					// HERE IS THE LOADING!!!
				}
				else {
					window.opener.location =  el.href;
				}
			}
			else {
				window.open(el.href, el.target);
			}
		}
	}
	
	if ((el.className == "topItem") || (el.className == "topFolder")) {
		if (selectedItem != null)
			restoreSubItem(selectedItem);
	}
	
	if ((el.className == "topItem") || (el.className == "subItem")) {
		if ((el.href != null) && (el.href != "")) {
			if ((el.target == null) || (el.target == "")) {
				if (window.opener == null) {
//					alert(document.all.tags("BASE").item(0));
					if (document.all.tags("BASE").item(0) != null)
//						eval(document.all.tags("BASE").item(0).target + ".location = el.href");
						window.open(el.href, document.all.tags("BASE").item(0).target);
					else 
						window.location = el.href;					// HERE IS THE LOADING!!!
				}
				else {
					window.opener.location =  el.href;
				}
			}
			else {
				window.open(el.href, el.target);
//				eval(el.target + ".location = el.href");
			}
		}
	}

	var tmp  = getReal(el, "className", "favMenu");
	if (tmp.className == "favMenu") fixScroll(tmp);

}

function handleOver() {
	var fromEl = getReal(window.event.fromElement, "tagName", "DIV");
	var toEl = getReal(window.event.toElement, "tagName", "DIV");
	if (fromEl == toEl) return;
	
	el = toEl;
	
	if ((el.className == "topFolder") || (el.className == "topItem")) overTopItem(el);
	if ((el.className == "subFolder") || (el.className == "subItem")) overSubItem(el);
	
	if ((el.className == "topItem") || (el.className == "subItem")) {
		if (el.href != null) {
			if (el.oldtitle == null) el.oldtitle = el.title;
			if (el.oldtitle != "")
				el.title = el.oldtitle + "\n" + el.href;
			else
				el.title = el.oldtitle + el.href;
		}
	}
	
	if (el.className == "scrollButton") overscrollButton(el);
}

function handleOut() {
	var fromEl = getReal(window.event.fromElement, "tagName", "DIV");
	var toEl = getReal(window.event.toElement, "tagName", "DIV");
	if (fromEl == toEl) return;
	
	el = fromEl;

	if ((el.className == "topFolder") || (el.className == "topItem")) outTopItem(el);
	if ((el.className == "subFolder") || (el.className == "subItem")) outSubItem(el);
	if (el.className == "scrollButton") outscrollButton(el);
}

function handleDown() {
	el = getReal(window.event.srcElement, "tagName", "DIV");
		
	if (el.className == "scrollButton") {
		downscrollButton(el);
		var mark = Math.max(el.id.indexOf("Up"), el.id.indexOf("Down"));
		var type = el.id.substr(mark);
		var menuID = el.id.substring(0,mark);
		eval("scroll" + type + "(" + menuID + ")");
	}
}

function handleUp() {
	el = getReal(window.event.srcElement, "tagName", "DIV");
		
	if (el.className == "scrollButton") {
		upscrollButton(el);
		window.clearTimeout(scrolltimer);
	}
}

////////////////////// EVERYTHING IS HANDLED ////////////////////////////

function hide(elID) {
	var el = eval(elID);
	el.style.display = "none";
	el.parentElement.openedSub = null;
	if (el.openedSub != null) hide(el.openedSub);
}

function writeSubPadding(depth) {
	var str, str2, val;

	var str = "<style type='text/css'>\n";
	
	for (var i=0; i < depth; i++) {
		str2 = "";
		val  = 0;
		for (var j=0; j < i; j++) {
			str2 += ".sub "
			val += 22;
		}
		str += str2 + ".subFolder {padding-left: " + (val-22) + "px;}\n";
		str += str2 + ".subItem   {padding-left: " + (val-22) + "px;}\n";
	}
	
	str += "</style>\n";
	return str;
}

//If you wan't to change colors do so below

function overTopItem(el) {
	with (el.style) {
		background   = "buttonface";
		borderLeft   = "1px solid buttonhighlight";
		borderRight  = "1px solid buttonshadow";
		borderTop    = "1px solid buttonhighlight";
		borderBottom = "1px solid buttonshadow";
		paddingBottom = "2px";
	}
}

function outTopItem(el) {
	if ((el.sub != null) && (el.parentElement.openedSub == el.sub.id)) { //opened
		with(el.style) {
			borderTop = "1px solid buttonshadow";
			borderLeft  = "1px solid buttonshadow";
			borderRight    = "1px solid buttonhighlight";
			borderBottom = "0px";
			paddingBottom = "3px";
			background = "url(images/tileback.gif) buttonface";
		}
	}
	else {
		with (el.style) {
			border = "1px solid buttonface";
			background = "buttonface";
			padding = "2px";
		}
	}
}

function overSubItem(el) {
	el.style.textDecoration = "underline";
}

function outSubItem(el) {
	el.style.textDecoration = "none";
}

function highlightSubItem(el) {
	el.style.background = "buttonshadow";
	el.style.color      = "white"; //"highlighttext";
	selectedItem = el;
}

function restoreSubItem(el) {
	el.style.background = "url(images/tileback.gif) buttonface";
	el.style.color      = "menutext";
	selectedItem = null;
}

function overscrollButton(el) {
	overTopItem(el);
	el.style.padding = "0px";
}

function outscrollButton(el) {
	outTopItem(el);
	el.style.padding = "0px";
}

function downscrollButton(el) {
	with (el.style) {
		borderRight   = "1px solid buttonhighlight";
		borderLeft  = "1px solid buttonshadow";
		borderBottom    = "1px solid buttonhighlight";
		borderTop = "1px solid buttonshadow";
	}
}

function upscrollButton(el) {
	overTopItem(el);
	el.style.padding = "0px";
}

// ...till here

function getReal(el, type, value) {
	var temp = el;
	while ((temp != null) && (temp.tagName != "BODY")) {
        if (eval("temp." + type) == value) {
			el = temp;
			return el;
		}
		temp = temp.parentElement;
	}
	return el;
}


////////////////////////////////////////////////////////////////////////////////////////
// Fix the scrollbars

var globalScrollContainer;	// Needed because the object is called through windwow.setTimeout
var overflowTimeout = 1;

function fixScroll(el) {
	globalScrollContainer = el;
	window.setTimeout('changeOverflow(globalScrollContainer)', overflowTimeout);
}


function changeOverflow(el) {
	if (el.offsetHeight > el.parentElement.clientHeight)
		window.setTimeout('globalScrollContainer.parentElement.style.overflow = "auto";', overflowTimeout);
	else
		window.setTimeout('globalScrollContainer.parentElement.style.overflow = "hidden";', overflowTimeout);
}

var curCheck;
var curValue='0';
function fun_check(checkboxParent)
{
	var b_check = checkboxParent.checked;
	if ( checkboxParent.type != 'checkbox' )
	{
		return;
	}

/*
	if ( curCheck == checkboxParent )
	{	//重复点选一个 checkbox 对象
		if ( curValue == '' || curValue == '0' )
		{
			curValue = '1';
			b_check = false;
			curCheck.checked = true;
		}else if ( curValue == '1' )
		{
			curValue = '2';
			b_check = true;
			curCheck.checked = true;
		}else
		{
			curValue = '0';
			b_check = false;
			curCheck.checked = false;
		}
	}else
	{
		curCheck = checkboxParent;
		if ( curCheck.checked )
		{
			curValue = '1';
		}else
		{
			curValue = '0';
		}
		return;
		
	}

*/
	/*el = getReal(checkboxParent, "tagName", "DIV");
	if ( el.className == "subFolder" )
	{
		el.sub = eval(el.id + "Sub");
		if ( el.sub )
		{
			var node = el.sub.getElementsByTagName("input");
			//alert (node.length);
			for(i=0;i<node.length;i++)
				node[i].checked=b_check;
		}
	}*/
}

function fun_getName(chkOBJ)
{
	div = getReal(chkOBJ, "tagName", "DIV");
	str1 = div.innerHTML;
	str1 = str1.substring( str1.lastIndexOf(">")+1, str1.length);
	return str1;
}//-->
</SCRIPT>
