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
 * CLASS �� MemTypeModifyBean
 * VERSION �� 0.00
 * DESC : ��Ա����޸�
 * DATE �� 2010-09-11
 * AUTHOR �� zhangqiang
 * HISTORY ��  2010-09-11 ����
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class MemTypeModifyBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public MemTypeModifyBean() {
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
        // ���ݿ����Ӷ���
        DBOperate conn = new DBOperate();

        try {
            // SQL��Ŷ���
            StringBuffer sb_SQL = new StringBuffer();
            // ����ID
            String strTYPE_ID = StringUtil.getRequestData(request.getParameter("type_id"));

            // ���SQL��䣬��ѯ��Ա�����Ϣ
            sb_SQL.append("select a.C_ID,");
            sb_SQL.append("       a.C_TYPENAME,");
            sb_SQL.append("       a.C_PERCENT,");
            sb_SQL.append("       a.C_SCORE ");
            sb_SQL.append("  from t_memtype a  ");
            sb_SQL.append(" WHERE a.C_ID = " + strTYPE_ID );

            // ִ�в�ѯ
            res = conn.Query(sb_SQL.toString());

            if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
                // ����������浽request��
                request.setAttribute("res", res);

                // ����Ǩ�ƻ���
                String str_URL = "/app/system/memtype_modify.jsp";

                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            } else {
                // Ǩ�Ƶ�������
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

            }

        } catch (Exception ex) {
            System.out.println("MemTypeModifyBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
}