<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<h3>이 파일은 first.jsp입니다.</h3>
<%-- 	<jsp:forward page="second.jsp" /> --%>
	<!-- second.jsp?date=2022... -->
<%-- 	<jsp:forward page="second.jsp"> --%>
	<jsp:include page="second.jsp">
		<jsp:param name="date" value="<%=new Date() %>" />
	</jsp:include>
	<p>===first.jsp의 페이지======</p>
</body>
</html>