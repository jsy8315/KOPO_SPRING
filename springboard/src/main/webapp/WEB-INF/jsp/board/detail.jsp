<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세 게시글임

	<div align="center">
		<table border="1" width="60%">
			<tr>
				<th>번호</th>
				<td>${boardVO.no}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${boardVO.title}</td>
			</tr>
			<tr>
				<th>지은이</th>
				<td>${boardVO.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${boardVO.regDate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardVO.content}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${boardVO.count}</td>
			</tr>
		</table>
	</div>
</body>
</html>