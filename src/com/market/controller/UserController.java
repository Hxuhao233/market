package com.market.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
import com.market.tools.RequestData;
import com.market.tools.ResponeData;

@RequestMapping(value = "/User")
@Controller
public class UserController {

	@Autowired
	private IStudentService iStudentService;

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public @ResponseBody ResponeData checkRepeatAccount(@RequestBody RequestData userData) {
		String username = userData.getData().get(0).get("account");
		ResponeData message = new ResponeData();
		if (iStudentService.checkRepeatAccount("account") > 0) {
			message.setCode(406);
			message.setInfo("改用户名已被使用");
		} else {
			message.setCode(200);
		}

		return message;
	}

	// 用户注册
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Message signUp(@RequestBody Student student) {
		int id = iStudentService.register(student);
		Message message = new Message();

		if (id > 0) {
			message.setCode(200);
			// message.setInfo("注册成功");
		} else {
			message.setCode(406);
			// message.setInfo("该用户名已被使用");
		}

		return message;
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponeData login(@RequestBody RequestData userData, HttpSession session) {
		// System.out.println("account" + account);
		// String password = "";
		ResponeData ret = new ResponeData();
		Student u = (Student) session.getAttribute("student");
		String account = userData.getData().get(0).get("account");
		String password = userData.getData().get(0).get("password");
		if (u != null) {
			System.out.println(u.getId());
			ret.setCode(201);
			ret.setInfo("用户已登录");
		} else if (account != null && password != null && !"".equals(account) && !"".equals(password)) {

			Student student = iStudentService.logIn(account, password);

			if (student != null) {
				System.out.println("user " + student.getId() + "" + student.getName() + " login!");
				// session.setMaxInactiveInterval(10); // 10s
				session.setAttribute("student", student);

				Map<String, String> userInfo = new HashMap<String, String>();
				userInfo.put("name", student.getName());
				ArrayList<Map<String, String>> infoItems = new ArrayList<Map<String, String>>();
				infoItems.add(userInfo);

				ret.setCode(200);
				ret.setInfo("登录成功");
				ret.setData(infoItems);

			} else {
				ret.setCode(203);
				ret.setInfo("用户名或密码错误");
			}
		} else {
			ret.setCode(202);
			ret.setInfo("未输入用户名或密码");

		}
		return ret;
	}

	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Message logout(HttpSession session) {

		Student student = (Student) session.getAttribute("student");
		// System.out.println(u.getUsername() + "logout");
		Message ret = new Message();
		if (student != null) {
			session.removeAttribute("student");
			ret.setCode(200);
			ret.setInfo("注销成功");

		} else {
			ret.setCode(204);
			ret.setInfo("注销失败");
		}
		return ret;
	}

	@ResponseBody
	@RequestMapping(value = "/forgetpwd", method = RequestMethod.POST)
	public Message forgetPwd(@RequestBody RequestData userData) {
		Message ret = new Message();

		String account = userData.getData().get(0).get("account");
		String variCode = userData.getData().get(0).get("variCode");
		String newpassword = userData.getData().get(0).get("password");

		if (iStudentService.checkRepeatAccount(account) == 0) {
			System.out.println("修改密码错误！不存在的用户");
			ret.setCode(207);
			ret.setInfo("不存在的用户");
		} else if (account != null && newpassword != null && variCode != null && !account.equals("")
				&& !newpassword.equals("") && !variCode.equals("")) {
			boolean isVerify = false;
			isVerify = iStudentService.forgetPwd(account, variCode, newpassword);
			if (isVerify) {
				// 通过验证
				ret.setCode(200);
				ret.setInfo("修改密码成功");
			} else {
				// 未通过验证
				ret.setCode(203);
				ret.setInfo("验证码错误");
			}

		} else {
			ret.setCode(202);
			ret.setInfo("未输入用户名或新密码或验证码");
		}

		return ret;
	}

	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public int check(HttpSession session) {
		int ret = 0;
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
