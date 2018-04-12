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

/*
 * CLASS      ： Parameters
 * DESC       :  数据传递类
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */

package com.syntc.util;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.LinkedList;
import com.syntc.util.StringUtil;


public class Parameters extends ParameterBase {

  private final static boolean DEBUG = false;

  /**
   * 构造函数
   * @param request 系统得到的request
   * @param response  系统得到的response
   */
  public Parameters(HttpServletRequest request) {
    HttpSession session = request.getSession();
    setRequestParameters(request);
//    setSessionParameters(session);
  }
  /**
   * 把上一页面所提交Form的内容转存到Parameters class中
   * @param request 系统得到的request
   * @param response  系统得到的response
   */
  public void setRequestParameters(HttpServletRequest request){
    try{
      Enumeration allParameterNames = request.getParameterNames();
      while(allParameterNames.hasMoreElements()){
        String paramName = (String)allParameterNames.nextElement();

        if(paramName.equals("outparam")){
            continue;
        }

        String [] paramValue = request.getParameterValues(paramName);
        int paramValueSize = paramValue.length;
        for(int i=0; i<paramValueSize;i++){
          setParameters("request",this.getParameterName(paramName,i+1), StringUtil.ISO2GB2312(paramValue[i]));
          if(DEBUG){
            System.out.println(paramName+"-"+StringUtil.ISO2GB2312(paramValue[i]));
          }
        }
        paramName = null;
      }
      allParameterNames = null;
    }catch(Exception e){
      //
    }

  }

  /**
   *   This method modify parameter name of http request for <SELECT multiple>
   */
  private String getParameterName(String parameterName, int index){
    try{
      String multipleName;
      if(parameterName.startsWith("multi_")||parameterName.startsWith("MULTI_")){
        multipleName = parameterName.substring(6) + index;
        return multipleName;
      } else {
        if(index != 1){
          multipleName = parameterName + Integer.toString(index);
        } else {
          multipleName = parameterName;
        }
        return multipleName;
      }
    }catch(Exception e){
      // error
      return parameterName;
    }
  }


  /**
   * 把session中的内容转存到Parameters class中
   * @param request 系统得到的request
   * @param response  系统得到的response
   */
  public void setSessionParameters(HttpSession session){
    try{
      Enumeration allParameterNames = session.getAttributeNames();
      while(allParameterNames.hasMoreElements()){
        String paramName = (String)allParameterNames.nextElement();
        //System.out.println("paramName = " + paramName);
        Object paramValue = session.getAttribute(paramName);
        setParameters("session", paramName , paramValue);
        paramName = null;
        paramValue = null;
      }
    }catch(Exception e){
      //
    }

  }

}
