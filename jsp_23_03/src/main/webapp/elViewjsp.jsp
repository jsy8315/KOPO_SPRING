<%@ page language="java" contentType="text/html; pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ELJstl_view 페이지</title>
</head>
<body>
	이름은 ${param.name}입니다. <br><br>
	선택한 과목은 ${paramValues['lang']}

</body>
</html>
