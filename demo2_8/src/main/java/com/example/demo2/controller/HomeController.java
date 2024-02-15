package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/")
  public String home() {
	  return "home";
  }
  
  //로그인
  @GetMapping("/login")
  public String login() {
	  return "user/login";
			  
  }
}
