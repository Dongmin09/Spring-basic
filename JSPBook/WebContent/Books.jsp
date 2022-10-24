<%@page import="BookMarket.dto.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="bookDAO" class="BookMarket.dao.BookRepository" scope="session" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>도서 목록</title>
</head>
<body>
	
	<jsp:include page="./menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	<%
		List<Book> listOfBooks = bookDAO.getAllBook();
	%>
	<div class= "contatiner">
	<div class="cols">
		<%	
				for(Book book : listOfBooks){
		%>
			<div>
				<h3><%=book.getBookName() %></h3>
				<p><%=book.getDesciption() %></p>
				<p><%=book.getBookPrice() %>원</p>
				<p><a href="Book.jsp?code=<%=book.getBookCode()%>"
						class="btn btn-secondary" role="button">
						도서정보&raquo;></a>
				</p>
			</div>
			<hr>
			<br><br>
			<% 		
				}
			%>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>