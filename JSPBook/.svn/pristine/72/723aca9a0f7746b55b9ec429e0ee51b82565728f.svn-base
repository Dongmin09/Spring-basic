<%@page import="BookMarket.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="bookDAO" class="BookMarket.dao.BookRepository" 
scope="session"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>도서 상세 정보</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
	<%	
		
		String code = request.getParameter("code");	
		Book book = bookDAO.getBookByCode(code);
	%>
	<div class="container">
		<div class="row">
		
			<div class="col-md-6">
				<h3><%=book.getBookName() %></h3>
				<p><%=book.getDesciption() %></p>
				<p>
					<b>도서 코드 : </b>
					<span class="badge badge-danger">
					<%=book.getBookCode() %>
					</span>
				</p>
				<p><b>저자 : </b><%=book.getAuthor() %></p>
				<p><b>재고 수 : </b><%=book.getUnitInStock() %></p>
				<p><b>총 페이지 수 : </b><%=book.getWholePage() %></p>
				<p><b>출판일 : </b><%=book.getPublicationDate() %></p>
				<h4><%=book.getBookPrice()%></h4>
				<p><a href="#" class="btn btn-info">도서 주문&raquo;</a>
				<a href="Books.jsp" class="btn btn-secondary">도서 목록&raquo;</a>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	
</body>
</html>