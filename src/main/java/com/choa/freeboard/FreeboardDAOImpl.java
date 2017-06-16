package com.choa.freeboard;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.RowMaker;


@Repository
public class FreeboardDAOImpl implements BoardDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		FreeboardDTO freeboardDTO = null;
		
		String sql = "select * from "
				+ "(select rownum R, F.* from "
				+ "(select * from freeboard order by ref desc, step asc) F ) "
				+ "where R between ? and ?";
		
		st = con.prepareStatement(sql);
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());
		
		rs = st.executeQuery();
		
		while(rs.next()){
			freeboardDTO = new FreeboardDTO();
			freeboardDTO.setNum(rs.getInt("num"));
			freeboardDTO.setWriter(rs.getString("writer"));
			freeboardDTO.setTitle(rs.getString("title"));
			freeboardDTO.setContents(rs.getString("contents"));
			freeboardDTO.setReg_date(rs.getDate("reg_date"));
			freeboardDTO.setHit(rs.getInt("hit"));
			freeboardDTO.setRef(rs.getInt("ref"));
			freeboardDTO.setStep(rs.getInt("step"));
			freeboardDTO.setDepth(rs.getInt("depth"));
			ar.add(freeboardDTO);
		}
		
		DBConnect.disConnect(rs, st, con);
		
		return ar;
	}
	
	@Override
	public BoardDTO boardView(int num) throws Exception {
		FreeboardDTO freeboardDTO = new FreeboardDTO();
		return freeboardDTO;
	}
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		int result = 0;
		return result;
	}
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		int result = 0;
		return result;
	}
	@Override
	public int boardDelete(int num) throws Exception {
		int result = 0;
		return result;
	}
	@Override
	public int boardCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	//count
	
	//hit
}
