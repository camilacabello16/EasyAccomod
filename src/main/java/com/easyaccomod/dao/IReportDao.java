package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.ReportModel;
import com.easyaccomod.model.RoomModel;

public interface IReportDao extends GenericDao<ReportModel> {
	List<ReportModel> findAll();
	ReportModel findOne(Long id);
	Long save(ReportModel reportModel);
	void delete(Long id);
	List<RoomModel> findRoomName();
}
