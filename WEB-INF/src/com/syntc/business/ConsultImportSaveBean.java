package com.syntc.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.common.upload.UploadUtil;
import com.syntc.common.upload.file;
import com.syntc.common.upload.files;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class ConsultImportSaveBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public ConsultImportSaveBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * ҵ���߼��������
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		try {

			
			UploadUtil myUpload = new UploadUtil();
			// ��ʼ������
			myUpload.initialize(request);
			// �趨������ļ���׺��
			myUpload.setAllowedExtList("xls");
			// �趨�Ƿ������Ƿ������ϵ�ͬ���ļ�
			myUpload.setIsCover(true);
			// �趨�����ļ���С������10M
			myUpload.setMaxFileSize(10 * 1024 * 1024);
			// �趨�ϴ�������·��
			String path = request.getSession().getServletContext() .getRealPath("/") + "chart\\";
			this.isChartPathExist(path);
			myUpload.setRealPath(path);

			// У���ļ���С
			// ���������ݵ�����������ݽṹ��
			myUpload.upload();
			
			// �õ��ϴ����ļ����˴��趨�ϴ��ļ�Ϊ1��
			files myFiles = myUpload.getFiles();

			file myFile = myFiles.getFile(0);
			// ���������ļ������������ڼ�Сʱ����
			String fileName = System.currentTimeMillis() + ".xls";
			myFile.setName(fileName);
			myFile.saveAs();
			
			String strMonth = StringUtil.getRequestData(request.getParameter("strMonth"));
			strMonth = strMonth.substring(0, 7);
			
			FileInputStream sourceFile = new FileInputStream(path + fileName);
			POIFSFileSystem fs = new POIFSFileSystem(sourceFile);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			
			//������Ϣ����ʽ
	        HSSFCellStyle errorInfoStyle = wb.createCellStyle();
	        HSSFFont errorInfoFont = wb.createFont();
	        errorInfoFont.setColor(HSSFColor.RED.index);
	        errorInfoFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        errorInfoStyle.setFont(errorInfoFont);
			
			Common common = new Common();
			HSSFSheet sheet = wb.getSheet("�Ա�");
			HSSFRow row;
			HSSFCell cell;
			String itemName;
			String itemID = "";
			String personNum;
			List list = new ArrayList();
			String[] datas;
			int error = 0;
			if (sheet != null) {
				Map sexMap = common.getOptionItemMap1("sex");
				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					cell = row.getCell(0);
					itemName = getCellValue(cell);
					if (itemName != null && itemName.length() > 0) {
						if (sexMap.containsKey(itemName)) {
							itemID = (String) sexMap.get(itemName);
						} else {
							error = error + 1;
			                cell = row.createCell(2);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						error = error + 1;
		                cell = row.createCell(2);
		                cell.setCellValue("�������ݴ���");
		                cell.setCellStyle(errorInfoStyle);
		                continue;
					}
					cell = row.getCell(1);
					personNum = getCellValue(cell);
					if (personNum != null && personNum.length() > 0) {
						if (personNum.matches("^\\d+(\\.0)?$")) {
							if (Integer.parseInt(personNum) == 0) {
								continue;
							}
						} else {
							error = error + 1;
			                cell = row.createCell(2);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						continue;
					}
					datas = new String[4];
					datas[0] = strMonth;
					datas[1] = "sex";
					datas[2] = itemID;
					datas[3] = personNum;
					list.add(datas);
				}
			}
			
			sheet = wb.getSheet("����");
			if (sheet != null) {
				Map ageMap = common.getOptionItemMap1("age");
				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					cell = row.getCell(0);
					itemName = getCellValue(cell);
					if (itemName != null && itemName.length() > 0) {
						if (ageMap.containsKey(itemName)) {
							itemID = (String) ageMap.get(itemName);
						} else {
							error = error + 1;
			                cell = row.createCell(2);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						error = error + 1;
		                cell = row.createCell(2);
		                cell.setCellValue("�������ݴ���");
		                cell.setCellStyle(errorInfoStyle);
		                continue;
					}
					cell = row.getCell(1);
					personNum = getCellValue(cell);
					if (personNum != null && personNum.length() > 0) {
						if (personNum.matches("^\\d+(\\.0)?$")) {
							if (Integer.parseInt(personNum) == 0) {
								continue;
							}
						} else {
							error = error + 1;
			                cell = row.createCell(2);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						continue;
					}
					datas = new String[4];
					datas[0] = strMonth;
					datas[1] = "age";
					datas[2] = itemID;
					datas[3] = personNum;
					list.add(datas);
				}
			}
			
			sheet = wb.getSheet("ý�巽ʽ");
			if (sheet != null) {
				Map mediaTypeMap = common.getOptionItemMap1("mediaType");
				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					cell = row.getCell(0);
					itemName = getCellValue(cell);
					if (itemName != null && itemName.length() > 0) {
						if (mediaTypeMap.containsKey(itemName)) {
							itemID = (String) mediaTypeMap.get(itemName);
						} else {
							error = error + 1;
			                cell = row.createCell(2);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						error = error + 1;
		                cell = row.createCell(2);
		                cell.setCellValue("�������ݴ���");
		                cell.setCellStyle(errorInfoStyle);
		                continue;
					}
					cell = row.getCell(1);
					personNum = getCellValue(cell);
					if (personNum != null && personNum.length() > 0) {
						if (personNum.matches("^\\d+(\\.0)?$")) {
							if (Integer.parseInt(personNum) == 0) {
								continue;
							}
						} else {
							error = error + 1;
			                cell = row.createCell(2);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						continue;
					}
					datas = new String[4];
					datas[0] = strMonth;
					datas[1] = "mediaType";
					datas[2] = itemID;
					datas[3] = personNum;
					list.add(datas);
				}
			}
			
			sheet = wb.getSheet("���ڵ���");
			if (sheet != null) {
				Map areaMap = common.getOptionItemMap1("province,city");
				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					cell = row.getCell(1);
					itemName = getCellValue(cell);
					if (itemName != null && itemName.length() > 0) {
						if (areaMap.containsKey(itemName)) {
							itemID = (String) areaMap.get(itemName);
						} else {
							error = error + 1;
			                cell = row.createCell(3);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						cell = row.getCell(0);
						itemName = getCellValue(cell);
						if (itemName != null && itemName.length() > 0) {
							if (areaMap.containsKey(itemName)) {
								itemID = (String) areaMap.get(itemName);
							} else {
								error = error + 1;
				                cell = row.createCell(3);
				                cell.setCellValue("�������ݴ���");
				                cell.setCellStyle(errorInfoStyle);
				                continue;
							}
						} else {							
							error = error + 1;
			                cell = row.createCell(3);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					}
					cell = row.getCell(2);
					personNum = getCellValue(cell);
					if (personNum != null && personNum.length() > 0) {
						if (personNum.matches("^\\d+(\\.0)?$")) {
							if (Integer.parseInt(personNum) == 0) {
								continue;
							}
						} else {
							error = error + 1;
			                cell = row.createCell(3);
			                cell.setCellValue("�������ݴ���");
			                cell.setCellStyle(errorInfoStyle);
			                continue;
						}
					} else {
						continue;
					}
					datas = new String[4];
					datas[0] = strMonth;
					datas[1] = "area";
					datas[2] = itemID;
					datas[3] = personNum;
					list.add(datas);
				}
			}
			
			File theFile = new File(path + fileName);
			theFile.delete();
			if (error > 0) {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				wb.write(outputStream);
		        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		        
				common.writeStreamToResponse("error.xls", response, inputStream);
		        
		        outputStream.close();
			} else {				
				// ���ݿ��������
				DBOperate conn = new DBOperate();
				Vector<String> vec = new Vector<String>();
				// SQL��Ŷ���
				StringBuffer sb_SQL = new StringBuffer();
				
				sb_SQL.append("DELETE FROM t_consult ");
				sb_SQL.append("WHERE C_MONTH = '" + strMonth + "' ");
				vec.add(sb_SQL.toString());
				
				for (int i = 0; i < list.size(); i++) {
					datas = (String[]) list.get(i);
					sb_SQL = new StringBuffer();
					sb_SQL.append("INSERT INTO t_consult(");
					sb_SQL.append("C_MONTH, C_ITEMTYPE, C_ITEMID, C_PERSONNUM) ");
					sb_SQL.append("VALUES(");
					sb_SQL.append("'" + datas[0] + "', ");
					sb_SQL.append("'" + datas[1] + "', ");
					sb_SQL.append(datas[2] + ", ");
					sb_SQL.append(datas[3] + ") ");
					vec.add(sb_SQL.toString());									
				}
				
				// �������ݿ����
				int i_Rtn = conn.doTransaction(vec);

				// �жϲ�ѯ����Ƿ�ִ�гɹ�
				if (i_Rtn == CommonConstants.CLDEF_DB_OK) {	
					// ����Ǩ�ƻ���
					String str_URL = "ConsultManage.do";
					// ����Ǩ��
					parameters.setParameters("results", "ForwardPage", str_URL);
				} else {
					// Ǩ�Ƶ�������
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

				}
			}
		} catch (Exception ex) {
			System.out.println("ConsultImportSaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
	
	/**
	 * ���ַ�����ʽ���ص�Ԫ���ֵ
	 */
	private String getCellValue(HSSFCell hssfCell) {
		DecimalFormat decimalFormater = new DecimalFormat("0.###############");
		String cellValue = "";
		if (hssfCell != null) {
			switch (hssfCell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
				cellValue = decimalFormater.format(hssfCell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_STRING:
				cellValue = hssfCell.getStringCellValue().trim();
				break;
			default:
				cellValue = "";
			}
		}
		return cellValue;
	}
	
	/**
     * ����洢ͼƬ·�������ڣ��򴴽�
     */
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    }
}