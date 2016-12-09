package com.market.service;

import com.market.model.University;

public interface IUniversityService {
	public University getUniversityById(int id);

	public void createUniversity(University university);

}
