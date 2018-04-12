/*-----------------------------------------------------------------------------
CLASS : 共通函数
处理概要 : 检查输入日期是否合法
作者名   : 2010-08-26  zhangqiang
更新者   :
变更内容 :
-----------------------------------------------------------------------------*/

/***************************************************************************************************************

 * 主要方法：

		function IsValidExcel() ------------ 检查用户是否安装Excel
		function CheckExcel() -------------- 检查是否安装EXCEL
		function allTrim(str) -------------- 去掉text中的空格
		function isRightDate(formName,p_year,p_month,p_day) ------------- 日期合法性检查
		function isRightStartAndEndNoEqual(aObjectEnd,aObjectStart) ----- 有效开始时间与有效截止时间合法性检查 add by lxk
		function isRightStartAndEnd(aObjectStart,aObjectEnd) ------------ 有效开始时间与有效截止时间合法性检查 add by lxk
		function isRightStringDate(aObject) ----------- 日期合法性检查 k
		function isRightReportDate(aDate) ------------- 日期合法性检查 k
		function checkNotNull(checkObj,focus) --------- 判断对象是否为 NULL 或 空串
		function InpCheck(Obj,Item) ------------------- 必须项目检查
		function InpCheckMsg(Obj ,Msg) ---------------- 必须项目检查
		function A0Check(Obj,Item,Max, Min) ----------- 检查英文数字
		function NumCheck(Obj,Item,Max,Min) ----------- 检查输入的金额
		function NumValCheck(Obj, Pre, Max, Min) ------ 检查数值
		function getFormatNumber(srcStr,nAfterDot) ---- 取得格式化的数字
		function popWinBussiness(path, obj) ----------- 示例窗口
		function openwin(elmentName) ---------- 弹出时间小页面并返回值
		function showCalDialog() -------------- 显示详细信息
		function openwinBirth(elmentName) ----- 弹出页面并返回值
		function showCalDialogBirth() --------- 弹出PopUp列表页--日期详细信息
		function showDeptDialog(url) ---------- 弹出PopUp列表页--组织（树型结构）详细信息
		function showDateDialog(url) ---------- 时间详细信息
		function showFileDialog(url) ---------- 文件详细信息
		function showEmpDialog(url) ----------- 弹出PopUp列表页--项目详细信息("/com/proSel.jsp") 分包商信息("/com/vendorSel.jsp")
		function showDetail(url) -------------- 显示详细信息
		function getRadioValue(obj) ----------- 取得单选的对象
        function checkRadioValue(obj) ----------- 判断是否选中单选对象
		function redirectPage() --------------- 测试分辨率，并提示
		function onSelectTR(objTR) ------------ 选择的时候改变背景色


		function getSrcInputObj(elmentName)得到事件得到触发的对象相关的返回对象
		function expand(idName) --------------- 展开树型对象的全部child
	    function bitLength()   ---------------- 判断一个字符串的长度，可定义一个汉字占几位
        function OnNumKeypress()--------数字与小数点控制

 ****************************************************************************************************************/

var VarAlpha='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
var VarDigit='0123456789';

/**
 * 检查用户是否安装Excel
 *
 * @version 1.0
 * @return  return  boolean true：正常／false：错误 / null 异常
 * @since   1.0
 */
function IsValidExcel()
{
    try
    {
        new ActiveXObject("WScript.Shell");
    }
    catch(x)
    {
        return false;
    }

    try
    {
        new ActiveXObject("Excel.Application");
    }
    catch(x){
        return null;
    }
    return true;
}

function CheckExcel()
{
    res=IsValidExcel();
    switch(res)
    {
        case true:
            break;
        case null:
            alert("系统提示您： 您没有安装 Excel ，请安装Excel，否则系统的部分功能您将不能使用。");
            return false;
        case false:
            alert("系统提示您： 您的浏览器不准使用 AxtiveX！否则系统的部分功能您将不能使用。");
            return false;
    }

    return true;
}
/**
 * 去掉text中的空格
 *
 * @version 1.0
 * @param   formName     from1
 * @param   参数  需要去掉空格的文本框的名称
 * @return  return  String 为去掉空格后的字符串
 * @since   1.0
*/
function allTrim(str){
  var strReturn;
  var strOld;
   strOld =str.value;
  strReturn=strOld.replace(/(^[\s]*)|([\s]*$)/g, "");
  str.value=strReturn;

}

