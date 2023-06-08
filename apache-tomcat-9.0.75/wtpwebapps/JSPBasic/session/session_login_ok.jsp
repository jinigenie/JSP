<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1. 아이디, 비밀번호, nick을 받습니다.
	2. 아이디 비밀번호가 동일하면 로그인 성공이라고 간주하고 (user_id, id)의 세션생성
	(user_nick, 닉네임)을 세션을 생성
	
	session_welcome로 이동해서 화면에 "id님 환영합니다"를 출력합니다.
	틀린경우는 로그인페이지로 리다이렉트 처리해주세요.

	*/
	
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nick = request.getParameter("name");
	
	if(id.equals("genie") && pw.equals("1234")){
		
		session.setAttribute("user_id", id);
		session.setAttribute("user_nick", nick);
		
		response.sendRedirect("session_welcome.jsp");
		
	} else {
		
		response.sendRedirect("session_login.jsp");
	}
	
%>












