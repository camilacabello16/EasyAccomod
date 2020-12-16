package com.easyaccomod.dao.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IAddressDao;
import com.easyaccomod.dao.ICityDao;
import com.easyaccomod.mapper.AddressMapper;
import com.easyaccomod.model.AddressModel;
import com.easyaccomod.model.CityModel;

public class AddressDao extends AbstractDao<AddressModel> implements IAddressDao {

	@Inject
	private ICityDao cityDao;
	
	@Override
	public List<AddressModel> findAll() {
		String sql = "SELECT * FROM address";
		return query(sql, new AddressMapper());
	}

	@Override
	public AddressModel findOne(long id) {
		String sql = "SELECT * FROM address WHERE id=?";
		List<AddressModel> addr = query(sql, new AddressMapper(), id);
		AddressModel addrModel = addr.get(0);
		CityModel city = cityDao.findOne(addrModel.getCityId());
		addrModel.setCity(city.getCity());
		return addrModel;
	}

}
