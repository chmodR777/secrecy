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

import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.common.bean.Common;

public class ResultHeaderTag extends BodyTagSupport {
    public ResultObj resultset = null;

    private String resultName = "";

    public int counter = 0;  // 计数器
	private int recnum = 0;   // 记录数

    public void setResultName(String resultName) {
        this.resultName = resultName ;
    }

    public ResultHeaderTag () {
      resultName = null;
    }

    public int doStartTag() {

      int i_retType = SKIP_BODY;
      
	  try {
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        Parameters parameters = (Parameters)request.getAttribute("outparam");
 
        if(parameters != null)
        {
			resultset = (ResultObj)parameters.getParameters("results", resultName);
            recnum = resultset.getRows() - 1;

            //有记录存在
            if(recnum > 0)
            {
               counter = 1;
               i_retType = EVAL_BODY_TAG;
            }
          
        }
      }
      catch(Exception e) {
        System.out.println("ResultHeaderTag(doStartTag) error=:"+e.getMessage());
      }
      return  i_retType;
    }

    public int doAfterBody () {
      int i_retType = SKIP_BODY;

      try {
          BodyContent bc = getBodyContent();
          getPreviousOut().print(bc.getString());
          bc.clearBody();
      }
      catch (Exception e) {
	      System.out.println("ResultHeaderTag(doAfterBody) error=:"+e.getMessage());
	  }

      try {
        if(counter < recnum)
        {
          counter += 1;             // 下一条记录 
          i_retType = EVAL_BODY_TAG;//还有未输出，重新对其body content计值
        }
        else{

          i_retType = SKIP_BODY;// 输出完毕则继续往下执行
        }
      } catch (Exception e) {
        System.out.println("ResultHeaderTag(doAfterBody) error1=:"+e.getMessage());
      }
      return  i_retType;
    }

    public int doEndTag () {
      try {
        resultset = null;
      } catch (Exception e) {
        System.out.println("ResultHeaderTag(doEndTag) error=:"+e.getMessage());
      }
      return  EVAL_PAGE;
    }
}