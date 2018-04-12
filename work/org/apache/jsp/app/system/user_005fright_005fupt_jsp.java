package org.apache.jsp.app.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class user_005fright_005fupt_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fHtmlTable;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody;
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
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _005fjspx_005ftagPool_005fsyntc_005fTableFoot_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.release();
    _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.release();
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
      out.write("<head><title>用户权限编辑页面</title></head>\r\n");
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
if("1".equals(strSEX)){
	strSEX = "男";
}else if("0".equals(strSEX)){
	strSEX = "女";
} else {
	strSEX = "&nbsp;";
}
String strTEL = StringUtil.convertNull(res.getCell("C_TEL", 1));
if (strTEL.length() == 0) {
	strTEL = "&nbsp;";
}
String strDEP = StringUtil.convertNull(res.getCell("C_DEP", 1));
if (strDEP.length() == 0) {
	strDEP = "&nbsp;";
}

List<String> list = (List<String>)request.getAttribute("list");
//具有菜单权限标志
boolean b_flag = false;

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
          out.write("    <td class=\"item\" width=\"20%\" nowrap>用户名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">");
          out.print(strUSER_CODE );
          out.write("\r\n");
          out.write("      <input type=\"hidden\" name=\"txtUSER_ID\" len=\"10\" value=\"");
          out.print(strUSER_ID );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>姓名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">");
          out.print(strUSER_NAME );
          out.write("\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>性别：</td>\r\n");
          out.write("\t<td class=\"input\">");
          out.print(strSEX );
          out.write("\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>联系电话：</td>\r\n");
          out.write("\t<td class=\"input\">");
          out.print(strTEL );
          out.write("\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>所在部门：</td>\r\n");
          out.write("\t<td class=\"input\">");
          out.print(strDEP );
          out.write("\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>&nbsp;</td>\r\n");
          out.write("\t<td class=\"input\">&nbsp;\r\n");
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
      out.write("<br>\r\n");
      if (_jspx_meth_syntc_005fTableTitle_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  syntc:HtmlTable
      com.syntc.taglib.html.HtmlTableTag _jspx_th_syntc_005fHtmlTable_005f1 = (com.syntc.taglib.html.HtmlTableTag) _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.get(com.syntc.taglib.html.HtmlTableTag.class);
      _jspx_th_syntc_005fHtmlTable_005f1.setPageContext(_jspx_page_context);
      _jspx_th_syntc_005fHtmlTable_005f1.setParent(null);
      int _jspx_eval_syntc_005fHtmlTable_005f1 = _jspx_th_syntc_005fHtmlTable_005f1.doStartTag();
      if (_jspx_eval_syntc_005fHtmlTable_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("<tr class=\"title\">\r\n");
          out.write("\t<th class=\"nm\" nowrap width=\"20%\">选择</th>\r\n");
          out.write("\t<th class=\"nm\" nowrap width=\"30%\">菜单名称</th>\r\n");
          out.write("    <th class=\"nm\" nowrap width=\"50%\">功能描述</th>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t\t");

			b_flag = false;
			for(int i=0; i < list.size(); i++){
				if("1".equals(list.get(i))){
					b_flag = true;
				}
			}
		
          out.write("\r\n");
          out.write("\t\t<input type=\"checkbox\" name=\"menuid\" id=\"m1\" value=\"1\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">患者信息管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">患者信息管理(一级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t\t");

			b_flag = false;
			for(int i=0; i < list.size(); i++){
				if("2".equals(list.get(i))){
					b_flag = true;
				}
			}
		
          out.write("\r\n");
          out.write("\t\t<input type=\"checkbox\" name=\"menuid\" id=\"m2\" value=\"2\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">患者信息查询</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">患者信息查询(一级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("3".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\r\n");
          out.write("\t<input type=\"checkbox\" name=\"menuid\" id=\"m3\" value=\"3\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">咨询信息管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">咨询信息管理(一级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("4".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\r\n");
          out.write("\t<input type=\"checkbox\" name=\"menuid\" id=\"m4\" value=\"4\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">邮药信息管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">邮药信息管理(一级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("5".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\t\r\n");
          out.write("\t<input type=\"checkbox\" name=\"menuid\" id=\"m5\" value=\"5\" onclick=\"chkAllSub('m5')\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">综合统计图表</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">综合统计图表(一级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("6".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m5_1\" value=\"6\" onclick=\"chkItsParent('m5',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;饼状统计图</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">饼状统计图(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("7".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m5_2\" value=\"7\" onclick=\"chkItsParent('m5',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;折线统计图</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">折线统计图(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("8".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m5_3\" value=\"8\" onclick=\"chkItsParent('m5',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;柱形统计图1</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">柱形统计图1(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("9".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m5_4\" value=\"9\" onclick=\"chkItsParent('m5',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;柱形统计图2</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">柱形统计图2(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("10".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t<input type=\"checkbox\" name=\"menuid\" id=\"m6\" value=\"10\" onclick=\"chkAllSub('m6')\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">系统管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">系统管理(一级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("11".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m6_1\" value=\"11\" onclick=\"chkItsParent('m6',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">用户管理(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("12".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m6_2\" value=\"12\" onclick=\"chkItsParent('m6',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权限管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">权限管理(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("13".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m6_3\" value=\"13\" onclick=\"chkItsParent('m6',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员类别管理</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">会员类别管理(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\r\n");
          out.write("\t");

		b_flag = false;
		for(int i=0; i < list.size(); i++){
			if("14".equals(list.get(i))){
				b_flag = true;
			}
		}
	
          out.write("\t\r\n");
          out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"menuid\" id=\"m6_4\" value=\"14\" onclick=\"chkItsParent('m6',this)\" ");
if(b_flag){ 
          out.write("checked");
} 
          out.write("></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统备份与恢复</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">系统备份与恢复(二级菜单)</td>\r\n");
          out.write("</tr>\r\n");
          out.write("<!--  tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>\t\r\n");
          out.write("\t<input type=\"checkbox\" checked></td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">个人密码维护</td>\r\n");
          out.write("    <td class=\"input\" width=\"50%\">个人密码维护(一级菜单)</td>\r\n");
          out.write("</tr>-->\r\n");
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
      out.write(" \r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_syntc_005fTitleFoot_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("function funSave() {\r\n");
      out.write("    document.form1.action = \"UserRightSave.do\";\r\n");
      out.write("    document.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funReturn() {\r\n");
      out.write("    document.form1.action = \"UserRight.do\";\r\n");
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
      out.write("\r\n");
      out.write("//选择所有子菜单\r\n");
      out.write("function chkAllSub(id){\r\n");
      out.write("\tvar parent = document.getElementById(id);\r\n");
      out.write("\tif(parent.checked){\r\n");
      out.write("\t\tif(\"m5\" == id){\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_1\").checked = true;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_2\").checked = true;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_3\").checked = true;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_4\").checked = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(\"m6\" == id){\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_1\").checked = true;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_2\").checked = true;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_3\").checked = true;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_4\").checked = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(\"m5\" == id){\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_1\").checked = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_2\").checked = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_3\").checked = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5_4\").checked = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(\"m6\" == id){\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_1\").checked = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_2\").checked = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_3\").checked = false;\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6_4\").checked = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//选择他的父菜单\r\n");
      out.write("function chkItsParent(parent,node){\r\n");
      out.write("\tif(node.checked){\r\n");
      out.write("\t\tif(\"m5\" == parent){\r\n");
      out.write("\t\t\tdocument.getElementById(\"m5\").checked = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(\"m6\" == parent){\r\n");
      out.write("\t\t\tdocument.getElementById(\"m6\").checked = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(\"m5\" == parent){\r\n");
      out.write("\t\t\tif(document.getElementById(\"m5_1\").checked==false &&\r\n");
      out.write("\t\t\t   document.getElementById(\"m5_2\").checked==false &&\r\n");
      out.write("\t\t\t   document.getElementById(\"m5_3\").checked==false &&\r\n");
      out.write("\t\t\t   document.getElementById(\"m5_4\").checked==false){\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"m5\").checked = false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(\"m6\" == parent){\r\n");
      out.write("\t\t\tif(document.getElementById(\"m6_1\").checked==false &&\r\n");
      out.write("\t\t\t   document.getElementById(\"m6_2\").checked==false &&\r\n");
      out.write("\t\t\t   document.getElementById(\"m6_3\").checked==false &&\r\n");
      out.write("\t\t\t   document.getElementById(\"m6_4\").checked==false){\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"m6\").checked = false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
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
    // /app/system/user_right_upt.jsp(9,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("系统管理 >> 权限管理 >> 编辑权限");
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
    // /app/system/user_right_upt.jsp(10,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("编辑权限");
    // /app/system/user_right_upt.jsp(10,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/system/user_right_upt.jsp(13,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f0.setheader("用户信息");
    int _jspx_eval_syntc_005fTableTitle_005f0 = _jspx_th_syntc_005fTableTitle_005f0.doStartTag();
    if (_jspx_eval_syntc_005fTableTitle_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableHeader_005f0(_jspx_th_syntc_005fTableTitle_005f0, _jspx_page_context))
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
    // /app/system/user_right_upt.jsp(72,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f1.setheader("权限列表");
    int _jspx_eval_syntc_005fTableTitle_005f1 = _jspx_th_syntc_005fTableTitle_005f1.doStartTag();
    if (_jspx_eval_syntc_005fTableTitle_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableHeader_005f1(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fSaveButton_005f0(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fButtonBase_005f0(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
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

  private boolean _jspx_meth_syntc_005fSaveButton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:SaveButton
    com.syntc.taglib.html.SaveButtonTag _jspx_th_syntc_005fSaveButton_005f0 = (com.syntc.taglib.html.SaveButtonTag) _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.get(com.syntc.taglib.html.SaveButtonTag.class);
    _jspx_th_syntc_005fSaveButton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fSaveButton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    int _jspx_eval_syntc_005fSaveButton_005f0 = _jspx_th_syntc_005fSaveButton_005f0.doStartTag();
    if (_jspx_th_syntc_005fSaveButton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.reuse(_jspx_th_syntc_005fSaveButton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fSaveButton_005fnobody.reuse(_jspx_th_syntc_005fSaveButton_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fButtonBase_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ButtonBase
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f0 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    // /app/system/user_right_upt.jsp(75,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("返 回");
    // /app/system/user_right_upt.jsp(75,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setonclick("funReturn();");
    int _jspx_eval_syntc_005fButtonBase_005f0 = _jspx_th_syntc_005fButtonBase_005f0.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
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
