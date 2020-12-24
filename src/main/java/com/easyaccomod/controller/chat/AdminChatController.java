package com.easyaccomod.controller.chat;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.ChatModel;
import com.easyaccomod.service.IChatService;

@WebServlet(urlPatterns = {"/admin-chat"})
public class AdminChatController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IChatService chatService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		Long adminId = Long.parseLong(idStr);
		ChatModel chatModel = new ChatModel();
		chatModel.setListResult(chatService.findByAdminId(adminId));
		req.setAttribute("chats", chatModel);
		RequestDispatcher rd = req.getRequestDispatcher("/views/adminchat.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
