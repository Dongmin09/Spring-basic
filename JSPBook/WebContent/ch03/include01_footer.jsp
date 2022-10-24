<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String memId = request.getParameter("memId");
memId = URLDecoder.decode(memId);
%>
Copyright <%=memId%>