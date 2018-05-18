package com.springmvcmybatistemplate.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.springmvcmybatistemplate.entity.User;

public interface UserService {
	public User get(Serializable id);
	public List<User> find(Map map);
	public void insert(User user);
	public void update(User user);
	public void deleteById(Serializable id);
	public void delete(Serializable[] ids);
}
