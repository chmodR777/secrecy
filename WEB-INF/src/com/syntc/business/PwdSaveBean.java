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
 * CLASS      ： PwdSaveBean
 * VERSION    ： 0.1
 * DESC       :  密码变更保存
 * DATE       ： 2007/03/24
 * AUTHOR     ： rr
 * HISTORY    ： 2007/03/24 0.1 作成
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class PwdSaveBean extends BusinessLogic{
      /**
       * 构造函数
       */
      public PwdSaveBean(){
         if(CommonConstants.CLDEF_DEBUG){
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
         }
      }

      /**
       * 业务逻辑处理机能
       */
      public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{

        // 数据库操作对象
        DBOperate conn = new DBOperate();

        try{
            // 用户信息
            UserBean user = (UserBean) request.getSession().getAttribute("UserBean");
            //UserBean中用户id
            String strUserID = user.getId();
            //UserBean中的密码
            String strUserPwd = user.getPwd();

            //迁移画面地址
            String strURL = null;

            //SQL 语句
            StringBuffer sbSql = new StringBuffer();

            //旧密码
            String strPwdOld = StringUtil.getRequestData(request.getParameter("pwd_old"));
            //新密码
            String strPwdNew = StringUtil.getRequestData(request.getParameter("pwd"));

            if (strPwdOld.equals(strUserPwd)) {
            
                sbSql.append("UPDATE t_user a SET ");
                sbSql.append("       a.C_PWD = '" + strPwdNew + "'");
                sbSql.append(" WHERE a.C_ID = " + strUserID);

                //进行数据库更新
                int iRtn = conn.doTransaction(sbSql.toString());

                //判断查询语句是否执行成功.
                if (iRtn  == CommonConstants.CLDEF_DB_OK) {
                    //更新UserBean中的密码
                	user.setPwd(strPwdNew);
                    //迁移列表画面
                    strURL = "/app/home/home.jsp";

                    parameters.setParameters("results", "ForwardPage", strURL);
                } else {
                    //迁移ERROR画面
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            } else {
                //迁移列表画面
                strURL = "PwdUpt.do?ifBug=1";

                parameters.setParameters("results", "ForwardPage", strURL);
                return;
            }
        }
        catch(Exception ex){
            System.out.println("PwdSaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * 页面表单检测处理机能
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


      }
}
