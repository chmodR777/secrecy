package com.syntc.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class PatientAddBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientAddBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		try {
			Common common = new Common();
			// ��ȡ��Ա��������б�
			String memTypeOptionList = common.getMemTypeOptionList("");
			request.setAttribute("memTypeOptionList", memTypeOptionList);
			// ��ȡ�Ա������б�
			String sexOptionList = common.getSexOptionList("");
			request.setAttribute("sexOptionList", sexOptionList);
			// ��ȡý�巽ʽ�����б�
			String mediaTypeOptionList = common.getMediaTypeOptionList("");
			request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
			// ��ȡ��ͬ��λ�����б�
			String companyOptionList = common.getCompanyOptionList("");
			request.setAttribute("companyOptionList", companyOptionList);
			// ��ȡ���ڵ���-ʡ�����б�
			String provinceOptionList = common.getProvinceOptionList("");
			request.setAttribute("provinceOptionList", provinceOptionList);
			// ��ȡ���ڵ���-�������б�
			request.setAttribute("cityOptionList", "");
			// ��ȡʡ��Map
			Map provinceCityMap = common.getProvinceCityMap();
			request.setAttribute("provinceCityMap", provinceCityMap);
			
			// ����Ǩ�ƻ���
			String str_URL = "/app/business/patient_add.jsp";

			// ����Ǩ��
			parameters.setParameters("results", "ForwardPage", str_URL);
		} catch (Exception ex) {
			System.out.println("PatientAddBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}