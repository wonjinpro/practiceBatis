package com.wonjin.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonjin.board.dao.BoardDao;

@Service
public class BoardService {
	@Autowired
	private BoardDao board; 
}
