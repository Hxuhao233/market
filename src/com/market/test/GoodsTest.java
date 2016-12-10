package com.market.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.model.Goods;

import com.market.service.IGoodsService;

import com.market.tools.GoodsData;
import com.market.tools.GoodsInfo;

public class GoodsTest {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
	IGoodsService iGoodsService = (IGoodsService) ac.getBean("goodsService");
	
	// 查询已发布商品
	@Test
	public  void queryMyGoods() {

		Goods goods = new Goods();
		goods.setCategoryid(1);
		goods.setDescription("2333");
		
		List<GoodsData> goodsList = iGoodsService.queryGoods(1);
		System.out.println(goodsList.get(1).getContactWays().getQqnum());
		((ClassPathXmlApplicationContext) ac).close();
	}
	
	
	
}
