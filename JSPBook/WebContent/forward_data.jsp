<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<%
		int number = Integer.parseInt(request.getParameter("gugugugu"));
		
		for(int i=1;i<=9;i++){
			out.print("<p>"+number+"*"+i+"="+(number*i)+"<br />");
		}
	%>
<%-- 	<p><%=number%> * 1  = <%=number *1 %> </p> --%>
<%-- 	<p><%=number%> * 2  = <%=number *2 %> </p> --%>
<%-- 	<p><%=number%> * 3  = <%=number *3 %> </p> --%>
<%-- 	<p><%=number%> * 4  = <%=number *4 %> </p> --%>
<%-- 	<p><%=number%> * 5 = <%=number * 5 %> </p> --%>
<%-- 	<p><%=number%> * 6  = <%=number *6 %> </p> --%>
<%-- 	<p><%=number%> * 7  = <%=number *7 %> </p> --%>
<%-- 	<p><%=number%> * 8  = <%=number *8 %> </p> --%>
<%-- 	<p><%=number%> * 9  = <%=number *9 %> </p> --%>
</body>
</html>