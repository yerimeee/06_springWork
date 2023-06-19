package com.kh.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.board.model.vo.Board;

@Mapper
public interface BoardDao {

	List<Board> selectBoardList(RowBounds rowBounds);

	int selectTotalRecord();

	int insertBoard(Board board);

	int updateCountBoard(int boardNo);
	
	Board selectOneBoard(int boardNo);

}
