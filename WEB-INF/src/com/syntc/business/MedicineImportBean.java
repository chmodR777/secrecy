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

public class MedicineImportBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public MedicineImportBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
		try {
			String strMonth = StringUtil.getRequestData(request.getParameter("strMonth"));
			strMonth = strMonth.substring(0, 7);
			
			UploadUtil myUpload = new UploadUtil();
			// 初始化工作
			myUpload.initialize(request);
			// 设定允许的文件后缀名
			myUpload.setAllowedExtList("xls");
			// 设定是否允许覆盖服务器上的同名文件
			myUpload.setIsCover(true);
			// 设定单个文件大小的限制10M
			myUpload.setMaxFileSize(10 * 1024 * 1024);
			// 设定上传的物理路径
			String path = request.getSession().getServletContext() .getRealPath("/") + "chart\\";
			this.isChartPathExist(path);
			myUpload.setRealPath(path);

			// 校验文件大小
			// 将所有数据导入组件的数据结构中
			myUpload.upload();
			
			// 得到上传的文件，此处设定上传文件为1个
			files myFiles = myUpload.getFiles();

			file myFile = myFiles.getFile(0);
			// 重新设置文件名，采用日期加小时分秒
			String fileName = System.currentTimeMillis() + ".xls";
			myFile.setName(fileName);
			myFile.saveAs();
			
			FileInputStream sourceFile = new FileInputStream(path + fileName);
			POIFSFileSystem fs = new POIFSFileSystem(sourceFile);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			
			//错误信息的样式
	        HSSFCellStyle errorInfoStyle = wb.createCellStyle();
	        HSSFFont errorInfoFont = wb.createFont();
	        errorInfoFont.setColor(HSSFColor.RED.index);
	        errorInfoFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        errorInfoStyle.setFont(errorInfoFont);
			
			Common common = new Common();
			HSSFSheet sheet = wb.getSheet("所在地区");
			HSSFRow row;
			HSSFCell cell;
			String itemName;
			String itemID = "";
			String personNum;
			List list = new ArrayList();
			String[] datas;
			int error = 0;
			
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
			                cell.setCellValue("导入数据错误！");
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
				                cell.setCellValue("导入数据错误！");
				                cell.setCellStyle(errorInfoStyle);
				                continue;
							}
						} else {							
							error = error + 1;
			                cell = row.createCell(3);
			                cell.setCellValue("导入数据错误！");
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
			                cell.setCellValue("导入数据错误！");
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
				// 数据库操作对象
				DBOperate conn = new DBOperate();
				Vector<String> vec = new Vector<String>();
				// SQL存放对象
				StringBuffer sb_SQL = new StringBuffer();
				
				sb_SQL.append("DELETE FROM t_medicine ");
				sb_SQL.append("WHERE C_MONTH = '" + strMonth + "' ");
				vec.add(sb_SQL.toString());
				
				for (int i = 0; i < list.size(); i++) {
					datas = (String[]) list.get(i);
					sb_SQL = new StringBuffer();
					sb_SQL.append("INSERT INTO t_medicine(");
					sb_SQL.append("C_MONTH, C_ITEMTYPE, C_ITEMID, C_PERSONNUM) ");
					sb_SQL.append("VALUES(");
					sb_SQL.append("'" + datas[0] + "', ");
					sb_SQL.append("'" + datas[1] + "', ");
					sb_SQL.append(datas[2] + ", ");
					sb_SQL.append(datas[3] + ") ");
					vec.add(sb_SQL.toString());
				}
				
				// 进行数据库更新
				int i_Rtn = conn.doTransaction(vec);
				
				// 判断查询语句是否执行成功
				if (i_Rtn == CommonConstants.CLDEF_DB_OK) {	
					// 设置迁移画面
					String str_URL = "MedicineManage.do";
					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				} else {
					// 迁移到错误画面
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

				}
			}
		} catch (Exception ex) {
			System.out.println("MedicineImportBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
	
	/**
	 * 以字符串形式返回单元格的值
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
     * 如果存储图片路径不存在，则创建
     */
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    }
}