package com.iu.sb4.member;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getMemberLogin(memberVO);
		
	}

}
