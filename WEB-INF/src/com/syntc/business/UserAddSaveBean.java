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
 * CLASS ： UserAddSaveBean
 * VERSION ： 0.00
 * DESC : 用户新建
 * DATE ： 2010-08-26
 * AUTHOR ： zhangqiang
 * HISTORY ： 2010-08-26
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

public class UserAddSaveBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public UserAddSaveBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * 业务逻辑处理机能
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        // 数据库操作对象
        DBOperate conn = new DBOperate();

        try {
            // SQL存放对象
            StringBuffer sb_SQL = new StringBuffer();
            // 用户账号
            String strUSER_CODE = StringUtil.getRequestData(request.getParameter("txtUSER_CODE"));
            // 用户姓名
            String strUSER_NAME = StringUtil.getRequestData(request.getParameter("txtUSER_NAME"));
            // 性别
            String strSEX = StringUtil.getRequestData(request.getParameter("txtSEX"));
            // 联系电话
            String strTEL = StringUtil.getRequestData(request.getParameter("txtTEL"));
            // 所在部门
            String strDEP = "";
            // 所在组织
			String strORG = StringUtil.getRequestData(request.getParameter("txtORG"));
            // 是否管理员
            String strRoleType = StringUtil.getRequestData(request.getParameter("txtRoleType"));
            // 备注
            String strREMARK = StringUtil.getRequestData(request.getParameter("txtREMARK")).replaceAll("\r", "<br>");
            //用户账号唯一
            boolean b_flag = chkUniqUserCode(strUSER_CODE);
            //不存在重复账号
            if(b_flag){
            	// 组合SQL语句，插入合同信息
                sb_SQL.append("insert into t_user(");
                sb_SQL.append("       C_CODE,C_NAME,");
                sb_SQL.append("       C_PWD,C_ROLETYPE,");
                sb_SQL.append("       C_SEX,C_TEL,");
                sb_SQL.append("       C_DEP,C_REMARK,C_ORG_ID)");
                sb_SQL.append(" values(");
                sb_SQL.append("       '"+strUSER_CODE+"',");
                sb_SQL.append("       '"+strUSER_NAME+"',");
                sb_SQL.append("       '"+strUSER_CODE+"',");
                sb_SQL.append("       '"+strRoleType+"',");
                sb_SQL.append("       '"+strSEX+"',");
                sb_SQL.append("       '"+strTEL+"',");
                sb_SQL.append("       '"+strDEP+"',");
                sb_SQL.append("       '"+strREMARK+"',");
                if (strORG.length() == 0) {
                	strORG = "-1";
                }
                sb_SQL.append(strORG);
                sb_SQL.append(")");
                
                
                // 进行数据库更新
                int i_Rtn = conn.doTransaction(sb_SQL.toString());
                // 判断查询语句是否执行成功.
                if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
                	
                    // 设置迁移画面
                    String str_URL = "UserManage.do";

                    // 画面迁移
                    parameters.setParameters("results", "ForwardPage", str_URL);
                } else {

                    // 迁移到错误画面
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }else{
            	//提示信息
            	String str_ErrMsg = "用户名："+strUSER_CODE+"已存在，请重新录入！";
            	//设置到request中
                request.setAttribute("pop_Msg",str_ErrMsg);
                // 设置迁移画面
                String str_URL = "UserAdd.do";
                // 画面迁移
                parameters.setParameters("results", "ForwardPage", str_URL);
            }
        } catch (Exception ex) {
            System.out.println("ContractNewBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    /**
     * 校验用户账号唯一性
     * @param strUserCode
     * @return
     */
    private boolean chkUniqUserCode(String strUserCode){
    	boolean b_flag = true;
    	DBOperate conn = new DBOperate();
    	ResultObj res1 = new ResultObj();
    	StringBuffer sb = new StringBuffer();
    	sb.append("select a.C_ID,");
    	sb.append("       a.C_NAME,a.C_CODE,");
    	sb.append("       a.C_SEX,a.C_TEL,");
    	sb.append("       a.C_DEP,a.C_REMARK ");
    	sb.append("  from t_user a ");
    	sb.append(" where a.C_CODE = '"+strUserCode+"' ");
    		
    	res1 = conn.Query(sb.toString());
    	//存在一条记录，与当前账号相同
    	if(CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size()>1){
    		b_flag = false;
    	}
    	//返回
    	return b_flag;
    }
 
}