package com.syntc.common.action;

import javax.servlet.http.*;
import com.syntc.util.*;

public abstract class BusinessLogic {
	public String str_ForwardPage = "";

	/**
	 * ����ҵ���߼��ĳ��󷽷���ִ��ҵ���߼���������
	 */
	public abstract void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException;
}