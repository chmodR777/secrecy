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
import java.util.Vector;

import com.syntc.common.bean.Common;


public class Tree {
   private int max_level;
   private int max_captionLength = 10;
   private int treeNumber = 0;
   private Vector trees;
   private boolean b_checkBox = false;

   public Tree(Vector trees){
      this.max_level = 0;
      this.trees = trees;

      if ( this.trees != null && this.trees.size()>0 ){
         this.treeNumber = this.trees.size();
         this.initTree();
      }

   }

   /**
    * desc:初始化树的深度、节点类型
    */
   private void initTree(){

      for (int i = 0;i<treeNumber ;i++ ){
         com.syntc.util.TreeNode node = (com.syntc.util.TreeNode)this.trees.get(i);
         int level = node.getLevel();
         if ( this.max_level < level ){
            this.max_level = level;
         }
         if ( i+1==this.treeNumber ){
         	node.setType(com.syntc.util.TreeNode.CLDEF_LEAF);
         }else if ( level == 1 ){
            node.setType( com.syntc.util.TreeNode.CLDEF_ROOT );
         }else {
            com.syntc.util.TreeNode nextNode = (com.syntc.util.TreeNode)this.trees.get(i+1);
            int nextLevel = nextNode.getLevel();
            if ( level < nextLevel ){
               node.setType( com.syntc.util.TreeNode.CLDEF_BRANCH );
            }else {
            	node.setType( com.syntc.util.TreeNode.CLDEF_LEAF );
            }
         }
      }

   }

   /**
    * desc: 画出一棵树
    */
   public String draw(String href,
      String target,
      String rootCSS,
      String branchCSS,
      String leafCSS,
      String imgPath,
      String onlyLeaf){

      long preValue = 0;
      long preLevel = 1;
      long curLevel = 0;
      long i_waif   = 0;
      StringBuffer sb_buffer = new StringBuffer();

      for (int i=0; i<this.treeNumber ;i++ ){

         com.syntc.util.TreeNode node = (com.syntc.util.TreeNode)this.trees.get(i);
         curLevel = node.getLevel();

         if ( curLevel > preLevel ){
            i_waif ++;
            sb_buffer.append("<DIV class=sub id=L"+preValue+"Sub>");
         }else if ( curLevel < preLevel ){
            i_waif -= preLevel-curLevel;

            for ( int j=0 ; j< preLevel-curLevel ;j++ ){
               sb_buffer.append("</DIV>");
            }
         }

         sb_buffer.append( this.drawNode(i,href,target,rootCSS,branchCSS,leafCSS,imgPath,onlyLeaf) );

         preValue = Long.parseLong( node.getValue() );
         preLevel = curLevel;
      }

      /*  层的尾部处理 */
      for ( int i=0 ; i< i_waif ;i++ ){
         sb_buffer.append("</DIV>");
      }

      return sb_buffer.toString();

   }

   /**
    * desc:画一棵节点
    */
   private String drawNode(int iv,     //第多少个节点，用于确定check得name
      String href,
      String target,
      String rootCSS,
      String branchCSS,
      String leafCSS,
      String imgPath,
      String onlyLeaf
      )
   {
      StringBuffer sb_buffer = new StringBuffer();
	  Common common = new Common();
      com.syntc.util.TreeNode node = (com.syntc.util.TreeNode)this.trees.get( iv );
      String value = node.getValue();
      String name  = node.getName();
      long    level = node.getLevel();
      boolean b_checkBox = node.getCheckBox();
      long    nodeType = node.getType();
      String className = null;
      String imgName   = null;

      if ( href == null ){
         href = "";
      }
      if ( target == null ){
         target = "";
      }
      if ( imgPath == null || imgPath.trim().equals("") ){
         imgPath = "/menus";
      }
      if ( rootCSS == null || rootCSS.trim().equals("") ){
         rootCSS = "root";
      }
      if ( branchCSS == null || branchCSS.trim().equals("") ){
         branchCSS = "branch";
      }
      if ( leafCSS == null || leafCSS.trim().equals("") ){
         leafCSS = "leaf";
      }

      if ( nodeType == com.syntc.util.TreeNode.CLDEF_ROOT ){
         className = rootCSS;
         imgName   = "menu_root.gif";
      }else if ( nodeType == com.syntc.util.TreeNode.CLDEF_BRANCH ){
         className = branchCSS;
         imgName   = "menu_branch.gif";
      }else{
         className = leafCSS;
         imgName   = "menu_leaf.gif";
      }

      sb_buffer.append("<DIV class=\""+className+"\"");
      sb_buffer.append(    " id=\"L"+value+"\"");
      sb_buffer.append(    " title=\""+name+"\"");
      sb_buffer.append(    " href=\""+href+"\"");
      sb_buffer.append(    " target=\""+target+"\"");
      sb_buffer.append(    " >");
      sb_buffer.append("<IMG src=\""+imgPath+"/"+imgName+"\">");
      if ( b_checkBox ){
         if(onlyLeaf.equals("YES")){//只有叶子节点有checkbox，返回名称为业务线
           if( className.equals(leafCSS) ){
             sb_buffer.append("<input type=checkbox name='chk" + iv + "'");
             sb_buffer.append("       value=\"" + value + "\">");
			 //--------------add by RR 2005-09-06--------------------------
             sb_buffer.append("<input type=hidden name='hdn_chk" + iv + "'");
			 //sb_buffer.append("       value=\"" + common.getSectionLine(value) + "\">");
			 //------------------------------------------------------------
           }
         }else if(onlyLeaf.equals("Yes")){//只有叶子节点有checkbox，返回名称为部门名称
           if( className.equals(leafCSS) ){
             sb_buffer.append("<input type=checkbox name='chk" + iv + "'");
             sb_buffer.append("       value=\"" + value + "\">");
			 //--------------add by RR 2005-09-06--------------------------
             sb_buffer.append("<input type=hidden name='hdn_chk" + iv + "'");
			 //sb_buffer.append("       value=\"" + common.getSecName(value) + "\">");
			 //------------------------------------------------------------
           }
         }else if(onlyLeaf.equals("NO")){//没有checkbox
         }else if(onlyLeaf.equals("no")){//全部节点checkbox，返回业务线
             sb_buffer.append("<input type=checkbox name='chk" + iv + "'");
             sb_buffer.append("       value=\"" + value + "\">");
			 //--------------add by RR 2005-09-06--------------------------
             sb_buffer.append("<input type=hidden name='hdn_chk" + iv + "'");
			 //sb_buffer.append("       value=\"" + common.getSectionLine(value) + "\">");
         }else{//各个节点都有checkbox,返回名称为部门名称
           //if( className.equals(leafCSS) ){
             sb_buffer.append("<input type=checkbox name='chk" + iv + "'");
             sb_buffer.append("       value=\"" + value + "\">");
			 //--------------add by RR 2005-09-06--------------------------
             sb_buffer.append("<input type=hidden name='hdn_chk" + iv + "'");
			 //sb_buffer.append("       value=\"" + common.getSecName(value) + "\">");
			 //------------------------------------------------------------
           //}
         }
      }
      sb_buffer.append( name.length()>max_captionLength?name.substring(0,10)+"..":name );
      sb_buffer.append("</DIV>");

      return sb_buffer.toString();
   }


}
