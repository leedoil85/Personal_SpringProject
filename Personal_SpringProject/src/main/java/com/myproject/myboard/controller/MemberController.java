package com.myproject.myboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.myboard.dao.PersonalMemberDAO;
import com.myproject.myboard.vo.PersonalMemberVO;

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
	
	@RequestMapping("/id_check.do")
	@ResponseBody
	public Map id_check(@RequestParam String mem_id) {
		PersonalMemberVO member = null;
		Map map = null;
		try {
			member =  personalMemberDAO.selectID(mem_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			map = new HashMap();
			
			if (member == null) {
				map.put("id_check", "yes" );
			}else{
				map.put("id_check", "no");
			}
		}
		
		return map;
	}
	
	@RequestMapping("/member_insert.do")
	@ResponseBody
	public Map<String, String> member_insert(@ModelAttribute @Validated PersonalMemberVO member) {
		//@ModelAttribute : 대상 객체의 필드와 파라메터를 1:1 매칭 
		//@Validated : 대상 객체의 확인 조건을 만족할 경우 통과(파라메터와 VO의 필드가 일치한다면)
		int res = 0;
		Map<String, String> param = new HashMap<String,String>();
		
		//param.put("member", personalMemberVO);
		System.out.println(member.toString());
		res = personalMemberDAO.member_insert(member);
		System.out.println("결과 : " + res);
		
		if (res == 1 ) {
			param.put("member_insert", "s");//성공s
		}
		
		return param;
	}
}
