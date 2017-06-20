package com.choa.freeboard;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;


@Repository
public class FreeboardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "FreeboardMapper.";
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		return sqlSession.selectList(NAMESPACE+"List", listInfo);
	}
	
	@Override
	public BoardDTO boardView(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"View", num);
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
	public int boardCount(ListInfo listInfo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"Count", listInfo);
	}
	@Override
	public int boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	//count
	
	//hit
}
