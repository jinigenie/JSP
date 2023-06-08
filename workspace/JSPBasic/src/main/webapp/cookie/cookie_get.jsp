<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//쿠키는 생명주기가 다할때까지 모든 페이지에서 사용 가능
	//요청이 들어올 때마다 쿠키는 자동으로 전송됨
	
	Cookie[] arr = request.getCookies();
	
	if(arr != null){ //쿠키가 존재할 때 접근
		for(Cookie c : arr){
			
			String name = c.getName();
			String value = c.getValue();
			
			out.println(name + "-" + value + "<br>");
			
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

	<a href = "cookie_remove.jsp">쿠키 삭제하기</a>

</body>
</html>