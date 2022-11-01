<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%//스크립틀릿
	//http://localhost/deleteCart.jsp?cartId=0E079055C0EAEFC168D164247BF31686
	//요청 파라미터 cartId를 받자
	String id =
	request.getParameter("cartId");	//0E079055C0EAEFC168D164247BF31686 <= session.getId()
	//cartId가 없네? => cart.jsp이동
	if(id==null || id.trim().equals("")){
		response.sendRedirect("cart.jsp");
		return;
	}
	
	session.invalidate();	
	
	response.sendRedirect("cart.jsp");
%>