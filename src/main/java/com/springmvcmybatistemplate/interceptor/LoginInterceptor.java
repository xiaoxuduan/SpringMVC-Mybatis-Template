package com.springmvcmybatistemplate.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String uri=request.getRequestURI();
		// Check if it's login/register page.
		if(!(uri.contains("login")||uri.contains("Login")||uri.contains("register"))){
			// not login/register request.
			if(request.getSession().getAttribute("user")!=null){
				// already login.
				return true;
			}else{
				// not login. redirect to login page.
				response.sendRedirect(request.getContextPath()+"/user/toLogin.action");
			}
		}else{
			// login/register request.
			return true;
		}
		return false;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception{}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
			Exception ex) throws Exception{}
}
