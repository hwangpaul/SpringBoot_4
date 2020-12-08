package com.iu.sb4.member;

public interface MemberService {
	
	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception;	
		
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;

}
