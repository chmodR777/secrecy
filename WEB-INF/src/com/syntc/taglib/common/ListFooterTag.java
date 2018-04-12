////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2010 zq CORPORATION
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.syntc.constants.CommonConstants;
import com.syntc.util.Parameters;
import com.syntc.util.StringUtil;

public class ListFooterTag extends TagSupport {

	private int i_CurPage = 1;
	private int i_RecNum = 0;
	private int i_PageSize = 10;
	private int i_PageCount = 1;

    public ListFooterTag () {
    }

    public int doStartTag() {
        return  SKIP_BODY;
    }

    public int doEndTag() {
      try {
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        Parameters parameters = (Parameters)request.getAttribute("outparam");
        if(parameters != null){
            //�ܼ�¼�� 
			String str_RecNum = (String)parameters.getParameters("results", "recNum");
			i_RecNum = Integer.parseInt(str_RecNum);
			//ȡ�õ�ǰҳ
            String str_CurPage = StringUtil.convertNull((String)parameters.getParameters("results", "curPage"),"1"); 
			i_CurPage = Integer.parseInt(str_CurPage);

			//ÿҳ��ʾ��
            String str_PageSize = StringUtil.convertNull((String)parameters.getParameters("results", "i_PageSize"), String.valueOf(CommonConstants.CLEDF_MAX_PAGE));
			i_PageSize = Integer.parseInt(str_PageSize);
			int i_CurSize = 0;
            
			//ȡ����ҳ�� 
			i_PageCount = i_RecNum / i_PageSize + (i_RecNum % i_PageSize == 0?0:1);

			if(i_PageSize > i_RecNum){
				i_CurSize = i_RecNum;		
			}
			if(i_PageSize < 0){
				i_CurSize = 0;
			}
			if(i_CurPage == i_PageCount ){
				i_CurSize = i_RecNum - i_PageSize*(i_CurPage-1);
			}else{
				i_CurSize = i_PageSize;
			}
			StringBuffer str_pageHtml = new StringBuffer();
            str_pageHtml.append("\r\n");
			
			str_pageHtml.append("<script>                                   \r\n");
            str_pageHtml.append("var maxPageSize = 100;                     \r\n");
			str_pageHtml.append("var maxPageNum = 2147483647;               \r\n");
			str_pageHtml.append("var maxSum = " + i_RecNum + ";             \r\n");

			//����򳤶ȱ��
			str_pageHtml.append("  function changeSize(obj){				\r\n");
            str_pageHtml.append("    var len = obj.value.length;			\r\n");
			str_pageHtml.append("    if (len > 0){							\r\n");
			str_pageHtml.append("      obj.size = len;}						\r\n");
            str_pageHtml.append("  }										\r\n");
            
			//cookies����
			str_pageHtml.append("  function setCookie(name, value) {        \r\n"); 
            str_pageHtml.append("    var expire = new Date();               \r\n"); 
            str_pageHtml.append("    var today = new Date();                \r\n");  
            str_pageHtml.append("    expire.setTime(today.getTime() + 3600*24*365);    \r\n");
            str_pageHtml.append("    document.cookie = name + \"=\" + escape(value) + ((expire == null) ? \"\" : (\"; expires=\" + expire.toGMTString()));                \r\n");
            str_pageHtml.append("   }                                       \r\n");

            //GOͼ�괦��
            str_pageHtml.append("  function pageByPageCheck(curPage,pageSize){               \r\n");
            str_pageHtml.append("    var str = pageSize.value;                               \r\n");
            str_pageHtml.append("    var i_pageSize = parseInt(str);                         \r\n");
            str_pageHtml.append("    setCookie(\"pageSize\", pageSize.value);                \r\n");
            str_pageHtml.append("    str = curPage.value;                                    \r\n");
            str_pageHtml.append("    for(var i=0;i<str.length;i++){                          \r\n");
            str_pageHtml.append("      if(!(str.charAt(i)>=0&&str.charAt(i)<=9)){            \r\n"); 
            str_pageHtml.append("        alert(\"�Բ���������Ĳ�����ֵ�������ݣ�\");             \r\n");
            str_pageHtml.append("        return false;}}                                     \r\n");
            str_pageHtml.append("    var i_curPage = parseInt(str);                          \r\n");
            str_pageHtml.append("    if( i_curPage <= 0 ){                                   \r\n");
			str_pageHtml.append("      alert(\"�Բ����������ݲ���Ϊ�㣡���������롣\");           \r\n");
			str_pageHtml.append("      return false;}                                        \r\n");
            str_pageHtml.append("    if( i_curPage > maxPageNum ){                           \r\n");  
			str_pageHtml.append("      alert(\"ҳ��ӦС��2147483647��\");                      \r\n");
			str_pageHtml.append("      return false;}                                        \r\n");
            str_pageHtml.append("    if( i_pageSize * ( i_curPage - 1 ) >= maxSum ){         \r\n");
			str_pageHtml.append("      alert(\"ҳ���ÿҳ��¼������\");                        \r\n");
			str_pageHtml.append("      return false;}                                        \r\n");
            str_pageHtml.append("    pageto(i_curPage);                                      \r\n");
            str_pageHtml.append("  }                                                         \r\n");
   
            //ÿҳ��ʾ��¼����  
            str_pageHtml.append("  function changeData(pageSize){                            \r\n");
			str_pageHtml.append("    document.form1.pageSize.value = pageSize.value;      \r\n");
			str_pageHtml.append("    document.form1.action = document.form1.actname.value;  \r\n   ");
			str_pageHtml.append("  	 form1.submit();                                      \r\n");
			str_pageHtml.append("       }                                                    \r\n");           
            //��ҳ����  
            str_pageHtml.append("  function pageto(iPage){                                   \r\n");
			str_pageHtml.append("    document.form1.curPage.value = iPage;                \r\n");
			str_pageHtml.append("    document.form1.action = document.form1.actname.value;  \r\n   ");
			str_pageHtml.append("    document.form1.state.value = 'list';                 \r\n");
			str_pageHtml.append("    form1.submit();   }                                  \r\n");

            str_pageHtml.append("</script>\r\n");

            //ҳ����ʾ����  
            str_pageHtml.append("\r\n");
			str_pageHtml.append("<TABLE width='100%' border='0' cellpadding='1' cellspacing='1' class='blue' valign='buttom'>\r\n");
            str_pageHtml.append("  <tr>\r\n");
            str_pageHtml.append("    <TD align='right'>\r\n");
            str_pageHtml.append("    �� <font color=blue><b>" + i_PageCount + "</b></font> ҳ ��ǰ\r\n");
            str_pageHtml.append("      <input type='text' name='curPage' value='" + i_CurPage + "' class=tx size=3 style='color:blue' onchange='changeSize(this);'>\r\n");
            str_pageHtml.append("      <input type='button' name='go' class=bt value='GO' onclick='pageByPageCheck(curPage, pageSize);'>ҳ\r\n");
            str_pageHtml.append("      &nbsp;&nbsp;��ҳ <font color=blue><b>" + i_CurSize + "</b></font> ����¼");
            str_pageHtml.append("      &nbsp;&nbsp;�� <font color=blue><b>" + i_RecNum + "</b></font> ����¼");
            str_pageHtml.append("      <input type='hidden' name='recNumber' value='" + i_CurSize + "'>\r\n");
            if (i_CurPage == 1) {
            	str_pageHtml.append("      [�� ҳ]\r\n");
            	str_pageHtml.append("      [��һҳ]\r\n");
            }else{
            	str_pageHtml.append("      [<a href='javascript:pageto(1)'>�� ҳ</a>]\r\n");
            	str_pageHtml.append("      [<a href='javascript:pageto("+(i_CurPage - 1)+")'>��һҳ</a>]\r\n");
            }
            if (i_CurPage == i_PageCount) {
            	str_pageHtml.append("      [��һҳ]\r\n");
            	str_pageHtml.append("      [���һҳ]\r\n");
            }else{
            	str_pageHtml.append("      [<a href='javascript:pageto("+(i_CurPage + 1)+")'>��һҳ</a>]\r\n");
            	str_pageHtml.append("      [<a href='javascript:pageto(" + i_PageCount+")'>���һҳ</a>]\r\n");
            }
            str_pageHtml.append("          ÿҳ��ʾ��¼\r\n");
            str_pageHtml.append("          <select name='pageSize' id='pageSize' onchange='changeData(pageSize);'>\r\n");
            if(i_PageSize==10){
            	str_pageHtml.append("        <option value='10' selected>10</option>\r\n");	
            }else{
            	str_pageHtml.append("        <option value='10'>10</option>\r\n");	
            }
            if(i_PageSize==20){
            	str_pageHtml.append("        <option value='20' selected>20</option>\r\n");
            }else{
            	str_pageHtml.append("        <option value='20' >20</option>\r\n");
            }
            if(i_PageSize==50){
            	str_pageHtml.append("        <option value='50' selected>50</option>\r\n");
            }else{
            	str_pageHtml.append("        <option value='50' >50</option>\r\n");
            }
            if(i_PageSize==100){
            	str_pageHtml.append("        <option value='100' selected>100</option>\r\n");
            }else{
            	str_pageHtml.append("        <option value='100' >100</option>\r\n");
            } 
//            if(i_PageSize==CommonConstants.CLEDF_SET_MAX){
//            	str_pageHtml.append("        <option value='" + CommonConstants.CLEDF_SET_MAX + "' selected>ȫ��</option>\r\n");
//            }else{
//            	str_pageHtml.append("        <option value='" + CommonConstants.CLEDF_SET_MAX + "'>ȫ��</option>\r\n");
//            }
            if(i_PageSize==i_RecNum){
            	str_pageHtml.append("        <option value='" + i_RecNum + "' selected>ȫ��</option>\r\n");
            }else{
            	str_pageHtml.append("        <option value='" + i_RecNum + "'>ȫ��</option>\r\n");
            }
            str_pageHtml.append("          </select>\r\n");
            str_pageHtml.append("        </TD>\r\n");
            str_pageHtml.append("      </TR>\r\n");
            str_pageHtml.append("    </TABLE>\r\n");
            
 
            //ҳ�����
            if (i_RecNum == 0){
            	str_pageHtml = new StringBuffer("");
            	str_pageHtml.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>\r\n");
                str_pageHtml.append("  <tr height='30' valign='middle'>\r\n");
                str_pageHtml.append("  <td align='center'><font color='red'>" + "û�з������������ݣ�" + "</font></td></tr></table>\r\n");
            	
            }
            
        	JspWriter out = pageContext.getOut();
        	out.write(str_pageHtml.toString());
            str_pageHtml.delete(0, str_pageHtml.length());
          
        }
      }
      catch(Exception ex) {
        System.out.println("error:"+ex.getMessage());
      }
      return  EVAL_PAGE;
    }
}