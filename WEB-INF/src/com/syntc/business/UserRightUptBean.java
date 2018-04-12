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
 * CLASS ： UserRightUptBean
 * VERSION ： 0.00
 * DESC : 用户权限编辑
 * DATE ： 2010-09-03
 * AUTHOR ： zhangqiang
 * HISTORY ： 2010-09-03 作成
 */
package com.syntc.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class UserRightUptBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public UserRightUptBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * 业务逻辑处理机能
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        // 结果集对象
        ResultObj res = new ResultObj();
        //用户权限对象
        ResultObj res_right = new ResultObj();
        // 数据库连接对象
        DBOperate conn = new DBOperate();

        try {
            // SQL存放对象
            StringBuffer sb_SQL = new StringBuffer();
            // 主键ID
            String strUSER_ID = StringUtil.getRequestData(request.getParameter("user_id"));

            // 组合SQL语句，查询用户信息
            sb_SQL.append("select a.C_ID,");
            sb_SQL.append("       a.C_NAME,a.C_CODE,");
            sb_SQL.append("       a.C_SEX,a.C_TEL,");
            sb_SQL.append("       o.C_NAME C_ORG,a.C_REMARK ");
            sb_SQL.append("  from t_user a left join t_org o on a.C_ORG_ID = o.C_ID ");
            sb_SQL.append(" WHERE a.C_ID = '" + strUSER_ID + "' ");

            // 执行查询
            res = conn.Query(sb_SQL.toString());
            
            StringBuffer sb_Right = new StringBuffer();
            sb_Right.append("SELECT a.C_MENUID ");
            sb_Right.append("  FROM t_right a ");
            sb_Right.append(" WHERE a.C_USERID = " + strUSER_ID);
            
            // 执行查询
            res_right = conn.Query(sb_Right.toString());

            if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && CommonConstants.CLDEF_DB_OK <= res_right.getStatus()) {
                // 将结果集保存到request中
                request.setAttribute("res", res);
                
                //存放用户权限id
                List<String> list = new ArrayList<String>();
                
                if(res_right.size()>1){
                	for(int i=1; i < res_right.size(); i++){
                		list.add(res_right.getCell("C_MENUID", i));
                	}
                }
                //权限结果集
                request.setAttribute("list", list);

                // 设置迁移画面
                String str_URL = "/app/system/user_right_upt.jsp";

                // 画面迁移
                parameters.setParameters("results", "ForwardPage", str_URL);
            } else {
                // 迁移到错误画面
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

            }

        } catch (Exception ex) {
            System.out.println("UserRightUptBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
}