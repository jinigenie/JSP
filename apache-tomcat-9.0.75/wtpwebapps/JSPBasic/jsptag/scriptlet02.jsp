<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 표현식 </h3>
	
	<%
	int a = 10;
	String str = "홍길동";
	
	%>

	<%
		out.println("이름: <b>" + a + "</b><br/>");
		out.println("이름: <b>" + str + "</b><br/>");
	%>

	나이: <b><%=a %></b><br/>
	이름: <b><%=str %></b><br/>
	
	<hr/>
	
	<%
		for(int i = 1 ; i <= 9; i++) {
			out.println(3 + " x " + i + " = " + 3 * i + "<br/>");
		}
	%>
	
	
	<hr/> 표현식으로 변경 <br/>
	
	
	<% for(int i = 1 ; i <= 9; i++) { %>
	
	3 x <%=i %> = <%=3*i %> <br/>
	<% } %>
	
	
	<hr/> 
	
	<!--  li를 반복문으로 생성하기 -->
	
	<ul> 
		<% for(int i = 1 ; i < 10; i++ ) {%>
			<li> <%=i %> </li>
		<% } %>	
	</ul>
	
	<hr/>
	
	<h3>반복문으로 체크박스에 1~20까지 이름을 붙여서 출력</h3>
	<% for(int i = 1 ; i <= 20; i++ ) {%>
			<input type= "checkbox" name= "demo"/> 상품 <%=i %>
	
	<% } %>	

	<!-- html 주석 : ctrl+shift+/  -->
	<%-- jsp 주석 : ctrl+shift+/  --%>
	
	
	
	
	
	
	
	
</body>
</html>