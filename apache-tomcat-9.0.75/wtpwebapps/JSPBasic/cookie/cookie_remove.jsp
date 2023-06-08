<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//쿠키 삭제는 동일한 이름으로 시간을 0초 선언하면 삭제됨
	Cookie cookie = new Cookie("choco", "abc123"); // 이름이 같아야 함
	
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>쿠키는 이미 삭제되어있습니다.</h3>
	<a href = "cookie_get.jsp">쿠키 확인하기</a>
	
</body>
</html>