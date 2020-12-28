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
import com.easyaccomod.model.DistrictModel;
import com.easyaccomod.model.RoomModel;
import com.easyaccomod.model.RoomTypeModel;
import com.easyaccomod.service.IAddressService;
import com.easyaccomod.service.ICityService;
import com.easyaccomod.service.IDistrictService;
import com.easyaccomod.service.IRoomService;
import com.easyaccomod.service.ITypeService;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 7350170045761730163L;
	
	@Inject
    private IRoomService roomService;
	
	@Inject
	private ITypeService typeService;
	
	@Inject
	private IAddressService addrService;
	
	@Inject
	private ICityService cityService;
	
	@Inject
	private IDistrictService districtService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String street = req.getParameter("street");
		String price = req.getParameter("price");
		String area = req.getParameter("area");
		RoomModel roomModel = new RoomModel();
		if(type.equals("Phòng trọ")) {
			roomModel.setSearchType(1L);
		} else if(type.equals("Chung cư mini")) {
			roomModel.setSearchType(2L);
		} else if(type.equals("Nhà nguyên căn")) {
			roomModel.setSearchType(3L);
		} else if(type.equals("Chung cư nguyên căn")) {
			roomModel.setSearchType(4L);
		}
		System.out.println(street);
		roomModel.setSearchStreet(street);
		int searchPrice = Integer.parseInt(price);
		int searchArea = Integer.parseInt(area);
		roomModel.setSearchArea(searchArea);
		roomModel.setSearchPrice(searchPrice);
		roomModel.setListResult(roomService.searchRoom(roomModel.getSearchType(), roomModel.getSearchStreet(), roomModel.getSearchPrice(), roomModel.getSearchArea()));
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
		
		DistrictModel districtModel = new DistrictModel();
		districtModel.setListResult(districtService.findAll());
		req.setAttribute("districts", districtModel);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/search.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
