<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head><title>招标专业选择页面</title></head>
<body topmargin=0 leftmargin=0 bgcolor="#efefff">
<form name="form1" method="post">
<syntc:ScriptsCommon />
<table>
<tr>
  <td colspan="4"></td>
</tr>
<tr>
  <td colspan="4"></td>
</tr>
<tr>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="3">主体工程</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2"><input type="radio" name="rad" value="道路">道路</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2"><input type="radio" name="rad" value="桥梁">桥梁</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2"><input type="radio" name="rad" value="排水">排水</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2"><input type="radio" name="rad" value="标段">标段</td>
</tr>
<tr>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="3">附属工程</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2">路灯工程</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="灯杆">灯杆</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="线缆">线缆</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="灯具">灯具</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2">交警</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="信号灯具">信号灯具</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="信号灯杆">信号灯杆</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="信号线缆">信号线缆</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="信号灯岗安装">信号灯岗安装</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="信号机采购">信号机采购</td>
</tr>
<tr>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td colspan="2">交通设施</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="标志">标志</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="标线">标线</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="标示">标示</td>
</tr>
<tr>
  <td></td>
  <td></td>
  <td><img src="../images/channel/open.gif"></td>
  <td><input type="radio" name="rad" value="交通护栏">交通护栏</td>
</tr>
<tr>
  <td colspan="4"></td>
</tr>
<tr>
  <td colspan="4"></td>
</tr>
<tr>
  <td colspan="4" align="center">
    <input type="button" value="确 定" onclick="funSave();" style="cursor:hand;"><input type="button" value="返 回" onclick="funBack();" style="cursor:hand;">
  </td>
</tr>
</table>
</form>
</body>
<script language="JavaScript">
function funSave() {
    if (checkRadioValue('rad')) {
        var radValue = getRadioValue(document.getElementsByName('rad'));
        window.returnValue=radValue;
        window.close();
    }
}

function funBack() {
    window.close();
}
</script>
</html>