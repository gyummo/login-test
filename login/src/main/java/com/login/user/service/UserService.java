package com.login.user.service;

import com.login.user.model.vo.User;

public interface UserService {
	// 로그인
	public abstract User loginUser(User u);
}
