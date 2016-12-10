package com.market.dao;

import java.util.List;

import com.market.model.Goods;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer id);
	
	List<Goods>  selectByKey(Integer pid);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);
}