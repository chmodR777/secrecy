//////////////////////////////////////////////////////////////
//
// COPYRIGHT (C) 2010 zq CORPORATION
//
// ALL RIGHTS RESERVED BY zq CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

/*
 * CLASS      �� UserBean
 * VERSION    �� 0.00
 * DESC       : �û���¼ҵ�����߼�BEAN
 * DATE       �� 2010-08-23
 * AUTHOR     �� deargod1981@sohu.com
 * HISTORY    �� 2010-08-23 0.00 ����
 */
package com.syntc.common.bean;

import java.util.HashMap;
import java.util.Map;

import com.syntc.constants.CommonConstants;
import com.syntc.util.DBOperate;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class UserBean {
	
	//id
	private String id;
	//�˺�
	private String userCode;
	//����
	private String userName;
	//����
	private String pwd;
	//��ɫ����
	private String roleType;
	//�Ա�
	private String sex;
	//��ϵ�绰
	private String tel;
	//���ڲ���
	private String dep;
	//��ע
	private String remark;
	//�û�Ȩ�޼���
	private Map<String,String> UserRightMap; 


	/**
	 *  ������� UserBean
	 */
	public UserBean() {
		id = "";
		userCode = "no code";
		userName = "";
		pwd = "";
		roleType = "";
		sex = "";
		tel = "";
		dep = "";
		remark = "";
		UserRightMap = new HashMap<String,String>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String strUserCode) {
		if(null == strUserCode){
			this.userCode = "no code";
		}else{
			this.userCode = strUserCode;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String strUserName) {
		if(null == strUserName){
			this.userName = "";
		}else{
			this.userName = strUserName;
		}
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String strPwd) {
		if(null == strPwd){
			this.pwd = "";
		}else{
			this.pwd = strPwd;
		}
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String strRoleType) {
		if(null == strRoleType){
			this.roleType = "";
		}else{
			this.roleType = strRoleType;
		}
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String strSex) {
		if(null == strSex){
			this.sex = "";
		}else{
			this.sex = strSex;
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String strTel) {
		if(null == strTel){
			this.tel = "";
		}else{
			this.tel = strTel;
		}
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String strDep) {
		if(null == strDep){
			this.dep = "";
		}else{
			this.dep = strDep;
		}
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String strRemark) {
		if(null == strRemark){
			this.remark = "";
		}else{
			this.remark = strRemark;
		}
	}

	public Map<String,String> getUserRightMap() {
		return UserRightMap;
	}

	public void setUserRightMap(Map<String,String> userRightMap) {
		UserRightMap = userRightMap;
	}

	/**
	 * ��ϸ˵�� :�û���Ϣװ��
	 * @param �û����
	 * @return void
	 * @exception none
	 */
	public void loadUserInfo(String p_str_UserCode) throws Exception {
		/////////////////////////////////////////////////////////////
		// ��������û���Ϣ
		
		this.setUserCode("");
		this.setUserName("");
		this.setSex("");
		this.setTel(""); 
		this.setDep("");
		this.setRoleType("");
		this.setPwd("");
		this.setRemark("");
		//����û�Ȩ��
		this.UserRightMap.clear();
		
		/////////////////////////////////////////////////////////////
		// ����������������
		String str_UserCode = StringUtil.convertNull(p_str_UserCode);
		String str_UserCodeDB = StringUtil.replace(str_UserCode, "'", "''");
		// �������ݿ�����
		DBOperate conn = new DBOperate();
		//����SQL��乹������
		StringBuffer sb_SQL = new StringBuffer();

		/////////////////////////////////////////////////////////////
		// �����ݿ���ȡ���û���Ϣ
		// ����SQL��䣭�û���Ϣ��ѯ
		sb_SQL.append("SELECT a.C_ID,");
		sb_SQL.append("       a.C_NAME,");
		sb_SQL.append("       a.C_CODE,");
		sb_SQL.append("       a.C_PWD,");
		sb_SQL.append("       a.C_SEX,");
		sb_SQL.append("       a.C_DEP,");
		sb_SQL.append("       a.C_TEL,");
		sb_SQL.append("       a.C_ROLETYPE,");
		sb_SQL.append("       a.C_REMARK ");
		sb_SQL.append("  FROM t_user a");
		sb_SQL.append(" WHERE a.C_CODE = '" + str_UserCodeDB + "'");

		// ��ѯ�������û���Ϣ
		ResultObj res = conn.Query(sb_SQL.toString());
		
		

		//�жϲ�ѯ����Ƿ�ִ�гɹ�.
		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			
			//�����û�id
			this.setId(res.getCell("C_ID", 1));
			//���õ�¼�û���ţ���¼�ʺţ�
			this.setUserCode(str_UserCode);
			//���õ�¼�û�����
			this.setUserName(res.getCell("C_NAME", 1));
			//��������
			this.setPwd(res.getCell("C_PWD", 1));
			//�����Ա�
			this.setSex(res.getCell("C_SEX", 1));
			//���õ绰
			this.setTel(res.getCell("C_TEL", 1));
			//�������ڲ���
			this.setDep(res.getCell("C_DEP", 1));
			//�����û���ɫ����
			this.setRoleType(res.getCell("C_ROLETYPE", 1));
			//���ñ�ע
			this.setRemark(res.getCell("C_REMARK", 1));
			
		} 

		/////////////////////////////////////////////////////////////
		// Ȩ����Ϣ��ѯ
		// ����SQL��䣭Ȩ����Ϣ��ѯ
		sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT a.C_MENUID");
		sb_SQL.append("  FROM t_right a,t_user b");
		sb_SQL.append(" WHERE b.C_ID = a.C_USERID ");
		sb_SQL.append("   AND b.C_CODE = '" + str_UserCodeDB + "'");

		// ��ѯ�������û���Ϣ
		res = conn.Query(sb_SQL.toString());

		//�жϲ�ѯ����Ƿ�ִ�гɹ�.
		if (CommonConstants.CLDEF_DB_OK == res.getStatus() && res.getRows() >= 2) {
			for (int i = 1; i < res.getRows(); i++) {
				UserRightMap.put(res.getCell("C_MENUID", i),CommonConstants.TRUE );
			}
		}
		
		//���Ϊ����Ա���������в˵�Ȩ��
		if("1".equals(this.getRoleType())){
			for(int i=1;i<=100;i++){
				UserRightMap.put(i+"", CommonConstants.TRUE);
			}
		}
	}

	
	/**
	 * �жϹ����Ƿ����
	 * ��ϸ˵��
	 * @param ���ܱ���
	 * @return �Ƿ����
	 * @exception none
	 */
	public boolean chkFunc(String p_str_FuncCode) {
		if (CommonConstants.TRUE.equals(UserRightMap.get(p_str_FuncCode))) {
			return true;
		}
		return false;
	}

}
