package com.easyaccomod.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.ReportModel;
import com.easyaccomod.service.IReportService;
import com.easyaccomod.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-report"})
public class ReportApi extends HttpServlet {

	private static final long serialVersionUID = 2727592066350351236L;
	
	@Inject
	private IReportService reportService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ReportModel reportModel = HttpUtil.of(req.getReader()).toModel(ReportModel.class);
		reportModel = reportService.save(reportModel);
		mapper.writeValue(resp.getOutputStream(), reportModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ReportModel reportModel = HttpUtil.of(req.getReader()).toModel(ReportModel.class);
		reportService.delete(reportModel.getId());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
