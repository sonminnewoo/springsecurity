package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.dto.CommentDTO;
import com.myspring.mapper.BoardMapper;
import com.myspring.mapper.CommentMapper;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private BoardMapper boardMapper;
	//추가
	@Transactional
	public void insert(CommentDTO comment) {	
		commentMapper.insert(comment);
		boardMapper.updateReplyCnt(comment.getBnum(), 1);
		
	}
	//삭제
	@Transactional
	public void delete(int cnum) {
		CommentDTO comment =commentMapper.read(cnum);
		boardMapper.updateReplyCnt(comment.getBnum(),-1);
		commentMapper.delete(cnum);
	}
	
	//전체보기
	public List<CommentDTO> getList(int bnum){
		return commentMapper.getList(bnum);
	}
	
	//삭제

}
