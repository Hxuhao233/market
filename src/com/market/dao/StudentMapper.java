package com.market.dao;

import java.util.Map;

import com.market.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    int selectAccount(String name);
    
    Student selectByKey(Map<String, String> accountAndPassword);
    
   // Student selectByAccountAndPassword(String account,String password);
}