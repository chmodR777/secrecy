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
 * <p>通用按钮共通处理;
 *
 * @version 0.00, 2006-06-07
 * @author  
 * @Desc    进度条基类
 * @since   0.00
 */	
package com.syntc.taglib.html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ProBarTag extends TagSupport {
	
	  public ProBarTag() {
	  }

      public int doEndTag(){

            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
          
            StringBuffer sb_HTML = new StringBuffer();
           
            sb_HTML.append(" <DIV id=\"opal_proc\" style=\"position:absolute;visibility:visible;display:none\">");
            sb_HTML.append(" <img style='position: absolute;top:150;left:250;visibility: visible;' ");
            sb_HTML.append("      src=\"" + request.getContextPath() + "/images/processing.gif\" width=\"100\" height=\"100\">");
            sb_HTML.append(" </DIV> ");
            
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