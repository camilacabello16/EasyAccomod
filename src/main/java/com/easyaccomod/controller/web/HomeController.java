package com.easyaccomod.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.AddressModel;
import com.easyaccomod.model.CityModel;
import com.easyaccomod.model.RoomModel;
import com.easyaccomod.model.RoomTypeModel;
import com.easyaccomod.service.IAddressService;
import com.easyaccomod.service.ICityService;
import com.easyaccomod.service.IRoomService;
import com.easyaccomod.service.ITypeService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4965199485492466775L;
	
	@Inject
	private IRoomService roomService;
	
	@Inject
	private ITypeService typeService;
	
	@Inject
	private ICityService cityService;
	
	@Inject
	private IAddressService addrService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get room
		RoomModel roomModel = new RoomModel();
		roomModel.setListResult(roomService.findAll());
		req.setAttribute("rooms", roomModel);
		
		//get type
		RoomTypeModel typeModel = new RoomTypeModel();
		typeModel.setListResult(typeService.findAll());
		req.setAttribute("types", typeModel);
		
		//get city
		CityModel cityModel = new CityModel();
		cityModel.setListResult(cityService.findAll());
		req.setAttribute("cities", cityModel);
		
		//get district
		AddressModel addrModel = new AddressModel();
		addrModel.setListResult(addrService.findAll());
		req.setAttribute("locations", addrModel);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
