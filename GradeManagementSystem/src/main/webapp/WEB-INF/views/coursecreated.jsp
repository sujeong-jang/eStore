<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${course.name} 수강 신청 완료 </br>
	
	<a href = "${pageContext.request.contextPath}/courses">수강신청목록 조회</a>
	<a href = "${pageContext.request.contextPath}">목록으로 돌아가기</a>
</body>
</html>