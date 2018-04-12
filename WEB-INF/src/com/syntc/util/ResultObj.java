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
 * CLASS      ： ResultObj
 * DESC       :  数据库查询结果集
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */

package com.syntc.util;

/**
 * 用于方法执行结果的返回
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
         * 用户定义属性
         */
        public String userString1;

        /**
         * 用户定义属性
         */
        public String userString2;
        /**
         * 用户定义属性
         */

        /**
         */
        public int userInt1;

        /**
         * 用户定义属性
         */
        public long userlong1;
        public ResultObj() {
            this.Cols   = 0;
            this.Rows   = 0;
            this.status = -1;
        }



        /**
             * 取得元素的值
             *
             * @param col 结果集字段顺序号
             * @param row 结果集中的行号
             * @return 元素值
             */
        public String getCell(int col, int row) {
                String[] s = (String[]) get(row);
                return s[col];
        }


        /**
         * 取得元素的值
         *
         * @param colName 结果集字段名称
         * @param Row 结果集行号
         * @return 元素值
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
         * 结果集中行数（包括字段名称）
         *
         * @return 行数
         */
        public int getRows() {
                return this.Rows;
        }
        /**
         * 取得结果集中的字段数
         *
         * @return 字段数
         */

        /**
         * 结果集中的字段数
         *
         * @return 字段数
         */
        public int getCols() {
                return this.Cols;
        }
        /**
         * 设定结果集中的行数
         *
         * @param row 行数
         */
        /**
         * 设定结果集中的行数
         *
         * @param row 行数
         */

        public void setRows(int row) {
                this.Rows = row;
        }

        /**
         * 设定结果集中的字段数
         *
         * @param col 字段数
         */
        public void setCols(int col) {
                this.Cols = col;
        }
        /**
         * 设定方法执行状态
         *
         * @param stat 状态值
         *   0：成功
         * －1：失败
         *  **：自定义
         */

        /**
         * 设定方法执行状态
         *
         * @param stat 状态值
         *   0：成功
         * －1：失败
         *  **：自定义
         */
        public void setStatus(int stat) {
                this.status = stat;
        }
        /**
         * 取得方法执行状态
         *
         * @return   0：成功
         * －1：失败
         *  **：自定义
         */

        /**
         * 取得方法执行状态
         *
         * @return 状态值
         */
        public int getStatus() {
                return (this.status);
        }

        /**
         * 设定方法执行错误信息
         *
         * @param em 错误信息
         */
        public void setErrMessage(String em) {
                this.errorMessage = em;
        }

        /**
         * 取得方法执行错误信息
         *
         * @return 错误信息
         */
        public String getErrMessage() {
                return (this.errorMessage);
        }

        /**
         * 设定SQL错误代码
         *
         * @param ec SQL错误代码
         */
        public void setErrCode(int ec) {
                this.errorCode = ec;
        }

        /**
         * 取得SQL错误代码
         *
         * @return 错误代码
         */
        public int getErrCode() {
                return (this.errorCode);
        }



        /**
         * 设置用户属性
         *
         * @param us1
         */
        public void setUserString1(String us1 ) {
                this.userString1 = us1;
        }

        /**
         * 取得用户属性
         */
        public String getUserString1() {
                return (this.userString1);
        }

        /**
         * 设置用户属性
         * @param us2
         */
        public void setUserString2(String us2 ) {
                this.userString2 = us2;
        }

        /**
         * 取得用户属性
         */
        public String getUserString2() {
                return (this.userString2);
        }

        /**
         * 取得用户属性
         */
        public int getUserInt() {
                return (this.userInt1);
        }

        /**
         * 设置用户属性
         *
         * @param ui1
         */
        public void setUserInt(int ui1 ) {
                this.userInt1 = ui1;
        }
        /**
         * 取得用户属性
         */

        public long getUserLong() {
                return (this.userlong1);
        }

        /**
         * 设置用户属性
         *
         * @param ul
         */
        public void setUserLong(long ul ) {
                this.userlong1 = ul;
        }


}