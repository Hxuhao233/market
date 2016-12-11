package com.market.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.model.Comments;
import com.market.service.IGoodsShowService;
import com.market.tools.GoodsData;

public class GoodsShowTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
	IGoodsShowService iGoodsShowService = (IGoodsShowService) ac.getBean("goodsShowService");

	// @Test
	public void addTest() {

		// 点赞
		System.out.println(iGoodsShowService.praiseGoods(4));

		// 评论
		System.out.println(iGoodsShowService.addComments(new Comments("这是一条商品评论", 1, 4)));

		((ClassPathXmlApplicationContext) ac).close();
	}

	@Test
	// 查找商品
	public void queryTest() throws JsonProcessingException {
		List<GoodsData> goodsDataList = new ArrayList<GoodsData>();
		goodsDataList = iGoodsShowService.getGoods("praiseTimes", "desc");
		ObjectMapper mapper = new ObjectMapper();
		for (GoodsData goodsData : goodsDataList) {

			String item = mapper.writeValueAsString(goodsData);
			System.out.println(item);
		}

	}

}
