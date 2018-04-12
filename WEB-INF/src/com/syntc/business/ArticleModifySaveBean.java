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

public class ArticleModifySaveBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ArticleModifySaveBean() {
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

			// SQL 语句
			StringBuffer sbSql = new StringBuffer();
			// 文章类别
	        String strArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
			String strID = StringUtil.getRequestData(request.getParameter("article_id"));
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
			
			sbSql.append("UPDATE t_article SET ");
			sbSql.append("C_TITLE = '" + strTitle + "', ");
			sbSql.append("C_TYPE = '" + strType + "', ");
			sbSql.append("C_CONTENT = '" + strContent + "', ");
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
				String strURL = "ArticleManage.do?article_type=" + strArticleType;
				parameters.setParameters("results", "ForwardPage", strURL);
			} else {
				// 迁移ERROR画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleModifySaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
