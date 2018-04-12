///////////////////////////////////////////////////////////// 
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

/*
 * CLASS      ： ResultType
 * DESC       :  SQL操作基础类型
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */
package com.syntc.util;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Hashtable;
import java.io.ByteArrayInputStream;

public class ResultType {

  private LinkedList resultSetList = null;
  private Hashtable targetRowTable = null;
  public int currentWatchRowNumber = 0;


  public ResultType() {
    resultSetList = new LinkedList();
  }

  public void setRow(int rowNumber,String columnName,Object object){
    Hashtable targetRowTable;
    // This method add data set as row of database
    try{
      if(rowNumber > this.size()){
        //System.out.println("ResultSet new Row create(" + rowNumber + ")");
        targetRowTable = new Hashtable();
        targetRowTable.remove(columnName);
        targetRowTable.put(columnName,object);
        resultSetList.add(rowNumber-1,targetRowTable);
        targetRowTable = null;
      } else {
        targetRowTable = (Hashtable)resultSetList.get(rowNumber-1);
        targetRowTable.remove(columnName);
        targetRowTable.put(columnName,object);
        targetRowTable = null;
      }
    }catch(Exception e){
      // Error
    }
    targetRowTable = null;
  }

  public Object getRow(int rowNumber,String columnName){
    Object object = null;
    try{
      // get Value of taget RowTable of target rowNum
      try{
        Hashtable targetRowTable = (Hashtable)resultSetList.get(rowNumber);
        object = targetRowTable.get(columnName);
        targetRowTable = null;
      }catch(IndexOutOfBoundsException e){
        System.out.println("This row number(" + rowNumber + " is not exist");
      }catch(Exception e){
        System.out.println("Ooops! getRow unexpected Exception was catched");
      }
    }catch(Exception e){
      // Error
    }
    return object;
  }


  public int size(){
    int listRowSize = -1;
    try{
      listRowSize = resultSetList.size();
      //System.out.println("ResultSet size = " + listRowSize + "at size()");
    }catch(Exception e){
      // Error
    }
    return listRowSize;
  }
  public String getSize(){
    int listRowSize = -1;
    try{
      listRowSize = resultSetList.size();
      //System.out.println("ResultSet size = " + listRowSize + "at getSize()");
    }catch(Exception e){
      // Error
    }
    return Integer.toString(listRowSize);
  }


  public boolean next(){
    boolean isNextRowExist = false;
    try{
      if(currentWatchRowNumber >= this.size()){
        targetRowTable = null;
        isNextRowExist = false;
      } else {
        // set rowTable
        targetRowTable = (Hashtable)resultSetList.get(currentWatchRowNumber);
        currentWatchRowNumber++;
        isNextRowExist = true;
      }
    }catch(Exception e){
      // Error
    }
    return isNextRowExist;
  }

  public boolean isLast(){
    boolean isLast = false;
    try{
      if(currentWatchRowNumber >= this.size()){
        isLast = true;
      }
    }catch(Exception e){
      // Error
    }
    return isLast;
  }

  public void rewind(){
    currentWatchRowNumber = 0;
  }

  public int getInt(String columnName){
    int value = 0;
    try{
      value = Integer.parseInt((String)targetRowTable.get(columnName.toUpperCase()));
    }catch(Exception e){
      // Error
    }
    return value;
  }

  public String getString(String columnName){
    String value = null;
    try{
      value = (String)targetRowTable.get(columnName.toUpperCase());
    }catch(Exception e){
      // Error
    }
    return value;
  }

  public java.sql.Date getDate(String columnName){

    java.sql.Date value = null;
    try{
      value = (java.sql.Date)targetRowTable.get(columnName.toUpperCase());
    }catch(Exception e){
      // Error
    }
    return value;
  }

  public ByteArrayInputStream getBlob(String columnName){
    ByteArrayInputStream value = null;
    try{
      value = (ByteArrayInputStream)targetRowTable.get(columnName.toUpperCase());
    }catch(Exception e){
      // Error
    }
    return value;
  }


  public void setResultSet(LinkedList list){
    // change another list( for test)
    resultSetList.clear();
    resultSetList = list;
  }
  /**
   * replace "" or null  to "<BR>"
   */
  public String outBr(String value){
    try{
      if(value == null)return "<BR>";
      if(value.equals(""))return "<BR>";
      return value;
    }catch(Exception e){
      // Error
      return value;
    }
  }


  public void close(){

      if(resultSetList == null)
          return;
      else{
          for(int i=0; i<resultSetList.size(); i++){

              Object element = resultSetList.get(i);
              if(element instanceof Hashtable){
                  clearHashtable((Hashtable)element);
                  ((Hashtable)element).clear();
              }

              element = null;
          }
          resultSetList.clear();
          resultSetList = null;
      }
  }

  public void clearHashtable(Hashtable hashtable){
      if(hashtable == null)
          return;
      else{
          Enumeration allElements = hashtable.elements();
          while(allElements.hasMoreElements()){
              Object element = allElements.nextElement();

              if(element instanceof Hashtable){
                  clearHashtable((Hashtable)element);
                  ((Hashtable)element).clear();
              }
              element = null;
          }
          allElements = null;
          hashtable = null;
      }
  }

}
