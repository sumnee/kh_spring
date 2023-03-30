package com.kh.marchpring.board.store.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.marchpring.board.domain.Board;
import com.kh.marchpring.board.domain.Reply;
import com.kh.marchpring.board.store.BoardStore;

@Repository
public class BoardStoreImpl implements BoardStore{

	@Override //게시글 작성
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override //게시글 목록 조회
	public List<Board> selectAllBoard(SqlSession session) {
		List<Board> bList = session.selectList("BoardMapper.selectBoardList");
		return bList;
	}

	@Override //게시글 하나 조회
	public Board selectOneBoard(SqlSession session, Integer boardNo) {
		Board board = session.selectOne("BoardMapper.selectOneBoard", boardNo);
		return board;
	}

	@Override //댓글 등록
	public int insertReply(SqlSession session, Reply reply) {
		int result = session.insert("BoardMapper.insertReply", reply);
		return result;
	}

	@Override //댓글 목록 조회
	public List<Reply> selectAllReply(SqlSession session, Integer boardNo) {
		List<Reply> rList = session.selectList("BoardMapper.selectReplyList", boardNo);
		return rList;
	}

}
