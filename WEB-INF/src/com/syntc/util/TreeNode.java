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

package com.syntc.util;

public class  TreeNode
{
   //�ڵ����Ͷ���
   public static int CLDEF_UNDEFINE = 0;
   public static int CLDEF_ROOT = 1;
   public static int CLDEF_BRANCH = 2;
   public static int CLDEF_LEAF = 3;

   private String value = null;
   private String parent= null;
   private String name  = null;
   private int    level = 0;
   private boolean b_checkBox = false;
   private int    nodeType = CLDEF_UNDEFINE;     

   public TreeNode(String value,String name,int level)
   {
      this.value = value;
      this.name  = name ;
      this.level = level;
   }

   public TreeNode(String value,String name,int level,boolean b_checkBox)
   {
      this.value = value;
      this.name  = name ;
      this.level = level;
      this.b_checkBox = b_checkBox;
   }

   /**
    * �趨����ֵ
    */
   public void setValue(String value)
   {
      this.value = value;
   }

   /**
    * ȡ�ýڵ��ֵ
    */
   public String getValue()
   {
      return this.value;
   }

   /**
    * �趨����ֵ
    */
   public void setParent(String parent)
   {
      this.parent = parent;
   }

   /**
    * ȡ�ýڵ��ֵ
    */
   public String getParent()
   {
      return this.parent;
   }

   /**
    * �趨��������
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * ȡ�ýڵ������
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * �趨level��ֵ
    */
   public void setLevel(int level)
   {
      this.level = level;
   }

   /**
    * ȡ��level��ֵ
    */
   public int getLevel()
   {
      return this.level;
   }
   /**
    * �趨�Ƿ���ҪcheckBox
    */
   public void setCheckBox(boolean b_checkBox)
   {
      this.b_checkBox = b_checkBox;
   }

   /**
    * ȡ��level�Ƿ���ҪcheckBox
    */
   public boolean getCheckBox()
   {
      return this.b_checkBox;
   }

   /**
    * �趨�ڵ�����
    */
   public void setType(int nodeType)
   {
      this.nodeType = nodeType;
   }

   /**
    * ȡ�ýڵ�����
    */
   public int getType()
   {
      return this.nodeType;
   }

}
