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

public class PatientAddSaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientAddSaveBean() {
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
			String strMemTypeID = StringUtil.getRequestData(request.getParameter("strMemTypeID"));
			if (strMemType.length() == 0) {
				strMemType = strMemTypeID;
			}
			// ���֤��
			String strIDCard = StringUtil.getRequestData(request.getParameter("strIDCard"));
			
			// ��Ա���Ψһ
			boolean b_flag = chkUniqMemCode(strMemCode);
			// �������ظ���Ա���
			if (b_flag) {
				Common common = new Common();
				// ���SQL���
				sb_SQL.append("INSERT INTO t_patient(");
				sb_SQL.append("C_MEMCODE, C_NAME, C_SEX, C_AGE, C_BIRTH, C_PROVINCE, C_CITY, ");
				sb_SQL.append("C_MOBILE, C_MEDIATYPE, C_IDCARD, C_COMPANY, C_MEMTYPE) ");
				sb_SQL.append("VALUES(");
				sb_SQL.append("'" + strMemCode + "', ");
				sb_SQL.append("'" + strName + "', ");
				if (strSex.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strSex + ", ");
				}
				if (strAge.length() == 0) {
					sb_SQL.append("NULL, ");
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strAge + ", ");
					int birth = common.getYear() - Integer.parseInt(strAge);
					sb_SQL.append(birth + ", ");
				}
				if (strProvince.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strProvince + ", ");
				}
				if (strCity.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strCity + ", ");
				}
				sb_SQL.append("'" + strMobile + "', ");
				if (strMediaType.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strMediaType + ", ");
				}
				sb_SQL.append("'" + strIDCard + "', ");
				if (strCompany.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strCompany + ", ");
				}
				if (strMemType.length() == 0) {
					sb_SQL.append("NULL) ");
				} else {
					sb_SQL.append(strMemType + ") ");
				}

				// �������ݿ����
				int i_Rtn = conn.doTransaction(sb_SQL.toString());
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
			} else {
				// ��ʾ��Ϣ
				String str_ErrMsg = "��Ա��ţ�" + strMemCode + "�Ѵ��ڣ�������¼�룡";
				// ���õ�request��
				request.setAttribute("pop_Msg", str_ErrMsg);
				// ����Ǩ�ƻ���
				String str_URL = "PatientAdd.do";
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("PatientAddSaveBean:" + ex.toString());
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
	private boolean chkUniqMemCode(String strMemCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_patient.C_ID ");
		sb.append("FROM t_patient ");
		sb.append("WHERE t_patient.C_MEMCODE = '" + strMemCode + "' ");

		res1 = conn.Query(sb.toString());
		// ����һ����¼���뵱ǰ��Ա�����ͬ
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
}