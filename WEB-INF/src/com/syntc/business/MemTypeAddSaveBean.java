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

public class MemTypeAddSaveBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public MemTypeAddSaveBean() {
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
            // ��Ա�������
            String strTYPE_NAME = StringUtil.getRequestData(request.getParameter("txtTYPE_NAME"));
            // Ժ���е�����
            String strPERCENT = StringUtil.getRequestData(request.getParameter("txtPERCENT"));
            // ��׼����
            String strSCORE = StringUtil.getRequestData(request.getParameter("txtSCORE"));
            
            // ��Ա�������Ψһ
			boolean b_flag1 = chkUniqTypeName(strTYPE_NAME);
			// ��׼����Ψһ
			boolean b_flag2 = chkUniqScore(strSCORE);
			if (b_flag1 && b_flag2) {
	        	// ���SQL��䣬�����ͬ��Ϣ
	            sb_SQL.append("insert into t_memtype(C_TYPENAME");
	            sb_SQL.append("       ,C_PERCENT,C_SCORE)");
	            sb_SQL.append(" values(");
	            sb_SQL.append("       '"+strTYPE_NAME+"',");
	            sb_SQL.append("       "+strPERCENT+","+strSCORE);
	            sb_SQL.append(")");
	
	            // �������ݿ����
	            int i_Rtn = conn.doTransaction(sb_SQL.toString());
	            // �жϲ�ѯ����Ƿ�ִ�гɹ�.
	            if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
	                // ����Ǩ�ƻ���
	                String str_URL = "MemTypeManage.do";
	
	                // ����Ǩ��
	                parameters.setParameters("results", "ForwardPage", str_URL);
	            } else {
	
	                // Ǩ�Ƶ�������
	                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
	
	            }
			} else {
				if (!b_flag1) {
					// ��ʾ��Ϣ
					String str_ErrMsg = "��Ա������ƣ�" + strTYPE_NAME + "�Ѵ��ڣ�������¼�룡";
					// ���õ�request��
					request.setAttribute("pop_Msg", str_ErrMsg);
					// ����Ǩ�ƻ���
					String str_URL = "MemTypeAdd.do";
					// ����Ǩ��
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
				if (!b_flag2) {
					// ��ʾ��Ϣ
					String str_ErrMsg = "��׼���֣�" + strSCORE + "�Ѵ��ڣ�������¼�룡";
					// ���õ�request��
					request.setAttribute("pop_Msg", str_ErrMsg);
					// ����Ǩ�ƻ���
					String str_URL = "MemTypeAdd.do";
					// ����Ǩ��
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
			}
        } catch (Exception ex) {
            System.out.println("MemTypeAddSaveBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
	/**
	 * У���Ա�������Ψһ��
	 * 
	 * @param strTypeName
	 * @return
	 */
	private boolean chkUniqTypeName(String strTypeName) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_memtype.C_ID ");
		sb.append("FROM t_memtype ");
		sb.append("WHERE t_memtype.C_TYPENAME = '" + strTypeName + "' ");

		res1 = conn.Query(sb.toString());
		// ����һ����¼���뵱ǰ�Һű����ͬ
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
	
	/**
	 * У���׼����Ψһ��
	 * 
	 * @param strScore
	 * @return
	 */
	private boolean chkUniqScore(String strScore) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_memtype.C_ID ");
		sb.append("FROM t_memtype ");
		sb.append("WHERE t_memtype.C_SCORE = " + strScore + " ");

		res1 = conn.Query(sb.toString());
		// ����һ����¼���뵱ǰ�Һű����ͬ
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// ����
		return b_flag;
	}
}