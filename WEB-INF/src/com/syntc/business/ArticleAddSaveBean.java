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
import com.syntc.util.StringUtil;

public class ArticleAddSaveBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ArticleAddSaveBean() {
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
		Common common = new Common();
		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			// 文章类别
            String strArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
			// 标题
			String strTitle = StringUtil.getRequestData(request.getParameter("strTitle"));
			// 类别
			String strType = StringUtil.getRequestData(request.getParameter("strType"));
			// 内容
			String strContent = StringUtil.getRequestData(request.getParameter("strContent"));
			// 操作人ID
			UserBean userBean = (UserBean) request.getSession().getAttribute("UserBean");
			String strOperator = userBean.getId();
			// 操作时间
			String strOperTime = common.getServerDate_MySQL();
			// 组合SQL语句
			sb_SQL = new StringBuffer();
			sb_SQL.append("INSERT INTO t_article(");
			sb_SQL.append("C_TITLE, C_TYPE, C_CONTENT, ");
			sb_SQL.append("C_OPERATOR, C_OPERTIME) ");
			sb_SQL.append("VALUES('");
			sb_SQL.append(strTitle + "', ");
			sb_SQL.append("'" + strType + "', ");
			sb_SQL.append("'" + strContent + "', ");
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
				String str_URL = "ArticleManage.do?article_type=" + strArticleType;
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("ArticleAddSaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}