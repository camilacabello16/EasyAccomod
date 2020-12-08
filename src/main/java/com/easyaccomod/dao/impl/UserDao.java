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

	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {
		String sql = "SELECT * FROM user INNER JOIN role ON role.id = user.roleid  WHERE username=? AND password = ?";
		List<UserModel> users = query(sql, new UserMapper(), userName, password);
		return users.isEmpty() ? null : users.get(0);
	}

}
