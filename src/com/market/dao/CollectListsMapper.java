package com.market.dao;

import com.market.model.CollectLists;

public interface CollectListsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectLists record);

    int insertSelective(CollectLists record);

    CollectLists selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectLists record);

    int updateByPrimaryKey(CollectLists record);
}