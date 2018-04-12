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
 * <p>通用功能名共通处理;
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


public class FuncHeaderTag extends TagSupport {

	//标题1
	private String header;

	private String showall;

	public FuncHeaderTag() {
		header = "未定义";
		showall = "no";
	}

	public String getheader() {
		return this.header;
	}
	public void setheader(String header) {
		this.header = header;
	}

	public String getshowall() {
		return this.showall;
	}
	public void setshowall(String showall) {
		this.showall = showall;
	}
	
	public int doEndTag() {
		String str_table_height = "1";
		if (showall.equals("yes")) {
			str_table_height = "42";
		}
        //取得session，取得UserBean 
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		UserBean user = (UserBean)request.getSession().getAttribute("UserBean");

		StringBuffer sb_HTML = new StringBuffer();
	    sb_HTML.append(      "<script language=\"JavaScript\">");
	    //sb_HTML.append(      "parent.document.frames.item('ttop').funChangePro(\""+user.+"\");");
	    sb_HTML.append(      "</script>");

		sb_HTML.append("<table cellpadding=0 cellspacing=0 topmargin=0 leftmargin=0 border=0 width=606>");
		sb_HTML.append("<tr><td width=1 style=\"background-image:url(images/frame/tt_1.jpg);background-repeat:repeat-x;background-position:top;\"><img src=images/clear.gif width=16 height=");
		sb_HTML.append(str_table_height);
		sb_HTML.append("></td>");
		sb_HTML.append("<td nowrap style=\"font-size:16px;font-weight:bold;color:#557755;padding-top:6px;vertical-align:top;background-image:url(images/frame/tt_2.jpg);background-repeat:repeat-x;background-position:top;\">");
		sb_HTML.append(this.header);
		sb_HTML.append("&nbsp;&nbsp;</td><td width=1 style=\"background-image:url(images/frame/tt_3.jpg);background-repeat:repeat-x;background-position:top;\"><img src=images/clear.gif width=16 height=1></td></tr>");
		sb_HTML.append("</table>");

		JspWriter out = pageContext.getOut();

		try {
			out.write(sb_HTML.toString());
		} catch (Exception ex) {
			System.out.println("com.syntc.taglib.html Exception " + ex.toString());
		}

		return Tag.EVAL_PAGE;

	}

	public void release() {
		super.release();
	}
}
