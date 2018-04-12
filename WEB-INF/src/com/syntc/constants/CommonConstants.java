package com.syntc.constants;

public class CommonConstants {

	// ϵͳ��־���� 2006/07/09
	public final static String CLDEF_LOG_PATH = "D:\\CJC\\FileData\\CJCLOG\\"; // ��־���Ŀ¼
	public final static String CLDEF_TRC_PATH = "D:\\CJC\\FileData\\CJCTRC\\"; // ���ٴ��Ŀ¼
	public final static String CLDEF_LOG_TYPE_INFO = "info"; // INFO ������Ϣ
	public final static String CLDEF_LOG_TYPE_TRACE = "trace"; // ��Ϣ��������
	public final static String CLDEF_LOG_TYPE_ERROR = "error"; // ������Ϣ����
	public final static String CLDEF_FILE_TYPE_MHT = "mht"; // MHT�ļ����

	// ϵͳ��¼���� 2006/07/07
	public final static int CLDEF_LOGIN_OK = 0; // 0����¼�ɹ�
	public final static int CLDEF_LOGIN_NG = -1; // 0����¼ʧ��

	// ϵͳ���Եȼ�
	public final static boolean CLDEF_DEBUG = false;
	public final static int CLDEF_TIMEOUT = 300000;
	public final static String CLDEF_ERROR_PAGE = "/com/errComPage.jsp";

	// ���ݿ�������� 2006/07/06
	public final static int CLDEF_DB_OK = 0; // 0��ȫ����������������������ȷ�ύ
	public final static int CLDEF_DB_OK2 = 1; // 1��ȫ��������������������û�з��ϲ�ѯ�����ļ�¼
	public final static int CLDEF_DB_NG1 = -1; // -1��δ�ܽ�����ȷ�����ݿ����ӡ���������
	public final static int CLDEF_DB_NG2 = -2; // -2���������е�һ������δ������������
	public final static int CLDEF_DB_NG3 = -3; // -3��δ����ȷִ�л��˲��������ǳ�������
	public final static int CLDEF_DB_NG4 = -4; // -4��δ����ȷִ���ύ���������ǳ�������

	// ��������ֵ����
	// ��д�������ʱ:
	// д�� return CLDEF_FUN_RTN_OK;
	// ��Ҫд�� return 0;
	// ��д�ж����ʱ:
	// д�� if( CLDEF_FUN_RTN_OK == i_Rtn ){ ...
	// ��Ҫд�� if( i_Rtn == 0 ){ ...
	public final static int CLDEF_FUN_RTN_OK = 0; // ��������ֵ OK
	public final static int CLDEF_FUN_RTN_NG = 1; // ��������ֵ NG

	// ÿҳĬ����ʾ��¼��
	public static int CLEDF_MAX_PAGE = 10;

	// ÿҳĬ��ȫ����¼��
	public static int CLEDF_SET_MAX = 5000;

	// ���г�����Ϣ�ڴ˶���

	// �ļ��Ƿ�ȷ��
	public static final String CONFIRM_YES = "1"; // ��
	public static final String CONFIRM_NO = "0"; // ��

	// �Ƿ�
	public static final String TRUE = "TRUE"; // ��
	public static final String FALSE = "FALSE"; // ��

	// �ļ��Ƿ�������
	public static final String ISNEW = "1"; // ������
	public static final String ISOLD = "0"; // ��������

	// �Ѱ��꣬δ����,�Ƿ���ȫ��
	public static final String PROCEDURE_YES = "1"; // �Ѱ��꣬����ɣ�����ȫ
	public static final String PROCEDURE_NO = "0"; // δ���꣬δ��ɣ�����ȫ

	// �ļ��ϴ�·������ʱ��Ҷ�д��·��
	public static final String UPLOADPAH = "D:\\CJC\\FileData\\FileUpload";
	public static final String BACKUPPATH = "D:/CJC/FileBackUp/";
	public static final String KEEP_PERIOD = "7";
	public static final String BACKUP_HOUR = "12";

