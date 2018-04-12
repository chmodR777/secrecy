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
 * CLASS      �� RequestUtil
 * DESC       :  HttpRequest ���󹤾���
 * VERSION    �� 0.00
 * DATE       �� 2006/07/05
 * AUTHOR     �� jinghuizhen@hotmail.com
 * HISTORY    �� 2006/07/05 0.00 ����
 */

package com.syntc.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.ServletException;

public class RequestUtil extends Object  {
   /**
   * �õ�request��servletPath
   * @param request http����ӿ�
   * @return String servletName(û����չ��)
   */
   public static String getServletNameNoExtend(HttpServletRequest request){
    String servletPath =  request.getServletPath();
    int virguleIndex = servletPath.indexOf('/');
    int dotIndex = servletPath.indexOf('.');
    String servletName = "";
    if(dotIndex==-1){
      //servletû����չ��
      servletName = servletPath.substring(virguleIndex+1);
    }else{
      servletName = servletPath.substring(virguleIndex+1, dotIndex);
    }
    return servletName;
   }

   /**
   * �õ�request��servletPath
   * @param request http����ӿ�
   * @return String servletName(����չ��)
   */
   public static String getServletName(HttpServletRequest request){
    String servletPath =  request.getServletPath();
    int virguleIndex = servletPath.indexOf('/');
    String servletName = servletPath.substring(virguleIndex+1);
    return servletName;
   }
}
