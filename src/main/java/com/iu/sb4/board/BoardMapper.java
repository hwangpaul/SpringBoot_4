package com.iu.sb4.board;

import java.util.List;

import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.board.notice.NoticeVO;
import com.iu.sb4.util.Pager;

public interface BoardMapper {
	
		public long getCount(Pager pager) throws Exception;

		//글하나조회
		public BoardVO getOne(BoardVO boardVO) throws Exception;
		
		//글리스트
		public List<BoardVO> getList(Pager pager) throws Exception;
		
		//글삭제
		public int setDelete(BoardVO boardVO) throws Exception;
		
		//title, contents 수정
		public int setUpdate(BoardVO boardVO) throws Exception;
		
		//글쓰기
		public int setInsert(BoardVO boardVO) throws Exception;
		
		public int setInsertFile(FileVO fileVO) throws Exception;
		
		public FileVO getFile(FileVO fileVO) throws Exception;
	
}
