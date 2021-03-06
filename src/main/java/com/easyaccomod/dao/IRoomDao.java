package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.RoomModel;

public interface IRoomDao extends GenericDao<RoomModel> {
	List<RoomModel> findByType(Long typeId);
	Long save(RoomModel roomModel);
	RoomModel findOne(Long id);
	void update(RoomModel updateRoom);
	void delete(long id);
	List<RoomModel> findAll();
	void updateSeen(Long id);
	void updateRating(int rating, Long id);
	List<RoomModel> searchRoom(Long roomType, String addrStreet, int price, int area);
	List<RoomModel> findBySeen();
}