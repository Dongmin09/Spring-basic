<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
	<%//스클립틀릿
		/*
			httpSession.setAttribute("userID", user_id);	//admin
			httpSession.setAttribute("userPW", user_pw);	//java
		*/
		//Object하위의 String 형으로 다운캐스팅
		String user_id = (String)session.getAttribute("userID");	//admin
		String user_pw = (String)session.getAttribute("userPW");	//java
		
		out.print("설정된 세션의 속성 값[1] : " + user_id + "<br />");
		out.print("설정된 세션의 속성 값[2] : " + user_pw + "<br />");
	%>
</body>
</html>




