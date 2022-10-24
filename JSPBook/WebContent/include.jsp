<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
   <%@include file="header.jsp" %>
   <%
      Date day = new Date();
      String am_pm;
      int hour = day.getHours();
      int minute = day.getMinutes();
      int second = day.getSeconds();
      if(hour/12==0){
    	  am_pm = "AM";
      }else{
    	  am_pm = "PM";
    	  hour = hour-12;
      }
      String CT = hour + ":" + minute + ":" + second + " " + am_pm;
      out.print("현재  시간 "+CT+"<br />");
   %>
</body>
</html>