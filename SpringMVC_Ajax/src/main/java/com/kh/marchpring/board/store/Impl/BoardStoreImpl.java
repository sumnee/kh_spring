package com.kh.marchpring.board.store.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.marchpring.board.domain.Board;
import com.kh.marchpring.board.store.BoardStore;

@Repository
public class BoardStoreImpl implements BoardStore{

	@Override
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override
	public List<Board> selectAllBoard(SqlSession session) {
		List<Board> bList = session.selectList("BoardMapper.selectBoardList");
		return bList;
	}

	@Override
	public Board selectOneBoard(SqlSession session, Integer boardNo) {
		Board board = session.selectOne("BoardMapper.selectOneBoard", boardNo);
		return board;
	}

}
