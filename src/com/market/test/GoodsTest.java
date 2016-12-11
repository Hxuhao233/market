package com.market.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.model.Goods;

import com.market.service.IGoodsService;

import com.market.tools.GoodsData;
import com.market.tools.GoodsInfo;

public class GoodsTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
	IGoodsService iGoodsService = (IGoodsService) ac.getBean("goodsService");

	// 查询已发布商品
	@Test
	public void queryMyGoods() throws JsonProcessingException {

		Goods goods = new Goods();
		goods.setCategoryid(1);
		goods.setDescription("2333");

		List<GoodsData> goodsList = iGoodsService.queryGoods(1);

		System.out.println("queryMyGoods result : ");
		// 输出json
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(goodsList));
		((ClassPathXmlApplicationContext) ac).close();
	}

	// 发布商品
	public void publishGoods() {

		Goods goods = new Goods();
		goods.setCategoryid(1);
		goods.setDescription("2333");

		int ret = iGoodsService.publishGoods(goods, "2924506260264f9da40c0451c1fa83a7.png");
		System.out.println("publishGoods result : " + ret);

		((ClassPathXmlApplicationContext) ac).close();
	}

}
