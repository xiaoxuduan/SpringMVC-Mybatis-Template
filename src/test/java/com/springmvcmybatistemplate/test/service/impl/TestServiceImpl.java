package com.springmvcmybatistemplate.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvcmybatistemplate.test.dao.TestDao;
import com.springmvcmybatistemplate.test.entity.User;
import com.springmvcmybatistemplate.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Resource
	private TestDao testDao;

	public List<User> findUserByName(User user) {
		List<User> userList=testDao.findUserByName(user);
		return userList;
	}
	
}
