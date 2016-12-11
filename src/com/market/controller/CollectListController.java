package com.market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.model.Student;
import com.market.service.ICollectListService;
import com.market.tools.BaseResponeData;
import com.market.tools.RequestData;
import com.market.tools.ResponeData;
import com.market.tools.ResponeDataForCollectList;

/**
 * 收藏夹管理
 * 
 * @author ck
 *
 */
@RequestMapping(value = "/CollectList")
@Controller
public class CollectListController {

	@Autowired
	private ICollectListService iCollectListService;

	// 获取用户收藏夹
	@RequestMapping(value = "/getCollectList", method = RequestMethod.GET)
	public @ResponseBody ResponeDataForCollectList getCollectList(HttpSession session) {
		ResponeDataForCollectList ret = new ResponeDataForCollectList();
		Student u = (Student) session.getAttribute("student");
		if (u == null) {
			ret.setCode(201);
			ret.setInfo("用户未登录");
		} else {
			List<Integer> list = iCollectListService.getCollectList(u.getId());
			ret.setCode(200);
			ret.setInfo("获取收藏夹成功");
			ret.setData(list);
		}
		return ret;
	}

	// 为收藏夹添加某件商品
	@RequestMapping(value = "/addCollectList/{id}", method = RequestMethod.POST)
	public @ResponseBody BaseResponeData addCollectList(@PathVariable("id") int goodsId, HttpSession session) {
		BaseResponeData ret = new BaseResponeData();
		Student u = (Student) session.getAttribute("student");
		if (u == null) {
			ret.setCode(201);
			ret.setInfo("用户未登录");
		} else {
			iCollectListService.addCollectList(u.getId(), goodsId);
			ret.setCode(200);
			ret.setInfo("添加成功");
		}
		return ret;
	}

	// 从收藏夹删除某件商品
	@RequestMapping(value = "/deleteCollectList/{id}", method = RequestMethod.POST)
	public @ResponseBody BaseResponeData deleteCollectList(@PathVariable("id") int goodsId, HttpSession session) {
		BaseResponeData ret = new BaseResponeData();
		Student u = (Student) session.getAttribute("student");
		if (u == null) {
			ret.setCode(201);
			ret.setInfo("用户未登录");
		} else {
			int l = iCollectListService.deleteCollectList(u.getId(), goodsId);
			if (l >= 1) {
				ret.setCode(200);
				ret.setInfo("删除成功");
			} else if (l == 0) {
				ret.setCode(202);
				ret.setInfo("删除失败，没有该记录");
			}
		}

		return ret;
	}

	// 清空收藏夹
	@RequestMapping(value = "/deleteCollectList/{id}", method = RequestMethod.GET)
	public @ResponseBody BaseResponeData clearCollectList(HttpSession session) {
		BaseResponeData ret = new BaseResponeData();
		Student u = (Student) session.getAttribute("student");
		if (u == null) {
			ret.setCode(201);
			ret.setInfo("用户未登录");
		} else {
			int l = iCollectListService.clearCollectList(u.getId());
			ret.setCode(200);
			ret.setInfo("成功删除了" + l + "条记录");
		}
		return ret;
	}

}
