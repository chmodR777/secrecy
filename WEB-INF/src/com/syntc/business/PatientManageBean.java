package com.syntc.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntc.common.action.BusinessLogic;
import com.syntc.common.bean.Common;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.RowSet;
import com.syntc.util.StringUtil;

public class PatientManageBean extends BusinessLogic {
	/**
	 * ���캯��
	 */
	public PatientManageBean() {
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
		RowSet rs = new RowSet();
		// ���ݿ����Ӷ���
		DBOperate conn = new DBOperate();

		// ��ǰҳ��
		int i_CurPage = 1;
		// ÿҳ��¼��
		int i_PageSize = 10;

		try {
			// ÿҳ��¼��
			String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String.valueOf(CommonConstants.CLEDF_MAX_PAGE));
			i_PageSize = Integer.parseInt(str_PageSize);
			// ȡ�õ�ǰҳ��
			String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
			i_CurPage = Integer.parseInt(str_CurPage);
			
			// ��ѯ����-��Ա���
			String p_MemCode = StringUtil.getRequestData(request.getParameter("txtMemCode"), "");
			// ��ѯ����-����
			String p_Name = StringUtil.getRequestData(request.getParameter("txtName"), "");
			// ��ѯ����-�Ա�
			String p_Sex = StringUtil.getRequestData(request.getParameter("txtSex"), "");
			// ��ѯ����-����
			String p_AgeMin = StringUtil.getRequestData(request.getParameter("txtAgeMin"), "");
			String p_AgeMax = StringUtil.getRequestData(request.getParameter("txtAgeMax"), "");
			// ��ѯ����-���ڵ���-ʡ
			String p_Province = StringUtil.getRequestData(request.getParameter("txtProvince"), "");
			// ��ѯ����-���ڵ���-��
			String p_City = StringUtil.getRequestData(request.getParameter("txtCity"), "");
			// ��ѯ����-�ֻ�
			String p_Mobile = StringUtil.getRequestData(request.getParameter("txtMobile"), "");
			// ��ѯ����-ý�巽ʽ
			String p_MediaType = StringUtil.getRequestData(request.getParameter("txtMediaType"), "");
			// ��ѯ����-��ͬ��λ
			String p_Company = StringUtil.getRequestData(request.getParameter("txtCompany"), "");
			// ��ѯ����-��Ա���
			String p_MemType = StringUtil.getRequestData(request.getParameter("txtMemType"), "");
			// ��ѯ����-���֤��
			String p_IDCard = StringUtil.getRequestData(request.getParameter("txtIDCard"), "");
			// ��ѯ����-�ۼƻ���
			String p_TotalScoreMin = StringUtil.getRequestData(request.getParameter("txtTotalScoreMin"), "");
			String p_TotalScoreMax = StringUtil.getRequestData(request.getParameter("txtTotalScoreMax"), "");

			// ���sql���
			StringBuffer sb_SQL = new StringBuffer();
			sb_SQL.append("SELECT * FROM (");
			sb_SQL.append("SELECT t_patient.C_ID AS C_ID, ");
			sb_SQL.append("t_patient.C_MEMCODE AS C_MEMCODE, ");
			sb_SQL.append("t_patient.C_NAME AS C_NAME, ");
			sb_SQL.append("t_patient.C_SEX AS C_SEX, ");
			sb_SQL.append("t_patient.C_AGE AS C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE AS C_PROVINCE, ");
			sb_SQL.append("t_patient.C_CITY AS C_CITY, ");
			sb_SQL.append("t_patient.C_MOBILE AS C_MOBILE, ");
			sb_SQL.append("t_patient.C_MEDIATYPE AS C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY AS C_COMPANY, ");
			sb_SQL.append("t_memtype.C_TYPENAME AS C_TYPENAME, ");
			sb_SQL.append("t_patient.C_IDCARD AS C_IDCARD, ");
			sb_SQL.append("SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS TOTALSCORE ");
			sb_SQL.append("FROM t_patient ");
			sb_SQL.append("LEFT JOIN t_ill ");
			sb_SQL.append("ON t_patient.C_ID = t_ill.C_PATIENTID ");
			sb_SQL.append("LEFT JOIN t_memtype ");
			sb_SQL.append("ON t_patient.C_MEMTYPE = t_memtype.C_ID ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_MemCode.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEMCODE like '%" + p_MemCode + "%' ");
			}
			if (p_Name.length() > 0) {
				sb_SQL.append("AND t_patient.C_NAME like '%" + p_Name + "%' ");
			}
			if (p_Sex.length() > 0) {
				sb_SQL.append("AND t_patient.C_SEX = " + p_Sex + " ");
			}
			if (p_AgeMin.length() > 0) {
				sb_SQL.append("AND t_patient.C_AGE >= " + p_AgeMin + " ");
			}
			if (p_AgeMax.length() > 0) {
				sb_SQL.append("AND t_patient.C_AGE <= " + p_AgeMax + " ");
			}
			if (p_Province.length() > 0) {
				sb_SQL.append("AND t_patient.C_PROVINCE = " + p_Province + " ");
			}
			if (p_City.length() > 0) {
				sb_SQL.append("AND t_patient.C_CITY = " + p_City + " ");
			}
			if (p_Mobile.length() > 0) {
				sb_SQL.append("AND t_patient.C_MOBILE like '%" + p_Mobile + "%' ");
			}
			if (p_MediaType.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEDIATYPE = " + p_MediaType + " ");
			}
			if (p_Company.length() > 0) {
				sb_SQL.append("AND t_patient.C_COMPANY = " + p_Company + " ");
			}
			if (p_MemType.length() > 0) {
				sb_SQL.append("AND t_patient.C_MEMTYPE = " + p_MemType + " ");
			}
			if (p_IDCard.length() > 0) {
				sb_SQL.append("AND t_patient.C_IDCARD like '%" + p_IDCard + "%' ");
			}
			sb_SQL.append("GROUP BY t_patient.C_MEMCODE, t_patient.C_NAME, t_patient.C_SEX, t_patient.C_AGE, ");
			sb_SQL.append("t_patient.C_PROVINCE, t_patient.C_CITY, t_patient.C_MOBILE, t_patient.C_MEDIATYPE, ");
			sb_SQL.append("t_patient.C_COMPANY, t_memtype.C_TYPENAME, t_patient.C_IDCARD) t_info ");
			sb_SQL.append("WHERE 1 = 1 ");
			if (p_TotalScoreMin.length() > 0) {
				sb_SQL.append("AND t_info.TOTALSCORE >= " + p_TotalScoreMin + " ");
			}
			if (p_TotalScoreMax.length() > 0) {
				sb_SQL.append("AND t_info.TOTALSCORE <= " + p_TotalScoreMax + " ");
			}

