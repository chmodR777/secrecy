package org.apache.jsp.app.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class user_005fmanage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/com/begin.jsp");
    _jspx_dependants.add("/WEB-INF/taglib.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fQueryButton_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fHtmlTable;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005flistfooter_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fQueryButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005flistfooter_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fTitleFoot_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fScriptsCommon_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.release();
    _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fQueryButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.release();
    _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005flistfooter_005fnobody.release();
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

      out.write(" \r\n");
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
      out.write("<html> \r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body topmargin=0 leftmargin=0 onload=\"initHTML();\">\r\n");

	ResultObj res = (ResultObj) request.getAttribute("res");

	// 查询条件-用户名
	String p_UserCode = StringUtil.getRequestData(request.getParameter("txtUserCode"), "");
	// 查询条件-姓名
	String p_UserName = StringUtil.getRequestData(request.getParameter("txtUserName"), "");
	// 查询条件-性别
	String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"), "");
	// 查询条件-联系电话
	String p_Tel = StringUtil.getRequestData(request.getParameter("txtTel"), "");
	// 查询条件-所在部门
	String p_Dep = StringUtil.getRequestData(request.getParameter("txtDep"), "");
	// 查询条件-备注
	String p_Remark = StringUtil.getRequestData(request.getParameter("txtRemark"), "");

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_syntc_005fTitleHeader_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"form1\" action=\"\" method=\"post\">\r\n");
      if (_jspx_meth_syntc_005fScriptsCommon_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"state\">\r\n");
      out.write("<input type=\"hidden\" name=\"actname\" value=\"UserManage.do\">\r\n");
      if (_jspx_meth_syntc_005fFuncHeader_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<br>\r\n");
      if (_jspx_meth_syntc_005fTableTitle_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<div id=\"queryPage\">\r\n");
      //  syntc:HtmlTable
      com.syntc.taglib.html.HtmlTableTag _jspx_th_syntc_005fHtmlTable_005f0 = (com.syntc.taglib.html.HtmlTableTag) _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.get(com.syntc.taglib.html.HtmlTableTag.class);
      _jspx_th_syntc_005fHtmlTable_005f0.setPageContext(_jspx_page_context);
      _jspx_th_syntc_005fHtmlTable_005f0.setParent(null);
      int _jspx_eval_syntc_005fHtmlTable_005f0 = _jspx_th_syntc_005fHtmlTable_005f0.doStartTag();
      if (_jspx_eval_syntc_005fHtmlTable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" width=\"20%\" nowrap>用户名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("      <input type=\"text\" name=\"txtUserCode\" value=\"");
          out.print(p_UserCode);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>姓名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("      <input type=\"text\" name=\"txtUserName\" value=\"");
          out.print(p_UserName);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>性别：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <select name=\"txtSex\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        <option value=\"1\" ");
if (p_Sex.equals("1")) {
          out.write("selected");
}
          out.write(">男</option>\r\n");
          out.write("        <option value=\"0\" ");
if (p_Sex.equals("0")) {
          out.write("selected");
}
          out.write(">女</option>\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>联系电话：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <input type=\"text\" name=\"txtTel\" value=\"");
          out.print(p_Tel);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" width=\"20%\" nowrap>所在部门：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("      <input type=\"text\" name=\"txtDep\" value=\"");
          out.print(p_Dep);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>备注：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("      <input type=\"text\" name=\"txtRemark\" value=\"");
          out.print(p_Remark);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr> \r\n");
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
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      if (_jspx_meth_syntc_005fTableTitle_005f1(_jspx_page_context))
        return;
      out.write("   \r\n");
      out.write("      <!-- 列表例子 -->\r\n");
      out.write("      ");
      //  syntc:HtmlTable
      com.syntc.taglib.html.HtmlTableTag _jspx_th_syntc_005fHtmlTable_005f1 = (com.syntc.taglib.html.HtmlTableTag) _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.get(com.syntc.taglib.html.HtmlTableTag.class);
      _jspx_th_syntc_005fHtmlTable_005f1.setPageContext(_jspx_page_context);
      _jspx_th_syntc_005fHtmlTable_005f1.setParent(null);
      int _jspx_eval_syntc_005fHtmlTable_005f1 = _jspx_th_syntc_005fHtmlTable_005f1.doStartTag();
      if (_jspx_eval_syntc_005fHtmlTable_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        <tr class=\"title\">\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap width=\"1%\">操作</th>\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap>用户名</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>姓名</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>性别</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>联系电话</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>所在部门</th>\r\n");
          out.write("        </tr>\r\n");