/**
 * 日期合法性检查
 * 发生错误用 Alert 提示，并将 focus 置于错误处
 *
 * @version 1.0
 * @param   formName     要检查的项目的object的Form 名称
 * @param   p_year   年的Object名称
 * @param   p_month  月的Object名称
 * @param   p_day    日的Object名称
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function isRightDate(formName,p_year,p_month,p_day)
{
    var result = true;
    var day = eval(formName.elements[p_day].value);
    var month = eval(formName.elements[p_month].value);
    var year = eval(formName.elements[p_year].value);

    if(year < 1990 || year > 2100){
        alert("年输入不正确。");
        formName.elements[p_year].focus();
        return false;
    }

    if(month>12 || month == 0){
        alert("月份输入不正确。");
        formName.elements[p_month].focus();
        return false;
    }
    switch(month)
    {
        case 2:
            if(day>29){
                alert("2月份最多为29天!");
                formName.elements[p_day].focus();
                return false;
            }else if(day==29) {
                if (year%400==0 || (year%100!=0 && year%4==0 )){
                    return true;
                }else{
                    alert("润年2月只有28天!");
                    formName.elements[p_day].focus();
                    return false;
                }
            }
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            if(day>30 || day == 0){
                alert( month + "月不满30天!");
                formName.elements[p_day].focus();
                return false;
            }
            break;
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
       case 10:
       case 12:
            if(day>31 || day == 0){
                alert("日 输入不正确!");
                formName.elements[p_day].focus();
                return false;
            }
    }
    return true;
}

/**
 * 有效开始时间与有效截止时间合法性检查 add by lxk
 * 发生错误用 Alert 提示，并将 focus 置于错误处
 *
 * @version 1.0
 * @param  aObjectStart  有效开始时间 yyyy-mm-dd
 * @param  aObjectEnd    有效截止时间 yyyy-mm-dd
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function isRightStartAndEndNoEqual(aObjectEnd,aObjectStart)
{
    var result = true;
    var strStart;
	var strEnd;
    strStart = aObjectStart.value;
    strEnd = aObjectEnd.value;

	if(strStart.replace(" ","")=="" || strEnd.replace(" ","")=="" ){
		return true;
	}

	var fristIndexBegin   = strStart.indexOf('-');
	var fristindexEnd     = strEnd.indexOf('-');

	var secondIndexBegin  = strStart.lastIndexOf('-');
	var secondIndexEnd    = strEnd.lastIndexOf('-');

	var intBeginYear;
	var intEndYear;

	var intBeginMonth;
	var intEndMonth;

	var intBeginDate;
	var intEndDate;

	if(fristIndexBegin==secondIndexBegin && fristindexEnd==secondIndexEnd){

		intBeginYear   = parseInt(strStart.substring(0,fristIndexBegin),10);
		intEndYear     = parseInt(strEnd.substring(0,fristindexEnd),10);

		intBeginDate   = parseInt(strStart.substring(secondIndexBegin+1),10);
		intEndDate     = parseInt(strEnd.substring(secondIndexEnd+1),10);

		intBeginMonth  = intBeginDate;
		intEndMonth    = intEndDate;
	}
	else if(fristIndexBegin!=secondIndexBegin && fristindexEnd!=secondIndexEnd){

		intBeginYear   = parseInt(strStart.substring(0,fristIndexBegin),10);
		intEndYear     = parseInt(strEnd.substring(0,fristindexEnd),10);

		intBeginMonth  = parseInt(strStart.substring(fristIndexBegin+1,secondIndexBegin),10);
		intEndMonth    = parseInt(strEnd.substring(fristindexEnd+1,secondIndexEnd),10);

		intBeginDate   = parseInt(strStart.substring(secondIndexBegin+1),10);
		intEndDate     = parseInt(strEnd.substring(secondIndexEnd+1),10);

	}
	else{
		return false;
	}

    if(intBeginYear>intEndYear){
		return false;
	}
	else if(intBeginYear<intEndYear){
		return true;
	}
	else{
		if(intBeginMonth>intEndMonth){
			return false;
		}
		else if(intBeginMonth<intEndMonth){
			return true;
		}
		else{
			if(intBeginDate>intEndDate){
				return false;
			}
			else{
				return true;
			}
		}
	}
}


/**
 * 有效开始时间与有效截止时间合法性检查 add by lxk
 * 发生错误用 Alert 提示，并将 focus 置于错误处
 *
 * @version 1.0
 * @param  aObjectStart  有效开始时间 yyyy-mm-dd
 * @param  aObjectEnd    有效截止时间 yyyy-mm-dd
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function isRightStartAndEnd(aObjectStart,aObjectEnd)
{
    var result = true;
    var strStart;
	var strEnd;
    strStart = aObjectStart.value;
    strEnd = aObjectEnd.value;

	if(strStart.replace(" ","")=="" || strEnd.replace(" ","")=="" ){
		return true;
	}

	var fristIndexBegin   = strStart.indexOf('-');
	var fristindexEnd     = strEnd.indexOf('-');

	var secondIndexBegin  = strStart.lastIndexOf('-');
	var secondIndexEnd    = strEnd.lastIndexOf('-');

	var intBeginYear;
	var intEndYear;

	var intBeginMonth;
	var intEndMonth;

	var intBeginDate;
	var intEndDate;

	if(fristIndexBegin==secondIndexBegin && fristindexEnd==secondIndexEnd){

		intBeginYear   = parseInt(strStart.substring(0,fristIndexBegin),10);
		intEndYear     = parseInt(strEnd.substring(0,fristindexEnd),10);

		intBeginDate   = parseInt(strStart.substring(secondIndexBegin+1),10);
		intEndDate     = parseInt(strEnd.substring(secondIndexEnd+1),10);

		intBeginMonth  = intBeginDate;
		intEndMonth    = intEndDate;
	}
	else if(fristIndexBegin!=secondIndexBegin && fristindexEnd!=secondIndexEnd){

		intBeginYear   = parseInt(strStart.substring(0,fristIndexBegin),10);
		intEndYear     = parseInt(strEnd.substring(0,fristindexEnd),10);

		intBeginMonth  = parseInt(strStart.substring(fristIndexBegin+1,secondIndexBegin),10);
		intEndMonth    = parseInt(strEnd.substring(fristindexEnd+1,secondIndexEnd),10);

		intBeginDate   = parseInt(strStart.substring(secondIndexBegin+1),10);
		intEndDate     = parseInt(strEnd.substring(secondIndexEnd+1),10);

	}
	else{
		return false;
	}

    if(intBeginYear>intEndYear){
		return false;
	}
	else if(intBeginYear<intEndYear){
		return true;
	}
	else{
		if(intBeginMonth>intEndMonth){
			return false;
		}
		else if(intBeginMonth<intEndMonth){
			return true;
		}
		else{
			if(intBeginDate>intEndDate){
				return false;
			}
			else{
				return true;
			}
		}
	}
}


/**
 * 日期合法性检查 k
 * 发生错误用 Alert 提示，并将 focus 置于错误处
 *
 * @version 1.0
 * @param   isRightStringDate  日期 yyyymmdd
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function isRightStringDate(aObject)
{
    var result = true;
    var strDate;
    strDate = aObject.value;

    var day = eval(strDate.substring(6,8));
    var month = eval(strDate.substring(4,6));
    var year = eval(strDate.substring(0,4));

    if(year < 1990 || year > 2100){
        alert("年输入不正确。");
        aObject.focus();
        return false;
    }

    if(month>12 || month == 0){
        alert("月份输入不正确。");
        aObject.focus();
        return false;
    }
    switch(month)
    {
        case 2:
            if(day>29){
                alert("2月份最多为29天!");
                aObject.focus();
                return false;
            }else if(day==29) {
                if (year%400==0 || (year%100!=0 && year%4==0 )){
                    return true;
                }else{
                    alert("润年2月只有28天!");
                    aObject.focus();
                    return false;
                }
            }
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            if(day>30 || day == 0){
                alert( month + "月不满30天!");
                aObject.focus();
                return false;
            }
            break;
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
       case 10:
       case 12:
            if(day>31 || day == 0){
                alert("日 输入不正确!");
                aObject.focus();
                return false;
            }
    }
    return true;
}

/**
 * 日期合法性检查 k
 * 发生错误用 Alert 提示
 *
 * @version 1.0
 * @param   isRightStringDate  日期 yyyymmdd
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function isRightReportDate(aDate)
{
    var result = true;
    var strDate;
    strDate = aDate;

    var day = eval(strDate.substring(6,8));
    var month = eval(strDate.substring(4,6));
    var year = eval(strDate.substring(0,4));

    if(year < 1990 || year > 2100){
        alert("年输入不正确。");
        aObject.focus();
        return false;
    }

    if(month>12 || month == 0){
        alert("月份输入不正确。");
        aObject.focus();
        return false;
    }
    switch(month)
    {
        case 2:
            if(day>29){
                alert("2月份最多为29天!");
                aObject.focus();
                return false;
            }else if(day==29) {
                if (year%400==0 || (year%100!=0 && year%4==0 )){
                    return true;
                }else{
                    alert("润年2月只有28天!");
                    aObject.focus();
                    return false;
                }
            }
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            if(day>30 || day == 0){
                alert( month + "月不满30天!");
                aObject.focus();
                return false;
            }
            break;
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
       case 10:
       case 12:
            if(day>31 || day == 0){
                alert("日 输入不正确!");
                aObject.focus();
                return false;
            }
    }
    return true;
}

/**
 * desc：	对象是否为 NULL 或 空串
 * parm：	检验的对象 | 为空后的焦点
 * detail：	无
 * author：	ljh
 * date：	2003-12-22
 */
