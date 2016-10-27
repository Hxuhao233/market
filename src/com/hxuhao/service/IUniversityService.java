package com.hxuhao.service;

import com.hxuhao.model.University;

public interface IUniversityService {
	public University getUniversityById(int id);
	public void createUniversity(University university);
	
}
