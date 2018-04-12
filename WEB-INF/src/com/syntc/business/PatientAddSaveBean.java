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

public class PatientAddSaveBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public PatientAddSaveBean() {
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
			// SQL存放对象
			StringBuffer sb_SQL = new StringBuffer();
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
			String strMemTypeID = StringUtil.getRequestData(request.getParameter("strMemTypeID"));
			if (strMemType.length() == 0) {
				strMemType = strMemTypeID;
			}
			// 身份证号
			String strIDCard = StringUtil.getRequestData(request.getParameter("strIDCard"));
			
			// 会员编号唯一
			boolean b_flag = chkUniqMemCode(strMemCode);
			// 不存在重复会员编号
			if (b_flag) {
				Common common = new Common();
				// 组合SQL语句
				sb_SQL.append("INSERT INTO t_patient(");
				sb_SQL.append("C_MEMCODE, C_NAME, C_SEX, C_AGE, C_BIRTH, C_PROVINCE, C_CITY, ");
				sb_SQL.append("C_MOBILE, C_MEDIATYPE, C_IDCARD, C_COMPANY, C_MEMTYPE) ");
				sb_SQL.append("VALUES(");
				sb_SQL.append("'" + strMemCode + "', ");
				sb_SQL.append("'" + strName + "', ");
				if (strSex.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strSex + ", ");
				}
				if (strAge.length() == 0) {
					sb_SQL.append("NULL, ");
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strAge + ", ");
					int birth = common.getYear() - Integer.parseInt(strAge);
					sb_SQL.append(birth + ", ");
				}
				if (strProvince.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strProvince + ", ");
				}
				if (strCity.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strCity + ", ");
				}
				sb_SQL.append("'" + strMobile + "', ");
				if (strMediaType.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strMediaType + ", ");
				}
				sb_SQL.append("'" + strIDCard + "', ");
				if (strCompany.length() == 0) {
					sb_SQL.append("NULL, ");
				} else {
					sb_SQL.append(strCompany + ", ");
				}
				if (strMemType.length() == 0) {
					sb_SQL.append("NULL) ");
				} else {
					sb_SQL.append(strMemType + ") ");
				}

				// 进行数据库更新
				int i_Rtn = conn.doTransaction(sb_SQL.toString());
				// 判断查询语句是否执行成功.
				if (i_Rtn == CommonConstants.CLDEF_DB_OK) {
					// 设置迁移画面
					String str_URL = "PatientManage.do";

					// 画面迁移
					parameters.setParameters("results", "ForwardPage", str_URL);
				} else {

					// 迁移到错误画面
					parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);

				}
			} else {
				// 提示信息
				String str_ErrMsg = "会员编号：" + strMemCode + "已存在，请重新录入！";
				// 设置到request中
				request.setAttribute("pop_Msg", str_ErrMsg);
				// 设置迁移画面
				String str_URL = "PatientAdd.do";
				// 画面迁移
				parameters.setParameters("results", "ForwardPage", str_URL);
			}
		} catch (Exception ex) {
			System.out.println("PatientAddSaveBean:" + ex.toString());
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
	private boolean chkUniqMemCode(String strMemCode) {
		boolean b_flag = true;
		DBOperate conn = new DBOperate();
		ResultObj res1 = new ResultObj();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t_patient.C_ID ");
		sb.append("FROM t_patient ");
		sb.append("WHERE t_patient.C_MEMCODE = '" + strMemCode + "' ");

		res1 = conn.Query(sb.toString());
		// 存在一条记录，与当前会员编号相同
		if (CommonConstants.CLDEF_DB_OK <= res1.getStatus() && res1.size() > 1) {
			b_flag = false;
		}
		// 返回
		return b_flag;
	}
}