function checkNotNull(checkObj,focus)
{
    var checkStr = checkObj.value;
	var temp = eval(focus);

    if(checkStr.length < 1){
		if ( focus = '' )
		{
			temp =checkObj ;
		}
        temp.focus();
        return false;
    }
    return true;
}

/**
 * 必须项目检查
 * 发生错误用 Alert 提示，并将 focus 置于错误处
 *
 * @version 1.0
 * @param   Obj     要检查的项目的object
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */

function InpCheck(Obj,Item){

    var checkStr = Obj.value;
    var Msg = Item;

    Msg = "必须输入的项目 [" + Item + "] 没有输入值！";

    if(checkStr.length < 1){
        alert(Msg);
        Obj.focus();
        return false;
    }
    return true;
}

/**
 * 必须项目检查
 * 发生错误用 Alert 提示，并将 focus 置于错误处
 *
 * @version 1.0
 * @param   Obj     要检查的项目的object
 * @param   Msg     没有输入时显示的信息
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */

function InpCheckMsg(Obj ,Msg){

    var checkStr = Obj.value;

    if(checkStr.length < 1){
        if (Msg != "") {
            alert(Msg);
            Obj.focus();
        }
        return false;
    }
    return true;
}

/**
 * 检查英文数字
 * 其他检查项目
 * ①输入的项目必须为英文与数字
 * ②输入的个数必须在指定的范围内
 * 发生错误时错误用 alert 表示，并将焦点放在错误位置。
 *
 * @version 1.0
 * @param   Obj     要进行检查的Object
 * @param   Max     最大的输入文字数
 * @param   Min     最小的输入文字数
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */

