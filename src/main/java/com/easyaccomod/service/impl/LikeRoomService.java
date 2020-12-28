package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.ILikeRoomDao;
import com.easyaccomod.model.LikeRoomModel;
import com.easyaccomod.service.ILikeRoomService;

public class LikeRoomService implements ILikeRoomService {

	@Inject
	private ILikeRoomDao likeRoomDao;
	
	@Override
	public List<LikeRoomModel> findByUserId(Long userId) {
		return likeRoomDao.findByUserId(userId);
	}

	@Override
	public LikeRoomModel save(LikeRoomModel likeRoomModel) {
		Long likeRoomId = likeRoomDao.save(likeRoomModel);
		return likeRoomDao.findOne(likeRoomId);
	}

	@Override
	public void delete(Long id) {
		likeRoomDao.delete(id);
	}

}
