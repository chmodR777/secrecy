package com.syntc.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class ArticleViewBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public ArticleViewBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// ���������
		ResultObj res = new ResultObj();
		// ���ݿ����Ӷ���
		DBOperate conn = new DBOperate();
		
		String strID = StringUtil.getRequestData(request.getParameter("article_id"));

		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT a.C_ID, ");
			sb_SQL.append("a.C_TITLE, ");
			sb_SQL.append("a.C_CONTENT ");
			sb_SQL.append("FROM t_article a ");
			sb_SQL.append("WHERE a.C_ID = ").append(strID).append(" ");

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				// ����������浽request��
				request.setAttribute("res", res);
				
				Common common = new Common();
				Map optionItemMap = common.getOptionItemMap("articleType");
				request.setAttribute("optionItemMap", optionItemMap);

				// ����Ǩ�ƻ���
				String str_URL = "/app/system/article_view.jsp";
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleViewBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}