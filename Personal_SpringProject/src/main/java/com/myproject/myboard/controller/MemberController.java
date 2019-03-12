package com.myproject.myboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.myboard.dao.PersonalMemberDAO;

@Controller
public class MemberController {

	PersonalMemberDAO personalMemberDAO;

	public MemberController() {
	}

	public MemberController(PersonalMemberDAO personalMemberDAO) {
		this.personalMemberDAO = personalMemberDAO;
	}
	
	@RequestMapping("/login.do")
	public String login() {

		return "/WEB-INF/views/membership/loginform.jsp";
	}

}
