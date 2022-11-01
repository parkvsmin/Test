package com.iu.home.qna;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception {
		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("qna/list");
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd(@ModelAttribute QnaVO qnaVO)throws Exception {
		return "qna/add";
	
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid QnaVO qnaVO, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView mv)throws Exception {
		//검증
		if(bindingResult.hasErrors()) {
			mv.setViewName("qna/add");
			return mv;
		}
		
		int result = qnaService.setAdd(qnaVO);
		redirectAttributes.addAttribute("result", result);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO)throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("detail", qnaVO);
		mv.setViewName("qna/detail");
		return mv;
	}
	

	@GetMapping("update")
	public ModelAndView setUpdate(QnaVO qnaVO,ModelAndView mv)throws Exception {
		qnaVO =qnaService.getDetail(qnaVO);
		mv.addObject("qnaVO",qnaVO);
		mv.setViewName("qna/update");
		return mv;
	}
	
	@PostMapping("update")
	public String setUpdate(QnaVO qnaVO)throws Exception {
		int result = qnaService.setUpdate(qnaVO);
		return "redirect:./detail?num="+qnaVO.getNum();
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int setFileDelete(QnaFileVO qnaFileVO)throws Exception {
		int result = qnaService.setFileDelete(qnaFileVO);
		return result;
	}

}