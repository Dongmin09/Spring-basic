<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>오류발생</title>
</head>
<body>
<!-- 오류 타입 -->
<%=exception.getClass().getName()%>
<!-- 오류 메시지 -->
<%=exception.getMessage() %>
<img src="/images/error.jpg" />
</body>
</html>