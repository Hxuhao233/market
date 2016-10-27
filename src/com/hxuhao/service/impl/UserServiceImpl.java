package com.hxuhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxuhao.dao.UserDao;
import com.hxuhao.model.User;
import com.hxuhao.service.IUserService;

/**
 * 
 * 使用@Service注解将UserServiceImpl类标注为一个service service的id是userService
 * 
 * @author hxuhao
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	/**
	 * 使用@Autowired注解标注userMapper变量， 当需要使用UserMapper时，Spring就会自动注入UserMapper
	 */
	@Autowired
	private UserDao userDao;// 注入dao

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.createUser(user);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

}
