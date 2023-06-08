<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- a태그 사용해서 req_get01페이지로 상대경로 -->
	<a href="../../request/req_get01.jsp">req_get01(상대)</a><br>
	
	<!-- a태그 사용해서 req_get01페이지로 절대경로 -->
	<a href="/JSPBasic/request/req_get01.jsp">req_get01(절대)</a><br>
	
	<!-- a태그 사용해서 DemoServlet으로 상대경로(맵핑 경로로 확인) -->
	<a href="../../banana">req_get01(상대)</a><br>
	
	<!-- a태그 사용해서 DemoServlet으로 절대경로 -->
	<a href="/JSPBasic/banana">DemoServlet(절대1)</a><br>
	<a href="<%=request.getContextPath() %>/banana">DemoServlet(절대2)</a><br>

	<!-- jsptag 폴더 밑에 있는 이미지. img 태그로 -->
	<img src="/JSPBasic/jsptag/1.jpg" alt="토끼">

	<!-- contextPath는 톰캣이 프로젝트를 구분하는 경로 -->


</body>
</html>