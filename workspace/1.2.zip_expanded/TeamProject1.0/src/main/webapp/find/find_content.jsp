<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file = "../include/header.jsp"%>
<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="700">

		<tr>
			<td width="20%">글번호</td>
			<td width="25%">${vo.num }</td>

			<td width="20%">연락처</td>
			<td width="35%">${vo.ph }</td>
		</tr>

		<tr>
			<td width="20%">동물 종류</td>
			<td width="30%">${vo.type }</td>

			<td width="20%">잃어버린 날짜</td>
			<td width="30%"><fmt:parseDate var = "B" value="${vo.time }" pattern="yyyy-MM-dd HH:mm" />
						<fmt:formatDate value="${B }" pattern="yyyy-MM-dd (E) hh시mm분" /></td>
		</tr>
	</table>

	<br>

	<table border="1" width="700">
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.content }</td>
		</tr>
	</table>

	<br>

	<div>
		<tr>
			<td colspan="4" align="center">
			<input type="button" value="목록" onclick="location.href='find_list.find'">&nbsp;&nbsp; 
			<inputtype="button" value="수정" onclick="location.href='board_modify.board?bno='">&nbsp;&nbsp;
				<input type="button" value="삭제">&nbsp;&nbsp;</td>
		</tr>
	</div>

	<hr>
	<h3>댓글</h3>
		<hr>
	<c:forEach items="${listcomment }" var="reply">
		<div>
			글쓴이 : ${reply.id }<br/>
			내용 : ${reply.body }<br/>
			시간 : ${reply.regdate }<br/>
		</div>
		<hr>
	</c:forEach>
	
	<hr>
	<div>
		<form action="<%=request.getContextPath() %>/find/reply.com" method="post">
			${user_id }<br/>
			<input type = "text" name = "body" placeholder="댓글을 남겨주세요">
			<input type = "hidden" name= "content_num" value="${vo.num  }" />
			<input type = "hidden" name= "id" value="${user_id  }" />
			<input type = "submit" value="등록"/>
		</form>
	
	</div>
	 
	
	
	
</div>
<%@include file = "../include/footer.jsp"%>
