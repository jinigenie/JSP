<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt"%>      
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
	fmt는 형변환을 다루는 기능이 있음
	
	Integer.parseInt() : string -> int
	parse => 다른 타입으로 형변환
	format => 같은 타입의 형태를 반환
	
	-->
	
	<h3>formatNumber, parseNumber, formatDate, parseDate</h3>
	
	----------------------------------------------------------------------------------
	<h3>formatDate => (날짜 데이터를 날짜 형식으로 변환)</h3>
	
	<c:set var="a" value="<%=new Date() %>"/>
	${a }<br>
	
	<fmt:formatDate value="${a }" pattern="yyyy년 MM월 dd일 / HH시 mm분 ss초"/><br>
	
	<fmt:formatDate var="a01" value="${a }" pattern="yyyy년 MM월 dd일 / HH시 mm분 ss초"/>
	<fmt:formatDate var="a02" value="${a }" pattern="yyyy-MM-dd"/>
	${a01 }<br>
	${a02 }<br>

	----------------------------------------------------------------------------------
	
	<h3>parseDate => (문자데이터를 날짜 형식으로 변환)</h3>
	
	<fmt:parseDate value="2023-06-07" pattern="yyyy-MM-dd"/><br>
	<fmt:parseDate value="2023년 06월 07일 15시 28분 03초" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/><br>

	----------------------------------------------------------------------------------
	
	<h3>formatNumber => (숫자데이터를 숫자 형식으로 변환)</h3>
	
	<c:set var="b" value="20000"/>
	<fmt:formatNumber value="${b }" pattern="00,000원" /><br>
	<fmt:formatNumber value="${b }" pattern="0.00" /><br>

	----------------------------------------------------------------------------------
	
	<h3>parseNumber => (문자데이터를 숫자 형식으로 변환)</h3>
	
	<fmt:parseNumber value="20,000원" pattern="00,000원"/><br>
	<fmt:parseNumber value="123abc" pattern="000abc"/><br>
	
	<hr/>
	
	<h3>2020년 05월 03일로 변경해서 출력</h3>
	<fmt:parseDate var="TIME_A" value="2020/05/03" pattern="yyyy/MM/dd" />
	<fmt:formatDate value="${TIME_A }" pattern="yyyy년 MM월 dd일" /><br>
	
    <fmt:parseDate var="TIME_C" value="2020-05-03 21:30:22" pattern = "yyyy-MM-dd HH:mm:ss"/>
    <fmt:formatDate value="${TIME_C }" pattern="yyyy년 MM월 dd일" /><br>
    
    <c:set var="TIME_D" value="<%=new Date() %>"/>
    <fmt:formatDate value="${TIME_D }" pattern = "yyyy년 MM월 dd일"/> 

	
	
	
</body>
</html>