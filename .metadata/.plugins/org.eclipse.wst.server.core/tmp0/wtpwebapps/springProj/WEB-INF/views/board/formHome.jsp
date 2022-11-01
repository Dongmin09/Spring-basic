<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>formHome</title>
</head>
<body>
	<!-- method속성이 생략 시 기본 method는 get  -->
	<form action="/board/register2">
		<input type="text" name="name" value="${name}">
		<input type="submit" value="register(GET)" />
	</form>
	<hr />
	<!-- method속성이 생략 시 기본 method는 get  -->
	<form action="/board/register2" method="post">
		<input type="text" name="name" value="${name}">
		<input type="submit" value="register(POST)" />
	</form>
	<hr />
	
	<h2>Params 메핑</h2>
	<p><a href="/board/get?register">Register</a></p>
	<p><a href="/board/get?modify">Modify</a></p>
	<p>
		<form action="/board/post" method="post">
			<button type="submit" name="register">Register</button>
		</form>
	</p>
	<p>
		<form action="/board/post" method="post">
			<button type="submit" name="modify">modify</button>
		</form>
	</p>
	
</body>
</html>