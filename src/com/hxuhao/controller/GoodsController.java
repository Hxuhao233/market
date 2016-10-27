package com.hxuhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hxuhao.model.Goods;
//import com.hxuhao.service.IGoodsService;

@RestController
//@RequestMapping(value="/Goods")
public class GoodsController {
	
	//@Autowired
	//private IGoodsService iGoodsService;
	
	@RequestMapping(value="publishGoods",method=RequestMethod.POST)
	public String publishGoods(/*@RequestBody  Goods goods, UriComponentsBuilder ucbuilder*/) {
		return "2333";
	}
	
	public ResponseEntity<Void> updateGoodsInfo(@RequestBody  Goods goods, UriComponentsBuilder ucbuilder) {
		return null;
	}
	
	public ResponseEntity<Void> deleteGoods(@RequestBody  Goods goods, UriComponentsBuilder ucbuilder) {
		return null;
	}
	
	public ResponseEntity<Goods> queryGoods(@RequestBody  Goods goods, UriComponentsBuilder ucbuilder) {
		return null;
	}
}
