package com.syntc.constants;

public class CommonConstants {

	// 系统日志管理 2006/07/09
	public final static String CLDEF_LOG_PATH = "D:\\CJC\\FileData\\CJCLOG\\"; // 日志存放目录
	public final static String CLDEF_TRC_PATH = "D:\\CJC\\FileData\\CJCTRC\\"; // 跟踪存放目录
	public final static String CLDEF_LOG_TYPE_INFO = "info"; // INFO 类型信息
	public final static String CLDEF_LOG_TYPE_TRACE = "trace"; // 信息跟踪类型
	public final static String CLDEF_LOG_TYPE_ERROR = "error"; // 错误信息类型
	public final static String CLDEF_FILE_TYPE_MHT = "mht"; // MHT文件后辍

	// 系统登录常量 2006/07/07
	public final static int CLDEF_LOGIN_OK = 0; // 0：登录成功
	public final static int CLDEF_LOGIN_NG = -1; // 0：登录失败

	// 系统调试等级
	public final static boolean CLDEF_DEBUG = false;
	public final static int CLDEF_TIMEOUT = 300000;
	public final static String CLDEF_ERROR_PAGE = "/com/errComPage.jsp";

	// 数据库操作常量 2006/07/06
	public final static int CLDEF_DB_OK = 0; // 0：全部操作均正常结束，且正确提交
	public final static int CLDEF_DB_OK2 = 1; // 1：全部操作均正常结束，但没有符合查询条件的记录
	public final static int CLDEF_DB_NG1 = -1; // -1：未能建立正确的数据库连接。（罕见）
	public final static int CLDEF_DB_NG2 = -2; // -2：批处理中的一个操作未能正常结束。
	public final static int CLDEF_DB_NG3 = -3; // -3：未能正确执行回退操作。（非常罕见）
	public final static int CLDEF_DB_NG4 = -4; // -4：未能正确执行提交操作。（非常罕见）

	// 函数返回值常量
	// 编写返回语句时:
	// 写成 return CLDEF_FUN_RTN_OK;
	// 不要写成 return 0;
	// 编写判断语句时:
	// 写成 if( CLDEF_FUN_RTN_OK == i_Rtn ){ ...
	// 不要写成 if( i_Rtn == 0 ){ ...
	public final static int CLDEF_FUN_RTN_OK = 0; // 函数返回值 OK
	public final static int CLDEF_FUN_RTN_NG = 1; // 函数返回值 NG

	// 每页默认显示记录数
	public static int CLEDF_MAX_PAGE = 10;

	// 每页默认全部记录数
	public static int CLEDF_SET_MAX = 5000;

	// 所有常量信息在此定义

	// 文件是否确认
	public static final String CONFIRM_YES = "1"; // 是
	public static final String CONFIRM_NO = "0"; // 否

	// 是否
	public static final String TRUE = "TRUE"; // 是
	public static final String FALSE = "FALSE"; // 否

	// 文件是否是最新
	public static final String ISNEW = "1"; // 是最新
	public static final String ISOLD = "0"; // 不是最新

	// 已办完，未办完,是否齐全，
	public static final String PROCEDURE_YES = "1"; // 已办完，已完成，是齐全
	public static final String PROCEDURE_NO = "0"; // 未办完，未完成，否齐全

	// 文件上传路径，暂时大家都写此路径
	public static final String UPLOADPAH = "D:\\CJC\\FileData\\FileUpload";
	public static final String BACKUPPATH = "D:/CJC/FileBackUp/";
	public static final String KEEP_PERIOD = "7";
	public static final String BACKUP_HOUR = "12";

	// 相关常量信息,在此定义
	public static final String SESS_LISTYEAR = "ProBasicListYear";
	public static final String SESS_LISTDEP = "ProBasicListDep";
	public static final String SESS_LISTSELF = "ProBasicListSelf";
	public static final String PROJECT_DELETED = "DEL";

	// 设计效果图
	public static final String FILECODE_DESIGN = "design";

	// 工程排迁项目相关文件
	public static final String PQ_TOTAL_MAP = "rr1"; // 现场示意图
	public static final String PQ_TOTAL_PLAN = "rr2"; // 总的工程安排（文件）
	public static final String PQ_TOTAL_PROCESS = "rr3"; // 总工程进展
	public static final String PQ_INVEST = "rr4"; // 资金情况（文件）

