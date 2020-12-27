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

	@Override
	public Long save(UserModel userModel) {
		String sql = "INSERT INTO user (roleid, username, password, fullname, phone) VALUES (?,?,?,?,?)";
		return insert(sql, 2, userModel.getUserName(), userModel.getPassword(),
				userModel.getFullName(), userModel.getPhone());
	}

	@Override
	public void update(UserModel userModel) {
		String sql = "UPDATE user SET roleid = ?, username=?, password=?, fullname=?, phone=? WHERE id=?";
		update(sql, userModel.getRoleId(), userModel.getUserName(), userModel.getPassword(),
				userModel.getFullName(), userModel.getPhone(), userModel.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM user WHERE id=?";
		update(sql, id);
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public List<UserModel> findAdmin() {
		String sql = "SELECT * FROM user WHERE roleid = 1";
		return query(sql, new UserMapper());
	}

}
