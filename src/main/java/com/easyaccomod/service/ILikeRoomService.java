package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.LikeRoomModel;

public interface ILikeRoomService {
	List<LikeRoomModel> findByUserId(Long userId);
	LikeRoomModel save(LikeRoomModel likeRoomModel);
	void delete(Long id);
}
