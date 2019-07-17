package com.myproject.myboard.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myproject.myboard.util.Pagination;
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
	
	public PersonalMemberVO member_login(String mem_id){
		PersonalMemberVO member = null;
		
		member = sqlSession.selectOne("member.member_login", mem_id);
		
		return member;
		
	}	
	
	public List<PersonalMemberVO> member_list(){
		List<PersonalMemberVO> mem_list = null;
		
		mem_list = sqlSession.selectList("member.member_list");
		
		return mem_list;
	}
	
	// 7/1 페이징 코드 작성중 컨트롤러까지 작성
	public int page_count(Pagination pag){
		int page_count =  sqlSession.selectOne("member.mem_list");
		
		return page_count;
	}

	public int mem_delete(String mem_id) {
		int res = 0;

		res = sqlSession.delete("member.member_delete", mem_id);
		return res;
	}
}