function A0Check(Obj,Item,Max, Min){

    var checkStr = Obj.value;
    var tempStr;
    var Count;
    var Msg = Item;

    Msg1 = Item + "的行数不正确，请检查后重新输入！";
    Msg2 = Item + "的值不正确，请检查后重新输入！";

    if(Max == Min){
        if(checkStr.length != Max){
            alert(Msg1);
            Obj.focus();
            return false;
        }
    }else{
        if(checkStr.length > Max){
            alert(Msg1);
            Obj.focus();
            return false;
        }
        if(checkStr.length < Min){
            alert(Msg1);
            Obj.focus();
            return false;
        }
    }
    for(Count = 0; Count < Max; Count++){
        tempStr = checkStr.charAt(Count);
        if((VarAlpha.indexOf(tempStr) == -1) &&
                (VarDigit.indexOf(tempStr) == -1)){
			alert(Msg2);
		    Obj.focus();
            return false;
        }
    }
    return true;
}

/**
 * 检查输入的金额
 * 检查项目
 * 1。输入的项目必须是数字
 * 2。数字在指定范围
 * 发生错误时错误用 alert 表示，并将焦点放在错误位置。
 *
 * @version 1.0
 * @param   Obj     要进行检查的Object
 * @param   Max     最大的输入文字数
 * @param   Min     最小的输入文字数
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function NumCheck(Obj,Item,Max,Min){

    var checkStr = Obj.value;
    var tempStr;
    var Count;
    var Msg;
    var Msg1;
    var Msg2;

    Msg  = Item + "的个数不正确，请检查后重新输入！";
    Msg1 = Item + "的个数不正确，请检查后重新输入！";
    Msg2 = Item + "的值不正确，请检查后重新输入！";

    if(Max == Min){
        if(checkStr.length != Max){
            alert(Msg1);
            Obj.focus();
            return false;
        }
    }else{
        if(checkStr.length > Max){
            alert("超过了最大个数！");
            Obj.focus();
            return false;
        }
    }

    for(Count = 0; Count < checkStr.length; Count++){
        tempStr = checkStr.charAt(Count);
        if( VarDigit.indexOf(tempStr) == -1 ){
            alert(Msg2);
            Obj.focus();
            return false;
        }
    }
    return true;
}

/**
 * 检查数值
 * 依次进行如下检查
 * 1。输入的必须是数值
 * 2。检查输入的小数点数值
 * 3。输入的数值在指定的范围内
 * 发生错误时错误用 alert 表示，并将焦点放在错误位置。
 *
 * @version 1.0
 * @param   Obj     僠僃僢僋暥帤楍傪帩偮僆僽僕僃僋僩
 * @param   Pre     小数部分的个数
 * @param   Max     许可的最大数值
 * @param   Min     许可的最小数值
 * @return  return  boolean true：正常／false：错误
 * @since   1.0
 */
function NumValCheck(Obj, Pre, Max, Min){

    var checkStr = Obj.value;
    var ptr;

    if (isNaN(checkStr)) {
        alert("请输入正确的数值！");
        Obj.focus();
        return false;
    }

    ptr = checkStr.indexOf(".", 0) + 1;
    if (ptr > 0) {
        if ((checkStr.length - ptr) > eval(Pre)) {
            if (Pre > 0) {
                alert("请输入小数点后不大于" + Pre + "位的数值！");
            } else {
                alert("请输入整数！");
            }
            Obj.focus();
            return false;
        }
    }

    if(eval(checkStr) < Min || Max < eval(checkStr)){
        alert("请输入从 " + Min + " 到 "+ Max + " 的数值。");
        Obj.focus();
        return false;
    }

    return true;
}
/**
 * Double型数据校验
 *
 * @version 1.0
 * @param   obj 要进行转化的数字对象 dec 小数点后位数 len 长度 msg 字段名 yn 是否必写
 * @return  return  true,false
 * @author  杨丽
 * @since   1.0
 */

