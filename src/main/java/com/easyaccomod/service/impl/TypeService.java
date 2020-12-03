package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.ITypeDao;
import com.easyaccomod.model.RoomTypeModel;
import com.easyaccomod.service.ITypeService;

public class TypeService implements ITypeService {

	@Inject
	private ITypeDao typeDao;
	
	@Override
	public List<RoomTypeModel> findAll() {
		return typeDao.findAll();
	}

}
