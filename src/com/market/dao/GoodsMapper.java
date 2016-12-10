package com.market.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.market.model.Goods;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer id);
	
	List<Goods> selectByKey(Integer pid);
	
	List<Goods> selectWithRules(@Param("sortWay")String sortWay,@Param("category")String category);
	
	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);
	
	int addOne(@Param("gid")Integer gid,@Param("field")String field);
}