package com.wonjin.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonjin.board.dao.BoardDao;
import com.wonjin.board.vo.Board;
import com.wonjin.board.vo.pagination;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public pagination getBoardList(int reqPage) {
		//페이지의 수를 구하는 법 
		//reqPage가 1일때 
		int Npp = 5;  //페이지당 개수 numPerPage 
		int end = reqPage * Npp; //마지막 숫자 
		int start = end-Npp+1; //첫번째 숫자
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		ArrayList<Board> list = dao.getBoardList(map);
		int totalPage=0;
		
		int totalCount = dao.getTotal();
		String pagi="";
		if(totalCount%Npp==0) {
			totalPage=totalCount/Npp;
		}else {
			totalPage=totalCount/Npp+1;
		}
		int pageNo=1;
		int pageNaviSize=5;
		
		//페이징 처리 
		//이전페이지 
		if(reqPage!=1) {
		pagi += "<a href='boardList.com?reqPage="+(reqPage-1)+"'>[이전]</a>";
		}
		if(reqPage >3) {
			pageNo=reqPage-2;
			}
		
		for(int i=0; i<pageNaviSize; i++) {
			
			if(pageNo==reqPage) {
				pagi+="<span>"+pageNo+"<span>";
			}else {
				
			
				pagi += "<a href='boardList.com?reqPage="+(pageNo)+"'>"+pageNo+"</a>";
			}	
				pageNo++;
				if(pageNo>totalPage) {
					break;
				}
			}
		//다음페이지 
		if(reqPage<totalPage) {
		pagi +="<a href='boardList.com?reqPage="+(reqPage+1)+"'>[다음]</a>";
		}
		pagination pg = new pagination();
		pg.setList(list);
		pg.setPagination(pagi);
		
		return pg;
	}

	public Board getOneBoard(int boardNo) {
		
		
		return dao.getOneBoard(boardNo);
	}

	public int boardUpdate(Board b) {
		
		
		return dao.boardUpdate(b);
	}

	public int deleteBoard(int boardNo) {
		
		return dao.deleteBoardno(boardNo);
	} 
}
