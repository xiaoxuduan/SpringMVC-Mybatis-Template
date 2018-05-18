package com.springmvcmybatistemplate.dao.impl;

import org.springframework.stereotype.Repository;

import com.springmvcmybatistemplate.dao.UserDao;
import com.springmvcmybatistemplate.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public UserDaoImpl(){
		// set name space;
		super.setNameSpace("com.springmvcmybatistemplate.mapper.UserMapper");
	}
}
