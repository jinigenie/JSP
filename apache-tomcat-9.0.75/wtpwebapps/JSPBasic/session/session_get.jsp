<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//세션 값 사용
	//한 번 생성 되었으면, 어디서든 기본값(30분)까지 사용 가능
	String id = (String)session.getAttribute("user_id");
	String name = (String)session.getAttribute("user_name");
			
	//시간 확인
	int time = session.getMaxInactiveInterval();
	
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	세션에 저장된 user_id: <%=id %><br>
	세션에 저장된 user_name: <%=name %><br>
	세션의 유지시간: <%=time %>
	
</body>
</html>