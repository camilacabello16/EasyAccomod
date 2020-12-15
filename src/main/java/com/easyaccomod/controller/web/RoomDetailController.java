package com.easyaccomod.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.CommentModel;
import com.easyaccomod.service.ICommentService;
import com.easyaccomod.service.IRoomService;

@WebServlet(urlPatterns = {"/chi-tiet-phong"})
public class RoomDetailController extends HttpServlet {

	private static final long serialVersionUID = -8934735974107237982L;
	
	@Inject
	private IRoomService roomService;
	
	@Inject
	private ICommentService commentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		Long roomId;
		roomId = Long.parseLong(idStr);
		
		req.setAttribute("room", roomService.findOne(roomId));
		
		CommentModel commentModel = new CommentModel();
		commentModel.setListResult(commentService.findByRoomId(roomId));
		req.setAttribute("comments", commentModel);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/room.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
