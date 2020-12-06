package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.AddressModel;

public class AddressMapper implements RowMapper<AddressModel> {

	@Override
	public AddressModel mapRow(ResultSet resultSet) {
		AddressModel address = new AddressModel();
		try {
			address.setId(resultSet.getLong("id"));
			address.setDistrict(resultSet.getString("district"));
			address.setCityId(resultSet.getLong("cityid"));
			address.setStreet(resultSet.getString("street"));
			return address;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
