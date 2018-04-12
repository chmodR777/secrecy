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
 * CLASS      �� CommonLog
 * VERSION    �� 0.00
 * DESC       : OPAL ��־�ļ���ͨ����
 * DATE       �� 2006/07/09
 * AUTHOR     �� jinghuizhen@hotmail.com
 * HISTORY    �� 2006/07/09 0.00 ����
 */
package com.syntc.util;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.syntc.constants.*;

public class CommonLog {
    
    public CommonLog() {
 
    }

    /**
     * ��ϸ˵�� ����Ϣд�뵽��־�ļ���
     * @param p_strType ��־����
     * @param p_strModelName ģ������
     * @param p_strLogPoint ��־���ٵ�
     * @param p_strLogInfo ��־��Ϣ
     * @return void
     * @exception IOException
     */	    
    public void writeLog(String p_strType,  //��־���� 
    		String p_strModelName,          //ģ������
    		String p_strLogPoint,           //��־���ٵ�
    		String p_strLogInfo){           //��־��Ϣ

        //ȡ�÷������ĵ�ǰʱ��
    	String str_FileName = "";           //�ļ�����
    	String strLogInfo   = "";           //��־��Ϣ    	
        Date now = new Date();              //WEB����������
        
        StringBuffer strbuffer = new StringBuffer("");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        
        //�����ļ�����
        str_FileName = CommonConstants.CLDEF_LOG_PATH + formatter.format(now) + ".log";
        
        //������־��Ϣ
        strbuffer.append("[TIME:" + now + "]");
        strbuffer.append("[TYPE:" + p_strType + "]");
        strbuffer.append("[" + p_strModelName + ":" + p_strLogPoint + "]");
        strbuffer.append("[MSG :" + p_strLogInfo + "]");
        strbuffer.append("\n");
        
        strLogInfo = strbuffer.toString();

        //����Ϣд���ļ�
        try{
            RandomAccessFile logrFile;
            logrFile = new RandomAccessFile(str_FileName,"rw");
            logrFile.seek(logrFile.length( ));
            logrFile.writeBytes( this.IsoToGBK( strLogInfo) );
            logrFile.close();
        }
        catch(IOException e)
        {
            System.out.println("writeLog:" + e.getMessage());
        }

    }
    
    /**
     * ��ϸ˵�� ����Ϣд�뵽��־�ļ���
     * @param p_strType ��־����
     * @param p_strModelName ģ������
     * @param p_strLogPoint ��־���ٵ�
     * @param p_strLogInfo ��־��Ϣ
     * @return void
     * @exception IOException
     */	    
    public void writeTrace(String p_strType,  //��־���� 
    		String p_strModelName,            //ģ������
    		String p_strTracePoint,           //��־���ٵ�
    		String p_strTraceInfo){           //��־������Ϣ

        //ȡ�÷������ĵ�ǰʱ��
    	String str_FileName = "";           //�ļ�����
    	String strLogInfo   = "";           //��־��Ϣ    	
        Date now = new Date();              //WEB����������
        
        StringBuffer strbuffer = new StringBuffer("");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        
        //�����ļ�����
        str_FileName = CommonConstants.CLDEF_TRC_PATH + formatter.format(now) + ".trc";
        
        
        //������־��Ϣ
        strbuffer.append("[TIME:" + now + "]");
        strbuffer.append("[TYPE:" + p_strType + "]");
        strbuffer.append("[" + p_strModelName + ":" + p_strTracePoint + "]");
        strbuffer.append("[MSG :" + p_strTraceInfo + "]");
        strbuffer.append("\n");
        
        strLogInfo = strbuffer.toString();

        //����Ϣд���ļ�
        try{
            RandomAccessFile logrFile;
            logrFile = new RandomAccessFile(str_FileName,"rw");
            logrFile.seek(logrFile.length( ));
            logrFile.writeBytes(this.IsoToGBK( strLogInfo) );
            logrFile.close();
        }
        catch(IOException e)
        {
            System.out.println("writeTrc:" + e.getMessage());
        }
    }
  
    private static String IsoToGBK(String str) throws java.io.UnsupportedEncodingException {
    	String strUTF8 = new String(str.getBytes("ISO-8859-1"), "GB2312");
    	return strUTF8;
    }  
}
