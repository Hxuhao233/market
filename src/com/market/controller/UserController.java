package com.market.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.model.Message;
import com.market.model.Student;
import com.market.service.IStudentService;
import com.market.tools.BaseResponeData;
import com.market.tools.RequestData;
import com.market.tools.ResponeData;
import com.market.tools.ResponeDataForMessage;

@RequestMapping(value = "/User")
@Controller
public class UserController {

	@Autowired
	private IStudentService iStudentService;

	// 用户名查重
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
	public @ResponseBody BaseResponeData signUp(@RequestBody Student student) {
		int id = iStudentService.register(student);
		BaseResponeData message = new BaseResponeData();

		if (id > 0) {
			message.setCode(200);
			// message.setInfo("注册成功");
		} else {
			message.setCode(406);
			// message.setInfo("该用户名已被使用");
		}

		return message;
	}

	// 用户登录
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

	// 用户注销
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public BaseResponeData logout(HttpSession session) {

		Student student = (Student) session.getAttribute("student");
		// System.out.println(u.getUsername() + "logout");
		BaseResponeData ret = new BaseResponeData();
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

	// 忘记密码
	@ResponseBody
	@RequestMapping(value = "/forgetpwd", method = RequestMethod.POST)
	public BaseResponeData forgetPwd(@RequestBody RequestData userData) {
		BaseResponeData ret = new BaseResponeData();

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

	// 修改密码
	@ResponseBody
	@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	public BaseResponeData changepwd(@RequestBody RequestData userData) {
		BaseResponeData ret = new BaseResponeData();

		String account = userData.getData().get(0).get("account");
		String oldpassword = userData.getData().get(0).get("oldpassword");
		String newpassword = userData.getData().get(0).get("newpassword");

		if (iStudentService.checkRepeatAccount(account) == 0) {
			System.out.println("修改密码错误！不存在的用户");
			ret.setCode(207);
			ret.setInfo("不存在的用户");
		} else if (account != null && oldpassword != null && newpassword != null && !account.equals("")
				&& !oldpassword.equals("") && !newpassword.equals("")) {
			boolean isChange = false;
			isChange = iStudentService.changePwd(account, oldpassword, newpassword);
			if (isChange) {
				// 已修改
				ret.setCode(200);
				ret.setInfo("修改密码成功");
			} else {
				// 未修改
				ret.setCode(203);
				ret.setInfo("修改密码失败");
			}
		} else {
			ret.setCode(202);
			ret.setInfo("未输入用户名或新旧密码");
		}
		return ret;
	}

	// 上传头像
	@ResponseBody
	@RequestMapping(value = "/uploadUserIcon", method = RequestMethod.POST)
	public BaseResponeData uploadUserIcon(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpSession session) {
		BaseResponeData response = new BaseResponeData();

		Student user = (Student) session.getAttribute("student");
		int uid = user != null ? user.getId() : 1;

		String pathRoot = request.getSession().getServletContext().getRealPath("/") + "../static";
		System.out.println(pathRoot);
		if (file != null) {
			String filePath = iStudentService.uploadImages(uid, pathRoot, file);
			if (filePath != null) {
				response.setCode(200);
				response.setInfo(filePath);
			} else {
				response.setCode(500);
				response.setInfo("图片上传失败");
			}
		} else {
			response.setCode(402);
			response.setInfo("图片为空");
		}

		return response;

	}

	// Session测试
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
	
	//发送消息
	@ResponseBody
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public BaseResponeData sendMessage (@RequestBody RequestData userData,HttpSession session){
		BaseResponeData ret=new BaseResponeData();
		Integer receiverId=Integer.valueOf(userData.getData().get(0).get("receiverId"));
		String Msg=userData.getData().get(0).get("msg");
		Student student = (Student) session.getAttribute("student");
		if (student==null){
			ret.setCode(201);
			ret.setInfo("帐号未登录");
		}else {
			if (iStudentService.sendMessage(student.getId(), receiverId, Msg)) {
				ret.setCode(200);
				ret.setInfo("发送成功");
			}else{
				ret.setCode(202);
				ret.setInfo("发送失败（接受者不存在）");
			}
		}
		return ret;
	}
	
	
	//查看消息
	@ResponseBody
	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public ResponeDataForMessage getMessage (HttpSession session){
		ResponeDataForMessage ret=new ResponeDataForMessage();
		Student student = (Student) session.getAttribute("student");
		if (student==null){
			ret.setCode(201);
			ret.setInfo("帐号未登录");
		}else {
			List<Message> mList=iStudentService.getMessage(student.getId()); 
			ret.setCode(200);
			ret.setData(mList);
			ret.setInfo("获取消息成功");
		}
		return ret;
	}
	
}
