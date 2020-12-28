package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.LikeRoomModel;

public class LikeRoomMapper implements RowMapper<LikeRoomModel> {

	@Override
	public LikeRoomModel mapRow(ResultSet resultSet) {
		LikeRoomModel likeRoom = new LikeRoomModel();
		try {
			likeRoom.setId(resultSet.getLong("id"));
			likeRoom.setRoomId(resultSet.getLong("roomid"));
			likeRoom.setUserId(resultSet.getLong("userid"));
			return likeRoom;
		} catch (SQLException e) {
			return null;
		}
	}

}
