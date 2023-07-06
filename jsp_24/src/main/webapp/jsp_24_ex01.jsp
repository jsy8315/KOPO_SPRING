<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="vatName" value="정수영"/>
	vatName : <c:out value="${vatName }"/>
	<br />
	<c:remove var="vatName" />
	vatName : <c:out value="${vatName }"/></h3>
	
	<hr />
	
	<c:catch var="error">
		<%= 2/0 %>
	</c:catch>
	<br />
	<c:out value="${error }"/>
	
	<hr />
	
	<c:if test="${1+2==3}>">
		1 + 2 = 3 결과입니다.
	</c:if>
	
	<hr />
	
	<c:set var="varName" value="박경덕" />
	<c:choose>
		<c:when test="${varName == '정수영' }">when: 정수영</c:when>
		<c:otherwise>when: 다른 사람</c:otherwise>
	</c:choose>
	
	<hr />
	
	<c:forEach var="fEach" begin="0" end="30" step="3">
		${fEach} 
	</c:forEach><p>
	
	<%
		List<String> fruits = new ArrayList<String>();
	
		fruits.add("사과");
		fruits.add("배");
		fruits.add("바나나");
		fruits.add("감");
		fruits.add("귤");
		
		pageContext.setAttribute("aFruits", fruits);
	%>
	<ul>
	<c:forEach var="result" items="${aFruits }">
		<li>${result }</li>
	</c:forEach><p>
	
	</ul>
	
	<%
		pageContext.setAttribute("aEach", "정수영, 박경덕, 박준하");
	%>
	<ul>
		<c:forEach var="result" items="${aEach }">
			<li>${result }</li>
		</c:forEach><p>
	</ul>
	<hr/>
	
	<!-- redirect 사용 예 -->
	<c:redirect url="ex1.jsp">
		<c:param name="name" value="정수영" />
	</c:redirect>
	<hr/>
</body>
</html>