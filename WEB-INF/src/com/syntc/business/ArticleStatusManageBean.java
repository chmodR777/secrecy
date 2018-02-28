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
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class ArticleStatusManageBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ArticleStatusManageBean() {
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

			// 查询条件-标题
			String p_Title = StringUtil.getRequestData(request.getParameter("txtTitle"), "");
			// 查询条件-状态
			String p_Status = StringUtil.getRequestData(request.getParameter("txtStatus"), "");
			// 文章类别
            String strARTICLE_TYPE = StringUtil.getRequestData(request.getParameter("article_type"));
            // 操作人ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			
			// 存放sql语句
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * from (");
			sb_SQL.append("SELECT a.C_ID, a.C_TITLE, u.C_CODE, a.C_OPERTIME, o.C_NAME ");
			sb_SQL.append("FROM t_article a, t_optionitem o, t_user u ");
			sb_SQL.append("WHERE a.C_STATUS = o.C_ID ");
			sb_SQL.append("AND o.C_TYPE = 'articleStatus' ");
			sb_SQL.append("AND a.C_OPERATOR = u.C_ID ");
			if (strOperator.length() != 0) {
				sb_SQL.append("AND u.C_ID = ").append(strOperator).append(" ");
			}
			sb_SQL.append("AND (a.C_STATUS = '93' OR a.C_STATUS = '94') ");
			sb_SQL.append("AND a.C_TYPE = ").append(strARTICLE_TYPE).append(" ");
			sb_SQL.append("UNION ALL ");
			sb_SQL.append("SELECT a.C_ID, a.C_TITLE, u.C_CODE, a.C_OPERTIME, o.C_NAME ");
			sb_SQL.append("FROM t_article a, t_optionitem o, t_user u ");
			sb_SQL.append("WHERE a.C_STATUS = o.C_ID ");
			sb_SQL.append("AND o.C_TYPE = 'articleStatus' ");
			sb_SQL.append("AND a.C_OPERATOR = u.C_ID ");
			sb_SQL.append("AND a.C_STATUS = '95' ");
			sb_SQL.append("AND a.C_TYPE = ").append(strARTICLE_TYPE).append(") t ");
			
			if (!"".equals(p_Title)) {
				sb_SQL.append("AND C_TITLE like '%" + p_Title + "%' ");
			}
			if (!"".equals(p_Status)) {
				sb_SQL.append("AND a.C_STATUS = '" + p_Status + "' ");
			}
			System.out.println("************************************************");
			System.out.println(sb_SQL.toString());
			System.out.println("************************************************");

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
				
				// 获取文章状态下拉列表
				String articleStatusOptionList = common.getArticleStatusOptionList(p_Status);
				request.setAttribute("articleStatusOptionList", articleStatusOptionList);

				// 设置迁移首画面
				String str_URL = "/app/system/article_status_manage.jsp";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleStatusManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
