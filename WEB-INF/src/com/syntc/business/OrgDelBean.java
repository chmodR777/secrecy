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

public class OrgDelBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public OrgDelBean() {
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

        try {
            // SQL��Ŷ���
            StringBuffer sb_SQL = new StringBuffer();
            // ����ID
            String strORG_ID = StringUtil.getRequestData(request.getParameter("org_id"));
            //����֯�Ƿ��û�ʹ��
            boolean bFlag = this.ifUsedByUser(strORG_ID);
            //��ʹ��
            if(bFlag){
            	//���ܱ�ɾ����ֱ�ӷ���
            	//��ʾ��Ϣ
            	String str_ErrMsg = "����ɾ������֯�Ѿ���ʹ�ã��޷�ɾ����";
            	//���õ�request��
                request.setAttribute("pop_Msg",str_ErrMsg);
                // ����Ǩ�ƻ���
                String str_URL = "OrgManage.do";
                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
            	// ���SQL���
                sb_SQL.append("DELETE FROM t_org ");
                sb_SQL.append(" WHERE C_ID = " + strORG_ID );
                
                // �������ݿ����
                int i_Rtn = conn.doTransaction(sb_SQL.toString());

                // �жϲ�ѯ����Ƿ�ִ�гɹ�.
                if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
                    // ����Ǩ�ƻ���
                    String str_URL = "OrgManage.do";

                    // ����Ǩ��
                    parameters.setParameters("results", "ForwardPage", str_URL);
                } else {
                    // Ǩ�Ƶ�������
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }

        } catch (Exception ex) {
            System.out.println("OrgDelBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    private boolean ifUsedByUser(String orgId){
    	boolean bFlag = false;
    	
    	DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select a.C_ID,a.C_ORG_ID ");
		sb_SQL.append("   from t_user a ");
		sb_SQL.append("  where a.C_ORG_ID = " + orgId);
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());

        if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
        	bFlag = true;
        }
    	
    	return bFlag;
    }
}