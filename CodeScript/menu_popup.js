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
			background = "url(/images/tileback.gif) buttonface";
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
	el.style.background = "url(/images/tileback.gif) buttonface";
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
	el = getReal(checkboxParent, "tagName", "DIV");
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
	}
}

function fun_getName(chkOBJ)
{
	div = getReal(chkOBJ, "tagName", "DIV");
	str1 = div.innerHTML;
	str1 = str1.substring( str1.lastIndexOf(">")+1, str1.length);
	return str1;
}