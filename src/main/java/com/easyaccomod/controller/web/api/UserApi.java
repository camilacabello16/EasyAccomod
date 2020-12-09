package com.easyaccomod.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.IUserService;
import com.easyaccomod.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-web-user"})
public class UserApi extends HttpServlet {

	private static final long serialVersionUID = -5789884390386117009L;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userModel = userService.save(userModel);
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userModel = userService.update(userModel);
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userService.delete(userModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	
}
