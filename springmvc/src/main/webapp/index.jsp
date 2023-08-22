<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
index<br>
<a href="${pageContext.request.contextPath}/member/joinForm">회원가입</a><br>
<a href="<%=request.getContextPath()%>/hello/h1">HelloController</a><br>
<a href="${pageContext.request.contextPath}/hello/h1">HelloController</a><br>
<a href="${pageContext.request.contextPath}/method/method">method/method</a>
<!-- 둘이 똑같음 -->
<a href="${pageContext.request.contextPath}/method/method">method/method</a>
</body>
</html>