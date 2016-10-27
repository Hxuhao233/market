package com.hxuhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxuhao.dao.StudentMapper;
import com.hxuhao.model.Student;
import com.hxuhao.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentMapper studentDao;
	
	@Override
	public int createStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentDao.insertSelective(student);
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		
		return studentDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		
		return studentDao.updateByPrimaryKeySelective(student);
	}

	@Override
	public Student queryStudent(int id) {
		// TODO Auto-generated method stub
		
		return studentDao.selectByPrimaryKey(id);
	}
	
}
