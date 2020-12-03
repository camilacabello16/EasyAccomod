package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.RoomTypeModel;

public class TypeMapper implements RowMapper<RoomTypeModel> {

	@Override
	public RoomTypeModel mapRow(ResultSet resultSet) {
		RoomTypeModel type = new RoomTypeModel();
		try {
			type.setId(resultSet.getLong("id"));
			type.setName(resultSet.getString("name"));
			type.setType(resultSet.getString("type"));
			return type;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
