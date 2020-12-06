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

}
