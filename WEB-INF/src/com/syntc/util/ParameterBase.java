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

/*
 * CLASS      ： Parameters
 * DESC       :  数据传递类
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */

package com.syntc.util;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Enumeration;
import java.lang.Object;

import com.syntc.util.CommonException;

 public class ParameterBase{

  protected Hashtable roottable = new Hashtable();

  public ParameterBase() {
  }

  public void setParameters(String category,Object key,Object value){
    Hashtable TargetCategory = null;
    try{
      // At first get target category hashtable
      // If no create category yet, it create.
      TargetCategory = (Hashtable)roottable.get(category);
      if(TargetCategory == null){
        Hashtable NewCategory = new Hashtable();
        roottable.put(category,NewCategory);
        TargetCategory =  (Hashtable)roottable.get(category);
        // Set any parameter for any category
        TargetCategory.put(key,value);
        NewCategory = null;
      } else {
        TargetCategory.put(key,value);
      }
    }catch(Exception e){
        // error
    }
    TargetCategory = null;
  }

  public Object getParameters(String category,Object key){
    Hashtable TargetCategory = null;
    try{
      TargetCategory = (Hashtable)roottable.get(category);
      // At first, get target category hashtable
      // If no exists table, method return null.
      if(TargetCategory == null){
        return null;
      } else {
        return TargetCategory.get(key);
      }
    }catch(Exception e){
      // error
      return null;
    }
    finally{
        TargetCategory = null;
    }
  }

  public void removeParameters(String category,Object key){
    try{
      Hashtable targetCategory = (Hashtable)roottable.get(category);
      if(targetCategory == null){
        return;
      } else {
        targetCategory.remove(key);
      }
      targetCategory = null;
    }catch(Exception e){
      // error
    }
  }

  public void resetParameters(String category,Object key,Object value){
    try{
      // at first, target key remove.
      removeParameters(category,key);
      // and set new value to same key.
      setParameters(category,key,value);
    }catch(Exception e){
      // error
    }
  }

  public void close(){
      clearHashtable(roottable);
      roottable = null;
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
              else if(element instanceof com.syntc.util.ResultType){
                 ((com.syntc.util.ResultType)element).close();
              }
              element = null;
          }
          allElements = null;
          hashtable = null;
      }
  }

}
