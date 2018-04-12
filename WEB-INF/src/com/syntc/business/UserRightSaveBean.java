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
 * CLASS      ： UserRightSaveBean
 * VERSION    ： 0.1
 * DESC       :  用户权限变更保存
 * DATE       ： 2010-09-03
 * AUTHOR     ： zhangqiang
 * HISTORY    ： 2010-09-03 0.1 作成
 */
package com.syntc.business;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class UserRightSaveBean extends BusinessLogic{
      /**
       * 构造函数
       */
      public UserRightSaveBean(){
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
        
        Vector<String> v_sql = new Vector<String>();

        try{
        	//取得用户id
        	String strUserID = StringUtil.getRequestData(request.getParameter("txtUSER_ID"));
        	//取得更新后的权限
        	String[] strRight = (String[])request.getParameterValues("menuid");
        	
            //SQL 语句
            StringBuffer sbSql = new StringBuffer();
            //删除原有权限
            sbSql = new StringBuffer();
        	sbSql.append("delete from t_right");
        	sbSql.append(" where C_USERID = " + strUserID);
        	v_sql.add(sbSql.toString());

            if(strRight != null && strRight.length >= 1){
            	for(int i = 0; i < strRight.length; i++){
            		//将新权限插入到数据库
                	sbSql = new StringBuffer();
                	sbSql.append("insert into t_right ");
                	sbSql.append(" (C_USERID,C_MENUID) ");
                	sbSql.append(" values("+strUserID+","+strRight[i]+")");
                	v_sql.add(sbSql.toString());
                }
            }

	        //进行数据库更新
	        int iRtn = conn.doTransaction(v_sql);
	
	        //判断查询语句是否执行成功.
	        if (iRtn  == CommonConstants.CLDEF_DB_OK) {
	            //迁移列表画面
	            String strURL = "UserRight.do";
	
	            parameters.setParameters("results", "ForwardPage", strURL);
	        } else {
	            //迁移ERROR画面
	            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
	
	        }
 
        }
        catch(Exception ex){
            System.out.println("UserRightSaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * 页面表单检测处理机能
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


      }
}
