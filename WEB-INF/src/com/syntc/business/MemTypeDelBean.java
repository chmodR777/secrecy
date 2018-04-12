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
 * CLASS ： MemTypeDelBean
 * VERSION ： 0.00
 * DESC : 用户删除
 * DATE ： 2010-09-11
 * AUTHOR ： zhangqiang
 * HISTORY ： 2010-09-11 作成
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

public class MemTypeDelBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public MemTypeDelBean() {
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
            // 主键ID
            String strType_ID = StringUtil.getRequestData(request.getParameter("type_id"));
            //此会员类型是否被患者使用
            boolean bFlag = this.ifUsedByPatient(strType_ID);
            //被使用
            if(bFlag){
            	//不能被删除，直接返回
            	//提示信息
            	String str_ErrMsg = "您所删除的会员类别已经被使用，无法删除！";
            	//设置到request中
                request.setAttribute("pop_Msg",str_ErrMsg);
                // 设置迁移画面
                String str_URL = "MemTypeManage.do";
                // 画面迁移
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
            	// 组合SQL语句
                sb_SQL.append("DELETE FROM t_memtype ");
                sb_SQL.append(" WHERE C_ID = " + strType_ID );
                
                // 进行数据库更新
                int i_Rtn = conn.doTransaction(sb_SQL.toString());

                // 判断查询语句是否执行成功.
                if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
                    // 设置迁移画面
                    String str_URL = "MemTypeManage.do";

                    // 画面迁移
                    parameters.setParameters("results", "ForwardPage", str_URL);
                } else {
                    // 迁移到错误画面
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }

        } catch (Exception ex) {
            System.out.println("MemTypeDelBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    private boolean ifUsedByPatient(String typeId){
    	boolean bFlag = false;
    	
    	DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select a.C_ID,a.C_MEMTYPE ");
		sb_SQL.append("   from t_patient a ");
		sb_SQL.append("  where a.C_MEMTYPE = " + typeId);
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());

        if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
        	bFlag = true;
        }
    	
    	return bFlag;
    }
}