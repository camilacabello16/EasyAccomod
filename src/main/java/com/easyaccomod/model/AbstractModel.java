package com.easyaccomod.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();

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
}
