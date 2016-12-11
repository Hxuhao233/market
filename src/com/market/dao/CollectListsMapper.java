package com.market.dao;

import java.util.List;
import java.util.Map;

import com.market.model.CollectLists;

public interface CollectListsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(CollectLists record);

	int insertSelective(CollectLists record);

	CollectLists selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CollectLists record);

	int updateByPrimaryKey(CollectLists record);

	List<Integer> selectGoodsIdByStudentId(Integer id);

	int deleteByStudentIdAndGoodsId(Map<String, Integer> studentIdAndGoodsId);

	int deleteByStudentId(Integer id);
}