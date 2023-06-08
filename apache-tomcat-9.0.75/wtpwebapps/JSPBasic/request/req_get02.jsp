<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id"); //input 태그의 name
	String pw = request.getParameter("pw");
	
	String[] agree = request.getParameterValues("agree"); //input태그의 복수 개의 값을 받을 때
	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 결과 페이지 </h3>
	아이디: <%=id %><br>
	비밀번호: <%=pw %><br>
	선택지: <%=Arrays.toString(agree) %><br>
	
	
	
</body>
</html>