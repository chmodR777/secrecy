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

public class MemTypeAddSaveBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public MemTypeAddSaveBean() {
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
            // 会员类别名称
            String strTYPE_NAME = StringUtil.getRequestData(request.getParameter("txtTYPE_NAME"));
            // 院方承担比例
            String strPERCENT = StringUtil.getRequestData(request.getParameter("txtPERCENT"));
            // 标准积分
            String strSCORE = StringUtil.getRequestData(request.getParameter("txtSCORE"));
            
            // 会员类别名称唯一
			boolean b_flag1 = chkUniqTypeName(strTYPE_NAME);
			// 标准积分唯一
			boolean b_flag2 = chkUniqScore(strSCORE);
			if (b_flag1 && b_flag2) {
	        	// 组合SQL语句，插入合同信息
	            sb_SQL.append("insert into t_memtype(C_TYPENAME");
	            sb_SQL.append("       ,C_PERCENT,C_SCORE)");
	            sb_SQL.append(" values(");
	            sb_SQL.append("       '"+strTYPE_NAME+"',");
	            sb_SQL.append("       "+strPERCENT+","+strSCORE);
	            sb_SQL.append(")");
	
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
			} else {
				if (!b_flag1) {
					// 提示信息
					String str_ErrMsg = "会员类别名称：" + strTYPE_NAME + "已存在，请重新录入！";
					// 设置到request中
					request.setAttribute("pop_Msg", str_ErrMsg);
					// 设置迁移画面
					String str_URL = "MemTypeAdd.do";
					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
				if (!b_flag2) {
					// 提示信息
					String str_ErrMsg = "标准积分：" + strSCORE + "已存在，请重新录入！";
					// 设置到request中
					request.setAttribute("pop_Msg", str_ErrMsg);
					// 设置迁移画面
					String str_URL = "MemTypeAdd.do";
					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
			}
        } catch (Exception ex) {
            System.out.println("MemTypeAddSaveBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
	/**
	 * 校验会员类别名称唯一性
	 * 
	 * @param strTypeName
	 * @return
	 */
	private boolean chkUniqTypeName(String strTypeName) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_memtype.C_ID ");
		sb.append("FROM t_memtype ");
		sb.append("WHERE t_memtype.C_TYPENAME = '" + strTypeName + "' ");

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
	 * @param strScore
	 * @return
	 */
	private boolean chkUniqScore(String strScore) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_memtype.C_ID ");
		sb.append("FROM t_memtype ");
		sb.append("WHERE t_memtype.C_SCORE = " + strScore + " ");

		res1 = conn.Query(sb.toString());
		// 存在一条记录，与当前挂号编号相同
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// 返回
		return b_flag;
	}
}