<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="kr.or.ddit.dto.Person"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<%
		//스크립트릿
			//List<Person> : Person 타입의 List 인터페이스
			//ArrayList<Person> : Person 타입의 ArrayList 클래스
			List<Person> personList = new ArrayList<Person>();
	%>
	<jsp:useBean id="person" class="kr.or.ddit.dto.Person" scope="page" />
	<%
		personList.add(person);
	
		//**동일한 데이터가 출력되지 않도록 처리해주기 위함
		person = new Person();
		
		person.setId(20182005);
		person.setName("개똥이");
		
		personList.add(person);
		//향샹된 for문
		for(Person row : personList){
			out.print("<p>아이디 : " + row.getId()   + "</p>");
			out.print("<p>이   름 : " + row.getName() + "</p>");
		}
	%>
</body>
</html>









