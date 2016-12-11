package com.market.service;

import java.util.List;

import com.market.model.Comments;
import com.market.tools.GoodsData;

public interface IGoodsShowService {

	int praiseGoods(int goodsid); // 商品点赞

	int addComments(Comments comments); // 提交商品评论

	List<GoodsData> getGoods(String sortField, String sortType); // 查看排序商品

	List<GoodsData> getGoods(String sortField, String sortType, int category); // 查看排序商品
																				// +
																				// 目录

	List<GoodsData> getGoods(String sortField, String sortType, int category, String info); // 查看排序商品
																							// +
																							// 目录
																							// +
																							// 搜索
}