			// ����sql
			rs.setSql(sb_SQL.toString());
			// ����ÿҳ��¼����
			rs.setPageSize(i_PageSize);
			// ��ѯָ��ҳ��¼
			res = rs.goPage(i_CurPage);

			// ִ�в�ѯ
			res = conn.Query(sb_SQL.toString());

			// �Ƿ��ѯ�ɹ�
			// CLDEF_DB_OK 0��ȫ�������������������鵽��¼
			// CLDEF_DB_OK2 1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
			if (CommonConstants.CLDEF_DB_OK <= res.getStatus()) {
				Common common = new Common();
				// �����ܼ�¼��
				parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
				// ����ÿҳ��¼��
				parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
				// ���õ�ǰҳ���б��ҳ��ز�����
				parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));

				// ����������浽request��
				request.setAttribute("res", res);
				Map optionItemMap = common.getOptionItemMap("sex,mediaType,company,province,city");
				request.setAttribute("optionItemMap", optionItemMap);
				
				// ��ȡ��Ա��������б�
				String memTypeOptionList = common.getMemTypeOptionList(p_MemType);
				request.setAttribute("memTypeOptionList", memTypeOptionList);
				// ��ȡ�Ա������б�
				String sexOptionList = common.getSexOptionList(p_Sex);
				request.setAttribute("sexOptionList", sexOptionList);
				// ��ȡý�巽ʽ�����б�
				String mediaTypeOptionList = common.getMediaTypeOptionList(p_MediaType);
				request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
				// ��ȡ��ͬ��λ�����б�
				String companyOptionList = common.getCompanyOptionList(p_Company);
				request.setAttribute("companyOptionList", companyOptionList);
				// ��ȡ���ڵ���-ʡ�����б�
				String provinceOptionList = common.getProvinceOptionList(p_Province);
				request.setAttribute("provinceOptionList", provinceOptionList);
				// ��ȡ���ڵ���-�������б�
				String cityOptionList = "";
				if (p_Province.length() > 0) {
					cityOptionList = common.getCityOptionList(p_Province, p_City);
				}
				request.setAttribute("cityOptionList", cityOptionList);
				
				// ��ȡʡ��Map
				Map provinceCityMap = common.getProvinceCityMap();
				request.setAttribute("provinceCityMap", provinceCityMap);

				// ����Ǩ���׻���
				String str_URL = "/app/business/patient_manage.jsp";
				// ����Ǩ��
				parameters.setParameters("results", "ForwardPage", str_URL);
			} else {
				// Ǩ�Ƶ�������
				parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
			}
		} catch (Exception ex) {
			System.out.println("PatientManageBean:" + ex.toString());
			parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
		}
	}

	/**
	 * ҳ�����⴦�����
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
	}
}
