package com.iu.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.member.MemberRoleVO;
import com.iu.sb4.member.MemberVO;

@Component
public class NoticeMemberInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		

		HttpSession session = request.getSession();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		boolean check = false;
		if(memberVO != null) {
			List<MemberRoleVO> roles = memberVO.getRoles();
			for(MemberRoleVO memberRoleVO:roles) {
				if(memberRoleVO.getRole().equals("member")) {
					check = true;
					break;
				}
			}
			
		}else {
				request.setAttribute("msg", "회원만 접근 가능한 서비스 입니다.");
		 		request.setAttribute("path", "../member/memberLogin");
		 		
		 		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		 		view.forward(request, response);
			
		}
				
		
		
		
		return check;
	}
	

}
