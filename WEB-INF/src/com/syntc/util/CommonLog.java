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
 * CLASS      ： CommonLog
 * VERSION    ： 0.00
 * DESC       : OPAL 日志文件共通处理
 * DATE       ： 2006/07/09
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/09 0.00 作成
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
     * 详细说明 将信息写入到日志文件中
     * @param p_strType 日志类型
     * @param p_strModelName 模块名称
     * @param p_strLogPoint 日志跟踪点
     * @param p_strLogInfo 日志信息
     * @return void
     * @exception IOException
     */	    
    public void writeLog(String p_strType,  //日志类型 
    		String p_strModelName,          //模块名称
    		String p_strLogPoint,           //日志跟踪点
    		String p_strLogInfo){           //日志信息

        //取得服务器的当前时间
    	String str_FileName = "";           //文件名称
    	String strLogInfo   = "";           //日志信息    	
        Date now = new Date();              //WEB服务器日期
        
        StringBuffer strbuffer = new StringBuffer("");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        
        //生成文件名称
        str_FileName = CommonConstants.CLDEF_LOG_PATH + formatter.format(now) + ".log";
        
        //生成日志信息
        strbuffer.append("[TIME:" + now + "]");
        strbuffer.append("[TYPE:" + p_strType + "]");
        strbuffer.append("[" + p_strModelName + ":" + p_strLogPoint + "]");
        strbuffer.append("[MSG :" + p_strLogInfo + "]");
        strbuffer.append("\n");
        
        strLogInfo = strbuffer.toString();

        //将信息写入文件
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
     * 详细说明 将信息写入到日志文件中
     * @param p_strType 日志类型
     * @param p_strModelName 模块名称
     * @param p_strLogPoint 日志跟踪点
     * @param p_strLogInfo 日志信息
     * @return void
     * @exception IOException
     */	    
    public void writeTrace(String p_strType,  //日志类型 
    		String p_strModelName,            //模块名称
    		String p_strTracePoint,           //日志跟踪点
    		String p_strTraceInfo){           //日志跟踪信息

        //取得服务器的当前时间
    	String str_FileName = "";           //文件名称
    	String strLogInfo   = "";           //日志信息    	
        Date now = new Date();              //WEB服务器日期
        
        StringBuffer strbuffer = new StringBuffer("");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        
        //生成文件名称
        str_FileName = CommonConstants.CLDEF_TRC_PATH + formatter.format(now) + ".trc";
        
        
        //生成日志信息
        strbuffer.append("[TIME:" + now + "]");
        strbuffer.append("[TYPE:" + p_strType + "]");
        strbuffer.append("[" + p_strModelName + ":" + p_strTracePoint + "]");
        strbuffer.append("[MSG :" + p_strTraceInfo + "]");
        strbuffer.append("\n");
        
        strLogInfo = strbuffer.toString();

        //将信息写入文件
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
