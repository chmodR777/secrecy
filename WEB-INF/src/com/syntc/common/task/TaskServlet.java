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
 * CLASS      ： TaskServlet
 * VERSION    ： 0.1
 * DESC       : 文件备份
 * DATE       ： 2007/04/18
 * AUTHOR     ： rr
 * HISTORY    ： 2007/04/18 0.00 作成
 */
package com.syntc.common.task;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * <p>This is a simple servlet that holds a global connection
 * pool. The Servlet context is used to store a named attribute
 * (this servlet) so that other servlets have access to the
 * connection pool
 */

public class TaskServlet extends HttpServlet
{

  /**
    * <p>Initialize the servlet. This is called once when the
    * servlet is loaded. It is guaranteed to complete before any
    * requests are made to the servlet
    *
    * @param cfg Servlet configuration information
    */
  public void init(ServletConfig cfg)
    throws ServletException
    {
        //System.out.println("初始化备份任务");

        //FileTrans dt = new FileTrans();

        //dt.addTask();

        //dt = null;

    }


}

