<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="kr.or.ddit.dto.Calculator"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<!-- 자바빈즈 액션스크립트 -->
	<!-- 자바빈즈 : 객체 / 자바빈클래스 : 클래스 -->
	<jsp:useBean id="bean" class="kr.or.ddit.dto.Calculator" />
	<%//스크립트릿
// 		Calculator bean = new Calculator();
	
		int m = bean.process(5);
		
		out.print("5의 3제곱 : " + m);
	%>
</body>
</html>