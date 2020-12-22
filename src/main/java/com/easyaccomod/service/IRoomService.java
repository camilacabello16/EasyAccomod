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
	
	void updateSeen(Long id);
	void updateRating(int rating, Long id);
	List<RoomModel> searchRoom(Long roomType, String addrStreet, int price, int area);
	List<RoomModel> findBySeen();
}
