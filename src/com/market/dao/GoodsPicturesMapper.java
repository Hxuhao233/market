package com.market.dao;

import java.util.List;

import com.market.model.GoodsPictures;

public interface GoodsPicturesMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GoodsPictures record);

	int insertSelective(GoodsPictures record);

	GoodsPictures selectByPrimaryKey(Integer id);
	
	List <String> selectByKey(Integer gid);
	
	int updateByPrimaryKeySelective(GoodsPictures record);

	int updateByPrimaryKey(GoodsPictures record);
}