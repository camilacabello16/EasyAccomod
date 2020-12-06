package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.IUserDao;
import com.easyaccomod.mapper.UserMapper;
import com.easyaccomod.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

}
