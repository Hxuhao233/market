package com.hxuhao.test;

import com.hxuhao.model.Student;
import com.hxuhao.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

	public IUserService userService;

	public static void main(String[] args) {
		UserTest userTest = new UserTest();
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		userTest.userService = (IUserService) ac.getBean("userService");
	//	User user = new User("2333333", "sss", "女");
		Student student = new Student();
		student.setId(1);
		student.setAccount("13710685836");
		student.setPassword("hxh896900488");
		//System.out.print(userTest.userService.login(student));
		System.out.println(userTest.userService.logout(1));
		
	}

}
