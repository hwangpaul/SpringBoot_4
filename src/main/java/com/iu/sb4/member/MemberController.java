package com.iu.sb4.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.member.MemberService;
import com.iu.sb4.member.MemberVO;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpServletResponse response ,HttpSession session) throws Exception{
		System.out.println("Member Login Post");
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.getMemberLogin(memberVO);
		
		session.setAttribute("member", memberVO);
		
		mv.setViewName("redirect:../");

		return mv;
	}
	
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		System.out.println("memberLogin");
		return mv;	
	}

}
