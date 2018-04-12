package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/com/begin.jsp");
  }

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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>top</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      com.syntc.common.bean.Common common = null;
      synchronized (session) {
        common = (com.syntc.common.bean.Common) _jspx_page_context.getAttribute("common", PageContext.SESSION_SCOPE);
        if (common == null){
          common = new com.syntc.common.bean.Common();
          _jspx_page_context.setAttribute("common", common, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      com.syntc.util.ResultObj rsObj = null;
      synchronized (_jspx_page_context) {
        rsObj = (com.syntc.util.ResultObj) _jspx_page_context.getAttribute("rsObj", PageContext.PAGE_SCOPE);
        if (rsObj == null){
          rsObj = new com.syntc.util.ResultObj();
          _jspx_page_context.setAttribute("rsObj", rsObj, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      com.syntc.util.RowSet pageObj = null;
      synchronized (_jspx_page_context) {
        pageObj = (com.syntc.util.RowSet) _jspx_page_context.getAttribute("pageObj", PageContext.PAGE_SCOPE);
        if (pageObj == null){
          pageObj = new com.syntc.util.RowSet();
          _jspx_page_context.setAttribute("pageObj", pageObj, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      com.syntc.common.bean.UserBean UserBean = null;
      synchronized (session) {
        UserBean = (com.syntc.common.bean.UserBean) _jspx_page_context.getAttribute("UserBean", PageContext.SESSION_SCOPE);
        if (UserBean == null){
          UserBean = new com.syntc.common.bean.UserBean();
          _jspx_page_context.setAttribute("UserBean", UserBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

	String path_root = request.getContextPath();
	//session 设置为半小时
	session.setMaxInactiveInterval( 30*60*1 );

    String str_LoginUserCode = UserBean.getUserCode();
    
	//如果session超时，重新登陆 @@wp need change 

	if(str_LoginUserCode.equals("no code")){

      out.write("\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("\talert(\"Session超时，请重新登录！\");\r\n");
      out.write("\tparent.parent.location.href=\"");
      out.print(path_root);
      out.write("/login.jsp\";\r\n");
      out.write("\t\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
 	
	} 

      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=text/css>\r\n");
      out.write("td {\r\n");
      out.write("\tFONT-SIZE: 9pt\r\n");
      out.write("}\r\n");
      out.write("a {\r\n");
      out.write("\tCOLOR: #000000; TEXT-DECORATION: underline\r\n");
      out.write("}\r\n");
      out.write("a:hover {\r\n");
      out.write("\tCOLOR: #e78a29; TEXT-DECORATION: none\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script\tlanguage=\"JavaScript\">\r\n");
      out.write("var cur_pro_id=\"\";\r\n");
      out.write("function funChangePro(proid){\r\n");
      out.write("\tif(cur_pro_id != proid){\r\n");
      out.write("\t\tcur_pro_id = proid;\r\n");
      out.write("\t\tdocument.form_top.submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funClearProid(){\r\n");
      out.write("\tcur_pro_id = \"#\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body text=#000000 leftMargin=0 topMargin=0\tonload=\"javascript:scroll(0,93);\" marginheight= \"0\" marginwidth=\"0\">\r\n");
      out.write("<form name=\"form_top\" action=\"Menu.do\" method=\"post\" target=\"leftFrame\">\r\n");
      out.write("<input type=\"hidden\" name=\"sh_xmxz\" value=\"open\">\r\n");
      out.write("<input type=\"hidden\" name=\"sh_zbht\" value=\"close\">\r\n");
      out.write("<input type=\"hidden\" name=\"sh_tjbb\" value=\"close\">\r\n");
      out.write("<input type=\"hidden\" name=\"sh_xtgl\" value=\"close\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<table cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td background=\"images/frame/top_01.jpg\" height=70>&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"70%\" background=\"images/frame/topbar_01.jpg\" height=22>\r\n");
      out.write("\t\t<table cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td nowrap>\r\n");
      out.write("\t\t\t\t<div align=center><img height=16 src=\"images/frame/bar_00.gif\" width=16></div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td nowrap>『当前用户：");
      out.print(UserBean.getUserName());
      out.write(' ');
      out.write('－');
      out.write(' ');
      out.print(UserBean.getUserCode());
      out.write(" 』</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"100%\" background=\"images/frame/topbar_01.jpg\">\r\n");
      out.write("\t\t<table cellSpacing=0 cellPadding=0 align=right border=0>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=24><img height=16 src=\"images/frame/bar_01.gif\" width=16></td>\r\n");
      out.write("\t\t\t\t<td width=40 nowrap><a href=\"white.htm\" target=mainFrame>首页</a></td>\r\n");
      out.write("\t\t\t\t<td width=24><img height=16 src=\"images/frame/bar_06.gif\" width=16></td> \r\n");
      out.write("\t\t\t\t<td width=40 nowrap><a \r\n");
      out.write("\t\t\t\t\tonclick=\"if (!window.confirm('您确认要退出系统吗？')){return false;}\"\r\n");
      out.write("\t\t\t\t\thref=\"login.jsp\" target=_top>退出</a></td>\r\n");
      out.write("\t\t\t\t<td width=24><img id=indent style=\"CURSOR: hand\"\r\n");
      out.write("\t\t\t\t\tonclick=\"if(parent.topset.rows!='22,*'){parent.topset.rows='22,*';window.scroll(0,93);document.all.indent.src='images/frame/bar_70.gif';}else{parent.topset.rows='93,*';document.all.indent.src='images/frame/bar_07.gif';};\"\r\n");
      out.write("\t\t\t\t\theight=16 src=\"images/frame/bar_07.gif\" width=16 name=indent></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
