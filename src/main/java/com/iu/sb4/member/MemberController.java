package com.iu.sb4.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.member.MemberService;
import com.iu.sb4.member.MemberVO;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberJoin") 
	public ModelAndView setInsert(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile files) throws Exception{
		System.out.println("Join Post");
		ModelAndView mv = new ModelAndView();
	
		if(memberService.getMemberError(memberVO, bindingResult)) {
			mv.setViewName("member/memberJoin");
			return mv;
		}
		
		//검증이 통과일 때 실행하는 코드 작성
		
		
		return mv;
	}
	
	@GetMapping("memberJoin")
	public void setInsert(MemberVO memberVO) throws Exception{
		System.out.println("Join");
		
		
	}
	
	@GetMapping("memberLogOut")
	public String getMemberLogout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
		
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("memberLogin");
		
		mv.setViewName("member/memberLogin");
		
		return mv;	
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpServletResponse response ,HttpSession session) throws Exception{
		System.out.println("Member Login Post");
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.getMemberLogin(memberVO);
		
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}else {
			String message = "Login Fail";
			mv.addObject("msg", message);
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("memberPage")
	public void getMemberPage() throws Exception{
		
		
	}
	

}
