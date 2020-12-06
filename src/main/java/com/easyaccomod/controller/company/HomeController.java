package com.easyaccomod.controller.company;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.RoomModel;
import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.IRoomService;
import com.easyaccomod.service.IUserService;

@WebServlet(urlPatterns = {"/company-home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4965199485492466775L;

	@Inject
	private IRoomService roomSevice;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoomModel roomModel = new RoomModel();
		roomModel.setListResult(roomSevice.findAll());
		req.setAttribute("rooms", roomModel);
		
		UserModel userModel = new UserModel();
		userModel.setListResult(userService.findAll());
		req.setAttribute("users", userModel);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/company/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
