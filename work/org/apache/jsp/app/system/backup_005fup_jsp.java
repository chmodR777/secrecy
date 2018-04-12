package org.apache.jsp.app.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class backup_005fup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/com/begin.jsp");
    _jspx_dependants.add("/WEB-INF/taglib.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fHtmlTable;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.release();
    _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.release();
    _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>系统备份与恢复</title></head>\r\n");
      out.write("\r\n");
      out.write("<body topmargin=0 leftmargin=0 >\r\n");
      out.write("\r\n");

String res = (String) request.getAttribute("res"); 

      out.write("\r\n");
      out.write("<form name=\"form1\" method=\"post\"  enctype=\"multipart/form-data\">\r\n");
      if (_jspx_meth_syntc_005fScriptsCommon_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_syntc_005fTitleHeader_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_syntc_005fFuncHeader_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      if (_jspx_meth_syntc_005fTableTitle_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_syntc_005fHtmlTable_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_syntc_005fTitleFoot_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("var res = \"");
      out.print(res);
      out.write("\";\r\n");
      out.write("if(res ==\"success\"){\r\n");
      out.write("\talert(\"备份成功！\");\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if(res ==\"error\"){\r\n");
      out.write("\talert(\"备份失败！\");\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if(res ==\"re_success\"){\r\n");
      out.write("\talert(\"恢复成功，请重启服务器！\");\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if(res ==\"re_error\"){\r\n");
      out.write("\talert(\"恢复失败！\");\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("function bitLength(str){\r\n");
      out.write("\tif(str==null || str == \"\") return 0;\r\n");
      out.write("\tvar len = 0;\r\n");
      out.write("\tfor(var i=0; i < str.length; i++){\r\n");
      out.write("\t\t//非汉字\r\n");
      out.write("\r\n");
      out.write("\t\tif(str.substring(i,i+1).charCodeAt(0) < 0x4e00){\r\n");
      out.write("\t\t\tlen ++;\r\n");
      out.write("\t\t \tcontinue;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//汉字\r\n");
      out.write("\t\tlen += 2;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn len;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function backup() {\r\n");
      out.write("    document.form1.action = \"BackUp.do\";\r\n");
      out.write("    document.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function check_e_Submit() {\r\n");
      out.write("\t\r\n");
      out.write("\tvar strName = document.getElementById(\"file\").value;\r\n");
      out.write("    if (bitLength(strName) <= 0) {\r\n");
      out.write("      alert(\"[恢复文件]不能为空，请输入！\");\r\n");
      out.write("   \t  document.getElementById(\"file\").focus();\r\n");
      out.write("      return false;\r\n");
      out.write("    }\r\n");
      out.write("\tstrLen = strName.length;\r\n");
      out.write("\tstrSQL = strName.substr (strLen-4,4);\r\n");
      out.write("\tif (\".sql\" != strSQL.toLowerCase ()){\r\n");
      out.write("\t\t\talert(\"请输入正确的恢复文件！\");\r\n");
      out.write("\t\t\t return false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t return true;\r\n");
      out.write("\t\t}\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function backup_e() {\r\n");
      out.write("   var fileName = document.getElementById(\"file\").value;\r\n");
      out.write("   if (check_e_Submit()) {\r\n");
      out.write("       document.form1.action = \"BackUp_Back.do?file=\"+fileName;\r\n");
      out.write("       document.form1.submit();\r\n");
      out.write("   }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_syntc_005fTitleHeader_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TitleHeader
    com.syntc.taglib.html.TitleHeaderTag _jspx_th_syntc_005fTitleHeader_005f0 = (com.syntc.taglib.html.TitleHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.get(com.syntc.taglib.html.TitleHeaderTag.class);
    _jspx_th_syntc_005fTitleHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTitleHeader_005f0.setParent(null);
    // /app/system/backup_up.jsp(15,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("系统管理 >> 系统备份与恢复 ");
    int _jspx_eval_syntc_005fTitleHeader_005f0 = _jspx_th_syntc_005fTitleHeader_005f0.doStartTag();
    if (_jspx_th_syntc_005fTitleHeader_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.reuse(_jspx_th_syntc_005fTitleHeader_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.reuse(_jspx_th_syntc_005fTitleHeader_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fFuncHeader_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:FuncHeader
    com.syntc.taglib.html.FuncHeaderTag _jspx_th_syntc_005fFuncHeader_005f0 = (com.syntc.taglib.html.FuncHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody.get(com.syntc.taglib.html.FuncHeaderTag.class);
    _jspx_th_syntc_005fFuncHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fFuncHeader_005f0.setParent(null);
    // /app/system/backup_up.jsp(16,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("系统备份与恢复");
    // /app/system/backup_up.jsp(16,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setshowall("yes");
    int _jspx_eval_syntc_005fFuncHeader_005f0 = _jspx_th_syntc_005fFuncHeader_005f0.doStartTag();
    if (_jspx_th_syntc_005fFuncHeader_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody.reuse(_jspx_th_syntc_005fFuncHeader_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody.reuse(_jspx_th_syntc_005fFuncHeader_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fTableTitle_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TableTitle
    com.syntc.taglib.html.TableTitleTag _jspx_th_syntc_005fTableTitle_005f0 = (com.syntc.taglib.html.TableTitleTag) _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.get(com.syntc.taglib.html.TableTitleTag.class);
    _jspx_th_syntc_005fTableTitle_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTableTitle_005f0.setParent(null);
    // /app/system/backup_up.jsp(19,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f0.setheader("");
    int _jspx_eval_syntc_005fTableTitle_005f0 = _jspx_th_syntc_005fTableTitle_005f0.doStartTag();
    if (_jspx_eval_syntc_005fTableTitle_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableHeader_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fButtonBase_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fButtonBase_005f1(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableFoot_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_syntc_005fTableTitle_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_syntc_005fTableTitle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.reuse(_jspx_th_syntc_005fTableTitle_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.reuse(_jspx_th_syntc_005fTableTitle_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fTableHeader_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TableHeader
    com.syntc.taglib.html.TableHeaderTag _jspx_th_syntc_005fTableHeader_005f0 = (com.syntc.taglib.html.TableHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.get(com.syntc.taglib.html.TableHeaderTag.class);
    _jspx_th_syntc_005fTableHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTableHeader_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    int _jspx_eval_syntc_005fTableHeader_005f0 = _jspx_th_syntc_005fTableHeader_005f0.doStartTag();
    if (_jspx_th_syntc_005fTableHeader_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.reuse(_jspx_th_syntc_005fTableHeader_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.reuse(_jspx_th_syntc_005fTableHeader_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fButtonBase_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ButtonBase
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f0 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    // /app/system/backup_up.jsp(21,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("备 份");
    // /app/system/backup_up.jsp(21,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setonclick("backup();");
    int _jspx_eval_syntc_005fButtonBase_005f0 = _jspx_th_syntc_005fButtonBase_005f0.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fButtonBase_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ButtonBase
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f1 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f1.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    // /app/system/backup_up.jsp(22,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f1.setcaption("恢 复");
    // /app/system/backup_up.jsp(22,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f1.setonclick("backup_e();");
    int _jspx_eval_syntc_005fButtonBase_005f1 = _jspx_th_syntc_005fButtonBase_005f1.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f1);
    return false;
  }

  private boolean _jspx_meth_syntc_005fTableFoot_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TableFoot
    com.syntc.taglib.html.TableFootTag _jspx_th_syntc_005fTableFoot_005f0 = (com.syntc.taglib.html.TableFootTag) _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.get(com.syntc.taglib.html.TableFootTag.class);
    _jspx_th_syntc_005fTableFoot_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTableFoot_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    int _jspx_eval_syntc_005fTableFoot_005f0 = _jspx_th_syntc_005fTableFoot_005f0.doStartTag();
    if (_jspx_th_syntc_005fTableFoot_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.reuse(_jspx_th_syntc_005fTableFoot_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.reuse(_jspx_th_syntc_005fTableFoot_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fHtmlTable_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:HtmlTable
    com.syntc.taglib.html.HtmlTableTag _jspx_th_syntc_005fHtmlTable_005f0 = (com.syntc.taglib.html.HtmlTableTag) _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.get(com.syntc.taglib.html.HtmlTableTag.class);
    _jspx_th_syntc_005fHtmlTable_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fHtmlTable_005f0.setParent(null);
    int _jspx_eval_syntc_005fHtmlTable_005f0 = _jspx_th_syntc_005fHtmlTable_005f0.doStartTag();
    if (_jspx_eval_syntc_005fHtmlTable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("  <tr>\r\n");
        out.write("    <td class=\"item\" nowrap>恢复文件：</td>\r\n");
        out.write("\t<td class=\"input\">\r\n");
        out.write("     <input type=\"file\" id=\"file\" name=\"file\" size=\"50\">\r\n");
        out.write("    </td>\r\n");
        out.write("  </tr>\r\n");
        int evalDoAfterBody = _jspx_th_syntc_005fHtmlTable_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_syntc_005fHtmlTable_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.reuse(_jspx_th_syntc_005fHtmlTable_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.reuse(_jspx_th_syntc_005fHtmlTable_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fTitleFoot_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TitleFoot
    com.syntc.taglib.html.TitleFootTag _jspx_th_syntc_005fTitleFoot_005f0 = (com.syntc.taglib.html.TitleFootTag) _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody.get(com.syntc.taglib.html.TitleFootTag.class);
    _jspx_th_syntc_005fTitleFoot_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTitleFoot_005f0.setParent(null);
    int _jspx_eval_syntc_005fTitleFoot_005f0 = _jspx_th_syntc_005fTitleFoot_005f0.doStartTag();
    if (_jspx_th_syntc_005fTitleFoot_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody.reuse(_jspx_th_syntc_005fTitleFoot_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody.reuse(_jspx_th_syntc_005fTitleFoot_005f0);
    return false;
  }
}
