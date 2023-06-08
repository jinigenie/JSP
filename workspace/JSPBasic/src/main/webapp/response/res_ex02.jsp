<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<style type="text/css">
		/*css문법*/
		
		body {
			padding: 0;
			margin: 0;
			
		}
		
		.wrap {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			
		}
		#btn {
			width: 100%;
			background: #FFCCCC;
			border:none;
			margin-top: 10px;
			
		}
	
	</style>
</head>
<body>

	<!-- 
	디자인
	인라인스타일시트 style 속성을 사용하여 태그에 디자인을 주는 방법
	내부스타일시트 태그에 class 속성을 생성하고, head 태그에서 디자인을 태그에 적용하는 방법
	
	id 속성은 화면에서 유니크해야 할 때 사용 -> id는 #으로 접근
	class 속성은 동일한 이름을 사용해도 됨 -> class는 .으로 접근
	
	 -->
	<div class="wrap">
		<form action="res_ex02_result.jsp" method="post" class="box">
		
			<h3 style="color: #CC99FF; text-align: center;">로그인 폼</h3>
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pw" placeholder="비밀번호"><br>
			<input type="submit" value="로그인" id="btn">		
		
		</form>
	</div>

</body>
</html>