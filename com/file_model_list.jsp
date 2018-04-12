<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="syntc"%>
<%@ include file="/com/begin.jsp"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<html>
<head>
<title></title>
<syntc:ScriptsCommon />
</head>
<body topmargin=0 leftmargin=0>
<%
// 用户信息
UserBean user = (UserBean) request.getSession().getAttribute("UserBean");
//权限取得
boolean bAllowEdit1 = UserBean.chkFunc("UserW");
boolean bAllowEdit2 = UserBean.chkFunc("UserAllW");
boolean bAllowEdit = false;
// 操作用户
String strUserID = user.getUserCode();
//
String strFileType = StringUtil.convertNull((String)request.getAttribute("file_type"));

%>
<syntc:TitleHeader header="系统维护 >> 模板下载" />

<form name="form1" action="" method="post">
<input type="hidden" name="state">
<input type="hidden" name="actname" value="SysOutUserList.do">

<syntc:FuncHeader header="文件模板"  showall="yes"/>

<br>
<input type="hidden" name="fileName">
<input type="hidden" name="fileDownName">
<table width="77%" align="left" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
      <syntc:TableTitle header="文件模板一览" >
      <syntc:TableHeader />
      <syntc:ReturnButton/>
      <syntc:TableFoot />
      </syntc:TableTitle>
      <syntc:HtmlTable>
        <tr class="title">
          <th class="nm" nowrap width="5%">文件名称</th>
        </tr>
        <%if ("1".equals(strFileType)) {%>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('1');return false;">排迁工期安排模板</a>
          </td>
        </tr>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('2');return false;">排迁进展情况模板</a>
          </td>
        </tr>
        <%}%>
        <%if ("2".equals(strFileType)) {%>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('6');return false;">主体工程工期安排模板</a>
          </td>
        </tr>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('3');return false;">子项目工期安排模板</a>
          </td>
        </tr>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('4');return false;">子项目进展情况模板</a>
          </td>
        </tr>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('5');return false;">子项目本周计划模板</a>
          </td>
        </tr>
        <%}%>
        <%if ("3".equals(strFileType)) {%>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('3');return false;">子项目工期安排模板</a>
          </td>
        </tr>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('4');return false;">子项目进展情况模板</a>
          </td>
        </tr>
        <tr>
          <td class="nm">
            <a href="#" class="detail" style="cursor:hand" onclick="downFile('5');return false;">子项目本周计划模板</a>
          </td>
        </tr>
        <%}%>
      </syntc:HtmlTable>
      <syntc:listfooter/>
    </td>
  </tr>
</table>
</form>
<syntc:TitleFoot />
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">

//下载文件
function downFile(fileid){
    if (fileid=="1") {
        document.form1.fileName.value = "pq_plan.xls";
        document.form1.fileDownName.value="排迁工期安排模板.xls";
    } else if (fileid=="2") {
        document.form1.fileName.value="pq_process.xls";
        document.form1.fileDownName.value="排迁进展情况模板.xls";
    } else if (fileid=="3") {
        document.form1.fileName.value="sub_pro_plan.xls";
        document.form1.fileDownName.value="子项目工期安排模板.xls";
    } else if (fileid=="4") {
        document.form1.fileName.value="sub_pro_process.xls";
        document.form1.fileDownName.value="子项目进展情况模板.xls";
    } else if (fileid=="5") {
        document.form1.fileName.value="sub_pro_week.xls";
        document.form1.fileDownName.value="子项目本周计划模板.xls";
    } else if (fileid=="6") {
        document.form1.fileName.value="main_pro_plan.xls";
        document.form1.fileDownName.value="主体工程工期安排模板.xls";
    }

    document.form1.action = "com/down_model_file.jsp";
    document.form1.submit();
}
</SCRIPT>

