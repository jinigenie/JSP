<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%

	//쿠키 생성 : new Cookie("이름(키)", "값")
	Cookie cookie = new Cookie("choco", "aaa123");
	Cookie cookie2 = new Cookie("banana", "바나나쿠키");

	//쿠키 시간 설정
	cookie.setMaxAge(1800); // 30분
	cookie2.setMaxAge(30);  //30초
	
	//쿠키 response에 저장
	response.addCookie(cookie);
	response.addCookie(cookie2);
	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href = "cookie_get.jsp">쿠키 확인하기</a>

</body>
</html>