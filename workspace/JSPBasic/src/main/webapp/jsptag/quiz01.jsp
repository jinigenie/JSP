<%@page import="java.util.HashSet"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 실행될 때마다 랜덤 로또번호를 저장하고 출력하는 프로그램 코드 작성
	HashSet<Integer> set = new HashSet();
	Random rd = new Random();
	
	while(set.size() < 6){
		set.add(rd.nextInt(45) + 1);	
	}

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	로또 번호 : <%=set.toString() %> <br/>
	
	로또 번호 : 
	[<%for(int a : set) {%>
		<%=a %>
	<% }%>]
	
</body>
</html>