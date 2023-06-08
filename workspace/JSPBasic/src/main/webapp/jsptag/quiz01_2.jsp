<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 
 	int[] arr = new int[6];
 	
 	for(int i = 0 ; i < arr.length ; i++){
 		arr[i] = (int)(Math.random() * 45) + 1;
 		for(int j = 0; j < i; j++){
 			if(arr[i] == arr[j]){
 				i--;
 				break;
 			}
 		}
 		
 	}
 
 
 %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	로또 번호 : <%= Arrays.toString(arr) %>

</body>
</html>