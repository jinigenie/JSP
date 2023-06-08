<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("utf-8"); //포스트방식의 한글 처리
	String ssr = request.getParameter("ssr");
	String pw = request.getParameter("pw");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	주민번호: <%=ssr %><br>
	비밀번호: <%=pw %>

</body>
</html>