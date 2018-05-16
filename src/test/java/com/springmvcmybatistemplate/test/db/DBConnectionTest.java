package com.springmvcmybatistemplate.test.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvcmybatistemplate.test.entity.User;

public class DBConnectionTest {
	private String resource="beans.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession=null;
	
	@Test
	public void testConnection() throws Exception{
		System.out.println("22");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(resource);
		System.out.println("33");
		sqlSessionFactory=(SqlSessionFactory)context.getBean("sessionFactory");
		sqlSession=sqlSessionFactory.openSession();
		System.out.println("1.");
		if(sqlSession!=null){
			System.out.println("Mybatis-database connection sucess. Current SQL configuration number: ");
			System.out.println(sqlSession.getConfiguration().getMappedStatements().size());
		}else{
			System.out.println("Mybatis-database connection fail.");
		}
		
		System.out.println("2.");
		User user=sqlSession.selectOne("test.findUserByName", "11");
		System.out.println("user name: "+user.getUserName());
		System.out.println("password: "+user.getPassword());
		System.out.println("end.");
	}
}