	// ��س�����Ϣ,�ڴ˶���
	public static final String SESS_LISTYEAR = "ProBasicListYear";
	public static final String SESS_LISTDEP = "ProBasicListDep";
	public static final String SESS_LISTSELF = "ProBasicListSelf";
	public static final String PROJECT_DELETED = "DEL";

	// ���Ч��ͼ
	public static final String FILECODE_DESIGN = "design";

	// ������Ǩ��Ŀ����ļ�
	public static final String PQ_TOTAL_MAP = "rr1"; // �ֳ�ʾ��ͼ
	public static final String PQ_TOTAL_PLAN = "rr2"; // �ܵĹ��̰��ţ��ļ���
	public static final String PQ_TOTAL_PROCESS = "rr3"; // �ܹ��̽�չ
	public static final String PQ_INVEST = "rr4"; // �ʽ�������ļ���

	// ��Ǩ��չ״��������ϣ�����������Ϣ
	// ����ʩ����λ��Ǩ����
	public static final String PQ_MSG_L1 = "[����ʩ����λ��Ǩ����]������ϣ������[��Ȩ��λ������ơ�Ԥ��]�Ľ�չ״����";
	// ��Ȩ��λ������ơ�Ԥ��
	public static final String PQ_MSG_L2 = "[��Ȩ��λ������ơ�Ԥ��]������ϣ������[������ͼֽ������]�Ľ�չ״����";
	// ������ͼֽ������
	public static final String PQ_MSG_L3 = "[������ͼֽ������]������ϣ������[���Ԥ��]�Ľ�չ״����";
	// ���Ԥ��
	public static final String PQ_MSG_L4 = "[���Ԥ��]������ϣ������[��(Ԥ)�������������������]�Ľ�չ״����";
	// ��(Ԥ)�������������������
	public static final String PQ_MSG_L5 = "[��(Ԥ)�������������������]������ϣ������[���������汨ί�쵼ǩ�����]�Ľ�չ״����";
	// ���������汨ί�쵼ǩ�����
	public static final String PQ_MSG_L6 = "[���������汨ί�쵼ǩ�����]������ϣ������[��ʩ����λǩ����ͬ]�Ľ�չ״����";
	// ��ʩ����λǩ����ͬ
	public static final String PQ_MSG_L7 = "[��ʩ����λǩ����ͬ]������ϣ������[���ڹ��̲���]�Ľ�չ״����";
	// ���ڹ��̲���
	public static final String PQ_MSG_L8 = "[���ڹ��̲���]������ϡ�";
	// δ�鵽���Ѷ���ʱ����ʾ��Ϣ
	public static final String PQ_MSG_NAN = "δ���ҵ���Ҫ������Ա����Ϣ";

	// ��Ǩ����Ǩ��ʹ�ó���
	// session��ʶ����
	public static final String PQ_BACK_PAGE = "pq_back_page_key";
	// һ������
	public static final String PQ_LIST = "back_to_list";
	// רҵ��Ϣ��ϸ����
	public static final String PQ_DETAIL = "back_to_detail";
	// רҵ��Ϣ�޸Ļ���
	public static final String PQ_MOD = "back_to_mod";
	// �ʽ���Ϣ�޸Ļ���
	public static final String PQ_TO_INVEST = "back_to_invest";
	// �ⲿ��Ա�б�ʹ�ó���
	public static final String OUT_USER_SEARCH = "out_user_search_key";
	// �ⲿ��Ա����
	public static final String OUT_USER_TYPE = "out";
 
