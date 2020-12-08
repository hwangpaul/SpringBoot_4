package com.iu.sb4.member.memberuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.sb4.member.MemberFileVO;
import com.iu.sb4.member.MemberService;
import com.iu.sb4.member.MemberVO;

@Service
public class MemberUserService implements MemberService{
	
	@Autowired
	private MemberUserMapper memberUserMapper;
	
	
	@Override
	public int setInsert(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserMapper.getMemberLogin(memberVO);
	}
}
