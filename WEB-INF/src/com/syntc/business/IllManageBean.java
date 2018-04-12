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
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class IllManageBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public IllManageBean() {
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
		String p_PatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
		
		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_patient.C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME, ");
			sb_SQL.append("t_patient.C_SEX, ");
			sb_SQL.append("t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, ");
			sb_SQL.append("t_patient.C_MEMTYPE, ");
			sb_SQL.append("t_memtype.C_TYPENAME AS C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD AS C_IDCARD, ");
			sb_SQL.append("SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS TOTALSCORE ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("LEFT JOIN t_ill ");
			sb_SQL.append("ON t_patient.C_ID = t_ill.C_PATIENTID ");
			sb_SQL.append("LEFT JOIN t_memtype ");
			sb_SQL.append("ON t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("WHERE t_patient.C_ID = " + p_PatientID + " ");
			sb_SQL.append("GROUP BY t_patient.C_ID, ");
			sb_SQL.append("t_patient.C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME, ");
			sb_SQL.append("t_patient.C_SEX, ");
			sb_SQL.append("t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, ");
			sb_SQL.append("t_patient.C_MEMTYPE, ");
			sb_SQL.append("t_memtype.C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD ");
			

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				// ����������浽request��
				request.setAttribute("res_patient", res);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("IllManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

		try {
			// ÿҳ��¼��
			String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String.valueOf(CommonConstants.CLEDF_MAX_PAGE));
			i_PageSize = Integer.parseInt(str_PageSize);
			// ȡ�õ�ǰҳ��
			String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
			i_CurPage = Integer.parseInt(str_CurPage);
			
			// ��ѯ����-�Һű��
			String p_Code = StringUtil.getRequestData(request.getParameter("txtCode"), "");
			// ��ѯ����-�������
			String p_Type = StringUtil.getRequestData(request.getParameter("txtType"), "");
			// ��ѯ����-������
			String p_MoneyMin = StringUtil.getRequestData(request.getParameter("txtMoneyMin"), "");
			String p_MoneyMax = StringUtil.getRequestData(request.getParameter("txtMoneyMax"), "");
			// ��ѯ����-����ʱ��
			String p_DateMin = StringUtil.getRequestData(request.getParameter("txtDateMin"), "");
			String p_DateMax = StringUtil.getRequestData(request.getParameter("txtDateMax"), "");
			// ��ѯ����-Ժ���е�����
			String p_PercentMin = StringUtil.getRequestData(request.getParameter("txtPercentMin"), "");
			String p_PercentMax = StringUtil.getRequestData(request.getParameter("txtPercentMax"), "");
			// ��ѯ����-����
			String p_ScoreMin = StringUtil.getRequestData(request.getParameter("txtScoreMin"), "");
			String p_ScoreMax = StringUtil.getRequestData(request.getParameter("txtScoreMax"), "");
			// ��ѯ����-����
			String p_Ill = StringUtil.getRequestData(request.getParameter("txtIll"), "");

			// ���sql���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * FROM (");
			sb_SQL.append("SELECT t_ill.C_ID as C_ID, ");
			sb_SQL.append("t_ill.C_CODE as C_CODE, ");
			sb_SQL.append("t_ill.C_TYPE as C_TYPE, ");
			sb_SQL.append("t_ill.C_MONEY as C_MONEY, ");
			sb_SQL.append("t_ill.C_DATE as C_DATE, ");
			sb_SQL.append("t_ill.C_PERCENT as C_PERCENT, ");
			sb_SQL.append("CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END AS SCORE, ");
			sb_SQL.append("t_ill.C_ILL as C_ILL, ");
			sb_SQL.append("t_user.C_NAME as USERNAME, ");
			sb_SQL.append("t_ill.C_OPERTIME as C_OPERTIME ");
			sb_SQL.append("FROM t_ill ");
			sb_SQL.append("LEFT JOIN t_user ");
			sb_SQL.append("ON t_ill.C_OPERATOR = t_user.C_ID ");
			sb_SQL.append("WHERE t_ill.C_PATIENTID = " + p_PatientID);
			if (p_Code.length() > 0) {
				sb_SQL.append(" AND t_ill.C_CODE like '%" + p_Code + "%'");
			}
			if (p_Type.length() > 0) {
				sb_SQL.append(" AND t_ill.C_TYPE = " + p_Type);
			}
			if (p_MoneyMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_MONEY >= " + p_MoneyMin);
			}
			if (p_MoneyMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_MONEY <= " + p_MoneyMax);
			}
			if (p_DateMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_DATE >= '" + p_DateMin + "' ");
			}
			if (p_DateMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_DATE <= '" + p_DateMax + "' ");
			}
			if (p_PercentMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_PERCENT >= " + p_PercentMin);
			}
			if (p_PercentMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_PERCENT <= " + p_PercentMax);
			}
			if (p_Ill.length() > 0) {
				sb_SQL.append(" AND t_ill.C_ILL like '%" + p_Ill + "%'");
			}
			sb_SQL.append(") t_info ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_ScoreMin.length() > 0) {
				sb_SQL.append("AND t_info.SCORE >= " + p_ScoreMin + " ");
			}
			if (p_ScoreMax.length() > 0) {
				sb_SQL.append("AND t_info.SCORE <= " + p_ScoreMax + " ");
			}

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
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city,hosType");
				request.setAttribute("optionItemMap", optionItemMap);
				
				// ��ȡ������������б�
				String hosTypeOptionList = common.getHosTypeOptionList(p_Type);
				request.setAttribute("hosTypeOptionList", hosTypeOptionList);

				// ����Ǩ���׻���
				String str_URL = "/app/business/ill_manage.jsp";
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("IllManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
