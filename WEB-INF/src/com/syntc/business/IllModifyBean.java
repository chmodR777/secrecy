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

public class IllModifyBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public IllModifyBean() {
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
		
		String strPatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
		String strID = StringUtil.getRequestData(request.getParameter("ill_id"));
		
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
			sb_SQL.append("WHERE t_patient.C_ID = " + strPatientID + " ");
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
			System.out.println("IllModifyBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_ill.C_ID, ");
			sb_SQL.append("t_ill.C_CODE, ");
			sb_SQL.append("t_ill.C_TYPE, ");
			sb_SQL.append("t_ill.C_MONEY, ");
			sb_SQL.append("t_ill.C_DATE, ");
			sb_SQL.append("t_ill.C_ILL ");
			sb_SQL.append("FROM t_ill ");
			sb_SQL.append("WHERE t_ill.C_ID = ").append(strID).append(" ");

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				// ����������浽request��
				request.setAttribute("res", res);
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city");
				request.setAttribute("optionItemMap", optionItemMap);
				
				// ��ȡ������������б�
				String hosTypeOptionList = common.getHosTypeOptionList(res.getCell("C_TYPE", 1));
				request.setAttribute("hosTypeOptionList", hosTypeOptionList);

				// ����Ǩ�ƻ���
				String str_URL = "/app/business/ill_modify.jsp";

				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}

		} catch (Exception ex) {
			System.out.println("IllModifyBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}