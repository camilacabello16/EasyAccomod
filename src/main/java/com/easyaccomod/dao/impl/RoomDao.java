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
		String sql = "INSERT INTO room (addressid, description, price, area, typeid, numberofroom, owner, bathroom, kitchen, aircondition, bacony, image, createddate, createdby, rating, seen, phone, status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, roomModel.getAddressId(), roomModel.getDescription(), roomModel.getPrice(),
				roomModel.getArea(), roomModel.getTypeId(), roomModel.getNumberOfRoom(), roomModel.getOwner(),
				roomModel.getBathroom(), roomModel.getKitchen(), roomModel.getAircondition(), roomModel.getBacony(),
				roomModel.getImage(), roomModel.getCreatedDate(), roomModel.getCreatedBy(), roomModel.getRating(),
				roomModel.getSeen(), roomModel.getPhone(), roomModel.getStatus());
	}

	@Override
	public RoomModel findOne(Long id) {
		String sql = "SELECT * FROM room WHERE id = ?";
		List<RoomModel> rooms = query(sql, new RoomMapper(), id);
		return rooms.isEmpty() ? null : rooms.get(0);
	}

	@Override
	public void update(RoomModel updateRoom) {
		String sql = "UPDATE room SET addressid=?, description=?, price=?, area=?, typeid=?, numberofroom=?, owner=?, bathroom=?, kitchen=?, aircondition=?, bacony=?, image=?, rating=?, seen=?, phone=?, status=?, createddate=?, createdby=?, modifieddate=?, modifiedby=? WHERE id=?";
		update(sql, updateRoom.getAddressId(), updateRoom.getDescription(), updateRoom.getPrice(), updateRoom.getArea(),
				updateRoom.getTypeId(), updateRoom.getNumberOfRoom(), updateRoom.getOwner(), updateRoom.getBathroom(),
				updateRoom.getKitchen(), updateRoom.getAircondition(), updateRoom.getBacony(), updateRoom.getImage(),
				updateRoom.getRating(), updateRoom.getSeen(), updateRoom.getPhone(), updateRoom.getStatus(),
				updateRoom.getCreatedDate(), updateRoom.getCreatedBy(), updateRoom.getModifiedDate(),
				updateRoom.getModifiedBy(), updateRoom.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM room WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<RoomModel> findAll() {
		String sql = "SELECT * FROM room";
		return query(sql, new RoomMapper());
	}

	@Override
	public void updateSeen(Long id) {
		String sql = "UPDATE room SET seen = seen + 1 WHERE id = ?";
		update(sql, id);
	}

	@Override
	public void updateRating(int rating, Long id) {
		String sql = "UPDATE room SET rating = (rating+?)/2 WHERE id = ?";
		update(sql, rating, id);
	}

	@Override
	public List<RoomModel> searchRoom(Long roomType, String addrStreet, int price, int area) {
		String sql = "SELECT * FROM room JOIN address ON room.addressid = address.id WHERE room.typeid=? AND address.street LIKE CONCAT('%',?,'%') AND room.price>=? AND room.price<=? AND room.area>=? AND room.area<=?";
		return query(sql, new RoomMapper(), roomType, addrStreet, price-1, price, area-10, area);
	}

	@Override
	public List<RoomModel> findBySeen() {
		String sql = "SELECT * FROM room ORDER BY seen desc limit 5";
		return query(sql, new RoomMapper());
	}

}