	// 排迁进展状况单项完毕，发送提醒消息
	// 主体施工单位排迁调查
	public static final String PQ_MSG_L1 = "[主体施工单位排迁调查]进行完毕，请跟踪[产权单位进行设计、预算]的进展状况。";
	// 产权单位进行设计、预算
	public static final String PQ_MSG_L2 = "[产权单位进行设计、预算]进行完毕，请跟踪[审核设计图纸、核量]的进展状况。";
	// 审核设计图纸、核量
	public static final String PQ_MSG_L3 = "[审核设计图纸、核量]进行完毕，请跟踪[审核预算]的进展状况。";
	// 审核预算
	public static final String PQ_MSG_L4 = "[审核预算]进行完毕，请跟踪[填(预)结算审批表，并起草情款报告]的进展状况。";
	// 填(预)结算审批表，并起草情款报告
	public static final String PQ_MSG_L5 = "[填(预)结算审批表，并起草情款报告]进行完毕，请跟踪[审批表及报告报委领导签署意见]的进展状况。";
	// 审批表及报告报委领导签署意见
	public static final String PQ_MSG_L6 = "[审批表及报告报委领导签署意见]进行完毕，请跟踪[与施工单位签订合同]的进展状况。";
	// 与施工单位签订合同
	public static final String PQ_MSG_L7 = "[与施工单位签订合同]进行完毕，请跟踪[首期工程拨款]的进展状况。";
	// 首期工程拨款
	public static final String PQ_MSG_L8 = "[首期工程拨款]进行完毕。";
	// 未查到提醒对象时的提示信息
	public static final String PQ_MSG_NAN = "未查找到需要提醒人员的信息";

	// 排迁画面迁移使用常量
	// session标识变量
	public static final String PQ_BACK_PAGE = "pq_back_page_key";
	// 一览画面
	public static final String PQ_LIST = "back_to_list";
	// 专业信息详细画面
	public static final String PQ_DETAIL = "back_to_detail";
	// 专业信息修改画面
	public static final String PQ_MOD = "back_to_mod";
	// 资金信息修改画面
	public static final String PQ_TO_INVEST = "back_to_invest";
	// 外部人员列表使用常量
	public static final String OUT_USER_SEARCH = "out_user_search_key";
	// 外部人员类型
	public static final String OUT_USER_TYPE = "out";
 
	// 关于文件对应功能模块问题，tb_file表一个file_id 主键无法区分该文件属于某个模块
	// 所以需要大家自己构建一个function_code进行区分
	// 构建function_code的方法为： 项目id_子项目id_自己的功能编码
	// 例如主体工程实施，子工程相关文件，工程总体计划安排表
	// 去工程id ＝ 2， 去子项目id ＝ 1，自定义“工程总体计划安排表” = zq1
	// 存入数据库形式为：2_1_zq1
	// 查找该模块的文件时需要写： WHERE function_code = '2_1_zq1'

	// 相关常量信息,在此定义
	public static final String MENU_CHAIQIAN = "CHAIQIAN";
	public static final String MENU_PAIQIAN = "PAIQIAN";

	// 主体工程实施，子项目相关表格
	public static final String SUB_PRO_TOTAL_PLAN = "zq1"; // 工程主体计划安排表
	public static final String SUB_PRO_PROCESS = "zq2"; // 工程进展情况表
	public static final String SUB_PRO_WEEK_PLAN = "zq3"; // 本周计划安排表

	// 主体工程相关文件功能号
	public static final String MAIN_FILE_FUNCODE = "zq4";
	// 主体工程现场图片文件功能号
	public static final String MAIN_XCTP_FUNCODE = "zq5";

	// 没有子工程时，子工程编号
	public static final String NO_SUB_FUNCODE = "0";

	// 共通人员选择模块，回写字段名称 session Key值
	public static final String COMMON_SELUSER_COLUMN = "common_seluser_column";

	// 用户管理部门code session Key 值
	public static final String SYS_USER_DEP_KEY = "sys_user_dep_key";

	// 用户管理用户code session Key 值
	public static final String SYS_USER_CODE_KEY = "sys_user_code_key";

	// 施工单位帐号分配，人员查询，用户姓名session KEY
	public static final String MAIN_OUT_USER_NAME = "mai_out_user_name";

	// 施工单位帐号分配，人员查询，用户单位session KEY
	public static final String MAIN_OUT_USER_DEP = "mai_out_user_dep";

