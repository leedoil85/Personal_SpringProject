package com.myproject.myboard.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.myproject.myboard.vo.PersonalMemberVO;

public class PersonalMemberDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public PersonalMemberVO selectID(String mem_id) {
		PersonalMemberVO member = null;
		
		member = sqlSession.selectOne("member.member_select",mem_id);
		
		return member;
	}
	
	public int member_insert(PersonalMemberVO member) {
		int res = 0;
		
		res = sqlSession.insert("member.member_insert", member);
		
		return res;
	}
}
