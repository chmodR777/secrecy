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

public class PatientModifyBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientModifyBean() {
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

		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			// ����ID
			String strID = StringUtil.getRequestData(request.getParameter("patient_id"));
			sb_SQL.append("SELECT t_patient.C_ID, ");
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
			sb_SQL.append("t_patient.C_IDCARD ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("WHERE t_patient.C_ID = ").append(strID).append(" ");

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				// ����������浽request��
				request.setAttribute("res", res);
				
				Common common = new Common();
				// ��ȡ��Ա��������б�
				String memTypeOptionList = common.getMemTypeOptionList(StringUtil.convertNull(res.getCell("C_MEMTYPE", 1)));
				request.setAttribute("memTypeOptionList", memTypeOptionList);
				// ��ȡ�Ա������б�
				String sexOptionList = common.getSexOptionList(StringUtil.convertNull(res.getCell("C_SEX", 1)));
				request.setAttribute("sexOptionList", sexOptionList);
				// ��ȡý�巽ʽ�����б�
				String mediaTypeOptionList = common.getMediaTypeOptionList(StringUtil.convertNull(res.getCell("C_MEDIATYPE", 1)));
				request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
				// ��ȡ��ͬ��λ�����б�
				String companyOptionList = common.getCompanyOptionList(StringUtil.convertNull(res.getCell("C_COMPANY", 1)));
				request.setAttribute("companyOptionList", companyOptionList);
				// ��ȡ���ڵ���-ʡ�����б�
				String provinceOptionList = common.getProvinceOptionList(StringUtil.convertNull(res.getCell("C_PROVINCE", 1)));
				request.setAttribute("provinceOptionList", provinceOptionList);
				// ��ȡ���ڵ���-�������б�
				String cityOptionList = "";
				if (StringUtil.convertNull(res.getCell("C_PROVINCE", 1)).length() > 0) {
					cityOptionList = common.getCityOptionList(StringUtil.convertNull(res.getCell("C_PROVINCE", 1)), 
							StringUtil.convertNull(res.getCell("C_CITY", 1)));
				}
				request.setAttribute("cityOptionList", cityOptionList);
				// ��ȡʡ��Map
				Map provinceCityMap = common.getProvinceCityMap();
				request.setAttribute("provinceCityMap", provinceCityMap);

				// ����Ǩ�ƻ���
				String str_URL = "/app/business/patient_modify.jsp";

				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}

		} catch (Exception ex) {
			System.out.println("PatientModifyBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}