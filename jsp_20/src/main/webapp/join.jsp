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
<h1>ȸ������ ver02 - ������� �߰�</h1>
	<form action="joinOk.jsp" method="post" name="reg_frm">
		���̵�&nbsp;<input type="text" name="id" size="20"><br />
		��й�ȣ&nbsp;<input type="password" name="pw" size="20"><br />
		��й�ȣ Ȯ��&nbsp;<input type="password" name="pw_check" size="20"><br />
		�̸�&nbsp;<input type="text" name="name" size="10"><br>
		����&nbsp;<br>
			��<input type="radio" name="gender" value="man">
			��<input type="radio" name="gender" value="woman"><br>
		��ȭ��ȣ&nbsp;<input type="text" name="phonenumber" size="50"><br>
		<input type="button" value="ȸ������" onclick="infoConfirm()">
			<input type="reset" value="���" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>