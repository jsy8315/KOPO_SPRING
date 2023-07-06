<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	파라미터 받음: <c:out value="${param.name }" />
	<hr>
	
	<c:set var="mName" value="정수영" />
		이름: <c:out value="정수영" /><br/>
	이름: <c:out value="${mName }" /><br />
	<hr>	
	
	<c:forEach var="mYear" begin="0" end="40" step="3">
		${fEach}
	</c:forEach>
	<hr>
	
	<c:if test="${1+2==3}>">
		1 + 2 = 3 결과입니다.
	</c:if>
	<hr>
	
</body>
</html>