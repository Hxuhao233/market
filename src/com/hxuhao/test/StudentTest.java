package com.hxuhao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxuhao.model.Student;
import com.hxuhao.service.IStudentService;

public class StudentTest {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
		IStudentService iStudentService = (IStudentService)ac.getBean("studentService");
		Student student = new Student();
		student.setAccount("13710685836");
		student.setPassword("hxh896900488");
		student.setName("何徐昊");
		System.out.println(iStudentService.createStudent(student));
	}
}
