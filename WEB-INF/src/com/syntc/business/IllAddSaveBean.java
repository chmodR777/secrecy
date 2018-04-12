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

public class IllAddSaveBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public IllAddSaveBean() {
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
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			// 患者ID
			String strPatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
			// 挂号编号
			String strCode = StringUtil.getRequestData(request.getParameter("strCode"));
			// 就诊类别
			String strType = StringUtil.getRequestData(request.getParameter("strType"));
			// 就诊金额
			String strMoney = StringUtil.getRequestData(request.getParameter("strMoney"));
			// 院方承担比例
			sb_SQL.append("SELECT t_memtype.C_PERCENT ");
			sb_SQL.append("FROM t_patient, t_memtype ");
			sb_SQL.append("WHERE t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("AND t_patient.C_ID = " + strPatientID + " ");
			Common common = new Common();
			String strPercent = common.getViewByID(sb_SQL.toString());
			// 就诊时间
			String strDate = StringUtil.getRequestData(request.getParameter("strDate"));
			// 病例
			String strIll = StringUtil.getRequestData(request.getParameter("strIll"));
			// 操作人ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			// 操作时间
			String strOperTime = common.getServerDate_MySQL();
			
			// 挂号编号唯一
			boolean b_flag = chkUniqCode(strCode);
			// 不存在重复挂号编号
			if (b_flag) {
				// 组合SQL语句
				sb_SQL = new StringBuffer();
				sb_SQL.append("INSERT INTO t_ill(");
				sb_SQL.append("C_PATIENTID, C_CODE, C_TYPE, C_MONEY, C_PERCENT, C_DATE, C_ILL, ");
				sb_SQL.append("C_OPERATOR, C_OPERTIME) ");
				sb_SQL.append("VALUES(");
				sb_SQL.append(strPatientID + ", ");
				sb_SQL.append("'" + strCode + "', ");
				if (strType.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strType + ", ");
				}
				if (strMoney.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strMoney + ", ");
				}
				if (strPercent.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strPercent + ", ");
				}
				if (strDate.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append("'" + strDate + "', ");
				}
				sb_SQL.append("'" + strIll + "', ");
				if (strOperator.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strOperator + ", ");
				}
				if (strOperTime.length() == 0) {
					sb_SQL.append("NULL) ");
				} else {
					sb_SQL.append("'" + strOperTime + "') ");
				}
				// 进行数据库更新
				int i_Rtn = conn.doTransaction(sb_SQL.toString());
				// 判断查询语句是否执行成功.
				if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
					// 设置迁移画面
					String str_URL = "IllManage.do?patient_id=" + strPatientID;

					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				} else {

					// 迁移到错误画面
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

				}
			} else {
				// 提示信息
				String str_ErrMsg = "挂号编号：" + strCode + "已存在，请重新录入！";
				// 设置到request中
				request.setAttribute("pop_Msg", str_ErrMsg);
				// 设置迁移画面
				String str_URL = "IllAdd.do?patient_id=" + strPatientID;
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("IllAddSaveBean:" + ex.toString());
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
	private boolean chkUniqCode(String strCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_ill.C_ID ");
		sb.append("FROM t_ill ");
		sb.append("WHERE t_ill.C_CODE = '" + strCode + "' ");

		res1 = conn.Query(sb.toString());
		// 存在一条记录，与当前挂号编号相同
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// 返回
		return b_flag;
	}
}