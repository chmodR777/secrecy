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
import com.syntc.util.StringUtil;

public class IllAddSaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public IllAddSaveBean() {
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
			// �Һű��
			String strCode = StringUtil.getRequestData(request.getParameter("strCode"));
			// �������
			String strType = StringUtil.getRequestData(request.getParameter("strType"));
			// ������
			String strMoney = StringUtil.getRequestData(request.getParameter("strMoney"));
			// Ժ���е�����
			sb_SQL.append("SELECT t_memtype.C_PERCENT ");
			sb_SQL.append("FROM t_patient, t_memtype ");
			sb_SQL.append("WHERE t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("AND t_patient.C_ID = " + strPatientID + " ");
			Common common = new Common();
			String strPercent = common.getViewByID(sb_SQL.toString());
			// ����ʱ��
			String strDate = StringUtil.getRequestData(request.getParameter("strDate"));
			// ����
			String strIll = StringUtil.getRequestData(request.getParameter("strIll"));
			// ������ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			// ����ʱ��
			String strOperTime = common.getServerDate_MySQL();
			
			// �Һű��Ψһ
			boolean b_flag = chkUniqCode(strCode);
			// �������ظ��Һű��
			if (b_flag) {
				// ���SQL���
				sb_SQL = new StringBuffer();
				sb_SQL.append("INSERT INTO t_ill(");
				sb_SQL.append("C_PATIENTID, C_CODE, C_TYPE, C_MONEY, C_PERCENT, C_DATE, C_ILL, ");
				sb_SQL.append("C_OPERATOR, C_OPERTIME) ");
				sb_SQL.append("VALUES(");
				sb_SQL.append(strPatientID + ", ");
				sb_SQL.append("'" + strCode + "', ");
				if (strType.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strType + ", ");
				}
				if (strMoney.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strMoney + ", ");
				}
				if (strPercent.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strPercent + ", ");
				}
				if (strDate.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append("'" + strDate + "', ");
				}
				sb_SQL.append("'" + strIll + "', ");
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
					String str_URL = "IllManage.do?patient_id=" + strPatientID;

					// ����Ǩ��
					parameters.setParameters("results", "ForwardPage", str_URL);
				} else {

					// Ǩ�Ƶ�������
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

				}
			} else {
				// ��ʾ��Ϣ
				String str_ErrMsg = "�Һű�ţ�" + strCode + "�Ѵ��ڣ�������¼�룡";
				// ���õ�request��
				request.setAttribute("pop_Msg", str_ErrMsg);
				// ����Ǩ�ƻ���
				String str_URL = "IllAdd.do?patient_id=" + strPatientID;
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("IllAddSaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}

	/**
	 * У��Һű��Ψһ��
	 * 
	 * @param strCode
	 * @return
	 */
	private boolean chkUniqCode(String strCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_ill.C_ID ");
		sb.append("FROM t_ill ");
		sb.append("WHERE t_ill.C_CODE = '" + strCode + "' ");

		res1 = conn.Query(sb.toString());
		// ����һ����¼���뵱ǰ�Һű����ͬ
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
}