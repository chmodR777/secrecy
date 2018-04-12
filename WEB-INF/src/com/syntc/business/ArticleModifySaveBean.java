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

public class ArticleModifySaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public ArticleModifySaveBean() {
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

			// SQL ���
			StringBuffer sbSql = new StringBuffer();
			// �������
	        String strArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
			String strID = StringUtil.getRequestData(request.getParameter("article_id"));
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
			
			sbSql.append("UPDATE t_article SET ");
			sbSql.append("C_TITLE = '" + strTitle + "', ");
			sbSql.append("C_TYPE = '" + strType + "', ");
			sbSql.append("C_CONTENT = '" + strContent + "', ");
			if (strOperator.length() == 0) {
				sbSql.append("C_OPERATOR = NULL, ");
			} else {
				sbSql.append("C_OPERATOR = " + strOperator + ", ");
			}
			if (strOperTime.length() == 0) {
				sbSql.append("C_OPERTIME = NULL ");
			} else {
				sbSql.append("C_OPERTIME = '" + strOperTime + "' ");
			}
			sbSql.append("WHERE C_ID = " + strID);

			// �������ݿ����
			int iRtn = conn.doTransaction(sbSql.toString());
			// �жϲ�ѯ����Ƿ�ִ�гɹ�.
			if (iRtn == CommonConstants.CLDEF_DB_OK) {
				// Ǩ���б���
				String strURL = "ArticleManage.do?article_type=" + strArticleType;
				parameters.setParameters("results", "ForwardPage", strURL);
			} else {
				// Ǩ��ERROR����
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleModifySaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
