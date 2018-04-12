////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
//
// ALL RIGHTS RESERVED BY SYNTC CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/*
 * CLASS      �� MenuBean
 * VERSION    �� 0.00
 * DESC       : ��Ŀ������Ϣ�½�����
 * DATE       �� 2007-03-23
 * AUTHOR     �� zhangqiang
 * HISTORY    �� 2007-03-23 ����
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class MenuBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public MenuBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		try {
			// ˵�����������·�����⣬����jsp�������ͨ��java�ļ�Ǩ�ƹ�ȥ����ע��

			// ����Ǩ���׻���
			String str_URL = "/menu.jsp";
			// ����Ǩ��
			parameters.setParameters("results", "ForwardPage", str_URL);
		} catch (Exception ex) {
			System.out.println("MenuBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}

}
