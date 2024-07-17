package com.login.user.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.login.common.template.Template;
import com.login.user.model.dao.UserDao;
import com.login.user.model.vo.User;

public class UserServiceImpl implements UserService{
	private UserDao uDao = new UserDao();
	
	@Override
	public User loginUser(User u) {
		SqlSession sqlSession = Template.getSqlSession();
		System.out.println("service: " + u);
		User loginUser = uDao.loginUser(sqlSession, u);
		
		sqlSession.close();
		return loginUser;
	}
}