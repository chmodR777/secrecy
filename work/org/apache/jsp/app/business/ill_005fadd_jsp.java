package org.apache.jsp.app.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class ill_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody;
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
    _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
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
    _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.release();
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
      out.write("<head><title>添加病例信息</title></head>\r\n");
      out.write("<body topmargin=0 leftmargin=0 onload=\"initHTML();\">\r\n");

	String str_PatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
	String hosTypeOptionList = (String) request.getAttribute("hosTypeOptionList");
	Map optionItemMap = (Map) request.getAttribute("optionItemMap");

      out.write("\r\n");
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
      if (_jspx_meth_syntc_005fTableTitle_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

ResultObj res_patient = (ResultObj) request.getAttribute("res_patient");

//会员编号
String str_MemCode = StringUtil.convertNull(res_patient.getCell("C_MEMCODE", 1));
if (str_MemCode.length() == 0) {
	str_MemCode = "&nbsp;";
}
//姓名
String str_Name = StringUtil.convertNull(res_patient.getCell("C_NAME", 1));
if (str_Name.length() == 0) {
	str_Name = "&nbsp;";
}
//性别
String str_Sex = StringUtil.convertNull(res_patient.getCell("C_SEX", 1));
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
String str_Age = StringUtil.convertNull(res_patient.getCell("C_AGE", 1));
if (str_Age.length() == 0) {
	str_Age = "&nbsp;";
}
//所在地区
String str_Province = StringUtil.convertNull(res_patient.getCell("C_PROVINCE", 1));
String str_City = StringUtil.convertNull(res_patient.getCell("C_CITY", 1));
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
String str_Mobile = StringUtil.convertNull(res_patient.getCell("C_MOBILE", 1));
if (str_Mobile.length() == 0) {
	str_Mobile = "&nbsp;";
}
//媒体方式
String str_MediaType = StringUtil.convertNull(res_patient.getCell("C_MEDIATYPE", 1));
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
String str_Company = StringUtil.convertNull(res_patient.getCell("C_COMPANY", 1));
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
String str_MemType = StringUtil.convertNull(res_patient.getCell("C_TYPENAME", 1));
if (str_MemType.length() == 0) {
	str_MemType = "&nbsp;";
}
//身份证号
String str_IDCard = StringUtil.convertNull(res_patient.getCell("C_IDCARD", 1));
if (str_IDCard.length() == 0) {
	str_IDCard = "&nbsp;";
}
//累计积分
String str_TotalScore = common.removeTailZero(StringUtil.convertNull(res_patient.getCell("TOTALSCORE", 1)));

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
          out.write("    <td class=\"item\" width=\"20%\" nowrap>会员编号：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\" nowrap>");
          out.print(str_MemCode);
          out.write("</td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>姓名：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\" nowrap>");
          out.print(str_Name);
          out.write("</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>性别：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_Sex);
          out.write("</td>\r\n");
          out.write("    <td class=\"item\" nowrap>年龄：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_Age);
          out.write("</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>所在地区：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_Area);
          out.write("</td>\r\n");
          out.write("    <td class=\"item\" nowrap>手机：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_Mobile);
          out.write("</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>媒体方式：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_MediaType);
          out.write("</td>\r\n");
          out.write("    <td class=\"item\" nowrap>合同单位：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_Company);
          out.write("</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>会员类别：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_MemType);
          out.write("</td>\r\n");
          out.write("    <td class=\"item\" nowrap>身份证号：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_IDCard);
          out.write("</td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>累计积分：</td>\r\n");
          out.write("\t<td class=\"input\" nowrap>");
          out.print(str_TotalScore);
          out.write("</td>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      //  syntc:HtmlTable
      com.syntc.taglib.html.HtmlTableTag _jspx_th_syntc_005fHtmlTable_005f1 = (com.syntc.taglib.html.HtmlTableTag) _005fjspx_005ftagPool_005fsyntc_005fHtmlTable.get(com.syntc.taglib.html.HtmlTableTag.class);
      _jspx_th_syntc_005fHtmlTable_005f1.setPageContext(_jspx_page_context);
      _jspx_th_syntc_005fHtmlTable_005f1.setParent(null);
      int _jspx_eval_syntc_005fHtmlTable_005f1 = _jspx_th_syntc_005fHtmlTable_005f1.doStartTag();
      if (_jspx_eval_syntc_005fHtmlTable_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" width=\"20%\" nowrap>挂号编号：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\" nowrap>\r\n");
          out.write("      <input type=\"text\" name=\"strCode\">\r\n");
          out.write("      <font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("\t<td class=\"item\" width=\"20%\" nowrap>就诊类别：</td>\r\n");
          out.write("\t<td class=\"input\" width=\"30%\" nowrap>\r\n");
          out.write("      <select name=\"strType\">\r\n");
          out.write("        <option value=\"\">--请选择--</option>\r\n");
          out.write("        ");
          out.print(hosTypeOptionList);
          out.write("\r\n");
          out.write("      </select>\r\n");
          out.write("      <font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>就诊金额：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      <input type=\"text\" name=\"strMoney\">\r\n");
          out.write("      <font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("    <td class=\"item\" nowrap>就诊时间：</td>\r\n");
          out.write("\t<td class=\"input\">\r\n");
          out.write("      ");
          if (_jspx_meth_syntc_005fDateImg_005f0(_jspx_th_syntc_005fHtmlTable_005f1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("      <font color=\"red\">*</font>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
          out.write("  <tr>\r\n");
          out.write("    <td class=\"item\" nowrap>病历：</td>\r\n");
          out.write("    <td class=\"input\" colspan=\"3\">\r\n");
          out.write("      <textarea name=\"strIll\" rows=\"15\" cols=\"90\"></textarea>\r\n");
          out.write("    </td>\r\n");
          out.write("  </tr>\r\n");
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
      out.write("\r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_syntc_005fTitleFoot_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("function checkSubmit() {\r\n");
      out.write("    if (chkLthNul(form1.strCode, \"挂号编号\", 32)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.strType, \"就诊类别\")) {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.strMoney, \"就诊金额\")) {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    if (!NumValCheck(form1.strMoney, 2, 999999999, -999999999)) {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkNul(form1.strDate, \"就诊时间\")) {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    if (chkLth(form1.strIll, \"病历\", 4096)) {\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    return true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funSave() {\r\n");
      out.write("    if (checkSubmit()) {\r\n");
      out.write("        document.form1.action = \"IllAddSave.do?patient_id=");
      out.print(str_PatientID);
      out.write("\";\r\n");
      out.write("        document.form1.submit();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function funReturn() {\r\n");
      out.write("    document.form1.action = \"IllManage.do?patient_id=");
      out.print(str_PatientID);
      out.write("\";\r\n");
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
    // /app/business/ill_add.jsp(14,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTitleHeader_005f0.setheader("患者信息管理 >> 病历信息管理 >> 新建");
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
    // /app/business/ill_add.jsp(15,0) name = header type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fFuncHeader_005f0.setheader("病历信息新建");
    // /app/business/ill_add.jsp(15,0) name = showall type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /app/business/ill_add.jsp(17,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f0.setheader("患者信息");
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
    // /app/business/ill_add.jsp(147,0) name = header type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fTableTitle_005f1.setheader("病历信息");
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
    // /app/business/ill_add.jsp(150,0) name = caption type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fButtonBase_005f0.setcaption("返 回");
    // /app/business/ill_add.jsp(150,0) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_syntc_005fDateImg_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_syntc_005fHtmlTable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  syntc:DateImg
    com.syntc.taglib.html.DateImgTag _jspx_th_syntc_005fDateImg_005f0 = (com.syntc.taglib.html.DateImgTag) _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.get(com.syntc.taglib.html.DateImgTag.class);
    _jspx_th_syntc_005fDateImg_005f0.setPageContext(_jspx_page_context);
    _jspx_th_syntc_005fDateImg_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_syntc_005fHtmlTable_005f1);
    // /app/business/ill_add.jsp(178,6) name = element type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fDateImg_005f0.setelement("strDate");
    // /app/business/ill_add.jsp(178,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_syntc_005fDateImg_005f0.setvalue("");
    int _jspx_eval_syntc_005fDateImg_005f0 = _jspx_th_syntc_005fDateImg_005f0.doStartTag();
    if (_jspx_th_syntc_005fDateImg_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.reuse(_jspx_th_syntc_005fDateImg_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsyntc_005fDateImg_0026_005fvalue_005felement_005fnobody.reuse(_jspx_th_syntc_005fDateImg_005f0);
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
