package com.springmvcmybatistemplate.test.service;

import java.util.List;

import com.springmvcmybatistemplate.test.entity.User;

public interface TestService {
	public List<User> findUserByName(User user);
}
