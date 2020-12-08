package com.easyaccomod.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

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
import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.IAddressService;
import com.easyaccomod.service.ICityService;
import com.easyaccomod.service.IRoomService;
import com.easyaccomod.service.ITypeService;
import com.easyaccomod.service.IUserService;
import com.easyaccomod.utils.FormUtil;
import com.easyaccomod.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
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
	
	@Inject
	private IUserService userService;
	
	ResourceBundle bundle = ResourceBundle.getBundle("message");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			String message = req.getParameter("message");
			if(message!=null) {
				req.setAttribute("message", bundle.getString(message));
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		} else {
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
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel user = FormUtil.toModel(UserModel.class, req);
			user = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
			if(user != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", user);;
				if(user.getRole().getRoleCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				} else if(user.getRole().getRoleCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}else if(user.getRole().getRoleCode().equals("COMPANY")) {
					resp.sendRedirect(req.getContextPath() + "/company-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=msg_invalid");
			}
		}
	}
}
