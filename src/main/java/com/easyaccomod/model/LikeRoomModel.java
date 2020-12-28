package com.easyaccomod.model;

public class LikeRoomModel extends AbstractModel<LikeRoomModel> {
	private Long roomId;
	private Long userId;
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
