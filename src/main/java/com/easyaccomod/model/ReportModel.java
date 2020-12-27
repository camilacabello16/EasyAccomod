package com.easyaccomod.model;

public class ReportModel extends AbstractModel<ReportModel> {
	private String content;
	private Long roomId;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
}
