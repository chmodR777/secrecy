package org.apache.jsp.app.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class pic_005fpie_005fchart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody;
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
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.release();
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
      out.write("<head><title>综合信息统计</title></head>\r\n");
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

	String flag = (String)request.getAttribute("flag");
	String startYear = (String)request.getAttribute("startYear");
	String startMonth = (String)request.getAttribute("startMonth");
	String endYear = (String)request.getAttribute("endYear");
	String endMonth = (String)request.getAttribute("endMonth");
	String level1 = (String)request.getAttribute("level1");
	String level2 = (String)request.getAttribute("level2");

	level1 = level1 == null ? "0" : level1;
	level2 = level2 == null ? "0" : level2;
	
	String chartPath = request.getSession().getServletContext().getContextPath()+"/chart";

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
          out.write("    <td class=\"item\" width=\"20%\">开始年份：\r\n");
          out.write("      <input type=\"hidden\" name=\"txtLevel1\" value=\"");
          out.print(level1 );
          out.write("\">\r\n");
          out.write("      <input type=\"hidden\" name=\"txtLevel2\" value=\"");
          out.print(level2 );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("\t  <select name=\"txtStartYear\">\r\n");
          out.write("\t    <option value=\"\">--请选择--</option>\r\n");
          out.write("\t    <option value=\"1988\" ");
 if("1988".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1988</option>\r\n");
          out.write("\t    <option value=\"1989\" ");
 if("1989".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1989</option>\r\n");
          out.write("\t    <option value=\"1990\" ");
 if("1990".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1990</option>\r\n");
          out.write("\t    <option value=\"1991\" ");
 if("1991".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1991</option>\r\n");
          out.write("\t    <option value=\"1992\" ");
 if("1992".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1992</option>\r\n");
          out.write("\t    <option value=\"1993\" ");
 if("1993".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1993</option>\r\n");
          out.write("\t    <option value=\"1994\" ");
 if("1994".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1994</option>\r\n");
          out.write("\t    <option value=\"1995\" ");
 if("1995".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1995</option>\r\n");
          out.write("\t    <option value=\"1996\" ");
 if("1996".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1996</option>\r\n");
          out.write("\t    <option value=\"1997\" ");
 if("1997".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1997</option>\r\n");
          out.write("\t    <option value=\"1998\" ");
 if("1998".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1998</option>\r\n");
          out.write("\t    <option value=\"1999\" ");
 if("1999".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">1999</option>\r\n");
          out.write("\t    <option value=\"2000\" ");
 if("2000".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2000</option>\r\n");
          out.write("\t    <option value=\"2001\" ");
 if("2001".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2001</option>\r\n");
          out.write("\t    <option value=\"2002\" ");
 if("2002".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2002</option>\r\n");
          out.write("\t    <option value=\"2003\" ");
 if("2003".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2003</option>\r\n");
          out.write("\t    <option value=\"2004\" ");
 if("2004".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2004</option>\r\n");
          out.write("\t    <option value=\"2005\" ");
 if("2005".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2005</option>\r\n");
          out.write("\t    <option value=\"2006\" ");
 if("2006".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2006</option>\r\n");
          out.write("\t    <option value=\"2007\" ");
 if("2007".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2007</option>\r\n");
          out.write("\t    <option value=\"2008\" ");
 if("2008".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2008</option>\r\n");
          out.write("\t    <option value=\"2009\" ");
 if("2009".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2009</option>\r\n");
          out.write("\t    <option value=\"2010\" ");
 if("2010".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2010</option>\r\n");
          out.write("\t    <option value=\"2011\" ");
 if("2011".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2011</option>\r\n");
          out.write("\t    <option value=\"2012\" ");
 if("2012".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2012</option>\r\n");
          out.write("\t    <option value=\"2013\" ");
 if("2013".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2013</option>\r\n");
          out.write("\t    <option value=\"2014\" ");
 if("2014".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2014</option>\r\n");
          out.write("\t    <option value=\"2015\" ");
 if("2015".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2015</option>\r\n");
          out.write("\t    <option value=\"2016\" ");
 if("2016".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2016</option>\r\n");
          out.write("\t    <option value=\"2017\" ");
 if("2017".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2017</option>\r\n");
          out.write("\t    <option value=\"2018\" ");
 if("2018".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2018</option>\r\n");
          out.write("\t    <option value=\"2019\" ");
 if("2019".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2019</option>\r\n");
          out.write("\t    <option value=\"2020\" ");
 if("2020".equals(startYear)){ 
          out.write("selected");
 } 
          out.write(">2020</option>\r\n");
          out.write("\t  </select><font color=\"red\">*</font>\r\n");
          out.write("\t</td>\r\n");
          out.write("    <td class=\"item\" width=\"20%\">开始月份：\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("\t  <select name=\"txtStartMonth\">\r\n");
          out.write("\t    <option value=\"\">--请选择--</option>\r\n");
          out.write("\t    <option value=\"01\" ");
 if("01".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">01</option>\r\n");
          out.write("\t    <option value=\"02\" ");
 if("02".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">02</option>\r\n");
          out.write("\t    <option value=\"03\" ");
 if("03".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">03</option>\r\n");
          out.write("\t    <option value=\"04\" ");
 if("04".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">04</option>\r\n");
          out.write("\t    <option value=\"05\" ");
 if("05".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">05</option>\r\n");
          out.write("\t    <option value=\"06\" ");
 if("06".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">06</option>\r\n");
          out.write("\t    <option value=\"07\" ");
 if("07".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">07</option>\r\n");
          out.write("\t    <option value=\"08\" ");
 if("08".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">08</option>\r\n");
          out.write("\t    <option value=\"09\" ");
 if("09".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">09</option>\r\n");
          out.write("\t    <option value=\"10\" ");
 if("10".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">10</option>\r\n");
          out.write("\t    <option value=\"11\" ");
 if("11".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">11</option>\r\n");
          out.write("\t    <option value=\"12\" ");
 if("12".equals(startMonth)){ 
          out.write("selected");
 } 
          out.write(">12</option>\r\n");
          out.write("\t  </select><font color=\"red\">*</font>\r\n");
          out.write("\t</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" width=\"20%\">结束年份：\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("\t  <select name=\"txtEndYear\">\r\n");
          out.write("\t  \t<option value=\"\">--请选择--</option>\r\n");
          out.write("\t  \t<option value=\"1988\" ");
 if("1988".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1988</option>\r\n");
          out.write("\t    <option value=\"1989\" ");
 if("1989".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1989</option>\r\n");
          out.write("\t    <option value=\"1990\" ");
 if("1990".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1990</option>\r\n");
          out.write("\t    <option value=\"1991\" ");
 if("1991".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1991</option>\r\n");
          out.write("\t    <option value=\"1992\" ");
 if("1992".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1992</option>\r\n");
          out.write("\t    <option value=\"1993\" ");
 if("1993".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1993</option>\r\n");
          out.write("\t    <option value=\"1994\" ");
 if("1994".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1994</option>\r\n");
          out.write("\t    <option value=\"1995\" ");
 if("1995".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1995</option>\r\n");
          out.write("\t    <option value=\"1996\" ");
 if("1996".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1996</option>\r\n");
          out.write("\t    <option value=\"1997\" ");
 if("1997".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1997</option>\r\n");
          out.write("\t    <option value=\"1998\" ");
 if("1998".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1998</option>\r\n");
          out.write("\t    <option value=\"1999\" ");
 if("1999".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">1999</option>\r\n");
          out.write("\t    <option value=\"2000\" ");
 if("2000".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2000</option>\r\n");
          out.write("\t    <option value=\"2001\" ");
 if("2001".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2001</option>\r\n");
          out.write("\t    <option value=\"2002\" ");
 if("2002".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2002</option>\r\n");
          out.write("\t    <option value=\"2003\" ");
 if("2003".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2003</option>\r\n");
          out.write("\t    <option value=\"2004\" ");
 if("2004".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2004</option>\r\n");
          out.write("\t    <option value=\"2005\" ");
 if("2005".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2005</option>\r\n");
          out.write("\t    <option value=\"2006\" ");
 if("2006".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2006</option>\r\n");
          out.write("\t    <option value=\"2007\" ");
 if("2007".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2007</option>\r\n");
          out.write("\t    <option value=\"2008\" ");
 if("2008".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2008</option>\r\n");
          out.write("\t    <option value=\"2009\" ");
 if("2009".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2009</option>\r\n");
          out.write("\t    <option value=\"2010\" ");
 if("2010".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2010</option>\r\n");
          out.write("\t    <option value=\"2011\" ");
 if("2011".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2011</option>\r\n");
          out.write("\t    <option value=\"2012\" ");
 if("2012".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2012</option>\r\n");
          out.write("\t    <option value=\"2013\" ");
 if("2013".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2013</option>\r\n");
          out.write("\t    <option value=\"2014\" ");
 if("2014".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2014</option>\r\n");
          out.write("\t    <option value=\"2015\" ");
 if("2015".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2015</option>\r\n");
          out.write("\t    <option value=\"2016\" ");
 if("2016".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2016</option>\r\n");
          out.write("\t    <option value=\"2017\" ");
 if("2017".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2017</option>\r\n");
          out.write("\t    <option value=\"2018\" ");
 if("2018".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2018</option>\r\n");
          out.write("\t    <option value=\"2019\" ");
 if("2019".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2019</option>\r\n");
          out.write("\t    <option value=\"2020\" ");
 if("2020".equals(endYear)){ 
          out.write("selected");
 } 
          out.write(">2020</option>\r\n");
          out.write("\t  </select><font color=\"red\">*</font>\r\n");
          out.write("\t</td>\r\n");
          out.write("    <td class=\"item\" width=\"20%\">结束月份：\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\">\r\n");
          out.write("\t  <select name=\"txtEndMonth\">\r\n");
          out.write("\t  \t<option value=\"\">--请选择--</option>\r\n");
          out.write("\t    <option value=\"01\" ");
 if("01".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">01</option>\r\n");
          out.write("\t    <option value=\"02\" ");
 if("02".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">02</option>\r\n");
          out.write("\t    <option value=\"03\" ");
 if("03".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">03</option>\r\n");
          out.write("\t    <option value=\"04\" ");
 if("04".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">04</option>\r\n");
          out.write("\t    <option value=\"05\" ");
 if("05".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">05</option>\r\n");
          out.write("\t    <option value=\"06\" ");
 if("06".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">06</option>\r\n");
          out.write("\t    <option value=\"07\" ");
 if("07".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">07</option>\r\n");
          out.write("\t    <option value=\"08\" ");
 if("08".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">08</option>\r\n");
          out.write("\t    <option value=\"09\" ");
 if("09".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">09</option>\r\n");
          out.write("\t    <option value=\"10\" ");
 if("10".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">10</option>\r\n");
          out.write("\t    <option value=\"11\" ");
 if("11".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">11</option>\r\n");
          out.write("\t    <option value=\"12\" ");
 if("12".equals(endMonth)){ 
          out.write("selected");
 } 
          out.write(">12</option>\r\n");
          out.write("\t  </select><font color=\"red\">*</font>\r\n");
          out.write("\t</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\">一级统计项：</td>\r\n");
          out.write("    <td class=\"input\" width=\"30%\">\r\n");
          out.write("      <select name=\"txtLevel1Type\" onchange=\"setLevel2Type()\">\r\n");
          out.write("      \t<option value=\"\">--请选择--</option>\r\n");
          out.write("        <option value=\"1\" ");
 if("1".equals(level1)){ 
          out.write("selected");
 } 
          out.write(">患者</option>\r\n");
          out.write("        <option value=\"2\" ");
 if("2".equals(level1)){ 
          out.write("selected");
 } 
          out.write(">咨询</option>\r\n");
          out.write("        <option value=\"3\" ");
 if("3".equals(level1)){ 
          out.write("selected");
 } 
          out.write(">邮药</option>\r\n");
          out.write("      </select><font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" width=\"20%\">二级统计项：</td>\r\n");
          out.write("    <td class=\"input\" width=\"30%\">\r\n");
          out.write("    \t<select name=\"txtLevel2Type\">\r\n");
          out.write("      \t<option value=\"\">--请选择--</option>\r\n");
          out.write("      </select><font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
 if("2".equals(flag)){ 
          out.write("\r\n");
          out.write("  <tr>\r\n");
          out.write("\t<td class=\"input\" colspan=\"4\">\r\n");
          out.write("      <img alt=\"\" src=\"");
          out.print(chartPath );
          out.write("/PicPieChart.jpg\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  \r\n");
 } 
          out.write('\r');
          out.write('\n');
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
      out.write("function checkSubmit() {\r\n");
      out.write("    if (chkNul(form1.txtStartYear, \"统计开始年份\")) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.txtStartMonth, \"统计开始月份\")) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.txtEndYear, \"统计结束年份\")) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.txtEndMonth, \"统计结束月份\")) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.txtLevel1Type, \"一级统计项\")) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.txtLevel2Type, \"二级统计项\")) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    return true;\r\n");
      out.write("}\r\n");
      out.write("function compute(){\r\n");
      out.write("\tif (checkSubmit()) {\r\n");
      out.write("\t\tdocument.form1.action = \"PicCakeChart.do?flag=2\";\r\n");
      out.write("\t    document.form1.submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function setLevel2Type(){\r\n");
      out.write("\tvar level1 = document.form1.txtLevel1Type;\r\n");
      out.write("\tvar level2 = document.form1.txtLevel2Type;\r\n");
      out.write("\tif(level1.value == \"1\"){\r\n");
      out.write("\t\tdeleteOption();\r\n");
      out.write("\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\tlevel2.options[1] = option; \r\n");
      out.write("\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\tlevel2.options[4] = option; \r\n");
      out.write("\t}else if(level1.value == \"2\"){\r\n");
      out.write("\t\tdeleteOption();\r\n");
      out.write("\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\tlevel2.options[1] = option; \r\n");
      out.write("\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\tlevel2.options[4] = option; \r\n");
      out.write("\t}else if(level1.value == \"3\"){\r\n");
      out.write("\t\tdeleteOption();\r\n");
      out.write("\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\tlevel2.options[1] = option; \r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tdeleteOption();\r\n");
      out.write("\t} \r\n");
      out.write("}\r\n");
      out.write("function deleteOption(){\r\n");
      out.write("\tvar level2 = document.form1.txtLevel2Type;\r\n");
      out.write("\tfor(var i=level2.options.length; i > 0; i--){\r\n");
      out.write("\t\tlevel2.options[i] = null;\r\n");
      out.write("\t}\r\n");
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
      out.write("\tvar level1 = document.form1.txtLevel1;\r\n");
      out.write("\tvar level2 = document.form1.txtLevel2;\r\n");
      out.write("\tonLoadSelect(level1.value,level2.value);\r\n");
      out.write("}\r\n");
      out.write("function onLoadSelect(lv1,lv2){\r\n");
      out.write("\tvar level2 = document.form1.txtLevel2Type;\r\n");
      out.write("\tif(\"1\" == lv1){\r\n");
      out.write("\t\tif(\"1\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option; \r\n");
      out.write("\t\t\tlevel2.options[1].selected = true;\r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t}else if(\"2\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tlevel2.options[2].selected = true;\r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t}else if(\"3\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option;\r\n");
      out.write("\t\t\tlevel2.options[3].selected = true; \r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t}else if(\"4\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option;\r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t\tlevel2.options[4].selected = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else if(\"2\" == lv1){\r\n");
      out.write("\t\tif(\"1\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option;\r\n");
      out.write("\t\t\tlevel2.options[1].selected = true; \r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t}else if(\"2\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option;\r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tlevel2.options[2].selected = true;\r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t}else if(\"3\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option;\r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\t\tlevel2.options[3].selected = true;\r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t}else if(\"4\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"性别\",\"1\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option;\r\n");
      out.write("\t\t\tvar option = new Option(\"年龄\",\"2\");\r\n");
      out.write("\t\t\tlevel2.options[2] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[3] = option; \r\n");
      out.write("\t\t\tvar option = new Option(\"媒体方式\",\"4\");\r\n");
      out.write("\t\t\tlevel2.options[4] = option;\r\n");
      out.write("\t\t\tlevel2.options[4].selected = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else if(\"3\" == lv1){\r\n");
      out.write("\t\tif(\"3\" == lv2){\r\n");
      out.write("\t\t\tvar option = new Option(\"所在地区\",\"3\");\r\n");
      out.write("\t\t\tlevel2.options[1] = option;\r\n");
      out.write("\t\t\tlevel2.options[1].selected = true; \r\n");
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
    // /app/system/pic_pie_chart.jsp(9,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("综合统计图表 >> 饼状统计图");
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
    // /app/system/pic_pie_chart.jsp(10,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("饼状统计图");
    // /app/system/pic_pie_chart.jsp(10,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/system/pic_pie_chart.jsp(13,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f0 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f0);
    // /app/system/pic_pie_chart.jsp(15,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("统   计");
    // /app/system/pic_pie_chart.jsp(15,0) name = width type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setwidth("40");
    // /app/system/pic_pie_chart.jsp(15,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setonclick("compute()");
    int _jspx_eval_syntc_005fButtonBase_005f0 = _jspx_th_syntc_005fButtonBase_005f0.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
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
