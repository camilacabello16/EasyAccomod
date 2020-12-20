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

	@Override
	public CityModel findOne(long id) {
		String sql = "SELECT * FROM city WHERE id=?";
		List<CityModel> city = query(sql, new CityMapper(), id);
		return city.isEmpty() ? null : city.get(0);
	}

	@Override
	public CityModel findOneByCity(String city) {
		String sql = "SELECT * FROM city WHERE city = ?";
		List<CityModel> cities = query(sql, new CityMapper(), city);
		return cities.isEmpty() ? null : cities.get(0);
	}

}
