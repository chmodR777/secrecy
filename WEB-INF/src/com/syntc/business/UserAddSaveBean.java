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
 * CLASS �� UserAddSaveBean
 * VERSION �� 0.00
 * DESC : �û��½�
 * DATE �� 2010-08-26
 * AUTHOR �� zhangqiang
 * HISTORY �� 2010-08-26
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

public class UserAddSaveBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public UserAddSaveBean() {
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
            // �û��˺�
            String strUSER_CODE = StringUtil.getRequestData(request.getParameter("txtUSER_CODE"));
            // �û�����
            String strUSER_NAME = StringUtil.getRequestData(request.getParameter("txtUSER_NAME"));
            // �Ա�
            String strSEX = StringUtil.getRequestData(request.getParameter("txtSEX"));
            // ��ϵ�绰
            String strTEL = StringUtil.getRequestData(request.getParameter("txtTEL"));
            // ���ڲ���
            String strDEP = "";
            // ������֯
			String strORG = StringUtil.getRequestData(request.getParameter("txtORG"));
            // �Ƿ����Ա
            String strRoleType = StringUtil.getRequestData(request.getParameter("txtRoleType"));
            // ��ע
            String strREMARK = StringUtil.getRequestData(request.getParameter("txtREMARK")).replaceAll("\r", "<br>");
            //�û��˺�Ψһ
            boolean b_flag = chkUniqUserCode(strUSER_CODE);
            //�������ظ��˺�
            if(b_flag){
            	// ���SQL��䣬�����ͬ��Ϣ
                sb_SQL.append("insert into t_user(");
                sb_SQL.append("       C_CODE,C_NAME,");
                sb_SQL.append("       C_PWD,C_ROLETYPE,");
                sb_SQL.append("       C_SEX,C_TEL,");
                sb_SQL.append("       C_DEP,C_REMARK,C_ORG_ID)");
                sb_SQL.append(" values(");
                sb_SQL.append("       '"+strUSER_CODE+"',");
                sb_SQL.append("       '"+strUSER_NAME+"',");
                sb_SQL.append("       '"+strUSER_CODE+"',");
                sb_SQL.append("       '"+strRoleType+"',");
                sb_SQL.append("       '"+strSEX+"',");
                sb_SQL.append("       '"+strTEL+"',");
                sb_SQL.append("       '"+strDEP+"',");
                sb_SQL.append("       '"+strREMARK+"',");
                if (strORG.length() == 0) {
                	strORG = "-1";
                }
                sb_SQL.append(strORG);
                sb_SQL.append(")");
                
                
                // �������ݿ����
                int i_Rtn = conn.doTransaction(sb_SQL.toString());
                // �жϲ�ѯ����Ƿ�ִ�гɹ�.
                if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
                	
                    // ����Ǩ�ƻ���
                    String str_URL = "UserManage.do";

                    // ����Ǩ��
                    parameters.setParameters("results", "ForwardPage", str_URL);
                } else {

                    // Ǩ�Ƶ�������
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }else{
            	//��ʾ��Ϣ
            	String str_ErrMsg = "�û�����"+strUSER_CODE+"�Ѵ��ڣ�������¼�룡";
            	//���õ�request��
                request.setAttribute("pop_Msg",str_ErrMsg);
                // ����Ǩ�ƻ���
                String str_URL = "UserAdd.do";
                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }
        } catch (Exception ex) {
            System.out.println("ContractNewBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    /**
     * У���û��˺�Ψһ��
     * @param strUserCode
     * @return
     */
    private boolean chkUniqUserCode(String strUserCode){
    	boolean b_flag = true;
    	DBOperate conn = new DBOperate();
    	ResultObj res1 = new ResultObj();
    	StringBuffer sb = new StringBuffer();
    	sb.append("select a.C_ID,");
    	sb.append("       a.C_NAME,a.C_CODE,");
    	sb.append("       a.C_SEX,a.C_TEL,");
    	sb.append("       a.C_DEP,a.C_REMARK ");
    	sb.append("  from t_user a ");
    	sb.append(" where a.C_CODE = '"+strUserCode+"' ");
    		
    	res1 = conn.Query(sb.toString());
    	//����һ����¼���뵱ǰ�˺���ͬ
    	if(CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size()>1){
    		b_flag = false;
    	}
    	//����
    	return b_flag;
    }
 
}