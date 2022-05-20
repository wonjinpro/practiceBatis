package com.wonjin.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.bcel.internal.util.ByteSequence;
import com.wonjin.board.service.BoardService;
import com.wonjin.board.vo.Board;
import com.wonjin.board.vo.FileVO;
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
	@RequestMapping(value="boardWriteFrm.com")
	public String boardWriteFrm() {
		
		return "board/boardWrite";
	}
	@RequestMapping(value="boardWrite.com")
	public String boardWrite(MultipartFile[] file, Board b,HttpServletRequest request) {
		
		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		//경로 지정하기 
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root +"resources/upload/board/";
		System.out.println(root);
		//중복 파일명 처리 
		for(MultipartFile upfile :file) {
			
			//원래 파일명 구하기 
			String filename = upfile.getOriginalFilename();
			//파일명 분리하기(중복제거)
			String onlyFile = filename.substring(0,filename.lastIndexOf("."));
			String extention= filename.substring(filename.lastIndexOf("."));
			String filepath = null;
			int count = 0;
			while(true) {
				
				if(count==0) {
					filepath = onlyFile + extention;
				}else {
					filepath = onlyFile +"_"+count+extention;
				}
				File checkFile =new File(savePath+filepath);
				if(!checkFile.exists()) {
					break;
				}
				count++;
				
			}//반복문 종료 
			//파일 업로드를 위한 스트림 생성 
			try {
				FileOutputStream fos = new FileOutputStream(new File(savePath+filepath));
				//파일 업로드 원활하게 해주는 스트림 생성 
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				//바이트배열로 변환해서 파일 업로드 
				byte[] bytes = upfile.getBytes();
				bos.write(bytes);
				bos.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileVO fileVo = new FileVO();
			fileVo.setFileName(filename);
			fileVo.setFilePath(filepath);
			fileList.add(fileVo);
			
			
		}//파일 한개씩 처리후 종료 완료 
		int result = service.insertBoard(fileList,b);
		return "board/boardList";
	}
}