if(res.size() > 1){
	for (int i = 1; i < res.size(); i++) {
		//取得id
		String str_id = StringUtil.convertNull(res.getCell("C_ID", i));
		//取得用户编号
		String str_userCode = StringUtil.convertNull(res.getCell("C_CODE", i));
		//取得姓名
		String str_userName = StringUtil.convertNull(res.getCell("C_NAME", i));
		//取得性别
		String str_sexCode = StringUtil.convertNull(res.getCell("C_SEX", i));
		String str_sex = "&nbsp;";
		if ("1".equals(str_sexCode)) {
			str_sex = "男";
		} else if ("0".equals(str_sexCode)) {
			str_sex = "女";
		}
		//取得联系电话
		String str_tel = StringUtil.convertNull(res.getCell("C_TEL", i));
		if (str_tel.length() == 0) {
			str_tel = "&nbsp;";
		}
		//取得所在部门
		String str_dep = StringUtil.convertNull(res.getCell("C_DEP", i));
		if (str_dep.length() == 0) {
			str_dep = "&nbsp;";
		}
		//是否管理员
		String str_roletype = StringUtil.convertNull(res.getCell("C_ROLETYPE", i));
		if("1".equals(str_roletype)){
			str_roletype = "&nbsp;&nbsp;<font color=red>(管理员)</font>";
		} else {
			str_roletype = "";
		}

          out.write("\r\n");
          out.write("        <tr>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap><input type=\"radio\" name=\"rad\" value=\"");
          out.print(str_id);
          out.write("\"></td>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap>");
          out.print(str_userCode);
          out.print(str_roletype );
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_userName);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_sex);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_tel);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_dep);
          out.write("</td>\r\n");
          out.write("        </tr>\r\n");
		}
	}

          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_syntc_005fHtmlTable_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_syntc_005fHtmlTable_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.reuse(_jspx_th_syntc_005fHtmlTable_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.reuse(_jspx_th_syntc_005fHtmlTable_005f1);
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_syntc_005flistfooter_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_syntc_005fTitleFoot_005f0(_jspx_page_context))
        return;
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("function funNew(){\r\n");
      out.write("\tdocument.form1.action = \"UserAdd.do\";\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funModify(){\r\n");
      out.write("\tif (checkRadioValue('rad')) {\r\n");
      out.write("        var radValue = getRadioValue(document.getElementsByName('rad'));\r\n");
      out.write("        document.form1.action = \"UserModify.do?user_id=\" + radValue;\r\n");
      out.write("        document.form1.submit();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funDelele(){\r\n");
      out.write("\tif (checkRadioValue('rad')) {\r\n");
      out.write("        if (confirm(\"您确认要删除数据吗？\")) {\r\n");
      out.write("            var radValue = getRadioValue(document.getElementsByName('rad'));\r\n");
      out.write("            document.form1.action = \"UserDel.do?user_id=\" + radValue;\r\n");
      out.write("            document.form1.submit();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("function funQuery(){\r\n");
      out.write("\tdocument.form1.action = \"UserManage.do\";\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
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
      out.write("</SCRIPT>\r\n");
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

  private boolean _jspx_meth_syntc_005fTitleHeader_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TitleHeader
    com.syntc.taglib.html.TitleHeaderTag _jspx_th_syntc_005fTitleHeader_005f0 = (com.syntc.taglib.html.TitleHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.get(com.syntc.taglib.html.TitleHeaderTag.class);
    _jspx_th_syntc_005fTitleHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTitleHeader_005f0.setParent(null);
    // /app/system/user_manage.jsp(25,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("系统管理	>> 用户管理");
    int _jspx_eval_syntc_005fTitleHeader_005f0 = _jspx_th_syntc_005fTitleHeader_005f0.doStartTag();
    if (_jspx_th_syntc_005fTitleHeader_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.reuse(_jspx_th_syntc_005fTitleHeader_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.reuse(_jspx_th_syntc_005fTitleHeader_005f0);
    return false;
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

  private boolean _jspx_meth_syntc_005fFuncHeader_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:FuncHeader
    com.syntc.taglib.html.FuncHeaderTag _jspx_th_syntc_005fFuncHeader_005f0 = (com.syntc.taglib.html.FuncHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fFuncHeader_0026_005fshowall_005fheader_005fnobody.get(com.syntc.taglib.html.FuncHeaderTag.class);
    _jspx_th_syntc_005fFuncHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fFuncHeader_005f0.setParent(null);
    // /app/system/user_manage.jsp(31,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("用户管理");
    // /app/system/user_manage.jsp(31,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/system/user_manage.jsp(33,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f0.setheader("请输入用户查询的条件");
    int _jspx_eval_syntc_005fTableTitle_005f0 = _jspx_th_syntc_005fTableTitle_005f0.doStartTag();
    if (_jspx_eval_syntc_005fTableTitle_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableHeader_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fQueryButton_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
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

  private boolean _jspx_meth_syntc_005fQueryButton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:QueryButton
    com.syntc.taglib.html.QueryButtonTag _jspx_th_syntc_005fQueryButton_005f0 = (com.syntc.taglib.html.QueryButtonTag) _005fjspx_005ftagPool_005fsyntc_005fQueryButton_005fnobody.get(com.syntc.taglib.html.QueryButtonTag.class);
    _jspx_th_syntc_005fQueryButton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fQueryButton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    int _jspx_eval_syntc_005fQueryButton_005f0 = _jspx_th_syntc_005fQueryButton_005f0.doStartTag();
    if (_jspx_th_syntc_005fQueryButton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fQueryButton_005fnobody.reuse(_jspx_th_syntc_005fQueryButton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fQueryButton_005fnobody.reuse(_jspx_th_syntc_005fQueryButton_005f0);
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

  private boolean _jspx_meth_syntc_005fTableTitle_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TableTitle
    com.syntc.taglib.html.TableTitleTag _jspx_th_syntc_005fTableTitle_005f1 = (com.syntc.taglib.html.TableTitleTag) _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.get(com.syntc.taglib.html.TableTitleTag.class);
    _jspx_th_syntc_005fTableTitle_005f1.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTableTitle_005f1.setParent(null);
    // /app/system/user_manage.jsp(77,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f1.setheader("用户列表");
    int _jspx_eval_syntc_005fTableTitle_005f1 = _jspx_th_syntc_005fTableTitle_005f1.doStartTag();
    if (_jspx_eval_syntc_005fTableTitle_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableHeader_005f1(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fNewButton_005f0(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fModifyButton_005f0(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fDeleteButton_005f0(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableFoot_005f1(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_syntc_005fTableTitle_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_syntc_005fTableTitle_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.reuse(_jspx_th_syntc_005fTableTitle_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTableTitle_0026_005fheader.reuse(_jspx_th_syntc_005fTableTitle_005f1);
    return false;
  }

  private boolean _jspx_meth_syntc_005fTableHeader_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TableHeader
    com.syntc.taglib.html.TableHeaderTag _jspx_th_syntc_005fTableHeader_005f1 = (com.syntc.taglib.html.TableHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.get(com.syntc.taglib.html.TableHeaderTag.class);
    _jspx_th_syntc_005fTableHeader_005f1.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTableHeader_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    int _jspx_eval_syntc_005fTableHeader_005f1 = _jspx_th_syntc_005fTableHeader_005f1.doStartTag();
    if (_jspx_th_syntc_005fTableHeader_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.reuse(_jspx_th_syntc_005fTableHeader_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTableHeader_005fnobody.reuse(_jspx_th_syntc_005fTableHeader_005f1);
    return false;
  }

  private boolean _jspx_meth_syntc_005fNewButton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:NewButton
    com.syntc.taglib.html.NewButtonTag _jspx_th_syntc_005fNewButton_005f0 = (com.syntc.taglib.html.NewButtonTag) _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody.get(com.syntc.taglib.html.NewButtonTag.class);
    _jspx_th_syntc_005fNewButton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fNewButton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    int _jspx_eval_syntc_005fNewButton_005f0 = _jspx_th_syntc_005fNewButton_005f0.doStartTag();
    if (_jspx_th_syntc_005fNewButton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody.reuse(_jspx_th_syntc_005fNewButton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody.reuse(_jspx_th_syntc_005fNewButton_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fModifyButton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ModifyButton
    com.syntc.taglib.html.ModifyButtonTag _jspx_th_syntc_005fModifyButton_005f0 = (com.syntc.taglib.html.ModifyButtonTag) _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody.get(com.syntc.taglib.html.ModifyButtonTag.class);
    _jspx_th_syntc_005fModifyButton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fModifyButton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    int _jspx_eval_syntc_005fModifyButton_005f0 = _jspx_th_syntc_005fModifyButton_005f0.doStartTag();
    if (_jspx_th_syntc_005fModifyButton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody.reuse(_jspx_th_syntc_005fModifyButton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody.reuse(_jspx_th_syntc_005fModifyButton_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fDeleteButton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:DeleteButton
    com.syntc.taglib.html.DeleteButtonTag _jspx_th_syntc_005fDeleteButton_005f0 = (com.syntc.taglib.html.DeleteButtonTag) _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody.get(com.syntc.taglib.html.DeleteButtonTag.class);
    _jspx_th_syntc_005fDeleteButton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fDeleteButton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    int _jspx_eval_syntc_005fDeleteButton_005f0 = _jspx_th_syntc_005fDeleteButton_005f0.doStartTag();
    if (_jspx_th_syntc_005fDeleteButton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody.reuse(_jspx_th_syntc_005fDeleteButton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody.reuse(_jspx_th_syntc_005fDeleteButton_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fTableFoot_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TableFoot
    com.syntc.taglib.html.TableFootTag _jspx_th_syntc_005fTableFoot_005f1 = (com.syntc.taglib.html.TableFootTag) _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.get(com.syntc.taglib.html.TableFootTag.class);
    _jspx_th_syntc_005fTableFoot_005f1.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTableFoot_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    int _jspx_eval_syntc_005fTableFoot_005f1 = _jspx_th_syntc_005fTableFoot_005f1.doStartTag();
    if (_jspx_th_syntc_005fTableFoot_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.reuse(_jspx_th_syntc_005fTableFoot_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.reuse(_jspx_th_syntc_005fTableFoot_005f1);
    return false;
  }

  private boolean _jspx_meth_syntc_005flistfooter_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:listfooter
    com.syntc.taglib.common.ListFooterTag _jspx_th_syntc_005flistfooter_005f0 = (com.syntc.taglib.common.ListFooterTag) _005fjspx_005ftagPool_005fsyntc_005flistfooter_005fnobody.get(com.syntc.taglib.common.ListFooterTag.class);
    _jspx_th_syntc_005flistfooter_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005flistfooter_005f0.setParent(null);
    int _jspx_eval_syntc_005flistfooter_005f0 = _jspx_th_syntc_005flistfooter_005f0.doStartTag();
    if (_jspx_th_syntc_005flistfooter_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005flistfooter_005fnobody.reuse(_jspx_th_syntc_005flistfooter_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005flistfooter_005fnobody.reuse(_jspx_th_syntc_005flistfooter_005f0);
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
