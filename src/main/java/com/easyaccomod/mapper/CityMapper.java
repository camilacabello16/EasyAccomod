package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.CityModel;

public class CityMapper implements RowMapper<CityModel> {

	@Override
	public CityModel mapRow(ResultSet resultSet) {
		CityModel city = new CityModel();
		try {
			city.setId(resultSet.getLong("id"));
			city.setCity(resultSet.getString("city"));
			return city;
		} catch (SQLException e) {
			return null;
		}
	}

}
