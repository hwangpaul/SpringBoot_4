package com.iu.sb4.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {
	
	@Autowired
	private QnaMapper qnaMapper;

	@Test
	void setInsertTest() throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("test title 1");
		qnaVO.setWriter("test title 1");
		qnaVO.setContents("test contents 1");
		
		int result = qnaMapper.setInsert(qnaVO);
		result = qnaMapper.setRefUpdate(qnaVO);
		
		assertNotNull(result);
	}

}
