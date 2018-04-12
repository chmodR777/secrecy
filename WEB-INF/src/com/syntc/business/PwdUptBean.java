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
 * CLASS      ： PwdUptBean
 * VERSION    ： 0.0
 * DESC       :  密码变更画面迁移
 * DATE       ： 2007/03/24
 * AUTHOR     ： rr
 * HISTORY    ： 2007/03/28 0.00 作成
 */
package com.syntc.business;

import javax.servlet.http.*;
import com.syntc.common.action.*;
import com.syntc.util.*;
import com.syntc.constants.CommonConstants;

public class PwdUptBean extends BusinessLogic{
      /**
       * 构造函数
       */
      public PwdUptBean(){
         if(CommonConstants.CLDEF_DEBUG){
            System.out.println("Business Logic instance " + this.getClass().getName() + " done!");
         }
      }

      /**
       * 业务逻辑处理机能
       */
      public void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{       
          
          try{
            
              //迁移画面地址
              String str_URL = null;
              //旧密码
              String strIfBug = StringUtil.getRequestData(request.getParameter("ifBug"));
              if ("".equals(strIfBug))
              {
                  //迁移列表画面
                  str_URL = "/app/home/pwd_upd.jsp";
              }
              else 
              {
                  //迁移列表画面
                  str_URL = "/app/home/pwd_upd.jsp?ifBug="+strIfBug;
              }
                      
              parameters.setParameters("results", "ForwardPage", str_URL);
                
          }
          catch(Exception ex){
              System.out.println("PwdUptBean:"+ex.toString());
              parameters.setParameters("results", "ForwardPage", CommonConstants.CLDEF_ERROR_PAGE);
          }
          
    }
    /**
     * 页面表单检测处理机能
     */
    public void validate(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException{
    
    
    }
}
    