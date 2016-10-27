package com.hxuhao.dao;

import com.hxuhao.model.GoodsPicrures;

public interface GoodsPicruresMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPicrures record);

    int insertSelective(GoodsPicrures record);

    GoodsPicrures selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPicrures record);

    int updateByPrimaryKey(GoodsPicrures record);
}