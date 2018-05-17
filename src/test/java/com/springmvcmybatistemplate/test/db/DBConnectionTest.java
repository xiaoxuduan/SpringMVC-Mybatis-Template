package com.springmvcmybatistemplate.test.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvcmybatistemplate.test.entity.User;

public class DBConnectionTest {
	private final static Logger logger=LogManager.getLogger();
	
	private String resource="beans.xml";
//	private String resource="springmvc-action.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession=null;
	
	@Test
	public void testConnection() throws Exception{
		logger.info("testConnection begin");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(resource);
		sqlSessionFactory=(SqlSessionFactory)context.getBean("sessionFactory");
		sqlSession=sqlSessionFactory.openSession();
		if(sqlSession!=null){
			System.out.println("Mybatis-database connection sucess. Current SQL configuration number: ");
			System.out.println(sqlSession.getConfiguration().getMappedStatements().size());
		}else{
			System.out.println("Mybatis-database connection fail.");
		}
		
		User user=sqlSession.selectOne("test.findUserByName", "aa");
//		UserMapper userMapper=(UserMapper)context.getBean("userMapper");
//		User user=userMapper.findUserByName("aa");
		System.out.println("user name: "+user.getUserName());
		System.out.println("password: "+user.getPassword());
		logger.info("testConnection end.");
	}
}
