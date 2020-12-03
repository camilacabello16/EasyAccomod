package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.mapper.RowMapper;

public interface GenericDao<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	//delete, update
	void update(String sql, Object... parameters);
	//add
	Long insert(String sql, Object... parameters);
}
