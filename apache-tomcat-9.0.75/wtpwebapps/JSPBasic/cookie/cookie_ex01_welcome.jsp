<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Cookie[] arr = request.getCookies();
	String id = ""; 

	if(arr != null){ //쿠키가 존재할 때 접근
		for(Cookie c : arr){
			
			if(c.getName().equals("user_id")) {
				id = c.getValue();
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>결과 페이지</h3>
	<!-- user_id 쿠키를 확인해서 "xxx님 환영합니다"로 출력 -->
	<%=id %>님 환영합니다.

</body>
</html>