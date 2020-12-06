package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IAddressDao;
import com.easyaccomod.model.AddressModel;
import com.easyaccomod.service.IAddressService;

public class AddressService implements IAddressService {

	@Inject
	private IAddressDao addrDao;
	
	@Override
	public List<AddressModel> findAll() {
		return addrDao.findAll();
	}

}
