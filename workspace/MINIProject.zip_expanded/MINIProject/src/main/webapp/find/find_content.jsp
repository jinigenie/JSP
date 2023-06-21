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
	
	
	<hr>
	<div>
		
	
	</div>
		<style>
		div.card {
			margin: 10px;
			padding: 20px;
			width: 500px;
			overflow: auto;
		}
		div.card1{
		display:flex;
		justify-content: space-between;
		
		}
		div.card2 {
			margin: 10px;
			padding: 20px;
			width: 600px;
			overflow: auto;
		}
	</style>
	
	<div  class="card" align="right"  >
		<div class="card-header" align="left"><h3>댓글 리스트</h3></div>
	<c:forEach items="${listcomment }" var="reply">
	<fmt:formatDate var = "time" value="${reply.regdate }" pattern="yyyy-MM-dd (E) hh시mm분"/>
		<ul id="reply--box" class="list-group">
		<div class="card1">
			<div><span>작성자 - [${reply.id }]</span></div> 
			<div><span>작성시간 - ${time}</span></div>
		</div>	
			<li id="reply--1" class="list-group-item d-flex justify-content-between">
				<div align="left">${reply.body }</div>
				
				<div class="d-flex">
					<button  type= "button" class="badge" onclick="location.href='findreply_del.com?idx=${reply.idx}&num=${vo.num }'">삭제</button>
				</div>
			</li>

		</ul>
			</c:forEach>
	</div>
	
	<div class="card2" align="center">
     <form action="<%=request.getContextPath() %>/find/reply.com" method="post" align="center">
			<input type = "hidden" name= "content_num" value="${vo.num  }" />
			<input type = "hidden" name= "id" value="${user_id  }" />
		<div class="card-body"align="center">
			<textarea id="body" class="form-control" rows="1" style="width: 500px; height: 104px;" ></textarea>
		</div>
		<div class="card-footer">
			<button type="submit" id="btn-reply-save" class="btn btn-primary">등록</button>
		</div>
		</form>
	</div>
</div>
    
    
	
<%@include file = "../include/footer.jsp"%>
