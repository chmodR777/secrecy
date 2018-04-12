package com.syntc.business;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.syntc.common.action.BusinessLogic;
import com.syntc.constants.CommonConstants;
import com.syntc.util.CommonException;
import com.syntc.util.DBOperate;
import com.syntc.util.Parameters;
import com.syntc.util.ResultObj;
import com.syntc.util.StringUtil;

public class PicBar2ChartBean extends BusinessLogic {
	
    /**
     * 构造函数
     */
    public PicBar2ChartBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Parameters parameters)
			throws CommonException {
		
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
            	//定义数据集
            	CategoryDataset dataset = new DefaultCategoryDataset();
            	//从数据库中取得数据集
            	dataset = this.getSexDateConsultDataSet(startYear,startMonth,endYear,endMonth,level1,level2);
            	//创建图形对象
            	JFreeChart chart = ChartFactory.createBarChart3D(
            	"柱型统计图", // 图表标题
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
            	
            	Font labelFont = new Font("宋体", Font.BOLD, 12);  
            	/* 
            	* VALUE_TEXT_ANTIALIAS_OFF表示将文字的抗锯齿关闭, 
            	* 使用的关闭抗锯齿后，字体尽量选择12到14号的宋体字,这样文字最清晰好看 
            	*/ 
            	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF); 
            	chart.setTextAntiAlias(false); 
            	
            	chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));
            	
            	// create plot 
            	CategoryPlot plot = chart.getCategoryPlot(); 
            	// 设置横虚线可见 
            	plot.setRangeGridlinesVisible(true); 
            	// 虚线色彩 
            	plot.setRangeGridlinePaint(Color.gray); 
            	
            	// 设置无数据时的信息 
                plot.setNoDataMessage("无对应的数据，请重新查询。"); 
                // 设置无数据时的信息显示颜色 
                plot.setNoDataMessagePaint(Color.red); 

            	// 数据轴精度 
            	NumberAxis vn = (NumberAxis) plot.getRangeAxis(); 
            	// vn.setAutoRangeIncludesZero(true); 
            	DecimalFormat df = new DecimalFormat("#0.00"); 
            	vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式 
            	// x轴设置 
            	CategoryAxis domainAxis = plot.getDomainAxis(); 
            	domainAxis.setLabelFont(labelFont);// 轴标题 
            	domainAxis.setTickLabelFont(labelFont);// 轴数值 

            	// Lable（Math.PI/3.0）度倾斜 
            	// domainAxis.setCategoryLabelPositions(CategoryLabelPositions 
            	// .createUpRotationLabelPositions(Math.PI / 3.0)); 

            	domainAxis.setMaximumCategoryLabelWidthRatio(0.6f);// 横轴上的 Lable 是否完整显示 

            	// 设置距离图片左端距离 
            	domainAxis.setLowerMargin(0.1); 
            	// 设置距离图片右端距离 
            	domainAxis.setUpperMargin(0.1); 
            	// 设置 columnKey 是否间隔显示 
            	// domainAxis.setSkipCategoryLabelsToFit(true); 

            	plot.setDomainAxis(domainAxis); 
            	// 设置柱图背景色（注意，系统取色的时候要使用16位的模式来查看颜色编码，这样比较准确） 
            	plot.setBackgroundPaint(new Color(255, 255, 204)); 

            	// y轴设置 
            	ValueAxis rangeAxis = plot.getRangeAxis(); 
            	rangeAxis.setLabelFont(labelFont); 
            	rangeAxis.setTickLabelFont(labelFont); 
            	// 设置最高的一个 Item 与图片顶端的距离 
            	rangeAxis.setUpperMargin(0.15); 
            	// 设置最低的一个 Item 与图片底端的距离 
            	rangeAxis.setLowerMargin(0.15); 
            	plot.setRangeAxis(rangeAxis); 

            	BarRenderer renderer = new BarRenderer(); 
            	// 设置柱子宽度 
            	renderer.setMaximumBarWidth(0.05); 
            	// 设置柱子高度 
            	renderer.setMinimumBarLength(0.2); 
            	// 设置柱子边框颜色 
            	renderer.setBaseOutlinePaint(Color.BLACK); 
            	// 设置柱子边框可见 
            	renderer.setDrawBarOutline(true); 

            	// // 设置柱的颜色 
            	//renderer.setSeriesPaint(0, new Color(204, 255, 255)); 
            	//renderer.setSeriesPaint(1, new Color(153, 204, 255)); 
            	//renderer.setSeriesPaint(2, new Color(51, 204, 204)); 

            	// 设置每个地区所包含的平行柱的之间距离 
            	renderer.setItemMargin(0.0); 

            	// 显示每个柱的数值，并修改该数值的字体属性 
            	renderer.setIncludeBaseInRange(true); 
            	renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
            	renderer.setBaseItemLabelsVisible(true); 

            	plot.setRenderer(renderer); 
            	// 设置柱的透明度 
            	plot.setForegroundAlpha(1.0f); 

            	
            	// 设置图标题的字体    
                Font font = new Font(" 黑体",Font.CENTER_BASELINE,20); 
                //设置柱图标题
                TextTitle title = new TextTitle("柱型统计图"); 
                //设置柱图字体
                title.setFont(font);   
                //设置柱图标题
                chart.setTitle(title); 


            	
                //定义文件输出流
                FileOutputStream fos_jpg = null;    
                try { 
                	//定义文件路径
                    fos_jpg=new FileOutputStream(chartPath+"\\PicBar2Chart.jpg");    
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
            String str_URL = "/app/system/pic_bar2_chart.jsp";

            // 画面迁移
            parameters.setParameters("results", "ForwardPage", str_URL);
        } catch (Exception ex) {
            System.out.println("PicBarChartBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
	}
	
    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    private void isChartPathExist(String chartPath) { 
    	File file = new File(chartPath); 
    	if (!file.exists()) { 
    		file.mkdirs(); 
    	} 
    }
    
    /**
     * 取得柱图2数据
     * @return
     */
    private DefaultCategoryDataset getSexDateConsultDataSet(String startYear,String startMonth,String endYear,String endMonth,String level1,String level2){
    	//返回值
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	//结果集
    	ResultObj res = new ResultObj();
    	
    	//患者
    	if("1".equals(level1)){
    		//性别
    		if("1".equals(level2)){
    			res = this.getPatientSexData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else if("2".equals(level2)){
    		//年龄	
    			res = this.getPatientAgeData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else if("3".equals(level2)){
    		//所在地区	
    			res = this.getPatientAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else if("4".equals(level2)){
    		//媒体方式
    			res = this.getPatientMediaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
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
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else if("2".equals(level2)){
    		//年龄	
    			res = this.getConsultAgeData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else if("3".equals(level2)){
    		//所在地区	
    			res = this.getConsultAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else if("4".equals(level2)){
    		//媒体方式	
    			res = this.getConsultMediaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
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
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), res.getCell("C_NAME", i) , res.getCell("C_MONTH", i));
            	}
    		}else{
    		//其他	
    			res = null;
    		}
    	}else{
    		//其他	
    		res = null;
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
		sb_SQL.append("  group by a.C_ITEMID,a.C_MONTH ");
		sb_SQL.append("  order by a.C_ITEMID,a.C_MONTH asc ");
		
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
		sb_SQL.append("  group by a.C_ITEMID,a.C_MONTH ");
		sb_SQL.append("  order by a.C_ITEMID,a.C_MONTH asc ");
		
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
		sb_SQL.append("  group by a.C_ITEMID,a.C_MONTH ");
		sb_SQL.append("  order by a.C_ITEMID,a.C_MONTH asc ");
		
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
		sb_SQL.append("  group by a.C_ITEMID,a.C_MONTH ");
		sb_SQL.append("  order by a.C_ITEMID,a.C_MONTH asc ");
		
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
		sb_SQL.append(" select COUNT(*) as persum,a.C_SEX,b.C_NAME,substr(e.C_DATE,1,7) as C_MONTH  ");
		sb_SQL.append("   from t_patient a,t_optionitem b,t_ill e ");
		sb_SQL.append("  where a.C_SEX = b.C_ID ");
		sb_SQL.append("    and a.C_ID = e.C_PATIENTID ");
		
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
		sb_SQL.append(" select count(*) as persum,c.C_NAME,b.C_MONTH  ");
		sb_SQL.append("   from ( ");
		sb_SQL.append("     SELECT a.C_ID,a.C_NAME,a.C_AGE,a.C_BIRTH,substr(e.C_DATE,1,7) as C_MONTH ,  ");
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
		sb_SQL.append("     from t_patient a,t_ill e  ");
		sb_SQL.append("    where 1=1 ");
		sb_SQL.append("      and a.C_ID = e.C_PATIENTID ");
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
     * 取得患者-所在地区数据
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
		sb_SQL.append(" select count(*) as persum,a.carea as C_NAME,a.C_MONTH  ");
		sb_SQL.append("   from ( ");
		
		sb_SQL.append("  select b.C_ID,b.C_NAME,b.carea,substr(e.C_DATE,1,7) as C_MONTH   ");
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
		
		sb_SQL.append("    ) b,t_ill e  ");
		sb_SQL.append("   where 1=1  ");
		sb_SQL.append("     and b.C_ID = e.C_PATIENTID  ");
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
     * 患者-媒体类型数据
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
		sb_SQL.append(" select COUNT(*) as persum,a.C_MEDIATYPE,b.C_NAME ,substr(e.C_DATE,1,7) as C_MONTH  ");
		sb_SQL.append("   from t_patient a,t_optionitem b,t_ill e ");
		sb_SQL.append("  where a.C_MEDIATYPE = b.C_ID ");
		sb_SQL.append("    and a.C_ID = e.C_PATIENTID ");
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

    private ResultObj getMedicineAreaData(String startYear,String startMonth,String endYear,String endMonth){
    	ResultObj res = new ResultObj();
       	DBOperate conn = new DBOperate();

		StringBuffer sb_SQL = new StringBuffer();
		sb_SQL.append(" select a.persum,a.carea as C_NAME ,a.C_MONTH  ");
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
