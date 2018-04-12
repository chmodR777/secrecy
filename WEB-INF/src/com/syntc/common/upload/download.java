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

package com.syntc.common.upload;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

public class download extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public download()
	{
		super();
	}
	public void destroy()
	{
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{

		response.setContentType("text/html");
		request.setCharacterEncoding("GBK");
		// 新建一个SmartUpload对象
		SmartUpload su = new SmartUpload();
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"));
		// 初始化
		su.initialize(this.getServletConfig(),request,response);
		su.setContentDisposition(null);//如果要实现单击在浏览器打开,注释该即可.
		// 下载文件
		try
		{
			System.out.print(name);
			su.downloadFile("D:/"+name);//目录根据实际改变
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

