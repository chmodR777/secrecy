<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />
</head>
<body>
<%
//提示消息结果集
ResultObj res = (ResultObj) request.getAttribute("res");
String message_id = "";
String pro_name = "";
String pq_name = "";
String message_content = "";
String created_time = "";
String strChk = "";

%>
<form method=post action="" name="form1">

</form>

<SCRIPT LANGUAGE="JavaScript">
<!--
//消息构造
function CLASS_MSN_MESSAGE(id,width,height,caption,title,message,target,action){
    this.id       = id;
    this.title    = title;
    this.caption  = caption;
    this.message  = message;
    this.target   = target;
    this.action   = action;
    this.width    = width?width:0;
    this.height   = height?height:0;
<%if(res.size() > 1){%>
    this.timeout  = 550;
<%} else {%>        
    this.timeout  = 1;
<%}%>        
    this.speed    = 20;
    this.step     = 1;
    this.right    = screen.width -1;
    this.bottom   = screen.height;
    this.left     = this.right - this.width;
    this.top      = this.bottom - this.height;
    this.timer    = 0;
    this.pause    = false;
    this.close    = false;
    this.autoHide = true;
}


//隐藏消息方法
CLASS_MSN_MESSAGE.prototype.hide = function(){
    if(this.onunload()){

        var offset  = this.height>this.bottom-this.top?this.height:this.bottom-this.top;
        var me  = this;

        if(this.timer>0){
            window.clearInterval(me.timer);
        }

        var fun = function(){
            if(me.pause==false||me.close){
                var x  = me.left;
                var y  = 0;
                var width = me.width;
                var height = 0;
                if(me.offset>0){
                    height = me.offset;
                }

                y  = me.bottom - height;

                if(y>=me.bottom){
                    window.clearInterval(me.timer);
                    me.Pop.hide();
                } else {
                    me.offset = me.offset - me.step;
                }
                me.Pop.show(x,y,width,height);
            }
        }

        this.timer = window.setInterval(fun,this.speed)
    }
}

//消息卸载事件，可以重写
CLASS_MSN_MESSAGE.prototype.onunload = function() {
    return true;
}

