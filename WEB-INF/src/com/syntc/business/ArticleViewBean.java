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
import com.syntc.util.StringUtil;

public class ArticleViewBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ArticleViewBean() {
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
		
		String strID = StringUtil.getRequestData(request.getParameter("article_id"));

		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT a.C_ID, ");
			sb_SQL.append("a.C_TITLE, ");
			sb_SQL.append("a.C_CONTENT ");
			sb_SQL.append("FROM t_article a ");
			sb_SQL.append("WHERE a.C_ID = ").append(strID).append(" ");

			// 执行查询
			res = conn.Query(sb_SQL.toString());
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				// 将结果集保存到request中
				request.setAttribute("res", res);
				
				Common common = new Common();
				Map optionItemMap = common.getOptionItemMap("articleType");
				request.setAttribute("optionItemMap", optionItemMap);

				// 设置迁移画面
				String str_URL = "/app/system/article_view.jsp";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ArticleViewBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}