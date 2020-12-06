package com.easyaccomod.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.RoomModel;
import com.easyaccomod.service.IRoomService;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4965199485492466775L;
	
	@Inject
	private IRoomService roomService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoomModel roomModel = new RoomModel();
		roomModel.setListResult(roomService.findAll());
		req.setAttribute("rooms", roomModel);
	
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