function DouCheck(Obj,msg,dec,len,yn){

    var checkStr = Obj.value;
    var ptr;
	if((checkStr == null || checkStr=="") && yn == 'y' ){
		alert('[' + msg + ']'+"不能为空，请输入正确的数值！");
		Obj.focus();
		return true;
	}
	if((checkStr == null || checkStr=="") && yn == 'n' ){
		return false;
	}
    if (isNaN(checkStr)) {
        alert("请输入正确的数值！");
        Obj.focus();
        return true;
    }
    if(checkStr.length>len){
        alert("您输入的数值超出范围，请最多输入13位整数、4位小数！");
        Obj.focus();
        return true;
    }
	if(checkStr.indexOf(".") == 0){
        alert("数值第一位不能是小数点！");
        Obj.focus();
        return true;

	}
    if(checkStr.indexOf(" ") == 0){
        alert("数值第一位不能是空格！");
        Obj.focus();
        return true;

	}
	if(checkStr.indexOf("-")>-1){
        alert("请输入正数！");
        Obj.focus();
        return true;
	}

    ptr = checkStr.indexOf(".", 0) + 1;
    if (ptr > 0) {
        if ((checkStr.length - ptr) > eval(dec)) {
            if (dec > 0) {
                alert("请输入小数点以下" + dec + "位的数值！");
            }
            Obj.focus();
            return true;
        }
    }
    return false;
}

/**
 * 取得格式化的数字
 *
 * @version 1.0
 * @param   srcStr 要进行转化的数字字符串 nAfterDot 小数点后位数
 * @return  return  转化后的数据串
 * @since   1.0
 */
function getFormatNumber(srcStr,nAfterDot){
    var srcStr,nAfterDot;
    var resultStr,nTen;

    srcStr = ""+srcStr+ "";

    strLen = srcStr.length;
    dotPos = srcStr.indexOf(".",0);
    if (dotPos == -1){
        resultStr = srcStr+".";
        for (i=0;i<nAfterDot;i++){
            resultStr = resultStr+"0";
        }
        return resultStr;
    }else{
        if ((strLen - dotPos - 1) >= nAfterDot){
            nAfter = dotPos + nAfterDot + 1;
            nTen =1;
            for(j=0;j<nAfterDot;j++){
                nTen = nTen*10;
            }
            resultStr = Math.round(parseFloat(srcStr)*nTen)/nTen;
            return resultStr;
        }else{
            resultStr = srcStr;
            for (i=0;i<(nAfterDot - strLen + dotPos + 1);i++){
                resultStr = resultStr+"0";
            }

        return resultStr;
        }
    }
}
//示例窗口
function popWinBussiness(path, obj){
    var wNEXT = path + '/popUpBussiness.jsp?txtParm=' + obj;
    StaNavi = window.open(wNEXT,'SelCha','toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=0,resizable=1,width=650,height=400,top=50,left=100');
    StaNavi.opener=self;

    if(navigator.appVersion.charAt >=3){
       StaNavi.focus();
    }

}

//    function rf()
//      {return false; }
//    document.oncontextmenu = rf
//    function keydown()
//      {if(event.keyCode ==93){return false;} }
//      document.onkeydown =keydown
//    function drag()
//      {return false;}
//    document.ondragstart=drag
//function stopmouse(e) {
//		if (navigator.appName == 'Netscape' && (e.which == 3 || e.which == 2))
// 		return false;
//      else if
//      (navigator.appName == 'Microsoft Internet Explorer' && (event.button == 2 || event.button == 3)) {
//  		   alert("城建处项目信息管理系统: 欢迎使用本系统！您只要按鼠标左键，就足够了！ :) ");
//		   return false;
// 		}
//		return true;
//      }
//      document.onmousedown=stopmouse;
//      if (document.layers)
//      window.captureEvents(Event.MOUSEDOWN);
//       window.onmousedown=stopmouse;

function openwin(elmentName)
{

   var aResult = showCalDialog();

   if (aResult != null)
   {
	var scrInputObj=getSrcInputObj(elmentName);
     scrInputObj.value  = aResult;
   }
}

function showCalDialog()
{
   var url="com/calendar.html";
   var aRetVal = showModalDialog(url,"status=no","dialogWidth:240px;dialogHeight:240px;status:no;");
   if (aRetVal != null)
   {
	   var aRetVals=aRetVal.split("-");
	   aRetVal=aRetVals[0];
	   for (i=1;i<aRetVals.length ;i++ )
	   {
		   if (aRetVals[i].length==1)
		   {
				aRetVal+="-0"+aRetVals[i];
		   }
		   else
		   {
				aRetVal+="-"+aRetVals[i];
		   }
	   }
      return aRetVal;
   }
   return null;
}
function openwinBirth(elmentName)
{
   var aResult = showCalDialogBirth();
   if (aResult != null)
   {
     window.document.forms[0].elements[elmentName].value  = aResult;
   }

}

