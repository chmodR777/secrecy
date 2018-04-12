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

import com.syntc.constants.CommonConstants;

public class DataIsNullTag extends TagSupport {
	
	  //跨越多行
	  private String cols;

	  public DataIsNullTag() {
		  cols = "1";
	  }
	  public String getcols() {
	    return this.cols;
	  }

	  public void setcols(String cols) {
	    this.cols = cols;
	  }
	  
	  public int doEndTag(){

	    StringBuffer sb_HTML = new StringBuffer();

	    sb_HTML.append("<tr><td colspan=\""+ this.cols +"\" align=\"center\" class=nm><font color=red>");
	    sb_HTML.append(CommonConstants.DATAISNULL + "</font></td></tr>");
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
