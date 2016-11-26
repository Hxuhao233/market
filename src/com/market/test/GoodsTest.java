package com.market.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.model.Goods;
import com.market.model.Student;
import com.market.service.IGoodsService;
import com.market.service.IStudentService;

public class GoodsTest {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
		IGoodsService iGoodsService = (IGoodsService)ac.getBean("goodsService");
		Goods goods = new Goods();
		goods.setCategoryid(1);
		goods.setDescription("2333");
		System.out.println(iGoodsService.publishGoods(goods));
	}
}
