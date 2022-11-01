package com.iu.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.iu.home.qna.QnaMapper;

@Controller
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QnaMapper qnaMapper;

	@GetMapping("/")
	public String home() throws Exception {
		
		return "index";
	}

}
