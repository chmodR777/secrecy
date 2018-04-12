package com.syntc.business;

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

public class PatientModifySaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientModifySaveBean() {
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
			Common common = new Common();
			// SQL ���
			StringBuffer sbSql = new StringBuffer();

			// ����ID
			String strID = StringUtil.getRequestData(request.getParameter("strID"));			
			// ��Ա���
			String strMemCode = StringUtil.getRequestData(request.getParameter("strMemCode"));
			// ����
			String strName = StringUtil.getRequestData(request.getParameter("strName"));
			// �Ա�
			String strSex = StringUtil.getRequestData(request.getParameter("strSex"));
			// ����
			String strAge = StringUtil.getRequestData(request.getParameter("strAge"));
			// ���ڵ���-ʡ
			String strProvince = StringUtil.getRequestData(request.getParameter("strProvince"));
			// ���ڵ���-��
			String strCity = StringUtil.getRequestData(request.getParameter("strCity"));
			// �ֻ�
			String strMobile = StringUtil.getRequestData(request.getParameter("strMobile"));
			// ý�巽ʽ
			String strMediaType = StringUtil.getRequestData(request.getParameter("strMediaType"));
			// ��ͬ��λ
			String strCompany = StringUtil.getRequestData(request.getParameter("strCompany"));
			// ��Ա���
			String strMemType = StringUtil.getRequestData(request.getParameter("strMemType"));
			// ���֤��
			String strIDCard = StringUtil.getRequestData(request.getParameter("strIDCard"));
			
			
			// У���Ա���Ψһ
			boolean b_flag = chkUniqMemCode(strID, strMemCode);
			// ��Ա���Ψһ
			if (b_flag) {
				sbSql.append("UPDATE t_patient SET ");
				sbSql.append("C_MEMCODE = '" + strMemCode + "', ");
				sbSql.append("C_NAME = '" + strName + "', ");
				if (strSex.length() == 0) {
					sbSql.append("C_SEX = NULL, ");
				} else {
					sbSql.append("C_SEX = " + strSex + ", ");
				}
				if (strAge.length() == 0) {
					sbSql.append("C_AGE = NULL, ");
					sbSql.append("C_BIRTH = NULL, ");
				} else {
					sbSql.append("C_AGE = " + strAge + ", ");
					int birth = common.getYear() - Integer.parseInt(strAge);
					sbSql.append("C_BIRTH = " + birth + ", ");
				}
				if (strProvince.length() == 0) {
					sbSql.append("C_PROVINCE = NULL, ");
				} else {
					sbSql.append("C_PROVINCE = " + strProvince + ", ");
				}
				if (strCity.length() == 0) {
					sbSql.append("C_CITY = NULL, ");
				} else {
					sbSql.append("C_CITY = " + strCity + ", ");
				}
				sbSql.append("C_MOBILE = '" + strMobile + "', ");
				if (strMediaType.length() == 0) {
					sbSql.append("C_MEDIATYPE = NULL, ");
				} else {
					sbSql.append("C_MEDIATYPE = " + strMediaType + ", ");
				}
				sbSql.append("C_IDCARD = '" + strIDCard + "', ");
				if (strCompany.length() == 0) {
					sbSql.append("C_COMPANY = NULL");
				} else {
					sbSql.append("C_COMPANY = " + strCompany);
				}
				if (strMemType.length() == 0) {
					sbSql.append(" ");
				} else {
					sbSql.append(", C_MEMTYPE = " + strMemType + " ");
				}
				sbSql.append("WHERE C_ID = " + strID);

				// �������ݿ����
				int iRtn = conn.doTransaction(sbSql.toString());

				// �жϲ�ѯ����Ƿ�ִ�гɹ�.
				if (iRtn == CommonConstants.CLDEF_DB_OK) {
					// Ǩ���б���
					String strURL = "PatientManage.do";
					parameters.setParameters("results", "ForwardPage", strURL);
				} else {
					// Ǩ��ERROR����
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
				}
			} else {
				// ��ʾ��Ϣ
				String str_ErrMsg = "��Ա��ţ�" + strMemCode + "�Ѵ��ڣ�������¼�룡";
				// ���õ�request��
				request.setAttribute("pop_Msg", str_ErrMsg);
				// ����Ǩ�ƻ���
				String str_URL = "PatientModify.do?patient_id=" + strID;
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("PatientModifySaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}

	/**
	 * У���Ա���Ψһ��
	 * 
	 * @param strMemCode
	 * @return
	 */
	private boolean chkUniqMemCode(String strID, String strMemCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_patient.C_ID ");
		sb.append("FROM t_patient ");
		sb.append("WHERE t_patient.C_MEMCODE = '" + strMemCode + "' ");
		sb.append("AND t_patient.C_ID <> " + strID + " ");

		res1 = conn.Query(sb.toString());
		// ����һ����¼���뵱ǰ��Ա�����ͬ
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() >= 2) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
}
