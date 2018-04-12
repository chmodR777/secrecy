package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class UserManageBean extends BusinessLogic{
	/**
     * ���캯��
     */
    public UserManageBean(){
       if(CommonConstants.CLDEF_DEBUG){
          System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
       }
    }
	
    /**
     * ҵ���߼��������
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
    	//���������
        ResultObj res = new ResultObj();
        RowSet rs = new RowSet();
        //���ݿ����Ӷ���
        DBOperate conn = new DBOperate();
        
        // ��ǰҳ��
        int i_CurPage = 1;
        // ÿҳ��¼��
        int i_PageSize = 10;	
        
        try{
        	// ÿҳ��¼��
            String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String
                    .valueOf(CommonConstants.CLEDF_MAX_PAGE));
            i_PageSize = Integer.parseInt(str_PageSize);
            // ȡ�õ�ǰҳ��
            String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
            i_CurPage = Integer.parseInt(str_CurPage);
        	
        	//��ѯ����-�˺�
        	String p_UserCode = StringUtil.getRequestData(request.getParameter("txtUserCode"),"");
        	//��ѯ����-����
        	String p_UserName = StringUtil.getRequestData(request.getParameter("txtUserName"),"");
        	//��ѯ����-�Ա�
        	String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"),"");
        	//��ѯ����-��ϵ�绰
        	String p_Tel = StringUtil.getRequestData(request.getParameter("txtTel"),"");
        	//��ѯ����-������֯
        	String p_Org = StringUtil.getRequestData(request.getParameter("txtOrg"),"");
        	//��ѯ����-��ע
        	String p_Remark = StringUtil.getRequestData(request.getParameter("txtRemark"),"");
        	
        	//���sql���
            StringBuffer sb_SQL = new StringBuffer();
            sb_SQL.append("select a.C_ID,");
            sb_SQL.append("       a.C_NAME,a.C_CODE,");
            sb_SQL.append("       a.C_SEX,a.C_TEL,");
            sb_SQL.append("       a.C_ROLETYPE,");
            sb_SQL.append("       o.C_NAME C_ORG,a.C_REMARK ");
            sb_SQL.append("  from t_user a left join t_org o on a.C_ORG_ID = o.C_ID ");
            sb_SQL.append(" where 1=1 ");
            if(!"".equals(p_UserCode)){
            	sb_SQL.append(" and C_CODE like '%"+p_UserCode+"%'");
            }
            if(!"".equals(p_UserName)){
            	sb_SQL.append(" and C_NAME like '%"+p_UserName+"%'");
            }
            if(!"".equals(p_Sex)){
            	sb_SQL.append(" and C_SEX = '"+p_Sex+"'");
            }
            if(!"".equals(p_Tel)){
            	sb_SQL.append(" and C_TEL like '%"+p_Tel+"%'");
            }
            if(!"".equals(p_Org)){
            	sb_SQL.append(" and a.C_ORG_ID = "+p_Org);
            }
            if(!"".equals(p_Remark)){
            	sb_SQL.append(" and C_REMARK like '%"+p_Remark+"%'");
            }
            
            // ����sql
            rs.setSql(sb_SQL.toString());
            // ����ÿҳ��¼����
            rs.setPageSize(i_PageSize);
            // ��ѯָ��ҳ��¼
            res = rs.goPage(i_CurPage);
            
            //ִ�в�ѯ
            res = conn.Query(sb_SQL.toString());
            
            //�Ƿ��ѯ�ɹ�
            //CLDEF_DB_OK   0��ȫ�������������������鵽��¼
            //CLDEF_DB_OK2  1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
            if(CommonConstants.CLDEF_DB_OK <= res.getStatus()){
            	Common common = new Common();
            	//�����ܼ�¼��
            	parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
            	//����ÿҳ��¼��
                parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
                // ���õ�ǰҳ���б��ҳ��ز�����
                parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));
            	
                //����������浽request��
                request.setAttribute("res",res);
                
                // ��ȡ��֯�����б�
				String orgOptionList = common.getOrgOptionList(p_Org);
				request.setAttribute("orgOptionList", orgOptionList);
                
                //����Ǩ���׻���
                String str_URL = "/app/system/user_manage.jsp";
                //����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
                //Ǩ�Ƶ�������
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);           
            }
            
        }catch(Exception ex){
            System.out.println("UserManageBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }
	
	/**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
    }
}
