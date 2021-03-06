package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.RoomTypeModel;

public interface ITypeDao extends GenericDao<RoomTypeModel> {
	List<RoomTypeModel> findAll();
	RoomTypeModel findOne(long id);
	RoomTypeModel findOneByType(String type);
}
