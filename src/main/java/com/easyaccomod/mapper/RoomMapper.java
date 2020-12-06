package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.RoomModel;

public class RoomMapper implements RowMapper<RoomModel> {

	@Override
	public RoomModel mapRow(ResultSet resultSet) {
		RoomModel room = new RoomModel();
		try {
			room.setId(resultSet.getLong("id"));
			room.setAddressId(resultSet.getLong("addressid"));
			room.setDescription(resultSet.getString("description"));
			room.setPrice(resultSet.getString("price"));
			room.setArea(resultSet.getInt("area"));
			room.setTypeId(resultSet.getLong("typeid"));
			room.setNumberOfRoom(resultSet.getInt("numberofroom"));
			room.setOwner(resultSet.getString("owner"));
			room.setBathroom(resultSet.getString("bathroom"));
			room.setKitchen(resultSet.getString("kitchen"));
			room.setAircondition(resultSet.getString("aircondition"));
			room.setBacony(resultSet.getString("bacony"));
			room.setImage(resultSet.getString("image"));
			room.setCreatedBy(resultSet.getString("createdby"));
			room.setCreatedDate(resultSet.getTimestamp("createddate"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				room.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedBy") != null) {
				room.setModifiedBy(resultSet.getString("modifiedby"));
			}
			room.setRating(resultSet.getInt("rating"));
			room.setSeen(resultSet.getLong("seen"));
			room.setPhone(resultSet.getString("phone"));
			room.setStatus(resultSet.getInt("status"));
			return room;
		}catch(SQLException e) {
			return null;
		}
	}

}
