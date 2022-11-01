package com.iu.home.member;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public void setJoin(@ModelAttribute MemberVO memberVO)throws Exception {
	
	}

	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, ModelAndView mv)throws Exception{
	
		int result = memberService.setJoin(memberVO); 
		mv.setViewName("redirect:../");
		return mv;
	}

	@GetMapping("login")
	public void getLogin()throws Exception {

	}

	@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session)throws Exception {
		memberVO = memberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		return "redirect:../";

	}

	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception {
		session.invalidate();
		return "redirect:../";

	}

	@GetMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO)throws Exception {
		return memberService.getIdCheck(memberVO);

	}

}
