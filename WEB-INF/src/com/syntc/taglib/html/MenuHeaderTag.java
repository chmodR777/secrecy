////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
//
// ALL RIGHTS RESERVED BY SYNTC CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/**
 * <p>通用标题共通处理;
 *
 * @version 0.00, 2006-06-08
 * @author  zhangqiang
 * @Desc    框架标签结尾
 * @since   0.00
 */	
package com.syntc.taglib.html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;

public class MenuHeaderTag extends TagSupport {

	  public MenuHeaderTag() {
	  }
	  
	  public int doEndTag(){
		  
        //取得session，取得UserBean 
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		UserBean user = (UserBean)request.getSession().getAttribute("UserBean");

	    StringBuffer sb_HTML = new StringBuffer();
	    
	    sb_HTML.append(      "<table border=0 class=menubar width=606>");
	    sb_HTML.append(        "<tr><td nowrap>&nbsp;&nbsp;&nbsp;&nbsp;");
	    //sb_HTML.append(CommonConstants.TITLE + ": " + user.getProName() + "</td>");
	    sb_HTML.append(        "<td nowrap align=right>");
	    sb_HTML.append(          "<img src=\"images/frame/bar_03.gif\" border=0 alt=\"\" ");
	    sb_HTML.append(          "style=\"cursor:hand\">&nbsp;&nbsp;");
	    sb_HTML.append(          "<a href=\"ProBasicList.do\" class=gohome>" + CommonConstants.ONCLICK + "</a>");
	    sb_HTML.append(        "&nbsp;&nbsp;</td></tr>");
	    sb_HTML.append(        "<tr><td nowrap height = 25 colspan=2 valign=top>&nbsp;&nbsp;&nbsp;&nbsp;");
	    sb_HTML.append(          "<font color=#ffffff>");
	    
	    //TODO 判断权限
	    sb_HTML.append(          "<a href=\"ProBasicDetail.do\" class=goback>" + CommonConstants.MODEL1 + "</a> &nbsp;| &nbsp;");
	    sb_HTML.append(          "<a href=\"ProShopDrawList.do\" class=goback>" + CommonConstants.MODEL2 + "</a> &nbsp;| &nbsp;");
	    sb_HTML.append(          "<a href=\"InviteList.do\" class=goback>" + CommonConstants.MODEL3A + "</a> &nbsp;| &nbsp;");
	    sb_HTML.append(          "<a href=\"ContractList.do\" class=goback>" + CommonConstants.MODEL3B + "</a> &nbsp;| &nbsp;");
	    /*
	    if(user.chkMenu(CommonConstants.MENU_CHAIQIAN)){
	    	sb_HTML.append(      "<a href=\"ProZDCQDetail.do\" class=goback>" + CommonConstants.MODEL4 + "</a> &nbsp;| &nbsp;");
	    }
	    if(user.chkMenu(CommonConstants.MENU_PAIQIAN)){
	        sb_HTML.append(      "<a href=\"PqDisplayList.do\" class=goback>" + CommonConstants.MODEL5 + "</a> &nbsp;| &nbsp;");
	    }
	    */
	    sb_HTML.append(          "<a href=\"MainProject.do\" class=goback>" + CommonConstants.MODEL6 + "</a> &nbsp;| &nbsp;");
	    sb_HTML.append(          "<a href=\"CheckHandover.do\" class=goback>" + CommonConstants.MODEL7 + "</a> &nbsp;| &nbsp;");
	    sb_HTML.append(          "<a href=\"ProJieSuanList.do\" class=goback>" + CommonConstants.MODEL8 + "</a>");
	    sb_HTML.append(        "</font></td></tr></table>");
	    
	    JspWriter out = pageContext.getOut();

	    try{
	    	out.write(sb_HTML.toString());
	    }
	    catch( Exception ex){
	    	System.out.println("com.syntc.taglib.html Exception " + ex.toString());
	    }
	    
	    return Tag.EVAL_PAGE;

	  }

	  public void release() {
	    super.release();
	  }
}
