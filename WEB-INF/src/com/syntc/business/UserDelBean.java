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
 * CLASS �� ContractDelBean
 * VERSION �� 0.00
 * DESC : �û�ɾ��
 * DATE �� 2010-08-26
 * AUTHOR �� zhangqiang
 * HISTORY �� 2010-08-26 ����
 */
package com.syntc.business;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class UserDelBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public UserDelBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * ҵ���߼��������
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        // ���ݿ��������
        DBOperate conn = new DBOperate();
        
        Vector<String> vec = new Vector<String>();

        try {
            // SQL��Ŷ���
            StringBuffer sb_SQL = new StringBuffer();
            StringBuffer sb_SQL1 = new StringBuffer();
            // ����ID
            String strUser_ID = StringUtil.getRequestData(request.getParameter("user_id"));
            
            if("1".equals(strUser_ID)){
            	//��ʾ��Ϣ
            	String str_ErrMsg = "������ɾ�������û�admin��";
            	//���õ�request��
                request.setAttribute("pop_Msg",str_ErrMsg);
            	
            	// ����Ǩ�ƻ���
                String str_URL = "UserManage.do";

                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
            	// ���SQL���
                sb_SQL.append("DELETE FROM t_user ");
                sb_SQL.append("WHERE C_ID = " + strUser_ID);
                
                vec.add(sb_SQL.toString());
                
                sb_SQL1.append("DELETE FROM t_right ");
                sb_SQL1.append("WHERE C_USERID = " + strUser_ID);
                
                vec.add(sb_SQL1.toString());
                
                // �������ݿ����
                int i_Rtn = conn.doTransaction(vec);
                //int i_Rtn1 = conn.doTransaction(sb_SQL1.toString());

                // �жϲ�ѯ����Ƿ�ִ�гɹ�.
                if (i_Rtn == CommonConstants.CLDEF_DB_OK ) {
                    // ����Ǩ�ƻ���
                    String str_URL = "UserManage.do";

                    // ����Ǩ��
                    parameters.setParameters("results", "ForwardPage", str_URL);
                } else {
                    // Ǩ�Ƶ�������
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }

        } catch (Exception ex) {
            System.out.println("UserDelBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
}