<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script language="JavaScript" src="members.js"></script>
<title>join.jsp</title>
</head>
<body>
<h1>회원가입 ver02 - 인증기능 추가</h1>
	<form action="joinOk.jsp" method="post" name="reg_frm">
		아이디&nbsp;<input type="text" name="id" size="20"><br />
		비밀번호&nbsp;<input type="password" name="pw" size="20"><br />
		비밀번호 확인&nbsp;<input type="password" name="pw_check" size="20"><br />
		이름&nbsp;<input type="text" name="name" size="10"><br>
		성별&nbsp;<br>
			남<input type="radio" name="gender" value="man">
			여<input type="radio" name="gender" value="woman"><br>
		전화번호&nbsp;<input type="text" name="phonenumber" size="50"><br>
		<input type="button" value="회원가입" onclick="infoConfirm()">
			<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>