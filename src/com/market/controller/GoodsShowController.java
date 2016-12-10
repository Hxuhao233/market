package com.market.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.tools.GoodsInfoData;

/**
 * 商品展示
 * @author hxuhao
 *
 */

@RequestMapping("/GoodsShow")
public class GoodsShowController {
	
	@ResponseBody
	public GoodsInfoData ShowGoods(){
		return null;
		
	}
}
