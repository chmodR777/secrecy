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
 * CLASS      ： MemTypeModifySaveBean
 * VERSION    ： 0.1
 * DESC       :  会员类别修改保存
 * DATE       ： 2010-09-11
 * AUTHOR     ：zhangqiang
 * HISTORY    ： 2010-09-11 作成
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

public class MemTypeModifySaveBean extends BusinessLogic{
      /**
       * 构造函数
       */
      public MemTypeModifySaveBean(){
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
            
            //类别id
            String strTYPE_ID = StringUtil.getRequestData(request.getParameter("txtTYPE_ID"));
            // 类别名称
            String strTYPE_NAME = StringUtil.getRequestData(request.getParameter("txtTYPE_NAME"));
            // 院方承担比例
            String strPERCENT = StringUtil.getRequestData(request.getParameter("txtPERCENT"));
            // 标准积分
            String strSCORE = StringUtil.getRequestData(request.getParameter("txtSCORE"));
            
            // 会员类别名称唯一
			boolean b_flag1 = chkUniqTypeName(strTYPE_ID, strTYPE_NAME);
			// 标准积分唯一
			boolean b_flag2 = chkUniqScore(strTYPE_ID, strSCORE);
			if (b_flag1 && b_flag2) {
	        	sbSql.append("update t_memtype set ");
	            sbSql.append("       C_TYPENAME = '" + strTYPE_NAME + "',");
	            sbSql.append("       C_PERCENT = " + strPERCENT + ",");
	            sbSql.append("       C_SCORE = " + strSCORE );
	            sbSql.append(" where C_ID = " + strTYPE_ID );
	                
	
	            //进行数据库更新
	            int iRtn = conn.doTransaction(sbSql.toString());
	
	            //判断查询语句是否执行成功.
	            if (iRtn  == CommonConstants.CLDEF_DB_OK) {
	                //迁移列表画面
	                String strURL = "MemTypeManage.do";
	
	                parameters.setParameters("results", "ForwardPage", strURL);
	            } else {
	                //迁移ERROR画面
	                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
	
	            }
			} else {
				if (!b_flag1) {
					// 提示信息
					String str_ErrMsg = "会员类别名称：" + strTYPE_NAME + "已存在，请重新录入！";
					// 设置到request中
					request.setAttribute("pop_Msg", str_ErrMsg);
					// 设置迁移画面
					String str_URL = "MemTypeModify.do?type_id=" + strTYPE_ID;
					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
				if (!b_flag2) {
					// 提示信息
					String str_ErrMsg = "标准积分：" + strSCORE + "已存在，请重新录入！";
					// 设置到request中
					request.setAttribute("pop_Msg", str_ErrMsg);
					// 设置迁移画面
					String str_URL = "MemTypeModify.do?type_id=" + strTYPE_ID;
					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
			}
        }
        catch(Exception ex){
            System.out.println("MemTypeModifySaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * 页面表单检测处理机能
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
      }
      
    /**
  	 * 校验会员类别名称唯一性
  	 * 
  	 * @param strID
  	 * @param strTypeName
  	 * @return
  	 */
  	private boolean chkUniqTypeName(String strID, String strTypeName) {
  		boolean b_flag = true;
  		DBOperate conn = new DBOperate();
  		ResultObj res1 = new ResultObj();
  		StringBuffer sb = new StringBuffer();
  		sb.append("SELECT t_memtype.C_ID ");
  		sb.append("FROM t_memtype ");
  		sb.append("WHERE t_memtype.C_TYPENAME = '" + strTypeName + "' ");
  		sb.append("AND t_memtype.C_ID <> " + strID + " ");

  		res1 = conn.Query(sb.toString());
  		// 存在一条记录，与当前挂号编号相同
  		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
  			b_flag = false;
  		}
  		// 返回
  		return b_flag;
  	}
  	
  	/**
  	 * 校验标准积分唯一性
  	 * 
  	 * @param strID
  	 * @param strScore
  	 * @return
  	 */
  	private boolean chkUniqScore(String strID, String strScore) {
  		boolean b_flag = true;
  		DBOperate conn = new DBOperate();
  		ResultObj res1 = new ResultObj();
  		StringBuffer sb = new StringBuffer();
  		sb.append("SELECT t_memtype.C_ID ");
  		sb.append("FROM t_memtype ");
  		sb.append("WHERE t_memtype.C_SCORE = " + strScore + " ");
  		sb.append("AND t_memtype.C_ID <> " + strID + " ");

  		res1 = conn.Query(sb.toString());
  		// 存在一条记录，与当前挂号编号相同
  		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
  			b_flag = false;
  		}
  		// 返回
  		return b_flag;
  	}
}
