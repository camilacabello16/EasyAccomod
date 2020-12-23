package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.UserModel;

public interface IUserDao extends GenericDao<UserModel> {
	List<UserModel> findAll();
	UserModel findByUserNameAndPassword(String userName, String password);
	Long save(UserModel userModel);
	void update(UserModel userModel);
	void delete(long id);
	UserModel findOne(Long id);
	List<UserModel> findAdmin();
}
