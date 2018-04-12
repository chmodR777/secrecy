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
 * @author  jinghuizhen@hotmail.com
 * @Desc    按钮基类
 * @since   0.00
 */	
package com.syntc.taglib.html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ButtonBaseTag extends TagSupport {
	
	  //按钮宽度
	  private String Width;

	  //按钮标题
	  private String Caption;

	  //onclick 事件
	  private String OnClick;
	  
	  //id
	  private String Id;

	  public ButtonBaseTag() {
		  Width = "40";
		  Caption = "未定义";
		  OnClick = "alert('未定义onclick 事件')";
		  id = "";
	  }

	  public String getId() {
	    return id;
	  }

	  public void setid(String Id) {
	    this.id = Id; 
	  }
	  public String getWidth() {
	    return Width;
	  }

	  public void setwidth(String Width) {
	    this.Width = Width;
	  }

	  public String getOnclick() {
	    return OnClick;
	  }

	  public void setonclick(String OnClick) {
	    this.OnClick = OnClick;
	  }

	  public String getCatpion() {
	    return Caption;
	  }

	  public void setcaption(String Caption) {
		  
	    this.Caption = Caption;
	    
	  }

	  public int doEndTag(){

        StringBuffer sb_HTML = new StringBuffer();

	    HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
	    
	    sb_HTML.append("<td width=\"24\" class=\"imagebutlf\"><img scr=\"");
	    sb_HTML.append(request.getContextPath());
	    sb_HTML.append("/images/clear.gif\" width=\"24\" height=\"1\"></td>");
	    sb_HTML.append("<td nowrap ");
	    if (Width != null) {
	      sb_HTML.append("width=\"");
	      sb_HTML.append(this.Width);
	      sb_HTML.append("\" ");
	    }

	    sb_HTML.append("align=\"center\" class=\"imagebut\"><a");
	    sb_HTML.append(" onclick=\"");

	    if(OnClick != null ){
	        sb_HTML.append(" javascript: " + OnClick);
	    }

	    sb_HTML.append("\"");
	    sb_HTML.append("onmouseover=\"this.style.cursor='hand';this.style.color= '#996600'\"");
	    sb_HTML.append("onmouseout=\"this.style.color= 'black'\"");
	    sb_HTML.append(" id=\"" + this.id + "\" ");
	    sb_HTML.append(">");

	    sb_HTML.append(this.Caption);
	    sb_HTML.append("</a></td>");
	    sb_HTML.append("<td width=\"14\" class=\"imagebutrg\"><img scr=\"");
	    sb_HTML.append(request.getContextPath());
	    sb_HTML.append("/images/clear.gif\" width=\"14\" height=\"1\"></td>");
	    
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
	    Caption = null;
	    OnClick = null;
	    Width = null;
	  }
}
