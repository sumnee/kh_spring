package com.kh.marchpring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.marchpring.board.domain.Board;
import com.kh.marchpring.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping(value = "/board/register", method=RequestMethod.GET)
	public ModelAndView showBoardRegister(ModelAndView mv) {
		mv.setViewName("board/register");
		return mv;
	}
	
	@RequestMapping(value = "/board/register", method=RequestMethod.POST)
	public ModelAndView doBoardInsert(
			ModelAndView mv
			, @ModelAttribute Board board) {
		try {
			int result = bService.insertBoard(board);
			mv.setViewName("redirect:/board/list");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/error");
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public ModelAndView viewBoardList(ModelAndView mv) {
		try {
			List<Board> bList = bService.selectAllBoard();
			mv.addObject("bList", bList).setViewName("board/list");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/error");
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/board/detail/{boardNo}", method=RequestMethod.GET)
	public ModelAndView viewBoardDetail(
			ModelAndView mv
			, @PathVariable Integer boardNo) {
		try {
			Board board = bService.selectOneBoard(boardNo);
			mv.addObject("board", board).setViewName("board/detail");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/error");
			e.printStackTrace();
		}
		return mv;
	}
	
	
	


}
