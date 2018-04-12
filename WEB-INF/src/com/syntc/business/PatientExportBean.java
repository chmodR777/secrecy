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

public class PatientExportBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientExportBean() {
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
		ResultObj res_memType = new ResultObj();
		// ���ݿ����Ӷ���
		DBOperate conn = new DBOperate();

		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_memtype.C_ID, ");
			sb_SQL.append("t_memtype.C_TYPENAME, ");
			sb_SQL.append("CASE WHEN t_memtype.C_SCORE IS NULL THEN 0 ELSE t_memtype.C_SCORE END AS SCORE ");
			sb_SQL.append("FROM t_memtype ");
			sb_SQL.append("ORDER BY t_memtype.C_SCORE DESC ");

			// ִ�в�ѯ
			res_memType = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("PatientExportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
		
		try {
			// ��ѯ����-��Ա���
			String p_MemCode = StringUtil.getRequestData(request.getParameter("txtMemCode"), "");
			// ��ѯ����-����
			String p_Name = StringUtil.getRequestData(request.getParameter("txtName"), "");
			// ��ѯ����-�Ա�
			String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"), "");
			// ��ѯ����-����
			String p_AgeMin = StringUtil.getRequestData(request.getParameter("txtAgeMin"), "");
			String p_AgeMax = StringUtil.getRequestData(request.getParameter("txtAgeMax"), "");
			// ��ѯ����-���ڵ���-ʡ
			String p_Province = StringUtil.getRequestData(request.getParameter("txtProvince"), "");
			// ��ѯ����-���ڵ���-��
			String p_City = StringUtil.getRequestData(request.getParameter("txtCity"), "");
			// ��ѯ����-�ֻ�
			String p_Mobile = StringUtil.getRequestData(request.getParameter("txtMobile"), "");
			// ��ѯ����-ý�巽ʽ
			String p_MediaType = StringUtil.getRequestData(request.getParameter("txtMediaType"), "");
			// ��ѯ����-��ͬ��λ
			String p_Company = StringUtil.getRequestData(request.getParameter("txtCompany"), "");
			// ��ѯ����-��Ա���
			String p_MemType = StringUtil.getRequestData(request.getParameter("txtMemType"), "");
			// ��ѯ����-���֤��
			String p_IDCard = StringUtil.getRequestData(request.getParameter("txtIDCard"), "");
			// ��ѯ����-�ۼƻ���
			String p_TotalScoreMin = StringUtil.getRequestData(request.getParameter("txtTotalScoreMin"), "");
			String p_TotalScoreMax = StringUtil.getRequestData(request.getParameter("txtTotalScoreMax"), "");

			// ���sql���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * FROM (");
			sb_SQL.append("SELECT t_patient.C_ID AS C_ID, ");
			sb_SQL.append("t_patient.C_MEMCODE AS C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME AS C_NAME, ");
			sb_SQL.append("t_patient.C_SEX AS C_SEX, ");
			sb_SQL.append("t_patient.C_AGE AS C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE AS C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY AS C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE AS C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE AS C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY AS C_COMPANY, ");
			sb_SQL.append("t_patient.C_MEMTYPE AS C_MEMTYPE, ");
			sb_SQL.append("t_memtype.C_TYPENAME AS C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD AS C_IDCARD, ");
			sb_SQL.append("SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS TOTALSCORE ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("LEFT JOIN t_ill ");
			sb_SQL.append("ON t_patient.C_ID = t_ill.C_PATIENTID ");
			sb_SQL.append("LEFT JOIN t_memtype ");
			sb_SQL.append("ON t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_MemCode.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEMCODE like '%" + p_MemCode + "%' ");
			}
			if (p_Name.length() > 0) {
				sb_SQL.append("AND t_patient.C_NAME like '%" + p_Name + "%' ");
			}
			if (p_Sex.length() > 0) {
				sb_SQL.append("AND t_patient.C_SEX = '" + p_Sex + "' ");
			}
			if (p_AgeMin.length() > 0) {
				sb_SQL.append("AND t_patient.C_AGE >= " + p_AgeMin + " ");
			}
			if (p_AgeMax.length() > 0) {
				sb_SQL.append("AND t_patient.C_AGE <= " + p_AgeMax + " ");
			}
			if (p_Province.length() > 0) {
				sb_SQL.append("AND t_patient.C_PROVINCE = '" + p_Province + "' ");
			}
			if (p_City.length() > 0) {
				sb_SQL.append("AND t_patient.C_CITY = '" + p_City + "' ");
			}
			if (p_Mobile.length() > 0) {
				sb_SQL.append("AND t_patient.C_MOBILE like '%" + p_Mobile + "%' ");
			}
			if (p_MediaType.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEDIATYPE = '" + p_MediaType + "' ");
			}
			if (p_Company.length() > 0) {
				sb_SQL.append("AND t_patient.C_COMPANY = '" + p_Company + "' ");
			}
			if (p_MemType.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEMTYPE = " + p_MemType + " ");
			}
			if (p_IDCard.length() > 0) {
				sb_SQL.append("AND t_patient.C_IDCARD like '%" + p_IDCard + "%' ");
			}
			sb_SQL.append("GROUP BY t_patient.C_MEMCODE, t_patient.C_NAME, t_patient.C_SEX, t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, t_patient.C_CITY, t_patient.C_MOBILE, t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, t_patient.C_MEMTYPE, t_memtype.C_TYPENAME, t_patient.C_IDCARD) t_info ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_TotalScoreMin.length() > 0) {
				sb_SQL.append("AND t_info.TOTALSCORE >= " + p_TotalScoreMin + " ");
			}
			if (p_TotalScoreMax.length() > 0) {
				sb_SQL.append("AND t_info.TOTALSCORE <= " + p_TotalScoreMax + " ");
			}

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			// �Ƿ��ѯ�ɹ�
			// CLDEF_DB_OK 0��ȫ�������������������鵽��¼
			// CLDEF_DB_OK2 1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city");

				int rowNum = 0;
				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet();
				
				HSSFCellStyle contentStyle = workBook.createCellStyle();
				contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		        contentStyle.setWrapText(true);

		        HSSFCellStyle titleStyle = workBook.createCellStyle();
		        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        titleStyle.setWrapText(true);
		        HSSFFont titleFont = workBook.createFont();
		        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        titleStyle.setFont(titleFont);
		        
		        sheet.setColumnWidth(0, 5000);
				sheet.setColumnWidth(1, 3000);
				sheet.setColumnWidth(2, 2000);
				sheet.setColumnWidth(3, 2000);
				sheet.setColumnWidth(4, 5000);
				sheet.setColumnWidth(5, 4000);
				sheet.setColumnWidth(6, 4000);
				sheet.setColumnWidth(7, 4000);
				sheet.setColumnWidth(8, 3000);
				sheet.setColumnWidth(9, 5500);
				sheet.setColumnWidth(10, 3000);
				sheet.setColumnWidth(11, 3000);
				sheet.setColumnWidth(12, 3000);
				
				HSSFRow row = sheet.createRow(rowNum);
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
		        cell.setCellValue("�Ƿ���Ҫ������Ա���");
		        cell.setCellStyle(titleStyle);
		        
		        cell = row.createCell(12);
		        cell.setCellValue("������Ļ�Ա���");
		        cell.setCellStyle(titleStyle);
		        
		        rowNum = rowNum + 1;
		        String str_MemCode;
		        String str_Name;
		        String str_Sex;
		        String str_Age;
		        String str_Province;
		        String str_City;
		        String str_Area;
		        String str_Mobile;
		        String str_MediaType;
		        String str_Company;
		        String str_MemType;
		        String str_TotalScore;
		        String str_IDCard;
		        String str_MediaTypeID;
		        boolean ajust = false;
		        String ajustMediaType = "";
		        String str_Score = "";
		        
		        if (res.size() > 1) {
		        	for (int i = 1; i < res.size(); i++) {
		        		ajust = false;
		        		
		        		//��Ա���
		        		str_MemCode = StringUtil.convertNull(res.getCell("C_MEMCODE", i));
		        		//����
		        		str_Name = StringUtil.convertNull(res.getCell("C_NAME", i));
		        		//�Ա�
		        		str_Sex = StringUtil.convertNull(res.getCell("C_SEX", i));
		        		if (str_Sex.length() > 0) {
		        			if (optionItemMap.containsKey(str_Sex)) {
		        				str_Sex = (String) optionItemMap.get(str_Sex);
		        			} else {
		        				str_Sex = "";
		        			}
		        		}
		        		//����
		        		str_Age = StringUtil.convertNull(res.getCell("C_AGE", i));
		        		//���ڵ���
		        		str_Province = StringUtil.convertNull(res.getCell("C_PROVINCE", i));
		        		str_City = StringUtil.convertNull(res.getCell("C_CITY", i));
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
		        		//�ֻ�
		        		str_Mobile = StringUtil.convertNull(res.getCell("C_MOBILE", i));
		        		//ý�巽ʽ
		        		str_MediaType = StringUtil.convertNull(res.getCell("C_MEDIATYPE", i));
		        		if (str_MediaType.length() > 0) {
		        			if (optionItemMap.containsKey(str_MediaType)) {
		        				str_MediaType = (String) optionItemMap.get(str_MediaType);
		        			} else {
		        				str_MediaType = "";
		        			}
		        		}
		        		//��ͬ��λ
		        		str_Company = StringUtil.convertNull(res.getCell("C_COMPANY", i));
		        		if (str_Company.length() > 0) {
		        			if (optionItemMap.containsKey(str_Company)) {
		        				str_Company = (String) optionItemMap.get(str_Company);
		        			} else {
		        				str_Company = "";
		        			}
		        		}
		        		//��Ա���
		        		str_MediaTypeID = StringUtil.convertNull(res.getCell("C_MEMTYPE", i));
		        		str_MemType = StringUtil.convertNull(res.getCell("C_TYPENAME", i));
		        		//���֤��
		        		str_IDCard = StringUtil.convertNull(res.getCell("C_IDCARD", i));
		        		//�ۼƻ���
		        		str_TotalScore = common.removeTailZero(StringUtil.convertNull(res.getCell("TOTALSCORE", i)));
		        		
		        		row = sheet.createRow(rowNum);
						cell = row.createCell(0);
				        cell.setCellValue(str_MemCode);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(1);
				        cell.setCellValue(str_Name);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(2);
				        cell.setCellValue(str_Sex);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(3);
				        cell.setCellValue(str_Age);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(4);
				        cell.setCellValue(str_Area);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(5);
				        cell.setCellValue(str_Mobile);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(6);
				        cell.setCellValue(str_MediaType);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(7);
				        cell.setCellValue(str_Company);
				        cell.setCellStyle(contentStyle);
						
				        cell = row.createCell(8);
				        cell.setCellValue(str_MemType);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(9);
				        cell.setCellValue(str_IDCard);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(10);
				        cell.setCellValue(str_TotalScore);
				        cell.setCellStyle(contentStyle);
				        
						if (res_memType.size() > 1) {
							for (int j = 1; j < res_memType.size(); j++) {
								str_Score = StringUtil.convertNull(res_memType.getCell("SCORE", j));
								if (Integer.parseInt(str_TotalScore) >= Integer.parseInt(str_Score)) {
									if (!str_MediaTypeID.equals(StringUtil.convertNull(res_memType.getCell("C_ID", j)))) {
										ajust = true;
										ajustMediaType = StringUtil.convertNull(res_memType.getCell("C_TYPENAME", j));
									}
									break;
								}
							}
						}
						if (ajust == true) {
							cell = row.createCell(11);
							cell.setCellValue("��");
							cell.setCellStyle(contentStyle);
							
							cell = row.createCell(12);
							cell.setCellValue(ajustMediaType + "(" + str_Score + ")");
							cell.setCellStyle(contentStyle);
						} else {
							cell = row.createCell(11);
							cell.setCellValue("��");
							cell.setCellStyle(contentStyle);
							
							cell = row.createCell(12);
							cell.setCellValue("");
							cell.setCellStyle(contentStyle);
						}
				        
				        rowNum = rowNum + 1;
		        	}
		        }
		        
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        workBook.write(outputStream);
		        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		        
				common.writeStreamToResponse("������Ϣ.xls", response, inputStream);
		        
		        outputStream.close();
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("PatientExportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
