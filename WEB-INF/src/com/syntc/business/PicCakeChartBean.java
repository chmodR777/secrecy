////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2010 zq CORPORATION
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
 * CLASS ： PicCakeChartBean
 * VERSION ： 0.00
 * DESC : 饼图生成
 * DATE ： 2010-09-23
 * AUTHOR ： zhangqiang
 * HISTORY ：2010-09-23 作成
 */
package com.syntc.business;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class PicCakeChartBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public PicCakeChartBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * 业务逻辑处理机能
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        try {
        	//显示图片标志 1初始化，不显示  2带有统计时间和统计项，要显示
        	String flag = StringUtil.getRequestData(request.getParameter("flag"));
        	
        	String startYear = "";
        	String startMonth = "";
        	String endYear = "";
        	String endMonth = "";
        	String level1 = "";
        	String level2 = "";
        	
        	if("2".equals(flag)){
        		startYear = StringUtil.getRequestData(request.getParameter("txtStartYear"));
            	startMonth = StringUtil.getRequestData(request.getParameter("txtStartMonth"));
            	endYear = StringUtil.getRequestData(request.getParameter("txtEndYear"));
            	endMonth = StringUtil.getRequestData(request.getParameter("txtEndMonth"));
            	level1 = StringUtil.getRequestData(request.getParameter("txtLevel1Type"));
            	level2 = StringUtil.getRequestData(request.getParameter("txtLevel2Type"));
            	
            	
            	//折线图图片保存路径
            	String chartPath = request.getSession().getServletContext().getRealPath("/")+"chart";
            	//如果没有此文件夹，则创建
            	this.isChartPathExist(chartPath);
            	
            	//定义默认饼图数据结构
            	PieDataset dataset=new DefaultPieDataset(); 
            	//取得饼图数据
            	dataset = this.getAreaMedicineDataSet(startYear,startMonth,endYear,endMonth,level1,level2);
            	//定义饼图参数
            	JFreeChart chart = ChartFactory.createPieChart3D(   
                        "饼状统计图", // chart title   
                        dataset,// data   
                        true,// include legend   
                        true,   
                        false  
                       ); 
            	// 使下说明标签字体清晰,去锯齿类似于 
            	// chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);的效果 
            	chart.setTextAntiAlias(false); 
            	// 图片背景色 
            	chart.setBackgroundPaint(Color.white); 
            	// 设置图标题的字体    
                Font font = new Font(" 黑体",Font.CENTER_BASELINE,20); 
                //设置饼图标题
                TextTitle title = new TextTitle("饼状统计图"); 
                //设置饼图字体
                title.setFont(font);   
                //设置饼图标题
                chart.setTitle(title); 
                
                chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));
            	
            	//3D饼图
            	PiePlot3D  plot=(PiePlot3D)chart.getPlot();   
            	// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位   
                plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", 
                		NumberFormat.getNumberInstance(), 
                		new DecimalFormat("0.00%")));    
                // 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例                   
                plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})")); 
                // 设置无数据时的信息 
                plot.setNoDataMessage("无对应的数据，请重新查询。"); 
                // 设置无数据时的信息显示颜色 
                plot.setNoDataMessagePaint(Color.red); 
                // 指定图片的透明度(0.0-1.0)    
                plot.setForegroundAlpha(1.0f);    
                // 指定显示的饼图上圆形(false)还椭圆形(true)    
                plot.setCircular(true); 
                //设置内容字体
                Font fontContext = new Font("宋体", Font.BOLD, 12); 
                //设置字体
                plot.setLabelFont(fontContext);
                
                plot.setBackgroundPaint(new Color(255, 255, 204));
                
                //设置饼块颜色
                //plot.setSectionPaint(pieKeys[0], new Color(244, 194, 144)); 
                //plot.setSectionPaint(pieKeys[1], new Color(144, 233, 144)); 
                
                
                //定义文件输出流
                FileOutputStream fos_jpg = null;    
                try { 
                	//定义文件路径
                    fos_jpg=new FileOutputStream(chartPath + "\\PicPieChart.jpg");    
                    //设置图片属性
                    ChartUtilities.writeChartAsJPEG(fos_jpg,1,chart,640,480,null);
                    //关闭文件流
                    fos_jpg.close();    
                } catch (Exception e) { 
                	//e.printStackTrace();
                	parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
                } 
        	}
        	
        	//睡眠0.2秒，以保证图片生成时间
        	Thread.sleep(2000);
        	
        	request.setAttribute("flag", flag);
        	request.setAttribute("startYear", startYear);
        	request.setAttribute("startMonth", startMonth);
        	request.setAttribute("endYear", endYear);
        	request.setAttribute("endMonth", endMonth);
        	request.setAttribute("level1", level1);
        	request.setAttribute("level2", level2);
        	

            // 设置迁移画面
            String str_URL = "/app/system/pic_pie_chart.jsp";

            // 画面迁移
            parameters.setParameters("results", "ForwardPage", str_URL);
        } catch (Exception ex) {
            System.out.println("PicCakeChartBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    /**
     * 生成图片保存路径，如果不存在则创建
     * @param chartPath
     */
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    }
    
    /**
     * 
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @param level1
     * @param level2
     * @return
     */
    private DefaultPieDataset getAreaMedicineDataSet(String startYear,String startMonth,String endYear,String endMonth,String level1,String level2){
    	DefaultPieDataset dataset = new DefaultPieDataset();
    	ResultObj res = new ResultObj();
    	
    	//患者
    	if("1".equals(level1)){
    		//性别
    		if("1".equals(level2)){
    			res = this.getPatientSexData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("2".equals(level2)){
    		//年龄
    			res = this.getPatientAgeData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("3".equals(level2)){
    		//所在地区	
    			res = this.getPatientAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("4".equals(level2)){
    		//媒体方式
    			res = this.getPatientMediaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else{
    		//其他	
    			res = null;
    		}
    	}else if("2".equals(level1)){
    	//咨询	
    		
    		//性别
    		if("1".equals(level2)){
    			res = this.getConsultSexData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("2".equals(level2)){
    		//年龄	
    			res = this.getConsultAgeData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("3".equals(level2)){
    		//所在地区	
    			res = this.getConsultAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("4".equals(level2)){
    		//媒体方式	
    			res = this.getConsultMediaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else{
    		//其他
    			res = null;
    		}
    	}else if("3".equals(level1)){
    	//邮药	
    		//所在地区
    		if("3".equals(level2)){
    			res = this.getMedicineAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else{
    		//其他	
    			res = null;
    		}
    	}else{
    		//其他	
    		res = null;
    	}
    	
    	return dataset;
    }
    
    /**
     * 取得咨询-性别数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getConsultSexData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select sum(a.C_PERSONNUM) as persum,a.C_ITEMTYPE,b.C_NAME,a.C_MONTH  ");
		sb_SQL.append("   from t_consult a,t_optionitem b ");
		sb_SQL.append("  where a.C_ITEMTYPE = 'sex' ");
		sb_SQL.append("    and a.C_ITEMID = b.C_ID  ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("    and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("    and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.C_ITEMID ");
		sb_SQL.append("  order by a.C_ITEMID asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得咨询-年龄段数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getConsultAgeData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select sum(a.C_PERSONNUM) as persum,a.C_ITEMTYPE,b.C_NAME,a.C_MONTH  ");
		sb_SQL.append("   from t_consult a,t_optionitem b ");
		sb_SQL.append("  where a.C_ITEMTYPE = 'age' ");
		sb_SQL.append("    and a.C_ITEMID = b.C_ID  ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("    and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("    and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.C_ITEMID ");
		sb_SQL.append("  order by a.C_ITEMID asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得咨询-地区段数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getConsultAreaData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select sum(a.C_PERSONNUM) as persum,a.C_ITEMTYPE,b.C_NAME,a.C_MONTH  ");
		sb_SQL.append("   from t_consult a,t_optionitem b ");
		sb_SQL.append("  where a.C_ITEMTYPE = 'area' ");
		sb_SQL.append("    and a.C_ITEMID = b.C_ID  ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("    and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("    and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.C_ITEMID ");
		sb_SQL.append("  order by a.C_ITEMID asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得咨询-媒体类型段数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getConsultMediaData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select sum(a.C_PERSONNUM) as persum,a.C_ITEMTYPE,b.C_NAME,a.C_MONTH  ");
		sb_SQL.append("   from t_consult a,t_optionitem b ");
		sb_SQL.append("  where a.C_ITEMTYPE = 'mediaType' ");
		sb_SQL.append("    and a.C_ITEMID = b.C_ID  ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("    and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("    and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.C_ITEMID ");
		sb_SQL.append("  order by a.C_ITEMID asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得患者-性别数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getPatientSexData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select COUNT(*) as persum,a.C_SEX,b.C_NAME  ");
		sb_SQL.append("   from t_patient a,t_optionitem b ");
		sb_SQL.append("  where a.C_SEX = b.C_ID ");
		
		//通过t_ill查找出诊时间在统计时间范围内的数据  start
		sb_SQL.append("    and a.C_ID in ( ");
		sb_SQL.append("        select d.C_PATIENTID ");
		sb_SQL.append("          from ( ");
		sb_SQL.append("            select c.C_PATIENTID,MIN(c.C_DATE) as cdate,substr(MIN(c.C_DATE),1,7) as cmonth ");
		sb_SQL.append("              from t_ill c ");
		sb_SQL.append("             where 1=1 ");
		sb_SQL.append("             group by c.C_PATIENTID ");
		sb_SQL.append("               ) d ");
		sb_SQL.append("         where  1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and d.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and d.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("   ) ");
		//end
		
		sb_SQL.append("    and b.C_TYPE = 'sex'  ");
		sb_SQL.append("  group by a.C_SEX ");
		sb_SQL.append("  order by a.C_SEX asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得患者-年龄数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getPatientAgeData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select count(*) as persum,c.C_NAME  ");
		sb_SQL.append("   from ( ");
		sb_SQL.append("     SELECT a.C_ID,a.C_NAME,a.C_AGE,a.C_BIRTH,  ");
		sb_SQL.append("       case ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 10 then 62  ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 11  ");
		sb_SQL.append("        and (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 20  then 63 ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 21   ");
		sb_SQL.append("        and (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 30  then 64 ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 31 ");
		sb_SQL.append("        and (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 40  then 65 ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 41  ");
		sb_SQL.append("        and (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 50  then 66  ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 51 ");
		sb_SQL.append("        and (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 60  then 67 ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 61 ");
		sb_SQL.append("        and (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) <= 70  then 68  ");
		sb_SQL.append("       when (EXTRACT(YEAR FROM NOW()) - a.C_BIRTH) >= 71  then 69  ");
		sb_SQL.append("       else 70 ");
		sb_SQL.append("       end as itemID ");
		sb_SQL.append("     from t_patient a ");
		sb_SQL.append("    where 1=1 ");
		
		//通过t_ill查找出诊时间在统计时间范围内的数据  start
		sb_SQL.append("    and a.C_ID in ( ");
		sb_SQL.append("        select d.C_PATIENTID ");
		sb_SQL.append("          from ( ");
		sb_SQL.append("            select c.C_PATIENTID,MIN(c.C_DATE) as cdate,substr(MIN(c.C_DATE),1,7) as cmonth ");
		sb_SQL.append("              from t_ill c ");
		sb_SQL.append("             where 1=1 ");
		sb_SQL.append("             group by c.C_PATIENTID ");
		sb_SQL.append("               ) d ");
		sb_SQL.append("         where  1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and d.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and d.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("   ) ");
		//end
		
		sb_SQL.append("    order by itemID asc  ");
		sb_SQL.append("  ) b ,t_optionitem c ");
		sb_SQL.append("  where b.itemID = c.C_ID ");
		sb_SQL.append("  group by b.itemID ");
		sb_SQL.append("  order by b.itemID asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得患者-所在区域数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getPatientAreaData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select count(*) as persum,a.carea as C_NAME  ");
		sb_SQL.append("   from ( ");
		
		sb_SQL.append("  select b.C_ID,b.C_NAME,b.carea   ");
		sb_SQL.append("    from ( ");
		
		sb_SQL.append("     (select aa.C_ID,aa.C_NAME,'省内' as carea ");
		sb_SQL.append("        from t_patient aa  ");
		sb_SQL.append("       where aa.C_PROVINCE = 14) ");
		sb_SQL.append("  union ");
		sb_SQL.append("     (select bb.C_ID,bb.C_NAME,'国际' as carea ");
		sb_SQL.append("        from t_patient bb ");
		sb_SQL.append("       where bb.C_PROVINCE = 45) ");
		sb_SQL.append("  union ");
		sb_SQL.append("     (select cc.C_ID,cc.C_NAME,'省外' as carea ");
		sb_SQL.append("        from t_patient cc ");
		sb_SQL.append("       where cc.C_PROVINCE in ");
		sb_SQL.append("             (15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44)) ");
		
		sb_SQL.append("    ) b ");
		sb_SQL.append("   where 1=1  ");
		//通过t_ill查找出诊时间在统计时间范围内的数据  start
		sb_SQL.append("    and b.C_ID in ( ");
		sb_SQL.append("        select d.C_PATIENTID ");
		sb_SQL.append("          from ( ");
		sb_SQL.append("            select c.C_PATIENTID,MIN(c.C_DATE) as cdate,substr(MIN(c.C_DATE),1,7) as cmonth ");
		sb_SQL.append("              from t_ill c ");
		sb_SQL.append("             where 1=1 ");
		sb_SQL.append("             group by c.C_PATIENTID ");
		sb_SQL.append("               ) d ");
		sb_SQL.append("         where  1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and d.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and d.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("   ) ");
		//end
		
		sb_SQL.append("    ) a ");
		sb_SQL.append("  group by a.carea ");
		sb_SQL.append("  order by a.carea desc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得患者-媒体类型数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getPatientMediaData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select COUNT(*) as persum,a.C_MEDIATYPE,b.C_NAME  ");
		sb_SQL.append("   from t_patient a,t_optionitem b ");
		sb_SQL.append("  where a.C_MEDIATYPE = b.C_ID ");
		sb_SQL.append("    and b.C_TYPE = 'mediaType'  ");
		
		//通过t_ill查找出诊时间在统计时间范围内的数据  start
		sb_SQL.append("    and a.C_ID in ( ");
		sb_SQL.append("        select d.C_PATIENTID ");
		sb_SQL.append("          from ( ");
		sb_SQL.append("            select c.C_PATIENTID,MIN(c.C_DATE) as cdate,substr(MIN(c.C_DATE),1,7) as cmonth ");
		sb_SQL.append("              from t_ill c ");
		sb_SQL.append("             where 1=1 ");
		sb_SQL.append("             group by c.C_PATIENTID ");
		sb_SQL.append("               ) d ");
		sb_SQL.append("         where  1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and d.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and d.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("    ) ");
		//end
		
		sb_SQL.append("  group by a.C_MEDIATYPE ");
		sb_SQL.append("  order by a.C_MEDIATYPE asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * 取得邮药-所在地区数据
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    private ResultObj getMedicineAreaData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select a.persum,a.carea as C_NAME  ");
		sb_SQL.append("   from ( ");
		sb_SQL.append("     (select case  ");
		sb_SQL.append("             when sum(aa.C_PERSONNUM) is not null then sum(aa.C_PERSONNUM)  ");
		sb_SQL.append("             else 0  ");
		sb_SQL.append("             end as persum,'省内' as carea ,aa.C_MONTH  ");
		sb_SQL.append("        from t_medicine aa  ");
		sb_SQL.append("       where aa.C_ITEMID in ( 14,46,47,48,49,50,51,52,53,54,55,56,57,58,59) ");
		sb_SQL.append("     ) union ");
		sb_SQL.append("     (select case ");
		sb_SQL.append("             when sum(bb.C_PERSONNUM) is not null then sum(bb.C_PERSONNUM) ");
		sb_SQL.append("             else 0 ");
		sb_SQL.append("             end as persum,'省外' as carea ,bb.C_MONTH  ");
		sb_SQL.append("        from t_medicine bb ");
		sb_SQL.append("       where bb.C_ITEMID in (15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44)  ");
		sb_SQL.append("     )union ");
		sb_SQL.append("     (select case ");
		sb_SQL.append("              when sum(cc.C_PERSONNUM) is not null then sum(cc.C_PERSONNUM) ");
		sb_SQL.append("              else 0  ");
		sb_SQL.append("              end as persum,'国际' as carea ,cc.C_MONTH  ");
		sb_SQL.append("        from t_medicine cc ");
		sb_SQL.append("       where cc.C_ITEMID = 45 ");
		sb_SQL.append("     )) a ");
		sb_SQL.append("  where 1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.carea ");
		sb_SQL.append("  order by a.carea asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
}