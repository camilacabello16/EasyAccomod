package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IUserDao;
import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDao userDao;
	
	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}

	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {
		return userDao.findByUserNameAndPassword(userName, password);
	}

	@Override
	public UserModel save(UserModel userModel) {
		Long userId = userDao.save(userModel);
		return userDao.findOne(userId);
	}

	@Override
	public UserModel update(UserModel userModel) {
		userDao.update(userModel);
		return userDao.findOne(userModel.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			userDao.delete(id);
		}
	}

	@Override
	public List<UserModel> findAdmin() {
		return userDao.findAdmin();
	}



}
