package com.kh.marchpring.board.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.marchpring.board.domain.Board;
import com.kh.marchpring.board.service.BoardService;
import com.kh.marchpring.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardStore bStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertBoard(Board board) {
		int result = bStore.insertBoard(session, board);
		return result;
	}

	@Override
	public List<Board> selectAllBoard() {
		List<Board> bList = bStore.selectAllBoard(session);
		return bList;
	}

	@Override
	public Board selectOneBoard(Integer boardNo) {
		Board board = bStore.selectOneBoard(session, boardNo);
		return board;
	}

}
