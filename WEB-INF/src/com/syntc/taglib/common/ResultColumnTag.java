////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
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

package com.syntc.taglib.common;



import javax.servlet.jsp.tagext.*;
import com.syntc.util.ResultObj;
import com.syntc.common.bean.Common;

public class ResultColumnTag extends TagSupport {
    // DEBUG FLAG
    private final static boolean DEBUG = false;

    private ResultObj resultset = null;
    private String column = "";
	private String type = "";
	private int counter = 0;
    

    public void setColumn(String column) {
        this.column = column;
    }

	public void setType(String type) {
        this.type = type;
    }

    public int doStartTag() {
        try{
          ResultHeaderTag resultHeaderTag = (ResultHeaderTag)this.findAncestorWithClass(this, Class.forName("com.syntc.common.taglib.ResultHeaderTag"));
          String columnValue = "";
          
          if (resultHeaderTag != null) {
              
			  resultset = resultHeaderTag.resultset;
			  counter = resultHeaderTag.counter;
              
			  if (column != null) {
				 String str_ColumnName = column.toUpperCase();
                 if(str_ColumnName.equals("ROWNUM") && !type.equals("CODE"))
                 {
					 if ( counter % 2 == 1)
					 {
                         columnValue = "alternateA";
					 }  
					 else{
						 columnValue = "alternateB";
					 }
                 }
                 else
                 {
                     columnValue = resultset.getCell(column, counter);

                     if(DEBUG){
                        System.out.println("字段名：" + column + "  字段值：" + columnValue);
                     }
                 }
                 
				 //common objCom = new common(); 

				 //将CODE转换成NAME
				 //if (type.equals("NAME") || type.equals("EDIT"))
				 //{
					 //columnValue = objCom.getNameFromCode(str_ColumnName, columnValue, type);
				 //}
                 
				 if (columnValue != null){
					 //显示页面值
					 pageContext.getOut().print(columnValue);
				 }
				 else{
					 pageContext.getOut().print("");
				 }
              }
          }
        }
        catch(Exception ex){
          System.out.println("error:"+ex.getMessage());
        }
        return  EVAL_PAGE;
    }
}