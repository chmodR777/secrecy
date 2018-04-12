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
 * CLASS �� MemTypeDelBean
 * VERSION �� 0.00
 * DESC : �û�ɾ��
 * DATE �� 2010-09-11
 * AUTHOR �� zhangqiang
 * HISTORY �� 2010-09-11 ����
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

public class MemTypeDelBean extends BusinessLogic {
    /**
     * ���캯��
     */
    public MemTypeDelBean() {
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
            String strType_ID = StringUtil.getRequestData(request.getParameter("type_id"));
            //�˻�Ա�����Ƿ񱻻���ʹ��
            boolean bFlag = this.ifUsedByPatient(strType_ID);
            //��ʹ��
            if(bFlag){
            	//���ܱ�ɾ����ֱ�ӷ���
            	//��ʾ��Ϣ
            	String str_ErrMsg = "����ɾ���Ļ�Ա����Ѿ���ʹ�ã��޷�ɾ����";
            	//���õ�request��
                request.setAttribute("pop_Msg",str_ErrMsg);
                // ����Ǩ�ƻ���
                String str_URL = "MemTypeManage.do";
                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
            	// ���SQL���
                sb_SQL.append("DELETE FROM t_memtype ");
                sb_SQL.append(" WHERE C_ID = " + strType_ID );
                
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
            }

        } catch (Exception ex) {
            System.out.println("MemTypeDelBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    private boolean ifUsedByPatient(String typeId){
    	boolean bFlag = false;
    	
    	DBOperate conn = new DBOperate();
		ResultObj res = new ResultObj();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select a.C_ID,a.C_MEMTYPE ");
		sb_SQL.append("   from t_patient a ");
		sb_SQL.append("  where a.C_MEMTYPE = " + typeId);
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());

        if (CommonConstants.CLDEF_DB_OK <= res.getStatus() && res.size() > 1) {
        	bFlag = true;
        }
    	
    	return bFlag;
    }
}