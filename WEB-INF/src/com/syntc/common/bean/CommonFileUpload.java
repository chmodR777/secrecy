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
 * CLASS      �� CommonFileUpload 
 * VERSION    �� 0.00
 * DESC       :  ��ͨ�ļ��ϴ�����
 * DATE       �� 2007-03-26
 * AUTHOR     �� zhangqiang
 * HISTORY    �� 2007-03-26 0.00 ����
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
	// �ϴ�����
	private UploadUtil myUpload;

	// ԭ�ļ���
	private String str_fileName = "";

	// �ļ���Ӧ����code
	private String str_funCode = "";

	// �ӹ���id
	private String str_subProId = "";

	// ��ģ��id
	private String str_typeID = "";

	// ��Ŀid
	private String str_ProID = "";
	
	//��ǰ�ļ�id
	private String str_fileID = "";
	
	public String getFileID(){
		return this.str_fileID;
	}
	
	private void setFileID(String p_fileID){
		this.str_fileID = p_fileID;
	}

	/**
	 * ���캯��
	 */
	public CommonFileUpload(UploadUtil upload) {
		this.myUpload = upload;
	}

	/**
	 * �����ļ���
	 * 
	 * @param p_fileName
	 */
	private void setFileName(String p_fileName) {
		this.str_fileName = p_fileName;
	}

	/**
	 * ȡ���ļ���
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
	 * �ϴ�����
	 * 
	 * @param request
	 * @return
	 */
	public boolean upload(HttpServletRequest request) {
		boolean b_flag = false;
		// ȡ��UserBean
		UserBean user = (UserBean) request.getSession().getAttribute("UserBean");

		int i_Rtn = 0;
		DBOperate conn = new DBOperate();
		Vector v_SQL = new Vector();

		try {

			// ��ʼ������
			myUpload.initialize(request);

			// �趨������ļ���׺��
			myUpload.setAllowedExtList("xls,doc,ppt,txt,rar,zip,bmp,jpg,gif,XLS,DOC,PPT,TXT,RAR,ZIP,BMP,JPG,GIF");

			// �趨�Ƿ������Ƿ������ϵ�ͬ���ļ�
			myUpload.setIsCover(true);

			// �趨�����ļ���С������10M
			myUpload.setMaxFileSize(10485760);

			// �趨�ϴ�������·��
			myUpload.setRealPath(CommonConstants.UPLOADPAH);

			// У���ļ���С
			try {
				// ���������ݵ�����������ݽṹ��
				myUpload.upload();
			} catch (SecurityException se) {
				b_flag = false;
				return b_flag;
			}

			// �õ��ϴ����ļ����˴��趨�ϴ��ļ�Ϊ1��
			files myFiles = myUpload.getFiles();

			file myFile = myFiles.getFile(0);
			// ���������ļ�������ʱ�������ڼ�Сʱ����
			String str_temp = this.gerFormatFileName();

			myFile.setName(str_temp + "." + myFile.getExtName());

			myFile.saveAs();

			// �����ļ���
			String str_saveName = myFile.getName();

			// ȡ���ļ�����
			String str_fileName = StringUtil.getRequestData(myUpload.getRequest().getParameter("file_original_name"));

			// ȡ�ñ�ע
			String str_reMark = StringUtil.getRequestData(myUpload.getRequest().getParameter("remark"));

			// ȡ���ϴ��ļ������ļ�����
			String str_fileType = myUpload.getRequest().getParameter("type");

			// ȡ������Ŀid
			String str_subProID = myUpload.getRequest().getParameter("sub");

			// ��ĿID
			//String str_proID = user.getProID();
			String str_proID = "";

			if (null == str_proID || "".equals(str_proID)) {
				str_proID = "0";
			}


			// ���칦��code
			this.str_funCode = str_proID + "_" + str_subProID + "_" + str_fileType;

			this.setSubPro(str_subProID);
			this.setTypeID(str_fileType);
			this.setProID(str_proID);

			// ����������
			StringBuffer sb_SQL = new StringBuffer();

			sb_SQL.append("UPDATE tb_file");
			sb_SQL.append("   SET if_latest = '" + CommonConstants.ISOLD + "'");
			sb_SQL.append(" WHERE function_code = '" + this.str_funCode + "'");

			v_SQL.add(sb_SQL.toString());

			sb_SQL = new StringBuffer();

			// �����ļ���Ϣ
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

			// �Ƿ��ѯ�ɹ�
			if (CommonConstants.CLDEF_DB_OK == i_Rtn) {
				b_flag = true;
				//���ñ����ļ���
				this.setFileName(str_saveName);
				Common common = new Common();
				sb_SQL = new StringBuffer();
				sb_SQL.append("SELECT file_id ");
				sb_SQL.append("  FROM tb_file ");
				sb_SQL.append(" WHERE function_code = '" + this.str_funCode + "'");
				sb_SQL.append("   AND if_latest = '" + CommonConstants.ISNEW + "'");
				//ȡ�õ�ǰ�ļ�id
				String str_fileID = common.getViewByID(sb_SQL.toString());
				//���õ�ǰ�ļ�id
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
	 * ȡ�ø�ʽ���ļ���
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