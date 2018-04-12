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
 * @author  jinghuizhen@hotmail.com
 * @Desc    标题基类
 * @since   0.00
 */	
package com.syntc.taglib.html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;

public class TitleHeaderTag extends TagSupport {
	
	  //标题1
	  private String header;

	  public TitleHeaderTag() {
		  header = "未定义标题";
	  }

	  public String getheader() {
	    return this.header;
	  }

	  public void setheader(String header) {
	    this.header = header;
	  }

	  public int doEndTag(){
		//取得session，取得UserBean 
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		UserBean user = (UserBean)request.getSession().getAttribute("UserBean");

	    StringBuffer sb_HTML = new StringBuffer();
    
	    sb_HTML.append("<table cellpadding=0 cellspacing=0 topmargin=0 leftmargin=0 border=0 width=100%>");
	    sb_HTML.append(  "<tr><td>");
	    sb_HTML.append(    "<table cellpadding=0 cellspacing=0 topmargin=0 leftmargin=0 border=0 width=100%>");
	    sb_HTML.append(      "<tr><td class=\"header\">");
	    sb_HTML.append(        "<img src=\"images/frame/left_box.gif\" border=0 alt=\"\">&nbsp;&nbsp;");
	    sb_HTML.append(CommonConstants.HEADER + "："+this.header);
	    sb_HTML.append(    "</td></tr></table>");
	    sb_HTML.append(  "</td></tr>");
	    sb_HTML.append(  "<tr><td>");
	    sb_HTML.append(    "<table cellspacing=8 border=0 width=100%><tr><td>");	      
 
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
