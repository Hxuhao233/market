package com.market.service;

import com.market.model.Student;

public interface IStudentService {
	/*
	 * public int createStudent(Student student); public int deleteStudent(int
	 * id); public int updateStudent(int id,Student student); public Student
	 * queryStudent(int id);
	 */
	public int checkRepeatAccount(String name);		// 查重

	public int register(Student student);		// 注册

	public Student logIn(String account, String password);	//　登录

	public int logOut(int studentId);						//　注销

	public boolean forgetPwd(String account, String variCode, String newPassword);		//　忘记密码
}
