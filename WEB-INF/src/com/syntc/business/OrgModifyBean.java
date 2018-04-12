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

public class OrgModifyBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public OrgModifyBean() {
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
            String strORG_ID = StringUtil.getRequestData(request.getParameter("org_id"));

            // ���SQL��䣬��ѯ��֯��Ϣ
            sb_SQL.append("select a.C_ID,");
            sb_SQL.append("       a.C_NAME");
            sb_SQL.append("  from t_org a  ");
            sb_SQL.append(" WHERE a.C_ID = " + strORG_ID );

            // ִ�в�ѯ
            res = conn.Query(sb_SQL.toString());

            if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
                // ����������浽request��
                request.setAttribute("res", res);

                // ����Ǩ�ƻ���
                String str_URL = "/app/system/org_modify.jsp";

                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            } else {
                // Ǩ�Ƶ�������
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

            }

        } catch (Exception ex) {
            System.out.println("OrgModifyBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
}