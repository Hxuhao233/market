package com.market.service;

import com.market.model.Student;

public interface IStudentService {
	/*
	public int createStudent(Student student); 
	public int deleteStudent(int id);
	public int updateStudent(int id,Student student);
	public Student queryStudent(int id);
	*/
	public int checkRepeatAccount(String name);
	
	public int register(Student student);				
	
	public Student logIn(String account,String password);
	
	public int logOut(int studentId);
	
	public boolean forgetPwd(String account,String variCode,String newPassword);
}
