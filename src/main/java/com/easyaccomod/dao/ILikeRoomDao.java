package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.LikeRoomModel;

public interface ILikeRoomDao extends GenericDao<LikeRoomModel> {
	List<LikeRoomModel> findByUserId(Long userId);
	LikeRoomModel findOne(Long id);
	Long save(LikeRoomModel likeRoomModel);
	void delete(long id);
}
