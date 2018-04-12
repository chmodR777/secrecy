//////////////////////////////////////////////////////////////
//
// COPYRIGHT (C) 2010 zq CORPORATION
//
// ALL RIGHTS RESERVED BY zq CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/*
 * CLASS      ： UserBean
 * VERSION    ： 0.00
 * DESC       : 用户登录业务处理逻辑BEAN
 * DATE       ： 2010-08-23
 * AUTHOR     ： deargod1981@sohu.com
 * HISTORY    ： 2010-08-23 0.00 作成
 */
package com.syntc.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class BackBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public BackBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		
		String  str_URL = null;
		Calendar cal=Calendar.getInstance();
        cal.setTime(new java.util.Date());
        int   year=cal.get(Calendar.YEAR);
        int   month=cal.get(Calendar.MONTH)+1;
        int   date=cal.get(Calendar.DATE);
        
        String  file_Code = (String)request.getParameter("backUpName");
        
    	String fileName = String.valueOf(year)+"_"+String.valueOf(month)+"_"+String.valueOf(date)+file_Code;
        try {
            Runtime rt = Runtime.getRuntime();

            // 调用 mysql 的 cmd:
            Process child = rt
                    .exec(" mysqldump --user=root --password=root his  --set-charset=utf8  ");// 设置导出编码为utf8。这里必须是utf8
           
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
                       
            InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码
           
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            
            
            File foder = new File("F:/backup1/");
            if(foder.exists()==false){
                foder.mkdirs();//多级目录
                  //foder.mkdir();//只创建一级目录
               }

            File file=new File(foder,fileName+".sql");
            if(!file.exists())
                file.createNewFile();

           
            // 要用来做导入用的sql目标文件：
            FileOutputStream fout = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
            writer.write(outStr);
            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
            writer.flush();

            // 别忘记关闭输入输出流
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
            
            String res= "success";
            request.setAttribute("res",res);

            str_URL = "/app/system/backup_up.jsp?actype=success";

        } catch (Exception e) {
        	 String res= "error";
             request.setAttribute("res",res);
        	str_URL = "/app/system/backup_up.jsp?actype=error";
            e.printStackTrace();
        }
		parameters.setParameters("results", "ForwardPage", str_URL);

	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}

}