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
<a href="${pageContext.request.contextPath}/member/joinForm">ȸ������</a><br>
<a href="<%=request.getContextPath()%>/hello/h1">HelloController</a><br>
<a href="${pageContext.request.contextPath}/hello/h1">HelloController</a><br>
<a href="${pageContext.request.contextPath}/method/method">method/method</a>
<!-- ���� �Ȱ��� -->
<a href="${pageContext.request.contextPath}/method/method">method/method</a>
</body>
</html>