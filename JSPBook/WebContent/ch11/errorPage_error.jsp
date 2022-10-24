<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<p>오류가 발생했습니다.</p>
	<!-- P.361 -->
	<!-- exception : JSP에서 제공해주는 오류 처리용 기본 내장 객체 -->
	<!-- <exception-type>java.lang.NullPointerException</exception-type> -->
	<p>예외 유형 : <%=exception.toString()%></p>
	<p>예외 유형 : <%=exception.getClass().getName()%></p>
	<p>오류 메시지 : <%=exception.getMessage()%></p>
</body>
</html>








