package com.springmvcmybatistemplate.test.dao;

import java.util.List;

import com.springmvcmybatistemplate.test.entity.User;

public interface TestDao {
	public List<User> findUserByName(User user);
}
