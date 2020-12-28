package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.DistrictModel;

public class DistrictMapper implements RowMapper<DistrictModel> {

	@Override
	public DistrictModel mapRow(ResultSet resultSet) {
		DistrictModel district = new DistrictModel();
		try {
			district.setDistrictName(resultSet.getString("districtname"));
			return district;
		} catch (SQLException e) {
			return null;
		}
	}

}
