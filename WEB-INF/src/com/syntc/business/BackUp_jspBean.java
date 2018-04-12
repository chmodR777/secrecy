//////////////////////////////////////////////////////////////
//
// COPYRIGHT (C) 2010 zq CORPORATION
//
// ALL RIGHTS RESERVED BY zq CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/*
 * CLASS      �� UserBean
 * VERSION    �� 0.00
 * DESC       : �û���¼ҵ�����߼�BEAN
 * DATE       �� 2010-08-23
 * AUTHOR     �� deargod1981@sohu.com
 * HISTORY    �� 2010-08-23 0.00 ����
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class BackUp_jspBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public BackUp_jspBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		
		String  str_URL = "/app/system/backup_up.jsp";
		parameters.setParameters("results", "ForwardPage", str_URL);

	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}

}