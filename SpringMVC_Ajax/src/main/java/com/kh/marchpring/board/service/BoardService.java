package com.kh.marchpring.board.service;

import java.util.List;

import com.kh.marchpring.board.domain.Board;
import com.kh.marchpring.board.domain.Reply;

public interface BoardService {

	/**
	 * 게시글 등록 service
	 * @param board
	 * @return int
	 */
	public int insertBoard(Board board);

	/**
	 * 게시글 목록 조회 service
	 * @return List
	 */
	public List<Board> selectAllBoard();

	/**
	 * 게시물 하나 선택 service
	 * @param boardNo
	 * @return Board
	 */
	public Board selectOneBoard(Integer boardNo);

	/**
	 * 댓글 작성
	 * @param reply
	 * @return int
	 */
	public int insertReply(Reply reply);

	/**
	 * 댓글 목록 조회
	 * @param boardNo
	 * @return List
	 */
	public List<Reply> selectAllReply(Integer boardNo);

}
