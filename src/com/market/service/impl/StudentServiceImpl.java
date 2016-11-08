package com.market.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.StudentMapper;
import com.market.model.Student;
import com.market.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentMapper studentDao;

	@Override
	public int register(Student student) {
		// TODO Auto-generated method stub
		int ret = 0;
		if(checkReatName(student.getAccount())==0){
			studentDao.insertSelective(student);	
			ret = student.getId();
			System.out.println("register id" + ret);
		}
		return ret;
	}

	@Override
	public Student logIn(String account ,String password) {
		// TODO Auto-generated method stub
		Map<String,String> param = new HashMap<String,String>();
		param.put("account", account);
		param.put("password", password);
		Student s = studentDao.selectByKey(param);
		if(s != null)
			return s;
		else{
			return null;
		}
	}

	@Override
	public int logOut(int studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkReatName(String name) {
		// TODO Auto-generated method stub
		
		return studentDao.selectName(name);
	}
	
	
}
