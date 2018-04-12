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

public class DateImgTag extends TagSupport {
	
	  //标题1
	  private String element;
	  //值
	  private String value;

	  public DateImgTag() {
		  element = "";
		  value = "";
	  }
	  
	  public String getelement() {
	    return this.element;
	  }

	  public void setelement(String p_element) {
	    this.element = p_element;
	  }
	  
	  public String getvalue(){
		  return this.value;
	  }
	  
	  public void setvalue(String p_value){
		  this.value = p_value;
	  }
	  
	  public int doEndTag(){

	    StringBuffer sb_HTML = new StringBuffer();

	    sb_HTML.append("<input type=\"text\" name=\"" + this.element + "\" value=\"" + this.value + "\" ReadOnly>");
	    sb_HTML.append("<img src=\"images/time.gif\" onclick=\"openwin('" + this.element + "')\" ");
	    sb_HTML.append("style=\"cursor:hand\">"); 
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
