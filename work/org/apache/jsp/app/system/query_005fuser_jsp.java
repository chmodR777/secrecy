package org.apache.jsp.app.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class query_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody;
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
    _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.release();
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
      out.write("<body topmargin=0 leftmargin=0>\r\n");

	ResultObj res = (ResultObj) request.getAttribute("res");


	String memTypeOptionList = (String) request.getAttribute("memTypeOptionList");
	String p_ILL_TypeOptionList = (String) request.getAttribute("p_ILL_TypeOptionList");
	String sexOptionList = (String) request.getAttribute("sexOptionList");
	String mediaTypeOptionList = (String) request.getAttribute("mediaTypeOptionList");
	String companyOptionList = (String) request.getAttribute("companyOptionList");
	String provinceOptionList = (String) request.getAttribute("provinceOptionList");
	String cityOptionList = (String) request.getAttribute("cityOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	Map provinceCityMap = (Map) request.getAttribute("provinceCityMap");
	
	
	//查询条件-会员编号
	String USER_ID = StringUtil.getRequestData(request.getParameter("USER_ID"),"");
	//查询条件-姓名
	String User_Name = StringUtil.getRequestData(request.getParameter("User_Name"),"");
	//查询条件-年龄
	String User_Age_From = StringUtil.getRequestData(request.getParameter("User_Age_From"),"");
	String User_Age_To = StringUtil.getRequestData(request.getParameter("User_Age_To"),"");
	//查询条件-身份证号
	String User_Card = StringUtil.getRequestData(request.getParameter("User_Card"),"");
	//查询条件-手机
	String User_Mobile = StringUtil.getRequestData(request.getParameter("User_Mobile"),"");
	//查询条件-合同单位
	String User_Depart = StringUtil.getRequestData(request.getParameter("User_Depart"),"");
	//查询条件-累计积分起始
	String User_Sunm_Beg = StringUtil.getRequestData(request.getParameter("User_Sunm_Beg"),"");
	//查询条件-累计积分结束
	String User_Sunm_End = StringUtil.getRequestData(request.getParameter("User_Sunm_End"),"");
	//查询条件-挂号编号
	String Ill_ID = StringUtil.getRequestData(request.getParameter("Ill_ID"),"");
	//查询条件-就诊金额起始
	String User_Money_From = StringUtil.getRequestData(request.getParameter("User_Money_From"),"");
	//查询条件-就诊金额结束
	String User_Money_To = StringUtil.getRequestData(request.getParameter("User_Money_To"),"");
	//查询条件-院方比例起始
	String User_Hos_From = StringUtil.getRequestData(request.getParameter("User_Hos_From"),"");
	//查询条件-院方比例结束
	String User_Hos_To = StringUtil.getRequestData(request.getParameter("User_Hos_To"),"");
	//查询条件-单次积分起始
	String User_Single_From = StringUtil.getRequestData(request.getParameter("User_Single_From"),"");
	//查询条件-单次积分结束
	String User_Single_To = StringUtil.getRequestData(request.getParameter("User_Single_To"),"");
	//查询条件-病历
	String User_ILL = StringUtil.getRequestData(request.getParameter("User_ILL"),"");
	// 查询条件-起始时间
	String User_DATE_From = StringUtil.getRequestData(request.getParameter("User_DATE_From"), "");
	//查询条件-结束时间
	String User_DATE_To = StringUtil.getRequestData(request.getParameter("User_DATE_To"), "");

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
      out.write("<input type=\"hidden\" name=\"actname\" value=\"Query_Info.do\">\r\n");
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
          out.write("    <td class=\"item\" width=\"5%\" nowrap>会员编号：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"20%\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"USER_ID\" value=\"");
          out.print(USER_ID );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"5%\" nowrap>姓名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"20%\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Name\" value=\"");
          out.print(User_Name );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" width=\"5%\" nowrap>性别：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"20%\" nowrap>\r\n");
          out.write("      <select name=\"USER_Sex\">\r\n");
          out.write("      <option value=\"\">--请选择--</option>\r\n");
          out.write("      ");
          out.print(sexOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" width=\"5%\" nowrap>手机：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"20%\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Mobile\" value=\"");
          out.print(User_Mobile );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("\t<td class=\"item\" nowrap>所在地区：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("\t<select name=\"User_PROVINCE\" onchange=\"javascript:getCityOptionList(this.options[this.selectedIndex].value);\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(provinceOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("      <select name=\"User_CITY\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(cityOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>媒体方式：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"USER_Media\">\r\n");
          out.write("      <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(mediaTypeOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>身份证号：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Card\" value=\"");
          out.print(User_Card );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" nowrap>合同单位：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"User_Depart\">\r\n");
          out.write("      <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(companyOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>会员类别：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"USER_Type\">\r\n");
          out.write("      <option value=\"\">--请选择--</option>\r\n");
          out.write("       \t");
          out.print(memTypeOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>累计积分：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Sunm_Beg\" value=\"");
          out.print(User_Sunm_Beg );
          out.write("\" size=\"6\">－<input type=\"text\" name=\"User_Sunm_End\" value=\"");
          out.print(User_Sunm_End );
          out.write("\" size=\"6\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" nowrap>挂号编号：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"Ill_ID\" value=\"");
          out.print(Ill_ID );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>就诊类别：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"ILL_Type\">\r\n");
          out.write("      <option value=\"\">--请选择--</option>\r\n");
          out.write("       \t");
          out.print(p_ILL_TypeOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>就诊金额：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Money_From\"  value=\"");
          out.print(User_Money_From );
          out.write("\" size=\"6\">－<input type=\"text\" name=\"User_Money_To\" value=\"");
          out.print(User_Money_To );
          out.write("\" size=\"6\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\">院方承担比例(%)：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Hos_From\" value=\"");
          out.print(User_Hos_From );
          out.write("\" size=\"6\">－<input type=\"text\" name=\"User_Hos_To\" value=\"");
          out.print(User_Hos_To );
          out.write("\" size=\"6\">\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>积分：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Single_From\" value=\"");
          out.print(User_Single_From );
          out.write("\" size=\"6\">－<input type=\"text\" name=\"User_Single_To\" value=\"");
          out.print(User_Single_To );
          out.write("\" size=\"6\">\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>病历：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_ILL\" value=\"");
          out.print(User_ILL );
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  \r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>年龄：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"User_Age_From\" value=\"");
          out.print(User_Age_From );
          out.write("\" size=\"6\">－<input type=\"text\" name=\"User_Age_To\" value=\"");
          out.print(User_Age_To );
          out.write("\" size=\"6\">\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>就诊时间：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap colspan=\"3\">\r\n");
          out.write("      ");
          //  syntc:DateImg
          com.syntc.taglib.html.DateImgTag _jspx_th_syntc_005fDateImg_005f0 = (com.syntc.taglib.html.DateImgTag) _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.get(com.syntc.taglib.html.DateImgTag.class);
          _jspx_th_syntc_005fDateImg_005f0.setPageContext(_jspx_page_context);
          _jspx_th_syntc_005fDateImg_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fHtmlTable_005f0);
          // /app/system/query_user.jsp(182,6) name = element type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_syntc_005fDateImg_005f0.setelement("User_DATE_From");
          // /app/system/query_user.jsp(182,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_syntc_005fDateImg_005f0.setvalue(User_DATE_From );
          int _jspx_eval_syntc_005fDateImg_005f0 = _jspx_th_syntc_005fDateImg_005f0.doStartTag();
          if (_jspx_th_syntc_005fDateImg_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.reuse(_jspx_th_syntc_005fDateImg_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.reuse(_jspx_th_syntc_005fDateImg_005f0);
          out.write('－');
          //  syntc:DateImg
          com.syntc.taglib.html.DateImgTag _jspx_th_syntc_005fDateImg_005f1 = (com.syntc.taglib.html.DateImgTag) _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.get(com.syntc.taglib.html.DateImgTag.class);
          _jspx_th_syntc_005fDateImg_005f1.setPageContext(_jspx_page_context);
          _jspx_th_syntc_005fDateImg_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fHtmlTable_005f0);
          // /app/system/query_user.jsp(182,77) name = element type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_syntc_005fDateImg_005f1.setelement("User_DATE_To");
          // /app/system/query_user.jsp(182,77) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_syntc_005fDateImg_005f1.setvalue(User_DATE_To );
          int _jspx_eval_syntc_005fDateImg_005f1 = _jspx_th_syntc_005fDateImg_005f1.doStartTag();
          if (_jspx_th_syntc_005fDateImg_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.reuse(_jspx_th_syntc_005fDateImg_005f1);
            return;
          }
          _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.reuse(_jspx_th_syntc_005fDateImg_005f1);
          out.write("\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>&nbsp;</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>&nbsp;</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  \r\n");
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
      out.write("\r\n");
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
          out.write("\t\t  <th class=\"nm\" nowrap>会员编号</th>\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap>姓名</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>性别</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>年龄</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>所在地区</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>手机</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>媒体方式</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>合同单位</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>会员类别</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>累计积分</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>挂号编号</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>就诊类别</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>就诊金额</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>就诊时间</th>\r\n");
          out.write("          <th class=\"nm\">院方承担比例(%)</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>积分</th>\r\n");
          out.write("        </tr>\r\n");
          out.write("       \r\n");


if(res!=null){
	for (int i = 1; i < res.size(); i++) {
		//会员编号
		String C_MEMCODE = StringUtil.convertNull(res.getCell("C_MEMCODE", i));
		
		//取得姓名
		String C_NAME = StringUtil.convertNull(res.getCell("C_NAME", i));
		//性别
		String C_SEX = StringUtil.convertNull(res.getCell("C_SEX", i));
		if (C_SEX.length() == 0) {
			C_SEX = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(C_SEX)) {
				C_SEX = (String) optionItemMap.get(C_SEX);
			} else {
				C_SEX = "&nbsp;";
			}
		}
		//取得用户年龄
		String C_AGE = StringUtil.convertNull(res.getCell("C_AGE", i));
		//所在地区
		String str_Province = StringUtil.convertNull(res.getCell("C_PROVINCE", i));
		String str_City = StringUtil.convertNull(res.getCell("C_CITY", i));
		String str_Area = "";
		if (str_Province != null && str_Province.length() > 0) {
			if (optionItemMap.containsKey(str_Province)) {
				str_Area = (String) optionItemMap.get(str_Province);
			}
		}
		if (str_City != null && str_City.length() > 0) {
			if (str_Area.length() > 0) {
				if (optionItemMap.containsKey(str_City)) {
					str_Area = str_Area + "-" + (String) optionItemMap.get(str_City);
				}
			}
		}
		if (str_Area.length() == 0) {
			str_Area = "&nbsp;";
		}
		//手机
		String str_Mobile = StringUtil.convertNull(res.getCell("C_MOBILE", i));
		//媒体方式
		String str_MediaType = StringUtil.convertNull(res.getCell("C_MEDIATYPE", i));
		if (str_MediaType.length() == 0) {
			str_MediaType = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(str_MediaType)) {
				str_MediaType = (String) optionItemMap.get(str_MediaType);
			} else {
				str_MediaType = "&nbsp;";
			}
		}
		//合同单位
		String str_Company = StringUtil.convertNull(res.getCell("C_COMPANY", i));
		if (str_Company.length() == 0) {
			str_Company = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(str_Company)) {
				str_Company = (String) optionItemMap.get(str_Company);
			} else {
				str_Company = "&nbsp;";
			}
		}
		//会员类别
		String str_MemType = StringUtil.convertNull(res.getCell("C_TYPENAME", i));
		//累计积分
		String SUM_MENOY = StringUtil.convertNull(res.getCell("MONEY", i));
		//挂号编号
		String C_CODE = StringUtil.convertNull(res.getCell("C_CODE", i));
		//就诊类别
		String C_TYPE = StringUtil.convertNull(res.getCell("C_TYPE", i));
		if (C_TYPE.length() == 0) {
			C_TYPE = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(C_TYPE)) {
				C_TYPE = (String) optionItemMap.get(C_TYPE);
			} else {
				C_TYPE = "&nbsp;";
			}
		}
		//就诊金额
		String str_Money = StringUtil.convertNull(res.getCell("C_MONEY", i));
		if (str_Money.length() == 0) {
			str_Money = "&nbsp;";
		} else {
			str_Money = common.removeTailZero(str_Money);
		}
		//就诊时间
		String C_DATE = StringUtil.convertNull(res.getCell("C_DATE", i));
		//院方承担比例(%)
		String str_Percent = StringUtil.convertNull(res.getCell("C_PERCENT", i));
		if (str_Percent.length() == 0) {
			str_Percent = "&nbsp;";
		} else {
			str_Percent = common.removeTailZero(str_Percent);
		}
		//积分
		String S_MONEY = StringUtil.convertNull(res.getCell("S_MONEY", i));

          out.write("\r\n");
          out.write("\t\t  <tr>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap>");
          out.print(C_MEMCODE);
          out.write(' ');
 if(C_MEMCODE=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap>");
          out.print(C_NAME);
          out.write(' ');
 if(C_NAME=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(C_SEX);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(C_AGE);
          out.write(' ');
 if(C_AGE=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Area);
          out.write(" </td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Mobile);
          out.write(' ');
 if(str_Mobile=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_MediaType);
          out.write(" </td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Company);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_MemType);
          out.write(' ');
 if(str_MemType=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(SUM_MENOY);
          out.write(' ');
 if(SUM_MENOY=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(C_CODE);
          out.write(' ');
 if(C_CODE=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(C_TYPE);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Money);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(C_DATE);
          out.write(' ');
 if(C_DATE=="") 
          out.print("&nbsp;");
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Percent);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(S_MONEY);
          out.write(' ');
 if(S_MONEY=="") 
          out.print("&nbsp;");
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
      out.write("   \r\n");
      out.write("\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("function funQuery(){\r\n");
      out.write("\tdocument.form1.action = \"Query_Info.do\";\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function download(){\r\n");
      out.write("\tdocument.form1.action = \"Query_Download.do\";\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function getCityOptionList(province) {\r\n");
      out.write("\t//清空市下拉列表\r\n");
      out.write("\tdocument.form1.User_CITY.length = 0; \r\n");
      out.write("\tdocument.form1.User_CITY.options[0] = new Option(\"--请选择--\", \"\");\r\n");
      out.write("\t");

		Iterator iter = provinceCityMap.keySet().iterator();
		String provinceID;
		while (iter.hasNext()) {
			provinceID = (String) iter.next();
	
      out.write("\r\n");
      out.write("\t\tif (province == ");
      out.print(provinceID);
      out.write(") {\r\n");
      out.write("\t\t\t");

			List cityList = (List) provinceCityMap.get(provinceID);
			String[] cityInfo;
			for (int i = 0; i < cityList.size(); i++) {
				cityInfo = (String[]) cityList.get(i);
			
      out.write("\r\n");
      out.write("\t\t\tdocument.form1.User_CITY.options[document.form1.User_CITY.length] = new Option('");
      out.print(cityInfo[1]);
      out.write("', '");
      out.print(cityInfo[0]);
      out.write("');\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t");
		
		}
	
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</SCRIPT> \r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_syntc_005fTitleHeader_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:TitleHeader
    com.syntc.taglib.html.TitleHeaderTag _jspx_th_syntc_005fTitleHeader_005f0 = (com.syntc.taglib.html.TitleHeaderTag) _005fjspx_005ftagPool_005fsyntc_005fTitleHeader_0026_005fheader_005fnobody.get(com.syntc.taglib.html.TitleHeaderTag.class);
    _jspx_th_syntc_005fTitleHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fTitleHeader_005f0.setParent(null);
    // /app/system/query_user.jsp(62,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("患者信息查询");
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
    // /app/system/query_user.jsp(68,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("患者信息查询");
    // /app/system/query_user.jsp(68,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/system/query_user.jsp(70,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/system/query_user.jsp(192,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f1.setheader("患者信息列表");
    int _jspx_eval_syntc_005fTableTitle_005f1 = _jspx_th_syntc_005fTableTitle_005f1.doStartTag();
    if (_jspx_eval_syntc_005fTableTitle_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fTableHeader_005f1(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
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

  private boolean _jspx_meth_syntc_005fButtonBase_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ButtonBase
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f0 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    // /app/system/query_user.jsp(194,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("导出查询结果");
    // /app/system/query_user.jsp(194,0) name = width type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setwidth("75");
    // /app/system/query_user.jsp(194,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setonclick("download();");
    int _jspx_eval_syntc_005fButtonBase_005f0 = _jspx_th_syntc_005fButtonBase_005f0.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
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
