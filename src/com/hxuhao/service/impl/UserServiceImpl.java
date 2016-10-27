package com.hxuhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxuhao.dao.StudentMapper;
import com.hxuhao.model.Student;
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
	private StudentMapper studentDao;// 注入dao

	@Override
	public int login(Student student) {
		// TODO Auto-generated method stub
		student.setIsonline(true);
		int id = studentDao.selectByAccountAndPassword(student);
		System.out.println(id);
		student.setId(id);
		student.setIsonline(true);
		return studentDao.updateByPrimaryKeySelective(student);
	}

	@Override
	public int logout(int id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(id);
		student.setIsonline(false);
		return studentDao.updateByPrimaryKeySelective(student);
	}

}
