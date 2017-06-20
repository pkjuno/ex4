package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;



public class NoticeDAOImplTest extends MyAbstractTest{
	
	@Inject
	private NoticeDAOImpl dao;
	
	@Test
	public void connectionTest() throws Exception{
		dao.boardCount();
		
	
	
		
	}
	
	//@Test
	public void countTest() throws Exception {
		int count = dao.boardCount();
		assertNotEquals(0, count);
	}
	
}
