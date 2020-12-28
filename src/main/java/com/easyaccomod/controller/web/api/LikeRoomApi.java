package com.easyaccomod.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.LikeRoomModel;
import com.easyaccomod.service.ILikeRoomService;
import com.easyaccomod.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-like-room"})
public class LikeRoomApi extends HttpServlet {

	private static final long serialVersionUID = 3245782888404407055L;
	
	@Inject
	private ILikeRoomService likeRoomService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		LikeRoomModel likeRoomModel = HttpUtil.of(req.getReader()).toModel(LikeRoomModel.class);
		likeRoomModel = likeRoomService.save(likeRoomModel);
		mapper.writeValue(resp.getOutputStream(), likeRoomModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		LikeRoomModel likeRoomModel = HttpUtil.of(req.getReader()).toModel(LikeRoomModel.class);
		likeRoomService.delete(likeRoomModel.getId());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
