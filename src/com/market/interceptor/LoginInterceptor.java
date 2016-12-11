package com.market.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.market.model.Student;

/**
 * 登录拦截器
 * 
 * @author hxuhao
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	// 允许不登录就访问的内容
	private static final String[] IGNORE_URI = { "/login", "/GoodShow/show", "/logout", "/images", "/register",
			"/scripts" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		String url = request.getRequestURL().toString();
		System.out.println(">>>: " + url);
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				flag = true;
				System.out.println("允许访问");
				break;
			}
		}
		if (!flag) {
			Student user = (Student) request.getSession().getAttribute("student");
			if (user != null) {
				flag = true;
				System.out.println("允许访问");
			}
		}
		// 不允许访问
		if (!flag) {
			response.getWriter().write("403 not auth!");
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
