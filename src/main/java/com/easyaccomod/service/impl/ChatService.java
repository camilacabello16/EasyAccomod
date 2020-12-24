package com.easyaccomod.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IChatDao;
import com.easyaccomod.model.ChatModel;
import com.easyaccomod.service.IChatService;

public class ChatService implements IChatService {

	@Inject
	private IChatDao chatDao;
	
	@Override
	public List<ChatModel> findByAdminId(Long adminId) {
		return chatDao.findByAdminId(adminId);
	}

	@Override
	public ChatModel save(ChatModel chatModel) {
		chatModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long chatId = chatDao.save(chatModel);
		return chatDao.findOne(chatId);
	}

}
