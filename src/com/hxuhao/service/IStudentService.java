package com.hxuhao.service;

import com.hxuhao.model.Student;

public interface IStudentService {
	public int createStudent(Student student);
	public int deleteStudent(int id);
	public int updateStudent(int id,Student student);
	public Student queryStudent(int id);
}
