package com.springmvcmybatistemplate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvcmybatistemplate.entity.User;
import com.springmvcmybatistemplate.service.UserService;

@Controller
public class UserController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/user/toLogin.action")
	public String toLogin(){
		return "/login.jsp";
	}
	
	@RequestMapping("/user/registerPage.action")
	public String toRegister(){
		return "/register.jsp";
	}
	
	@RequestMapping("/user/login.action")
	public String login(Model model, HttpServletRequest request){
		Map<String, String> map=new HashMap<String, String>();
		map.put("userName", request.getParameter("username"));
		map.put("password", request.getParameter("password"));
		List<User> userList = userService.find(map);
		if(userList!=null && userList.size()>0){
			request.getSession().setAttribute("user", userList.get(0));
			return "/home.jsp";
		}
		model.addAttribute("errorMsg", "login failed. username or password is wrong.");
		return "/login.jsp";
	}
	
	@RequestMapping("/user/register.action")
	public String register(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		// Check if the username has been registered.
		Map<String, String> map=new HashMap<String, String>();
		map.put("userName", request.getParameter("username"));
		List<User> userList=userService.find(map);
		if(userList!=null && userList.size()>0){
			// if the username has been registered.
			model.addAttribute("errorMsg", "Register failed. The username has been registered.");
			return "/register.jsp";
		}
		User user=new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		userService.insert(user);
		model.addAttribute("noticeMsg", "Register successed. Please login.");
		return "/login.jsp";
	}
	
}
