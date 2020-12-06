package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.ICityDao;
import com.easyaccomod.model.CityModel;
import com.easyaccomod.service.ICityService;

public class CityService implements ICityService {

	@Inject
	private ICityDao cityDao;
	
	@Override
	public List<CityModel> findAll() {
		return cityDao.findAll();
	}

}