	// �����ļ���Ӧ����ģ�����⣬tb_file��һ��file_id �����޷����ָ��ļ�����ĳ��ģ��
	// ������Ҫ����Լ�����һ��function_code��������
	// ����function_code�ķ���Ϊ�� ��Ŀid_����Ŀid_�Լ��Ĺ��ܱ���
	// �������幤��ʵʩ���ӹ�������ļ�����������ƻ����ű�
	// ȥ����id �� 2�� ȥ����Ŀid �� 1���Զ��塰��������ƻ����ű� = zq1
	// �������ݿ���ʽΪ��2_1_zq1
	// ���Ҹ�ģ����ļ�ʱ��Ҫд�� WHERE function_code = '2_1_zq1'

	// ��س�����Ϣ,�ڴ˶���
	public static final String MENU_CHAIQIAN = "CHAIQIAN";
	public static final String MENU_PAIQIAN = "PAIQIAN";

	// ���幤��ʵʩ������Ŀ��ر��
	public static final String SUB_PRO_TOTAL_PLAN = "zq1"; // ��������ƻ����ű�
	public static final String SUB_PRO_PROCESS = "zq2"; // ���̽�չ�����
	public static final String SUB_PRO_WEEK_PLAN = "zq3"; // ���ܼƻ����ű�

	// ���幤������ļ����ܺ�
	public static final String MAIN_FILE_FUNCODE = "zq4";
	// ���幤���ֳ�ͼƬ�ļ����ܺ�
	public static final String MAIN_XCTP_FUNCODE = "zq5";

	// û���ӹ���ʱ���ӹ��̱��
	public static final String NO_SUB_FUNCODE = "0";

	// ��ͨ��Աѡ��ģ�飬��д�ֶ����� session Keyֵ
	public static final String COMMON_SELUSER_COLUMN = "common_seluser_column";

	// �û�������code session Key ֵ
	public static final String SYS_USER_DEP_KEY = "sys_user_dep_key";

	// �û������û�code session Key ֵ
	public static final String SYS_USER_CODE_KEY = "sys_user_code_key";

	// ʩ����λ�ʺŷ��䣬��Ա��ѯ���û�����session KEY
	public static final String MAIN_OUT_USER_NAME = "mai_out_user_name";

	// ʩ����λ�ʺŷ��䣬��Ա��ѯ���û���λsession KEY
	public static final String MAIN_OUT_USER_DEP = "mai_out_user_dep";

	// yangli add �ļ����ܺ�
	// ʩ��ͼ��ƹ��ܺ�
	public static final String PRO_SHOPDRAWING_UPLOAD = "ylsgtsc";// ʩ��ͼ�ϴ�
	// ʩ��ͼ���Id
	public static final String PRO_SHOPDRAWING_ID = "sondesignID";
	// ͳ�Ʊ���,����
	public static final String STAT_REPORT_FT = "ylsrft";
	// ����
	public static final String STAT_REPORT_CS = "ylsrcs";
	// ���
	public static final String STAT_REPORT_DH = "ylsrdh";
	// yangli end �ļ����ܺ�
	// yangli ͳ�Ʊ�����ֵ,����������,��������ģ�����
	public static final String STAT_REP_FT = "0";// ����
	public static final String STAT_REP_CS = "1";// ����
	public static final String STAT_REP_DH = "2";// ���
	// yangli ͳ�Ʊ�����ֵ����
	// yangli �������ͳ���
	public static final String DEP_TYPE_JH = "nmjh";// �ƻ���
	public static final String DEP_TYPE_GC = "nmgc";// ���̴�
	public static final String DEP_TYPE_GW = "nmgw";// ������
	public static final String DEP_TYPE_SW = "lesw";// �н�ί
	public static final String DEP_TYPE_TLD = "outld";// ʩ����λ
	public static final String DEP_TYPE_DSN = "oudsn";// ��Ƶ�λ,Ԥ�����Ȳ�ʹ��
	public static final String DEP_TYPE_CJC = "nmcj";// �ǽ���
	public static final String DEP_TYPE_QT = "nmother";// ��������

