<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%
	String path	= request.getContextPath();	
	String loginMess = request.getParameter("p_LoginState");
	if (loginMess == null) {
		loginMess = "";
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>保密教育管理平台</title>
    <script type="text/javascript" src="<%=path%>/lib/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/superslide.2.1.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/bootstrap/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="<%=path%>/lib/bootstrap/css/bootstrap.min.css">
</head>
<body onkeydown="checksubmit()" onload="funonload()">
<style type="text/css">
    * { margin: 0;  padding: 0; list-style: none; }
    body { background: #fff;  font: normal 12px/22px 微软雅黑,宋体; width: 100%; }
    img {  border: 0; }
    a { text-decoration: none; color: #333; }
    a:hover {  color: #1974A1; }
    .container {width: 100%; position: absolute;height: 520px; top:50%; margin-top:-300px; padding:0px; }
    .fullSlide {width: 100%; position: relative;height: 480px;}
    .fullSlide .bd {margin: 0 auto;position: relative;z-index: 0;overflow: hidden; }
    .fullSlide .bd ul { width: 100% !important;  }
    .fullSlide .bd li {  width: 100% !important; height: 480px;  overflow: hidden; text-align: center;  }
    .fullSlide .bd li a { display: block;  height: 410px; }
    .fullSlide .hd { width: 100%;  position: absolute; z-index: 1; bottom: 0px; left: 0; height: 30px;  line-height: 30px; }
    .fullSlide .hd ul { text-align: center; }
    .fullSlide .hd ul li {
        cursor: pointer; display: inline-block; *display: inline; zoom: 1; width: 42px;  height: 11px; margin: 1px;
        overflow: hidden; background: #000;  filter: alpha(opacity=50); opacity: 0.5; line-height: 999px;
    }
    .fullSlide .hd ul .on { background: #f00;  }
    .fullSlide .prev, .fullSlide .next {
        display: block; position: absolute; z-index: 1; top: 50%; margin-top: -30px; left: 5%; z-index: 1;
        width: 40px; height: 60px;  background: url(/images/login/slider-arrow.png) -126px -137px #000 no-repeat;
        cursor: pointer; filter: alpha(opacity=50); opacity: 0.5; display: none;
    }
    .fullSlide .next { left: auto; right: 5%; background-position: -6px -137px;  }
    .logo{ max-width:1000px; margin:0 auto; }
    .loginPanel { max-width: 1200px;  margin: 0 auto;  /*position: relative;*/ background: #fff; position:relative;  }
    .loginPanel .login {
        display: block; position: absolute; z-index: 99; font: normal 14px 微软雅黑,宋体;
        overflow: hidden; width: 240px; *width: 210px; background-color: red;
        top: 120px;  right: 100px; padding: 40px 0 50px 30px;
        background-color: white;  opacity: 1;  filter: alpha(opacity=100);
        -webkit-box-shadow: 0px 0px 2px rgba(0,0,0,0.13), 0px 1px 5px rgba(0,0,0,0.36), inset 0px 0px 0px 1px rgba(255,255,255,0.69);
        -moz-box-shadow: 0px 0px 2px rgba(0,0,0,0.13), 0px 1px 5px rgba(0,0,0,0.36), inset 0px 0px 0px 1px rgba(255,255,255,0.69);
        box-shadow: 0px 0px 2px rgba(0,0,0,0.13), 0px 1px 5px rgba(0,0,0,0.36), inset 0px 0px 0px 1px rgba(255,255,255,0.69);
        border-radius: 5px;  -webkit-border-radius: 5px;  -moz-border-radius: 5px;
    }
    .login h1 {  font: normal 20px 微软雅黑,黑体; margin: 0 0 20px 0;  }
    .login input, .login button{  width: 180px; font-family:微软雅黑,宋体;}
    .btn-login:hover {  background-color: rgb(147,199,25); }
    .footer{ margin:0 auto; max-width:1000px; text-align:center; line-height:3em;}
    .footer a{ color:#666;}
    .modal-title{ font-family:微软雅黑,宋体; }
    .form-control{ *height:22px; *line-height:22px; *width: 156px !important; /*for ie7*/ }
</style>
<div class="container">
    <div class="logo"><img src="/images/login/logo_login.png" /></div>
    <div class="fullSlide">

        <div class="loginPanel">
            <div class="login">
                <form name="loginFrm" action="Login.do"	method="post">
                    <h1>登录窗口</h1>
                    <div class="form-group">
                        <label class="sr-only" for="txtUserCode">用户名</label>
                        <input type="text" class="form-control" id="txtUserCode" name="txtUserCode" placeholder="输入用户名" >
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="txtUserPwd">密码</label>
                        <input type="password" class="form-control" id="txtUserPwd" name="txtUserPwd" placeholder="输入密码" >
                    </div>
                    <input type="button" class="btn btn-success" value="登录" onclick="mysubmit()">
                </form>
            </div>
        </div>
        <div class="bd">
            <ul>
                <li _src="url(/images/login/2.jpg)" style="background: #F2E1C3 center 0 no-repeat;"></li>
                <li _src="url(/images/login/3.jpg)" style="background: #56A9DB center 0 no-repeat;"></li>
                <li _src="url(/images/login/1.jpg)" style="background: #97BECD center 0 no-repeat;"></li>
            </ul>
        </div>
        <div class="hd">
            <ul>
            </ul>
        </div>
        <span class="prev"></span><span class="next"></span>

    </div>
<!--    <div class="footer">-->
<!--        <span class="help-block">单位名称单位名称单位名称 &copy; 版权所有</span>-->
<!--    </div>-->
</div>
<script type="text/javascript">

jQuery(".fullSlide").hover(function () {
        jQuery(this).find(".prev,.next").stop(true, true).fadeTo("show", 0.5)
    },
    function () {
        jQuery(this).find(".prev,.next").fadeOut()
    });
jQuery(".fullSlide").slide({
    titCell: ".hd ul",
    mainCell: ".bd ul",
    effect: "fold",
    autoPlay: true,
    autoPage: true,
    trigger: "click",
    delayTime: 1000,
    interTime: 5000,
    startFun: function (i) {
        var curLi = jQuery(".fullSlide .bd li").eq(i);
        if (!!curLi.attr("_src")) {
            curLi.css("background-image", curLi.attr("_src")).removeAttr("_src")
        }
    }
});

function funonload() {
	document.loginFrm.txtUserCode.focus();
}

function mysubmit() {
	var	v_user = document.loginFrm.txtUserCode.value;
	var	v_pwd = document.loginFrm.txtUserPwd.value;

	if (v_user == null || v_user == "") {
		alert("请输入用户名！");
		return;
	}
	if (v_pwd == null || v_pwd == "") {
		alert("请输入密码！");
		return;
	} 


	document.loginFrm.action="<%=path%>/Login.do";
	document.loginFrm.submit();
}

function checksubmit() {
	if (event.keyCode == 13) {
		mysubmit();
	}	
}
</script>
</body>
</html>