function showCalDialogBirth()
{
   var url="/com/calendarBirthday.html";
   var aRetVal = showModalDialog(url,"status=no","dialogWidth:200px;dialogHeight:230px;status:no;");
   if (aRetVal != null)
   {
      return aRetVal;
   }
   return null;
}
function showDeptDialog(url)
{
   var aRetVal = showModalDialog(url,"status=no","dialogWidth:325px;dialogHeight:600px;status:no;");
   if (aRetVal != null)
   {
      return aRetVal;
   }
   return null;
}

function showDateDialog(url)
{
   var aRetVal = showModalDialog(url,"status=no","dialogwidth=386px;dialogheight=229px;status:no;scroll:no;");
   if (aRetVal != null)
   {
      return aRetVal;
   }
   return null;
}

function showFileDialog(url)
{
   var aRetVal = showModalDialog(url,"status=no","dialogwidth=800px;dialogheight=500px;status:no;scroll:no;");
   if (aRetVal != null)
   {
      return aRetVal;
   }
   return null;
}


function showEmpDialog(url){
   var aRetVal = showModalDialog(url,"status=no","dialogWidth:800px;dialogHeight:500px;status:no;");
   if (aRetVal != null)
   {
      return aRetVal;
   }
   return null;
}

function showDetail(url){

    StaNavi = window.open(url,'SelCha','toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,width=800,height=600,top=50,left=135');
    StaNavi.opener=self;

    if(navigator.appVersion.charAt() >=3){
       StaNavi.focus();
    }

}

//项目类型弹出画面
function openwinProType(elmentName)
{
	var url="ProTypeList.do";
	var aResult = showModalDialog(url,"status=no","dialogWidth:500px;dialogHeight:600px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult;
	}
}
//资金类型弹出列表
function openwinInvestType(elmentName)
{
	var url="InvestTypeList.do";
	var aResult = showModalDialog(url,"status=no","dialogWidth:500px;dialogHeight:600px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult;
	}
}
//经手人弹出画面
function openwinPersonSel(elmentName)
{
	var url="CommonUserFrame.do";
	var aResult = showModalDialog(url,"status=no","dialogWidth:700px;dialogHeight:500px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult;
	}
}
//接受单位弹出列表
function openwinCompanySel(elmentName)
{
	var url="CompanyList.do";
	var aResult = showModalDialog(url,"status=no","dialogWidth:700px;dialogHeight:500px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult;
	}
}

function openwinSpecialty(elmentName)
{
	var url="com/specialtyList.jsp";
	var aResult = showModalDialog(url,"status=no","dialogWidth:200px;dialogHeight:555px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult;
	}
}

function openwinProject(elmentID, elmentName)
{
	var url="CommonProjectFrame.do";
	var aResult = showModalDialog(url,"status=no","dialogWidth:700px;dialogHeight:500px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentID);
		scrInputObj.value  = aResult[0];
        scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult[1];
	}
}

function openwinZDCQ(elmentName)
{
	var url="CommonZDCQFrame.do";
	var aResult = showModalDialog(url,"status=no","dialogWidth:700px;dialogHeight:500px;status:no;scroll=yes;resizable=yes");
	if (aResult != null){
		var scrInputObj=getSrcInputObj(elmentName);
		scrInputObj.value  = aResult;
	}
}

function getRadioValue(obj)
{
  for (var i =0; i< obj.length; i++)
  {
    if (obj[i].checked)
    {
      return obj[i].value;
    }
  }
  if(obj.checked)
  {
    return obj.value;
  }
  return 0;
}

function checkRadioValue(obj) {
    var radArray = document.getElementsByName(obj);
    if (radArray.length == 0) {
        alert("没有数据！");
        return false;
    }
    else {
        for (var i = 0; i < radArray.length; i ++) {
            if (radArray[i].checked) {
                return true;
            }
        }
        alert("请选择数据！");
        return false;
    }
}

function redirectPage() {
	if ((screen.width == 640) && (screen.height == 480))
		size = "640 x 480";
	else if ((screen.width == 800) && (screen.height == 600))
		size = "800 x 600";
	else if ((screen.width == 1024) && (screen.height == 768))
		size = "1024 x 768";
	else size = "the default 640 x 480";

	if(size != "1024 x 768"){
		alert("系统检测，你的屏幕分辨率为 " + size + "，本系统建议采用 1024 x 768,否则数据量过大会引起页面空间不足!");
	}
}

function onSelectTR(objTR){
	if(objTR.style.backgroundColor == "#eeeeff" ){
		objTR.style.backgroundColor="#99ccff" ;
		objTR.cells[0].children[0].checked = true;
		if (document.form1.elements["chkCheckAll"] != null) {
			var li_Num;
			var checkall;
			checkall=true;
			li_Num = parseInt(document.form1.hdnCurRecCount.value);
			for( i = 1; i <= li_Num ; i++ ){
				parmObjName = "chk" + i;
				if(document.form1.elements[parmObjName].checked == false){
					checkall = false;
				}
			}
			if(checkall){
				document.form1.chkCheckAll.checked=true;
			}
		}
	}
	else{
		objTR.style.backgroundColor="#eeeeff" ;
		objTR.cells[0].children[0].checked = false;
		if (document.form1.elements["chkCheckAll"] != null) {
			document.form1.chkCheckAll.checked = false;
		}
	}
}

