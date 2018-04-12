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
 * CLASS      �� FileTrans
 * VERSION    �� 0.1
 * DESC       : �ļ�����
 * DATE       �� 2007/04/18
 * AUTHOR     �� rr
 * HISTORY    �� 2007/04/18 0.00 ����
 */
package com.syntc.common.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import com.syntc.constants.CommonConstants;


public class FileTrans extends TimerTask {
   	private static final String COPY_HOUR = CommonConstants.BACKUP_HOUR;
    private Timer timer;
    private boolean canDoCopyDaily;
    public FileTrans() {
        timer = new Timer(true);
        canDoCopyDaily = true;
    }

    /**
     * Runs the task, which sends all email messages that have been queued.
     */
    public void run() {
        Calendar calendar = new GregorianCalendar();
        String str_ServerDateTime =new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
        String str_Date = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        String str_Hour = new SimpleDateFormat("HH").format(calendar.getTime());
        int int_Day  = calendar.get(Calendar.DAY_OF_WEEK);
        
        System.out.println("����ʱ���飺str_ServerDateTime = " + str_ServerDateTime
                + " str_Date = " + str_Date + " str_Time = " + str_Hour 
                + " canDoCopyDaily =" + canDoCopyDaily);
        
        //���Ա��ݣ�ʱ��Ϊ����ָ��ʱ�䣬����Ϊ�ܶ���������
        if ( canDoCopyDaily && str_Hour.equals(COPY_HOUR) && (int_Day==Calendar.TUESDAY ||int_Day==Calendar.THURSDAY )) {
        //if ( canDoCopyDaily && str_Hour.equals(COPY_HOUR) && int_Day==Calendar.WEDNESDAY) {
            System.out.println("ִ�� �ļ�����...");
            //ʵ�б���
            this.doCopyFiles();
            //ʵ�б��ݺ󣬽����ݱ���趨Ϊfalse
            canDoCopyDaily = false;
        }

        //��Ϊ�ܶ��������ģ��������ݼ���
        //if( str_Hour.equals(COPY_HOUR) ){
        if( int_Day != Calendar.TUESDAY && int_Day != Calendar.THURSDAY ){
            canDoCopyDaily = true;  
        }

    
    }

    public void destroyTask() {
        System.out.println(new Date() + "���ٱ�������!");
        timer.cancel();
    }

    public void addTask() {

        System.out.println("������������!");
        timer.schedule(this, 30000, 3600000);

    }

    private int doCopyFiles() {

        int iRnt = 0;
		
        String strStartTime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS").format(new Date());
        
        long beginTimeMillis = System.currentTimeMillis();
		
        System.out.println("start app at : " + strStartTime);

        System.out.println(new FileBackUp().execute());

		String strEndTime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS").format(new Date());
        
        long endTimeMillis = System.currentTimeMillis();
		
        System.out.println("end app at : " + strEndTime);
        
        System.out.println("�����ʱ��:" + (endTimeMillis - beginTimeMillis) + "MSEL");

        return iRnt;

    }


}
