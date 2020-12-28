package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.IDistrictDao;
import com.easyaccomod.mapper.DistrictMapper;
import com.easyaccomod.model.DistrictModel;

public class DistrictDao extends AbstractDao<DistrictModel> implements IDistrictDao {

	@Override
	public List<DistrictModel> findAll() {
		String sql = "SELECT * FROM district";
		return query(sql, new DistrictMapper());
	}

}
