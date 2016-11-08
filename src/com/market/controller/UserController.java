package com.market.controller;



import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.model.Student;
import com.market.service.IStudentService;
import com.market.tools.Message;

@Controller
public class UserController {
	
	@Autowired
	private IStudentService iStudentService;
	
	// 用户注册
	@RequestMapping(value="signup",method=RequestMethod.POST)
	public @ResponseBody Message signUp(@RequestBody Student student){
		int id = iStudentService.register(student);
		Message message = new Message();
		
		if(id > 0){
			message.setCode(200);
			message.setInfo("注册成功");
		}else{
			message.setCode(201);
			message.setInfo("该用户名已被使用");
		}
			
		return message;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Message login(@RequestBody Student s,HttpSession session){
		//System.out.println("account" + account);
	//	String password = "";
		Message ret = new Message();
		Student u  = (Student) session.getAttribute("student");
		
		if(u!=null){
			System.out.println(u.getId());
			ret.setCode(201);
			ret.setInfo("用户已登录");
		}else if ( s.getAccount() != null && s.getPassword() != null &&
				! "".equals(s.getAccount()) && ! "".equals(s.getPassword()) ){
			
			Student student = iStudentService.logIn(s.getAccount(),s.getPassword());
			
			if(student != null){
				System.out.println("user " + student.getId() + " login!");
				//session.setMaxInactiveInterval(10); 			// 10s 
				session.setAttribute("student",student);

				ret.setCode(200);
				ret.setInfo("登录成功");
			}else{
				ret.setCode(400);
				ret.setInfo( "用户名或密码错误");
			}
		}else {
			ret.setCode(202);
			ret.setInfo( "未输入用户名或密码");
			
		}
		return ret;
	}
	
	@ResponseBody
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public Message logout(HttpSession session){
		Student student = (Student)session.getAttribute("student");
		//System.out.println(u.getUsername() + "logout");
		Message ret = new Message();
        if(student != null){
        	session.removeAttribute("student");
        	ret.setCode(200);
        	ret.setInfo("注销成功");
        	
        }else{
        	ret.setCode(203);
        	ret.setInfo("注销失败");
        }
		return ret;
	}
	
	@ResponseBody
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public int check(HttpSession session){
		int ret=0;
		System.out.println("\n\n\ncheck sesson !!\n\n\n");
		
        System.out.println("");
        System.out.println("*** Session data ***");
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
        	
            String s = e.nextElement();
            System.out.println(s + " == " + session.getAttribute(s));
            System.out.println(s + " max time :" + session.getMaxInactiveInterval());
            ret++;
            
        }
        
        return ret;
	}
	
}
