package org.apache.jsp.app.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class patient_005fmanage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _005fjspx_005ftagPool_005fsyntc_005fNewButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fModifyButton_005fnobody.release();
    _005fjspx_005ftagPool_005fsyntc_005fDeleteButton_005fnobody.release();
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
	String sexOptionList = (String) request.getAttribute("sexOptionList");
	String mediaTypeOptionList = (String) request.getAttribute("mediaTypeOptionList");
	String companyOptionList = (String) request.getAttribute("companyOptionList");
	String provinceOptionList = (String) request.getAttribute("provinceOptionList");
	String cityOptionList = (String) request.getAttribute("cityOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");
	Map provinceCityMap = (Map) request.getAttribute("provinceCityMap");
	
	// 查询条件-会员编号
	String p_MemCode = StringUtil.getRequestData(request.getParameter("txtMemCode"), "");
	// 查询条件-姓名
	String p_Name = StringUtil.getRequestData(request.getParameter("txtName"), "");
	// 查询条件-年龄
	String p_AgeMin = StringUtil.getRequestData(request.getParameter("txtAgeMin"), "");
	String p_AgeMax = StringUtil.getRequestData(request.getParameter("txtAgeMax"), "");
	// 查询条件-所在地区-省
	String p_Province = StringUtil.getRequestData(request.getParameter("txtProvince"), "");
	// 查询条件-手机
	String p_Mobile = StringUtil.getRequestData(request.getParameter("txtMobile"), "");
	// 查询条件-身份证号
	String p_IDCard = StringUtil.getRequestData(request.getParameter("txtIDCard"), "");
	// 查询条件-累计积分
	String p_TotalScoreMin = StringUtil.getRequestData(request.getParameter("txtTotalScoreMin"), "");
	String p_TotalScoreMax = StringUtil.getRequestData(request.getParameter("txtTotalScoreMax"), "");

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
      out.write("<input type=\"hidden\" name=\"actname\" value=\"PatientManage.do\">\r\n");
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
          out.write("    <td class=\"item\" width=\"20%\" nowrap>会员编号：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"txtMemCode\" value=\"");
          out.print(p_MemCode);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>姓名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"txtName\" value=\"");
          out.print(p_Name);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>性别：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"txtSex\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(sexOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>年龄：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"txtAgeMin\" size=\"10\" value=\"");
          out.print(p_AgeMin);
          out.write("\">－<input type=\"text\" name=\"txtAgeMax\" size=\"10\" value=\"");
          out.print(p_AgeMax);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>所在地区：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"txtProvince\" onchange=\"javascript:getCityOptionList(this.options[this.selectedIndex].value);\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(provinceOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("\t  <select name=\"txtCity\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(cityOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>手机：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"txtMobile\" value=\"");
          out.print(p_Mobile);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>媒体方式：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"txtMediaType\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(mediaTypeOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>合同单位：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"txtCompany\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(companyOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>会员类别：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <select name=\"txtMemType\">\r\n");
          out.write("\t\t<option value=\"\">--请选择--</option>\r\n");
          out.write("       \t");
          out.print(memTypeOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>身份证号：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"txtIDCard\" value=\"");
          out.print(p_IDCard);
          out.write("\">\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>累计积分：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"txtTotalScoreMin\" size=\"10\" value=\"");
          out.print(p_TotalScoreMin);
          out.write("\">－<input type=\"text\" name=\"txtTotalScoreMax\" size=\"10\" value=\"");
          out.print(p_TotalScoreMax);
          out.write("\">\r\n");
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
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      if (_jspx_meth_syntc_005fTableTitle_005f1(_jspx_page_context))
        return;
      out.write("   \r\n");
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
          out.write("\t\t  <th class=\"nm\" nowrap>会员编号</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>姓名</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>性别</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>年龄</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>所在地区</th>\r\n");
          out.write("          <th class=\"nm\" nowrap>手机</th>\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap>媒体方式</th>\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap>合同单位</th>\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap>会员类别</th>\r\n");
          out.write("\t\t  <th class=\"nm\" nowrap>累计积分</th>\r\n");
          out.write("        </tr>\r\n");

