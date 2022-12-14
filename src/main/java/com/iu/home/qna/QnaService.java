package com.iu.home.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;	
	@Value("${app.upload.qna}")
	private String path;

	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.makeRow();
		return qnaMapper.getList(pager);
	}

	public int setAdd(QnaVO qnaVO)throws Exception{
		int result = qnaMapper.setAdd(qnaVO);

		File file = new File(path);

		if(!file.exists()) {
			boolean check=file.mkdirs();
			log.info("check : {} ",check);
		}

		for(MultipartFile f : qnaVO.getFiles()) {

			if(!f.isEmpty()) {
				log.info("fileName : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		return result;
	}

	public QnaVO getDetail(QnaVO qnaVO)throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.getDetail(qnaVO);
	}

	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO)throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.getFileDetail(qnaFileVO);
	}

	public int setUpdate(QnaVO qnaVO)throws Exception {
		// TODO Auto-generated method stub
		//return qnaMapper.setUpdate(qnaVO);
		int result = qnaMapper.setUpdate(qnaVO);
		
		File file = new File(path);

		if(!file.exists()) {
			boolean check=file.mkdirs();
			log.info("check : {} ",check);
		}

		for(MultipartFile f : qnaVO.getFiles()) {

			if(!f.isEmpty()) {
				log.info("fileName : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		return result;
	}

	public int setFileDelete(QnaFileVO qnaFileVO)throws Exception {
		// TODO Auto-generated method stub
		qnaFileVO = qnaMapper.getFileDetail(qnaFileVO);
		int result = qnaMapper.setFileDelete(qnaFileVO);

		if(result>0) {
			File file = new File(path, qnaFileVO.getFileName());
			file.delete();
		}
		return result;
	}

}