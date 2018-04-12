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
	 * 构造函数
	 */
	public PatientModifyBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// 结果集对象
		ResultObj res = new ResultObj();
		// 数据库连接对象
		DBOperate conn = new DBOperate();

		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			// 主键ID
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

			// 执行查询
			res = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				// 将结果集保存到request中
				request.setAttribute("res", res);
				
				Common common = new Common();
				// 获取会员类别下拉列表
				String memTypeOptionList = common.getMemTypeOptionList(StringUtil.convertNull(res.getCell("C_MEMTYPE", 1)));
				request.setAttribute("memTypeOptionList", memTypeOptionList);
				// 获取性别下拉列表
				String sexOptionList = common.getSexOptionList(StringUtil.convertNull(res.getCell("C_SEX", 1)));
				request.setAttribute("sexOptionList", sexOptionList);
				// 获取媒体方式下拉列表
				String mediaTypeOptionList = common.getMediaTypeOptionList(StringUtil.convertNull(res.getCell("C_MEDIATYPE", 1)));
				request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
				// 获取合同单位下拉列表
				String companyOptionList = common.getCompanyOptionList(StringUtil.convertNull(res.getCell("C_COMPANY", 1)));
				request.setAttribute("companyOptionList", companyOptionList);
				// 获取所在地区-省下拉列表
				String provinceOptionList = common.getProvinceOptionList(StringUtil.convertNull(res.getCell("C_PROVINCE", 1)));
				request.setAttribute("provinceOptionList", provinceOptionList);
				// 获取所在地区-市下拉列表
				String cityOptionList = "";
				if (StringUtil.convertNull(res.getCell("C_PROVINCE", 1)).length() > 0) {
					cityOptionList = common.getCityOptionList(StringUtil.convertNull(res.getCell("C_PROVINCE", 1)), 
							StringUtil.convertNull(res.getCell("C_CITY", 1)));
				}
				request.setAttribute("cityOptionList", cityOptionList);
				// 获取省市Map
				Map provinceCityMap = common.getProvinceCityMap();
				request.setAttribute("provinceCityMap", provinceCityMap);

				// 设置迁移画面
				String str_URL = "/app/business/patient_modify.jsp";

				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}

		} catch (Exception ex) {
			System.out.println("PatientModifyBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}