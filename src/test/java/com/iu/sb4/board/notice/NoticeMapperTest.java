package com.iu.sb4.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.util.Pager;

@SpringBootTest
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void getListTest() throws Exception{
		long curPage = 1;
		Pager pager = new Pager();
		pager.setPerPage(5);
		pager.setCurPage(curPage);
		pager.makeRow();
		pager.setKind("writer");
		pager.setSearch("r9");
		
		List<BoardVO> ar = noticeMapper.getList(pager);
		
		assertNotNull(ar);
		
		
	}

	//@Test
	void setInsertTest() throws Exception{
		
		for(int i=0; i<100;i++) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test title2"+i);
		noticeVO.setWriter("test writer2"+i);
		noticeVO.setContents("test contents2"+i);
		
		int result = noticeMapper.setInsert(noticeVO);
		if(i%10==0) {
			Thread.sleep(1000);
		}
	}
	System.out.println("Finish");	
	
	}
	
	//@Test
	void setUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("Update Title");
		noticeVO.setWriter("Update Writer");
		noticeVO.setContents("Update Contents");
		noticeVO.setNum(2);
		
		int result = noticeMapper.setUpdate(noticeVO);
		
		assertNotEquals(0, result);
	}
	
  //@Test
	void getOneTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setNum(1);
		
		BoardVO boardVO= noticeMapper.getOne(noticeVO);
		
		assertNotNull(boardVO);
	}
	
	//@Test
	void setDeleteTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(2);
		
		int result = noticeMapper.setDelete(noticeVO);
		
		assertNotEquals(0, result);
		
	}

}
