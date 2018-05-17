package com.springmvcmybatistemplate.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvcmybatistemplate.test.dao.TestDao;
import com.springmvcmybatistemplate.test.entity.User;

@Repository
public class TestDaoImpl implements TestDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	private SqlSession getSqlSession(){
		if(sqlSession==null){
			sqlSession=sqlSessionFactory.openSession();
		}
		return sqlSession;
	}

	public List<User> findUserByName(User user) {
		List<User> userList=getSqlSession().selectList("test.findUserByName", user.getUserName());
		return userList;
	}
	
	
}
