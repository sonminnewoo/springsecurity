package com.myspring.app09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.dto.CommentDTO;
import com.myspring.dto.CustomUser;
import com.myspring.service.CommentService;

@RequestMapping("/reply/*")
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	//전체보기
	@GetMapping("commentList/{bnum}")
	public List<CommentDTO> list(@PathVariable int bnum) {
		return commentService.getList(bnum);
	}
	
	//삭제
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		commentService.delete(cnum);
		return cnum;
	}
	
	
	//추가
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment	) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 CustomUser user = (CustomUser)auth.getPrincipal();
		comment.setUserid(user.getUsername()); 
		commentService.insert(comment);
		return "success";
	} 

}
