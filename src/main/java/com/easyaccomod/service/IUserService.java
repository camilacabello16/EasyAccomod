package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.UserModel;

public interface IUserService {
	List<UserModel> findAll();
}
