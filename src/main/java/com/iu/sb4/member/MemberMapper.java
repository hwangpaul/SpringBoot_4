package com.iu.sb4.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
	
	public MemberVO getMemberId(MemberVO memberVO) throws Exception;

}
