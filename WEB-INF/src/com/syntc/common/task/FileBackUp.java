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
 * CLASS      ： FileBackUp
 * VERSION    ： 0.1
 * DESC       : 文件备份
 * DATE       ： 2007/04/18
 * AUTHOR     ： rr
 * HISTORY    ： 2007/04/18 0.00 作成
 */
package com.syntc.common.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.syntc.constants.CommonConstants;

public class FileBackUp {
	private static final String PATH = CommonConstants.UPLOADPAH + "\\";
	private static final String COPY_PATH = CommonConstants.BACKUPPATH;
    private static final String KEEP_PERIOD = CommonConstants.KEEP_PERIOD;
    private static final String FORMAT_DATE = "yyyyMMdd";
    private String strCompareDay = "";
    private String strDate = "";

    /**
     * 备份程序实行
     * @return string 执行结果
     */
    public String execute(){
        
        String returnResult = "";
		int iPastDay = Integer.parseInt(KEEP_PERIOD)*(-1);
        Calendar calendar = new GregorianCalendar();
        //strDate = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        strDate = new SimpleDateFormat("yyyyMMddhhmmss").format(calendar.getTime());
 		
        File fileCopy = new File(PATH);

		if ((fileCopy == null) || !fileCopy.isDirectory()) {
            returnResult = "指定的文件保存路径不存在。";
            return returnResult ;
        }

        File fileCopyTo = new File(COPY_PATH + strDate);
		
        if ((fileCopyTo == null) || !fileCopyTo.isDirectory()) {
            fileCopyTo.mkdirs();
        }

        calendarPastday(iPastDay);
        
        try{   

            copyDirectory(fileCopy);

            returnResult = "文件备份成功。";
            
        } catch(Exception e) {
            e.printStackTrace();
            returnResult = e.getMessage();
        }
        return returnResult;
    }

    /**
     * 计算保管期间
     * @param past 保管天数
     */
	private void calendarPastday(int past) {
		GregorianCalendar cal = new GregorianCalendar();
		StringBuffer sbTemp = new StringBuffer();

		cal.add(Calendar.DATE, past);
        sbTemp.append(Integer.toString(cal.get(Calendar.YEAR)));
        sbTemp.append(addZeroFormat(Integer.toString(cal.get(Calendar.MONTH)+1)));
        sbTemp.append(addZeroFormat(Integer.toString(cal.get(Calendar.DATE))));

		strCompareDay = sbTemp.toString();
	}

	/**
	 * 为字符串补“0”
	 * @param str 需要格式化的字符串
	 * @return 格式化后的字符串
	 */
    private String addZeroFormat(String str) {
		StringBuffer sbfTemp = new StringBuffer();
		String strTemp = null;
		sbfTemp = sbfTemp.append("00");
		sbfTemp = sbfTemp.append(str);
		strTemp = sbfTemp.toString();
		strTemp = strTemp.substring(strTemp.length()-2,strTemp.length());
		return strTemp;
	}

    /**
     * 检查文件夹内符合要求的文件，并复制文件
     * @param copyFile 需要检查的文件路径
     */
	private void copyDirectory(File copyFile) {

		if ((copyFile == null) || !copyFile.isDirectory()) {
			return;
		}

		String strFileName = "";
		File[] entries = copyFile.listFiles();
		int iFileLength = entries.length;

		for (int i = 0; i < iFileLength; i++) {

            if (entries[i].isDirectory()) {
				copyDirectory(entries[i]);
			} else {
				strFileName = entries[i].getName();
				if (checkCopy(strFileName.toLowerCase())) {
                    copyFile(entries[i].toString(),COPY_PATH + strDate + "/" + strFileName);
				}
			}
		}
	}

	/**
	 * 复制文件
	 * @param oldPath 原始文件
	 * @param newPath 新生成的文件
	 */
    private void copyFile(String oldPath, String newPath){

        try {
            int bytesum = 0;
            int byteread = 0;
            File oldFile = new File(oldPath);
            if (oldFile.exists()) {
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream outStream = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ( (byteread=inStream.read(buffer))!=-1){
                    bytesum += byteread;
                    outStream.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
    /**
     * 判断文件是否需要复制
     * @param strFileName 需要判断的文件名称
     * @return true 需要复制； false 不需要复制
     */
    private boolean checkCopy(String strFileName) {
		boolean bolReturn = false;
		int iComp = 0;
		String strTemp = "";

		if (strFileName.length() >= 8) {
			strTemp = strFileName.substring(0, 8);
		} else {
			return bolReturn;
		}

		if (checkCompareString(strTemp)) {
			iComp = strTemp.compareTo(strCompareDay);
			if (iComp < 0) {
				bolReturn = false;
			} else {
				bolReturn = true;
            }
		}

		return bolReturn;
	}

    /**
     * 判断文件名称是否符合日期格式
     * @param strFormatString
     * @return
     */
	private boolean checkCompareString(String strFormatString) { 
		SimpleDateFormat simpledateformat = null;

        simpledateformat = new SimpleDateFormat(FORMAT_DATE);

		try{
			simpledateformat.parse(strFormatString);
		} catch(ParseException exception) {
			return false;
		}

		return true;
	}

}
