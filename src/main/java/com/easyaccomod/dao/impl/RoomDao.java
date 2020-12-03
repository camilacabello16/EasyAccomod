package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.IRoomDao;
import com.easyaccomod.mapper.RoomMapper;
import com.easyaccomod.model.RoomModel;

public class RoomDao extends AbstractDao<RoomModel> implements IRoomDao {

	@Override
	public List<RoomModel> findByType(Long typeId) {
		String sql = "SELECT * FROM room WHERE typeid = ?";
		return query(sql, new RoomMapper(), typeId);
	}

	@Override
	public Long save(RoomModel roomModel) {
		String sql = "INSERT INTO room (addressid, description, price, area, typeid, numberofroom, owner, bathroom, kitchen, aircondition, bacony, image, createddate, createdby, rating, seen, phone) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, roomModel.getAddressId(), roomModel.getDescription(), roomModel.getPrice(),
				roomModel.getArea(), roomModel.getTypeId(), roomModel.getNumberOfRoom(), roomModel.getOwner(),
				roomModel.getBathroom(), roomModel.getKitchen(), roomModel.getAircondition(), roomModel.getBacony(),
				roomModel.getImage(), roomModel.getCreatedDate(), roomModel.getCreatedBy(), roomModel.getRating(),
				roomModel.getSeen(), roomModel.getPhone());
	}

	@Override
	public RoomModel findOne(Long id) {
		String sql = "SELECT * FROM room WHERE id = ?";
		List<RoomModel> rooms = query(sql, new RoomMapper(), id);
		return rooms.isEmpty() ? null : rooms.get(0);
	}

	@Override
	public void update(RoomModel updateRoom) {
		String sql = "UPDATE room SET addressid=?, description=?, price=?, area=?, typeid=?, numberofroom=?, owner=?, bathroom=?, kitchen=?, aircondition=?, bacony=?, image=?, rating=?, seen=?, phone=?, createddate=?, createdby=?, modifieddate=?, modifiedby=? WHERE id=?";
		update(sql, updateRoom.getAddressId(), updateRoom.getDescription(), updateRoom.getPrice(), updateRoom.getArea(),
				updateRoom.getTypeId(), updateRoom.getNumberOfRoom(), updateRoom.getOwner(), updateRoom.getBathroom(),
				updateRoom.getKitchen(), updateRoom.getAircondition(), updateRoom.getBacony(), updateRoom.getImage(),
				updateRoom.getRating(), updateRoom.getSeen(), updateRoom.getPhone(), updateRoom.getCreatedDate(),
				updateRoom.getCreatedBy(), updateRoom.getModifiedDate(), updateRoom.getModifiedBy(),
				updateRoom.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM room WHERE id = ?";
		update(sql, id);
	}

}
