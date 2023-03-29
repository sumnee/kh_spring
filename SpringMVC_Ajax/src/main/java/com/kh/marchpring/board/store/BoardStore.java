package com.kh.marchpring.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.marchpring.board.domain.Board;

public interface BoardStore {

	public int insertBoard(SqlSession session, Board board);

	public List<Board> selectAllBoard(SqlSession session);

	public Board selectOneBoard(SqlSession session, Integer boardNo);

}
