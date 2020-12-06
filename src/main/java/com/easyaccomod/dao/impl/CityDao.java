package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.ICityDao;
import com.easyaccomod.mapper.CityMapper;
import com.easyaccomod.model.CityModel;

public class CityDao extends AbstractDao<CityModel> implements ICityDao {

	@Override
	public List<CityModel> findAll() {
		String sql = "SELECT * FROM city";
		return query(sql, new CityMapper());
	}

}
