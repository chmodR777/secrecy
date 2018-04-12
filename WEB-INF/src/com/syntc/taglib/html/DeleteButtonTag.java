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

/**
 * <p>通用按钮共通处理;
 *
 * @version 0.00, 2006-06-07
 * @author  jinghuizhen@hotmail.com
 * @Desc    删除按钮基类
 * @since   0.00
 */	
package com.syntc.taglib.html;

import com.syntc.taglib.html.*;

public class DeleteButtonTag extends ButtonBaseTag {
	
	  public DeleteButtonTag() {
		  this.setcaption("删 除");
		  this.setonclick("funDelele();");
	  }

	  public int doEndTag() {
         return super.doEndTag();
	  }

	  public void release() {
	    super.release();
	  }
}