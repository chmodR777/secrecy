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

    public int counter = 0;  // ������
	private int recnum = 0;   // ��¼��

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

            //�м�¼����
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
          counter += 1;             // ��һ����¼ 
          i_retType = EVAL_BODY_TAG;//����δ��������¶���body content��ֵ
        }
        else{

          i_retType = SKIP_BODY;// ���������������ִ��
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