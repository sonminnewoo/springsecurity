package com.myspring.app09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.dto.BoardDTO;
import com.myspring.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board/*")
@Controller
@RequiredArgsConstructor
public class BoardController {
	//@Autowired
	private  final BoardService boardService;
	
//	public BoardController(BoardService boarService) {
//		this.boardService = boarService;
//	}
	//추가폼
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public void insert() { }
	
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		boardService.insert(board);
		return "redirect:list";
	}
	@GetMapping("list")
		public String list(Model model) {
		 List<BoardDTO> boards =  boardService.list();
		 model.addAttribute("boards", boards);
		 model.addAttribute("count", boardService.count());
			return "board/list";
		}
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		// 내용추가
		model.addAttribute("board", boardService.view(num));
	   return "board/view";	
	}
	
	

}
