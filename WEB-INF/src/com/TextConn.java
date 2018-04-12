package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class TextConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			 String url =
			 "jdbc:mysql://localhost/HIS?useUnicode=true&characterEncoding=GB2312";
			
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			 Connection conn = DriverManager.getConnection(url, "root",
			 "root");
			
			 Statement stat = conn.createStatement();
			
			 ResultSet rst = stat.executeQuery("select ( 2 * 2) as DD");
			
			 while (rst.next()) {
			 System.out.println("------------"+rst.getString("DD"));
			 }
			
			 rst.close();
			 stat.close();
			 conn.close();
			 
			
			/*
			Date   now   =   new   Date();      
	        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式      
	        String  hehe  = dateFormat.format(now); 
	        
	        System.out.println("-----------"+hehe);
	        
	        dateFormat = new SimpleDateFormat("MM");
	        
	        String nowMonth = dateFormat.format(now);
	        
	        System.out.println("==========="+nowMonth);
			 
		       DefaultPieDataset dfp=new DefaultPieDataset(); 

		       dfp.setValue("管理人员", 25); 

		       dfp.setValue("市场人员", 35); 

		       dfp.setValue("开发人员", 20); 

		       dfp.setValue("后勤人员", 5); 

		       dfp.setValue("财务人员", 15); 

		        //Create JFreeChart object 

		       JFreeChart a =ChartFactory.createPieChart("CityInfoPort公司组织架构图",dfp, true, true, true); 

		       ChartFrame  frame=new ChartFrame ("CityInfoPort公司组织架构图 ",a,true); 

		       frame.pack(); 

		       frame.setVisible(true); 
		       */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
