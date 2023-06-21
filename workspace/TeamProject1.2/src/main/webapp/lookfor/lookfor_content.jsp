<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file = "../include/header.jsp"%>
<div align="center" class="div_center">

	<form action="lookfor_delete.lookfor" method="post">
	<h3>잃어버린 아이를 찾습니다!</h3>
	<hr>
	<h5>♡잃어버린 우리 아이를 찾아주시면 반드시 사례하겠습니다!♡</h5>
	<table border="1" width="600">

		<tr>
			<td width="20%">글번호</td>
			<td width="25%">${vo.num }</td>

			<td width="20%">연락처</td>
			<td width="35%">${uvo.phone }</td>
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

	<table border="1" width="600">
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
				<input type="button" value="목록" onclick="location.href='lookfor_list.lookfor'">&nbsp;&nbsp; 
				<input type="button" value="수정" onclick="location.href='lookfor_modify.lookfor?num=${vo.num}'">&nbsp;&nbsp;
				<input type="submit" value="삭제" onclick="">&nbsp;&nbsp;</td>
		</tr>
	</form>
	</div>
	

	<br>

	<div>

		<table id="tblListComment" class="table table-bordered">

			<c:if test="${ clist.size() == 100 }">
				<tr>
					<td colspan="2">댓글이 없습니다.</td>
				</tr>
			</c:if>

			<c:forEach items="${ clist }" var="cdto">
				<tr>
					<td>${ cdto.content } <span>${ cdto.name }. ${ cdto.regdate }</span>
					</td>
					<td><input type="button" value="삭제하기" class="btn btn-default"
						onclick="location.href='/myapp/board/delcomment.do?seq=${ cdto.seq }&pseq=${ dto.seq }';" />
					</td>
				</tr>
			</c:forEach>
		</table>

		<form method="POST" action="">
			<table id="tblAddComment" class="table table-bordered">
				<tr>
					<td><input type="text" name="content" id="content"
						class="form-control" required placeholder="댓글을 작성하세요. " /></td>
					<td><input type="submit" value="댓글쓰기" class="btn btn-primary" /></td>
				</tr>
			</table>
			<input type="hidden" name="pseq" value="${dto.seq }" />
		</form>

	</div>
</div>

<%@include file = "../include/footer.jsp"%>