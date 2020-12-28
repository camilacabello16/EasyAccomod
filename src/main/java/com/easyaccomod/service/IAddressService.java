package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.AddressModel;

public interface IAddressService {
	List<AddressModel> findAll();
	List<AddressModel> findDistrict();
}
