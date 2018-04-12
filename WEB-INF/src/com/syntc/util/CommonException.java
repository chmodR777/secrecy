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
 * CLASS      ： CommonException
 * DESC       :  基础异常处理
 * VERSION    ： 0.00
 * DATE       ： 2006/07/05
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/05 0.00 作成
 */
package com.syntc.util;

import java.io.PrintStream;
import java.io.PrintWriter;


public class CommonException extends RuntimeException{

    private Throwable previousThrowable = null;

    public CommonException() {

    }

    public CommonException(String message){
        super(message);
    }

    public void printStackTrace(){
        super.printStackTrace();
        if (this.previousThrowable != null)
        {
            this.previousThrowable.printStackTrace();
        }
    }

    public CommonException(Throwable inThrowable){
        this.previousThrowable = inThrowable;
    }
}
