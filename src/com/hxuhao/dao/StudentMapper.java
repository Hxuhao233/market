package com.hxuhao.dao;

import com.hxuhao.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int selectByAccountAndPassword(Student student);
    
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}