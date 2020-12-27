package com.easyaccomod.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyaccomod.model.ReportModel;

public class ReportMapper implements RowMapper<ReportModel> {

	@Override
	public ReportModel mapRow(ResultSet resultSet) {
		ReportModel report = new ReportModel();
		try {
			report.setId(resultSet.getLong("id"));
			report.setContent(resultSet.getString("content"));
			report.setRoomId(resultSet.getLong("roomid"));
			return report;
		}catch(SQLException e) {
			return null;
		}
	}

}
