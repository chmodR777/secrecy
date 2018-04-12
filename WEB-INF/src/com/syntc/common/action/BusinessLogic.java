package com.syntc.common.action;

import javax.servlet.http.*;
import com.syntc.util.*;

public abstract class BusinessLogic {
	public String str_ForwardPage = "";

	/**
	 * 定义业务逻辑的抽象方法（执行业务逻辑处理方法）
	 */
	public abstract void execute(HttpServletRequest request, HttpServletResponse response, Parameters parameters) throws CommonException;
}