	// yangli �������ͳ�������
	public static final String SUB_PRO_TOTAL_PLAN_NAME = "��������ƻ����ű�";
	public static final String SUB_PRO_PROCESS_NAME = "���̽�չ�����";
	public static final String SUB_PRO_WEEK_PLAN_NAME = "���ܼƻ����ű�";
	// yangli ������ʾ
	public static final String REPORT_CLEW = "ע�⣺���Ҫʹ�û��ϱ����������,������ƻ�����ϵ,��ȡ�����µ�������Ϣ��";

	// ����ģ�����
	public static final String MODEL1 = "������Ϣ";
	public static final String MODEL2 = "��ƹ���";
	public static final String MODEL3 = "�б��ͬ";
	public static final String MODEL3A = "�б����";
	public static final String MODEL3B = "��ͬ����";
	public static final String MODEL4 = "���ز�Ǩ";
	public static final String MODEL5 = "��Ǩ����";
	public static final String MODEL6 = "����ʵʩ";
	public static final String MODEL7 = "�����ƽ�";
	public static final String MODEL8 = "����";
	public static final String TITLE = "��ǰ��Ŀ";
	public static final String HEADER = "��ǰλ��";
	public static final String ONCLICK = "��ѡ��Ŀ";

	// �����û������ʱ����ʾ��������
	public static final String DATAISNULL = "��ǰû������!";
	public static final String DATANOTINPUT = "<font color=red>��δ����</font>";

	// ��ɫ����
	public static final String SYS_ROLE_SYSTEM = "1"; // ϵͳ
	public static final String SYS_ROLE_SYSTEM_HIDE = "2"; // ϵͳ����
	public static final String SYS_ROLE_PRO_HIDE = "3"; // ��Ŀ����

	// ��ɫ��ų���
	// ϵͳ����Ա
	public static final String ROLE_ROOT = "root";
	// �û�����Ա
	public static final String ROLE_USERMNG = "usermng";
	// ��Ŀ����Ա
	public static final String ROLE_PROJECTMNG = "projectmng";
	// ��ƹ���Ա
	public static final String ROLE_DESIGNMNG = "designmng";
	// �б����Ա
	public static final String ROLE_ZHAOBIAOMNG = "zhaobiaomng";
	// ��ͬ����Ա
	public static final String ROLE_HETONGMNG = "hetongmng";
	// �������Ա
	public static final String ROLE_REPORTMNG = "reportmng";
	// ʩ�����߹���Ա
	public static final String ROLE_SGFXMNG = "sgfxmng";
	// ��ҵ����1����Ա
	public static final String ROLE_YANSHOU1MNG = "yanshou1mng";
	// ��ҵ����2����Ա
	public static final String ROLE_YANSHOU2MNG = "yanshou2mng";
	// ��ҵ����3����Ա
	public static final String ROLE_YANSHOU3MNG = "yanshou3mng";
	// ��ҵ���չ���Ա
	public static final String ROLE_YANSHOU4MNG = "yanshou4mng";
	// ��Ǩ��ͬ�������
	public static final String ROLE_PQMONEYMNG = "pqmoneymng";
	// �ϼ��쵼
	public static final String ROLE_SUPPERLEADER = "supperleader";
	// ��������
	public static final String ROLE_CHULEADER = "chuleader";
	// �ⲿ��Ա
	public static final String ROLE_EXPUSR1 = "expusr1";
	// ��Ŀ��ع���ʦ
	public static final String ROLE_PROJECTUPD = "projectupd";
	// ��Ŀ��ظ����Ҵ���
	public static final String ROLE_PROJECTSUPD = "projectsupd";
	// ��Ŀ��ز�Ǩ������
	public static final String ROLE_CHAIQIANUPD = "chaiqianupd";
	// ��Ŀ�����Ǩ������
	public static final String ROLE_PAIQIANUPD = "paiqianupd";
	// ��Ŀ���Ԥ�������
	public static final String ROLE_YUSUANUPD = "yusuanupd";
}
