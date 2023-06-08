<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//java로 세션 값 참조
	//String name = (String)session.getAttribute("name");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>세션값은 sessionScope 생략 가능하지만 적는 것이 좋다</h3>
	${sessionScope.name }<br/>
	${sessionScope.id }<br/>
	
	<hr>
	${applicationScope.count }<br>

</body>
</html>