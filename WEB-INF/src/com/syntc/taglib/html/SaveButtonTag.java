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
 * <p>ͨ�ð�ť��ͨ����;
 *
 * @version 0.00, 2006-06-07
 * @author  jinghuizhen@hotmail.com
 * @Desc    ���水ť����
 * @since   0.00
 */	
package com.syntc.taglib.html;

import com.syntc.taglib.html.*;

public class SaveButtonTag extends ButtonBaseTag {
	
	  public SaveButtonTag() {
		  this.setcaption("�� ��");
		  this.setonclick("funSave();");
	  }

	  public int doEndTag() {
         return super.doEndTag();
	  }

	  public void release() {
	    super.release();
	  }
}