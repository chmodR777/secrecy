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
 * CLASS      �� FileBackUp
 * VERSION    �� 0.1
 * DESC       : �ļ�����
 * DATE       �� 2007/04/18
 * AUTHOR     �� rr
 * HISTORY    �� 2007/04/18 0.00 ����
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
     * ���ݳ���ʵ��
     * @return string ִ�н��
     */
    public String execute(){
        
        String returnResult = "";
		int iPastDay = Integer.parseInt(KEEP_PERIOD)*(-1);
        Calendar calendar = new GregorianCalendar();
        //strDate = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        strDate = new SimpleDateFormat("yyyyMMddhhmmss").format(calendar.getTime());
 		
        File fileCopy = new File(PATH);

		if ((fileCopy == null) || !fileCopy.isDirectory()) {
            returnResult = "ָ�����ļ�����·�������ڡ�";
            return returnResult ;
        }

        File fileCopyTo = new File(COPY_PATH + strDate);
		
        if ((fileCopyTo == null) || !fileCopyTo.isDirectory()) {
            fileCopyTo.mkdirs();
        }

        calendarPastday(iPastDay);
        
        try{   

            copyDirectory(fileCopy);

            returnResult = "�ļ����ݳɹ���";
            
        } catch(Exception e) {
            e.printStackTrace();
            returnResult = e.getMessage();
        }
        return returnResult;
    }

    /**
     * ���㱣���ڼ�
     * @param past ��������
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
	 * Ϊ�ַ�������0��
	 * @param str ��Ҫ��ʽ�����ַ���
	 * @return ��ʽ������ַ���
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
     * ����ļ����ڷ���Ҫ����ļ����������ļ�
     * @param copyFile ��Ҫ�����ļ�·��
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
	 * �����ļ�
	 * @param oldPath ԭʼ�ļ�
	 * @param newPath �����ɵ��ļ�
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
     * �ж��ļ��Ƿ���Ҫ����
     * @param strFileName ��Ҫ�жϵ��ļ�����
     * @return true ��Ҫ���ƣ� false ����Ҫ����
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
     * �ж��ļ������Ƿ�������ڸ�ʽ
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
