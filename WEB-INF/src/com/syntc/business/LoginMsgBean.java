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
 * CLASS      ： LoginMsgBean
 * VERSION    ： 0.1
 * DESC       :  画面表示提示信息查询
 * DATE       ： 2007/03/24
 * AUTHOR     ： rr
 * HISTORY    ： 2007/03/24 0.1 作成
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
	* 构造函数
	*/
	public LoginMsgBean(){
		if(CommonConstants.CLDEF_DEBUG){
		System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	* 业务逻辑处理机能
	*/
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{

		//数据库操作对象
		DBOperate conn = new DBOperate();
		// 查询结果集对象
		ResultObj res     = new ResultObj();

		try{
			// 用户信息
			UserBean user = (UserBean) request.getSession().getAttribute("UserBean");
            //userid
            String strUserID = user.getUserCode();
			//String strUserID = "usr1";
			
			//迁移画面地址
			String strURL = null;

			//LOG日志对象
			CommonLog log = new CommonLog();

			//SQL 语句
			StringBuffer sbSql = new StringBuffer("");

				  
			//查询选择记录的详细信息
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

			//执行查询
			res = conn.Query( sbSql.toString() );

			//判断查询语句是否执行成功.
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {

				log.writeTrace(CommonConstants.CLDEF_LOG_TYPE_INFO,
					"LoginMsgBean",
					"QUERY",
					"OK" );

				//将查询结果记录集保存到request指定属性中
				request.setAttribute("res",res);

				//迁移列表画面
				strURL = "/app/home/message.jsp";

				parameters.setParameters("results", "ForwardPage", strURL);
			}
			else
			{
				log.writeTrace(CommonConstants.CLDEF_LOG_TYPE_INFO,
					"LoginMsgBean",
					"QUERY",
					"NG. SQL = " + sbSql.toString() );

				//迁移ERROR画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			  
			}

		}
		catch(Exception ex){
			System.out.println("LoginMsgBean:"+ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}
	/**
	* 页面表单检测处理机能
	*/
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{


	}
}
    