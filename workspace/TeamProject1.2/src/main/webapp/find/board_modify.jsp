<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center" class="div_center">
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="" method="post">
		
		<table border="1" width="500">
			
			<tr>
			<%-- 	<td>글 번호</td>
				<td>${vo.bno }</td> --%>
				<!-- 
				화면에서는 굳이 보여질 필요가 없지만 데이터는 넘어가야됨
				이때 사용 될 옵션은 input태그의 hidden속성을 쓴다 
				hidden은 폼태그 어디에서도 존재할수 있다. 단 화면에는 안보임-->
				<input type="hidden" name ="bno" value="">
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="" readonly></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="title" value="">
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content">${vo.content }
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록">        
				</td>
			</tr>
			
		</table>
		
	</form>
			
</div>
