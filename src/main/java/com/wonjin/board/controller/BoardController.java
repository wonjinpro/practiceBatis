package com.wonjin.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wonjin.board.service.BoardService;
import com.wonjin.board.vo.Board;
import com.wonjin.board.vo.pagination;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping(value = "boardList.com")
	public String boardList(int reqPage, Model model) {

		pagination list = service.getBoardList(reqPage);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageNavi", list.getPagination());
		return "board/boardList";
	}

	@RequestMapping(value = "boardViewFrm.com")
	public String boardViewFrm(int boardNo,Model model) {
		Board b = service.getOneBoard(boardNo);
			model.addAttribute("b",b);
		return "board/boardView";
	}
	@RequestMapping(value="updateBoard.com")
	public String boardUpdate(Board b) {
		int result = service.boardUpdate(b);
	
		return "redirect:boardViewFrm.com?boardNo="+b.getBoardNo();
		
	}
	@RequestMapping(value="deleteBoard.com")
	public String deleteBoard(int boardNo) {
		int result = service.deleteBoard(boardNo);
		if(result>0) {
			return "board/success";
		}else {
			return "board/fail";
		}
			
		
	}

}
