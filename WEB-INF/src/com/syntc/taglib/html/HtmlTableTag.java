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

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class HtmlTableTag extends TagSupport {
	
	  private String id;

	  public HtmlTableTag() {
		  id = "";
	  }
	  
	  public void setid(String p_id){
		  this.id = p_id;
	  }
	  public String getid(){
		  return this.id;
	  }
	  
	  public int doStartTag(){
		  StringBuffer sb_HTML = new StringBuffer();
		  
		  sb_HTML.append("<table cellspacing=0 cellpadding=0 width=100% border=0>");
		  sb_HTML.append("<tr>");
		  sb_HTML.append("<td class=f_ml height=1 width=1><img src=images/table/t_9.jpg></td>");
		  sb_HTML.append("<td>");
		  sb_HTML.append("<table width=100% border=0 align=center cellpadding=5 cellspacing=0 id=\""+this.id+"\">");
		  
		  JspWriter out = pageContext.getOut();
		  
		  try{
			  out.write(sb_HTML.toString());
		  }catch( Exception ex){
			  System.out.println("com.syntc.taglib.html Exception " + ex.toString());
		  }
		  return Tag.EVAL_PAGE;
	  }
	  
	  public int doEndTag(){

	    StringBuffer sb_HTML = new StringBuffer();

	    sb_HTML.append("</table>");
	    sb_HTML.append("</td>");
	    sb_HTML.append("<td class=f_mr height=1 width=1><img src=images/table/t_10.jpg></td>");
	    sb_HTML.append("</tr>");
	    sb_HTML.append("<tr>");
	    sb_HTML.append("<td height=1 width=1><img src=images/table/t_13.jpg></td>");
	    sb_HTML.append("<td class=f_bm><img src=images/table/t_15.jpg></td>");
	    sb_HTML.append("<td height=1 width=1><img src=images/table/t_17.jpg></td>");
	    sb_HTML.append("</tr>");
	    sb_HTML.append("</table>");
	    
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
