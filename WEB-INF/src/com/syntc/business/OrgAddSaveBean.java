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

public class OrgAddSaveBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public OrgAddSaveBean() {
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
            // 组织名称
            String strORG_NAME = StringUtil.getRequestData(request.getParameter("txtORG_NAME"));
            
            // 组织名称唯一
			boolean b_flag1 = chkUniqOrgName(strORG_NAME);
			if (b_flag1) {
	        	// 组合SQL语句，插入合同信息
	            sb_SQL.append("insert into t_org(C_NAME) values(").append("'" + strORG_NAME + "')");
	
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
			} else {
				// 提示信息
				String str_ErrMsg = "组织名称：" + strORG_NAME + "已存在，请重新录入！";
				// 设置到request中
				request.setAttribute("pop_Msg", str_ErrMsg);
				// 设置迁移画面
				String str_URL = "OrgAdd.do";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
        } catch (Exception ex) {
            System.out.println("OrgAddSaveBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
	/**
	 * 校验织名称唯一性
	 * 
	 * @param strOrgName
	 * @return
	 */
	private boolean chkUniqOrgName(String strOrgName) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_org.C_ID ");
		sb.append("FROM t_org ");
		sb.append("WHERE t_org.C_NAME = '" + strOrgName + "' ");

		res1 = conn.Query(sb.toString());
		//
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// 返回
		return b_flag;
	}
}