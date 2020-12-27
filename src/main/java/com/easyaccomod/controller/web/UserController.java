package com.easyaccomod.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.service.IUserService;

@WebServlet(urlPatterns = {"/thong-tin-nguoi-dung"})
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 5777501016990554079L;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter("id");
		Long userId = Long.parseLong(userIdStr);
		
		req.setAttribute("user", userService.findOne(userId));
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/profile.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
