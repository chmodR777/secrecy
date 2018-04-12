package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class IllDelBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public IllDelBean() {
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

		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			// ����ID
			String strPatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
			// ����ID
			String strID = StringUtil.getRequestData(request.getParameter("ill_id"));

			// ���SQL���
			sb_SQL.append("DELETE FROM t_ill ");
			sb_SQL.append("WHERE C_ID = " + strID);

			// �������ݿ����
			int i_Rtn = conn.doTransaction(sb_SQL.toString());

			// �жϲ�ѯ����Ƿ�ִ�гɹ�
			if (i_Rtn == CommonConstants.CLDEF_DB_OK) {				
				// ����Ǩ�ƻ���
				String str_URL = "IllManage.do?patient_id=" + strPatientID;

				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}

		} catch (Exception ex) {
			System.out.println("IllDelBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}