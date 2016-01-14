package com.pakin.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pakin.crm.domain.Employee;
import com.pakin.crm.util.ActionContext;
import com.pakin.crm.util.MyPermission;
import com.pakin.crm.util.PermissionUtil;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.getSession().setAttribute("IP_IN_SESSION",request.getRemoteAddr());
		ActionContext.set(request.getSession());
		Employee user = (Employee) ActionContext.get().getAttribute(
				"USER_IN_SESSION");
		if (user == null && !"/login".equals(request.getRequestURI())) {
			response.sendRedirect("/login.jsp");
			return false;
		}
		//URL权限判断
		if (handler instanceof HandlerMethod) {
			HandlerMethod handerMethod = (HandlerMethod) handler;
			//判断方法上有没有注解
			if (handerMethod.getMethod()
					.isAnnotationPresent(MyPermission.class)) {
				return true;
			}
			String resourceName = handerMethod.getBean().getClass().getName()
					+ ":" + handerMethod.getMethod().getName();
			if (PermissionUtil.checkPermission(resourceName)) {
				return true;
			} else {
				ResponseBody annotation = handerMethod.getMethod()
						.getAnnotation(ResponseBody.class);
				if (annotation != null) {
					//返回json格式
					response.sendRedirect("/noPermission.json");
				} else {
					//返回页面
					response.sendRedirect("/noPermission.jsp");
				}
				//响应对应的内容
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
