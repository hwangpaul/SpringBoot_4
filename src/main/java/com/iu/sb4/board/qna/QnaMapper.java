package com.iu.sb4.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.sb4.board.BoardMapper;
import com.iu.sb4.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper{
	
	public int setRefUpdate(QnaVO qnaVO) throws Exception;

}
