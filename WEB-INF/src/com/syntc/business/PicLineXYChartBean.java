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
 * CLASS �� PicLineXYChartBean
 * VERSION �� 0.00
 * DESC : ����ͼ����
 * DATE �� 2010-09-23
 * AUTHOR �� zhangqiang
 * HISTORY ��2010-09-23 ����
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
     * ���캯��
     */
    public PicLineXYChartBean() {
        if (CommonConstants.CLDEF_DEBUG) {
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
        }
    }

    /**
     * ҵ���߼��������
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
        try {
        	//��ʾͼƬ��־ 1��ʼ��������ʾ  2����ͳ��ʱ���ͳ���Ҫ��ʾ
        	String flag = StringUtil.getRequestData(request.getParameter("flag"));
        	
        	String startYear = "";
        	String startMonth = "";
        	String endYear = "";
        	String endMonth = "";
        	String[] cntItem = null;
        	
        	//2����ͳ��ʱ���ͳ���Ҫ��ʾ	
        	if("2".equals(flag)){
        		//��ʼ��
            	startYear = StringUtil.getRequestData(request.getParameter("txtStartYear"));
            	//��ʼ��
            	startMonth = StringUtil.getRequestData(request.getParameter("txtStartMonth"));
            	//������
            	endYear = StringUtil.getRequestData(request.getParameter("txtEndYear"));
            	//������
            	endMonth = StringUtil.getRequestData(request.getParameter("txtEndMonth"));
            	
            	//ͳ����
            	cntItem = (String[])request.getParameterValues("cntItem");
            	
            	//����ͼͼƬ����·��
            	String chartPath = request.getSession().getServletContext().getRealPath("/")+"chart";
            	//���û�д��ļ��У��򴴽�
            	this.isChartPathExist(chartPath);
            	//�������ݼ�
            	CategoryDataset dataset = new DefaultCategoryDataset();
            	//�����ݿ���ȡ�����ݼ�
            	dataset = this.getSexDateConsultDataSet(startYear,startMonth,endYear,endMonth,cntItem);
            	//����ͼ�ζ���
            	JFreeChart chart = ChartFactory.createLineChart(
            	"����ͳ��ͼ", // ͼ�����
            	"ͳ����", // Ŀ¼�����ʾ��ǩ
            	"����", // ��ֵ�����ʾ��ǩ
            	dataset, // ���ݼ�
            	PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
            	true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
            	false, // �Ƿ����ɹ���
            	false // �Ƿ�����URL����
            	);
            	
            	//������������ľ����Ⱦ�������������
            	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
            	RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

            	// 1,��������ͼ������ɫ
            	chart.setBackgroundPaint(Color.WHITE);
            	
            	// ����ͼ���������    
                Font font = new Font(" ����",Font.CENTER_BASELINE,20); 
                //���ñ�ͼ����
                TextTitle title = new TextTitle("����ͳ��ͼ"); 
                //���ñ�ͼ����
                title.setFont(font);   
                //���ñ�ͼ����
                chart.setTitle(title); 
                
                chart.getLegend().setItemFont(new Font("����", Font.BOLD, 10));

            	//�趨Plot����
            	CategoryPlot plot = chart.getCategoryPlot();
            	
            	// ����������� 
            	Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12); 

            	// 2,������ϸͼ�����ʾϸ�ڲ��ֵı�����ɫ
            	plot.setBackgroundPaint(new Color(255, 255, 204));
            	// 3,���ô�ֱ��������ɫ
            	plot.setDomainGridlinePaint(Color.black);
            	//4,�����Ƿ���ʾ��ֱ������
            	plot.setDomainGridlinesVisible(true);
            	//5,����ˮƽ��������ɫ
            	plot.setRangeGridlinePaint(Color.blue);
            	//6,�����Ƿ���ʾˮƽ������
            	plot.setRangeGridlinesVisible(true);
            	
            	// ����������ʱ����Ϣ 
                plot.setNoDataMessage("�޶�Ӧ�����ݣ������²�ѯ��"); 
                // ����������ʱ����Ϣ��ʾ��ɫ 
                plot.setNoDataMessagePaint(Color.red); 
            	
            	// ����������֮��ľ��� 
            	plot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D)); 

            	CategoryAxis domainAxis = plot.getDomainAxis(); 
            	domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 10));  
            	domainAxis.setLabelFont(labelFont);// ����� 
            	domainAxis.setTickLabelFont(labelFont);// ����ֵ 
            	domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // �����ϵ� 
            	
            	NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();   
            	/*------����Y�������ϵ�����-----------*/ 
            	numberaxis.setTickLabelFont(new Font("����", Font.PLAIN, 10));   
            	/*------����Y��ı�������------------*/ 
            	numberaxis.setLabelFont(new Font("����", Font.PLAIN, 10));
            	
            	LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)	plot.getRenderer(); 

            	lineandshaperenderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ� 
            	lineandshaperenderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�
            	
            	// ��ʾ�۵����� 
            	lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
            	lineandshaperenderer.setBaseItemLabelsVisible(true); 


            	
                //�����ļ������
                FileOutputStream fos_jpg = null;    
                try { 
                	//�����ļ�·��
                    fos_jpg=new FileOutputStream(chartPath+"\\PicLineXYChart.jpg");    
                    //����ͼƬ����
                    ChartUtilities.writeChartAsJPEG(fos_jpg,1,chart,640,480,null);
                    //�ر��ļ���
                    fos_jpg.close();    
                } catch (Exception e) { 
                	//e.printStackTrace();
                	parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
                }
        	}
        	
        	//˯��0.2�룬�Ա�֤ͼƬ����ʱ��
        	Thread.sleep(2000); 
        	
        	request.setAttribute("flag", flag);
        	request.setAttribute("startYear", startYear);
        	request.setAttribute("startMonth", startMonth);
        	request.setAttribute("endYear", endYear);
        	request.setAttribute("endMonth", endMonth);
        	request.setAttribute("cntItem", cntItem);
        	

            // ����Ǩ�ƻ���
            String str_URL = "/app/system/pic_linexy_chart.jsp";

            // ����Ǩ��
            parameters.setParameters("results", "ForwardPage", str_URL);
        } catch (Exception ex) {
            System.out.println("PicLineXYChartBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    
    /**
     * ȡ����ͼ����
     * @return
     */
    private DefaultCategoryDataset getSexDateConsultDataSet(String startYear,String startMonth,String endYear,String endMonth,String[] cntItem){
    	//����ֵ
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	//�����
    	ResultObj res = new ResultObj();
    	//ȡ�ö����������õ�dataset��
    	for(String item : cntItem){
    		if("1".equals(item)){
    			//��ѯ��
    			res = this.getConsultNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "��ѯ��" , res.getCell("C_MONTH", i));
            	}
    		}else if("2".equals(item)){
    			//��ҩ��
    			res = this.getMedicineNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "��ҩ��" , res.getCell("C_MONTH", i));
            	}
    		}else if("3".equals(item)){
    			//������
    			res = this.getFirstComeNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "������" , res.getCell("C_MONTH", i));
            	}
    		}else if("4".equals(item)){
    			//������
    			res = this.getMultyComeNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "������" , res.getCell("C_MONTH", i));
            	}
    		}else if("5".equals(item)){
    			//�ܾ�����
    			res = this.getSumComeNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "�ܾ�����" , res.getCell("C_MONTH", i) );
            	}
    		}else if("6".equals(item)){
    			//סԺ��
    			res = this.getHospitalNum(startYear, startMonth, endYear, endMonth);
    			for (int i = 1; i < res.size(); i++) {
            		dataset.addValue(Double.parseDouble(res.getCell("persum", i)), "סԺ��" , res.getCell("C_MONTH", i));
            	}
    		}
    	}
        
    	/*
    	dataset.addValue(100, "����", "һ��");
    	dataset.addValue(200, "����", "����");
    	dataset.addValue(100, "����", "����");
    	dataset.addValue(400, "����", "����");
    	dataset.addValue(300, "����", "����");
    	dataset.addValue(500, "����", "����");
    	dataset.addValue(90, "����", "����");
    	dataset.addValue(700, "����", "����");
    	dataset.addValue(800, "����", "����");
    	dataset.addValue(1000, "����", "ʮ��");
    	dataset.addValue(300, "����", "ʮһ��");
    	dataset.addValue(700, "����", "ʮ����");
    	dataset.addValue(1200, "�Ϻ�", "һ��");
    	dataset.addValue(1100, "�Ϻ�", "����");
    	dataset.addValue(1000, "�Ϻ�", "����");
    	dataset.addValue(900, "�Ϻ�", "����");
    	dataset.addValue(800, "�Ϻ�", "����");
    	dataset.addValue(700, "�Ϻ�", "����");
    	dataset.addValue(800, "�Ϻ�", "����");
    	dataset.addValue(500, "�Ϻ�", "����");
    	dataset.addValue(400, "�Ϻ�", "����");
    	dataset.addValue(300, "�Ϻ�", "ʮ��");
    	dataset.addValue(200, "�Ϻ�", "ʮһ��");
    	dataset.addValue(100, "�Ϻ�", "ʮ����");
    	dataset.addValue(600, "�人", "һ��");
    	dataset.addValue(500, "�人", "����");
    	dataset.addValue(400, "�人", "����");
    	dataset.addValue(300, "�人", "����");
    	dataset.addValue(200, "�人", "����");
    	dataset.addValue(100, "�人", "����");
    	dataset.addValue(200, "�人", "����");
    	dataset.addValue(300, "�人", "����");
    	dataset.addValue(400, "�人", "����");
    	dataset.addValue(500, "�人", "ʮ��");
    	dataset.addValue(600, "�人", "ʮһ��");
    	dataset.addValue(700, "�人", "ʮ����");
    	
    	*/

    	
    	return dataset;
    }
    //ȡ����ѯ��
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    //ȡ����ҩ��
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	
    	return res;
    }
    
    //ȡ�ó�����
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	
    	return res;
    }
    
    //ȡ�ø�����
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    //ȡ���ܾ�����
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    //ȡ��סԺ��
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
		
		// ִ�в�ѯ
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