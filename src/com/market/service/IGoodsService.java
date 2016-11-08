package com.market.service;

import java.util.List;

public interface IGoodsService {
	public int publishGoods();				// 发布商品
	public int deleteGoods();					// 删除已发布商品
	public int modifyGoods();				// 修改已发布商品
	public List<Object> queryGoods();	// 查询商品 
}
