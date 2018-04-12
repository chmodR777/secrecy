package org.apache.jsp.app.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/com/begin.jsp");
    _jspx_dependants.add("/WEB-INF/taglib.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody.release();
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

      out.write("\r\n");
      out.write("\r\n");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      if (_jspx_meth_syntc_005fScriptsCommon_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("a{\r\n");
      out.write("    color: #000000; text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("a:hover{\r\n");
      out.write("    color: #e78a29; text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body topmargin=0 leftmargin=0 class=homebg>\r\n");
      out.write("<form method=post action=\"\" name=\"form1\">\r\n");
      out.write("<table border=0 width=100%>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td valign=top>\r\n");
      out.write("<br><br><br><br>\r\n");
      out.write("<img src=\"");
      out.print(path_root);
      out.write("/images/frame/home_txt.gif\" border=0 alt=\"\" >\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id='shadow' style='visibility:hidden; position:absolute; top:30; left:30; width:30; height:30; z-index:1; background-color:#BED9EB; filter:alpha(opacity=40);'></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 初始化\r\r\n");
      out.write("\r\n");
      out.write(" */\r\n");
      out.write(" move = null; //移动标记\r\n");
      out.write(" wmin = 100; //最小的窗口为100x100\r\n");
      out.write(" zmax = 10000; //刻录当前的最高层\r\n");
      out.write(" ssize = 4; //阴影宽度\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 父窗口内按下鼠标时，得到相关的值\r\r\n");
      out.write("\r\n");
      out.write(" */\r\n");
      out.write(" function Down(obj){\r\n");
      out.write("  move = 1;\r\n");
      out.write("  obj.x = event.x; //鼠标起始位置\r\n");
      out.write("  obj.y = event.y;\r\n");
      out.write("  obj.l = obj.offsetParent.offsetLeft; //父元素当前位置\r\r\n");
      out.write("\r\n");
      out.write("  obj.t = obj.offsetParent.offsetTop;\r\n");
      out.write("  obj.w = obj.offsetParent.offsetWidth;\r\n");
      out.write("  obj.h = obj.offsetParent.offsetHeight;\r\n");
      out.write("  Shadow(obj) //重画阴影\r\n");
      out.write("  obj.setCapture(); //得到鼠标\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 标题栏托动窗口\r\r\n");
      out.write("\r\n");
      out.write(" */\r\n");
      out.write(" function Remove(obj){\r\n");
      out.write("  if(move != null){\r\n");
      out.write("   obj.offsetParent.style.left = event.x - obj.x + obj.l; // 鼠标移过的位置 + 父元素当前位置\r\r\n");
      out.write("\r\n");
      out.write("   obj.offsetParent.style.top = event.y - obj.y + obj.t;\r\n");
      out.write("   Shadow(obj) //重画阴影\r\n");
      out.write("   }\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 状态栏改变窗口大小\r\n");
      out.write(" */\r\n");
      out.write(" function Resize(obj){\r\n");
      out.write("  if(move != null){\r\n");
      out.write("   obj.offsetParent.style.width = Math.max(wmin, event.x - obj.x + obj.w); //窗口的width, height不能为负数\r\r\n");
      out.write("\r\n");
      out.write("   obj.offsetParent.style.height = Math.max(wmin, event.y - obj.y + obj.h);\r\n");
      out.write("   Shadow(obj) //重画阴影\r\n");
      out.write("  }\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 放开鼠标时，清理不用的东西\r\r\n");
      out.write("\r\n");
      out.write(" */\r\n");
      out.write(" function Up(obj){\r\n");
      out.write("  move = null;\r\n");
      out.write("  document.getElementById('shadow').style.visibility = 'hidden'; //隐藏阴影\r\n");
      out.write("  obj.releaseCapture(); //释放鼠标\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 父窗口按下鼠标时，将当前层置顶\r\r\n");
      out.write("\r\n");
      out.write(" */\r\n");
      out.write(" function Focus(obj){\r\n");
      out.write("  zmax = zmax +10; //最高层（变量）每次点击加10，以保证最高\r\r\n");
      out.write("\r\n");
      out.write("  obj.style.zIndex = zmax; //将当前层置顶，当前层 = 最高层\r\n");
      out.write("  document.getElementById('shadow').style.zIndex = zmax - 1; //阴影的层 = 最高层 - 1\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write(" /**\r\n");
      out.write(" * 标题栏按下鼠标或移动窗口时，重画阴影\r\n");
      out.write(" */\r\n");
      out.write(" function Shadow(obj){\r\n");
      out.write("  /**\r\n");
      out.write("  * 阴影的位置 = 新的父元素位置 + 阴影宽度\r\n");
      out.write("  */\r\n");
      out.write("  document.getElementById('shadow').style.left = obj.offsetParent.offsetLeft + ssize;\r\n");
      out.write("  document.getElementById('shadow').style.top = obj.offsetParent.offsetTop + ssize;\r\n");
      out.write("  document.getElementById('shadow').style.width = obj.offsetParent.offsetWidth;\r\n");
      out.write("  document.getElementById('shadow').style.height = obj.offsetParent.offsetHeight;\r\n");
      out.write("  document.getElementById('shadow').style.visibility = 'visible';\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_syntc_005fScriptsCommon_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ScriptsCommon
    com.syntc.taglib.html.ScriptsCommonTag _jspx_th_syntc_005fScriptsCommon_005f0 = (com.syntc.taglib.html.ScriptsCommonTag) _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody.get(com.syntc.taglib.html.ScriptsCommonTag.class);
    _jspx_th_syntc_005fScriptsCommon_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fScriptsCommon_005f0.setParent(null);
    int _jspx_eval_syntc_005fScriptsCommon_005f0 = _jspx_th_syntc_005fScriptsCommon_005f0.doStartTag();
    if (_jspx_th_syntc_005fScriptsCommon_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody.reuse(_jspx_th_syntc_005fScriptsCommon_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody.reuse(_jspx_th_syntc_005fScriptsCommon_005f0);
    return false;
  }
}
