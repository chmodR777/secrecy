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
	 * ���캯��
	 */
	public LoginBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}                                                                                                              

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// ���ݿ��������
		DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();

		try {
			// ��ѯBuffer
			StringBuffer sb_SQL = new StringBuffer("");

			// ��¼״̬
			int i_AccessRtn = CommonConstants.CLDEF_LOGIN_NG;

			// Ǩ�ƻ���
			String str_URL = "";

			// �û���������
			String str_UserCode = StringUtil.convertNull(request.getParameter("txtUserCode"));
			String str_Password = StringUtil.convertNull(request.getParameter("txtUserPwd"));

			// Ϊ�����ݿ�����ִ�� SQL���滻������
			String str_UserCodeDB = StringUtil.replace(str_UserCode, "'", "''");

			// �����û��Ƿ�Ϊ��ϵͳ�û�
			sb_SQL = new StringBuffer();
			sb_SQL.append(" select a.C_ID ");
			sb_SQL.append("   from t_user a "); 
			sb_SQL.append("  where a.C_CODE = '" + str_UserCodeDB + "' ");
			sb_SQL.append("    and a.C_PWD = '" + str_Password + "' "); 

			res = conn.Query(sb_SQL.toString());
			
			if (CommonConstants.CLDEF_DB_OK == res.getStatus() && res.size() == 2) {
				// ��UserBean����session
				UserBean user = new UserBean();
				// �����û���Ϣ
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
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}

}