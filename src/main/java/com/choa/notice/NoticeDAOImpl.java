package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.RowMaker;



@Repository
//NoticeDAO noticeDAO = new NoticeDAO()와 같다.
//멤버 변수 처리가 필요 @Inject 할것.
public class NoticeDAOImpl  implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"List", rowMaker);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"View", num);
		
		return boardDTO;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"Write", boardDTO); 
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"Update", boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"Delete", num);
	}

	@Override
	public int boardCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"Count");
	}

	@Override
	public int boardHit(int num) throws Exception {
		return 0;
	}


	
}
