package com.market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CollectListsMapper;
import com.market.dao.GoodsMapper;
import com.market.model.CollectLists;
import com.market.service.ICollectListService;

@Service("collectListService")
public class CollectListServiceImpl implements ICollectListService {

	@Autowired
	CollectListsMapper collectListDao;
	@Autowired
	public GoodsMapper goodsDao;

	@Override
	public List<Integer> getCollectList(Integer studentId) {
		return collectListDao.selectGoodsIdByStudentId(studentId);
	}

	@Override
	public void addCollectList(Integer studentId, Integer goodsId) {
		CollectLists lists = new CollectLists();
		lists.setGoodsid(goodsId);
		lists.setStudentid(studentId);
		
		int ret = collectListDao.insertSelective(lists);
		//System.out.println("infected row : " + ret);
		if(ret>0){
			goodsDao.addOne(goodsId, "collectedTimes");
		}
	}

	@Override
	public int deleteCollectList(Integer studentId, Integer goodsId) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("studentid", studentId);
		param.put("goodsid", goodsId);
		goodsDao.subtractOne(goodsId, "collectedTimes");
		return collectListDao.deleteByStudentIdAndGoodsId(param);
	}

	@Override
	public int clearCollectList(Integer studentId) {
		List<Integer> gList = collectListDao.selectGoodsIdByStudentId(studentId);
		for (int i = 0; i < gList.size(); i++) {
			goodsDao.subtractOne(gList.get(i), "collectedTimes");
		}
		return collectListDao.deleteByStudentId(studentId);
	}
}
