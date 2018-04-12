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
 * CLASS      �� ResultObj
 * DESC       :  ���ݿ��ѯ�����
 * VERSION    �� 0.00
 * DATE       �� 2006/07/05
 * AUTHOR     �� jinghuizhen@hotmail.com
 * HISTORY    �� 2006/07/05 0.00 ����
 */

package com.syntc.util;

/**
 * ���ڷ���ִ�н���ķ���
 * @version 1.0.1
 * @since 2000/12/12
 */
public class ResultObj extends java.util.ArrayList {
        public int Rows, Cols;
        private int index;
        public int status ;
        public String errorMessage = null;
        public int errorCode ;


        /**
         * �û���������
         */
        public String userString1;

        /**
         * �û���������
         */
        public String userString2;
        /**
         * �û���������
         */

        /**
         */
        public int userInt1;

        /**
         * �û���������
         */
        public long userlong1;
        public ResultObj() {
            this.Cols   = 0;
            this.Rows   = 0;
            this.status = -1;
        }



        /**
             * ȡ��Ԫ�ص�ֵ
             *
             * @param col ������ֶ�˳���
             * @param row ������е��к�
             * @return Ԫ��ֵ
             */
        public String getCell(int col, int row) {
                String[] s = (String[]) get(row);
                return s[col];
        }


        /**
         * ȡ��Ԫ�ص�ֵ
         *
         * @param colName ������ֶ�����
         * @param Row ������к�
         * @return Ԫ��ֵ
         */
        public String getCell(String colName, int Row) {
            boolean searchFlag = false;

                for (int i = 0; i < Cols; i++) {
                        String[] s = (String[])get(0);
                     //   System.out.println(s[i]);
                        if (colName.equalsIgnoreCase(s[i].trim())) {
                                index = i;
                                searchFlag = true;
                                break;
                        }
                }
                String[] r = (String[]) get(Row);
                if(searchFlag)
                    return r[index];
                else
                    return null ;

        }



        /**
         * ������������������ֶ����ƣ�
         *
         * @return ����
         */
        public int getRows() {
                return this.Rows;
        }
        /**
         * ȡ�ý�����е��ֶ���
         *
         * @return �ֶ���
         */

        /**
         * ������е��ֶ���
         *
         * @return �ֶ���
         */
        public int getCols() {
                return this.Cols;
        }
        /**
         * �趨������е�����
         *
         * @param row ����
         */
        /**
         * �趨������е�����
         *
         * @param row ����
         */

        public void setRows(int row) {
                this.Rows = row;
        }

        /**
         * �趨������е��ֶ���
         *
         * @param col �ֶ���
         */
        public void setCols(int col) {
                this.Cols = col;
        }
        /**
         * �趨����ִ��״̬
         *
         * @param stat ״ֵ̬
         *   0���ɹ�
         * ��1��ʧ��
         *  **���Զ���
         */

        /**
         * �趨����ִ��״̬
         *
         * @param stat ״ֵ̬
         *   0���ɹ�
         * ��1��ʧ��
         *  **���Զ���
         */
        public void setStatus(int stat) {
                this.status = stat;
        }
        /**
         * ȡ�÷���ִ��״̬
         *
         * @return   0���ɹ�
         * ��1��ʧ��
         *  **���Զ���
         */

        /**
         * ȡ�÷���ִ��״̬
         *
         * @return ״ֵ̬
         */
        public int getStatus() {
                return (this.status);
        }

        /**
         * �趨����ִ�д�����Ϣ
         *
         * @param em ������Ϣ
         */
        public void setErrMessage(String em) {
                this.errorMessage = em;
        }

        /**
         * ȡ�÷���ִ�д�����Ϣ
         *
         * @return ������Ϣ
         */
        public String getErrMessage() {
                return (this.errorMessage);
        }

        /**
         * �趨SQL�������
         *
         * @param ec SQL�������
         */
        public void setErrCode(int ec) {
                this.errorCode = ec;
        }

        /**
         * ȡ��SQL�������
         *
         * @return �������
         */
        public int getErrCode() {
                return (this.errorCode);
        }



        /**
         * �����û�����
         *
         * @param us1
         */
        public void setUserString1(String us1 ) {
                this.userString1 = us1;
        }

        /**
         * ȡ���û�����
         */
        public String getUserString1() {
                return (this.userString1);
        }

        /**
         * �����û�����
         * @param us2
         */
        public void setUserString2(String us2 ) {
                this.userString2 = us2;
        }

        /**
         * ȡ���û�����
         */
        public String getUserString2() {
                return (this.userString2);
        }

        /**
         * ȡ���û�����
         */
        public int getUserInt() {
                return (this.userInt1);
        }

        /**
         * �����û�����
         *
         * @param ui1
         */
        public void setUserInt(int ui1 ) {
                this.userInt1 = ui1;
        }
        /**
         * ȡ���û�����
         */

        public long getUserLong() {
                return (this.userlong1);
        }

        /**
         * �����û�����
         *
         * @param ul
         */
        public void setUserLong(long ul ) {
                this.userlong1 = ul;
        }


}