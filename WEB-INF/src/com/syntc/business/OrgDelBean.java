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

public class OrgDelBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public OrgDelBean() {
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
            String strORG_ID = StringUtil.getRequestData(request.getParameter("org_id"));
            //此组织是否被用户使用
            boolean bFlag = this.ifUsedByUser(strORG_ID);
            //被使用
            if(bFlag){
            	//不能被删除，直接返回
            	//提示信息
            	String str_ErrMsg = "您所删除的组织已经被使用，无法删除！";
            	//设置到request中
                request.setAttribute("pop_Msg",str_ErrMsg);
                // 设置迁移画面
                String str_URL = "OrgManage.do";
                // 画面迁移
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
            	// 组合SQL语句
                sb_SQL.append("DELETE FROM t_org ");
                sb_SQL.append(" WHERE C_ID = " + strORG_ID );
                
                // 进行数据库更新
                int i_Rtn = conn.doTransaction(sb_SQL.toString());

                // 判断查询语句是否执行成功.
                if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
                    // 设置迁移画面
                    String str_URL = "OrgManage.do";

                    // 画面迁移
                    parameters.setParameters("results", "ForwardPage", str_URL);
                } else {
                    // 迁移到错误画面
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }

        } catch (Exception ex) {
            System.out.println("OrgDelBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    private boolean ifUsedByUser(String orgId){
    	boolean bFlag = false;
    	
    	DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select a.C_ID,a.C_ORG_ID ");
		sb_SQL.append("   from t_user a ");
		sb_SQL.append("  where a.C_ORG_ID = " + orgId);
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());

        if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
        	bFlag = true;
        }
    	
    	return bFlag;
    }
}