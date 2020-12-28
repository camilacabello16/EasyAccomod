package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.ILikeRoomDao;
import com.easyaccomod.mapper.LikeRoomMapper;
import com.easyaccomod.model.LikeRoomModel;

public class LikeRoomDao extends AbstractDao<LikeRoomModel> implements ILikeRoomDao {

	@Override
	public LikeRoomModel findOne(Long id) {
		String sql = "SELECT * FROM like_room WHERE id = ?";
		List<LikeRoomModel> likeRooms = query(sql, new LikeRoomMapper(), id);
		return likeRooms.isEmpty() ? null : likeRooms.get(0);
	}

	@Override
	public Long save(LikeRoomModel likeRoomModel) {
		String sql = "INSERT INTO like_room (userid, roomid) VALUES(?,?)";
		return insert(sql, likeRoomModel.getUserId(), likeRoomModel.getRoomId());
	}

	@Override
	public List<LikeRoomModel> findByUserId(Long userId) {
		String sql = "SELECT * FROM like_room WHERE userid = ?";
		return query(sql, new LikeRoomMapper(), userId);
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM like_room WHERE id = ?";
		update(sql, id);
	}

}
