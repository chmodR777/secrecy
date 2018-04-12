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
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.upload.UploadUtil;
import com.syntc.common.upload.file;
import com.syntc.common.upload.files;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class BackUp_BackBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public BackUp_BackBean() {
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
		// 迁移画面
		try {
			UploadUtil myUpload = new UploadUtil();
			// 初始化工作
			myUpload.initialize(request);
			// 设定允许的文件后缀名
			myUpload.setAllowedExtList("sql");
			// 设定是否允许覆盖服务器上的同名文件
			myUpload.setIsCover(true);
			// 设定单个文件大小的限制10M
			myUpload.setMaxFileSize(10 * 1024 * 1024);
			// 设定上传的物理路径
			String path = request.getSession().getServletContext() .getRealPath("/") + "chart\\";
			this.isChartPathExist(path);
			myUpload.setRealPath(path);

			// 校验文件大小
			// 将所有数据导入组件的数据结构中
			myUpload.upload();
			
			// 得到上传的文件，此处设定上传文件为1个
			files myFiles = myUpload.getFiles();

			file myFile = myFiles.getFile(0);
			// 重新设置文件名，采用日期加小时分秒
			String fileName = System.currentTimeMillis() + ".sql";
			myFile.setName(fileName);
			myFile.saveAs();

			Runtime rt = Runtime.getRuntime();
	
			Process child = rt.exec(" mysql -u root --password=root his   ");
			
			OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + fileName), "utf8"));
			while ((inStr = br.readLine()) != null) {
			sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
	
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
			writer.flush();
			// 别忘记关闭输入输出流
			out.close();
			br.close();
			writer.close();
			
			String res= "re_success";
            request.setAttribute("res",res);

            str_URL = "/app/system/backup_up.jsp?actype=success";
	
            File theFile = new File(path + fileName);
			theFile.delete();
		} catch (Exception e) {
			 String res= "re_error";
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
	
	/**
     * 如果存储图片路径不存在，则创建
     */
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    }

}