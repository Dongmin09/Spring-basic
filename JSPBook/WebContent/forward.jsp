<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 

저는 인클루드 써서 할게용
 -->
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h4>구구단 출력하기</h4><!-- 오예스-->
	<jsp:include page="forward_data.jsp">
		<jsp:param name="gugugugu" value="5" />
	</jsp:include>
</html>