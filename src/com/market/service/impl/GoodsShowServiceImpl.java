package com.market.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CommentsMapper;
import com.market.dao.ContactWaysMapper;
import com.market.dao.GoodsMapper;
import com.market.dao.GoodsPicturesMapper;
import com.market.model.Comments;
import com.market.model.ContactWays;
import com.market.model.Goods;
import com.market.service.IGoodsShowService;
import com.market.tools.GoodsData;

@Service("goodsShowService")
public class GoodsShowServiceImpl implements IGoodsShowService{
	

	
	@Autowired
	private CommentsMapper commentsDao;
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private GoodsPicturesMapper goodsPicturesDao;
	@Autowired
	private ContactWaysMapper contactWayDao;
	
	
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
	public List<GoodsData> getGoods(String sortField,String sortType) {
		// TODO Auto-generated method stub
		return getGoods(sortField, sortType,0, null);
	}

	@Override
	public List<GoodsData> getGoods(String sortField,String sortType, int category) {
		// TODO Auto-generated method stub
		return getGoods(sortField, sortType,category, null);
	}
	


	@Override
	public List<GoodsData> getGoods(String sortField,String sortType, int category, String info) {
		// TODO Auto-generated method stub
		List<GoodsData> goodsDataList = new ArrayList<GoodsData>();
		// 查找商品
		if(info!=null){
			info = info+"*";
		}
		List<Goods> goodsList = goodsDao.selectWithRules(sortField, sortType,category,info);
		for(Goods goodsItem : goodsList){
			GoodsData goodsDataItem = new GoodsData();
			List<String> pictureAddrList = goodsPicturesDao.selectByGoodsId(goodsItem.getId());
			List<Comments> commentsList = commentsDao.selectByGoodsId(goodsItem.getId());
			ContactWays contactWays = contactWayDao.selectByKey(goodsItem.getId());
			goodsDataItem.setGoods(goodsItem);
			goodsDataItem.setComments(commentsList);
			goodsDataItem.setContactWays(contactWays);
			goodsDataItem.setImagePath(pictureAddrList.size()>0 ? pictureAddrList.get(0) : null);
			goodsDataList.add(goodsDataItem);
		}
		return goodsDataList;
	}

}
