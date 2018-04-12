package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class ArticleAddBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ArticleAddBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// 文章类别
        String p_ArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
		
		try {
			Common common = new Common();
			// 获取文章类别下拉列表
			String articleTypeOptionList = common.getArticleTypeOptionList("", p_ArticleType);
			request.setAttribute("articleTypeOptionList", articleTypeOptionList);
				
			// 设置迁移画面
			String str_URL = "/app/system/article_add.jsp";
			// 画面迁移
			parameters.setParameters("results", "ForwardPage", str_URL);
		} catch (Exception ex) {
			System.out.println("ArticleAddBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}