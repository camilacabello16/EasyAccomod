package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.ITypeDao;
import com.easyaccomod.mapper.TypeMapper;
import com.easyaccomod.model.RoomTypeModel;

public class TypeDao extends AbstractDao<RoomTypeModel> implements ITypeDao {

	@Override
	public List<RoomTypeModel> findAll() {
		String sql = "SELECT * FROM room_type";
		return query(sql, new TypeMapper());
	}

	@Override
	public RoomTypeModel findOne(long id) {
		String sql = "SELECT * FROM room_type WHERE id=?";
		List<RoomTypeModel> type = query(sql, new TypeMapper(), id);
		return type.isEmpty() ? null : type.get(0);
	}

}
