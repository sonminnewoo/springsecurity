package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.dto.BoardDTO;
import com.myspring.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	// 추가
	public void insert(BoardDTO board) {
		boardMapper.insert(board);
	}
	//전체보기  ==> list
	public List<BoardDTO> list(){
		return boardMapper.list();
	}
	//개수
	public int count() {
		return boardMapper.count();
	}
	//상세보기
	public BoardDTO view(int num) {
		return boardMapper.view(num);
	}
	

}
