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
 * CLASS      �� UserModifySaveBean
 * VERSION    �� 0.1
 * DESC       :  �û���Ϣ�޸ı���
 * DATE       �� 2010-08-26
 * AUTHOR     ��zhangqiang
 * HISTORY    �� 2010-08-26 ����
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

public class UserModifySaveBean extends BusinessLogic{
      /**
       * ���캯��
       */
      public UserModifySaveBean(){
         if(CommonConstants.CLDEF_DEBUG){
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
         }
      }

      /**
       * ҵ���߼��������
       */
      public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{

        // ���ݿ��������
        DBOperate conn = new DBOperate();
        try{

            //SQL ���
            StringBuffer sbSql = new StringBuffer();
            
            //�û�id
            String strUSER_ID = StringUtil.getRequestData(request.getParameter("txtUSER_ID"));
            // �û��˺�
            String strUSER_CODE = StringUtil.getRequestData(request.getParameter("txtUSER_CODE"));
            // �û�����
            String strUSER_NAME = StringUtil.getRequestData(request.getParameter("txtUSER_NAME"));
            // �Ա�
            String strSEX = StringUtil.getRequestData(request.getParameter("txtSEX"));
            // ��ϵ�绰
            String strTEL = StringUtil.getRequestData(request.getParameter("txtTEL"));
            // ������֯
            String strORG = StringUtil.getRequestData(request.getParameter("txtORG"));
            // �Ƿ����Ա
            String strROLETYPE = StringUtil.getRequestData(request.getParameter("txtRoleType"));
            // ��ע
            String strREMARK = StringUtil.getRequestData(request.getParameter("txtREMARK")).replaceAll("\r", "<br>");
            //У���˺�Ψһ
            boolean b_flag = chkUniqUserCode(strUSER_ID,strUSER_CODE);
            //�˺�Ψһ
            if(b_flag){
            	sbSql.append("update t_user set ");
                sbSql.append("       C_NAME = '" + strUSER_NAME + "',");
                sbSql.append("       C_CODE = '" + strUSER_CODE + "',");
                sbSql.append("       C_SEX = '" + strSEX + "',");
                sbSql.append("       C_TEL = '" + strTEL + "',");
                sbSql.append("       C_DEP = '',");
                sbSql.append("       C_ROLETYPE = '" + strROLETYPE + "',");
                sbSql.append("       C_REMARK = '" + strREMARK + "',");
                if (strORG.length() == 0) {
                	strORG = "-1";
                }
                sbSql.append("       C_ORG_ID = " + strORG);
                sbSql.append(" where C_ID = " + strUSER_ID );
                    

                //�������ݿ����
                int iRtn = conn.doTransaction(sbSql.toString());

                //�жϲ�ѯ����Ƿ�ִ�гɹ�.
                if (iRtn  == CommonConstants.CLDEF_DB_OK) {
                    //Ǩ���б���
                    String strURL = "UserManage.do";

                    parameters.setParameters("results", "ForwardPage", strURL);
                } else {
                    //Ǩ��ERROR����
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            }else{
            	//��ʾ��Ϣ
            	String str_ErrMsg = "�û�����"+strUSER_CODE+"�Ѵ��ڣ�������¼�룡";
            	//���õ�request��
                request.setAttribute("pop_Msg",str_ErrMsg);
                // ����Ǩ�ƻ���
                String str_URL = "UserModify.do?user_id="+strUSER_ID;
                // ����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }
        }
        catch(Exception ex){
            System.out.println("UserModifySaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * ҳ�����⴦�����
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
      }
      
      /**
       * У���û��˺�Ψһ��
       * @param strUserCode
       * @return
       */
      private boolean chkUniqUserCode(String strUSER_ID,String strUSER_CODE){
      	boolean b_flag = true;
      	DBOperate conn = new DBOperate();
      	ResultObj res1 = new ResultObj();
      	StringBuffer sb = new StringBuffer();
      	sb.append("select a.C_ID,");
      	sb.append("       a.C_NAME,a.C_CODE,");
      	sb.append("       a.C_SEX,a.C_TEL,");
      	sb.append("       a.C_DEP,a.C_REMARK ");
      	sb.append("  from t_user a ");
      	sb.append(" where a.C_ID <> "+strUSER_ID);
      	sb.append("   and a.C_CODE = '"+strUSER_CODE+"'");
      		
      	res1 = conn.Query(sb.toString());
      	//����һ����¼���뵱ǰ�˺���ͬ
      	if(CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size()>=2){
      		b_flag = false;
      	}
      	//����
      	return b_flag;
      }
}
