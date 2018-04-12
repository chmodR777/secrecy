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
import org.apache.poi.ss.util.Region;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class IllExportBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public IllExportBean() {
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
		ResultObj res_patient = new ResultObj();
		// ���ݿ����Ӷ���
		DBOperate conn = new DBOperate();

		String p_PatientID = StringUtil.getRequestData(request.getParameter("patient_id"));
		
		try {
			// SQL��Ŷ���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_patient.C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME, ");
			sb_SQL.append("t_patient.C_SEX, ");
			sb_SQL.append("t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, ");
			sb_SQL.append("t_patient.C_MEMTYPE, ");
			sb_SQL.append("t_memtype.C_TYPENAME AS C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD AS C_IDCARD, ");
			sb_SQL.append("SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS TOTALSCORE ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("LEFT JOIN t_ill ");
			sb_SQL.append("ON t_patient.C_ID = t_ill.C_PATIENTID ");
			sb_SQL.append("LEFT JOIN t_memtype ");
			sb_SQL.append("ON t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("WHERE t_patient.C_ID = " + p_PatientID + " ");
			sb_SQL.append("GROUP BY t_patient.C_ID, ");
			sb_SQL.append("t_patient.C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME, ");
			sb_SQL.append("t_patient.C_SEX, ");
			sb_SQL.append("t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, ");
			sb_SQL.append("t_patient.C_MEMTYPE, ");
			sb_SQL.append("t_memtype.C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD ");

			// ִ�в�ѯ
			res_patient = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("IllExportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

		try {
			// ��ѯ����-�Һű��
			String p_Code = StringUtil.getRequestData(request.getParameter("txtCode"), "");
			// ��ѯ����-�������
			String p_Type = StringUtil.getRequestData(request.getParameter("txtType"), "");
			// ��ѯ����-������
			String p_MoneyMin = StringUtil.getRequestData(request.getParameter("txtMoneyMin"), "");
			String p_MoneyMax = StringUtil.getRequestData(request.getParameter("txtMoneyMax"), "");
			// ��ѯ����-����ʱ��
			String p_DateMin = StringUtil.getRequestData(request.getParameter("txtDateMin"), "");
			String p_DateMax = StringUtil.getRequestData(request.getParameter("txtDateMax"), "");
			// ��ѯ����-Ժ���е�����
			String p_PercentMin = StringUtil.getRequestData(request.getParameter("txtPercentMin"), "");
			String p_PercentMax = StringUtil.getRequestData(request.getParameter("txtPercentMax"), "");
			// ��ѯ����-����
			String p_ScoreMin = StringUtil.getRequestData(request.getParameter("txtScoreMin"), "");
			String p_ScoreMax = StringUtil.getRequestData(request.getParameter("txtScoreMax"), "");
			// ��ѯ����-����
			String p_Ill = StringUtil.getRequestData(request.getParameter("txtIll"), "");

			// ���sql���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * FROM (");
			sb_SQL.append("SELECT t_ill.C_ID as C_ID, ");
			sb_SQL.append("t_ill.C_CODE as C_CODE, ");
			sb_SQL.append("t_ill.C_TYPE as C_TYPE, ");
			sb_SQL.append("t_ill.C_MONEY as C_MONEY, ");
			sb_SQL.append("t_ill.C_DATE as C_DATE, ");
			sb_SQL.append("t_ill.C_PERCENT as C_PERCENT, ");
			sb_SQL.append("CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END AS SCORE, ");
			sb_SQL.append("t_ill.C_ILL as C_ILL, ");
			sb_SQL.append("t_user.C_NAME as USERNAME, ");
			sb_SQL.append("t_ill.C_OPERTIME as C_OPERTIME ");
			sb_SQL.append("FROM t_ill ");
			sb_SQL.append("LEFT JOIN t_user ");
			sb_SQL.append("ON t_ill.C_OPERATOR = t_user.C_ID ");
			sb_SQL.append("WHERE t_ill.C_PATIENTID = " + p_PatientID);
			if (p_Code.length() > 0) {
				sb_SQL.append(" AND t_ill.C_CODE like '%" + p_Code + "%'");
			}
			if (p_Type.length() > 0) {
				sb_SQL.append(" AND t_ill.C_TYPE = " + p_Type);
			}
			if (p_MoneyMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_MONEY >= " + p_MoneyMin);
			}
			if (p_MoneyMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_MONEY <= " + p_MoneyMax);
			}
			if (p_DateMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_DATE >= '" + p_DateMin + "' ");
			}
			if (p_DateMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_DATE <= '" + p_DateMax + "' ");
			}
			if (p_PercentMin.length() > 0) {
				sb_SQL.append(" AND t_ill.C_PERCENT >= " + p_PercentMin);
			}
			if (p_PercentMax.length() > 0) {
				sb_SQL.append(" AND t_ill.C_PERCENT <= " + p_PercentMax);
			}
			if (p_Ill.length() > 0) {
				sb_SQL.append(" AND t_ill.C_ILL like '%" + p_Ill + "%'");
			}
			sb_SQL.append(") t_info ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_ScoreMin.length() > 0) {
				sb_SQL.append("AND t_info.SCORE >= " + p_ScoreMin + " ");
			}
			if (p_ScoreMax.length() > 0) {
				sb_SQL.append("AND t_info.SCORE <= " + p_ScoreMax + " ");
			}

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			// �Ƿ��ѯ�ɹ�
			// CLDEF_DB_OK 0��ȫ�������������������鵽��¼
			// CLDEF_DB_OK2 1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city,hosType");
				int rowNum = 0;
				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet();
				
				HSSFCellStyle contentStyle = workBook.createCellStyle();
				contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		        contentStyle.setWrapText(true);

		        HSSFCellStyle titleStyle = workBook.createCellStyle();
		        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        HSSFFont titleFont = workBook.createFont();
		        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        titleStyle.setFont(titleFont);
		        
		        HSSFCellStyle headerStyle = workBook.createCellStyle();
		        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        headerStyle.setFont(titleFont);
				
				sheet.setColumnWidth(0, 5000);
				sheet.setColumnWidth(1, 2500);
				sheet.setColumnWidth(2, 3000);
				sheet.setColumnWidth(3, 3000);
				sheet.setColumnWidth(4, 4000);
				sheet.setColumnWidth(5, 3000);
				sheet.setColumnWidth(6, 10000);
				sheet.setColumnWidth(7, 5000);
				sheet.setColumnWidth(8, 4500);
				
				sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum, (short) 8));
				HSSFRow row = sheet.createRow(rowNum);
				HSSFCell cell = row.createCell(0);
				cell.setCellValue("������Ϣ");
		        cell.setCellStyle(headerStyle);
				rowNum = rowNum + 1;
				
				//��Ա���
				String str_MemCode = StringUtil.convertNull(res_patient.getCell("C_MEMCODE", 1));
				//����
				String str_Name = StringUtil.convertNull(res_patient.getCell("C_NAME", 1));
				//�Ա�
				String str_Sex = StringUtil.convertNull(res_patient.getCell("C_SEX", 1));
				if (str_Sex.length() > 0) {
					if (optionItemMap.containsKey(str_Sex)) {
						str_Sex = (String) optionItemMap.get(str_Sex);
					} else {
						str_Sex = "";
					}
				}
				//����
				String str_Age = StringUtil.convertNull(res_patient.getCell("C_AGE", 1));
				//���ڵ���
				String str_Province = StringUtil.convertNull(res_patient.getCell("C_PROVINCE", 1));
				String str_City = StringUtil.convertNull(res_patient.getCell("C_CITY", 1));
				String str_Area = "";
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
				String str_Mobile = StringUtil.convertNull(res_patient.getCell("C_MOBILE", 1));
				//ý�巽ʽ
				String str_MediaType = StringUtil.convertNull(res_patient.getCell("C_MEDIATYPE", 1));
				if (str_MediaType.length() > 0) {
					if (optionItemMap.containsKey(str_MediaType)) {
						str_MediaType = (String) optionItemMap.get(str_MediaType);
					} else {
						str_MediaType = "";
					}
				}
				//��ͬ��λ
				String str_Company = StringUtil.convertNull(res_patient.getCell("C_COMPANY", 1));
				if (str_Company.length() > 0) {
					if (optionItemMap.containsKey(str_Company)) {
						str_Company = (String) optionItemMap.get(str_Company);
					} else {
						str_Company = "";
					}
				}
				//��Ա���
				String str_MemType = StringUtil.convertNull(res_patient.getCell("C_TYPENAME", 1));
				//���֤��
				String str_IDCard = StringUtil.convertNull(res_patient.getCell("C_IDCARD", 1));
				//�ۼƻ���
				String str_TotalScore = common.removeTailZero(StringUtil.convertNull(res_patient.getCell("TOTALSCORE", 1)));
				
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short) 4));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum, (short) 8));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("��Ա��ţ�");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(1);
				cell.setCellValue(str_MemCode);
		        cell.setCellStyle(contentStyle);
		        cell = row.createCell(5);
				cell.setCellValue("������");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(6);
				cell.setCellValue(str_Name);
		        cell.setCellStyle(contentStyle);
				rowNum = rowNum + 1;
				
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short) 4));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum, (short) 8));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("�Ա�");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(1);
				cell.setCellValue(str_Sex);
		        cell.setCellStyle(contentStyle);
		        cell = row.createCell(5);
				cell.setCellValue("���䣺");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(6);
				cell.setCellValue(str_Age);
		        cell.setCellStyle(contentStyle);
				rowNum = rowNum + 1;
				
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short) 4));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum, (short) 8));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("���ڵ�����");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(1);
				cell.setCellValue(str_Area);
		        cell.setCellStyle(contentStyle);
		        cell = row.createCell(5);
				cell.setCellValue("�ֻ���");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(6);
				cell.setCellValue(str_Mobile);
		        cell.setCellStyle(contentStyle);
				rowNum = rowNum + 1;
				
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short) 4));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum, (short) 8));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("ý�巽ʽ��");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(1);
				cell.setCellValue(str_MediaType);
		        cell.setCellStyle(contentStyle);
		        cell = row.createCell(5);
				cell.setCellValue("��ͬ��λ��");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(6);
				cell.setCellValue(str_Company);
		        cell.setCellStyle(contentStyle);
				rowNum = rowNum + 1;
				
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short) 4));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum, (short) 8));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("��Ա���");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(1);
				cell.setCellValue(str_MemType);
		        cell.setCellStyle(contentStyle);
		        cell = row.createCell(5);
				cell.setCellValue("���֤�ţ�");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(6);
				cell.setCellValue(str_IDCard);
		        cell.setCellStyle(contentStyle);
				rowNum = rowNum + 1;
				
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short) 4));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("�ۼƻ��֣�");
		        cell.setCellStyle(headerStyle);
		        cell = row.createCell(1);
				cell.setCellValue(str_TotalScore);
		        cell.setCellStyle(contentStyle);
				rowNum = rowNum + 2;
				
				sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum, (short) 8));
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue("������Ϣ�б�");
		        cell.setCellStyle(headerStyle);
				rowNum = rowNum + 1;
		        
				row = sheet.createRow(rowNum);
				cell = row.createCell(0);
		        cell.setCellValue("�Һű��");
		        cell.setCellStyle(titleStyle);

		        cell = row.createCell(1);
		        cell.setCellValue("�������");
		        cell.setCellStyle(titleStyle);

		        cell = row.createCell(2);
		        cell.setCellValue("������");
		        cell.setCellStyle(titleStyle);

		        cell = row.createCell(3);
		        cell.setCellValue("����ʱ��");
		        cell.setCellStyle(titleStyle);

		        cell = row.createCell(4);
		        cell.setCellValue("Ժ���е�����(%)");
		        cell.setCellStyle(titleStyle);
		        
		        cell = row.createCell(5);
		        cell.setCellValue("����");
		        cell.setCellStyle(titleStyle);
		        
		        cell = row.createCell(6);
		        cell.setCellValue("����");
		        cell.setCellStyle(titleStyle);
		        
		        cell = row.createCell(7);
		        cell.setCellValue("������");
		        cell.setCellStyle(titleStyle);
				
		        cell = row.createCell(8);
		        cell.setCellValue("����ʱ��");
		        cell.setCellStyle(titleStyle);
		        
		        rowNum = rowNum + 1;
		        String str_Code;
		        String str_Type;
		        String str_Money;
		        String str_Date;
		        String str_Percent;
		        String str_Score;
		        String str_Ill;
		        String str_UserName;
		        String str_OperTime;
		        if (res.size() > 1) {
		        	for (int i = 1; i < res.size(); i++) {
		        		//�Һű��
		        		str_Code = StringUtil.convertNull(res.getCell("C_CODE", i));
		        		//�������
		        		str_Type = StringUtil.convertNull(res.getCell("C_TYPE", i));
		        		if (str_Type.length() > 0) {
		        			if (optionItemMap.containsKey(str_Type)) {
		        				str_Type = (String) optionItemMap.get(str_Type);
		        			} else {
		        				str_Type = "";
		        			}
		        		}
		        		//������
		        		str_Money = StringUtil.convertNull(res.getCell("C_MONEY", i));
		        		if (str_Money.length() > 0) {
		        			str_Money = common.removeTailZero(str_Money);
		        		}
		        		//����ʱ��
		        		str_Date = StringUtil.convertNull(res.getCell("C_DATE", i));
		        		//Ժ���е�����(%)
		        		str_Percent = StringUtil.convertNull(res.getCell("C_PERCENT", i));
		        		if (str_Percent.length() > 0) {
		        			str_Percent = common.removeTailZero(str_Percent);
		        		}
		        		//����
		        		str_Score = common.removeTailZero(StringUtil.convertNull(res.getCell("SCORE", i)));
		        		//����
		        		str_Ill = StringUtil.convertNull(res.getCell("C_ILL", i));
		        		//������
		        		str_UserName = StringUtil.convertNull(res.getCell("USERNAME", i));
		        		//����ʱ��
		        		str_OperTime = StringUtil.convertNull(res.getCell("C_OPERTIME", i));
		        		if (str_OperTime.length() > 0) {
		        			str_OperTime = str_OperTime.substring(0, 19);
		        		}
		        		
		        		row = sheet.createRow(rowNum);
						cell = row.createCell(0);
				        cell.setCellValue(str_Code);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(1);
				        cell.setCellValue(str_Type);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(2);
				        cell.setCellValue(str_Money);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(3);
				        cell.setCellValue(str_Date);
				        cell.setCellStyle(contentStyle);

				        cell = row.createCell(4);
				        cell.setCellValue(str_Percent);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(5);
				        cell.setCellValue(str_Score);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(6);
				        cell.setCellValue(str_Ill);
				        cell.setCellStyle(contentStyle);
				        
				        cell = row.createCell(7);
				        cell.setCellValue(str_UserName);
				        cell.setCellStyle(contentStyle);
						
				        cell = row.createCell(8);
				        cell.setCellValue(str_OperTime);
				        cell.setCellStyle(contentStyle);
				        
				        rowNum = rowNum + 1;
		        	}
		        }
		        
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        workBook.write(outputStream);
		        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		        
				common.writeStreamToResponse("���߲�����Ϣ.xls", response, inputStream);
		        
		        outputStream.close();
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("IllExportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