//消息显示方法
CLASS_MSN_MESSAGE.prototype.show = function(){
    var oPopup = window.parent.parent.frames["topFrame"].createPopup(); //IE5.5+
    this.Pop = oPopup;
    var w = this.width;
    var h = this.height;
    str = ""
    str += " <FORM METHOD=POST ACTION='' name='form1'>"
    str += " <DIV style='Z-INDEX: 500; WIDTH: " + w + "px;POSITION: absolute; TOP: 0px; HEIGHT: " + h + "px; border: 1 solid #BED9EB; background-color: #FFFFFF '>"
    str += "  <table cellspacing=0 cellpadding=0 width='100%' border=0 >"
    str += "    <tr>"
    str += "      <td height=1 width=1><img src=images/table/t_1.jpg></td>"
    str += "      <td class=f_tl nowrap width=30%>" + this.caption + "</td>"
    str += "      <td height=1 width=1><img src=images/table/t_3.jpg></td>"
    str += "      <td class=f_tr align=right>"
    str += "        <table border=0 cellpadding=0 cellspacing=0 width=100%>"
    str += "          <tr>"
    str += "            <td><img scr=images/clear.gif width=1 height=22></td>"
    str += "            <td width='24' class='imagebutlf'><img scr=images/clear.gif width='24' height='1'></td>"
    str += "            <td nowrap width='40' align='center' class='imagebut'>"
    str += "              <SPAN  id='onDel' title=删除 style='FONT-WEIGHT: bold; FONT-SIZE: 12px; CURSOR: hand; COLOR: red; MARGIN-RIGHT: 4px'>删 除</SPAN>"
    str += "            </td>"
    str += "            <td width='14' class='imagebutrg'><img scr=images/clear.gif width='14' height='1'></td>"
    str += "            <td width='24' class='imagebutlf'><img scr=images/clear.gif width='24' height='1'></td>"
    str += "            <td nowrap width='40' align='center' class='imagebut'>"
    str += "              <SPAN title=关闭 style='FONT-WEIGHT: bold; FONT-SIZE: 12px; CURSOR: hand; COLOR: red; MARGIN-RIGHT: 4px' id='btSysClose' >关 闭</SPAN>"
    str += "            </td>"
    str += "            <td width='14' class='imagebutrg'><img scr=images/clear.gif width='14' height='1'></td>"
    str += "          </tr>"
    str += "        </table>"
    str += "      </td>"
    str += "      <td height=1 width=1><img src=images/table/t_5.jpg></td>"
    str += "    </tr>"
    str += "  </table>"
    str += "  <table cellspacing=0 cellpadding=0 width=100% border=0>"
    str += "    <tr>"
    str += "      <td class=f_ml height=1 width=1><img src=images/table/t_9.jpg></td>"
    str += "      <td >"
    str += "        <DIV style='WIDTH:100%;TOP: 0px; HEIGHT:192px;overflow:auto'>"
    str += "          <table width=100% border=0 align=center cellpadding=5 cellspacing=0>"
<%if(res.size() > 1){
      for (int i = 1; i < res.size(); i++) {
          message_id = StringUtil.convertNull(res.getCell("message_id", i));
          pro_name = StringUtil.convertNull(res.getCell("pro_name", i));
          pq_name = StringUtil.convertNull(res.getCell("pq_name", i));
          message_content = StringUtil.convertNull(res.getCell("message_content", i));
          created_time = StringUtil.convertNull(res.getCell("created_time", i));
          if (i == 1) {
              strChk = "checked";
%>
    str += "    <input type='hidden' id='onDelHid' name='onDelHid'>  "
<%
          } else {
              strChk = "";
          }
%>
    str += "            <tr>"
    str += "              <td class='item' align='center' width=10%>"
//    str += "                <INPUT TYPE='radio' <%//=strChk%> NAME='rad' value='<%//=message_id%>' onclick='form1.onDelHid.value=<%//=message_id%>'>"
    str += "                <input type='checkbox' name='chk' value='<%=message_id%>'>"
    str += "              </td>"
    str += "              <td class=nm width=15% align='center'><%=created_time%></td>"
    str += "              <td class=nm align='left'><%=pro_name%><%=pq_name%>专业，<%=message_content%></td>"
    str += "            </tr>"
<%
      }
  } else {
%>
    str += "            <tr>"
    str += "              <td class='item' align='center' width=10%><font color=red>没有提示消息</font></td>"
    str += "            </tr>"
<%}%>
    str += "          </table>"
    str += "        </DIV>  "
    str += "          <table height=20 width='100%'cellspacing=0 cellpadding=0 border=0>"
        str += "    <tr>"
        str += "      <td id='alertMsg'align='center' style='color:red;FILTER:progid:DXImageTransform.Microsoft.Gradient(startColorStr=#FFFFFF, endColorStr=#BED9EB, gradientType=0);'>&nbsp;</td>"
        str += "    </tr>"
    str += "          </table>"
    str += "      </td>"
    str += "      <td class=f_mr height=1 width=1><img src=images/table/t_10.jpg></td>"
    str += "    </tr>"
    str += "    <tr>"
    str += "      <td height=1 width=1><img src=images/table/t_13.jpg></td>"
    str += "      <td class=f_bm><img src=images/table/t_15.jpg></td>"
    str += "      <td height=1 width=1><img src=images/table/t_17.jpg></td>"
    str += "    </tr>"
    str += "  </table>"
    str += "</DIV>  "
    str += "    <link href='css/css.css' type=text/css rel=stylesheet>  "
    str += " </FORM>"
<%if(res.size() <= 1){%>
    str="";
<%}%>        

    oPopup.document.body.innerHTML = str;

    this.offset  = 0;
    var me  = this;

    oPopup.document.body.onmouseover = function(){me.pause=true;}
    oPopup.document.body.onmouseout = function(){me.pause=false;}

    var fun = function(){
        var x  = me.left;
        var y  = 0;
        var width    = me.width;
        var height    = me.height;

            if(me.offset>me.height){
                height = me.height;
            } else {
                height = me.offset;
            }

        y  = me.bottom - me.offset;
        if(y<=me.top){
            me.timeout--;
            if(me.timeout==0){
                window.clearInterval(me.timer);
                if(me.autoHide){
                    me.hide();
                }
            }
        } else {
            me.offset = me.offset + me.step;
        }
        me.Pop.show(x,y,width,height);

    }

    this.timer = window.setInterval(fun,this.speed)
<%if(res.size() >1){%>

    var btClose = oPopup.document.getElementById("btSysClose");
        btClose.onclick = function(){
            me.close = true;
            me.hide();
        }

    var ondel = oPopup.document.getElementById("onDel");  
        ondel.onclick = function(){  
            var radArray = oPopup.document.getElementsByName("chk");
            var hidEle = oPopup.document.getElementsByName("onDelHid");
            var spanMsg = oPopup.document.getElementById("alertMsg");
            var strVal = "";
            if (radArray.length == 0) {
                spanMsg.innerText="没有数据！";
                return false;
            } else {
                for (var i = 0; i < radArray.length; i ++) {
                    if (radArray[i].checked) {
                        if (strVal=="") {
                            strVal += radArray[i].value;
                        } else {
                            strVal += ",";
                            strVal += radArray[i].value;
                        }
                    }
                }
                if (strVal=="") {
                    spanMsg.innerText="请选择数据！";
                    return false;
                }
                hidEle.value = strVal;
            }
            me.hide(); 
            parent.parent.frames["topFrame"].document.frames["iFrmMsg"].location.href = "LoginMsgDel.do?msgID="+ hidEle.value;
    
        }

<%}%>

}

//设置速度方法
CLASS_MSN_MESSAGE.prototype.speed = function(s){
    var t = 20;
    try {
        t = praseInt(s);
    } catch(e){}
    this.speed = t;
}

//设置步长方法
CLASS_MSN_MESSAGE.prototype.step = function(s){
    var t = 1;
    try {
        t = praseInt(s);
    } catch(e){}
    this.step = t;
}

CLASS_MSN_MESSAGE.prototype.rect = function(left,right,top,bottom){
    try {
        this.left = left !=null?left:this.right-this.width;
        this.right = right !=null?right:this.left +this.width;
        this.bottom = bottom!=null?(bottom>screen.height?screen.height:bottom):screen.height;
        this.top = top !=null?top:this.bottom - this.height;
    } catch(e){}
}

<%
  int iWidth = 0;
  int iHeight = 0;
  if(res.size() > 1){
      iWidth = 450;  
      iHeight = 250; 
  }
  
%>
var MSG1 = new CLASS_MSN_MESSAGE("aa",<%=iWidth%>,<%=iHeight%>,"您有<%=res.size()-1%>条消息","","");
    MSG1.rect(null,null,null,screen.height-50);
    MSG1.speed = 20;
    MSG1.step = 10;
    MSG1.show();


//-->
</SCRIPT>

</body>



</html>

