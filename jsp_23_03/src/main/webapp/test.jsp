<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="Memberinfo" class="kr.co.jsp_23.Memberinfo" scope="page" />
<jsp:setProperty name="Memberinfo" property="name" value="정수영"/>
<jsp:setProperty name="Memberinfo" property="id" value="abc"/>
<jsp:setProperty name="Memberinfo" property="pw" value="123"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    이름: <jsp:getProperty name="Memberinfo" property="name"/><br />
    아이디: <jsp:getProperty name="Memberinfo" property="id"/><br />
    비밀번호: <jsp:getProperty name="Memberinfo" property="pw"/><br />
    <hr />
    이름: ${Memberinfo.name }<br />
    아이디: ${Memberinfo.id }<br />
    비밀번호: ${Memberinfo.pw }<br />
</body>
</html>
