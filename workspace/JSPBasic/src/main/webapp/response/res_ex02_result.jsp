<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("aaa123") && pw.equals("1234")){
		response.sendRedirect("res_ex02_ok.jsp");
	} else response.sendRedirect("res_ex02_no.jsp");



%>
