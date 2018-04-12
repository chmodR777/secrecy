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

public class OrgAddSaveBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public OrgAddSaveBean() {
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
            // ��֯����
            String strORG_NAME = StringUtil.getRequestData(request.getParameter("txtORG_NAME"));
            
            // ��֯����Ψһ
			boolean b_flag1 = chkUniqOrgName(strORG_NAME);
			if (b_flag1) {
	        	// ���SQL��䣬�����ͬ��Ϣ
	            sb_SQL.append("insert into t_org(C_NAME) values(").append("'" + strORG_NAME + "')");
	
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
			} else {
				// ��ʾ��Ϣ
				String str_ErrMsg = "��֯���ƣ�" + strORG_NAME + "�Ѵ��ڣ�������¼�룡";
				// ���õ�request��
				request.setAttribute("pop_Msg", str_ErrMsg);
				// ����Ǩ�ƻ���
				String str_URL = "OrgAdd.do";
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
        } catch (Exception ex) {
            System.out.println("OrgAddSaveBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
	/**
	 * У��֯����Ψһ��
	 * 
	 * @param strOrgName
	 * @return
	 */
	private boolean chkUniqOrgName(String strOrgName) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_org.C_ID ");
		sb.append("FROM t_org ");
		sb.append("WHERE t_org.C_NAME = '" + strOrgName + "' ");

		res1 = conn.Query(sb.toString());
		//
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
}