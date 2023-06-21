<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>

<div align="center" class="div_center">
	<h3>동물 발견 신고서</h3>
	<hr>

	<form action="writerForm.find" method="post">
		<table border="1" width="700">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="10"></td>
				<td>작성자</td>
				<td><input type="text" name="id" size="10"  value="${vo.id }"
						readonly="readonly"></td>

			</tr>
			<tr>
				<td>발견 시간</td>
				<td width="300"><input type="date" name="date"><input
					type="time" name="time"></td>
				<td width="20%">신고자 연락처</td>
				<td width="30%"><input type="text" name="phone" value="${vo.phone }"></td>
			</tr>
			<tr>
				<td>동물 종류</td>
				<td><input type='radio' name='anymal' value='dog' /> 개 <input
					type='radio' name='anymal' value='cat' /> 고양이 <input type='radio'
					name='anymal' value='no' /> 모름</td>

				<td>발견 장소</td>
				<td><input type="text" name="area"></td>

			</tr>

			<tr>
				<td width="20%">내용</td>
				<td colspan="3" height="120px"><textarea rows="10"
						style="width: 95%;" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성 완료" onclick="location.href='writerForm.find'">
					&nbsp;&nbsp; <input type="button" value="목록""></td>
					<td colspan="3"><input type="file" name="fileName" ></td>
			</tr>

		</table>
		
		</form>
		
	</div>
<%@include file = "../include/footer.jsp"%>