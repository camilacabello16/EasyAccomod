package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.ReportModel;

public interface IReportService {
	List<ReportModel> findAll();
	ReportModel save(ReportModel reportModel);
	void delete(Long id);
}
