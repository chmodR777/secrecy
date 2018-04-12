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
 * CLASS      �� MemTypeModifySaveBean
 * VERSION    �� 0.1
 * DESC       :  ��Ա����޸ı���
 * DATE       �� 2010-09-11
 * AUTHOR     ��zhangqiang
 * HISTORY    �� 2010-09-11 ����
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

public class MemTypeModifySaveBean extends BusinessLogic{
      /**
       * ���캯��
       */
      public MemTypeModifySaveBean(){
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
            
            //���id
            String strTYPE_ID = StringUtil.getRequestData(request.getParameter("txtTYPE_ID"));
            // �������
            String strTYPE_NAME = StringUtil.getRequestData(request.getParameter("txtTYPE_NAME"));
            // Ժ���е�����
            String strPERCENT = StringUtil.getRequestData(request.getParameter("txtPERCENT"));
            // ��׼����
            String strSCORE = StringUtil.getRequestData(request.getParameter("txtSCORE"));
            
            // ��Ա�������Ψһ
			boolean b_flag1 = chkUniqTypeName(strTYPE_ID, strTYPE_NAME);
			// ��׼����Ψһ
			boolean b_flag2 = chkUniqScore(strTYPE_ID, strSCORE);
			if (b_flag1 && b_flag2) {
	        	sbSql.append("update t_memtype set ");
	            sbSql.append("       C_TYPENAME = '" + strTYPE_NAME + "',");
	            sbSql.append("       C_PERCENT = " + strPERCENT + ",");
	            sbSql.append("       C_SCORE = " + strSCORE );
	            sbSql.append(" where C_ID = " + strTYPE_ID );
	                
	
	            //�������ݿ����
	            int iRtn = conn.doTransaction(sbSql.toString());
	
	            //�жϲ�ѯ����Ƿ�ִ�гɹ�.
	            if (iRtn  == CommonConstants.CLDEF_DB_OK) {
	                //Ǩ���б���
	                String strURL = "MemTypeManage.do";
	
	                parameters.setParameters("results", "ForwardPage", strURL);
	            } else {
	                //Ǩ��ERROR����
	                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
	
	            }
			} else {
				if (!b_flag1) {
					// ��ʾ��Ϣ
					String str_ErrMsg = "��Ա������ƣ�" + strTYPE_NAME + "�Ѵ��ڣ�������¼�룡";
					// ���õ�request��
					request.setAttribute("pop_Msg", str_ErrMsg);
					// ����Ǩ�ƻ���
					String str_URL = "MemTypeModify.do?type_id=" + strTYPE_ID;
					// ����Ǩ��
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
				if (!b_flag2) {
					// ��ʾ��Ϣ
					String str_ErrMsg = "��׼���֣�" + strSCORE + "�Ѵ��ڣ�������¼�룡";
					// ���õ�request��
					request.setAttribute("pop_Msg", str_ErrMsg);
					// ����Ǩ�ƻ���
					String str_URL = "MemTypeModify.do?type_id=" + strTYPE_ID;
					// ����Ǩ��
					parameters.setParameters("results", "ForwardPage", str_URL);
				}
			}
        }
        catch(Exception ex){
            System.out.println("MemTypeModifySaveBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

      }
      /**
       * ҳ�����⴦�����
       */
      public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
      }
      
    /**
  	 * У���Ա�������Ψһ��
  	 * 
  	 * @param strID
  	 * @param strTypeName
  	 * @return
  	 */
  	private boolean chkUniqTypeName(String strID, String strTypeName) {
  		boolean b_flag = true;
  		DBOperate conn = new DBOperate();
  		ResultObj res1 = new ResultObj();
  		StringBuffer sb = new StringBuffer();
  		sb.append("SELECT t_memtype.C_ID ");
  		sb.append("FROM t_memtype ");
  		sb.append("WHERE t_memtype.C_TYPENAME = '" + strTypeName + "' ");
  		sb.append("AND t_memtype.C_ID <> " + strID + " ");

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
  	 * @param strID
  	 * @param strScore
  	 * @return
  	 */
  	private boolean chkUniqScore(String strID, String strScore) {
  		boolean b_flag = true;
  		DBOperate conn = new DBOperate();
  		ResultObj res1 = new ResultObj();
  		StringBuffer sb = new StringBuffer();
  		sb.append("SELECT t_memtype.C_ID ");
  		sb.append("FROM t_memtype ");
  		sb.append("WHERE t_memtype.C_SCORE = " + strScore + " ");
  		sb.append("AND t_memtype.C_ID <> " + strID + " ");

  		res1 = conn.Query(sb.toString());
  		// ����һ����¼���뵱ǰ�Һű����ͬ
  		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
  			b_flag = false;
  		}
  		// ����
  		return b_flag;
  	}
}
