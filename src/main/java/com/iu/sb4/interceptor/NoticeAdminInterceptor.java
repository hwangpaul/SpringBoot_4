package com.iu.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.notice.NoticeMapper;
import com.iu.sb4.board.qna.QnaVO;
import com.iu.sb4.member.MemberRoleVO;
import com.iu.sb4.member.MemberVO;

@Component
public class NoticeAdminInterceptor implements HandlerInterceptor{
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		boolean result = false;
		
		//1) 요청 URI 
		
		String path = request.getRequestURI();
		String kind = path.substring(path.lastIndexOf("notice")).replace("notice", "");
		
		String message = "권한이 필요";
		
		
		if(memberVO != null) {
			List<MemberRoleVO> roles = memberVO.getRoles();
			for(MemberRoleVO memberRoleVO:roles) {
				if(memberRoleVO.getRole().equals("admin")) {
					if(kind.equals("Write")) {
						result = true;
						break;
						
					}else {
						int num = Integer.parseInt(request.getParameter("num"));
						BoardVO boardVO = new BoardVO();
						boardVO.setNum(num);
						boardVO = noticeMapper.getOne(boardVO);
						
						if(boardVO.getWriter().equals(memberVO.getId())) {
							result = true;
							break;
						}else {
							message = "작성자만 접근이 가능";
						}
						
					}
					
					
				}
			}
			
		}
		
		if(!result) {
			request.setAttribute("msg", message);
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}

}
