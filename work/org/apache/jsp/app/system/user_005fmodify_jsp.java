package org.apache.jsp.app.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class user_005fmodify_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody;
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
    _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.release();
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
      out.write("<html>\r\n");
      out.write("<head><title>用户信息修改页面</title></head>\r\n");
      out.write("<body topmargin=0 leftmargin=0 onload=\"initHTML();\">\r\n");
      out.write("<form name=\"form1\" method=\"post\">\r\n");
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

ResultObj res = (ResultObj)request.getAttribute("res");

String strUSER_ID = StringUtil.convertNull(res.getCell("C_ID", 1));
String strUSER_CODE = StringUtil.convertNull(res.getCell("C_CODE", 1));
String strUSER_NAME = StringUtil.convertNull(res.getCell("C_NAME", 1));
String strSEX = StringUtil.convertNull(res.getCell("C_SEX", 1));
String strTEL = StringUtil.convertNull(res.getCell("C_TEL", 1));
String strDEP = StringUtil.convertNull(res.getCell("C_DEP", 1));
String strROLETYPE = StringUtil.convertNull(res.getCell("C_ROLETYPE", 1));
String strREMARK = StringUtil.convertNull(res.getCell("C_REMARK", 1)).replaceAll("<br>", "\r");

      out.write('\r');
      out.write('\n');
      //  syntc:HtmlTable
      com.syntc.taglib.html.HtmlTableTag _jspx_th_syntc_005fHtmlTable_005f0 = (com.syntc.taglib.html.HtmlTableTag) _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.get(com.syntc.taglib.html.HtmlTableTag.class);
      _jspx_th_syntc_005fHtmlTable_005f0.setPageContext(_jspx_page_context);
      _jspx_th_syntc_005fHtmlTable_005f0.setParent(null);
      int _jspx_eval_syntc_005fHtmlTable_005f0 = _jspx_th_syntc_005fHtmlTable_005f0.doStartTag();
      if (_jspx_eval_syntc_005fHtmlTable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" width=\"20%\" nowrap>用户名(数字,字母,下划线)：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("      <input type=\"text\" name=\"txtUSER_CODE\" value=\"");
          out.print(strUSER_CODE );
          out.write("\">\r\n");
          out.write("      <input type=\"hidden\" name=\"txtUSER_ID\" value=\"");
          out.print(strUSER_ID );
          out.write("\">\r\n");
          out.write("      <font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>姓名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("      <input type=\"text\" name=\"txtUSER_NAME\" value=\"");
          out.print(strUSER_NAME );
          out.write("\">\r\n");
          out.write("      <font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>性别：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <select name=\"txtSEX\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        <option value=\"1\" ");
if (strSEX.equals("1")) {
          out.write("selected");
}
          out.write(">男</option>\r\n");
          out.write("        <option value=\"0\" ");
if (strSEX.equals("0")) {
          out.write("selected");
}
          out.write(">女</option>\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>联系电话：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <input type=\"text\" name=\"txtTEL\" value=\"");
          out.print(strTEL );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>所在部门：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <input type=\"text\" name=\"txtDEP\" value=\"");
          out.print(strDEP );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>是否管理员：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <select name=\"txtRoleType\">\r\n");
          out.write("        <option value=\"1\" ");
if (strROLETYPE.equals("1")) {
          out.write("selected");
}
          out.write(">是</option>\r\n");
          out.write("        <option value=\"0\" ");
if (strROLETYPE.equals("0")) {
          out.write("selected");
}
          out.write(">否</option>\r\n");
          out.write("      </select><font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>备注：</td>\r\n");
          out.write("\t<td class=\"input\" colspan=\"3\">\r\n");
          out.write("      <textarea name=\"txtREMARK\" rows=\"3\" cols=\"64\">");
          out.print(strREMARK );
          out.write("</textarea>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          int evalDoAfterBody = _jspx_th_syntc_005fHtmlTable_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_syntc_005fHtmlTable_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.reuse(_jspx_th_syntc_005fHtmlTable_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.reuse(_jspx_th_syntc_005fHtmlTable_005f0);
      out.write("\r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_syntc_005fTitleFoot_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("function checkUserCode(value){\r\n");
      out.write("\tvar reg = \"^\\\\w+$\";\r\n");
      out.write("\tvar flag = value.match(reg);\r\n");
      out.write("\treturn flag;\r\n");
      out.write("}\r\n");
      out.write("function checkSubmit() {\r\n");
      out.write("    if (chkLthNul(form1.txtUSER_CODE, \"用户名\", 32)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }else{\r\n");
      out.write("    \tif(null == checkUserCode(form1.txtUSER_CODE.value)){\r\n");
      out.write("\t\t\talert(\"用户名只能为数字，字母，下划线!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("    if (chkLthNul(form1.txtUSER_NAME, \"姓名\", 32)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    maxLength = form1.txtTEL.len;\r\n");
      out.write("    if (chkLth(form1.txtTEL, \"联系电话\", 32)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    maxLength = form1.txtDEP.len;\r\n");
      out.write("    if (chkLth(form1.txtDEP, \"所在部门\", 64)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    maxLength = form1.txtREMARK.len;\r\n");
      out.write("    if (chkLth(form1.txtREMARK, \"备注\", 1024)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    return true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funSave() {\r\n");
      out.write("    if (checkSubmit()) {\r\n");
      out.write("        document.form1.action = \"UserModifySave.do\";\r\n");
      out.write("        document.form1.submit();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funReturn() {\r\n");
      out.write("    document.form1.action = \"UserManage.do\";\r\n");
      out.write("    document.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function initHTML(){\r\n");
      out.write("\t");

	    String str_PopMsg = StringUtil.convertNull((String)request.getAttribute("pop_Msg"));
	    if (!str_PopMsg.equals("")){
	
      out.write("\r\n");
      out.write("\t    alert(\"");
      out.print(str_PopMsg);
      out.write("\");\r\n");
      out.write("\t");

	    }
	
      out.write("\r\n");
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
    // /app/system/user_modify.jsp(9,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("系统管理 >> 用户管理 >> 修改");
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
    // /app/system/user_modify.jsp(10,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("用户修改");
    // /app/system/user_modify.jsp(10,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/system/user_modify.jsp(13,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
        if (_jspx_meth_syntc_005fSaveButton_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fButtonBase_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
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

  private boolean _jspx_meth_syntc_005fSaveButton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:SaveButton
    com.syntc.taglib.html.SaveButtonTag _jspx_th_syntc_005fSaveButton_005f0 = (com.syntc.taglib.html.SaveButtonTag) _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.get(com.syntc.taglib.html.SaveButtonTag.class);
    _jspx_th_syntc_005fSaveButton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fSaveButton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    int _jspx_eval_syntc_005fSaveButton_005f0 = _jspx_th_syntc_005fSaveButton_005f0.doStartTag();
    if (_jspx_th_syntc_005fSaveButton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.reuse(_jspx_th_syntc_005fSaveButton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.reuse(_jspx_th_syntc_005fSaveButton_005f0);
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
    // /app/system/user_modify.jsp(16,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("返 回");
    // /app/system/user_modify.jsp(16,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setonclick("funReturn();");
    int _jspx_eval_syntc_005fButtonBase_005f0 = _jspx_th_syntc_005fButtonBase_005f0.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
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
