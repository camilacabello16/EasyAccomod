package com.easyaccomod.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();
	private Long searchType;
	private String searchStreet;
	private int searchPrice;
	private int searchArea;


	public String getSearchStreet() {
		return searchStreet;
	}

	public void setSearchStreet(String searchStreet) {
		this.searchStreet = searchStreet;
	}

	public int getSearchPrice() {
		return searchPrice;
	}

	public void setSearchPrice(int searchPrice) {
		this.searchPrice = searchPrice;
	}

	public int getSearchArea() {
		return searchArea;
	}

	public void setSearchArea(int searchArea) {
		this.searchArea = searchArea;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public Long getSearchType() {
		return searchType;
	}

	public void setSearchType(Long searchType) {
		this.searchType = searchType;
	}
}
