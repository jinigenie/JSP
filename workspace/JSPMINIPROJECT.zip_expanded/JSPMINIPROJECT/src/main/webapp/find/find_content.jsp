<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="600">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.num }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${vo.hit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.writer }</td>
			
			<td>작성일</td>
			<td ><fmt:formatDate value="" pattern="yyyy-MM-dd (E) hh시mm분"/></td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px"></td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='board_list.board'">&nbsp;&nbsp;
				<input type="button" value="수정" onclick="location.href='board_modify.board?bno='">&nbsp;&nbsp;
				<input type="button" value="삭제">&nbsp;&nbsp;
			</td>
		</tr>
	</table>

<div>

	<table id="tblListComment" class="table table-bordered">
		
		<c:if test="${ clist.size() == 100 }">
			<tr>
				<td colspan="2">댓글이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach items="${ clist }" var="cdto">
			<tr>
				<td>
					${ cdto.content }
					<span>${ cdto.name }. ${ cdto.regdate }</span>
				</td>
				<td>
					<input type="button" value="삭제하기" class="btn btn-default" 
						onclick="location.href='/myapp/board/delcomment.do?seq=${ cdto.seq }&pseq=${ dto.seq }';"/>
				</td>
			</tr>
		</c:forEach>	
	</table>
	
	<form method="POST" action="">
		<table id="tblAddComment" class="table table-bordered">
			<tr>
				<td><input type="text" name="content" id="content" class="form-control" required placeholder="댓글을 작성하세요. "/></td>
				<td><input type="submit" value="댓글쓰기" class="btn btn-primary"  /></td>
			</tr>
		</table>
		<input type="hidden" name="pseq" value="${ dto.seq }" />
	</form>
	
</div>
</div>

