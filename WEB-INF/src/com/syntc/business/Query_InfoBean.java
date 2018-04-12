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

public class Query_InfoBean extends BusinessLogic {
	/**
	 * 构造函数
	 */
	public Query_InfoBean() {
		if (CommonConstants.CLDEF_DEBUG) {
			System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
		}
	}

	/**
	 * 业务逻辑处理机能
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
		//结果集对象
        ResultObj res = new ResultObj();
        RowSet rs = new RowSet();
        //数据库连接对象
        DBOperate conn = new DBOperate();
        
        //获取公共方法
       Common com = new Common(); 
       
        
        // 当前页号
        int i_CurPage = 1;
        // 每页记录数
        int i_PageSize = 10;	
        
        
        try{       	

        	// 每页记录数
            String str_PageSize = StringUtil.getRequestData(request.getParameter("pageSize"), String
                    .valueOf(CommonConstants.CLEDF_MAX_PAGE));
            i_PageSize = Integer.parseInt(str_PageSize);
            // 取得当前页号
            String str_CurPage = StringUtil.getRequestData(request.getParameter("curPage"), "1");
            i_CurPage = Integer.parseInt(str_CurPage);
        	
        	//查询条件-会员编号
        	String p_USER_ID = StringUtil.getRequestData(request.getParameter("USER_ID"),"");
        	//查询条件-姓名
        	String p_User_Name = StringUtil.getRequestData(request.getParameter("User_Name"),"");
        	//查询条件-性别
        	String p_USER_Sex = StringUtil.getRequestData(request.getParameter("USER_Sex"),"");
        	//查询条件-手机
        	String p_USER_Mobile = StringUtil.getRequestData(request.getParameter("User_Mobile"),"");
        	//查询条件-家庭住址省
        	String p_User_PROVINCE = StringUtil.getRequestData(request.getParameter("User_PROVINCE"),"");
        	//查询条件-家庭住址市
        	String p_User_CITY = StringUtil.getRequestData(request.getParameter("User_CITY"),"");
        	//查询条件-媒体方式
        	String p_USER_Media = StringUtil.getRequestData(request.getParameter("USER_Media"),"");
        	//查询条件-身份证号
        	String p_User_Card = StringUtil.getRequestData(request.getParameter("User_Card"),"");
        	//查询条件-合同单位
        	String p_User_Depart = StringUtil.getRequestData(request.getParameter("User_Depart"),"");
        	//查询条件-会员类别
        	String p_USER_Type = StringUtil.getRequestData(request.getParameter("USER_Type"),"");
        	//查询条件-累计积分起始
        	String p_User_Sunm_Beg = StringUtil.getRequestData(request.getParameter("User_Sunm_Beg"),"");
        	//查询条件-累计积分结束
        	String p_User_Sunm_End = StringUtil.getRequestData(request.getParameter("User_Sunm_End"),"");
        	//查询条件-挂号编号
        	String p_Ill_ID = StringUtil.getRequestData(request.getParameter("Ill_ID"),"");
        	//查询条件-就诊类别
        	String p_ILL_Type = StringUtil.getRequestData(request.getParameter("ILL_Type"),"");
        	//查询条件-就诊金额起始
        	String p_User_Money_From = StringUtil.getRequestData(request.getParameter("User_Money_From"),"");
        	//查询条件-就诊金额结束
        	String p_User_Money_To = StringUtil.getRequestData(request.getParameter("User_Money_To"),"");
        	//查询条件-院方比例起始
        	String p_User_Hos_From = StringUtil.getRequestData(request.getParameter("User_Hos_From"),"");
        	//查询条件-院方比例结束
        	String p_User_Hos_To = StringUtil.getRequestData(request.getParameter("User_Hos_To"),"");
        	//查询条件-单次积分起始
        	String p_User_Single_From = StringUtil.getRequestData(request.getParameter("User_Single_From"),"");
        	//查询条件-单次积分结束
        	String p_User_Single_To = StringUtil.getRequestData(request.getParameter("User_Single_To"),"");
        	//查询条件-病例
        	String p_User_ILL = StringUtil.getRequestData(request.getParameter("User_ILL"),"");
        	//查询条件-就诊时间起始
        	String p_User_DATE_From = StringUtil.getRequestData(request.getParameter("User_DATE_From"),"");
        	//查询条件-就诊时间结束
        	String p_User_DATE_To = StringUtil.getRequestData(request.getParameter("User_DATE_To"),"");
        	//查询条件-年龄
			String p_User_Age_From = StringUtil.getRequestData(request.getParameter("User_Age_From"), "");
			String p_User_Age_To = StringUtil.getRequestData(request.getParameter("User_Age_To"), "");
        	
        	//存放sql语句
            StringBuffer sb_SQL = new StringBuffer();
            sb_SQL.append(" SELECT * FROM ");
            sb_SQL.append("       (SELECT MEN.* ,T_ILL.C_CODE,T_ILL.C_DATE,T_ILL.C_ILL AS ILL,T_ILL.C_MONEY, ROUND(T_ILL.C_MONEY) AS S_MONEY , T_ILL.C_PERCENT,T_ILL.C_TYPE, t_memtype.C_TYPENAME FROM ");
            sb_SQL.append("       (select * from ");
            sb_SQL.append("       t_patient MAIN ");
            sb_SQL.append("       LEFT JOIN  (SELECT C_PATIENTID,SUM(CASE WHEN t_ill.C_MONEY IS NULL THEN 0 ELSE ROUND(t_ill.C_MONEY, 0) END) AS MONEY FROM ");
            sb_SQL.append("       t_ill GROUP BY C_PATIENTID) SUMMON  ");
            sb_SQL.append("       ON MAIN.c_id=SUMMON.C_PATIENTID ) MEN  ");
            sb_SQL.append("       LEFT JOIN t_ill  ");
            sb_SQL.append("       ON MEN.C_ID = t_ill.C_PATIENTID ");
            sb_SQL.append("       LEFT JOIN t_memtype ");
            sb_SQL.append("       ON MEN.C_MEMTYPE = t_memtype.C_ID)ALlMSG  ");
            sb_SQL.append("       WHERE   ");
            sb_SQL.append("  1=1  ");
            if(!"".equals(p_USER_ID)){
            	sb_SQL.append(" and ALlMSG.C_MEMCODE like '%"+p_USER_ID+"%'");
            }
            if(!"".equals(p_User_Name)){
            	sb_SQL.append(" and ALlMSG.C_NAME like '%"+p_User_Name+"%'");
            }
            if(!"".equals(p_USER_Sex)){
            	sb_SQL.append(" and ALlMSG.C_SEX = "+p_USER_Sex);
            }
            if(!"".equals(p_USER_Mobile)){
            	sb_SQL.append(" and ALlMSG.C_MOBILE like '%"+p_USER_Mobile+"%'");
            }
            if(!"".equals(p_User_PROVINCE)){
            	sb_SQL.append(" and ALlMSG.C_PROVINCE = "+p_User_PROVINCE);
            }
            if(!"".equals(p_User_CITY)){
            	sb_SQL.append(" and ALlMSG.C_CITY = "+p_User_CITY);
            }
            if(!"".equals(p_USER_Media)){
            	sb_SQL.append(" and ALlMSG.C_MEDIATYPE = "+p_USER_Media);
            }
            if(!"".equals(p_User_Card)){
            	sb_SQL.append(" and ALlMSG.C_IDCARD like '%"+p_User_Card+"%'");
            }
            if(!"".equals(p_User_Depart)){
            	sb_SQL.append(" and ALlMSG.C_COMPANY = "+p_User_Depart);
            }
            if(!"".equals(p_USER_Type)){
            	sb_SQL.append(" and ALlMSG.C_MEMTYPE = "+p_USER_Type);
            }
            if(!"".equals(p_Ill_ID)){
            	sb_SQL.append(" and ALlMSG.C_CODE like '%"+p_Ill_ID+"%'");
            }
            if(!"".equals(p_ILL_Type)){
            	sb_SQL.append(" and ALlMSG.C_TYPE = "+p_ILL_Type);
            }
            if(!"".equals(p_User_Money_From)){
            	sb_SQL.append(" and ALlMSG.C_MONEY >= "+p_User_Money_From);
            }
            if(!"".equals(p_User_Money_To)){
            	sb_SQL.append(" and ALlMSG.C_MONEY <= "+p_User_Money_To);
            }
            if(!"".equals(p_User_Hos_From)){
            	sb_SQL.append(" and ALlMSG.C_PERCENT >= "+p_User_Hos_From);
            }
            if(!"".equals(p_User_Hos_To)){
            	sb_SQL.append(" and ALlMSG.C_PERCENT <= "+p_User_Hos_To);
            }
            if(!"".equals(p_User_ILL)){
            	sb_SQL.append(" and ALlMSG.ILL like '%"+p_User_ILL+"%'");
            }
            
            if(!"".equals(p_User_DATE_From)){
            	sb_SQL.append(" and ALlMSG.C_DATE >= '"+p_User_DATE_From+"'");
            }
            
            if(!"".equals(p_User_DATE_To)){
            	sb_SQL.append(" and ALlMSG.C_DATE <= '"+p_User_DATE_To+"'");
            }
            
            if(!"".equals(p_User_Sunm_Beg)){
            	sb_SQL.append(" and ALlMSG.MONEY >= "+p_User_Sunm_Beg);
            }
            
            if(!"".equals(p_User_Sunm_End)){
            	sb_SQL.append(" and ALlMSG.MONEY <= "+p_User_Sunm_End);
            }
            
            if(!"".equals(p_User_Single_From)){
            	sb_SQL.append(" and ALlMSG.S_MONEY >= "+p_User_Single_From);
            }
            
            if(!"".equals(p_User_Single_To)){
            	sb_SQL.append(" and ALlMSG.S_MONEY <= "+p_User_Single_To);
            }
            
            if (p_User_Age_From.length() > 0) {
				sb_SQL.append("AND ALlMSG.C_AGE >= " + p_User_Age_From + " ");
			}
			if (p_User_Age_To.length() > 0) {
				sb_SQL.append("AND ALlMSG.C_AGE <= " + p_User_Age_To + " ");
			}
            
            // 设置sql
            rs.setSql(sb_SQL.toString());
            // 设置每页记录条数
            rs.setPageSize(i_PageSize);
            // 查询指定页记录
            res = rs.goPage(i_CurPage);
            //执行查询
            res = conn.Query(sb_SQL.toString());
            
            
            //是否查询成功
            //CLDEF_DB_OK   0：全部操作均正常结束，查到记录
            //CLDEF_DB_OK2  1：全部操作均正常结束，但没有符合查询条件的记录
            if(CommonConstants.CLDEF_DB_OK <= res.getStatus()){
            	//设置总记录数
            	parameters.setParameters("results", "recNum", String.valueOf(rs.getRecordCount()));
            	//设置每页记录数
                parameters.setParameters("results", "i_PageSize", String.valueOf(i_PageSize));
                // 设置当前页（列表分页相关参数）
                parameters.setParameters("results", "curPage", String.valueOf(rs.getCurPage()));
            	
                //将结果集保存到request中
                request.setAttribute("res",res);
                
                Map optionItemMap = com.getOptionItemMap("sex,mediaType,company,province,city,hosType");
				request.setAttribute("optionItemMap", optionItemMap);
				
				
				// 获取会员类别下拉列表
				String p_ILL_TypeOptionList = com.getHosTypeOptionList(p_ILL_Type);
				request.setAttribute("p_ILL_TypeOptionList", p_ILL_TypeOptionList);
				// 获取会员类别下拉列表
				String memTypeOptionList = com.getMemTypeOptionList(p_USER_Type);
				request.setAttribute("memTypeOptionList", memTypeOptionList);
				// 获取性别下拉列表
				String sexOptionList = com.getSexOptionList(p_USER_Sex);
				request.setAttribute("sexOptionList", sexOptionList);
				// 获取媒体方式下拉列表
				String mediaTypeOptionList = com.getMediaTypeOptionList(p_USER_Media);
				request.setAttribute("mediaTypeOptionList", mediaTypeOptionList);
				// 获取合同单位下拉列表
				String companyOptionList = com.getCompanyOptionList(p_User_Depart);
				request.setAttribute("companyOptionList", companyOptionList);
				// 获取所在地区-省下拉列表
				String provinceOptionList = com.getProvinceOptionList(p_User_PROVINCE);
				request.setAttribute("provinceOptionList", provinceOptionList);
				// 获取所在地区-市下拉列表
				String cityOptionList = "";
				if (p_User_PROVINCE.length() > 0) {
					cityOptionList = com.getCityOptionList(p_User_PROVINCE, p_User_CITY);
				}
				request.setAttribute("cityOptionList", cityOptionList);
				
				// 获取省市Map
				Map provinceCityMap = com.getProvinceCityMap();
				request.setAttribute("provinceCityMap", provinceCityMap);
                
				
				 //执行查询
	            res = conn.Query(sb_SQL.toString());
                
                //设置迁移首画面
                String str_URL = "/app/system/query_user.jsp";
                //画面迁移
                parameters.setParameters("results", "ForwardPage", str_URL);
            }else{
                //迁移到错误画面
                parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);           
            }
            
        }catch(Exception ex){
            System.out.println("Query_InfoBean:"+ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }

	}

	/**
	 * 页面表单检测处理机能
	 */
	public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters)
			throws CommonException {
	}

}