package com.springmvcmybatistemplate.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvcmybatistemplate.dao.BaseDao;

public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String nameSpace;
	
	public String getNameSpace() {
		return nameSpace;
	}
	
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	
	public List<T> find(Map map){
		List<T> oList=this.getSqlSession().selectList(nameSpace+".find", map);
		return oList;
	}
	
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(nameSpace+".get", id);
	}

	public void insert(T entity) {
		this.getSqlSession().insert(nameSpace+".insert", entity);
	}

	public void update(T entity) {
		this.getSqlSession().update(nameSpace+".update", entity);
	}

	public void deleteById(Serializable id) {
		this.getSqlSession().delete(nameSpace+".deleteById", id);
	}

	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(nameSpace+".delete", ids);
	}
	
}
