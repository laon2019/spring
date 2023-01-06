package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("select * from tbl_board order by bno DESC")
	public List<BoardVO> getList();
	
	
	@Select("select sysdate from dual")
	public String getTime();
	
	public void insert(BoardVO board);
	
}