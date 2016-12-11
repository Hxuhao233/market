package com.market.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.market.model.Student;

public interface IStudentService {
	/*
	 * public int createStudent(Student student); public int deleteStudent(int
	 * id); public int updateStudent(int id,Student student); public Student
	 * queryStudent(int id);
	 */
	public int checkRepeatAccount(String name); // 查重

	public int register(Student student); // 注册

	public Student logIn(String account, String password); // 登录

	public int logOut(int studentId); // 注销

	public String uploadImages(int userId, String path, MultipartFile file); // 上传头像

	public boolean forgetPwd(String account, String variCode, String newPassword); // 忘记密码

	public boolean changePwd(String account, String oldPwd, String newPwd); // 修改密码
}
