package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.RoomModel;

public interface IRoomService {
	List<RoomModel> findByType(Long typeId);
	List<RoomModel> findAll();
	RoomModel findOne(Long id);
	//add
	RoomModel save(RoomModel roomModel);
	//update
	RoomModel update(RoomModel updateRoom);
	//delete
	void delete(long[] ids);
}
