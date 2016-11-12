package com.market.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品管理
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.model.Goods;
import com.market.service.IGoodsService;
import com.market.tools.PhotoData;

@RestController
@RequestMapping(value="/Goods")
public class GoodsController {
	
	//@Autowired
	private IGoodsService iGoodsService;
	
	@RequestMapping(value="/Goods",method=RequestMethod.POST)
	public String publishGoods(@RequestBody Map<String,PhotoData[]> photos) {
	
		
		System.out.println(photos.size());
		System.out.println(photos.get("photos").length);
		return "2333333";
	}
	
	@RequestMapping(value="/Goods/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateGoodsInfo(@PathVariable("id")int id, @RequestBody  Goods goods) {
		return null;
	}
	
	public ResponseEntity<Void> deleteGoods(@RequestBody  Goods goods, UriComponentsBuilder ucbuilder) {
		return null;
	}
	
	public ResponseEntity<Goods> queryGoods(@RequestBody  Goods goods, UriComponentsBuilder ucbuilder) {
		return null;
	}
}
