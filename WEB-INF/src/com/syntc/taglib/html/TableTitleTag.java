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
 * <p>通用表格头部;
 *
 * @version 0.00, 2006-06-08
 * @author  zhangqiang
 * @Desc    标题基类
 * @since   0.00
 */	
package com.syntc.taglib.html;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TableTitleTag extends TagSupport {
	
	  //标题1
	  private String header;

	  public TableTitleTag() {
		  header = "未定义标题";
	  }

	  public String getheader() {
	    return this.header;
	  }

	  public void setheader(String header) {
	    this.header = header;
	  }

	  public int doStartTag(){

	    StringBuffer sb_HTML = new StringBuffer();
    
	    sb_HTML.append("<table cellspacing=0 cellpadding=0 width=\"100%\" border=0 >");
	    sb_HTML.append(  "<tr>");
	    sb_HTML.append(    "<td height=1 width=1><img src=images/table/t_1.jpg></td>");
	    sb_HTML.append(      "<td class=f_tl nowrap width=30%>&nbsp;");
	    sb_HTML.append(this.header);
	    sb_HTML.append(    "&nbsp;</td>");
	    sb_HTML.append(  "<td height=1 width=1><img src=images/table/t_3.jpg></td>");
	    sb_HTML.append(  "<td class=f_tr align=right>");	      
 
	    JspWriter out = pageContext.getOut();

	    try{
	    	out.write(sb_HTML.toString());
	    }
	    catch( Exception ex){
	    	System.out.println("com.syntc.taglib.html Exception " + ex.toString());
	    }
	    
	    return Tag.EVAL_PAGE;

	  }
	  
	  public int doEndTag(){

	    StringBuffer sb_HTML = new StringBuffer();

	    sb_HTML.append("</td>");
	    sb_HTML.append("<td height=1 width=1><img src=images/table/t_5.jpg></td>");
	    sb_HTML.append("</tr></table>");
	    
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
