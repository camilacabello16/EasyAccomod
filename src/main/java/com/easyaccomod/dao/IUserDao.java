package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.UserModel;

public interface IUserDao extends GenericDao<UserModel> {
	List<UserModel> findAll();
	UserModel findByUserNameAndPassword(String userName, String password);
}
