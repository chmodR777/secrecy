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
 * CLASS      �� UserBean
 * VERSION    �� 0.00
 * DESC       : �û���¼ҵ�����߼�BEAN
 * DATE       �� 2010-08-23
 * AUTHOR     �� deargod1981@sohu.com
 * HISTORY    �� 2010-08-23 0.00 ����
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
	 * ���캯��
	 */
	public BackUp_BackBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		
		String  str_URL = null;
		// Ǩ�ƻ���
		try {
			UploadUtil myUpload = new UploadUtil();
			// ��ʼ������
			myUpload.initialize(request);
			// �趨������ļ���׺��
			myUpload.setAllowedExtList("sql");
			// �趨�Ƿ������Ƿ������ϵ�ͬ���ļ�
			myUpload.setIsCover(true);
			// �趨�����ļ���С������10M
			myUpload.setMaxFileSize(10 * 1024 * 1024);
			// �趨�ϴ�������·��
			String path = request.getSession().getServletContext() .getRealPath("/") + "chart\\";
			this.isChartPathExist(path);
			myUpload.setRealPath(path);

			// У���ļ���С
			// ���������ݵ�����������ݽṹ��
			myUpload.upload();
			
			// �õ��ϴ����ļ����˴��趨�ϴ��ļ�Ϊ1��
			files myFiles = myUpload.getFiles();

			file myFile = myFiles.getFile(0);
			// ���������ļ������������ڼ�Сʱ����
			String fileName = System.currentTimeMillis() + ".sql";
			myFile.setName(fileName);
			myFile.saveAs();

			Runtime rt = Runtime.getRuntime();
	
			Process child = rt.exec(" mysql -u root --password=root his   ");
			
			OutputStream out = child.getOutputStream();//����̨��������Ϣ��Ϊ�����
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
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			// �����ǹر����������
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
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}
	
	/**
     * ����洢ͼƬ·�������ڣ��򴴽�
     */
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    }

}