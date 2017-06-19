package com.choa.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.freeboard.FreeboardServiceImpl;

public class NoticeServiceImplTest extends MyAbstractTest{
	
	@Autowired
	private FreeboardServiceImpl service;
	
	@Test
	public void serviceTest() throws Exception{
		BoardDTO boardDTO = service.boardView(583);
		System.out.println(boardDTO.getWriter());
		
	}
	
	
	
}
