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
import javax.servlet.jsp.JspException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class ParametersEqualTag extends TagSupport {
    // DEBUG FLAG
    private final static boolean DEBUG = false;

    private String name = "";
    private String value = "";

    public void setName(String name) {
        this.name = name; 
    }

    public void setValue(String value) {
        if(value==null)
          this.value = "";
        else
          this.value = value;
    }

    public int doStartTag() {
      int returnType = SKIP_PAGE;
        try
        {
            HttpSession session = pageContext.getSession();
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
            Parameters parameters = (Parameters)session.getAttribute("outparam");
            Object valueObject = parameters.getParameters("request", this.name);
            String strName="";
            if(valueObject!=null && valueObject instanceof String)
            {
               strName = (String)StringUtil.ISO2GB2312((String)valueObject);
            }
            
            if(strName.equals(this.value))
            {
               returnType = EVAL_BODY_INCLUDE;
            }
            else
            {
               returnType = SKIP_BODY;
            }
          
        }
        catch(Exception ex){
          System.out.println("error:"+ex.getMessage());
        }

        return  returnType;
    }

    public int doEndTag () {
      return  EVAL_PAGE;
    }
}
