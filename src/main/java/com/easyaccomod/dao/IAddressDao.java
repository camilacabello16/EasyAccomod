package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.AddressModel;

public interface IAddressDao extends GenericDao<AddressModel> {
	List<AddressModel> findAll();
	AddressModel findOne(long id);
	AddressModel findOneByDistrictAndStreet(String district, String street);
	AddressModel findOneByStreet(String street);
}
