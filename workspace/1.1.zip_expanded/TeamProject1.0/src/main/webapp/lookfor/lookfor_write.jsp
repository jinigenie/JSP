<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>
<div align="center" class="div_center">
	<h3>실종 신고글 작성</h3>
	<hr>

	<form action="writeForm.lookfor" method="post">

		<table border="1" width="700">

			<tr>
				<td width="20%">동물 종류</td>
				<td><input type='radio' name='anymal' value='dog' /> 개 <input
					type='radio' name='anymal' value='cat' /> 고양이 <input type='radio'
					name='anymal' value='no' /> 기타</td>
			</tr>

			<tr>
				<td width="20%">잃어버린 시간</td>
				<td width="80%"><input type="date" name="date"><input
					type="time" name="time"></td>

			</tr>

			<tr>
				<td width="20%">잃어버린 장소</td>
				<td width="80%"><input type="text" name="area"></td>
			</tr>

		</table>

		<br>

		<table border="1" width="700">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="10"></td>

			</tr>

			<tr>
				<td width="20%">작성자</td>
				<td width="30%">${uvo.id }</td>

				<td width="20%">연락처</td>
				<td width="30%"><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td colspan="3" height="120px"><textarea rows="10"
						style="width: 95%;" name="content"></textarea></td>
			</tr>

			<tr>

				<td colspan="3"><input type="file" name="fileName"></td>
			</tr>

		</table>
		
		<br>
		<td colspan="2"><input type="submit" value="작성 완료"
			onclick="location.href='writeForm.lookfor'"> &nbsp;&nbsp; 
			<input type="button" value="목록" onclick="location.href='lookfor_list.lookfor'"></td>
	</form>

</div>
<%@include file = "../include/footer.jsp"%>