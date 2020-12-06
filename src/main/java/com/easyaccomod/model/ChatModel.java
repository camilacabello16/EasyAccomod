package com.easyaccomod.model;

public class ChatModel extends AbstractModel<ChatModel> {
	private Long userId;
	private String content;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
