<%@	page contentType="text/html; charset=UTF-8"%>
<%@	taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@	include	file="/com/begin.jsp"%>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />

<style>
a{
    color: #000000; text-decoration: underline;
}
a:hover{
    color: #e78a29; text-decoration: none;
}
</style>

</head>
<body topmargin=0 leftmargin=0 class=homebg>
<form method=post action="" name="form1">
<table border=0 width=100%>
<tr>
	<td valign=top>
<br><br><br><br>
<img src="<%=path_root%>/images/frame/home_txt.gif" border=0 alt="" >
	</td>
</tr>
</table>


<div id='shadow' style='visibility:hidden; position:absolute; top:30; left:30; width:30; height:30; z-index:1; background-color:#BED9EB; filter:alpha(opacity=40);'></div>


<script>

 /**
 * 初始化

 */
 move = null; //移动标记
 wmin = 100; //最小的窗口为100x100
 zmax = 10000; //刻录当前的最高层
 ssize = 4; //阴影宽度

 /**
 * 父窗口内按下鼠标时，得到相关的值

 */
 function Down(obj){
  move = 1;
  obj.x = event.x; //鼠标起始位置
  obj.y = event.y;
  obj.l = obj.offsetParent.offsetLeft; //父元素当前位置

  obj.t = obj.offsetParent.offsetTop;
  obj.w = obj.offsetParent.offsetWidth;
  obj.h = obj.offsetParent.offsetHeight;
  Shadow(obj) //重画阴影
  obj.setCapture(); //得到鼠标
 }

 /**
 * 标题栏托动窗口

 */
 function Remove(obj){
  if(move != null){
   obj.offsetParent.style.left = event.x - obj.x + obj.l; // 鼠标移过的位置 + 父元素当前位置

   obj.offsetParent.style.top = event.y - obj.y + obj.t;
   Shadow(obj) //重画阴影
   }
 }

 /**
 * 状态栏改变窗口大小
 */
 function Resize(obj){
  if(move != null){
   obj.offsetParent.style.width = Math.max(wmin, event.x - obj.x + obj.w); //窗口的width, height不能为负数

   obj.offsetParent.style.height = Math.max(wmin, event.y - obj.y + obj.h);
   Shadow(obj) //重画阴影
  }
 }

 /**
 * 放开鼠标时，清理不用的东西

 */
 function Up(obj){
  move = null;
  document.getElementById('shadow').style.visibility = 'hidden'; //隐藏阴影
  obj.releaseCapture(); //释放鼠标
 }

 /**
 * 父窗口按下鼠标时，将当前层置顶

 */
 function Focus(obj){
  zmax = zmax +10; //最高层（变量）每次点击加10，以保证最高

  obj.style.zIndex = zmax; //将当前层置顶，当前层 = 最高层
  document.getElementById('shadow').style.zIndex = zmax - 1; //阴影的层 = 最高层 - 1
 }

 /**
 * 标题栏按下鼠标或移动窗口时，重画阴影
 */
 function Shadow(obj){
  /**
  * 阴影的位置 = 新的父元素位置 + 阴影宽度
  */
  document.getElementById('shadow').style.left = obj.offsetParent.offsetLeft + ssize;
  document.getElementById('shadow').style.top = obj.offsetParent.offsetTop + ssize;
  document.getElementById('shadow').style.width = obj.offsetParent.offsetWidth;
  document.getElementById('shadow').style.height = obj.offsetParent.offsetHeight;
  document.getElementById('shadow').style.visibility = 'visible';
 }

</script>

</form>

</body>
</html>