/*
    功能：得到事件得到触发的对象相关的返回对象
	添加：	zp
	时间：2006-08-21
*/
function getSrcInputObj(elmentName)
{

		var currentImg=window.event.srcElement;//根据事件得到触发的IMG对象
		var inputSrcObj;
		if (currentImg.name=="")
		{
			inputSrcObj=window.document.forms[0].elements[elmentName];
			return inputSrcObj;
		}
		var allimg =document.getElementsByName(currentImg.name);//取得对象

		if (allimg.length>1)
		{
			   var rowPos = 0;
		   for(var i=0;i<allimg.length;i++)
		   {
			   if(allimg[i]==currentImg)
			   {
				   rowPos = i;
				   break;
			   }
		   }
//		 p_item = arguments[0];
//		 p_item=p_item[rowPos];
		 inputSrcObj =  window.document.forms[0].elements[elmentName];
		 inputSrcObj = inputSrcObj[rowPos];
	   }
	   else
	   {
//		 p_item = arguments[0];
		 inputSrcObj = window.document.forms[0].elements[elmentName];

	   }
	   return inputSrcObj;
}


//展开树型对象的全部child
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
//        alert(allImg.length);
		for(i=0;i<allImg.length;i++){
			if ( allImg[i].src.indexOf('/menus/folderclose.gif') != -1 )
            {
//                alert(allImg[i].src);
				allImg[i].src ='/menus/folderopen.gif';
            }
		}

	}
}

/**
 * @version 1.0
 * @auther lizhonghua
 * @date 2006-08-16
 * @param value:全选或全不选
 * @param a:全选复选框对象
 */

function setCheckAll(value,a)
{
  var L = document.forms.length;
  for (var j=0; j<L; j++) {
    var myForm=document.forms[j];
    var length = myForm.length;
    for(var i=0 ; i<length ; i++) {
      if (myForm[i].type=="checkbox" && myForm[i].name=="chk") {
      myForm[i].checked=value;
      }
    }
  }
  for (var j=0; j<L; j++) {
    var myForm=document.forms[j];
    var length = myForm.length;
    for(var i=0 ; i<length ; i++) {
      if (myForm[i].type=="checkbox" && myForm[i].name=="chk" && myForm[i]!=a) {
          myForm[i].onclick=function(){a.checked=false;};
      }
    }
  }
}
function isBlankByHint(str ,hint){
  if( isBlank(str) ){
	alert(hint);
	return true;
  }

  return false;
}

function isBlank(str){
	var returnString = str;
	while(returnString.charAt(0)==" " || returnString.charAt(0)=="\r" || returnString.charAt(0)=="\t" || returnString.charAt(0)=="\n" )
		returnString=returnString.substring(1,returnString.length);
	while(returnString.charAt(returnString.length-1)==" " || returnString.charAt(returnString.length-1)=="\r" || returnString.charAt(returnString.length-1)=="\t" || returnString.charAt(returnString.length-1)=="\n")
		returnString=returnString.substring(0,returnString.length-1);
	return returnString.length<=0;
}

function isLengthOut(str,hint,len){
	if( isLength(str,len)){
		alert(hint);
		return true;
	}
	return false;
}

function isLength(str,len){
	if(bitLength(str) > len){
		return true;
	}
	return false;
}

//字段长度判断,是否为空、是否超长
function chkLthNul(obj,msg,len){
    var checkStr = obj.value;
	if(bitLength(checkStr) <= 0){
	    var lanAlert = '不能为空，请输入！';
	    alert( '[' + msg + ']' + lanAlert );
	    obj.focus();
		return true;
	}
	if(bitLength(checkStr) > len){
	    var lanAlert = '长度最大为' + len + '位，请重新输入！\n注意：一个汉字占2位';
	    alert( '[' + msg + ']' + lanAlert );
	    obj.focus();
		return true;
	}
    return false;
}
//字段可以为空，只做超长判断
function chkLth(obj,msg,len){
	var checkStr = obj.value;
	if(bitLength(checkStr) > len){
	    var lanAlert = '长度最大为' + len + '位，请重新输入！\n注意：一个汉字占2位';
	    alert( '[' + msg + ']' + lanAlert );
	    obj.focus();
		return true;
	}
    return false;
}
//字段非空判断,如时间等不需要长度判断时使用
function chkNul(obj,msg){
    var checkStr = obj.value;
	if(bitLength(checkStr) <= 0){
	    var lanAlert = '不能为空，请输入！';
	    alert( '[' + msg + ']' + lanAlert );
	    obj.focus();
		return true;
	}
	return false;
}
/**
 *名称：bitLength()
 *功能：判断一个字符串的长度，可定义一个汉字占几位
 *形参：
 *返回：长度
 */
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

