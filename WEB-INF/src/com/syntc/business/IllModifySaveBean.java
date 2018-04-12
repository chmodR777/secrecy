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

public class IllModifySaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public IllModifySaveBean() {
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

			// SQL ���
			StringBuffer sbSql = new StringBuffer();
			// ����ID
			String strPatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
			String strID = StringUtil.getRequestData(request.getParameter("ill_id"));
			// �Һű��
			String strCode = StringUtil.getRequestData(request.getParameter("strCode"));
			// �������
			String strType = StringUtil.getRequestData(request.getParameter("strType"));
			// ������
			String strMoney = StringUtil.getRequestData(request.getParameter("strMoney"));
			// ����ʱ��
			String strDate = StringUtil.getRequestData(request.getParameter("strDate"));
			// ����
			String strIll = StringUtil.getRequestData(request.getParameter("strIll"));
			// ������ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			Common common = new Common();
			// ����ʱ��
			String strOperTime = common.getServerDate_MySQL();
			
			// У��Һű��Ψһ
			boolean b_flag = chkUniqCode(strID, strCode);
			// �Һű��Ψһ
			if (b_flag) {
				sbSql.append("UPDATE t_ill SET ");
				sbSql.append("C_CODE = '" + strCode + "', ");
				if (strType.length() == 0) {
					sbSql.append("C_TYPE = NULL, ");
				} else {
					sbSql.append("C_TYPE = " + strType + ", ");
				}
				if (strMoney.length() == 0) {
					sbSql.append("C_MONEY = NULL, ");
				} else {
					sbSql.append("C_MONEY = " + strMoney + ", ");
				}
				if (strDate.length() == 0) {
					sbSql.append("C_DATE = NULL, ");
				} else {
					sbSql.append("C_DATE = '" + strDate + "', ");
				}
				sbSql.append("C_ILL = '" + strIll + "', ");
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
					String strURL = "IllManage.do?patient_id=" + strPatientID;
					parameters.setParameters("results", "ForwardPage", strURL);
				} else {
					// Ǩ��ERROR����
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
				}
			} else {
				// ��ʾ��Ϣ
				String str_ErrMsg = "�Һű�ţ�" + strCode + "�Ѵ��ڣ�������¼�룡";
				// ���õ�request��
				request.setAttribute("pop_Msg", str_ErrMsg);
				// ����Ǩ�ƻ���
				String str_URL = "IllModify.do?patient_id=" + strPatientID + "&ill_id=" + strID;
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("IllModifySaveBean:" + ex.toString());
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
	private boolean chkUniqCode(String strID, String strCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_ill.C_ID ");
		sb.append("FROM t_ill ");
		sb.append("WHERE t_ill.C_CODE = '" + strCode + "' ");
		sb.append("AND t_ill.C_ID <> " + strID + " ");

		res1 = conn.Query(sb.toString());
		// ����һ����¼���뵱ǰ�Һű����ͬ
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() >= 2) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
}
