package com.easyaccomod.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.mapper.UserMapper;
import com.easyaccomod.model.RoomModel;
import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.IRoomService;
import com.easyaccomod.utils.HttpUtil;
import com.easyaccomod.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-room"})
public class RoomApi extends HttpServlet {

	private static final long serialVersionUID = -6251591877578709052L;
	
	@Inject
	private IRoomService roomService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		RoomModel roomModel = HttpUtil.of(req.getReader()).toModel(RoomModel.class);
		roomModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());
		roomModel = roomService.save(roomModel);
		mapper.writeValue(resp.getOutputStream(), roomModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		RoomModel updateRoom = HttpUtil.of(req.getReader()).toModel(RoomModel.class);
		updateRoom.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());
		updateRoom = roomService.update(updateRoom);
		mapper.writeValue(resp.getOutputStream(), updateRoom);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		RoomModel roomModel = HttpUtil.of(req.getReader()).toModel(RoomModel.class);
		roomService.delete(roomModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
