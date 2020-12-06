package com.easyaccomod.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IRoomDao;
import com.easyaccomod.model.RoomModel;
import com.easyaccomod.service.IRoomService;

public class RoomService implements IRoomService {

	@Inject
	private IRoomDao roomDao;
	
	@Override
	public List<RoomModel> findByType(Long typeId) {
		return roomDao.findByType(typeId);
	}

	@Override
	public RoomModel save(RoomModel roomModel) {
		roomModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		roomModel.setCreatedBy("");
		Long roomId = roomDao.save(roomModel);
		return roomDao.findOne(roomId);
	}

	@Override
	public RoomModel update(RoomModel updateRoom) {
		RoomModel oldRoom = roomDao.findOne(updateRoom.getId());
		updateRoom.setCreatedDate(oldRoom.getCreatedDate());
		updateRoom.setCreatedBy(oldRoom.getCreatedBy());
		updateRoom.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateRoom.setModifiedBy("");
		roomDao.update(updateRoom);
		return roomDao.findOne(updateRoom.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			roomDao.delete(id);
		}
	}

	@Override
	public List<RoomModel> findAll() {
		return roomDao.findAll();
	}
	
}
