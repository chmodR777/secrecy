package com.syntc.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class Query_DownloadBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public Query_DownloadBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// ���������
		ResultObj res = new ResultObj();
		// ���ݿ����Ӷ���
		DBOperate conn = new DBOperate();
	            
		try {
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
            sb_SQL.append("       (SELECT MEN.* ,T_ILL.C_CODE,T_ILL.C_DATE,T_ILL.C_ILL,T_ILL.C_MONEY, ROUND(T_ILL.C_MONEY) AS S_MONEY , T_ILL.C_PERCENT,T_ILL.C_TYPE, t_memtype.C_TYPENAME, t_ill.C_OPERTIME as C_OPERTIME, t_user.C_NAME as USERNAME FROM ");
            sb_SQL.append("       (select * from ");
            sb_SQL.append("       t_patient MAIN ");
            sb_SQL.append("       LEFT JOIN  (SELECT C_PATIENTID,SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS MONEY FROM ");
            sb_SQL.append("       t_ill GROUP BY C_PATIENTID) SUMMON  ");
            sb_SQL.append("       ON MAIN.c_id=SUMMON.C_PATIENTID ) MEN  ");
            sb_SQL.append("       LEFT JOIN t_ill  ");
            sb_SQL.append("       ON MEN.C_ID = t_ill.C_PATIENTID ");
            sb_SQL.append("       LEFT JOIN t_memtype ");
            sb_SQL.append("       ON MEN.C_MEMTYPE = t_memtype.C_ID ");
            sb_SQL.append("       LEFT JOIN t_user ");
            sb_SQL.append("       ON t_ill.C_OPERATOR = t_user.C_ID)ALlMSG  ");
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
			
			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());
			// �Ƿ��ѯ�ɹ�
			// CLDEF_DB_OK 0��ȫ�������������������鵽��¼
			// CLDEF_DB_OK2 1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common com = new Common();
				Map optionItemMap = com.getOptionItemMap("sex,mediaType,company,province,city,hosType");
			
				HSSFWorkbook wb = new HSSFWorkbook();
				
				HSSFCellStyle contentStyle = wb.createCellStyle();
				contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		        contentStyle.setWrapText(true);

		        HSSFCellStyle titleStyle = wb.createCellStyle();
		        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        titleStyle.setWrapText(true);
		        HSSFFont titleFont = wb.createFont();
		        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        titleStyle.setFont(titleFont);
		        
		        HSSFSheet s = wb.createSheet();
		        s.setColumnWidth(0, 5000);
				s.setColumnWidth(1, 3000);
				s.setColumnWidth(2, 2000);
				s.setColumnWidth(3, 2000);
				s.setColumnWidth(4, 5000);
				s.setColumnWidth(5, 4000);
				s.setColumnWidth(6, 4000);
				s.setColumnWidth(7, 4000);
				s.setColumnWidth(8, 3000);
				s.setColumnWidth(9, 5500);
				s.setColumnWidth(10, 3000);
				s.setColumnWidth(11, 5000);
				s.setColumnWidth(12, 2500);
				s.setColumnWidth(13, 3000);
				s.setColumnWidth(14, 3000);
				s.setColumnWidth(15, 4000);
				s.setColumnWidth(16, 3000);
				s.setColumnWidth(17, 10000);
				s.setColumnWidth(18, 5000);
				s.setColumnWidth(19, 4500);
		        
				HSSFRow row = s.createRow(0);
				HSSFCell cell = row.createCell(0);
				cell.setCellValue("��Ա���");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(1);
				cell.setCellValue("����");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(2);
				cell.setCellValue("�Ա�");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(3);
				cell.setCellValue("����");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(4);
				cell.setCellValue("���ڵ���");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(5);
				cell.setCellValue("�ֻ�");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(6);
				cell.setCellValue("ý�巽ʽ");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(7);
				cell.setCellValue("��ͬ��λ");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(8);
				cell.setCellValue("��Ա���");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(9);
				cell.setCellValue("���֤��");				
				cell.setCellStyle(titleStyle);
				cell = row.createCell(10);
				cell.setCellValue("�ۼƻ���");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(11);
				cell.setCellValue("�Һű��");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(12);
				cell.setCellValue("�������");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(13);
				cell.setCellValue("������");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(14);
				cell.setCellValue("����ʱ��");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(15);
				cell.setCellValue("Ժ���е�����(%)");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(16);
				cell.setCellValue("����");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(17);
				cell.setCellValue("����");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(18);
				cell.setCellValue("������");
				cell.setCellStyle(titleStyle);
				cell = row.createCell(19);
				cell.setCellValue("����ʱ��");
				cell.setCellStyle(titleStyle);
			
			
				int n = 1;
				String str_Sex;
				String str_Province;
				String str_City;
				String str_Area;
				String str_MediaType;
				String str_Company;
				String str_Type;
				String str_Money;
				String str_Percent;
				String str_OperTime;
				for (n = 1; n < res.size(); n++) {
					row = s.createRow(n);
					//��Ա���
					cell = row.createCell(0);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_MEMCODE", n)));
					cell.setCellStyle(contentStyle);
					//����
					cell = row.createCell(1);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_NAME", n)));
					cell.setCellStyle(contentStyle);
					//�Ա�
					cell = row.createCell(2);
					str_Sex = StringUtil.convertNull(res.getCell("C_SEX", n));
	        		if (str_Sex.length() > 0) {
	        			if (optionItemMap.containsKey(str_Sex)) {
	        				str_Sex = (String) optionItemMap.get(str_Sex);
	        			} else {
	        				str_Sex = "";
	        			}
	        		}
					cell.setCellValue(str_Sex);
					cell.setCellStyle(contentStyle);
					//����
					cell = row.createCell(3);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_AGE", n)));
					cell.setCellStyle(contentStyle);
					//���ڵ���
					cell = row.createCell(4);
					str_Province = StringUtil.convertNull(res.getCell("C_PROVINCE", n));
	        		str_City = StringUtil.convertNull(res.getCell("C_CITY", n));
	        		str_Area = "";
	        		if (str_Province != null && str_Province.length() > 0) {
	        			if (optionItemMap.containsKey(str_Province)) {
	        				str_Area = (String) optionItemMap.get(str_Province);
	        			}
	        		}
	        		if (str_City != null && str_City.length() > 0) {
	        			if (str_Area.length() > 0) {
	        				if (optionItemMap.containsKey(str_City)) {
	        					str_Area = str_Area + "-" + (String) optionItemMap.get(str_City);
	        				}
	        			}
	        		}
	        		cell.setCellValue(str_Area);
					cell.setCellStyle(contentStyle);
					//�ֻ�
					cell = row.createCell(5);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_MOBILE", n)));
					cell.setCellStyle(contentStyle);
					//ý�巽ʽ
					cell = row.createCell(6);
					str_MediaType = StringUtil.convertNull(res.getCell("C_MEDIATYPE", n));
	        		if (str_MediaType.length() > 0) {
	        			if (optionItemMap.containsKey(str_MediaType)) {
	        				str_MediaType = (String) optionItemMap.get(str_MediaType);
	        			} else {
	        				str_MediaType = "";
	        			}
	        		}
	        		cell.setCellValue(str_MediaType);
					cell.setCellStyle(contentStyle);
					//��ͬ��λ
					cell = row.createCell(7);
					str_Company = StringUtil.convertNull(res.getCell("C_COMPANY", n));
	        		if (str_Company.length() > 0) {
	        			if (optionItemMap.containsKey(str_Company)) {
	        				str_Company = (String) optionItemMap.get(str_Company);
	        			} else {
	        				str_Company = "";
	        			}
	        		}
	        		cell.setCellValue(str_Company);
					cell.setCellStyle(contentStyle);
					//��Ա���
					cell = row.createCell(8);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_TYPENAME", n)));
					cell.setCellStyle(contentStyle);
					//���֤��
					cell = row.createCell(9);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_IDCARD", n)));
					cell.setCellStyle(contentStyle);
					//�ۼƻ���
					cell = row.createCell(10);
					cell.setCellValue(com.removeTailZero(StringUtil.convertNull(res.getCell("MONEY", n))));
					cell.setCellStyle(contentStyle);
					//�Һű��
					cell = row.createCell(11);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_CODE", n)));
					cell.setCellStyle(contentStyle);
					//�������
					cell = row.createCell(12);
					str_Type = StringUtil.convertNull(res.getCell("C_TYPE", n));
	        		if (str_Type.length() > 0) {
	        			if (optionItemMap.containsKey(str_Type)) {
	        				str_Type = (String) optionItemMap.get(str_Type);
	        			} else {
	        				str_Type = "";
	        			}
	        		}
	        		cell.setCellValue(str_Type);
					cell.setCellStyle(contentStyle);
					//������
					cell = row.createCell(13);
					str_Money = StringUtil.convertNull(res.getCell("C_MONEY", n));
	        		if (str_Money.length() > 0) {
	        			str_Money = com.removeTailZero(str_Money);
	        		}
	        		cell.setCellValue(str_Money);
					cell.setCellStyle(contentStyle);
					//����ʱ��
					cell = row.createCell(14);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_DATE", n)));
					cell.setCellStyle(contentStyle);
					//Ժ���е�����(%)
					cell = row.createCell(15);
					str_Percent = StringUtil.convertNull(res.getCell("C_PERCENT", n));
	        		if (str_Percent.length() > 0) {
	        			str_Percent = com.removeTailZero(str_Percent);
	        		}
	        		cell.setCellValue(str_Percent);
					cell.setCellStyle(contentStyle);
					//����
					cell = row.createCell(16);
					cell.setCellValue(com.removeTailZero(StringUtil.convertNull(res.getCell("S_MONEY", n))));
					cell.setCellStyle(contentStyle);
					//����
					cell = row.createCell(17);
					cell.setCellValue(StringUtil.convertNull(res.getCell("C_ILL", n)));
					cell.setCellStyle(contentStyle);
					//������
					cell = row.createCell(18);
					cell.setCellValue(StringUtil.convertNull(res.getCell("USERNAME", n)));
					cell.setCellStyle(contentStyle);
					//����ʱ��
					cell = row.createCell(19);
					str_OperTime = StringUtil.convertNull(res.getCell("C_OPERTIME", n));
	        		if (str_OperTime.length() > 0) {
	        			str_OperTime = str_OperTime.substring(0, 19);
	        		}
	        		cell.setCellValue(str_OperTime);
					cell.setCellStyle(contentStyle);
				}
			
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        wb.write(outputStream);
		        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		        
				com.writeStreamToResponse("������Ϣ.xls", response, inputStream);
		        
		        outputStream.close();
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		}  catch (Exception ex) {
			System.out.println("Query_DownloadBean:" + ex.toString());
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