package com.iu.sb4.board.qna;

import java.util.List;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QnaVO extends BoardVO{
	
	private long ref;
	private long step;
	private long depth;
	
	private List<FileVO> files;
	
}
