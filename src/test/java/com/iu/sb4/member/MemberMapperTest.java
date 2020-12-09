package com.iu.sb4.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.iu.sb4.member.MemberMapper;
import com.iu.sb4.member.MemberVO;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(value = true)
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void setInsertTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test2");
		memberVO.setPw("test2");
		memberVO.setName("test name");
		memberVO.setAge(20);
		memberVO.setEmail("test@email.com");
		
		int result = memberMapper.setInsert(memberVO);
		
		assertEquals(1, result);
		
	}
	
	@Test
	void setInsertFileTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("id1");
		memberFileVO.setFileName("fileName2");
		memberFileVO.setOriName("oriName2");
		
		int result = memberMapper.setInsertFile(memberFileVO);
		
		System.out.println("member File");
		assertEquals(1, result);
	}
	
	@Test
	void getMemberLoginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("pw1");
		
		memberVO = memberMapper.getMemberLogin(memberVO);
		
		assertNotNull(memberVO);
		
	}

}
