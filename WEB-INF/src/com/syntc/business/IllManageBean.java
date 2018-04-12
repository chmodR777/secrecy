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

public class IllManageBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public IllManageBean() {
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
		String p_PatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
		
		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_patient.C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME, ");
			sb_SQL.append("t_patient.C_SEX, ");
			sb_SQL.append("t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, ");
			sb_SQL.append("t_patient.C_MEMTYPE, ");
			sb_SQL.append("t_memtype.C_TYPENAME AS C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD AS C_IDCARD, ");
			sb_SQL.append("SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS TOTALSCORE ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("LEFT JOIN t_ill ");
			sb_SQL.append("ON t_patient.C_ID = t_ill.C_PATIENTID ");
			sb_SQL.append("LEFT JOIN t_memtype ");
			sb_SQL.append("ON t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("WHERE t_patient.C_ID = " + p_PatientID + " ");
			sb_SQL.append("GROUP BY t_patient.C_ID, ");
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
			sb_SQL.append("t_memtype.C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD ");
			

			// 执行查询
			res = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				// 将结果集保存到request中
				request.setAttribute("res_patient", res);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("IllManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

		try {
			// 每页记录数
			String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String.valueOf(CommonConstants.CLEDF_MAX_PAGE));
			i_PageSize = Integer.parseInt(str_PageSize);
			// 取得当前页号
			String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
			i_CurPage = Integer.parseInt(str_CurPage);
			
			// 查询条件-挂号编号
			String p_Code = StringUtil.getRequestData(request.getParameter("txtCode"), "");
			// 查询条件-就诊类别
			String p_Type = StringUtil.getRequestData(request.getParameter("txtType"), "");
			// 查询条件-就诊金额
			String p_MoneyMin = StringUtil.getRequestData(request.getParameter("txtMoneyMin"), "");
			String p_MoneyMax = StringUtil.getRequestData(request.getParameter("txtMoneyMax"), "");
			// 查询条件-就诊时间
			String p_DateMin = StringUtil.getRequestData(request.getParameter("txtDateMin"), "");
			String p_DateMax = StringUtil.getRequestData(request.getParameter("txtDateMax"), "");
			// 查询条件-院方承担比例
			String p_PercentMin = StringUtil.getRequestData(request.getParameter("txtPercentMin"), "");
			String p_PercentMax = StringUtil.getRequestData(request.getParameter("txtPercentMax"), "");
			// 查询条件-积分
			String p_ScoreMin = StringUtil.getRequestData(request.getParameter("txtScoreMin"), "");
			String p_ScoreMax = StringUtil.getRequestData(request.getParameter("txtScoreMax"), "");
			// 查询条件-病历
			String p_Ill = StringUtil.getRequestData(request.getParameter("txtIll"), "");

			// 存放sql语句
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * FROM (");
			sb_SQL.append("SELECT t_ill.C_ID as C_ID, ");
			sb_SQL.append("t_ill.C_CODE as C_CODE, ");
			sb_SQL.append("t_ill.C_TYPE as C_TYPE, ");
			sb_SQL.append("t_ill.C_MONEY as C_MONEY, ");
			sb_SQL.append("t_ill.C_DATE as C_DATE, ");
			sb_SQL.append("t_ill.C_PERCENT as C_PERCENT, ");
			sb_SQL.append("CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END AS SCORE, ");
			sb_SQL.append("t_ill.C_ILL as C_ILL, ");
			sb_SQL.append("t_user.C_NAME as USERNAME, ");
			sb_SQL.append("t_ill.C_OPERTIME as C_OPERTIME ");
			sb_SQL.append("FROM t_ill ");
			sb_SQL.append("LEFT JOIN t_user ");
			sb_SQL.append("ON t_ill.C_OPERATOR = t_user.C_ID ");
			sb_SQL.append("WHERE t_ill.C_PATIENTID = " + p_PatientID);
			if (p_Code.length() > 0) {
				sb_SQL.append(" AND t_ill.C_CODE like '%" + p_Code + "%'");
			}
			if (p_Type.length() > 0) {
				sb_SQL.append(" AND t_ill.C_TYPE = " + p_Type);
			}
			if (p_MoneyMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_MONEY >= " + p_MoneyMin);
			}
			if (p_MoneyMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_MONEY <= " + p_MoneyMax);
			}
			if (p_DateMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_DATE >= '" + p_DateMin + "' ");
			}
			if (p_DateMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_DATE <= '" + p_DateMax + "' ");
			}
			if (p_PercentMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_PERCENT >= " + p_PercentMin);
			}
			if (p_PercentMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_PERCENT <= " + p_PercentMax);
			}
			if (p_Ill.length() > 0) {
				sb_SQL.append(" AND t_ill.C_ILL like '%" + p_Ill + "%'");
			}
			sb_SQL.append(") t_info ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_ScoreMin.length() > 0) {
				sb_SQL.append("AND t_info.SCORE >= " + p_ScoreMin + " ");
			}
			if (p_ScoreMax.length() > 0) {
				sb_SQL.append("AND t_info.SCORE <= " + p_ScoreMax + " ");
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
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city,hosType");
				request.setAttribute("optionItemMap", optionItemMap);
				
				// 获取就诊类别下拉列表
				String hosTypeOptionList = common.getHosTypeOptionList(p_Type);
				request.setAttribute("hosTypeOptionList", hosTypeOptionList);

				// 设置迁移首画面
				String str_URL = "/app/business/ill_manage.jsp";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("IllManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
