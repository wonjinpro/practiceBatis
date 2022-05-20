 package com.wonjin.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonjin.board.vo.Board;
import com.wonjin.board.vo.FileVO;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public ArrayList<Board> getBoardList(HashMap<String, Object> map) {
		
		List list = sqlSession.selectList("board.boardList",map);
		return (ArrayList<Board>)list;
	}

	public int getTotal() {
		
		int total = sqlSession.selectOne("board.total");
		
		return total;
	}

	public Board getOneBoard(int boardNo) {
		
		Board bo = sqlSession.selectOne("board.getOneBoard",boardNo);
		return bo;
	}

	public int boardUpdate(Board b) {
		int result = sqlSession.update("board.updateBoard",b);
		return result;
	}

	public int deleteBoardno(int boardNo) {
		int result= sqlSession.delete("board.deleteBoard",boardNo);
		return result;
	}

	public int insetBoard(Board b) {
		
		int boardNo = sqlSession.insert("board.insertBoard", b); 
		return boardNo;
	}

	

	

	
	
}
