package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class ConsultManageBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ConsultManageBean() {
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
			
			// 查询条件-年月
			String p_Month = StringUtil.getRequestData(request.getParameter("txtMonth"), "");

			// 存放sql语句
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT DISTINCT t_consult.C_MONTH ");
			sb_SQL.append("FROM t_consult ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_Month.length() > 0) {
				sb_SQL.append("AND t_consult.C_MONTH like '%" + p_Month + "%' ");
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
				// 设置总记录数
				parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
				// 设置每页记录数
				parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
				// 设置当前页（列表分页相关参数）
				parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));

				// 将结果集保存到request中
				request.setAttribute("res", res);

				// 设置迁移首画面
				String str_URL = "/app/business/consult_manage.jsp";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ConsultManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
