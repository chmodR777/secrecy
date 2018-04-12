package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.syntc.util.*;
import com.syntc.common.bean.*;
import com.syntc.constants.CommonConstants;
import java.util.*;
import java.io.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".nu{\r\n");
      out.write("\tborder-bottom-width: 1px;\r\n");
      out.write("\tborder-bottom-style: solid;\r\n");
      out.write("\tborder-bottom-color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write(".mw {\r\n");
      out.write("\tbackground-color: #6D7DDE;\r\n");
      out.write("}\r\n");
      out.write(".m1l {\r\n");
      out.write("\tbackground-color: #A2ADEE;\r\n");
      out.write("\tcursor:hand;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("\theight: 27px;\r\n");
      out.write("\tborder-bottom-width: 1px;\r\n");
      out.write("\tborder-bottom-style: solid;\r\n");
      out.write("\tborder-bottom-color: #C0C8F2;\r\n");
      out.write("\tpadding-left: 13px;}\r\n");
      out.write(".m1 {\r\n");
      out.write("\tbackground-color: #A2ADEE;\r\n");
      out.write("\tfont-family: \"宋体;SimSun\";\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tcolor: 2C40AE;\r\n");
      out.write("\tcursor:hand;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("\theight: 27px;\r\n");
      out.write("\tborder-bottom-width: 1px;\r\n");
      out.write("\tborder-bottom-style: solid;\r\n");
      out.write("\tborder-bottom-color: #C0C8F2;\r\n");
      out.write("}\r\n");
      out.write(".m2 {\r\n");
      out.write("\tbackground-color: #DADFF9;\r\n");
      out.write("\tfont-family: \"宋体;SimSun\";\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: 2C40AE;\r\n");
      out.write("\tcursor:hand;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("\theight: 27px;\r\n");
      out.write("\tborder-bottom-width: 1px;\r\n");
      out.write("\tborder-bottom-style: solid;\r\n");
      out.write("\tborder-bottom-color: #C0C8F2;\r\n");
      out.write("\tpadding-top: 3px;\r\n");
      out.write("}\r\n");
      out.write("body{\r\n");
      out.write("  overflow-x: hidden;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	//取得用户菜单权限
	UserBean user = (UserBean)request.getSession().getAttribute("UserBean");
	
	Map<String,String> map = user.getUserRightMap();


	String str_display;
	String str_imgname;
	String str_sh;

	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_xmxz"),"open");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}


      out.write("\r\n");
      out.write("\r\n");
      out.write("<body topmargin=0 leftmargin=0 bgcolor=#A2ADEE>\r\n");
      out.write("<form name=\"formmenu\" action=\"\" method=\"post\" target=\"mainFrame\">\r\n");
      out.write("  <table width=\"200\" border=0 cellpadding=\"0\" cellspacing=\"0\" align=right>\r\n");
      out.write("  <tr class=mw>\r\n");
      out.write("    <td width=50 height=3 ><img src=\"images/clear.gif\"></td>\r\n");
      out.write("    <td><img src=\"images/clear.gif\"></td>\r\n");
      out.write("    <td width=40><img src=\"images/clear.gif\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td class=\"mw\" colspan=3 nowrap height=27>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"images/menus/welcom.jpg\"></td>\r\n");
      out.write("  </tr>\r\n");

	if("TRUE".equals(map.get("1"))){

      out.write("\r\n");
      out.write("  <tr onClick=\"gourl('PatientManage.do');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m11.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">患者信息管理</td>\r\n");
      out.write("    <td class=\"m1\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("2"))){

      out.write("\r\n");
      out.write("  <tr onClick=\"gourl('Query_Info.do');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m3.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">患者信息查询</td>\r\n");
      out.write("    <td class=\"m1\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("3"))){

      out.write("\r\n");
      out.write("  <tr onClick=\"gourl('ConsultManage.do');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m4.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">咨询信息管理</td>\r\n");
      out.write("    <td class=\"m1\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\r\n");

	}
	if("TRUE".equals(map.get("4"))){

      out.write("\r\n");
      out.write("  <tr onClick=\"gourl('MedicineManage.do');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m6.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">邮药信息管理</td>\r\n");
      out.write("    <td class=\"m1\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_zbht"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}

	if("TRUE".equals(map.get("5"))){

      out.write("\r\n");
      out.write("  <tr onClick=\"oc('zbht');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m7.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">综合统计图表</td>\r\n");
      out.write("    <td class=\"m1\"><img src=\"images/menus/");
      out.print(str_imgname);
      out.write(".gif\" id=\"oc_zbht\"></td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("6"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_zbht\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('PicCakeChart.do?flag=1');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">饼状统计图</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("7"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_zbht\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('PicLineXYChart.do?flag=1');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">折线统计图</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("8"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_zbht\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('PicBarChart.do?flag=1');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">柱形统计图1</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("9"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_zbht\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('PicBar2Chart.do?flag=1');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">柱形统计图2</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	str_display = "none";
	str_imgname = "c";
	str_sh = StringUtil.convertNull(request.getParameter("sh_tjbb"),"close");
	if(str_sh.equals("open")){
		str_display = "";
		str_imgname = "o";
	}
	if("TRUE".equals(map.get("10"))){

      out.write("\r\n");
      out.write("  <tr onClick=\"oc('tjbb');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m5.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">系统管理</td>\r\n");
      out.write("    <td class=\"m1\"><img src=\"images/menus/");
      out.print(str_imgname);
      out.write(".gif\" id=\"oc_tjbb\"></td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("11"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_tjbb\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('UserManage.do');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">用户管理</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("12"))){

      out.write("\r\n");
      out.write("\t<tr id=\"sub_tjbb\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('UserRight.do');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">权限管理</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("13"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_tjbb\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('MemTypeManage.do');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">会员类别管理</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}
	if("TRUE".equals(map.get("14"))){

      out.write("\r\n");
      out.write("  <tr id=\"sub_tjbb\" style=\"display:");
      out.print(str_display);
      out.write(";\" onClick=\"gourl('BackUp_jsp.do');\">\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("    <td class=\"m2\">系统备份与恢复</td>\r\n");
      out.write("    <td class=\"m2\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");

	}

      out.write("\r\n");
      out.write("  <tr onClick=\"gourl('PwdUpt.do');\">\r\n");
      out.write("    <td class=\"m1l\"><img src=\"images/menus/m2.jpg\"></td>\r\n");
      out.write("    <td class=\"m1\">个人密码修改</td>\r\n");
      out.write("    <td class=\"m1\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#A2ADEE\" colspan=3 height=10><img src=\"images/clear.gif\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("function oc(folderid){\r\n");
      out.write("\t// 设置打开关闭图标\r\n");
      out.write("\tvar ocid=\"oc_\"+folderid;\r\n");
      out.write("\tvar subdisplay;\r\n");
      out.write("\tvar bopen;\r\n");
      out.write("\tvar oc = document.all(ocid);\r\n");
      out.write("\tvar imgname=\"\";\r\n");
      out.write("\timgname = oc.src;\r\n");
      out.write("\tif (imgname.substr(imgname.length-18,18)==\"images/menus/o.gif\"){\r\n");
      out.write("\t\ts_status = \"close\";\r\n");
      out.write("\t\toc.src=\"images/menus/c.gif\";\r\n");
      out.write("\t\tsubdisplay=\"none\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\ts_status = \"open\";\r\n");
      out.write("\t\toc.src=\"images/menus/o.gif\";\r\n");
      out.write("\t\tsubdisplay=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t// 显示或隐藏子菜单\r\n");
      out.write("\tvar subid=\"sub_\"+folderid;\r\n");
      out.write("\tvar lineArray = document.all(subid);\r\n");
      out.write("\tif (lineArray.length > 1){\r\n");
      out.write("\t\tfor (var i = 0; i < lineArray.length; i ++) {\r\n");
      out.write("\t\t\tlineArray[i].style.display=subdisplay;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\t\tlineArray.style.display=subdisplay;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// 在top中保存当前的设置\r\n");
      out.write("\tvar sh_name=\"sh_\"+folderid;\r\n");
      out.write("\r\n");
      out.write("\tvar sh = parent.document.frames.item('ttop').form_top.elements(sh_name);\r\n");
      out.write("\tsh.value=s_status;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function gourl(vurl){\r\n");
      out.write("\tdocument.formmenu.action=vurl;\r\n");
      out.write("\tdocument.formmenu.submit();\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
}
