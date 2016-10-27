package com.hxuhao.service;

import com.hxuhao.model.Student;


public interface IUserService {
//	public User getUserByName(String name);
//
//	public User getUserById(int id);
//
//	public void createUser(User user);
	
	public int login(Student student);		// 登录
	
	public int logout(int id);						// 注销
}
