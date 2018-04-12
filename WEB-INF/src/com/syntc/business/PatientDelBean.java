package com.syntc.business;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class PatientDelBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientDelBean() {
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
		Vector<String> vec = new Vector<String>();

		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			StringBuffer sb_SQL1 = new StringBuffer();
			// ����ID
			String strID = StringUtil.getRequestData(request.getParameter("patient_id"));

			// ���SQL���
			sb_SQL.append("DELETE FROM t_patient ");
			sb_SQL.append("WHERE C_ID = " + strID);
			vec.add(sb_SQL.toString());
			sb_SQL1.append("DELETE FROM t_ill ");
			sb_SQL1.append("WHERE C_PATIENTID = " + strID);
			vec.add(sb_SQL1.toString());

			// �������ݿ����
			int i_Rtn = conn.doTransaction(vec);

			// �жϲ�ѯ����Ƿ�ִ�гɹ�.
			if (i_Rtn == CommonConstants.CLDEF_DB_OK) {				
				// ����Ǩ�ƻ���
				String str_URL = "PatientManage.do";

				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}

		} catch (Exception ex) {
			System.out.println("PatientDelBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}