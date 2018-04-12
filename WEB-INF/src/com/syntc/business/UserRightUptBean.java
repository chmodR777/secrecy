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
 * CLASS �� UserRightUptBean
 * VERSION �� 0.00
 * DESC : �û�Ȩ�ޱ༭
 * DATE �� 2010-09-03
 * AUTHOR �� zhangqiang
 * HISTORY �� 2010-09-03 ����
 */
package com.syntc.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class UserRightUptBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public UserRightUptBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * ҵ���߼��������
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        // ���������
        ResultObj res = new ResultObj();
        //�û�Ȩ�޶���
        ResultObj res_right = new ResultObj();
        // ���ݿ����Ӷ���
        DBOperate conn = new DBOperate();

        try {
            // SQL��Ŷ���
            StringBuffer sb_SQL = new StringBuffer();
            // ����ID
            String strUSER_ID = StringUtil.getRequestData(request.getParameter("user_id"));

            // ���SQL��䣬��ѯ�û���Ϣ
            sb_SQL.append("select a.C_ID,");
            sb_SQL.append("       a.C_NAME,a.C_CODE,");
            sb_SQL.append("       a.C_SEX,a.C_TEL,");
            sb_SQL.append("       o.C_NAME C_ORG,a.C_REMARK ");
            sb_SQL.append("  from t_user a left join t_org o on a.C_ORG_ID = o.C_ID ");
            sb_SQL.append(" WHERE a.C_ID = '" + strUSER_ID + "' ");

            // ִ�в�ѯ
            res = conn.Query(sb_SQL.toString());
            
            StringBuffer sb_Right = new StringBuffer();
            sb_Right.append("SELECT a.C_MENUID ");
            sb_Right.append("  FROM t_right a ");
            sb_Right.append(" WHERE a.C_USERID = " + strUSER_ID);
            
            // ִ�в�ѯ
            res_right = conn.Query(sb_Right.toString());

            if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && CommonConstants.CLDEF_DB_OK <= res_right.getStatus()) {
                // ����������浽request��
                request.setAttribute("res", res);
                
                //����û�Ȩ��id
                List<String> list = new ArrayList<String>();
                
                if(res_right.size()>1){
                	for(int i=1; i < res_right.size(); i++){
                		list.add(res_right.getCell("C_MENUID", i));
                	}
                }
                //Ȩ�޽����
                request.setAttribute("list", list);

                // ����Ǩ�ƻ���
                String str_URL = "/app/system/user_right_upt.jsp";

                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            } else {
                // Ǩ�Ƶ�������
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

            }

        } catch (Exception ex) {
            System.out.println("UserRightUptBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
}