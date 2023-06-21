<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>
<section>


	<div align="center"><!-- 문자를 가운데로 -->
	
	<h3>회원가입</h3>
	
		<form action="joinForm.user" method="post">
			<table border="1">
			
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required" pattern="\w{3,}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" required="required" pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>핸드폰 번호</td>
					<td><input type="text" name="phone" required="required" pattern="\w{3,}"></td>
				</tr>
				
			</table>
			
			<div style="color:red;">${msg }</div>
			
			<input type="submit" value="가입">
			<input type="reset" value="정보초기화">
		</form>
	</div>

</section>

<%@include file = "../include/footer.jsp"%>