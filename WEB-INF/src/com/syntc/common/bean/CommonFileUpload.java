////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
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
 * CLASS      ： CommonFileUpload 
 * VERSION    ： 0.00
 * DESC       :  共通文件上传处理
 * DATE       ： 2007-03-26
 * AUTHOR     ： zhangqiang
 * HISTORY    ： 2007-03-26 0.00 作成
 */
package com.syntc.common.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.syntc.common.upload.UploadUtil;
import com.syntc.common.upload.file;
import com.syntc.common.upload.files;
import com.syntc.constants.CommonConstants;
import com.syntc.util.DBOperate;
import com.syntc.util.StringUtil;

public class CommonFileUpload {
	// 上传对象
	private UploadUtil myUpload;

	// 原文件名
	private String str_fileName = "";

	// 文件对应功能code
	private String str_funCode = "";

	// 子工程id
	private String str_subProId = "";

	// 子模块id
	private String str_typeID = "";

	// 项目id
	private String str_ProID = "";
	
	//当前文件id
	private String str_fileID = "";
	
	public String getFileID(){
		return this.str_fileID;
	}
	
	private void setFileID(String p_fileID){
		this.str_fileID = p_fileID;
	}

	/**
	 * 构造函数
	 */
	public CommonFileUpload(UploadUtil upload) {
		this.myUpload = upload;
	}

	/**
	 * 设置文件名
	 * 
	 * @param p_fileName
	 */
	private void setFileName(String p_fileName) {
		this.str_fileName = p_fileName;
	}

	/**
	 * 取得文件名
	 * 
	 * @return
	 */
	public String getFileName() {
		return this.str_fileName;
	}

	private void setSubPro(String p_subPro) {
		this.str_subProId = p_subPro;
	}

	public String getSubPor() {
		return this.str_subProId;
	}

	private void setTypeID(String p_typeId) {
		this.str_typeID = p_typeId;
	}

	public String getTypeID() {
		return this.str_typeID;
	}

	private void setProID(String p_proId) {
		this.str_ProID = p_proId;
	}

	public String getProID() {
		return this.str_ProID;
	}

	/**
	 * 上传处理
	 * 
	 * @param request
	 * @return
	 */
	public boolean upload(HttpServletRequest request) {
		boolean b_flag = false;
		// 取得UserBean
		UserBean user = (UserBean) request.getSession().getAttribute("UserBean");

		int i_Rtn = 0;
		DBOperate conn = new DBOperate();
		Vector v_SQL = new Vector();

		try {

			// 初始化工作
			myUpload.initialize(request);

			// 设定允许的文件后缀名
			myUpload.setAllowedExtList("xls,doc,ppt,txt,rar,zip,bmp,jpg,gif,XLS,DOC,PPT,TXT,RAR,ZIP,BMP,JPG,GIF");

			// 设定是否允许覆盖服务器上的同名文件
			myUpload.setIsCover(true);

			// 设定单个文件大小的限制10M
			myUpload.setMaxFileSize(10485760);

			// 设定上传的物理路径
			myUpload.setRealPath(CommonConstants.UPLOADPAH);

			// 校验文件大小
			try {
				// 将所有数据导入组件的数据结构中
				myUpload.upload();
			} catch (SecurityException se) {
				b_flag = false;
				return b_flag;
			}

			// 得到上传的文件，此处设定上传文件为1个
			files myFiles = myUpload.getFiles();

			file myFile = myFiles.getFile(0);
			// 重新设置文件名，暂时采用日期加小时分秒
			String str_temp = this.gerFormatFileName();

			myFile.setName(str_temp + "." + myFile.getExtName());

			myFile.saveAs();

			// 保存文件名
			String str_saveName = myFile.getName();

			// 取得文件名称
			String str_fileName = StringUtil.getRequestData(myUpload.getRequest().getParameter("file_original_name"));

			// 取得备注
			String str_reMark = StringUtil.getRequestData(myUpload.getRequest().getParameter("remark"));

			// 取得上传文件类型文件类型
			String str_fileType = myUpload.getRequest().getParameter("type");

			// 取得子项目id
			String str_subProID = myUpload.getRequest().getParameter("sub");

			// 项目ID
			//String str_proID = user.getProID();
			String str_proID = "";

			if (null == str_proID || "".equals(str_proID)) {
				str_proID = "0";
			}


			// 构造功能code
			this.str_funCode = str_proID + "_" + str_subProID + "_" + str_fileType;

			this.setSubPro(str_subProID);
			this.setTypeID(str_fileType);
			this.setProID(str_proID);

			// 构造插入语句
			StringBuffer sb_SQL = new StringBuffer();

			sb_SQL.append("UPDATE tb_file");
			sb_SQL.append("   SET if_latest = '" + CommonConstants.ISOLD + "'");
			sb_SQL.append(" WHERE function_code = '" + this.str_funCode + "'");

			v_SQL.add(sb_SQL.toString());

			sb_SQL = new StringBuffer();

			// 插入文件信息
			sb_SQL.append("INSERT INTO tb_file(");
			sb_SQL.append("            file_original_name,");
			sb_SQL.append("            file_save_name,");
			sb_SQL.append("            if_confirm,");
			sb_SQL.append("            function_code,");
			sb_SQL.append("            if_latest,");
			sb_SQL.append("            remark,");
			sb_SQL.append("            created_by,");
			sb_SQL.append("            created_time)");
			sb_SQL.append("   VALUES(");
			sb_SQL.append("          '" + str_fileName + "',");
			sb_SQL.append("          '" + str_saveName + "',");
			sb_SQL.append("          '" + CommonConstants.CONFIRM_NO + "',");
			sb_SQL.append("'" + this.str_funCode + "',");
			sb_SQL.append("          '" + CommonConstants.ISNEW + "',");
			sb_SQL.append("          '" + str_reMark + "',");
			sb_SQL.append("          '" + user.getUserCode() + "',");
			sb_SQL.append("          getdate() )");

			v_SQL.add(sb_SQL.toString());

			i_Rtn = conn.doTransaction(v_SQL);

			// 是否查询成功
			if (CommonConstants.CLDEF_DB_OK == i_Rtn) {
				b_flag = true;
				//设置保存文件名
				this.setFileName(str_saveName);
				Common common = new Common();
				sb_SQL = new StringBuffer();
				sb_SQL.append("SELECT file_id ");
				sb_SQL.append("  FROM tb_file ");
				sb_SQL.append(" WHERE function_code = '" + this.str_funCode + "'");
				sb_SQL.append("   AND if_latest = '" + CommonConstants.ISNEW + "'");
				//取得当前文件id
				String str_fileID = common.getViewByID(sb_SQL.toString());
				//设置当前文件id
				this.setFileID(str_fileID);
				
			} else {
				b_flag = false;
			}
		} catch (Exception e) {
			b_flag = false;
			return b_flag;
		}
		return b_flag;
	}

	/**
	 * 取得格式化文件名
	 * 
	 * @return
	 */
	private String gerFormatFileName() {
		String str_temp = "";
		Date date = new Date();
		str_temp = new SimpleDateFormat("yyyyMMdd_hhmmss").format(date);
		return str_temp;
	}

}