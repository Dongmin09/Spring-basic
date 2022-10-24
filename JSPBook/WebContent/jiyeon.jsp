<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sripting Tag</title>
</head>
<body>
	Today :
	
		<%
			Date day = new Date();
			//스크립틀릿
			out.print(day + "<br />");
		%>
		
<!-- 		jsp를 생성하고 자바스크립틀릿을 사용하여 java.util.Date형 지역변수에 현재 날짜를 저장하여 출력하였습니다. -->

</body>
</html>