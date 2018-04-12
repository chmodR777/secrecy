package com.syntc.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class ConsultExportBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public ConsultExportBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		// 结果集对象
		ResultObj res = new ResultObj();
		// 数据库连接对象
		DBOperate conn = new DBOperate();
		// key-type  value-List(String[2] {itemID, itemName})
		Map optionItemMap = new HashMap();
		// key-itemID  value-personNum
		Map personNumMap = new HashMap();
		
		try {
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_optionitem.C_TYPE, ");
			sb_SQL.append("t_optionitem.C_ID, ");
			sb_SQL.append("t_optionitem.C_NAME ");
			sb_SQL.append("FROM t_optionitem ");
			sb_SQL.append("WHERE t_optionitem.C_TYPE IN ('sex', 'mediaType', 'age', 'province') ");
			sb_SQL.append("AND t_optionitem.C_STATUS = '1' ");
			sb_SQL.append("ORDER BY t_optionitem.C_TYPE, t_optionitem.C_ORDER ");

			// 执行查询
			res = conn.Query(sb_SQL.toString());

			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				if (res.size() > 1) {
					String type;
					String itemID;
					String itemName;
					List optionItemList;
					String[] optionItem;
		        	for (int i = 1; i < res.size(); i++) {
		        		type = StringUtil.convertNull(res.getCell("C_TYPE", i));
		        		itemID = StringUtil.convertNull(res.getCell("C_ID", i));
		        		itemName = StringUtil.convertNull(res.getCell("C_NAME", i));
		        		optionItemList = new ArrayList();
		        		if (optionItemMap.containsKey(type)) {
		        			optionItemList = (List) optionItemMap.get(type);
		        		}
		        		optionItem = new String[2];
		        		optionItem[0] = itemID;
		        		optionItem[1] = itemName;
		        		optionItemList.add(optionItem);
		        		optionItemMap.put(type, optionItemList);
		        	}
				}
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

			}
		} catch (Exception ex) {
			System.out.println("ConsultExportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
		
		try {
			String p_Month = StringUtil.getRequestData(request.getParameter("month"));

			// 存放sql语句
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT t_consult.C_ITEMID, ");
			sb_SQL.append("t_consult.C_PERSONNUM ");
			sb_SQL.append("FROM t_consult ");
			sb_SQL.append("WHERE t_consult.C_MONTH = '" + p_Month + "' ");

			// 执行查询
			res = conn.Query(sb_SQL.toString());

			// 是否查询成功
			// CLDEF_DB_OK 0：全部操作均正常结束，查到记录
			// CLDEF_DB_OK2 1：全部操作均正常结束，但没有符合查询条件的记录
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				
				if (res.size() > 1) {
					String itemID;
					String personNum;
		        	for (int i = 1; i < res.size(); i++) {
		        		itemID = StringUtil.convertNull(res.getCell("C_ITEMID", i));
		        		personNum = StringUtil.convertNull(res.getCell("C_PERSONNUM", i));
		        		personNumMap.put(itemID, personNum);
		        	}
				}

				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet("性别");
				
				HSSFCellStyle contentStyle = workBook.createCellStyle();
				contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		        HSSFCellStyle titleStyle = workBook.createCellStyle();
		        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        HSSFFont titleFont = workBook.createFont();
		        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        titleStyle.setFont(titleFont);
		        
		        sheet.setColumnWidth(0, 10000);
				sheet.setColumnWidth(1, 5000);
				
				int rowNum = 0;
				List optionItemList = (List) optionItemMap.get("sex");
				String[] optionItem;
				HSSFRow row;
				HSSFCell cell;
				for (int i = 0; i < optionItemList.size(); i++) {
					optionItem = (String[]) optionItemList.get(i);
					row = sheet.createRow(rowNum);
					cell = row.createCell(0);
			        cell.setCellValue(optionItem[1]);
			        cell.setCellStyle(titleStyle);
			        
			        cell = row.createCell(1);
			        if (personNumMap.containsKey(optionItem[0])) {
			        	cell.setCellValue((String) personNumMap.get(optionItem[0]));
			        } else {
			        	cell.setCellValue("0");
			        }
			        cell.setCellStyle(contentStyle);
			        
			        rowNum = rowNum + 1;
				}
				
				
				sheet = workBook.createSheet("年龄");
		        
		        sheet.setColumnWidth(0, 10000);
				sheet.setColumnWidth(1, 5000);
				
				rowNum = 0;
				optionItemList = (List) optionItemMap.get("age");
				for (int i = 0; i < optionItemList.size(); i++) {
					optionItem = (String[]) optionItemList.get(i);
					row = sheet.createRow(rowNum);
					cell = row.createCell(0);
			        cell.setCellValue(optionItem[1]);
			        cell.setCellStyle(titleStyle);
			        
			        cell = row.createCell(1);
			        if (personNumMap.containsKey(optionItem[0])) {
			        	cell.setCellValue((String) personNumMap.get(optionItem[0]));
			        } else {
			        	cell.setCellValue("0");
			        }
			        cell.setCellStyle(contentStyle);
			        
			        rowNum = rowNum + 1;
				}
				
				
				sheet = workBook.createSheet("媒体方式");
		        
		        sheet.setColumnWidth(0, 10000);
				sheet.setColumnWidth(1, 5000);
				
				rowNum = 0;
				optionItemList = (List) optionItemMap.get("mediaType");
				for (int i = 0; i < optionItemList.size(); i++) {
					optionItem = (String[]) optionItemList.get(i);
					row = sheet.createRow(rowNum);
					cell = row.createCell(0);
			        cell.setCellValue(optionItem[1]);
			        cell.setCellStyle(titleStyle);
			        
			        cell = row.createCell(1);
			        if (personNumMap.containsKey(optionItem[0])) {
			        	cell.setCellValue((String) personNumMap.get(optionItem[0]));
			        } else {
			        	cell.setCellValue("0");
			        }
			        cell.setCellStyle(contentStyle);
			        
			        rowNum = rowNum + 1;
				}
				
				sheet = workBook.createSheet("所在地区");
		        
		        sheet.setColumnWidth(0, 10000);
		        sheet.setColumnWidth(1, 10000);
				sheet.setColumnWidth(2, 5000);
				
				rowNum = 0;
				optionItemList = (List) optionItemMap.get("province");
				Map provinceCityMap = common.getProvinceCityMap();
				List cityList;
				String[] city;
				for (int i = 0; i < optionItemList.size(); i++) {
					optionItem = (String[]) optionItemList.get(i);
			        
			        if (optionItem[0].equals("14")) {
			        	cityList = (List) provinceCityMap.get(optionItem[0]);
			        	for (int j = 0; j < cityList.size(); j++) {
			        		city = (String[]) cityList.get(j);
			        		
			        		row = sheet.createRow(rowNum);
							cell = row.createCell(0);
					        cell.setCellValue(optionItem[1]);
					        cell.setCellStyle(titleStyle);
					        
					        cell = row.createCell(1);
					        cell.setCellValue(city[1]);
					        cell.setCellStyle(titleStyle);
					        
					        cell = row.createCell(2);
					        if (personNumMap.containsKey(city[0])) {
					        	cell.setCellValue((String) personNumMap.get(city[0]));
					        } else {
					        	cell.setCellValue("0");
					        }
					        cell.setCellStyle(contentStyle);
					        
					        rowNum = rowNum + 1;
			        	}
			        } else {
			        	row = sheet.createRow(rowNum);
						cell = row.createCell(0);
				        cell.setCellValue(optionItem[1]);
				        cell.setCellStyle(titleStyle);
				        
				        cell = row.createCell(1);
				        cell.setCellValue("");
				        cell.setCellStyle(titleStyle);
				        
				        cell = row.createCell(2);
				        if (personNumMap.containsKey(optionItem[0])) {
				        	cell.setCellValue((String) personNumMap.get(optionItem[0]));
				        } else {
				        	cell.setCellValue("0");
				        }
				        cell.setCellStyle(contentStyle);
				        
				        rowNum = rowNum + 1;
			        }
				}
		        
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        workBook.write(outputStream);
		        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		        
				common.writeStreamToResponse(p_Month + "咨询信息.xls", response, inputStream);
		        
		        outputStream.close();
			} else {
				// 迁移到错误画面
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("ConsultExportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
