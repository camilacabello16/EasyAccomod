package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.ChatModel;

public interface IChatDao extends GenericDao<ChatModel> {
	Long save(ChatModel chatModel);
	List<ChatModel> findByAdminId(Long adminId);
	ChatModel findOne(Long id);
}
