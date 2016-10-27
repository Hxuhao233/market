package com.hxuhao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hxuhao.model.University;
import com.hxuhao.service.IUniversityService;

public class UniversityTest {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		IUniversityService iUniversityService = (IUniversityService) ac.getBean("universityService");
		
		University university = new University();
		university.setName("unknown");
		//iUniversityService.createUniversity(university);
		university.setName("华南理工大学");
		//iUniversityService.createUniversity(university);
		System.out.println(iUniversityService.getUniversityById(2).getName());
	}
}
