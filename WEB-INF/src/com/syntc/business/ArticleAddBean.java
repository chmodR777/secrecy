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
	 * ���캯��
	 */
	public ArticleAddBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// �������
        String p_ArticleType = StringUtil.getRequestData(request.getParameter("article_type"));
		
		try {
			Common common = new Common();
			// ��ȡ������������б�
			String articleTypeOptionList = common.getArticleTypeOptionList("", p_ArticleType);
			request.setAttribute("articleTypeOptionList", articleTypeOptionList);
				
			// ����Ǩ�ƻ���
			String str_URL = "/app/system/article_add.jsp";
			// ����Ǩ��
			parameters.setParameters("results", "ForwardPage", str_URL);
		} catch (Exception ex) {
			System.out.println("ArticleAddBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}