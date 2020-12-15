package com.easyaccomod.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.easyaccomod.dao.ICommentDao;
import com.easyaccomod.model.CommentModel;
import com.easyaccomod.service.ICommentService;

public class CommentService implements ICommentService {

	@Inject
	private ICommentDao commentDao;
	
	@Override
	public CommentModel save(CommentModel commentModel) {
		commentModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long roomId = commentDao.save(commentModel);
		return commentDao.findOne(roomId);
	}

	@Override
	public CommentModel update(CommentModel commentModel) {
		CommentModel oldRoom = commentDao.findOne(commentModel.getId());
		commentModel.setCreatedDate(oldRoom.getCreatedDate());
		commentModel.setCreatedBy(oldRoom.getCreatedBy());
		commentModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		commentDao.update(commentModel);
		return commentDao.findOne(commentModel.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			commentDao.delete(id);
		}
	}

	@Override
	public List<CommentModel> findByRoomId(Long roomId) {
		return commentDao.findByRoomId(roomId);
	}

}
