//////////////////////////////////////////////////////////////
//
// COPYRIGHT (C) 2010 zq CORPORATION
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
 * CLASS      ： UserModifySaveBean
 * VERSION    ： 0.1
 * DESC       :  用户信息修改保存
 * DATE       ： 2010-08-26
 * AUTHOR     ：zhangqiang
 * HISTORY    ： 2010-08-26 作成
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class UserModifySaveBean extends BusinessLogic{
      /**
       * 构造函数
       */
      public UserModifySaveBean(){
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

            //SQL 语句
            StringBuffer sbSql = new StringBuffer();
            
            //用户id
            String strUSER_ID = StringUtil.getRequestData(request.getParameter("txtUSER_ID"));
            // 用户账号
            String strUSER_CODE = StringUtil.getRequestData(request.getParameter("txtUSER_CODE"));
            // 用户姓名
            String strUSER_NAME = StringUtil.getRequestData(request.getParameter("txtUSER_NAME"));
            // 性别
            String strSEX = StringUtil.getRequestData(request.getParameter("txtSEX"));
            // 联系电话
            String strTEL = StringUtil.getRequestData(request.getParameter("txtTEL"));
            // 所在组织
            String strORG = StringUtil.getRequestData(request.getParameter("txtORG"));
            // 是否管理员
            String strROLETYPE = StringUtil.getRequestData(request.getParameter("txtRoleType"));
            // 备注
            String strREMARK = StringUtil.getRequestData(request.getParameter("txtREMARK")).replaceAll("\r", "<br>");
            //校验账号唯一
            boolean b_flag = chkUniqUserCode(strUSER_ID,strUSER_CODE);
            //账号唯一
            if(b_flag){
            	sbSql.append("update t_user set ");
                sbSql.append("       C_NAME = '" + strUSER_NAME + "',");
                sbSql.append("       C_CODE = '" + strUSER_CODE + "',");
                sbSql.append("       C_SEX = '" + strSEX + "',");
                sbSql.append("       C_TEL = '" + strTEL + "',");
                sbSql.append("       C_DEP = '',");
                sbSql.append("       C_ROLETYPE = '" + strROLETYPE + "',");
                sbSql.append("       C_REMARK = '" + strREMARK + "',");
                if (strORG.length() == 0) {
                	strORG = "-1";
                }
                sbSql.append("       C_ORG_ID = " + strORG);
                sbSql.append(" where C_ID = " + strUSER_ID );
                    

                //进行数据库更新
                int iRtn = conn.doTransaction(sbSql.toString());

                //判断查询语句是否执行成功.
                if (iRtn  == CommonConstants.CLDEF_DB_OK) {
                    //迁移列表画面
                    String strURL = "UserManage.do";

                    parameters.setParameters("results", "ForwardPage", strURL);
                } else {
                    //迁移ERROR画面
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }else{
            	//提示信息
            	String str_ErrMsg = "用户名："+strUSER_CODE+"已存在，请重新录入！";
            	//设置到request中
                request.setAttribute("pop_Msg",str_ErrMsg);
                // 设置迁移画面
                String str_URL = "UserModify.do?user_id="+strUSER_ID;
                // 画面迁移
                parameters.setParameters("results", "ForwardPage", str_URL);
            }
        }
        catch(Exception ex){
            System.out.println("UserModifySaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * 页面表单检测处理机能
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
      }
      
      /**
       * 校验用户账号唯一性
       * @param strUserCode
       * @return
       */
      private boolean chkUniqUserCode(String strUSER_ID,String strUSER_CODE){
      	boolean b_flag = true;
      	DBOperate conn = new DBOperate();
      	ResultObj res1 = new ResultObj();
      	StringBuffer sb = new StringBuffer();
      	sb.append("select a.C_ID,");
      	sb.append("       a.C_NAME,a.C_CODE,");
      	sb.append("       a.C_SEX,a.C_TEL,");
      	sb.append("       a.C_DEP,a.C_REMARK ");
      	sb.append("  from t_user a ");
      	sb.append(" where a.C_ID <> "+strUSER_ID);
      	sb.append("   and a.C_CODE = '"+strUSER_CODE+"'");
      		
      	res1 = conn.Query(sb.toString());
      	//存在一条记录，与当前账号相同
      	if(CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size()>=2){
      		b_flag = false;
      	}
      	//返回
      	return b_flag;
      }
}
