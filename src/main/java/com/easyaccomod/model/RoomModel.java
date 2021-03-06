package com.easyaccomod.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RoomModel extends AbstractModel<RoomModel> {
	private Long addressId;
	private String description;
	private String price;
	private int area;
	private Long typeId;
	private int numberOfRoom;
	private String owner;
	private String bathroom;
	private String kitchen;
	private String aircondition;
	private String bacony;
	private String image;
	private int rating;
	private Long seen;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private String phone;
	private int status;
	private String roomType;
	private String addrDistrict;
	private String addrStreet;
	private String addrCity;
	private List<RoomModel> listRoom = new ArrayList<>();
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public int getNumberOfRoom() {
		return numberOfRoom;
	}
	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getBathroom() {
		return bathroom;
	}
	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}
	public String getKitchen() {
		return kitchen;
	}
	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}
	public String getAircondition() {
		return aircondition;
	}
	public void setAircondition(String aircondition) {
		this.aircondition = aircondition;
	}
	public String getBacony() {
		return bacony;
	}
	public void setBacony(String bacony) {
		this.bacony = bacony;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Long getSeen() {
		return seen;
	}
	public void setSeen(Long seen) {
		this.seen = seen;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddrDistrict() {
		return addrDistrict;
	}
	public void setAddrDistrict(String addrDistrict) {
		this.addrDistrict = addrDistrict;
	}
	public String getAddrStreet() {
		return addrStreet;
	}
	public void setAddrStreet(String addrStreet) {
		this.addrStreet = addrStreet;
	}
	public String getAddrCity() {
		return addrCity;
	}
	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}
	public List<RoomModel> getListRoom() {
		return listRoom;
	}
	public void setListRoom(List<RoomModel> listRoom) {
		this.listRoom = listRoom;
	}

	
}
