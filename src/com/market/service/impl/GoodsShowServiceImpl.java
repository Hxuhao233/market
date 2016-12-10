package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CommentsMapper;
import com.market.dao.GoodsMapper;
import com.market.model.Comments;
import com.market.service.IGoodsShowService;
import com.market.tools.GoodsData;

@Service("goodsShowService")
public class GoodsShowServiceImpl implements IGoodsShowService{
	

	
	@Autowired
	private CommentsMapper commentsDao;
	
	@Autowired
	private GoodsMapper goodsDao;
	
	@Override
	public int praiseGoods(int goodsid) {
		// TODO Auto-generated method stub
		
		return goodsDao.addOne(goodsid, "praiseTimes");
	}

	@Override
	public int addComments(Comments comments) {
		// TODO Auto-generated method stub
		int ret = commentsDao.insertSelective(comments);
	/*
		if(ret>0){
			return goodsDao.addOne(comments.getGoodsid(), "comments");
		}
		*/
		return ret;
		
	}

	@Override
	public List<GoodsData> getGoods(String sortWay) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<GoodsData> getGoods(String sortWay, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsData> getGoods(String sortWay, String category, String info) {
		// TODO Auto-generated method stub
		return null;
	}

}
