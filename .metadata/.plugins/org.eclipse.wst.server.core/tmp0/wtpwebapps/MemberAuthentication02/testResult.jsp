<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">

<meta http=equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 확인</title>
</head>
<body>
    <h1>회원 정보</h1>
    <p>ID: <%= request.getAttribute("id") %></p>
    <p>Email: <%= request.getAttribute("mail") %></p>
    <p>Name: <%= request.getAttribute("name") %></p>
    <p>Mobile: <%= request.getAttribute("cp") %></p>
</body>
</html>
