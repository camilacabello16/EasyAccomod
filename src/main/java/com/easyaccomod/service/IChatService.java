package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.ChatModel;

public interface IChatService {
	List<ChatModel> findByAdminId(Long adminId);
	ChatModel save(ChatModel chatModel);
}
