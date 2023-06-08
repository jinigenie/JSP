<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	StringBuffer url = request.getRequestURL();
	String uri = request.getRequestURI();
	String remote = request.getRemoteAddr();
	String header = request.getHeader("content-type");

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	context path(프로젝트 식별경로) : <%=path %><br/>
	url(전체 주소) : <%=url %><br/>
	uri(포트번호를 제외한 경로) : <%=uri %><br/>
	remote addr(요청 주소) : <%= remote %><br/>
	header_contentType(요청에 대한 문서타입) : <%= header %><br/>


</body>
</html>