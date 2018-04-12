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
 * CLASS      �� UserRightSaveBean
 * VERSION    �� 0.1
 * DESC       :  �û�Ȩ�ޱ������
 * DATE       �� 2010-09-03
 * AUTHOR     �� zhangqiang
 * HISTORY    �� 2010-09-03 0.1 ����
 */
package com.syntc.business;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class UserRightSaveBean extends BusinessLogic{
      /**
       * ���캯��
       */
      public UserRightSaveBean(){
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
        
        Vector<String> v_sql = new Vector<String>();

        try{
        	//ȡ���û�id
        	String strUserID = StringUtil.getRequestData(request.getParameter("txtUSER_ID"));
        	//ȡ�ø��º��Ȩ��
        	String[] strRight = (String[])request.getParameterValues("menuid");
        	
            //SQL ���
            StringBuffer sbSql = new StringBuffer();
            //ɾ��ԭ��Ȩ��
            sbSql = new StringBuffer();
        	sbSql.append("delete from t_right");
        	sbSql.append(" where C_USERID = " + strUserID);
        	v_sql.add(sbSql.toString());

            if(strRight != null && strRight.length >= 1){
            	for(int i = 0; i < strRight.length; i++){
            		//����Ȩ�޲��뵽���ݿ�
                	sbSql = new StringBuffer();
                	sbSql.append("insert into t_right ");
                	sbSql.append(" (C_USERID,C_MENUID) ");
                	sbSql.append(" values("+strUserID+","+strRight[i]+")");
                	v_sql.add(sbSql.toString());
                }
            }

	        //�������ݿ����
	        int iRtn = conn.doTransaction(v_sql);
	
	        //�жϲ�ѯ����Ƿ�ִ�гɹ�.
	        if (iRtn  == CommonConstants.CLDEF_DB_OK) {
	            //Ǩ���б���
	            String strURL = "UserRight.do";
	
	            parameters.setParameters("results", "ForwardPage", strURL);
	        } else {
	            //Ǩ��ERROR����
	            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
	
	        }
 
        }
        catch(Exception ex){
            System.out.println("UserRightSaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * ҳ�����⴦�����
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


      }
}
