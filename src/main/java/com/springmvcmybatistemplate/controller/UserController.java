package com.springmvcmybatistemplate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
			
			// test
//			for(Map.Entry<String, String> entry: map.entrySet()){
//				System.out.println(entry.getKey()+" "+entry.getValue()+".....................");
//			}
//		
//			User user = userService.get("11");
//			request.getSession().setAttribute("user", user);
//			return "/home.jsp";
		
		
		List<User> userList = userService.find(map);
		if(userList!=null && userList.size()>0){
			request.getSession().setAttribute("user", userList.get(0));
			return "/home.jsp";
		}
		model.addAttribute("errorMsg", "login failed. username or password is wrong.");
		return "/login.jsp";
	}
}
