<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<title>Spring Form</title>


</head>
<body>
<!-- modelAttribute 속성에 폼 객체의 속성명을 지정함  -->
<!-- 폼 객체 속성 명(model.addAttribute("member", new CustomerVO())) 과 
	스프링 폼태그의  modelAttribute 속성값은 동일해야함 -->
<form:form modelAttribute="custVO" method="post" action="register">
	<table>
		<tr>
			<th><form:label path="cumId">유저</form:label></th>
			<td>
				<!-- <input type = "text" name="cumId" />-->
				<form:hidden path="cumId"/>****
				<%-- <font color="red"><form:errors path="cumId" /></font> --%>
			</td>
		</tr>
		<tr>
			<th><form:label path="cumName">이름</form:label></th>
			<td>
				<!-- <input type = "text" name="cumName" /> -->
				<form:input path="cumName"/>
				<font color="red"><form:errors path="cumName" /></font>
			</td>
		</tr>
		<tr>
			<th><form:label path="password">비밀번호</form:label></th>
			<td>
				<!-- <input type = "text" name="password" /> -->
				<form:password path="password"/>
				<font color="red"><form:errors path="password" /></font>
			</td>
		</tr>
		<tr>
			<th>소개</th>
			<td>
				<!-- <input type = "text" name="introduction" /> -->
				<form:textarea path="introduction" rows="6" cols="30"/>
			</td>
		</tr>
		<tr>
			<th>취미(hobbyList)</th>
			<td>
				<!-- <input type = "text" name="introduction" /> -->
				<form:checkboxes path="hobbyList" items="${hobbyMap}"/>
			</td>
		</tr>
		<tr>
			<th>개발자여부</th>
			<td>
				<!-- <input type = "text" name="introduction" /> -->
				<form:checkbox path="developer" value="Y"/>
			</td>
		</tr>
<%-- 	<tr>
			<th>성별</th>
			<td>
				<!-- <input type = "text" name="introduction" /> -->
				<form:radiobuttons path="gender" items="${genderMap}"/>
			</td>
		</tr> --%>
		<tr>
	         <th>성별</th>
	         <td>
	         <!-- private String gender; -->
	            <form:radiobutton path="gender" value="Male" label="Male" />
	            <form:radiobutton path="gender" value="Female" label="Female" />
	            <form:radiobutton path="gender" value="Other" label="Other" />
	         </td>
       </tr>
		<tr>
			<th>외국인여부</th>
			<td>
				<!-- <input type = "text" name="introduction" /> -->
				<form:checkbox  path="foreigner" value="false"/>
			</td>
		</tr>
<%-- 		<tr>
			<th>국적</th>
			<td>
				<!-- private String nationality /> -->
				<form:select path="nationlity" items="${nationalityMap}"/>
			</td>
		</tr> --%>
		<tr>
			<th>국적</th>
			<td>
				<!-- private String nationality /> -->
				<select id="nationlity" name="nationlity" >
					<option value="korea">korea</option>
					<option value="Germany">Germany</option>
					<option value="Australia">Australia</option>
				</select>
			</td>
		</tr>
	</table>
	<form:button name="register">등록</form:button>
</form:form>
<script type="text/javascript">
CKEDITOR.replace("introduction");

</script>

</body>
</html>