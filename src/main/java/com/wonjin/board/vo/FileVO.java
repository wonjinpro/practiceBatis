package com.wonjin.board.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FileVO {
	
	
	private int fileNo;
	private int boardNo;
	private String fileName;
	private String filePath;
}
