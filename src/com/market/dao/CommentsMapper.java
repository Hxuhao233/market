package com.market.dao;

import java.util.List;

import com.market.model.Comments;

public interface CommentsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Comments record);

	int insertSelective(Comments record);

	Comments selectByPrimaryKey(Integer id);

	List<Comments> selectByGoodsId(Integer gid);

	int updateByPrimaryKeySelective(Comments record);

	int updateByPrimaryKey(Comments record);
}