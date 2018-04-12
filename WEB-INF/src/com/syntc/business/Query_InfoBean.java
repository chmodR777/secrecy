package com.syntc.business;

import java.util.Map;

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

public class Query_InfoBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public Query_InfoBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		//���������
        ResultObj res = new ResultObj();
        RowSet rs = new RowSet();
        //���ݿ����Ӷ���
        DBOperate conn = new DBOperate();
        
        //��ȡ��������
       Common com = new Common(); 
       
        
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
        	
        	//��ѯ����-��Ա���
        	String p_USER_ID = StringUtil.getRequestData(request.getParameter("USER_ID"),"");
        	//��ѯ����-����
        	String p_User_Name = StringUtil.getRequestData(request.getParameter("User_Name"),"");
        	//��ѯ����-�Ա�
        	String p_USER_Sex = StringUtil.getRequestData(request.getParameter("USER_Sex"),"");
        	//��ѯ����-�ֻ�
        	String p_USER_Mobile = StringUtil.getRequestData(request.getParameter("User_Mobile"),"");
        	//��ѯ����-��ͥסַʡ
        	String p_User_PROVINCE = StringUtil.getRequestData(request.getParameter("User_PROVINCE"),"");
        	//��ѯ����-��ͥסַ��
        	String p_User_CITY = StringUtil.getRequestData(request.getParameter("User_CITY"),"");
        	//��ѯ����-ý�巽ʽ
        	String p_USER_Media = StringUtil.getRequestData(request.getParameter("USER_Media"),"");
        	//��ѯ����-���֤��
        	String p_User_Card = StringUtil.getRequestData(request.getParameter("User_Card"),"");
        	//��ѯ����-��ͬ��λ
        	String p_User_Depart = StringUtil.getRequestData(request.getParameter("User_Depart"),"");
        	//��ѯ����-��Ա���
        	String p_USER_Type = StringUtil.getRequestData(request.getParameter("USER_Type"),"");
        	//��ѯ����-�ۼƻ�����ʼ
        	String p_User_Sunm_Beg = StringUtil.getRequestData(request.getParameter("User_Sunm_Beg"),"");
        	//��ѯ����-�ۼƻ��ֽ���
        	String p_User_Sunm_End = StringUtil.getRequestData(request.getParameter("User_Sunm_End"),"");
        	//��ѯ����-�Һű��
        	String p_Ill_ID = StringUtil.getRequestData(request.getParameter("Ill_ID"),"");
        	//��ѯ����-�������
        	String p_ILL_Type = StringUtil.getRequestData(request.getParameter("ILL_Type"),"");
        	//��ѯ����-��������ʼ
        	String p_User_Money_From = StringUtil.getRequestData(request.getParameter("User_Money_From"),"");
        	//��ѯ����-���������
        	String p_User_Money_To = StringUtil.getRequestData(request.getParameter("User_Money_To"),"");
        	//��ѯ����-Ժ��������ʼ
        	String p_User_Hos_From = StringUtil.getRequestData(request.getParameter("User_Hos_From"),"");
        	//��ѯ����-Ժ����������
        	String p_User_Hos_To = StringUtil.getRequestData(request.getParameter("User_Hos_To"),"");
        	//��ѯ����-���λ�����ʼ
        	String p_User_Single_From = StringUtil.getRequestData(request.getParameter("User_Single_From"),"");
        	//��ѯ����-���λ��ֽ���
        	String p_User_Single_To = StringUtil.getRequestData(request.getParameter("User_Single_To"),"");
        	//��ѯ����-����
        	String p_User_ILL = StringUtil.getRequestData(request.getParameter("User_ILL"),"");
        	//��ѯ����-����ʱ����ʼ
        	String p_User_DATE_From = StringUtil.getRequestData(request.getParameter("User_DATE_From"),"");
        	//��ѯ����-����ʱ�����
        	String p_User_DATE_To = StringUtil.getRequestData(request.getParameter("User_DATE_To"),"");
        	//��ѯ����-����
			String p_User_Age_From = StringUtil.getRequestData(request.getParameter("User_Age_From"), "");
			String p_User_Age_To = StringUtil.getRequestData(request.getParameter("User_Age_To"), "");
        	
        	//���sql���
            StringBuffer sb_SQL = new StringBuffer();
            sb_SQL.append(" SELECT * FROM ");
            sb_SQL.append("       (SELECT MEN.* ,T_ILL.C_CODE,T_ILL.C_DATE,T_ILL.C_ILL AS ILL,T_ILL.C_MONEY, ROUND(T_ILL.C_MONEY) AS S_MONEY , T_ILL.C_PERCENT,T_ILL.C_TYPE, t_memtype.C_TYPENAME FROM ");
            sb_SQL.append("       (select * from ");
            sb_SQL.append("       t_patient MAIN ");
            sb_SQL.append("       LEFT JOIN  (SELECT C_PATIENTID,SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS MONEY FROM ");
            sb_SQL.append("       t_ill GROUP BY C_PATIENTID) SUMMON  ");
            sb_SQL.append("       ON MAIN.c_id=SUMMON.C_PATIENTID ) MEN  ");
            sb_SQL.append("       LEFT JOIN t_ill  ");
            sb_SQL.append("       ON MEN.C_ID = t_ill.C_PATIENTID ");
            sb_SQL.append("       LEFT JOIN t_memtype ");
            sb_SQL.append("       ON MEN.C_MEMTYPE = t_memtype.C_ID)ALlMSG  ");
            sb_SQL.append("       WHERE   ");
            sb_SQL.append("  1=1  ");
            if(!"".equals(p_USER_ID)){
            	sb_SQL.append(" and ALlMSG.C_MEMCODE like '%"+p_USER_ID+"%'");
            }
            if(!"".equals(p_User_Name)){
            	sb_SQL.append(" and ALlMSG.C_NAME like '%"+p_User_Name+"%'");
            }
            if(!"".equals(p_USER_Sex)){
            	sb_SQL.append(" and ALlMSG.C_SEX = "+p_USER_Sex);
            }
            if(!"".equals(p_USER_Mobile)){
            	sb_SQL.append(" and ALlMSG.C_MOBILE like '%"+p_USER_Mobile+"%'");
            }
            if(!"".equals(p_User_PROVINCE)){
            	sb_SQL.append(" and ALlMSG.C_PROVINCE = "+p_User_PROVINCE);
            }
            if(!"".equals(p_User_CITY)){
            	sb_SQL.append(" and ALlMSG.C_CITY = "+p_User_CITY);
            }
            if(!"".equals(p_USER_Media)){
            	sb_SQL.append(" and ALlMSG.C_MEDIATYPE = "+p_USER_Media);
            }
            if(!"".equals(p_User_Card)){
            	sb_SQL.append(" and ALlMSG.C_IDCARD like '%"+p_User_Card+"%'");
            }
            if(!"".equals(p_User_Depart)){
            	sb_SQL.append(" and ALlMSG.C_COMPANY = "+p_User_Depart);
            }
            if(!"".equals(p_USER_Type)){
            	sb_SQL.append(" and ALlMSG.C_MEMTYPE = "+p_USER_Type);
            }
            if(!"".equals(p_Ill_ID)){
            	sb_SQL.append(" and ALlMSG.C_CODE like '%"+p_Ill_ID+"%'");
            }
            if(!"".equals(p_ILL_Type)){
            	sb_SQL.append(" and ALlMSG.C_TYPE = "+p_ILL_Type);
            }
            if(!"".equals(p_User_Money_From)){
            	sb_SQL.append(" and ALlMSG.C_MONEY >= "+p_User_Money_From);
            }
            if(!"".equals(p_User_Money_To)){
            	sb_SQL.append(" and ALlMSG.C_MONEY <= "+p_User_Money_To);
            }
            if(!"".equals(p_User_Hos_From)){
            	sb_SQL.append(" and ALlMSG.C_PERCENT >= "+p_User_Hos_From);
            }
            if(!"".equals(p_User_Hos_To)){
            	sb_SQL.append(" and ALlMSG.C_PERCENT <= "+p_User_Hos_To);
            }
            if(!"".equals(p_User_ILL)){
            	sb_SQL.append(" and ALlMSG.ILL like '%"+p_User_ILL+"%'");
            }
            
            if(!"".equals(p_User_DATE_From)){
            	sb_SQL.append(" and ALlMSG.C_DATE >= '"+p_User_DATE_From+"'");
            }
            
            if(!"".equals(p_User_DATE_To)){
            	sb_SQL.append(" and ALlMSG.C_DATE <= '"+p_User_DATE_To+"'");
            }
            
            if(!"".equals(p_User_Sunm_Beg)){
            	sb_SQL.append(" and ALlMSG.MONEY >= "+p_User_Sunm_Beg);
            }
            
            if(!"".equals(p_User_Sunm_End)){
            	sb_SQL.append(" and ALlMSG.MONEY <= "+p_User_Sunm_End);
            }
            
            if(!"".equals(p_User_Single_From)){
            	sb_SQL.append(" and ALlMSG.S_MONEY >= "+p_User_Single_From);
            }
            
            if(!"".equals(p_User_Single_To)){
            	sb_SQL.append(" and ALlMSG.S_MONEY <= "+p_User_Single_To);
            }
            
            if (p_User_Age_From.length() > 0) {
				sb_SQL.append("AND ALlMSG.C_AGE >= " + p_User_Age_From + " ");
			}
			if (p_User_Age_To.length() > 0) {
				sb_SQL.append("AND ALlMSG.C_AGE <= " + p_User_Age_To + " ");
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
            	//�����ܼ�¼��
            	parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
            	//����ÿҳ��¼��
                parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
                // ���õ�ǰҳ���б��ҳ��ز�����
                parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));
            	
                //����������浽request��
                request.setAttribute("res",res);
                
                Map optionItemMap = com.getOptionItemMap("sex,mediaType,company,province,city,hosType");
				request.setAttribute("optionItemMap", optionItemMap);
				
				
				// ��ȡ��Ա��������б�
				String p_ILL_TypeOptionList = com.getHosTypeOptionList(p_ILL_Type);
				request.setAttribute("p_ILL_TypeOptionList", p_ILL_TypeOptionList);
				// ��ȡ��Ա��������б�
				String memTypeOptionList = com.getMemTypeOptionList(p_USER_Type);
				request.setAttribute("memTypeOptionList", memTypeOptionList);
				// ��ȡ�Ա������б�
				String sexOptionList = com.getSexOptionList(p_USER_Sex);
				request.setAttribute("sexOptionList", sexOptionList);
				// ��ȡý�巽ʽ�����б�
				String mediaTypeOptionList = com.getMediaTypeOptionList(p_USER_Media);
				request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
				// ��ȡ��ͬ��λ�����б�
				String companyOptionList = com.getCompanyOptionList(p_User_Depart);
				request.setAttribute("companyOptionList", companyOptionList);
				// ��ȡ���ڵ���-ʡ�����б�
				String provinceOptionList = com.getProvinceOptionList(p_User_PROVINCE);
				request.setAttribute("provinceOptionList", provinceOptionList);
				// ��ȡ���ڵ���-�������б�
				String cityOptionList = "";
				if (p_User_PROVINCE.length() > 0) {
					cityOptionList = com.getCityOptionList(p_User_PROVINCE, p_User_CITY);
				}
				request.setAttribute("cityOptionList", cityOptionList);
				
				// ��ȡʡ��Map
				Map provinceCityMap = com.getProvinceCityMap();
				request.setAttribute("provinceCityMap", provinceCityMap);
                
				
				 //ִ�в�ѯ
	            res = conn.Query(sb_SQL.toString());
                
                //����Ǩ���׻���
                String str_URL = "/app/system/query_user.jsp";
                //����Ǩ��
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
                //Ǩ�Ƶ�������
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);           
            }
            
        }catch(Exception ex){
            System.out.println("Query_InfoBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}

}