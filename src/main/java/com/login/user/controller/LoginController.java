package com.login.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.user.model.vo.User;
import com.login.user.service.UserServiceImpl;

/**
 * Servlet implementation class userLoginController
 */
@WebServlet("/login.u")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		User u = new User();
		
		u.setUserId(request.getParameter("userId"));
		u.setUserPwd(request.getParameter("userPwd"));
		System.out.println("controller: " + u);
		
		User loginUser = new UserServiceImpl().loginUser(u);
		
		if (loginUser == null) {
			request.setAttribute("errorMsg", "로그인 실패");
		} else {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
		}
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}
