package com.login.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/loginAjax.ui")
public class LoginFetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginFetchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 클라이언트로부터 받은 데이터 읽기
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");

        // 간단한 로그인 체크
        boolean loginSuccess = checkLogin(userId, userPwd);

        // 응답 데이터 구성
        String jsonResponse;
        if (loginSuccess) {
            jsonResponse = "{\"success\": true}";
        } else {
            jsonResponse = "{\"success\": false}";
        }

        // 클라이언트에 응답 전송
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
	
    private boolean checkLogin(String userId, String userPwd) {
        // 실제 로그인 체크 로직은 여기에 구현
        // 예시로 간단하게 userId가 "user"이고 userPwd가 "password"인 경우에만 로그인 성공으로 가정
        return "user".equals(userId) && "password".equals(userPwd);
    }
}
