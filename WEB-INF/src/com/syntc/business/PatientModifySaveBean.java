package com.syntc.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class PatientModifySaveBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public PatientModifySaveBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {

		// 数据库操作对象
		DBOperate conn = new DBOperate();
		try {
			Common common = new Common();
			// SQL 语句
			StringBuffer sbSql = new StringBuffer();

			// 患者ID
			String strID = StringUtil.getRequestData(request.getParameter("strID"));			
			// 会员编号
			String strMemCode = StringUtil.getRequestData(request.getParameter("strMemCode"));
			// 姓名
			String strName = StringUtil.getRequestData(request.getParameter("strName"));
			// 性别
			String strSex = StringUtil.getRequestData(request.getParameter("strSex"));
			// 年龄
			String strAge = StringUtil.getRequestData(request.getParameter("strAge"));
			// 所在地区-省
			String strProvince = StringUtil.getRequestData(request.getParameter("strProvince"));
			// 所在地区-市
			String strCity = StringUtil.getRequestData(request.getParameter("strCity"));
			// 手机
			String strMobile = StringUtil.getRequestData(request.getParameter("strMobile"));
			// 媒体方式
			String strMediaType = StringUtil.getRequestData(request.getParameter("strMediaType"));
			// 合同单位
			String strCompany = StringUtil.getRequestData(request.getParameter("strCompany"));
			// 会员类别
			String strMemType = StringUtil.getRequestData(request.getParameter("strMemType"));
			// 身份证号
			String strIDCard = StringUtil.getRequestData(request.getParameter("strIDCard"));
			
			
			// 校验会员编号唯一
			boolean b_flag = chkUniqMemCode(strID, strMemCode);
			// 会员编号唯一
			if (b_flag) {
				sbSql.append("UPDATE t_patient SET ");
				sbSql.append("C_MEMCODE = '" + strMemCode + "', ");
				sbSql.append("C_NAME = '" + strName + "', ");
				if (strSex.length() == 0) {
					sbSql.append("C_SEX = NULL, ");
				} else {
					sbSql.append("C_SEX = " + strSex + ", ");
				}
				if (strAge.length() == 0) {
					sbSql.append("C_AGE = NULL, ");
					sbSql.append("C_BIRTH = NULL, ");
				} else {
					sbSql.append("C_AGE = " + strAge + ", ");
					int birth = common.getYear() - Integer.parseInt(strAge);
					sbSql.append("C_BIRTH = " + birth + ", ");
				}
				if (strProvince.length() == 0) {
					sbSql.append("C_PROVINCE = NULL, ");
				} else {
					sbSql.append("C_PROVINCE = " + strProvince + ", ");
				}
				if (strCity.length() == 0) {
					sbSql.append("C_CITY = NULL, ");
				} else {
					sbSql.append("C_CITY = " + strCity + ", ");
				}
				sbSql.append("C_MOBILE = '" + strMobile + "', ");
				if (strMediaType.length() == 0) {
					sbSql.append("C_MEDIATYPE = NULL, ");
				} else {
					sbSql.append("C_MEDIATYPE = " + strMediaType + ", ");
				}
				sbSql.append("C_IDCARD = '" + strIDCard + "', ");
				if (strCompany.length() == 0) {
					sbSql.append("C_COMPANY = NULL");
				} else {
					sbSql.append("C_COMPANY = " + strCompany);
				}
				if (strMemType.length() == 0) {
					sbSql.append(" ");
				} else {
					sbSql.append(", C_MEMTYPE = " + strMemType + " ");
				}
				sbSql.append("WHERE C_ID = " + strID);

				// 进行数据库更新
				int iRtn = conn.doTransaction(sbSql.toString());

				// 判断查询语句是否执行成功.
				if (iRtn == CommonConstants.CLDEF_DB_OK) {
					// 迁移列表画面
					String strURL = "PatientManage.do";
					parameters.setParameters("results", "ForwardPage", strURL);
				} else {
					// 迁移ERROR画面
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
				}
			} else {
				// 提示信息
				String str_ErrMsg = "会员编号：" + strMemCode + "已存在，请重新录入！";
				// 设置到request中
				request.setAttribute("pop_Msg", str_ErrMsg);
				// 设置迁移画面
				String str_URL = "PatientModify.do?patient_id=" + strID;
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("PatientModifySaveBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}

	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}

	/**
	 * 校验会员编号唯一性
	 * 
	 * @param strMemCode
	 * @return
	 */
	private boolean chkUniqMemCode(String strID, String strMemCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_patient.C_ID ");
		sb.append("FROM t_patient ");
		sb.append("WHERE t_patient.C_MEMCODE = '" + strMemCode + "' ");
		sb.append("AND t_patient.C_ID <> " + strID + " ");

		res1 = conn.Query(sb.toString());
		// 存在一条记录，与当前会员编号相同
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() >= 2) {
			b_flag = false;
		}
		// 返回
		return b_flag;
	}
}
