package com.genie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.genie.user.model.UserVO;
import com.genie.user.service.UserService;
import com.genie.user.service.UserServiceImpl;

//1. 확장자패턴으로 변경
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	//2. get, post 하나로 모으기
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//3. 요청분기
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);
		
		//** MVC2에서는 화면을 띄우는 요청도 컨트롤러를 거쳐 나가도록 처리
		//** 기본 이동이 전부 forward 형식으로 처리
		//** 리다이렉트는 다시 컨트롤러를 태워 나가는 용도로 사용
		
		UserService service = new UserServiceImpl();
		
		
		if(command.equals("/user/user_join.user")) {
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
			
		} else if(command.equals("/user/user_login.user")) {
			
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		
		//회원가입요청
		} else if(command.equals("/user/joinForm.user")) { 
			
			//가입
			int result = service.join(request, response);
			
			if(result == 1) { // 중복
				request.setAttribute("msg", "중복된 아이디입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
				
			} else { // 가입성공
				response.sendRedirect("user_login.user");
			}
			
		//로그인
		} else if(command.equals("/user/loginForm.user")) {
			
			UserVO vo = service.login(request, response);
			
			if(vo == null) { // 로그인 실패
				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
				
				
			} else { // 로그인 성공
				
				// 세션에 회원정보 저장 (자바에서 세션 얻는 방법)
				HttpSession session = request.getSession();
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				
				response.sendRedirect("user_mypage.user");
				
			}
			
		}
		
	}



}