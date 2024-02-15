package com.myspring.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myspring.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO read(String userid);

}
