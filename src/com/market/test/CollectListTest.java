package com.market.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.dao.GoodsMapper;
import com.market.service.ICollectListService;
import com.market.service.impl.CollectListServiceImpl;


public class CollectListTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
	ICollectListService iCollectListService = (ICollectListService) ac.getBean("collectListService");
	
	
	//@Test
	//获取用户收藏夹
	public void getTest ()
	{
		Integer sid = 1;
		List<Integer>gList=iCollectListService.getCollectList(sid);
		System.out.println("ID为"+sid+"的用户的收藏列表为：");
		for (int i = 0; i < gList.size(); i++) {
			System.out.print("第"+(i+1)+"件ID:"+gList.get(i));
			System.out.println("收藏数:"+((CollectListServiceImpl)iCollectListService).goodsDao.selectByPrimaryKey(gList.get(i)).getCollectedtimes());
		}
		
	}
	@Test
	//为收藏夹添加某件商品
	public void addTest()
	{
		Integer sid=1;
		Integer gid=5;
		System.out.print("添加前");
		getTest();
		iCollectListService.addCollectList(sid, gid);
		System.out.print("添加后");
		getTest();
	}

	
	//@Test
	//从收藏夹删除某件商品
	public void deleteTest()
	{
		Integer sid=1;
		Integer gid=4;
		System.out.println("删除前");
		getTest();
		iCollectListService.deleteCollectList(sid, gid);
		System.out.println("删除后");
		getTest();
	}
	
	//@Test
	//清空收藏夹
	public void clearTest ()
	{
		Integer sid = 1;
		System.out.println("清空前");
		getTest();
		iCollectListService.clearCollectList(sid);
		System.out.println("清空后");
		getTest();
	}
}
