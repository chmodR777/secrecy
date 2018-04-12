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
 * CLASS      �� LoginMsgDelBean
 * VERSION    �� 0.1
 * DESC       :  ��Ϣ������Ϣɾ��
 * DATE       �� 2007/03/24
 * AUTHOR     �� rr
 * HISTORY    �� 2007/03/24 0.1 ����
 */
package com.syntc.business;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.UserBean;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.CommonLog;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;

public class LoginMsgDelBean extends BusinessLogic{
	/**
	* ���캯��
	*/
	public LoginMsgDelBean(){
		if(CommonConstants.CLDEF_DEBUG){
		System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	* ҵ���߼��������
	*/
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{

		//���ݿ��������
		DBOperate conn = new DBOperate();
        Vector vSQL = new Vector();
		try{
			// �û���Ϣ
			UserBean user = (UserBean) request.getSession().getAttribute("UserBean");
			
			//Ǩ�ƻ����ַ
			String strURL = null;

			//LOG��־����
			CommonLog log = new CommonLog();

			//ID��־
			String strMessageID = request.getParameter("msgID");
            String[] arrMessageID = strMessageID.split(",");

			//SQL ���
			StringBuffer sbSql = new StringBuffer("");

            for ( int i = 0 ; i < arrMessageID.length ; i++ ) {
                //����������Ϣ
                sbSql = new StringBuffer();
                
                sbSql.append("DELETE FROM tb_send_message");
                sbSql.append(" WHERE message_id = CAST(" + arrMessageID[i] + " AS numeric(9))");
                vSQL.add(sbSql.toString());
            }
			
            //ִ�в�ѯ
	    	int iRtn = conn.doTransaction(vSQL);
			//�жϲ�ѯ����Ƿ�ִ�гɹ�.
			if (CommonConstants.CLDEF_DB_OK == iRtn) {

				log.writeTrace(CommonConstants.CLDEF_LOG_TYPE_INFO,
					"LoginMsgDelBean",
					"DELETE",
					"OK" );

				//Ǩ���б���
				strURL = "LoginMsg.do";

				parameters.setParameters("results", "ForwardPage", strURL);
			}
			else
			{
				log.writeTrace(CommonConstants.CLDEF_LOG_TYPE_INFO,
					"LoginMsgDelBean",
					"DELETE",
					"NG. SQL = " + sbSql.toString() );

				//Ǩ��ERROR����
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			  
			}

		}
		catch(Exception ex){
			System.out.println("LoginMsgDelBean:"+ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}
	/**
	* ҳ�����⴦�����
	*/
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


	}
}
    