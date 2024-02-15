package com.example_jpa.demo3.service;

import java.util.List;

import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.stereotype.Service;

import com.example_jpa.demo3.model.JpaMember;
import com.example_jpa.demo3.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	//추가
	public void save(JpaMember member) {
		memberRepository.save(member);
	}
	//전체보기
	public List<JpaMember> list(){
		return memberRepository.findAll();
	}
	//상세보기 select * from jpa_member where id =1
	public JpaMember view(Long id) {
		return memberRepository.findById(id).get();
	}
	//삭제 delete from jpa_member where id =1
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	//수정(더티체킹)
	@Transactional
	public void update(JpaMember member) {
		//memberRepository.update(member);
	 JpaMember m =	memberRepository.findById(member.getId()).get();
	 m.setAddr(member.getAddr());
	 m.setEmail(member.getEmail());
	 m.setMemo(member.getMemo());
	 m.setPassword(member.getPassword());
	}
	

}
