<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//세션은 서버와의 정보를 유지하기 위한 수단으로 서버에서 생성하고 서버에서 저장
	session.setAttribute("user_id", "xxx123");
	session.setAttribute("user_name", "홍길동");

	//세션의 시간 설정
	session.setMaxInactiveInterval(3600); //1시간 설정

	//세션값의 특정값 삭제
	session.removeAttribute("user_id"); //user_id 삭제
	
	//세션값의 무효화(모든 값 삭제)
	session.invalidate();
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>

	<a href = "session_get.jsp">세션 확인하기</a>

</html>