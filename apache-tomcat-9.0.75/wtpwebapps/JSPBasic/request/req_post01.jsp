<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 포스트방식으로 하면 주소에 데이터가 보이지 않음 -->
	<!-- 포스트방식은 반드시 form태그 필요, method="post"로 작성 -->
	
	<form action ="req_post02.jsp" method="post">
		주민번호: <input type="text" name="ssr"><br>
		비밀번호: <input type="password" name="pw"><br>
	
		<input type="submit" value="전송">
	</form>


</body>
</html>