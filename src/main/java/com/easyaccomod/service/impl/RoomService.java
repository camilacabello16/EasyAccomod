package com.easyaccomod.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IAddressDao;
import com.easyaccomod.dao.IRoomDao;
import com.easyaccomod.dao.ITypeDao;
import com.easyaccomod.model.AddressModel;
import com.easyaccomod.model.RoomModel;
import com.easyaccomod.model.RoomTypeModel;
import com.easyaccomod.service.IRoomService;

public class RoomService implements IRoomService {

	@Inject
	private IRoomDao roomDao;
	
	@Inject
	private ITypeDao typeDao;
	
	@Inject
	private IAddressDao addrDao;
	
	@Override
	public List<RoomModel> findByType(Long typeId) {
		return roomDao.findByType(typeId);
	}

	@Override
	public RoomModel save(RoomModel roomModel) {
		roomModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long roomId = roomDao.save(roomModel);
		return roomDao.findOne(roomId);
	}

	@Override
	public RoomModel update(RoomModel updateRoom) {
		RoomModel oldRoom = roomDao.findOne(updateRoom.getId());
		updateRoom.setCreatedDate(oldRoom.getCreatedDate());
		updateRoom.setCreatedBy(oldRoom.getCreatedBy());
		updateRoom.setModifiedDate(new Timestamp(System.currentTimeMillis()));
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

	@Override
	public RoomModel findOne(Long id) {
		RoomModel roomModel = roomDao.findOne(id);
		RoomTypeModel typeModel = typeDao.findOne(roomModel.getTypeId());
		roomModel.setRoomType(typeModel.getType());
		AddressModel addrModel = addrDao.findOne(roomModel.getAddressId());
		roomModel.setAddrDistrict(addrModel.getDistrict());
		roomModel.setAddrStreet(addrModel.getStreet());
		roomModel.setAddrCity(addrModel.getCity());
		return roomModel;
	}
	
}
