package com.iu.sb4.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//model.addAttribute("board", "notice")
	//Controller내의 모든 메서드에 적용
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "qna";
	}
	
	@PostMapping("qnaWrite")
	public String setInsert(@Valid BoardVO boardVO, BindingResult bindingResult ,MultipartFile [] files) throws Exception{
		
		System.out.println("Qna Write ------------------");
		if(bindingResult.hasErrors()) {
			System.out.println("검증 실패 ----------------");
			return "board/boardWrite";
		}
		
		int result = qnaService.setInsert(boardVO, files);
		
		return "redirect:../qnaList";
		
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Qna Write");
		
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardVO = qnaService.getOne(boardVO);
		
		mv.addObject("vo", boardVO);
	
		mv.setViewName("board/boardSelect");
		
		return mv;
		
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("qna List");
		
		List<BoardVO> ar = qnaService.getList(pager);
		
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		
		
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
}
