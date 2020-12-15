package com.easyaccomod.service;

import java.util.List;

import com.easyaccomod.model.CommentModel;

public interface ICommentService {
	CommentModel save(CommentModel commentModel);
	CommentModel update(CommentModel commentModel);
	void delete(long[] ids);
	List<CommentModel> findByRoomId(Long roomId);
}
