package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.ChatModel;

public class ChatMapper implements RowMapper<ChatModel> {

	@Override
	public ChatModel mapRow(ResultSet resultSet) {
		ChatModel chat = new ChatModel();
		try {
			chat.setId(resultSet.getLong("id"));
			chat.setContent(resultSet.getString("content"));
			chat.setRole(resultSet.getInt("role"));
			chat.setAdminId(resultSet.getLong("adminid"));
			chat.setCreatedBy(resultSet.getString("createdby"));
			chat.setCreatedDate(resultSet.getTimestamp("createddate"));
			return chat;
		}catch(SQLException e) {
			return null;
		}
	}

}
