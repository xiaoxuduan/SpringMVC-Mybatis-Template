package com.springmvcmybatistemplate.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcmybatistemplate.dao.UserDao;
import com.springmvcmybatistemplate.entity.User;
import com.springmvcmybatistemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public User get(Serializable id) {
		return userDao.get(id);
	}

	public List<User> find(Map map) {
		return userDao.find(map);
	}

	public void insert(User user) {
		userDao.insert(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void deleteById(Serializable id) {
		userDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		userDao.delete(ids);
	}

}
