////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2010 zq CORPORATION
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
 * CLASS �� ContractAddBean
 * VERSION �� 0.00
 * DESC : ϵͳ�û��½�ҳ��
 * DATE �� 2010-08-26
 * AUTHOR �� zhangqiang
 * HISTORY ��2010-08-26 ����
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.Parameters;

public class UserAddBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public UserAddBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * ҵ���߼��������
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        try {
        	Common common = new Common();
        	// ��ȡ��֯�����б�
			String orgOptionList = common.getOrgOptionList("");
			request.setAttribute("orgOptionList", orgOptionList);
            // ����Ǩ�ƻ���
            String str_URL = "/app/system/user_add.jsp";

            // ����Ǩ��
            parameters.setParameters("results", "ForwardPage", str_URL);
        } catch (Exception ex) {
            System.out.println("ContractAddBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
}