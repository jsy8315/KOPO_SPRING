<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="kr.co.jsp_23.Memberinfo" scope="page" />
<jsp:setProperty name="member" property="name" value="정수영"/>
<jsp:setProperty name="member" property="id" value="abc"/>
<jsp:setProperty name="member" property="pw" value="123"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	이름: <jsp:setProperty name="member" property="name" value="정수영"/>
	아이디: <jsp:setProperty name="member" property="id" value="abc"/>
	비밀번호: <jsp:setProperty name="member" property="pw" value="123"/>
	<hr />
	이름: ${pageScope.member.name }<br />
	아이디: ${member.id }<br />
	비밀번호:  ${member.pw }<br />
</body>
</html>