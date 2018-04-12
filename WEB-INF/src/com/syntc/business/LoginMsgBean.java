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
 * CLASS      �� LoginMsgBean
 * VERSION    �� 0.1
 * DESC       :  �����ʾ��ʾ��Ϣ��ѯ
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
import com.syntc.util.CommonLog;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;

public class LoginMsgBean extends BusinessLogic{
	/**
	* ���캯��
	*/
	public LoginMsgBean(){
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
		// ��ѯ���������
		ResultObj res     = new ResultObj();

		try{
			// �û���Ϣ
			UserBean user = (UserBean) request.getSession().getAttribute("UserBean");
            //userid
            String strUserID = user.getUserCode();
			//String strUserID = "usr1";
			
			//Ǩ�ƻ����ַ
			String strURL = null;

			//LOG��־����
			CommonLog log = new CommonLog();

			//SQL ���
			StringBuffer sbSql = new StringBuffer("");

				  
			//��ѯѡ���¼����ϸ��Ϣ
			sbSql = new StringBuffer("");
			sbSql.append("SELECT ");
			sbSql.append("    message_id,");
			sbSql.append("    pro_name,");
			sbSql.append("    pq_name,");
			sbSql.append("    message_content,");
			sbSql.append("    CONVERT(char(10), created_time, 126) AS created_time");
			sbSql.append("  FROM tb_send_message ");
			sbSql.append(" WHERE user_code = '" + strUserID + "'");
			sbSql.append(" ORDER BY message_id DESC");

			//ִ�в�ѯ
			res = conn.Query( sbSql.toString() );

			//�жϲ�ѯ����Ƿ�ִ�гɹ�.
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {

				log.writeTrace(CommonConstants.CLDEF_LOG_TYPE_INFO,
					"LoginMsgBean",
					"QUERY",
					"OK" );

				//����ѯ�����¼�����浽requestָ��������
				request.setAttribute("res",res);

				//Ǩ���б���
				strURL = "/app/home/message.jsp";

				parameters.setParameters("results", "ForwardPage", strURL);
			}
			else
			{
				log.writeTrace(CommonConstants.CLDEF_LOG_TYPE_INFO,
					"LoginMsgBean",
					"QUERY",
					"NG. SQL = " + sbSql.toString() );

				//Ǩ��ERROR����
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			  
			}

		}
		catch(Exception ex){
			System.out.println("LoginMsgBean:"+ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}
	/**
	* ҳ�����⴦�����
	*/
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


	}
}
    