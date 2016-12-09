package com.market.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品管理
 */

import org.springframework.beans.factory.annotation.Autowired;
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
import com.market.service.IGoodsService;

import com.market.tools.GoodsInfo;

@Controller
@RequestMapping(value = "/Goods")
public class GoodsController {

	@Autowired
	private IGoodsService iGoodsService;

	@RequestMapping(value = "/Goods", method = RequestMethod.POST)
	public @ResponseBody GoodsInfo publishGoods(Goods goods,
			@RequestParam(value = "files", required = true) MultipartFile[] files,ContactWays contactWays ,HttpServletRequest request) {
		GoodsInfo goodsInfo = new GoodsInfo();
		System.out.println(goods.getGoodsname());
		if (goods.getCategoryid() == null)
			goods.setCategoryid(1);


		//	保存商品基本信息
		int ret = iGoodsService.publishGoods(goods);
		
		String pathRoot = request.getSession().getServletContext().getRealPath("/") + "../static";
		goodsInfo.setGood(goods);
		System.out.println("发布商品 :" + goods.getId());
		
		// 保存图片
		if (goods.getId() > 0 && files.length > 0) {
			
			System.out.println(files.length);
			List<String> filePaths = iGoodsService.uploadImages(goods.getId(), pathRoot, files);
			goodsInfo.setPictureAddr(filePaths);
		}
		
		//	保存联系方式
		System.out.println(contactWays.getPhonenum());
		if(!"".equals(contactWays.getPhonenum()) || !"".equals(contactWays.getQqnum())){
			contactWays.setGoodsid(goods.getId());
			iGoodsService.uploadContactWay(contactWays);
		}
		return goodsInfo;
	}

	@RequestMapping(value = "/Goods/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateGoodsInfo(@PathVariable("id") int id, @RequestBody Goods goods) {
		return null;
	}

	@RequestMapping(value = "/Goods", method = RequestMethod.GET)
	public @ResponseBody int deleteGoods() {
		return 1;
	}

	public ResponseEntity<Goods> queryGoods(@RequestBody Goods goods, UriComponentsBuilder ucbuilder) {
		return null;
	}
}
