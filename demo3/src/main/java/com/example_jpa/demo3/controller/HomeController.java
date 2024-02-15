package com.example_jpa.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example_jpa.demo3.model.JpaMember;
import com.example_jpa.demo3.repository.MemberRepository;
import com.example_jpa.demo3.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	@PostMapping("join")
	public String join(JpaMember member) {
		memberService.save(member);
		return "redirect:list";
	}
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("arr", memberService.list());
		return "list";
	}
	//상세보기
	@GetMapping("view/{id}")
	public String view(@PathVariable Long id, Model model) {
	    model.addAttribute("member", memberService.view(id));
	    return "view";
	}
	
	//삭제
	@DeleteMapping("dekete/{id}")
	public Long delete(@PathVariable Long id) {
		memberService.delete(id);
		return id;
	}
	//수정폼
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.view(id));
		return "update";
	}
	//수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody JpaMember member) {
//		memberService.update(member);
//		JpaMember m = MemberRepository.findById(member.getId()).get();
//		m.setAddr(member.getAddr());
//		m.setAddr(member.getAddr());
//		m.setAddr(member.getAddr());
//		m.setAddr(member.getAddr());
//		m.setAddr(member.getAddr());
//		m.setAddr(member.getAddr());
		memberService.update(member);
		return "success";
	}
	
}
