<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	int count = 0;

	//누적 기능
	if(application.getAttribute("count") != null) {
		count = (int)application.getAttribute("count");
	}

	count++;
	
	//application 객체는 session과 사용방법이 동일
	application.setAttribute("count", count);

	//값의 사용
	int total = (int)application.getAttribute("count");
	

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	결과: <%=total %>
	
</body>
</html>