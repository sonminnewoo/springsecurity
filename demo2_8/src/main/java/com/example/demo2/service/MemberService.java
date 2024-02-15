package com.example.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo2.domain.CustomUser;
import com.example.demo2.dto.MemberDTO;
import com.example.demo2.mapper.MemberMapper;

@Service
public class MemberService  implements UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
	    MemberDTO member = 	memberMapper.read(username);
		return member ==null ? null : new CustomUser(member);
	}

}
