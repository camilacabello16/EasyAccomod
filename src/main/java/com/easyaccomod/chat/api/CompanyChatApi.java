package com.easyaccomod.chat.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.ChatModel;
import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.IChatService;
import com.easyaccomod.utils.HttpUtil;
import com.easyaccomod.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-com-chat"})
public class CompanyChatApi extends HttpServlet {

	private static final long serialVersionUID = -4743225027658645536L;
	
	@Inject
	private IChatService chatService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ChatModel chatModel = HttpUtil.of(req.getReader()).toModel(ChatModel.class);
		chatModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());
		chatModel = chatService.save(chatModel);
		mapper.writeValue(resp.getOutputStream(), chatModel);
	}

}
