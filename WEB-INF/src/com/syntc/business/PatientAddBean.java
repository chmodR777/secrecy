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
	 * 构造函数
	 */
	public PatientAddBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		try {
			Common common = new Common();
			// 获取会员类别下拉列表
			String memTypeOptionList = common.getMemTypeOptionList("");
			request.setAttribute("memTypeOptionList", memTypeOptionList);
			// 获取性别下拉列表
			String sexOptionList = common.getSexOptionList("");
			request.setAttribute("sexOptionList", sexOptionList);
			// 获取媒体方式下拉列表
			String mediaTypeOptionList = common.getMediaTypeOptionList("");
			request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
			// 获取合同单位下拉列表
			String companyOptionList = common.getCompanyOptionList("");
			request.setAttribute("companyOptionList", companyOptionList);
			// 获取所在地区-省下拉列表
			String provinceOptionList = common.getProvinceOptionList("");
			request.setAttribute("provinceOptionList", provinceOptionList);
			// 获取所在地区-市下拉列表
			request.setAttribute("cityOptionList", "");
			// 获取省市Map
			Map provinceCityMap = common.getProvinceCityMap();
			request.setAttribute("provinceCityMap", provinceCityMap);
			
			// 设置迁移画面
			String str_URL = "/app/business/patient_add.jsp";

			// 画面迁移
			parameters.setParameters("results", "ForwardPage", str_URL);
		} catch (Exception ex) {
			System.out.println("PatientAddBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}