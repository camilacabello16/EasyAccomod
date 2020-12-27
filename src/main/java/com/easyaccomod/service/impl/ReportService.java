package com.easyaccomod.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.IReportDao;
import com.easyaccomod.model.ReportModel;
import com.easyaccomod.service.IReportService;

public class ReportService implements IReportService {

	@Inject
	private IReportDao reportDao;
	
	@Override
	public List<ReportModel> findAll() {
		return reportDao.findAll();
	}

	@Override
	public ReportModel save(ReportModel reportModel) {
		Long reportId = reportDao.save(reportModel);
		return reportDao.findOne(reportId);
	}

	@Override
	public void delete(Long id) {
		reportDao.delete(id);
	}

}
