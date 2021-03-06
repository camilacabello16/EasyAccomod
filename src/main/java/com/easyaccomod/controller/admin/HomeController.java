package com.easyaccomod.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.ReportModel;
import com.easyaccomod.model.RoomModel;
import com.easyaccomod.service.IAddressService;
import com.easyaccomod.service.ICityService;
import com.easyaccomod.service.IDistrictService;
import com.easyaccomod.service.IReportService;
import com.easyaccomod.service.IRoomService;
import com.easyaccomod.service.ITypeService;
import com.easyaccomod.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4965199485492466775L;
	
	@Inject
	private IRoomService roomService;
	
	@Inject
	private ITypeService typeService;
	
	@Inject
	private IAddressService addrService;
	
	@Inject
	private ICityService cityService;
	
	@Inject
	private IReportService reportService;
	
	@Inject
	private IDistrictService districtService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoomModel roomModel = FormUtil.toModel(RoomModel.class, req);
		ReportModel reportModel = new ReportModel();
		String type = req.getParameter("type");
		String view = "";
		if(type != null && type.equals("edit")) {
			if(roomModel.getId() != null) {
				roomModel = roomService.findOne(roomModel.getId());
			} else {
				
			}
			req.setAttribute("types", typeService.findAll());
			req.setAttribute("addr", addrService.findAll());
			req.setAttribute("cities", cityService.findAll());
			req.setAttribute("districts", districtService.findAll());
			view = "/views/edit.jsp";
		} else if(type == null) {
			roomModel.setListResult(roomService.findAll());
			roomModel.setListRoom(roomService.findBySeen());
			
			reportModel.setListResult(reportService.findAll());
			req.setAttribute("reports", reportModel);
			
			int reportSize = reportModel.getListResult().size();
			req.setAttribute("numberReport", reportSize);
			
			view = "/views/admin/home.jsp";
		}

		req.setAttribute("rooms", roomModel);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
