<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	Double h = Double.parseDouble(request.getParameter("cm"));
	Double w = Double.parseDouble(request.getParameter("kg"));
	Double bmi = w / (h/100 * h/100);
%> 
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	이름: <%=name %><br>
	키: <%=h %><br>
	몸무게: <%=w %><br>
	BMI 지수: <%=bmi %><br> 
	
	<%if(bmi >= 25) {%> 
	과체중 
	<%} else if( bmi <= 18) {%> 
	저체중
	<%} else{ %> 
	정상
	<%} %>
	

</body>
</html>