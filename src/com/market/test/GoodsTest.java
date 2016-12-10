package com.market.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.model.Goods;

import com.market.service.IGoodsService;
import com.market.tools.GoodsInfo;

public class GoodsTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
		IGoodsService iGoodsService = (IGoodsService) ac.getBean("goodsService");
		Goods goods = new Goods();
		goods.setCategoryid(1);
		goods.setDescription("2333");
		
		List<GoodsInfo> goodsList = iGoodsService.queryGoods(1);
		System.out.println(goodsList.get(1).getGood().getDescription());
		((ClassPathXmlApplicationContext) ac).close();
	}
}
