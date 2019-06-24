package com.myproject.myboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.myproject.myboard.dao.PersonalMemberDAO;
import com.myproject.myboard.vo.PersonalMemberVO;

@Controller
@SessionAttributes("mem_id")
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
	
	@RequestMapping("/signupSucess.do")
	public String signupSucess() {
		
		return "/WEB-INF/views/membership/signupSucess.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logOut(SessionStatus session) {
		session.setComplete();
		
		return "/WEB-INF/views/membership/loginform.jsp";
	}
	
	@RequestMapping("/management.do")
	public String management(Model model) {
		//dao객체를 통해 db를 조회하여 리스트 획득
		List<PersonalMemberVO> list = personalMemberDAO.member_list();
				
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/membership/management.jsp";
	}	
	
	
	
	@RequestMapping("/id_check.do")
	@ResponseBody
	public Map<String, String> id_check(@RequestParam String mem_id) {
		PersonalMemberVO member = null;
		Map<String,String> map = null;
		try {
			member =  personalMemberDAO.selectID(mem_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			map = new HashMap<String,String>();
			
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
	public Map<String, String> member_insert(@ModelAttribute @Validated PersonalMemberVO member ,ModelMap model) {
		//@ModelAttribute : 대상 객체의 필드와 파라메터를 1:1 매칭 자동으로 setter를 호출
		//@Validated : 대상 객체의 확인 조건을 만족할 경우 통과(파라메터와 VO의 필드가 일치한다면)
		
		//model.addAttribute("mem_pw", member.setMem_pw());
		
		int res = 0;
		Map<String, String> param = new HashMap<String,String>();
		//param.put("member", personalMemberVO);
			
		res = personalMemberDAO.member_insert(member);
		System.out.println("결과 : " + res);
		
		if (res == 1 ) {
			param.put("member_insert", "s");//성공s
		}
		
		return param;
	}
	
	//id조회 pw정보 일치여부 확인
	@RequestMapping("/member_login.do")
	@ResponseBody
	public Map<String,String> mem_login(@RequestParam String mem_id,@RequestParam String mem_pw, Model model){
		System.out.println("--로그인 시작--");
		System.out.printf("로그인 아이디: %s\n",mem_id);
		Map<String, String> jsonData = new HashMap<String, String>();
		PersonalMemberVO member = personalMemberDAO.member_login(mem_id);
		
		//getter는 조회된 데이터가 있을때만 
		//파라메터로 보내준 값이 세팅 되는게 아닌것같음
		if (member == null) {//조회된 결과가 없으면
			jsonData.put("jsonData", "no_id");
			System.out.printf("아이디 %s 일치하는 아이디 없음\n",mem_id);
		}else if(  member.getMem_pw().equals(mem_pw.trim()) == false) {
			jsonData.put("jsonData", "no_pw");
			System.out.printf("아이디 %s 비밀번호 불일치\n",mem_id);
		}else {
			jsonData.put("jsonData","clear");
			System.out.printf("아이디 %s 로그인 성공\n",mem_id);
			model.addAttribute("mem_id", member.getMem_id());
		}
		System.out.println("--로그인 종료--");
		return jsonData;
	}
	
	@RequestMapping("/member_delete.do")
	@ResponseBody
	public Map<String, String> mem_delete(@RequestParam String mem_id){
		System.out.println("--회원 삭제 시작--");
		Map<String, String> jsonData = new HashMap<String, String>();
		System.out.printf("아이디 : %s 삭제\n",mem_id);
		int res = personalMemberDAO.mem_delete(mem_id);
		
		if (res == 1) {
			System.out.printf("%d건 삭제 성공!\n",res);
			jsonData.put("jsonData", "success");
		}else {
			System.out.println("삭제실패");
			jsonData.put("jsonData", "fail");
		}
		
		System.out.println("--회원 삭제 종료--");
		return jsonData;
	}
	
	
	
	
}
