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
	 * 构造函数
	 */
	public IllModifySaveBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {

		// 数据库操作对象
		DBOperate conn = new DBOperate();
		try {

			// SQL 语句
			StringBuffer sbSql = new StringBuffer();
			// 患者ID
			String strPatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
			String strID = StringUtil.getRequestData(request.getParameter("ill_id"));
			// 挂号编号
			String strCode = StringUtil.getRequestData(request.getParameter("strCode"));
			// 就诊类别
			String strType = StringUtil.getRequestData(request.getParameter("strType"));
			// 就诊金额
			String strMoney = StringUtil.getRequestData(request.getParameter("strMoney"));
			// 就诊时间
			String strDate = StringUtil.getRequestData(request.getParameter("strDate"));
			// 病例
			String strIll = StringUtil.getRequestData(request.getParameter("strIll"));
			// 操作人ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			Common common = new Common();
			// 操作时间
			String strOperTime = common.getServerDate_MySQL();
			
			// 校验挂号编号唯一
			boolean b_flag = chkUniqCode(strID, strCode);
			// 挂号编号唯一
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

				// 进行数据库更新
				int iRtn = conn.doTransaction(sbSql.toString());

				// 判断查询语句是否执行成功.
				if (iRtn == CommonConstants.CLDEF_DB_OK) {
					// 迁移列表画面
					String strURL = "IllManage.do?patient_id=" + strPatientID;
					parameters.setParameters("results", "ForwardPage", strURL);
				} else {
					// 迁移ERROR画面
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
				}
			} else {
				// 提示信息
				String str_ErrMsg = "挂号编号：" + strCode + "已存在，请重新录入！";
				// 设置到request中
				request.setAttribute("pop_Msg", str_ErrMsg);
				// 设置迁移画面
				String str_URL = "IllModify.do?patient_id=" + strPatientID + "&ill_id=" + strID;
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("IllModifySaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}

	/**
	 * 校验挂号编号唯一性
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
		// 存在一条记录，与当前挂号编号相同
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() >= 2) {
			b_flag = false;
		}
		// 返回
		return b_flag;
	}
}
