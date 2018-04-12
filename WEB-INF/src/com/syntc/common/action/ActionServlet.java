////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2010 zq CORPORATION
//
// ALL RIGHTS RESERVED BY SYNTC CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR SYNTC PURPOSE FOR WHICH IT WAS
// FURNISHED BY NEC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/*
 * CLASS      ： ActionServlet
 * VERSION    ： 0.00
 * DATE       ： 2010-08-25
 * AUTHOR     ： deargod1981@sohu.com
 * HISTORY    ： 2010-08-25 作成
 */
package com.syntc.common.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syntc.util.CommonException;
import com.syntc.util.Parameters;
import com.syntc.util.RequestUtil;
import com.syntc.util.StringUtil;

public class ActionServlet extends HttpServlet {

	  //业务逻辑处理bean 类路径
	  public static final String ACTION_BEAN_PATH = "com.syntc.business.";

	  //业务逻辑处理bean 类名结尾字符串
	  public static final String ACTION_BEAN_NAME = "Bean";
	  
	  //程序目录
	  public static String RootPath = null;
	  
	  //计数器
	  public static int counter = 0;
	  public static int PageCounter = 0;
	  
	  //DEBUG 状态
	  private final static boolean DEBUG = false;

	  //Servlet Context	  
	  private ServletContext application = null;	  
	  /**
	   *  取得Servlet Context
	   */
	  public void init(ServletConfig config) throws ServletException
	  {
		this.application = config.getServletContext();
		RootPath = application.getRealPath("/");
	  }

	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	                    throws ServletException, IOException {
	  }

	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
		 request.setCharacterEncoding("GBK"); 
	     doGet(request, response);
	  }

	  public void service(HttpServletRequest request, HttpServletResponse response)
	                      throws ServletException, IOException {
	    long beginTimeMillis = System.currentTimeMillis();//得到业务处理的开始时间

	    HttpSession session = request.getSession();

	    if(DEBUG){
	      System.out.println( "Action: begin" );
	    }

	    /**
	     * 构造数据输入类（转换session和request）
	     */
	    Parameters parameters = new Parameters(request);

	    /**
	     * 创建对象，用于实例化业务Bean
	     */
	    String actionKey = RequestUtil.getServletNameNoExtend(request);

	    StringBuffer BusinessBeanName = new StringBuffer().append(ACTION_BEAN_PATH).append(StringUtil.replace(actionKey,"/",".")).append(ACTION_BEAN_NAME);

	    if(DEBUG){
	        System.out.println("Action：实例化业务处理类[" + BusinessBeanName.toString() + "]");
	    }

	    try{
	      Class BusinessBeanClass = Class.forName(BusinessBeanName.toString());
	      Object BusinessBeanOjbect = BusinessBeanClass.newInstance();
	      Method BMethod = null;
				Class[] paramClasses = null;
	      Object[] paramObjects = null;

	      paramClasses = new Class[3];
				paramClasses[0] = HttpServletRequest.class;
				paramClasses[1] = HttpServletResponse.class;
				paramClasses[2] = Parameters.class;

	      paramObjects = new Object[3];
	      paramObjects[0] = request;
	      paramObjects[1] = response;
	      paramObjects[2] = parameters;

	      /* -------------------- 业务逻辑处理 ------------------- */
	      if(DEBUG){
	          System.out.println("Action：执行execute方法");
	      }

	      // 取得execute方法
	      BMethod = BusinessBeanClass.getMethod("execute", paramClasses);

	      // 执行execute方法
	      BMethod.invoke(BusinessBeanOjbect, paramObjects);

	      /* -------------------- 数据输出类的实类设置到session的属性里面 --------------------- */
	      Parameters oldParameters = (Parameters)request.getAttribute("outparam");
	      if(oldParameters!=null){
	            oldParameters.close();
	            oldParameters= null;
	        }
	      request.removeAttribute("outparam");
	      request.setAttribute("outparam", parameters);


	      long endTimeMillis = System.currentTimeMillis();
	      if(DEBUG){
	          System.out.println("Action：业务处理耗时 -- "+(endTimeMillis - beginTimeMillis)+"MSEL"); //得到业务处理的结束时间
	          System.out.println("Action：画面迁移【" + (String)parameters.getParameters("results", "ForwardPage")+"】");
	      }

	      if(DEBUG){
	          System.out.println((String)parameters.getParameters("results", "ForwardPage"));
	      }
	      request.getRequestDispatcher((String)parameters.getParameters("results", "ForwardPage")).forward(request,response);

	      BusinessBeanClass = null;
	      BusinessBeanOjbect = null;
	      BMethod = null;
	      paramClasses = null;
	      paramObjects = null;
	      return;
	    }
	    catch(ClassNotFoundException CNFex){
	      System.out.println("Action：业务处理类实例化失败1【" + BusinessBeanName.toString() + "】"+CNFex.getMessage());
	    }
	    catch(InstantiationException Iex){
	      System.out.println("Action：业务处理类实例化失败2【" + BusinessBeanName.toString() + "】"+Iex.getMessage());
	    }
	    catch(IllegalAccessException IAex){
	      System.out.println("Action：业务处理类实例化失败3【" + BusinessBeanName.toString()+"】"+IAex.getMessage());
	    }
	    catch(NoSuchMethodException NSMex){
	      System.out.println("Action：业务处理类实例化失败4【" + BusinessBeanName.toString() + "】"+NSMex.getMessage());
	    }
	    catch(InvocationTargetException ITex){
	      System.out.println("Action：业务处理类实例化失败5【" + BusinessBeanName.toString()+"】"+ITex.getMessage());
	    }
	    catch(CommonException Cex){
	      System.out.println("Action：业务处理类实例化失败6【" + BusinessBeanName.toString()+"】"+Cex.getMessage());
	    }
	    catch(Exception ex){
	    }
	    parameters = null;
	    actionKey = null;
	    if(BusinessBeanName!=null){
	        BusinessBeanName.delete(0, BusinessBeanName.length());
	        BusinessBeanName = null;
	    }
	  }
	}

