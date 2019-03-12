package com.myproject.myboard.dao;

import org.apache.ibatis.session.SqlSession;

public class PersonalMemberDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
