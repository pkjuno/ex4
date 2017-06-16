package com.choa.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;



@Service
public class FreeboardServiceImpl implements BoardService {
	
	@Autowired
	private FreeboardDAOImpl freeboardDAO;
	//생성자 or Setter
	
	//test
	public void test(){
		System.out.println(freeboardDAO);
	}
	
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		PageMaker pageMaker = new PageMaker(curPage, 30);
		return freeboardDAO.boardList(pageMaker.getRowMaker("", ""));
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		return freeboardDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return freeboardDAO.boardDelete(num);
	}

	
	
	
}
