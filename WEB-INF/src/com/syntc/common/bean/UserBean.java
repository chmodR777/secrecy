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
 * CLASS      ： UserBean
 * VERSION    ： 0.00
 * DESC       : 用户登录业务处理逻辑BEAN
 * DATE       ： 2010-08-23
 * AUTHOR     ： deargod1981@sohu.com
 * HISTORY    ： 2010-08-23 0.00 作成
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
	//账号
	private String userCode;
	//姓名
	private String userName;
	//密码
	private String pwd;
	//角色类型
	private String roleType;
	//性别
	private String sex;
	//联系电话
	private String tel;
	//所在部门
	private String dep;
	//备注
	private String remark;
	//用户权限集合
	private Map<String,String> UserRightMap; 


	/**
	 *  构造对象 UserBean
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
	 * 详细说明 :用户信息装载
	 * @param 用户编号
	 * @return void
	 * @exception none
	 */
	public void loadUserInfo(String p_str_UserCode) throws Exception {
		/////////////////////////////////////////////////////////////
		// 清除现有用户信息
		
		this.setUserCode("");
		this.setUserName("");
		this.setSex("");
		this.setTel(""); 
		this.setDep("");
		this.setRoleType("");
		this.setPwd("");
		this.setRemark("");
		//清除用户权限
		this.UserRightMap.clear();
		
		/////////////////////////////////////////////////////////////
		// 参数处理及变量定义
		String str_UserCode = StringUtil.convertNull(p_str_UserCode);
		String str_UserCodeDB = StringUtil.replace(str_UserCode, "'", "''");
		// 创建数据库连接
		DBOperate conn = new DBOperate();
		//定义SQL语句构建变量
		StringBuffer sb_SQL = new StringBuffer();

		/////////////////////////////////////////////////////////////
		// 从数据库中取得用户信息
		// 构建SQL语句－用户信息查询
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

		// 查询并加载用户信息
		ResultObj res = conn.Query(sb_SQL.toString());
		
		

		//判断查询语句是否执行成功.
		if (CommonConstants.CLDEF_DB_OK == res.getStatus()) {
			
			//设置用户id
			this.setId(res.getCell("C_ID", 1));
			//设置登录用户编号（登录帐号）
			this.setUserCode(str_UserCode);
			//设置登录用户姓名
			this.setUserName(res.getCell("C_NAME", 1));
			//设置密码
			this.setPwd(res.getCell("C_PWD", 1));
			//设置性别
			this.setSex(res.getCell("C_SEX", 1));
			//设置电话
			this.setTel(res.getCell("C_TEL", 1));
			//设置所在部门
			this.setDep(res.getCell("C_DEP", 1));
			//设置用户角色类型
			this.setRoleType(res.getCell("C_ROLETYPE", 1));
			//设置备注
			this.setRemark(res.getCell("C_REMARK", 1));
			
		} 

		/////////////////////////////////////////////////////////////
		// 权限信息查询
		// 构建SQL语句－权限信息查询
		sb_SQL = new StringBuffer();
		sb_SQL.append("SELECT a.C_MENUID");
		sb_SQL.append("  FROM t_right a,t_user b");
		sb_SQL.append(" WHERE b.C_ID = a.C_USERID ");
		sb_SQL.append("   AND b.C_CODE = '" + str_UserCodeDB + "'");

		// 查询并加载用户信息
		res = conn.Query(sb_SQL.toString());

		//判断查询语句是否执行成功.
		if (CommonConstants.CLDEF_DB_OK == res.getStatus() && res.getRows() >= 2) {
			for (int i = 1; i < res.getRows(); i++) {
				UserRightMap.put(res.getCell("C_MENUID", i),CommonConstants.TRUE );
			}
		}
		
		//如果为管理员，则赋予所有菜单权限
		if("1".equals(this.getRoleType())){
			for(int i=1;i<=100;i++){
				UserRightMap.put(i+"", CommonConstants.TRUE);
			}
		}
	}

	
	/**
	 * 判断功能是否可用
	 * 详细说明
	 * @param 功能编码
	 * @return 是否可用
	 * @exception none
	 */
	public boolean chkFunc(String p_str_FuncCode) {
		if (CommonConstants.TRUE.equals(UserRightMap.get(p_str_FuncCode))) {
			return true;
		}
		return false;
	}

}
