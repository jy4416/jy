package com.jy.interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 登录验证拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获得session
		HttpSession session=request.getSession();
		//获得session中的数据
		String user=(String) session.getAttribute("user");
		if(user==null){//没有登录
			response.sendRedirect("/jy/login.jsp");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}

}
