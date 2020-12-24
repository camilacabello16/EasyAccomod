package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.IChatDao;
import com.easyaccomod.mapper.ChatMapper;
import com.easyaccomod.model.ChatModel;

public class ChatDao extends AbstractDao<ChatModel> implements IChatDao {

	@Override
	public Long save(ChatModel chatModel) {
		String sql = "INSERT INTO chat_table (content, role, adminid, createdby, createddate) VALUES(?,?,?,?,?)";
		return insert(sql, chatModel.getContent(), chatModel.getRole(), chatModel.getAdminId(),
				chatModel.getCreatedBy(), chatModel.getCreatedDate());
	}

	@Override
	public List<ChatModel> findByAdminId(Long adminId) {
		String sql = "SELECT * FROM chat_table WHERE adminid=? ORDER BY createddate ASC";
		return query(sql, new ChatMapper(), adminId);
	}

	@Override
	public ChatModel findOne(Long id) {
		String sql = "SELECT * FROM chat_table WHERE id=?";
		List<ChatModel> chats = query(sql, new ChatMapper(), id);
		return chats.isEmpty() ? null : chats.get(0);
	}

}
