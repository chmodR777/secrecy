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
import com.syntc.util.ResultObj;
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class ArticleStatusManageBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public ArticleStatusManageBean() {
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
		RowSet rs = new RowSet();
		// ���ݿ����Ӷ���
		DBOperate conn = new DBOperate();

		// ��ǰҳ��
		int i_CurPage = 1;
		// ÿҳ��¼��
		int i_PageSize = 10;

		try {
			// ÿҳ��¼��
			String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String.valueOf(CommonConstants.CLEDF_MAX_PAGE));
			i_PageSize = Integer.parseInt(str_PageSize);
			// ȡ�õ�ǰҳ��
			String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
			i_CurPage = Integer.parseInt(str_CurPage);

			// ��ѯ����-����
			String p_Title = StringUtil.getRequestData(request.getParameter("txtTitle"), "");
			// ��ѯ����-״̬
			String p_Status = StringUtil.getRequestData(request.getParameter("txtStatus"), "");
			// �������
            String strARTICLE_TYPE = StringUtil.getRequestData(request.getParameter("article_type"));
            // ������ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			
			// ���sql���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * from (");
			sb_SQL.append("SELECT a.C_ID, a.C_TITLE, u.C_CODE, a.C_OPERTIME, o.C_NAME ");
			sb_SQL.append("FROM t_article a, t_optionitem o, t_user u ");
			sb_SQL.append("WHERE a.C_STATUS = o.C_ID ");
			sb_SQL.append("AND o.C_TYPE = 'articleStatus' ");
			sb_SQL.append("AND a.C_OPERATOR = u.C_ID ");
			if (strOperator.length() != 0) {
				sb_SQL.append("AND u.C_ID = ").append(strOperator).append(" ");
			}
			sb_SQL.append("AND (a.C_STATUS = '93' OR a.C_STATUS = '94') ");
			sb_SQL.append("AND a.C_TYPE = ").append(strARTICLE_TYPE).append(" ");
			sb_SQL.append("UNION ALL ");
			sb_SQL.append("SELECT a.C_ID, a.C_TITLE, u.C_CODE, a.C_OPERTIME, o.C_NAME ");
			sb_SQL.append("FROM t_article a, t_optionitem o, t_user u ");
			sb_SQL.append("WHERE a.C_STATUS = o.C_ID ");
			sb_SQL.append("AND o.C_TYPE = 'articleStatus' ");
			sb_SQL.append("AND a.C_OPERATOR = u.C_ID ");
			sb_SQL.append("AND a.C_STATUS = '95' ");
			sb_SQL.append("AND a.C_TYPE = ").append(strARTICLE_TYPE).append(") t ");
			
			if (!"".equals(p_Title)) {
				sb_SQL.append("AND C_TITLE like '%" + p_Title + "%' ");
			}
			if (!"".equals(p_Status)) {
				sb_SQL.append("AND a.C_STATUS = '" + p_Status + "' ");
			}
			System.out.println("************************************************");
			System.out.println(sb_SQL.toString());
			System.out.println("************************************************");

			// ����sql
			rs.setSql(sb_SQL.toString());
			// ����ÿҳ��¼����
			rs.setPageSize(i_PageSize);
			// ��ѯָ��ҳ��¼
			res = rs.goPage(i_CurPage);

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			// �Ƿ��ѯ�ɹ�
			// CLDEF_DB_OK 0��ȫ�������������������鵽��¼
			// CLDEF_DB_OK2 1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				// �����ܼ�¼��
				parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
				// ����ÿҳ��¼��
				parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
				// ���õ�ǰҳ���б��ҳ��ز�����
				parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));

				// ����������浽request��
				request.setAttribute("res", res);
				
				// ��ȡ����״̬�����б�
				String articleStatusOptionList = common.getArticleStatusOptionList(p_Status);
				request.setAttribute("articleStatusOptionList", articleStatusOptionList);

				// ����Ǩ���׻���
				String str_URL = "/app/system/article_status_manage.jsp";
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleStatusManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
