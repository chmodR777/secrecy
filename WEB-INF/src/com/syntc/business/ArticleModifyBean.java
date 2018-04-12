package com.syntc.business;

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

public class ArticleModifyBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ArticleModifyBean() {
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
		
		// 文章类别
        String strArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
		String strID = StringUtil.getRequestData(request.getParameter("article_id"));

		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT a.C_ID, ");
			sb_SQL.append("a.C_TITLE, ");
			sb_SQL.append("a.C_TYPE, ");
			sb_SQL.append("a.C_CONTENT ");
			sb_SQL.append("FROM t_article a ");
			sb_SQL.append("WHERE a.C_ID = ").append(strID).append(" ");

			// 执行查询
			res = conn.Query(sb_SQL.toString());
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				// 将结果集保存到request中
				request.setAttribute("res", res);
				
				// 获取文章类别下拉列表
				String articleTypeOptionList = common.getArticleTypeOptionList(res.getCell("C_TYPE", 1), strArticleType);
				request.setAttribute("articleTypeOptionList", articleTypeOptionList);

				// 设置迁移画面
				String str_URL = "/app/system/article_modify.jsp";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleModifyBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}