	// yangli add 文件功能号
	// 施工图设计功能号
	public static final String PRO_SHOPDRAWING_UPLOAD = "ylsgtsc";// 施工图上传
	// 施工图设计Id
	public static final String PRO_SHOPDRAWING_ID = "sondesignID";
	// 统计报表,分体
	public static final String STAT_REPORT_FT = "ylsrft";
	// 处上
	public static final String STAT_REPORT_CS = "ylsrcs";
	// 大伙
	public static final String STAT_REPORT_DH = "ylsrdh";
	// yangli end 文件功能号
	// yangli 统计报表常量值,查阅人区分,方便其他模块调用
	public static final String STAT_REP_FT = "0";// 分体
	public static final String STAT_REP_CS = "1";// 处上
	public static final String STAT_REP_DH = "2";// 大伙
	// yangli 统计报表常量值结束
	// yangli 部门类型常量
	public static final String DEP_TYPE_JH = "nmjh";// 计划处
	public static final String DEP_TYPE_GC = "nmgc";// 工程处
	public static final String DEP_TYPE_GW = "nmgw";// 管网处
	public static final String DEP_TYPE_SW = "lesw";// 市建委
	public static final String DEP_TYPE_TLD = "outld";// 施工单位
	public static final String DEP_TYPE_DSN = "oudsn";// 设计单位,预留，先不使用
	public static final String DEP_TYPE_CJC = "nmcj";// 城建处
	public static final String DEP_TYPE_QT = "nmother";// 其他部门

	// yangli 部门类型常量结束
	public static final String SUB_PRO_TOTAL_PLAN_NAME = "工程主体计划安排表";
	public static final String SUB_PRO_PROCESS_NAME = "工程进展情况表";
	public static final String SUB_PRO_WEEK_PLAN_NAME = "本周计划安排表";
	// yangli 报表提示
	public static final String REPORT_CLEW = "注意：如果要使用或上报这里的数据,请先与计划处联系,以取得最新的数据信息！";

	// 功能模块标题
	public static final String MODEL1 = "基本信息";
	public static final String MODEL2 = "设计管理";
	public static final String MODEL3 = "招标合同";
	public static final String MODEL3A = "招标管理";
	public static final String MODEL3B = "合同管理";
	public static final String MODEL4 = "征地拆迁";
	public static final String MODEL5 = "排迁管理";
	public static final String MODEL6 = "工程实施";
	public static final String MODEL7 = "验收移交";
	public static final String MODEL8 = "结算";
	public static final String TITLE = "当前项目";
	public static final String HEADER = "当前位置";
	public static final String ONCLICK = "重选项目";

	// 结果集没有数据时，显示语言描述
	public static final String DATAISNULL = "当前没有数据!";
	public static final String DATANOTINPUT = "<font color=red>尚未输入</font>";

	// 角色类型
	public static final String SYS_ROLE_SYSTEM = "1"; // 系统
	public static final String SYS_ROLE_SYSTEM_HIDE = "2"; // 系统隐藏
	public static final String SYS_ROLE_PRO_HIDE = "3"; // 项目隐藏

	// 角色编号常量
	// 系统管理员
	public static final String ROLE_ROOT = "root";
	// 用户管理员
	public static final String ROLE_USERMNG = "usermng";
	// 项目管理员
	public static final String ROLE_PROJECTMNG = "projectmng";
	// 设计管理员
	public static final String ROLE_DESIGNMNG = "designmng";
	// 招标管理员
	public static final String ROLE_ZHAOBIAOMNG = "zhaobiaomng";
	// 合同管理员
	public static final String ROLE_HETONGMNG = "hetongmng";
	// 报表管理员
	public static final String ROLE_REPORTMNG = "reportmng";
	// 施工放线管理员
	public static final String ROLE_SGFXMNG = "sgfxmng";
	// 内业验收1管理员
	public static final String ROLE_YANSHOU1MNG = "yanshou1mng";
	// 内业验收2管理员
	public static final String ROLE_YANSHOU2MNG = "yanshou2mng";
	// 内业验收3管理员
	public static final String ROLE_YANSHOU3MNG = "yanshou3mng";
	// 外业验收管理员
	public static final String ROLE_YANSHOU4MNG = "yanshou4mng";
	// 排迁合同拨款管理
	public static final String ROLE_PQMONEYMNG = "pqmoneymng";
	// 上级领导
	public static final String ROLE_SUPPERLEADER = "supperleader";
	// 各处处长
	public static final String ROLE_CHULEADER = "chuleader";
	// 外部人员
	public static final String ROLE_EXPUSR1 = "expusr1";
	// 项目相关工程师
	public static final String ROLE_PROJECTUPD = "projectupd";
	// 项目相关负责处室处长
	public static final String ROLE_PROJECTSUPD = "projectsupd";
	// 项目相关拆迁负责人
	public static final String ROLE_CHAIQIANUPD = "chaiqianupd";
	// 项目相关排迁负责人
	public static final String ROLE_PAIQIANUPD = "paiqianupd";
	// 项目相关预算审核人
	public static final String ROLE_YUSUANUPD = "yusuanupd";
}
