package com.springmvcmybatistemplate.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvcmybatistemplate.test.entity.User;
import com.springmvcmybatistemplate.test.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test/findUser.action")
	private String findUser(User user, Model model){
		List<User> userList=testService.findUserByName(user);
		model.addAttribute("userList", userList);
		return "/test/test.jsp";
	}
}
