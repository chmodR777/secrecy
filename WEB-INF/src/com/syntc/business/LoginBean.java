package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class LoginBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public LoginBean() {
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
		ResultObj res = new ResultObj();

		try {
			// 查询Buffer
			StringBuffer sb_SQL = new StringBuffer("");

			// 登录状态
			int i_AccessRtn = CommonConstants.CLDEF_LOGIN_NG;

			// 迁移画面
			String str_URL = "";

			// 用户名，密码
			String str_UserCode = StringUtil.convertNull(request.getParameter("txtUserCode"));
			String str_Password = StringUtil.convertNull(request.getParameter("txtUserPwd"));

			// 为了数据库正常执行 SQL，替换单引号
			String str_UserCodeDB = StringUtil.replace(str_UserCode, "'", "''");

			// 检验用户是否为本系统用户
			sb_SQL = new StringBuffer();
			sb_SQL.append(" select a.C_ID ");
			sb_SQL.append("   from t_user a "); 
			sb_SQL.append("  where a.C_CODE = '" + str_UserCodeDB + "' ");
			sb_SQL.append("    and a.C_PWD = '" + str_Password + "' "); 

			res = conn.Query(sb_SQL.toString());
			
			if (CommonConstants.CLDEF_DB_OK == res.getStatus() && res.size() == 2) {
				// 将UserBean存入session
				UserBean user = new UserBean();
				// 加载用户信息
				user.loadUserInfo(str_UserCode);
				request.getSession().setAttribute("UserBean", user);

				str_URL = "/frame.html";
			} else {
				str_URL = "/login.jsp?p_LoginState=" + i_AccessRtn;
			}
			
			parameters.setParameters("results", "ForwardPage", str_URL);

		} catch (Exception ex) {
			System.out.println("LoginBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}

}