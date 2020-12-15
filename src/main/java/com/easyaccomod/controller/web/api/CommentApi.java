package com.easyaccomod.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.CommentModel;
import com.easyaccomod.model.UserModel;
import com.easyaccomod.service.ICommentService;
import com.easyaccomod.utils.HttpUtil;
import com.easyaccomod.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-web-comment"})
public class CommentApi extends HttpServlet {

	private static final long serialVersionUID = -9154452985913877050L;
	
	@Inject
	private ICommentService commentService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel cmtModel = HttpUtil.of(req.getReader()).toModel(CommentModel.class);
		cmtModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());
		//cmtModel.setCreatedBy("test");
		cmtModel = commentService.save(cmtModel);
		mapper.writeValue(resp.getOutputStream(), cmtModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel cmtModel = HttpUtil.of(req.getReader()).toModel(CommentModel.class);
		cmtModel.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());
		cmtModel = commentService.update(cmtModel);
		mapper.writeValue(resp.getOutputStream(), cmtModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CommentModel cmtModel = HttpUtil.of(req.getReader()).toModel(CommentModel.class);
		commentService.delete(cmtModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
