<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정 결과화면</h1>
	<%=session.getAttribute("name") %>님의 회원정보 수정이 정상 처리되었습니다. <br />
	<a href="logout.jsp">로그아웃</a><br />
	<a href="modify.jsp">추가 회원정보수정</a>
</body>
</html>