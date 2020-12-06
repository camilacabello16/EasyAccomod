package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.IAddressDao;
import com.easyaccomod.mapper.AddressMapper;
import com.easyaccomod.model.AddressModel;

public class AddressDao extends AbstractDao<AddressModel> implements IAddressDao {

	@Override
	public List<AddressModel> findAll() {
		String sql = "SELECT * FROM address";
		return query(sql, new AddressMapper());
	}

}
