package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;



public class NoticeDAOImplTest extends MyAbstractTest{

	@Autowired
	private NoticeDAOImpl noticeDAO;
	
	@Test
	public void test() throws Exception {
		PageMaker pageMaker = new PageMaker(1);	
		List<NoticeDTO> ar = noticeDAO.noticeList(pageMaker.getRowMaker("", ""));
		assertEquals(0, ar.size());
	}
	
	@Test
	public void test2()throws Exception{
		int result = noticeDAO.noticeDelete(527);
		assertEquals(1, result);
	}
	

	
}
