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
 * CLASS �� PicCakeChartBean
 * VERSION �� 0.00
 * DESC : ��ͼ����
 * DATE �� 2010-09-23
 * AUTHOR �� zhangqiang
 * HISTORY ��2010-09-23 ����
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
     * ���캯��
     */
    public PicCakeChartBean() {
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
        	String level1 = "";
        	String level2 = "";
        	
        	if("2".equals(flag)){
        		startYear = StringUtil.getRequestData(request.getParameter("txtStartYear"));
            	startMonth = StringUtil.getRequestData(request.getParameter("txtStartMonth"));
            	endYear = StringUtil.getRequestData(request.getParameter("txtEndYear"));
            	endMonth = StringUtil.getRequestData(request.getParameter("txtEndMonth"));
            	level1 = StringUtil.getRequestData(request.getParameter("txtLevel1Type"));
            	level2 = StringUtil.getRequestData(request.getParameter("txtLevel2Type"));
            	
            	
            	//����ͼͼƬ����·��
            	String chartPath = request.getSession().getServletContext().getRealPath("/")+"chart";
            	//���û�д��ļ��У��򴴽�
            	this.isChartPathExist(chartPath);
            	
            	//����Ĭ�ϱ�ͼ���ݽṹ
            	PieDataset dataset=new DefaultPieDataset(); 
            	//ȡ�ñ�ͼ����
            	dataset = this.getAreaMedicineDataSet(startYear,startMonth,endYear,endMonth,level1,level2);
            	//�����ͼ����
            	JFreeChart chart = ChartFactory.createPieChart3D(   
                        "��״ͳ��ͼ", // chart title   
                        dataset,// data   
                        true,// include legend   
                        true,   
                        false  
                       ); 
            	// ʹ��˵����ǩ��������,ȥ��������� 
            	// chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);��Ч�� 
            	chart.setTextAntiAlias(false); 
            	// ͼƬ����ɫ 
            	chart.setBackgroundPaint(Color.white); 
            	// ����ͼ���������    
                Font font = new Font(" ����",Font.CENTER_BASELINE,20); 
                //���ñ�ͼ����
                TextTitle title = new TextTitle("��״ͳ��ͼ"); 
                //���ñ�ͼ����
                title.setFont(font);   
                //���ñ�ͼ����
                chart.setTitle(title); 
                
                chart.getLegend().setItemFont(new Font("����", Font.BOLD, 10));
            	
            	//3D��ͼ
            	PiePlot3D  plot=(PiePlot3D)chart.getPlot();   
            	// ͼƬ����ʾ�ٷֱ�:�Զ��巽ʽ��{0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ���� ,С�������λ   
                plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", 
                		NumberFormat.getNumberInstance(), 
                		new DecimalFormat("0.00%")));    
                // ͼ����ʾ�ٷֱ�:�Զ��巽ʽ�� {0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ����                   
                plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})")); 
                // ����������ʱ����Ϣ 
                plot.setNoDataMessage("�޶�Ӧ�����ݣ������²�ѯ��"); 
                // ����������ʱ����Ϣ��ʾ��ɫ 
                plot.setNoDataMessagePaint(Color.red); 
                // ָ��ͼƬ��͸����(0.0-1.0)    
                plot.setForegroundAlpha(1.0f);    
                // ָ����ʾ�ı�ͼ��Բ��(false)����Բ��(true)    
                plot.setCircular(true); 
                //������������
                Font fontContext = new Font("����", Font.BOLD, 12); 
                //��������
                plot.setLabelFont(fontContext);
                
                plot.setBackgroundPaint(new Color(255, 255, 204));
                
                //���ñ�����ɫ
                //plot.setSectionPaint(pieKeys[0], new Color(244, 194, 144)); 
                //plot.setSectionPaint(pieKeys[1], new Color(144, 233, 144)); 
                
                
                //�����ļ������
                FileOutputStream fos_jpg = null;    
                try { 
                	//�����ļ�·��
                    fos_jpg=new FileOutputStream(chartPath + "\\PicPieChart.jpg");    
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
        	request.setAttribute("level1", level1);
        	request.setAttribute("level2", level2);
        	

            // ����Ǩ�ƻ���
            String str_URL = "/app/system/pic_pie_chart.jsp";

            // ����Ǩ��
            parameters.setParameters("results", "ForwardPage", str_URL);
        } catch (Exception ex) {
            System.out.println("PicCakeChartBean:" + ex.toString());
            parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
        }
    }

    /**
     * ҳ�����⴦�����
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException {
    }
    /**
     * ����ͼƬ����·��������������򴴽�
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
    	
    	//����
    	if("1".equals(level1)){
    		//�Ա�
    		if("1".equals(level2)){
    			res = this.getPatientSexData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("2".equals(level2)){
    		//����
    			res = this.getPatientAgeData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("3".equals(level2)){
    		//���ڵ���	
    			res = this.getPatientAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("4".equals(level2)){
    		//ý�巽ʽ
    			res = this.getPatientMediaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else{
    		//����	
    			res = null;
    		}
    	}else if("2".equals(level1)){
    	//��ѯ	
    		
    		//�Ա�
    		if("1".equals(level2)){
    			res = this.getConsultSexData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("2".equals(level2)){
    		//����	
    			res = this.getConsultAgeData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("3".equals(level2)){
    		//���ڵ���	
    			res = this.getConsultAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else if("4".equals(level2)){
    		//ý�巽ʽ	
    			res = this.getConsultMediaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else{
    		//����
    			res = null;
    		}
    	}else if("3".equals(level1)){
    	//��ҩ	
    		//���ڵ���
    		if("3".equals(level2)){
    			res = this.getMedicineAreaData(startYear,startMonth,endYear,endMonth);
    			for (int i = 1; i < res.size(); i++) {
    				dataset.setValue(res.getCell("C_NAME", i), Double.parseDouble(res.getCell("persum", i)));
            	}
    		}else{
    		//����	
    			res = null;
    		}
    	}else{
    		//����	
    		res = null;
    	}
    	
    	return dataset;
    }
    
    /**
     * ȡ����ѯ-�Ա�����
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ����ѯ-���������
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ����ѯ-����������
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ����ѯ-ý�����Ͷ�����
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ�û���-�Ա�����
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
		
		//ͨ��t_ill���ҳ���ʱ����ͳ��ʱ�䷶Χ�ڵ�����  start
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ�û���-��������
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
		
		//ͨ��t_ill���ҳ���ʱ����ͳ��ʱ�䷶Χ�ڵ�����  start
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ�û���-������������
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
		
		sb_SQL.append("     (select aa.C_ID,aa.C_NAME,'ʡ��' as carea ");
		sb_SQL.append("        from t_patient aa  ");
		sb_SQL.append("       where aa.C_PROVINCE = 14) ");
		sb_SQL.append("  union ");
		sb_SQL.append("     (select bb.C_ID,bb.C_NAME,'����' as carea ");
		sb_SQL.append("        from t_patient bb ");
		sb_SQL.append("       where bb.C_PROVINCE = 45) ");
		sb_SQL.append("  union ");
		sb_SQL.append("     (select cc.C_ID,cc.C_NAME,'ʡ��' as carea ");
		sb_SQL.append("        from t_patient cc ");
		sb_SQL.append("       where cc.C_PROVINCE in ");
		sb_SQL.append("             (15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44)) ");
		
		sb_SQL.append("    ) b ");
		sb_SQL.append("   where 1=1  ");
		//ͨ��t_ill���ҳ���ʱ����ͳ��ʱ�䷶Χ�ڵ�����  start
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ�û���-ý����������
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
		
		//ͨ��t_ill���ҳ���ʱ����ͳ��ʱ�䷶Χ�ڵ�����  start
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
    
    /**
     * ȡ����ҩ-���ڵ�������
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
		sb_SQL.append("             end as persum,'ʡ��' as carea ,aa.C_MONTH  ");
		sb_SQL.append("        from t_medicine aa  ");
		sb_SQL.append("       where aa.C_ITEMID in ( 14,46,47,48,49,50,51,52,53,54,55,56,57,58,59) ");
		sb_SQL.append("     ) union ");
		sb_SQL.append("     (select case ");
		sb_SQL.append("             when sum(bb.C_PERSONNUM) is not null then sum(bb.C_PERSONNUM) ");
		sb_SQL.append("             else 0 ");
		sb_SQL.append("             end as persum,'ʡ��' as carea ,bb.C_MONTH  ");
		sb_SQL.append("        from t_medicine bb ");
		sb_SQL.append("       where bb.C_ITEMID in (15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44)  ");
		sb_SQL.append("     )union ");
		sb_SQL.append("     (select case ");
		sb_SQL.append("              when sum(cc.C_PERSONNUM) is not null then sum(cc.C_PERSONNUM) ");
		sb_SQL.append("              else 0  ");
		sb_SQL.append("              end as persum,'����' as carea ,cc.C_MONTH  ");
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
		
		// ִ�в�ѯ
        res = conn.Query(sb_SQL.toString());
    	return res;
    }
}