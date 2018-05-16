package com.springmvcmybatistemplate.test.mapper;

import com.springmvcmybatistemplate.test.entity.User;

/**
 * It should be public.
 * 
 * @author Xiaoxu Duan
 */
public interface UserMapper {
	
	User findUserByName(String userName);

}
