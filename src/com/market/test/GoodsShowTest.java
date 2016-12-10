package com.market.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.model.Comments;
import com.market.service.IGoodsShowService;

public class GoodsShowTest {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
	IGoodsShowService iGoodsShowService = (IGoodsShowService) ac.getBean("goodsShowService");
	
	@Test
	public void addTest(){

		//点赞
		System.out.println(iGoodsShowService.praiseGoods(4));
		
		// 评论
		System.out.println(iGoodsShowService.addComments(new Comments("这是一条商品评论",1,4)));
		
		((ClassPathXmlApplicationContext) ac).close();
	}
	
	@Test
	public void queryTest(){
		
	}
	
}
