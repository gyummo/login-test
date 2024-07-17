package com.login.user.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.login.user.model.vo.User;

public class UserDao {
	
	public User loginUser(SqlSession sqlSession, User u) {
		System.out.println("Dao: " + u);
		return sqlSession.selectOne("userMapper.loginUser", u);
	}
}

