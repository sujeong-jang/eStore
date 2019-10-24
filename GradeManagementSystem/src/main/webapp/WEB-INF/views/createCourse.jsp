<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type = "text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
		
<sf:form method = "post" action = "${pageContext.request.contextPath}/docreate" modelAttribute="course">
			<table class = "formtable">
				<tr> <td class="label">Year: </td> <td> <sf:input  type="text" path = "year"/> <br>
					<sf:errors path="year" class="error"/> </td> </tr>
				<tr> <td class="label">Semester: </td> <td> <sf:input  type="text" path = "semester"/> <br>
				 <sf:errors path="semester" class="error"/> </td> </tr>
				<tr> <td class="label">Code: </td> <td> <sf:input  type="text" path = "code"/><br>
				<sf:errors path="code" class="error"/> </td> </tr>
				<tr> <td class="label">Name: </td> <td> <sf:input  type="text" path = "name"/><br>
				<sf:errors path="name" class="error"/> </td> </tr>
				<tr> <td class="label">Level: </td> <td> <sf:input  type="text" path = "level"/><br>
				<sf:errors path="level" class="error"/> </td> </tr>
				<tr> <td class="label">Credit: </td> <td> <sf:input  type="text" path = "credit"/><br>
				<sf:errors path="credit" class="error"/> </td> </tr>
				<tr><td></td><td><input type = "submit" value = "수강신청"></td></tr>
			</table>
		</sf:form>
</body>
</html>