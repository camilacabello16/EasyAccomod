package com.easyaccomod.dao.impl;

import java.util.List;

import com.easyaccomod.dao.ICommentDao;
import com.easyaccomod.mapper.CommentMapper;
import com.easyaccomod.model.CommentModel;

public class CommentDao extends AbstractDao<CommentModel> implements ICommentDao {

	@Override
	public Long save(CommentModel commentModel) {
		String sql = "INSERT INTO comment (userid, roomid, content, createddate, createdby) VALUES(?,?,?,?,?)";
		return insert(sql, commentModel.getUserId(), commentModel.getRoomId(), commentModel.getContent(),
				commentModel.getCreatedDate(), commentModel.getCreatedBy());
	}

	@Override
	public void update(CommentModel commentModel) {
		String sql = "UPDATE comment SET userid=?, roomid=?, content=?, createddate=?, createdby=?, modifieddate=?, modifiedby=? WHERE id=?";
		update(sql, commentModel.getUserId(), commentModel.getRoomId(), commentModel.getContent(),
				commentModel.getCreatedDate(), commentModel.getCreatedBy(), commentModel.getModifiedDate(),
				commentModel.getModifiedBy(), commentModel.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM comment WHERE id = ?";
		update(sql, id);
	}

	@Override
	public CommentModel findOne(Long id) {
		String sql = "SELECT * FROM comment WHERE id=?";
		List<CommentModel> comments = query(sql, new CommentMapper(), id);
		return comments.isEmpty() ? null : comments.get(0);
	}

	@Override
	public List<CommentModel> findByRoomId(Long roomId) {
		String sql = "SELECT * FROM comment WHERE roomid=?";
		return query(sql, new CommentMapper(), roomId);
	}

}
