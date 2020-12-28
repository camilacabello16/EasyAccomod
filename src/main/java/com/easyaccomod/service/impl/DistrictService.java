package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IDistrictDao;
import com.easyaccomod.model.DistrictModel;
import com.easyaccomod.service.IDistrictService;

public class DistrictService implements IDistrictService {

	@Inject
	private IDistrictDao districtDao;
	
	@Override
	public List<DistrictModel> findAll() {
		return districtDao.findAll();
	}

}
