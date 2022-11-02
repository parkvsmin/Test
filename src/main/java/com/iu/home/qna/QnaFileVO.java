package com.iu.home.qna;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QnaFileVO {
	
	private Long fileNum;
	private Long num;
	private String fileName;
	private String oriName;
	
	private MultipartFile [] files;

}
