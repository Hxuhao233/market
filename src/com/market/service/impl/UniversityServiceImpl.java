package com.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.UniversityMapper;
import com.market.model.University;
import com.market.service.IUniversityService;

@Service("universityService")
public class UniversityServiceImpl implements IUniversityService {

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
