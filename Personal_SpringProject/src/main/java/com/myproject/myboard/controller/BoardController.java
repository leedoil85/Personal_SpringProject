package com.myproject.myboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.myboard.dao.PersonalBoardDAO;

@Controller
public class BoardController {
	PersonalBoardDAO personalBoardDAO;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardController(PersonalBoardDAO personalBoardDAO) {
		this.personalBoardDAO = personalBoardDAO;
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/signup.do")
	public String login() {
		
		return "/WEB-INF/views/membership/signupform.jsp";
	}
	
	@RequestMapping("/main.do")
	public String mainPage() {
		
		return "/WEB-INF/views/main.jsp";
	}

	
}
