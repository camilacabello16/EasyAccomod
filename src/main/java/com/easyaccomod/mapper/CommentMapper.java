package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.CommentModel;

public class CommentMapper implements RowMapper<CommentModel> {

	@Override
	public CommentModel mapRow(ResultSet resultSet) {
		CommentModel commentModel = new CommentModel();
		try {
			commentModel.setId(resultSet.getLong("id"));
			commentModel.setUserId(resultSet.getLong("userid"));
			commentModel.setRoomId(resultSet.getLong("roomid"));
			commentModel.setContent(resultSet.getString("content"));
			commentModel.setCreatedBy(resultSet.getString("createdby"));
			commentModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				commentModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				commentModel.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return commentModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
