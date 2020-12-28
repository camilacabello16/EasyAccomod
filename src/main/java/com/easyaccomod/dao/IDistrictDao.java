package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.DistrictModel;

public interface IDistrictDao extends GenericDao<DistrictModel> {
	List<DistrictModel> findAll(); 
}
