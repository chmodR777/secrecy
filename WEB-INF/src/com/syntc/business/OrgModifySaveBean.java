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

public class OrgModifySaveBean extends BusinessLogic{
      /**
       * ���캯��
       */
      public OrgModifySaveBean(){
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
            
            // ��֯id
            String strORG_ID = StringUtil.getRequestData(request.getParameter("txtORG_ID"));
            // ��֯����
            String strORG_NAME = StringUtil.getRequestData(request.getParameter("txtORG_NAME"));
            
            // ��֯����Ψһ
			boolean b_flag1 = chkUniqOrgName(strORG_ID, strORG_NAME);
			if (b_flag1) {
	        	sbSql.append("update t_org set C_NAME = '" + strORG_NAME + "' where C_ID = " + strORG_ID);
	                
	
	            //�������ݿ����
	            int iRtn = conn.doTransaction(sbSql.toString());
	
	            //�жϲ�ѯ����Ƿ�ִ�гɹ�.
	            if (iRtn  == CommonConstants.CLDEF_DB_OK) {
	                //Ǩ���б���
	                String strURL = "OrgManage.do";
	
	                parameters.setParameters("results", "ForwardPage", strURL);
	            } else {
	                //Ǩ��ERROR����
	                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
	            }
			} else {
				// ��ʾ��Ϣ
				String str_ErrMsg = "��֯���ƣ�" + strORG_NAME + "�Ѵ��ڣ�������¼�룡";
				// ���õ�request��
				request.setAttribute("pop_Msg", str_ErrMsg);
				// ����Ǩ�ƻ���
				String str_URL = "OrgModify.do?org_id=" + strORG_ID;
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
        }
        catch(Exception ex){
            System.out.println("OrgModifySaveBean:"+ex.toString());
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
  	 * @param strOrgName
  	 * @return
  	 */
  	private boolean chkUniqOrgName(String strID, String strOrgName) {
  		boolean b_flag = true;
  		DBOperate conn = new DBOperate();
  		ResultObj res1 = new ResultObj();
  		StringBuffer sb = new StringBuffer();
  		sb.append("SELECT t_org.C_ID ");
  		sb.append("FROM t_org ");
  		sb.append("WHERE t_org.C_NAME = '" + strOrgName + "' ");
  		sb.append("AND t_org.C_ID <> " + strID + " ");

  		res1 = conn.Query(sb.toString());
  		//
  		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
  			b_flag = false;
  		}
  		// ����
  		return b_flag;
  	}
}
