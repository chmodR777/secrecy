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

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TitleBaseTag extends TagSupport {
	
	  //标题1
	  private String header;
	  //onclick 事件
	  private String OnClick;

	  public TitleBaseTag() {
		  header = "未定义标题";
	  }
	  
	  public String getOnclick() {
		    return OnClick;
	  }

	  public void setonclick(String OnClick) {
	    this.OnClick = OnClick;
	  }

	  public String getheader() {
	    return this.header;
	  }

	  public void setheader(String header) {
	    this.header = header;
	  }

	  public int doEndTag(){

	    StringBuffer sb_HTML = new StringBuffer();
    
	    sb_HTML.append(" <td>　</td> ");
	    sb_HTML.append(" <td class=\"HEADER \" >");
	    sb_HTML.append(" <IMG SRC=\"images/icon-org.gif\"  BORDER=0 >&nbsp;");
	    sb_HTML.append("<a href=\"#\" class=\"detail\" style=\"cursor:hand\" onclick=\"javascript: " + this.OnClick + "\">");
	    sb_HTML.append(this.header +"</a></td>");  
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
	    this.header = null;
	    this.OnClick = null;
	  }
}
