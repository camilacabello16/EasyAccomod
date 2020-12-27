package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.IReportDao;
import com.easyaccomod.mapper.ReportMapper;
import com.easyaccomod.mapper.RoomMapper;
import com.easyaccomod.model.ReportModel;
import com.easyaccomod.model.RoomModel;

public class ReportDao extends AbstractDao<ReportModel> implements IReportDao {

	@Override
	public List<ReportModel> findAll() {
		String sql = "SELECT * FROM report";
		return query(sql, new ReportMapper());
	}

	@Override
	public ReportModel findOne(Long id) {
		String sql = "SELECT * FROM report WHERE id=?";
		List<ReportModel> reportModel = query(sql, new ReportMapper(), id);
		return reportModel.isEmpty() ? null : reportModel.get(0);
	}

	@Override
	public Long save(ReportModel reportModel) {
		String sql = "INSERT INTO report (content, roomid) VALUES(?,?)";
		return insert(sql, reportModel.getContent(), reportModel.getRoomId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM report WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<RoomModel> findRoomName() {
		String sql = "SELECT room.* FROM room JOIN report ON room.id = report.roomid";
		return query(sql, new RoomMapper());
	}

}
