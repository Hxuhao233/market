package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 商品管理
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.model.ContactWays;
import com.market.model.Goods;
import com.market.model.Student;
import com.market.service.IGoodsService;
import com.market.tools.GoodsData;
import com.market.tools.GoodsInfo;
import com.market.tools.GoodsInfoData;
import com.market.tools.Message;
import com.market.tools.RequestData;
import com.market.tools.ResponeData;

@Controller
@RequestMapping(value = "/Goods")
public class GoodsController {

	@Autowired
	private IGoodsService iGoodsService;

	@RequestMapping(value = "/publishGoods", method = RequestMethod.POST)
	public @ResponseBody Message publishGoods(@RequestBody GoodsData goodsData, HttpServletRequest request,
			HttpSession session) {
		Message response = new Message();

		Student user = (Student) session.getAttribute("student");
		int uid = user != null ? user.getId() : 1;

		Goods goods = goodsData.getGoods();
		goods.setPublisherid(uid);
		ContactWays contactWays = goodsData.getContactWays();

		System.out.println(goods.getGoodsname());
		if (goods.getCategoryid() == null)
			goods.setCategoryid(1);

		// 保存商品基本信息
		int ret = iGoodsService.publishGoods(goods, goodsData.getImagePath());
		if (ret > 0) {
			response.setCode(200);
			response.setInfo("发布商品成功");
			System.out.println("发布商品 :" + goods.getId());
		} else {
			response.setCode(401);
			response.setInfo("发布商品失败");
		}

		/*
		 * // 保存图片
		 * 
		 * String pathRoot =
		 * request.getSession().getServletContext().getRealPath("/") +
		 * "../static"; if (goods.getId() > 0 && files.length > 0) {
		 * 
		 * System.out.println(files.length); List<String> filePaths =
		 * iGoodsService.uploadImages(goods.getId(), pathRoot, files);
		 * goodsInfo.setPictureAddr(filePaths); }
		 */
		// 保存联系方式
		System.out.println(contactWays.getPhonenum());
		if (!"".equals(contactWays.getPhonenum()) || !"".equals(contactWays.getQqnum())) {
			contactWays.setGoodsid(goods.getId());
			iGoodsService.uploadContactWay(contactWays);
		}
		return response;
	}

	// 保存图片
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> register(
			@RequestParam(value = "files", required = false) MultipartFile[] files, HttpServletRequest request,
			HttpSession session) {

		Student user = (Student) session.getAttribute("student");
		int uid = user != null ? user.getId() : 1;

		Map<String, Object> results = new HashMap<String, Object>();
		String pathRoot = request.getSession().getServletContext().getRealPath("/") + "../static";
		System.out.println(pathRoot);
		if (files.length > 0) {
			List<String> filePaths = iGoodsService.uploadImages(uid, pathRoot, files);
			results.put("imagePaths", filePaths);
		}

		return new ResponseEntity<Map<String, Object>>(results, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/Goods/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateGoodsInfo(@PathVariable("id") int id, @RequestBody Goods goods) {
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteGoods{gid}", method = RequestMethod.GET)
	public GoodsInfoData deleteGoods(@PathVariable("gid") int pid, HttpSession session) {
		GoodsInfoData goodsInfoData = new GoodsInfoData();

		Student user = (Student) session.getAttribute("student");
		int pid1 = user != null ? user.getId() : Integer.valueOf(pid);

		if (iGoodsService.deleteGoods() > 0) {
			List<GoodsData> goodsInfoList = iGoodsService.queryGoods(pid1);

			if (goodsInfoList.size() == 0) {
				goodsInfoData.setCode(404);
			} else {
				goodsInfoData = new GoodsInfoData(200, goodsInfoList);
			}

		} else {
			goodsInfoData.setCode(500);
		}
		return goodsInfoData;
	}

	@ResponseBody
	@RequestMapping(value = "/queryPublishedGoods/{pid}", method = RequestMethod.GET)
	// 查询已发布商品
	public GoodsInfoData queryGoods(@PathVariable("pid") int pid, HttpSession session) {
		GoodsInfoData goodsInfoData;
		Student user = (Student) session.getAttribute("student");
		int pid1 = user != null ? user.getId() : Integer.valueOf(pid);

		List<GoodsData> goodsInfoList = iGoodsService.queryGoods(pid1);

		if (goodsInfoList.size() == 0) {
			goodsInfoData = new GoodsInfoData(404, null);
		} else {
			goodsInfoData = new GoodsInfoData(200, goodsInfoList);
		}
		return goodsInfoData;
	}
}
