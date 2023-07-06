<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print("로그아웃합니다 : 세션 전체 삭제");
		session.invalidate();
	%>
	<form action="login.html" method="post">
		<input type="submit" name="submit" value="다시 로그인하기"><br>
	</form>
</body>
</html>