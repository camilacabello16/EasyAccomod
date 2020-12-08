package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.RoleModel;
import com.easyaccomod.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setId(resultSet.getLong("id"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setPhone(resultSet.getString("phone"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setUserName(resultSet.getString("username"));
			try {
				RoleModel role = new RoleModel();
				role.setRoleCode(resultSet.getString("rolecode"));
				role.setRoleName(resultSet.getString("rolename"));
				user.setRole(role);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
