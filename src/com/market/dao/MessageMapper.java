package com.market.dao;

import java.util.List;

import com.market.model.Message;

public interface MessageMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Message record);

	int insertSelective(Message record);

	Message selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Message record);

	int updateByPrimaryKey(Message record);
	
	List<Message> selectByStudentId(Integer id);

}