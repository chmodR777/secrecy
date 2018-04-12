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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class BackUpBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public BackUpBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼���������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		
		String  str_URL = null;
		Calendar cal=Calendar.getInstance();
        cal.setTime(new java.util.Date());
        int   year=cal.get(Calendar.YEAR);
        int   month=cal.get(Calendar.MONTH)+1;
        int   date=cal.get(Calendar.DATE);
        
        
        
        
    	String fileName = String.valueOf(year)+"_"+String.valueOf(month)+"_"+String.valueOf(date);
        
        
    	
        try {
            Runtime rt = Runtime.getRuntime();

            // ���� mysql �� cmd:
            Process child = rt
                    .exec(" mysqldump -u root --password=root his  --set-charset=utf8   ");// ���õ�������Ϊutf8�����������utf8
           
            // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
            InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
                       
            InputStreamReader xx = new InputStreamReader(in, "utf8");// �������������Ϊutf8�����������utf8����������ж����������
           
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // ��Ͽ���̨�����Ϣ�ַ���
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            

            File file=new File("���ݿⱸ��"+fileName+".sql");
            if(!file.exists())
                file.createNewFile();

           
            // Ҫ�����������õ�sqlĿ���ļ���
            FileOutputStream fout = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
            writer.write(outStr);
            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
            writer.flush();

            // �����ǹر����������
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
            
            String realName = "���ݿⱸ��"+fileName+".sql";
            File zipFile = new File("���ݿⱸ��"+fileName+".sql");
			long filesize = zipFile.length();
			FileInputStream fileIn;
			fileIn = new FileInputStream(zipFile);
			
			response.reset();
			response.setContentType("bin");
			response.addHeader("content_type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=\"" +
                    URLEncoder.encode(realName, "UTF-8") + "\"");
			response.addHeader("content-length", Long.toString(filesize));
			 byte bytes[] = new byte[500];
			int len;
				while ((len = fileIn.read(bytes)) != -1) {
				      response.getOutputStream().write(bytes, 0, len);
				}
            
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
	 * ҳ�������⴦������
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}

}