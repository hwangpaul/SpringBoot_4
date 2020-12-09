package com.iu.sb4.board.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	//model.addAttribute("board", "notice")
	//Controller내의 모든 메서드에 적용
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	//@PostMapping("noticeUpdate")
	public ModelAndView setUpdatePost(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(boardVO);
		
		return mv;
	}
	
	//@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Update");
		
		boardVO = noticeService.getOne(boardVO);
		
		mv.addObject("vo", boardVO);
		
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@GetMapping("noticeFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		fileVO = noticeService.getFile(fileVO);
		
		mv.addObject("fileVO", fileVO);
		//mv.addObject("filePath", "upload/notice");
		mv.addObject("filePath", filePath);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Board Select");
		
		boardVO = noticeService.getOne(boardVO);
		
		mv.addObject("vo", boardVO);

		mv.setViewName("board/boardSelect");
		
		return mv;
		
	}
	
			
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Notice List");
		
		List<BoardVO> ar = noticeService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("lists", ar);

		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public String setInsert(BoardVO boardVO) throws Exception{
		
		System.out.println("Board Write");
		

		return"board/boardWrite";
	}
	
	@PostMapping("noticeWrite")
	public String setinsert(@Valid BoardVO boardVO,BindingResult bindingResult, MultipartFile [] files) throws Exception{
		System.out.println("Notice Write ------------------");
		if(bindingResult.hasErrors()) {
			System.out.println("검증 실패 ----------------");
			return "board/boardWrite";
		}
		
		int result = noticeService.setInsert(boardVO, files);
		
		return "redirect:./noticeList";
		
	}

}
