package com.syntc.business;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class PatientDelBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public PatientDelBean() {
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
		Vector<String> vec = new Vector<String>();

		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			StringBuffer sb_SQL1 = new StringBuffer();
			// 主键ID
			String strID = StringUtil.getRequestData(request.getParameter("patient_id"));

			// 组合SQL语句
			sb_SQL.append("DELETE FROM t_patient ");
			sb_SQL.append("WHERE C_ID = " + strID);
			vec.add(sb_SQL.toString());
			sb_SQL1.append("DELETE FROM t_ill ");
			sb_SQL1.append("WHERE C_PATIENTID = " + strID);
			vec.add(sb_SQL1.toString());

			// 进行数据库更新
			int i_Rtn = conn.doTransaction(vec);

			// 判断查询语句是否执行成功.
			if (i_Rtn == CommonConstants.CLDEF_DB_OK) {				
				// 设置迁移画面
				String str_URL = "PatientManage.do";

				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}

		} catch (Exception ex) {
			System.out.println("PatientDelBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}