package com.hxuhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxuhao.dao.UniversityMapper;
import com.hxuhao.model.University;
import com.hxuhao.service.IUniversityService;

@Service("universityService")
public class UniversityServiceImpl implements IUniversityService{
	
	@Autowired
	private UniversityMapper universityDao; 
	
	
	@Override
	public University getUniversityById(int id) {
		// TODO Auto-generated method stub
		
		return universityDao.selectByPrimaryKey(id);
	}

	@Override
	public void createUniversity(University university) {
		// TODO Auto-generated method stub
		universityDao.insertSelective(university);
	}
	
}
