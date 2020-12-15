package com.easyaccomod.dao;

import java.util.List;

import com.easyaccomod.model.CommentModel;

public interface ICommentDao {
	Long save(CommentModel commentModel);
	void update(CommentModel commentModel);
	void delete(long id);
	
	CommentModel findOne(Long id);
	List<CommentModel> findByRoomId(Long roomId);
}
