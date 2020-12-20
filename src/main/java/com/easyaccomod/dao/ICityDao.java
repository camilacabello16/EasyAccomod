package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.CityModel;

public interface ICityDao extends GenericDao<CityModel> {
	List<CityModel> findAll();
	CityModel findOne(long id);
	CityModel findOneByCity(String city);
}
