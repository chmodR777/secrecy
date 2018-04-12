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
 * CLASS ： PicLineXYChartBean
 * VERSION ： 0.00
 * DESC : 折线图生成
 * DATE ： 2010-09-23
 * AUTHOR ： zhangqiang
 * HISTORY ：2010-09-23 作成
 */
package com.syntc.business;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class PicLineXYChartBean extends BusinessLogic {
    /**
     * 构造函数
     */
    public PicLineXYChartBean() {
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
        	String[] cntItem = null;
        	
        	//2带有统计时间和统计项，要显示	
        	if("2".equals(flag)){
        		//开始年
            	startYear = StringUtil.getRequestData(request.getParameter("txtStartYear"));
            	//开始月
            	startMonth = StringUtil.getRequestData(request.getParameter("txtStartMonth"));
            	//结束年
            	endYear = StringUtil.getRequestData(request.getParameter("txtEndYear"));
            	//结束月
            	endMonth = StringUtil.getRequestData(request.getParameter("txtEndMonth"));
            	
            	//统计项
            	cntItem = (String[])request.getParameterValues("cntItem");
            	
            	//折线图图片保存路径
            	String chartPath = request.getSession().getServletContext().getRealPath("/")+"chart";
            	//如果没有此文件夹，则创建
            	this.isChartPathExist(chartPath);
            	//定义数据集
            	CategoryDataset dataset = new DefaultCategoryDataset();
            	//从数据库中取得数据集
            	dataset = this.getSexDateConsultDataSet(startYear,startMonth,endYear,endMonth,cntItem);
            	//定义图形对象
            	JFreeChart chart = ChartFactory.createLineChart(
            	"折线统计图", // 图表标题
            	"统计项", // 目录轴的显示标签
            	"数量", // 数值轴的显示标签
            	dataset, // 数据集
            	PlotOrientation.VERTICAL, // 图表方向：水平、垂直
            	true, // 是否显示图例(对于简单的柱状图必须是false)
            	false, // 是否生成工具
            	false // 是否生成URL链接
            	);
            	
            	//设置消除字体的锯齿渲染（解决中文问题
            	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
            	RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

            	// 1,设置整个图表背景颜色
            	chart.setBackgroundPaint(Color.WHITE);
            	
            	// 设置图标题的字体    
                Font font = new Font(" 黑体",Font.CENTER_BASELINE,20); 
                //设置饼图标题
                TextTitle title = new TextTitle("折线统计图"); 
                //设置饼图字体
                title.setFont(font);   
                //设置饼图标题
                chart.setTitle(title); 
                
                chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));

            	//设定Plot参数
            	CategoryPlot plot = chart.getCategoryPlot();
            	
            	// 设置面板字体 
            	Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12); 

            	// 2,设置详细图表的显示细节部分的背景颜色
            	plot.setBackgroundPaint(new Color(255, 255, 204));
            	// 3,设置垂直网格线颜色
            	plot.setDomainGridlinePaint(Color.black);
            	//4,设置是否显示垂直网格线
            	plot.setDomainGridlinesVisible(true);
            	//5,设置水平网格线颜色
            	plot.setRangeGridlinePaint(Color.blue);
            	//6,设置是否显示水平网格线
            	plot.setRangeGridlinesVisible(true);
            	
            	// 设置无数据时的信息 
                plot.setNoDataMessage("无对应的数据，请重新查询。"); 
                // 设置无数据时的信息显示颜色 
                plot.setNoDataMessagePaint(Color.red); 
            	
            	// 设置轴和面板之间的距离 
            	plot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D)); 

            	CategoryAxis domainAxis = plot.getDomainAxis(); 
            	domainAxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 10));  
            	domainAxis.setLabelFont(labelFont);// 轴标题 
            	domainAxis.setTickLabelFont(labelFont);// 轴数值 
            	domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的 
            	
            	NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();   
            	/*------设置Y轴坐标上的文字-----------*/ 
            	numberaxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 10));   
            	/*------设置Y轴的标题文字------------*/ 
            	numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 10));
            	
            	LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)	plot.getRenderer(); 

            	lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见 
            	lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
            	
            	// 显示折点数据 
            	lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
            	lineandshaperenderer.setBaseItemLabelsVisible(true); 


            	
                //定义文件输出流
                FileOutputStream fos_jpg = null;    
                try { 
                	//定义文件路径
                    fos_jpg=new FileOutputStream(chartPath+"\\PicLineXYChart.jpg");    
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
        	request.setAttribute("cntItem", cntItem);
        	

            // 设置迁移画面
            String str_URL = "/app/system/pic_linexy_chart.jsp";

            // 画面迁移
            parameters.setParameters("results", "ForwardPage", str_URL);
        } catch (Exception ex) {
            System.out.println("PicLineXYChartBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    /**
     * 取得线图数据
     * @return
     */
    private DefaultCategoryDataset getSexDateConsultDataSet(String startYear,String startMonth,String endYear,String endMonth,String[] cntItem){
    	//返回值
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	//结果集
    	ResultObj res = new ResultObj();
    	//取得多个结果集设置到dataset中
    	for(String item : cntItem){
    		if("1".equals(item)){
    			//咨询量
    			res = this.getConsultNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "咨询量" , res.getCell("C_MONTH", i));
            	}
    		}else if("2".equals(item)){
    			//邮药量
    			res = this.getMedicineNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "邮药量" , res.getCell("C_MONTH", i));
            	}
    		}else if("3".equals(item)){
    			//初诊量
    			res = this.getFirstComeNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "初诊量" , res.getCell("C_MONTH", i));
            	}
    		}else if("4".equals(item)){
    			//复诊量
    			res = this.getMultyComeNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "复诊量" , res.getCell("C_MONTH", i));
            	}
    		}else if("5".equals(item)){
    			//总就诊量
    			res = this.getSumComeNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "总就诊量" , res.getCell("C_MONTH", i) );
            	}
    		}else if("6".equals(item)){
    			//住院量
    			res = this.getHospitalNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "住院量" , res.getCell("C_MONTH", i));
            	}
    		}
    	}
        
    	/*
    	dataset.addValue(100, "北京", "一月");
    	dataset.addValue(200, "北京", "二月");
    	dataset.addValue(100, "北京", "三月");
    	dataset.addValue(400, "北京", "四月");
    	dataset.addValue(300, "北京", "五月");
    	dataset.addValue(500, "北京", "六月");
    	dataset.addValue(90, "北京", "七月");
    	dataset.addValue(700, "北京", "八月");
    	dataset.addValue(800, "北京", "九月");
    	dataset.addValue(1000, "北京", "十月");
    	dataset.addValue(300, "北京", "十一月");
    	dataset.addValue(700, "北京", "十二月");
    	dataset.addValue(1200, "上海", "一月");
    	dataset.addValue(1100, "上海", "二月");
    	dataset.addValue(1000, "上海", "三月");
    	dataset.addValue(900, "上海", "四月");
    	dataset.addValue(800, "上海", "五月");
    	dataset.addValue(700, "上海", "六月");
    	dataset.addValue(800, "上海", "七月");
    	dataset.addValue(500, "上海", "八月");
    	dataset.addValue(400, "上海", "九月");
    	dataset.addValue(300, "上海", "十月");
    	dataset.addValue(200, "上海", "十一月");
    	dataset.addValue(100, "上海", "十二月");
    	dataset.addValue(600, "武汉", "一月");
    	dataset.addValue(500, "武汉", "二月");
    	dataset.addValue(400, "武汉", "三月");
    	dataset.addValue(300, "武汉", "四月");
    	dataset.addValue(200, "武汉", "五月");
    	dataset.addValue(100, "武汉", "六月");
    	dataset.addValue(200, "武汉", "七月");
    	dataset.addValue(300, "武汉", "八月");
    	dataset.addValue(400, "武汉", "九月");
    	dataset.addValue(500, "武汉", "十月");
    	dataset.addValue(600, "武汉", "十一月");
    	dataset.addValue(700, "武汉", "十二月");
    	
    	*/

    	
    	return dataset;
    }
    //取得咨询量
    private ResultObj getConsultNum(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
    	
    	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select sum(a.C_PERSONNUM) as persum,a.C_ITEMTYPE,a.C_MONTH  ");
		sb_SQL.append("   from t_consult a ");
		sb_SQL.append("  where a.C_ITEMTYPE = 'sex' ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("    and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("    and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.C_MONTH ");
		sb_SQL.append("  order by a.C_MONTH asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    //取得邮药量
    private ResultObj getMedicineNum(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
    	
    	DBOperate conn = new DBOperate();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select sum(a.C_PERSONNUM) as persum,a.C_ITEMTYPE,a.C_MONTH ");
		sb_SQL.append("   from t_medicine a ");
		sb_SQL.append("  where 1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and a.C_MONTH >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and a.C_MONTH <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by a.C_MONTH ");
		sb_SQL.append("  order by a.C_MONTH asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	
    	return res;
    }
    
    //取得初诊量
    private ResultObj getFirstComeNum(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
    	
    	DBOperate conn = new DBOperate();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select count(*) as persum ,b.cmonth as C_MONTH ");
		sb_SQL.append("   from(  ");
		sb_SQL.append("   		select a.C_PATIENTID as pid ,substr(a.C_DATE,1,7) as cmonth,MIN(a.C_DATE) as cdate  ");
		sb_SQL.append("   		from t_ill a group by a.C_PATIENTID) b  ");
		sb_SQL.append("  where 1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and b.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and b.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by b.cmonth ");
		sb_SQL.append("  order by b.cmonth asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	
    	return res;
    }
    
    //取得复诊量
    private ResultObj getMultyComeNum(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
    	DBOperate conn = new DBOperate();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select count(*) as persum ,b.cmonth as C_MONTH ");
		sb_SQL.append("   from(  ");
		sb_SQL.append("     select a.C_ID ,a.C_PATIENTID as pid ,substr(a.C_DATE,1,7) as cmonth,a.C_DATE as cdate  ");
		sb_SQL.append("   	  from t_ill a  ");
		sb_SQL.append("      where a.C_ID not in (  ");
		sb_SQL.append("   	   select d.C_ID    ");
		sb_SQL.append("   	     from ( ");
		sb_SQL.append("   	       select c.C_ID, c.C_PATIENTID as pid,MIN(c.C_DATE) ");
		sb_SQL.append("   	         from t_ill c ");
		sb_SQL.append("   	          group by c.C_PATIENTID order by c.C_ID asc ) d ");
		sb_SQL.append("       )) b ");
		sb_SQL.append("  where 1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and b.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and b.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by b.cmonth ");
		sb_SQL.append("  order by b.cmonth asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    //取得总就诊量
    private ResultObj getSumComeNum(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
    	DBOperate conn = new DBOperate();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select count(*) as persum ,b.cmonth as C_MONTH ");
		sb_SQL.append("   from(  ");
		sb_SQL.append("   		select a.C_PATIENTID as pid ,substr(a.C_DATE,1,7) as cmonth,a.C_DATE as cdate  ");
		sb_SQL.append("   		from t_ill a ) b  ");
		sb_SQL.append("  where 1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and b.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and b.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by b.cmonth ");
		sb_SQL.append("  order by b.cmonth asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    //取得住院量
    private ResultObj getHospitalNum(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
    	DBOperate conn = new DBOperate();
		
		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select count(*) as persum ,b.cmonth as C_MONTH ");
		sb_SQL.append("   from(  ");
		sb_SQL.append("   		select a.C_PATIENTID,substr(a.C_DATE,1,7) as cmonth,a.C_DATE as cdate  ");
		sb_SQL.append("   		from t_ill a where a.C_TYPE = 61 ) b  ");
		sb_SQL.append("  where 1=1 ");
		if(!"".equals(startYear) && !"".equals(startMonth)){
			sb_SQL.append("  and b.cmonth >= '" + startYear + "-" + startMonth + "'");
		}
		if(!"".equals(endYear) && !"".equals(endMonth)){
			sb_SQL.append("  and b.cmonth <= '" + endYear + "-" + endMonth + "'");
		}
		sb_SQL.append("  group by b.cmonth ");
		sb_SQL.append("  order by b.cmonth asc ");
		
		// 执行查询
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    } 

}