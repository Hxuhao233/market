package com.market.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.market.dao.StudentMapper;
import com.market.model.Student;
import com.market.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentMapper studentDao;

	@Override
	public int register(Student student) {
		// TODO Auto-generated method stub
		int ret = 0;
		if (checkRepeatAccount(student.getAccount()) == 0) {
			studentDao.insertSelective(student);
			ret = student.getId();
			System.out.println("register id" + ret);
		}
		return ret;
	}

	@Override
	public Student logIn(String account, String password) {
		// TODO Auto-generated method stub
		Map<String, String> param = new HashMap<String, String>();
		param.put("account", account);
		param.put("password", password);
		Student s = studentDao.selectByKey(param);
		if (s != null)
			return s;
		else {
			return null;
		}
	}

	@Override
	public int logOut(int studentId) {
		// TODO Auto-generated method stub
		// 暂无其他需求
		return 0;
	}

	@Override
	public int checkRepeatAccount(String name) {
		// TODO Auto-generated method stub

		return studentDao.selectAccount(name);
	}

	@Override
	public boolean forgetPwd(String account, String variCode, String newPassword) {
		boolean isVerify = false;
		// TODO 在StudentMapper里添加函数检测account与variCode是否匹配，返回给isVerify
		isVerify = true;
		if (isVerify) {
			// 修改密码
			Student u = studentDao.selectByAccount(account);
			u.setPassword(newPassword);
			studentDao.updateByPrimaryKeySelective(u);
		}

		return isVerify;
	}

	@Override
	public boolean changePwd(String account, String oldPwd, String newPwd) {
		boolean isChange = false;
		Map<String, String> param = new HashMap<String, String>();
		param.put("account", account);
		param.put("password", oldPwd);
		Student s = studentDao.selectByKey(param);
		if (s != null) {
			// 密码用户匹配成功
			s.setPassword(newPwd);
			studentDao.updateByPrimaryKeySelective(s);
			isChange = true;
		} else {
			// 密码用户匹配失败
			isChange = false;
		}
		return isChange;
	}

	@Override
	public String uploadImages(int userId, String pathRoot, MultipartFile file) {
		// TODO Auto-generated method stub
		String filePath = new String();

		String path = "";
		if (!file.isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = file.getContentType();
			// 获得文件后缀名称
			String imageName = contentType.substring(contentType.indexOf("/") + 1);
			pathRoot = "/images/";
			path = uuid + "." + imageName.trim();

			try {
				file.transferTo(new File(pathRoot + path));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(pathRoot + path);

		// request.setAttribute("imagesPath", "../../static" + path);
		filePath = "../../static/image/" + path;

		// 更新数据库
		Student record = new Student();
		record.setId(userId);
		record.setIconaddr(path);
		studentDao.updateByPrimaryKeySelective(record);

		return filePath;

	}
}
