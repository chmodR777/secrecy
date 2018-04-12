//////////////////////////////////////////////////////////////
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
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
 * CLASS      �� PwdSaveBean
 * VERSION    �� 0.1
 * DESC       :  ����������
 * DATE       �� 2007/03/24
 * AUTHOR     �� rr
 * HISTORY    �� 2007/03/24 0.1 ����
 */
package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class PwdSaveBean extends BusinessLogic{
      /**
       * ���캯��
       */
      public PwdSaveBean(){
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
            // �û���Ϣ
            UserBean user = (UserBean) request.getSession().getAttribute("UserBean");
            //UserBean���û�id
            String strUserID = user.getId();
            //UserBean�е�����
            String strUserPwd = user.getPwd();

            //Ǩ�ƻ����ַ
            String strURL = null;

            //SQL ���
            StringBuffer sbSql = new StringBuffer();

            //������
            String strPwdOld = StringUtil.getRequestData(request.getParameter("pwd_old"));
            //������
            String strPwdNew = StringUtil.getRequestData(request.getParameter("pwd"));

            if (strPwdOld.equals(strUserPwd)) {
            
                sbSql.append("UPDATE t_user a SET ");
                sbSql.append("       a.C_PWD = '" + strPwdNew + "'");
                sbSql.append(" WHERE a.C_ID = " + strUserID);

                //�������ݿ����
                int iRtn = conn.doTransaction(sbSql.toString());

                //�жϲ�ѯ����Ƿ�ִ�гɹ�.
                if (iRtn  == CommonConstants.CLDEF_DB_OK) {
                    //����UserBean�е�����
                	user.setPwd(strPwdNew);
                    //Ǩ���б���
                    strURL = "/app/home/home.jsp";

                    parameters.setParameters("results", "ForwardPage", strURL);
                } else {
                    //Ǩ��ERROR����
                    parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

                }
            } else {
                //Ǩ���б���
                strURL = "PwdUpt.do?ifBug=1";

                parameters.setParameters("results", "ForwardPage", strURL);
                return;
            }
        }
        catch(Exception ex){
            System.out.println("PwdSaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * ҳ�����⴦�����
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


      }
}
