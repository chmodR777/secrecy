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

package com.syntc.taglib.common;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpServletRequest;

import com.syntc.util.Parameters;

public class ParametersTag extends TagSupport {
    // DEBUG FLAG
    private final static boolean DEBUG = false;

    private String name = "";

    public void setName(String name) {
        this.name = name;
    }

    public int doStartTag() {
        return  SKIP_BODY;
    }

    public int doEndTag () {
        try {
        	HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
            Parameters parameters = (Parameters)request.getAttribute("outparam");
            if(parameters != null){
	            Object valueObject = parameters.getParameters("request", this.name);
	            if(valueObject!=null && valueObject instanceof String)
	            {
	               pageContext.getOut().print((String)valueObject);
	            }
	            else
	            {
	              pageContext.getOut().print("");
	            }
            }
        } catch (Exception ex) {
          System.out.println("error:"+ex.getMessage());
        }
        return  EVAL_PAGE;
    }
}
