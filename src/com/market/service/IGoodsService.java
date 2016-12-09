package com.market.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.market.model.ContactWays;
import com.market.model.Goods;

public interface IGoodsService {
	public int publishGoods(Goods goods); // 发布商品

	public int deleteGoods(); // 删除已发布商品

	public int modifyGoods(); // 修改已发布商品

	public List<Object> queryGoods(); // 查询商品

	public List<String> uploadImages(int userId, String path, MultipartFile[] files);		//　添加商品图片
	
	public int uploadContactWay(ContactWays contactWays);			//　添加商品联系方式
}
