<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>자바 빈 사용 예제</h1>
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="student" class="kr.co.jsplec.ex.Student" scope="page" />
	
	<jsp:setProperty name="student" property="name" value="suyoung" />
	<jsp:setProperty name="student" property="age" value="30" />
	<jsp:setProperty name="student" property="grade" value="A+" />
	<jsp:setProperty name="student" property="studentNum" value="17" />
	
	<jsp:getProperty name="student" property="name" />
	<jsp:getProperty name="student" property="age" />
	<jsp:getProperty name="student" property="grade" />
	<jsp:getProperty name="student" property="studentNum" />
</body>
</html>