if (res.size() > 1) {
	for (int i = 1; i < res.size(); i++) {
		//ID
		String str_ID = StringUtil.convertNull(res.getCell("C_ID", i));
		//会员编号
		String str_MemCode = StringUtil.convertNull(res.getCell("C_MEMCODE", i));
		if (str_MemCode.length() == 0) {
			str_MemCode = "&nbsp;";
		}
		//姓名
		String str_Name = StringUtil.convertNull(res.getCell("C_NAME", i));
		if (str_Name.length() == 0) {
			str_Name = "&nbsp;";
		}
		//性别
		String str_Sex = StringUtil.convertNull(res.getCell("C_SEX", i));
		if (str_Sex.length() == 0) {
			str_Sex = "&nbsp;";
		} else {
			if (optionItemMap.containsKey(str_Sex)) {
				str_Sex = (String) optionItemMap.get(str_Sex);
			} else {
				str_Sex = "&nbsp;";
			}
		}
		//年龄
		String str_Age = StringUtil.convertNull(res.getCell("C_AGE", i));
		if (str_Age.length() == 0) {
			str_Age = "&nbsp;";
		}
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
		if (str_Mobile.length() == 0) {
			str_Mobile = "&nbsp;";
		}
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
		if (str_MemType.length() == 0) {
			str_MemType = "&nbsp;";
		}
		//累计积分
		String str_TotalScore = common.removeTailZero(StringUtil.convertNull(res.getCell("TOTALSCORE", i)));

          out.write("\r\n");
          out.write("        <tr>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap><input type=\"radio\" name=\"rad\" value=\"");
          out.print(str_ID);
          out.write("\"></td>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap>");
          out.print(str_MemCode);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Name);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Sex);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Age);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Area);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Mobile);
          out.write("</td>\r\n");
          out.write("\t\t  <td class=\"nm\" nowrap>");
          out.print(str_MediaType);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_Company);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_MemType);
          out.write("</td>\r\n");
          out.write("          <td class=\"nm\" nowrap>");
          out.print(str_TotalScore);
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
      out.write("  \r\n");
      out.write("\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("function funNew(){\r\n");
      out.write("\tdocument.form1.action = \"PatientAdd.do\";\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funModify(){\r\n");
      out.write("\tif (checkRadioValue('rad')) {\r\n");
      out.write("        var radValue = getRadioValue(document.getElementsByName('rad'));\r\n");
      out.write("        document.form1.action = \"PatientModify.do?patient_id=\" + radValue;\r\n");
      out.write("        document.form1.submit();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funDelele(){\r\n");
      out.write("\tif (checkRadioValue('rad')) {\r\n");
      out.write("        if (confirm(\"您确认要删除数据吗？\")) {\r\n");
      out.write("            var radValue = getRadioValue(document.getElementsByName('rad'));\r\n");
      out.write("            //清空查询条件\r\n");
      out.write("            form1.txtMemCode.value = \"\";\r\n");
      out.write("            form1.txtName.value = \"\";\r\n");
      out.write("            form1.txtSex.value = \"\";\r\n");
      out.write("            form1.txtAgeMin.value = \"\";\r\n");
      out.write("            form1.txtAgeMax.value = \"\";\r\n");
      out.write("            form1.txtProvince.value = \"\";\r\n");
      out.write("            form1.txtCity.value = \"\";\r\n");
      out.write("            form1.txtMobile.value = \"\";\r\n");
      out.write("            form1.txtMediaType.value = \"\";\r\n");
      out.write("            form1.txtCompany.value = \"\";\r\n");
      out.write("            form1.txtMemType.value = \"\";\r\n");
      out.write("            form1.txtIDCard.value = \"\";\r\n");
      out.write("            form1.txtTotalScoreMin.value = \"\";\r\n");
      out.write("            form1.txtTotalScoreMax.value = \"\";\r\n");
      out.write("            document.form1.action = \"PatientDel.do?patient_id=\" + radValue;\r\n");
      out.write("            document.form1.submit();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funQuery(){\r\n");
      out.write("\tdocument.form1.action = \"PatientManage.do\";\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funIllManage() {\r\n");
      out.write("\tif (checkRadioValue('rad')) {\r\n");
      out.write("        var radValue = getRadioValue(document.getElementsByName('rad'));\r\n");
      out.write("        document.form1.action = \"IllManage.do?patient_id=\" + radValue;\r\n");
      out.write("        document.form1.submit();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getCityOptionList(province) {\r\n");
      out.write("\t//清空市下拉列表\r\n");
      out.write("\tdocument.all.txtCity.length = 0; \r\n");
      out.write("\tdocument.all.txtCity.options[0] = new Option(\"--请选择--\", \"\");\r\n");
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
      out.write("\t\t\tdocument.all.txtCity.options[document.all.txtCity.length] = new Option('");
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
      out.write("\r\n");
      out.write("function funExportQueryResult() {\r\n");
      out.write("\tdocument.form1.action = \"PatientExport.do\";\r\n");
      out.write("    document.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("</SCRIPT>  \r\n");
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
    // /app/business/patient_manage.jsp(37,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("患者信息管理");
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
    // /app/business/patient_manage.jsp(43,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("患者信息管理");
    // /app/business/patient_manage.jsp(43,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/business/patient_manage.jsp(45,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/business/patient_manage.jsp(130,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
        if (_jspx_meth_syntc_005fButtonBase_005f0(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_syntc_005fButtonBase_005f1(_jspx_th_syntc_005fTableTitle_005f1, _jspx_page_context))
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

  private boolean _jspx_meth_syntc_005fButtonBase_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ButtonBase
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f0 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    // /app/business/patient_manage.jsp(135,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("导出查询结果");
    // /app/business/patient_manage.jsp(135,0) name = width type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setwidth("75");
    // /app/business/patient_manage.jsp(135,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setonclick("funExportQueryResult();");
    int _jspx_eval_syntc_005fButtonBase_005f0 = _jspx_th_syntc_005fButtonBase_005f0.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f0);
    return false;
  }

  private boolean _jspx_meth_syntc_005fButtonBase_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fTableTitle_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:ButtonBase
    com.syntc.taglib.html.ButtonBaseTag _jspx_th_syntc_005fButtonBase_005f1 = (com.syntc.taglib.html.ButtonBaseTag) _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.get(com.syntc.taglib.html.ButtonBaseTag.class);
    _jspx_th_syntc_005fButtonBase_005f1.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fButtonBase_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fTableTitle_005f1);
    // /app/business/patient_manage.jsp(136,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f1.setcaption("病历信息管理");
    // /app/business/patient_manage.jsp(136,0) name = width type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f1.setwidth("75");
    // /app/business/patient_manage.jsp(136,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f1.setonclick("funIllManage();");
    int _jspx_eval_syntc_005fButtonBase_005f1 = _jspx_th_syntc_005fButtonBase_005f1.doStartTag();
    if (_jspx_th_syntc_005fButtonBase_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fButtonBase_0026_005fwidth_005fonclick_005fcaption_005fnobody.reuse(_jspx_th_syntc_005fButtonBase_005f1);
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
