package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class ArticleAddSaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public ArticleAddSaveBean() {
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
		Common common = new Common();
		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			// �������
            String strArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
			// ����
			String strTitle = StringUtil.getRequestData(request.getParameter("strTitle"));
			// ���
			String strType = StringUtil.getRequestData(request.getParameter("strType"));
			// ����
			String strContent = StringUtil.getRequestData(request.getParameter("strContent"));
			// ������ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			// ����ʱ��
			String strOperTime = common.getServerDate_MySQL();
			// ���SQL���
			sb_SQL = new StringBuffer();
			sb_SQL.append("INSERT INTO t_article(");
			sb_SQL.append("C_TITLE, C_TYPE, C_CONTENT, ");
			sb_SQL.append("C_OPERATOR, C_OPERTIME) ");
			sb_SQL.append("VALUES('");
			sb_SQL.append(strTitle + "', ");
			sb_SQL.append("'" + strType + "', ");
			sb_SQL.append("'" + strContent + "', ");
			if (strOperator.length() == 0) {
				sb_SQL.append("NULL, ");
			} else {
				sb_SQL.append(strOperator + ", ");
			}
			if (strOperTime.length() == 0) {
				sb_SQL.append("NULL) ");
			} else {
				sb_SQL.append("'" + strOperTime + "') ");
			}
			// �������ݿ����
			int i_Rtn = conn.doTransaction(sb_SQL.toString());
			// �жϲ�ѯ����Ƿ�ִ�гɹ�.
			if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
				// ����Ǩ�ƻ���
				String str_URL = "ArticleManage.do?article_type=" + strArticleType;
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("ArticleAddSaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}