package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myspring.dto.BoardDTO;

@Mapper
public interface BoardMapper {
 //추가
	@Insert("insert  into board(title, writer,content) values(#{title},#{writer},#{content})")
	public void insert(BoardDTO board);

	//전체보기  ==> list
	@Select("select * from board order by num desc")
	public List<BoardDTO> list();
	//개수
	@Select("select count(*) from board")
	public int count();
	//상세보기
	@Select("select * from board where num=#{num}")
	public BoardDTO view(int num);
	//댓글 개수 증감
	@Update("update board set replyCnt =replyCnt+#{amount} "
			+ " where num=#{bnum} ")
	public void updateReplyCnt(@Param("bnum") int bnum, 
			                             @Param("amount") int amount);
}





