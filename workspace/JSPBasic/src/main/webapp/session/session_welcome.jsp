<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
	
	session_welcome로 이동해서 화면에 "id님 환영합니다"를 출력합니다.
	틀린경우는 로그인페이지로 리다이렉트 처리해주세요.
	
	session_welcome페이지에서는 a태그를 이용해서 로그아웃 기능을 만들어주세요
	로그아웃은 session_logout.jsp에서 세션을 무효화하고 리다이렉트로 이동해주면 됩니다.
	*/
	String id = (String)session.getAttribute("user_id");

	// 로그인한 사람만 접근 가능
	if ( session.getAttribute("user_id") == null) {
		response.sendRedirect("session_login.jsp");
	}
	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=id %>님 환영합니다.<br>
	<a href = "session_logout.jsp">로그아웃하기</a>

</body>
</html>