/**
 *名称：checkKeyCode()
 *功能：校验一个字符串只能含有字母，数字，下划线和“.”
 *参数：Obj[组件对象]
 *      Item[组件名称]
 *返回：true[不含非法字符];false[含有非法字符]
 */
 function checkKeyCode(Obj,Item){
	var checkStr = Obj.value;
	var Count;
	for(Count = 0; Count < checkStr.length; Count++){
        var tempStr = checkStr.charAt(Count);
        if((VarAlpha.indexOf(tempStr) == -1)
			&& (VarDigit.indexOf(tempStr) == -1)
			&& ("_".indexOf(tempStr) == -1)
			&& (".".indexOf(tempStr) == -1)){
			alert('['+Item+'] 只能含有字母，数字，下划线和点!');
		    Obj.focus();
            return false;
        }
    }
    return true;
}

/**
 *名称：haveChineseCharacter()
 *功能：判断一个字符串只能由字母、数字和下划线组成
 *形参：Obj[组件对象]
 * 	   Item[组件名称]
 *     len[字符串长度]
 *返回：true[不含非法字符];false[含有非法字符]
 */
function haveChineseCharacter(Obj,Item,len){
	var checkStr = Obj.value;
    var tempStr;
    var Count;

	for(Count = 0; Count < len; Count++){
        tempStr = checkStr.charAt(Count);
        if((VarAlpha.indexOf(tempStr) == -1) &&
                (VarDigit.indexOf(tempStr) == -1) &&
					("_".indexOf(tempStr) == -1)){
			alert(Item + "只能包含英文、数字和下划线!");
		    Obj.focus();
            return true;
        }
    }
    return false;
}



 ///////////////////////////////////////////////////////////////////////////////////////////////
 //2006-10-21 by zhenjh 控制页面操作
 //以下代码用于确保用户不可以进行以下操作：
 // 1.在表单中按 ENTER 键。
 // 2.点击右键想刷新或者拷贝
 // 3.按住 ctrl 键要拷贝。
 function rf()
 {
	return false;
 }

 //document.oncontextmenu = rf

 function keydown()
 {
    //如果为shift+enter同时按下，则正常处理（用于处理textarea中换行问题）
	if(window.event.keyCode == 13 && window.event.shiftKey){
		return true;
	}

	//截获ENTER KEY
	if (window.event.keyCode==13) {
		alert("如果您要进行提交操作，请您确认页面数据填写完毕后，点击相关的操作按钮继续您的业务操作。本系统禁止进行回车确认操作，避免因此而带来的意外。谢谢合作。");
		return false;
	}

	if(event.keyCode ==93){
	  return false;
	}
}
//document.onkeydown =keydown

//不可拖拽
function drag()
{
  return false;
}

//document.ondragstart=drag

//不可点击右键想选中
function stopmouse(e) {
  if (navigator.appName == 'Netscape' && (e.which == 3 || e.which == 2))
	return false;
  else if
  (navigator.appName == 'Microsoft Internet Explorer' && (event.button == 2 || event.button == 3)) {
	   //alert("欢迎使用东软集团过程财富库管理系统,本系统禁止进行点击鼠标右键操作，避免因此而带来的意外。谢谢合作。 ");
	   return false;
	}
	return true;
}

//document.onmousedown=stopmouse;

if (document.layers)
	window.captureEvents(Event.MOUSEDOWN);

//window.onmousedown=stopmouse;

 //end of 页面处理
 ///////////////////////////////////////////////////////////////////////////

/**
 *名称：chr2Unicode(str)
 *功能：字符串转换成UNICODE

 *形参：Obj[转换对象]
 *返回：返回转换后对象
 */
 function chr2Unicode(str) {
    if ('' != str) {
        var st, t, i;
        st = '';
        for (i = 1; i <= str.length; i ++){
            t = str.charCodeAt(i - 1).toString(16);
            if (t.length < 4)
            while(t.length <4)
                t = '0'.concat(t);
            t = t.slice(2, 4).concat(t.slice(0, 2))
            st = st.concat(t);
        }
        return(st.toUpperCase());
    }
    else {
            return('');
    }
}

//数字与小数点控制
 function OnNumDotKeypress(){
 	if ((event.keyCode < 48|| event.keyCode > 57)&&(event.keyCode != 46)) {
 		event.returnValue = false;
 	}
 }
 //数字控制
 function OnNumKeypress(){
 	if ((event.keyCode < 48|| event.keyCode > 57)) {
 		event.returnValue = false;
 	}
 }

function setFileName(vFile, vName){
	if (vName.value!=""){
		return;
	};
	var obj  = vFile;
	var filename = new Array;
	var value;
	filename = obj.value.split("\\");
	value = filename[filename.length-1];
	if(value.indexOf(".")!=-1){
		value = value.substring(0,value.indexOf("."));
	}else{
		return;
	}
	vName.value = value;
}
