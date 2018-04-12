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
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class PatientManageBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public PatientManageBean() {
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
		RowSet rs = new RowSet();
		// 数据库连接对象
		DBOperate conn = new DBOperate();

		// 当前页号
		int i_CurPage = 1;
		// 每页记录数
		int i_PageSize = 10;

		try {
			// 每页记录数
			String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String.valueOf(CommonConstants.CLEDF_MAX_PAGE));
			i_PageSize = Integer.parseInt(str_PageSize);
			// 取得当前页号
			String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
			i_CurPage = Integer.parseInt(str_CurPage);
			
			// 查询条件-会员编号
			String p_MemCode = StringUtil.getRequestData(request.getParameter("txtMemCode"), "");
			// 查询条件-姓名
			String p_Name = StringUtil.getRequestData(request.getParameter("txtName"), "");
			// 查询条件-性别
			String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"), "");
			// 查询条件-年龄
			String p_AgeMin = StringUtil.getRequestData(request.getParameter("txtAgeMin"), "");
			String p_AgeMax = StringUtil.getRequestData(request.getParameter("txtAgeMax"), "");
			// 查询条件-所在地区-省
			String p_Province = StringUtil.getRequestData(request.getParameter("txtProvince"), "");
			// 查询条件-所在地区-市
			String p_City = StringUtil.getRequestData(request.getParameter("txtCity"), "");
			// 查询条件-手机
			String p_Mobile = StringUtil.getRequestData(request.getParameter("txtMobile"), "");
			// 查询条件-媒体方式
			String p_MediaType = StringUtil.getRequestData(request.getParameter("txtMediaType"), "");
			// 查询条件-合同单位
			String p_Company = StringUtil.getRequestData(request.getParameter("txtCompany"), "");
			// 查询条件-会员类别
			String p_MemType = StringUtil.getRequestData(request.getParameter("txtMemType"), "");
			// 查询条件-身份证号
			String p_IDCard = StringUtil.getRequestData(request.getParameter("txtIDCard"), "");
			// 查询条件-累计积分
			String p_TotalScoreMin = StringUtil.getRequestData(request.getParameter("txtTotalScoreMin"), "");
			String p_TotalScoreMax = StringUtil.getRequestData(request.getParameter("txtTotalScoreMax"), "");

			// 存放sql语句
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * FROM (");
			sb_SQL.append("SELECT t_patient.C_ID AS C_ID, ");
			sb_SQL.append("t_patient.C_MEMCODE AS C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME AS C_NAME, ");
			sb_SQL.append("t_patient.C_SEX AS C_SEX, ");
			sb_SQL.append("t_patient.C_AGE AS C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE AS C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY AS C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE AS C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE AS C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY AS C_COMPANY, ");
			sb_SQL.append("t_memtype.C_TYPENAME AS C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD AS C_IDCARD, ");
			sb_SQL.append("SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS TOTALSCORE ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("LEFT JOIN t_ill ");
			sb_SQL.append("ON t_patient.C_ID = t_ill.C_PATIENTID ");
			sb_SQL.append("LEFT JOIN t_memtype ");
			sb_SQL.append("ON t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_MemCode.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEMCODE like '%" + p_MemCode + "%' ");
			}
			if (p_Name.length() > 0) {
				sb_SQL.append("AND t_patient.C_NAME like '%" + p_Name + "%' ");
			}
			if (p_Sex.length() > 0) {
				sb_SQL.append("AND t_patient.C_SEX = " + p_Sex + " ");
			}
			if (p_AgeMin.length() > 0) {
				sb_SQL.append("AND t_patient.C_AGE >= " + p_AgeMin + " ");
			}
			if (p_AgeMax.length() > 0) {
				sb_SQL.append("AND t_patient.C_AGE <= " + p_AgeMax + " ");
			}
			if (p_Province.length() > 0) {
				sb_SQL.append("AND t_patient.C_PROVINCE = " + p_Province + " ");
			}
			if (p_City.length() > 0) {
				sb_SQL.append("AND t_patient.C_CITY = " + p_City + " ");
			}
			if (p_Mobile.length() > 0) {
				sb_SQL.append("AND t_patient.C_MOBILE like '%" + p_Mobile + "%' ");
			}
			if (p_MediaType.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEDIATYPE = " + p_MediaType + " ");
			}
			if (p_Company.length() > 0) {
				sb_SQL.append("AND t_patient.C_COMPANY = " + p_Company + " ");
			}
			if (p_MemType.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEMTYPE = " + p_MemType + " ");
			}
			if (p_IDCard.length() > 0) {
				sb_SQL.append("AND t_patient.C_IDCARD like '%" + p_IDCard + "%' ");
			}
			sb_SQL.append("GROUP BY t_patient.C_MEMCODE, t_patient.C_NAME, t_patient.C_SEX, t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, t_patient.C_CITY, t_patient.C_MOBILE, t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, t_memtype.C_TYPENAME, t_patient.C_IDCARD) t_info ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_TotalScoreMin.length() > 0) {
				sb_SQL.append("AND t_info.TOTALSCORE >= " + p_TotalScoreMin + " ");
			}
			if (p_TotalScoreMax.length() > 0) {
				sb_SQL.append("AND t_info.TOTALSCORE <= " + p_TotalScoreMax + " ");
			}

			// 设置sql
			rs.setSql(sb_SQL.toString());
			// 设置每页记录条数
			rs.setPageSize(i_PageSize);
			// 查询指定页记录
			res = rs.goPage(i_CurPage);

			// 执行查询
			res = conn.Query(sb_SQL.toString());

			// 是否查询成功
			// CLDEF_DB_OK 0：全部操作均正常结束，查到记录
			// CLDEF_DB_OK2 1：全部操作均正常结束，但没有符合查询条件的记录
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				// 设置总记录数
				parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
				// 设置每页记录数
				parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
				// 设置当前页（列表分页相关参数）
				parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));

				// 将结果集保存到request中
				request.setAttribute("res", res);
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city");
				request.setAttribute("optionItemMap", optionItemMap);
				
				// 获取会员类别下拉列表
				String memTypeOptionList = common.getMemTypeOptionList(p_MemType);
				request.setAttribute("memTypeOptionList", memTypeOptionList);
				// 获取性别下拉列表
				String sexOptionList = common.getSexOptionList(p_Sex);
				request.setAttribute("sexOptionList", sexOptionList);
				// 获取媒体方式下拉列表
				String mediaTypeOptionList = common.getMediaTypeOptionList(p_MediaType);
				request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
				// 获取合同单位下拉列表
				String companyOptionList = common.getCompanyOptionList(p_Company);
				request.setAttribute("companyOptionList", companyOptionList);
				// 获取所在地区-省下拉列表
				String provinceOptionList = common.getProvinceOptionList(p_Province);
				request.setAttribute("provinceOptionList", provinceOptionList);
				// 获取所在地区-市下拉列表
				String cityOptionList = "";
				if (p_Province.length() > 0) {
					cityOptionList = common.getCityOptionList(p_Province, p_City);
				}
				request.setAttribute("cityOptionList", cityOptionList);
				
				// 获取省市Map
				Map provinceCityMap = common.getProvinceCityMap();
				request.setAttribute("provinceCityMap", provinceCityMap);

				// 设置迁移首画面
				String str_URL = "/app/business/patient_manage.jsp";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("PatientManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
