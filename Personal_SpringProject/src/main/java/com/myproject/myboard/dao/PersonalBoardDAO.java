package com.myproject.myboard.dao;

import org.apache.ibatis.session.SqlSession;

public class PersonalBoardDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
