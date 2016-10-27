package com.hxuhao.controller;


import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hxuhao.model.Student;
import com.hxuhao.service.IUserService;

@RestController

public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ResponseEntity<Student> login(@RequestBody Student student){
		System.out.println("id : " + student.getId());
		System.out.println(iUserService.login(student));
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public ResponseEntity<String>logout(@RequestBody Student student){
		System.out.println("id" + student.getId());
		iUserService.logout(Integer.valueOf(student.getId()));
		return new ResponseEntity<String>(new String("ok"),HttpStatus.OK);
	}
}
