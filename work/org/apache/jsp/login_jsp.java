package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
String path	=	request.getContextPath();	
	String loginMess = request.getParameter("p_LoginState");
	if(loginMess == null){
		loginMess = "";
	}


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link\thref=\"");
      out.print(path);
      out.write("/css/css.css\" type=text/css rel=stylesheet>\r\n");
      out.write("<title>沈阳友好肾病医院信息管理系统</title>\r\n");
      out.write("<syntc:ScriptsCommon />\r\n");
      out.write("\r\n");
      out.write("<script\tlanguage=javascript>\r\n");
      out.write("function funonload(){\r\n");
      out.write("\tdocument.loginFrm.txtUserCode.focus();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function mysubmit(){\r\n");
      out.write("\tvar\tv_user = document.loginFrm.txtUserCode.value;\r\n");
      out.write("\tvar\tv_pwd\t=\tdocument.loginFrm.txtUserPwd.value;\r\n");
      out.write("\tif(v_user\t== null\t|| v_user\t== \"\"){\r\n");
      out.write("\t\talert(\"请输入用户名！\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(v_pwd ==\tnull ||\tv_pwd\t== \"\"){\r\n");
      out.write("\t\talert(\"请输入密码！\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tdocument.loginFrm.action=\"");
      out.print( path );
      out.write("/Login.do\";\r\n");
      out.write("\tdocument.loginFrm.submit();\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checksubmit(){\r\n");
      out.write("\tif(event.keyCode ==\t13){\r\n");
      out.write("\t\tmysubmit();\r\n");
      out.write("\t}\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function myclear(){\r\n");
      out.write("\tdocument.loginFrm.txtUserCode.value\t= \"\";\t\r\n");
      out.write("\tdocument.loginFrm.txtUserPwd.value = \"\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body\ttopmargin=\"50\" leftmargin=\"0\"\tonkeydown=\"checksubmit()\" onload=\"funonload()\">\r\n");
      out.write("\r\n");
      out.write("<form\tname=\"loginFrm\"\taction=\"Login.do\"\tmethod=\"post\">\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\"\tvalign=\"center\">\r\n");
      out.write("\r\n");
      out.write("<!-- 头部 -->\r\n");
      out.write("<table cellpadding=\"0\" cellspacing=\"0\" topmargin=\"0\" leftmargin=\"0\"\tborder=0 width=730>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" topmargin=\"0\" leftmargin=\"0\"\tborder=0 width=100%>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td\twidth=280 align=left><img src=\"");
      out.print(path);
      out.write("/images/login/head1.gif\" border=0></td>\r\n");
      out.write("\t\t\t\t\t<td\tbgcolor=\"#ffffff\" background =\"");
      out.print(path);
      out.write("/images/login/headbg2.gif\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("<!-- 中左 -->\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" topmargin=\"0\" leftmargin=\"0\"\tborder=0 width=100%>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td\twidth=280 align=left><img\tsrc=\"");
      out.print(path);
      out.write("/images/login/left.gif\"\tborder=0></td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" topmargin=\"0\" leftmargin=\"0\"\tborder=0 width=100%>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td\twidth=115 align=left><img src=\"");
      out.print(path);
      out.write("/images/login/bar1.gif\" border=0></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td align=center valign=top>\r\n");
      out.write("\r\n");
      out.write("<!-- 中部 -->\r\n");
      out.write("<table cellpadding=\"0\" cellspacing=\"0\" topmargin=\"0\" leftmargin=\"0\"\tborder=0 width=70%>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=2 height=30>&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=2 align=center>");
if(!loginMess.equals("")){
      out.write("<font color=red>用户名或密码错误！</font>");
}
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=2 height=25>&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td\talign=\"center\" nowrap height=30>用户名：</td>\r\n");
      out.write("\t\t<td\talign=\"right\" nowrap><INPUT\tTYPE=\"text\"\tNAME=\"txtUserCode\" size=\"10\" style=\"width:120\" value=\"\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td\talign=\"center\" nowrap height=30>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>\r\n");
      out.write("\t\t<td\talign=\"right\" nowrap><INPUT\tTYPE=\"password\"\tNAME=\"txtUserPwd\" size=\"12\" style=\"width:120\" value=\"\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td></td>\r\n");
      out.write("\t\t<td\talign=\"right\" nowrap height=30>\r\n");
      out.write("\t\t\t<INPUT TYPE=\"button\" VALUE=\" 登录 \" onclick=\"mysubmit()\">&nbsp;\r\n");
      out.write("\t\t\t<INPUT TYPE=\"button\" VALUE=\" 清除 \" onclick=\"myclear()\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<!-- 中右 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td\twidth=11 bgcolor=\"#ffffff\" valign=bottom align=right><img src=\"");
      out.print(path);
      out.write("/images/login/bow.gif\"\tborder=0></td>\r\n");
      out.write("\t\t\t\t\t<td\twidth=11 background=\"");
      out.print(path);
      out.write("/images/login/bg.gif\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("<!-- 下部 -->\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td\twidth=100% height=11 background=\"");
      out.print(path);
      out.write("/images/login/bg.gif\"></td>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td\theight=20>&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">zq开发小组\t版权所有 2010</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
