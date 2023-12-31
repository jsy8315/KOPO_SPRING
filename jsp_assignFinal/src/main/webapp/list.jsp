<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP 게시판</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #e6e6e6;
        }
    </style>
</head>
<body>
    <h1>게시판 글 목록</h1>
    <table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="dto">
                <tr>
                    <td>${dto.bId}</td>
                    <td>${dto.bName}</td>
                    <td>
                    	<c:forEach begin="1" end="${dto.bIndent }">-</c:forEach>
                    	<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a>
                    	<!-- 글의 제목을 클릭하면 글 확인/수정/삭제/답글이 가능하도록 가능 -->
                    	<!-- id에 해당하는 글 꺼내도록 -->
					</td>
                    <td>${dto.bDate}</td>
                    <td>${dto.bHit}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="write_view.do" class="btn btn-primary pull-right">글작성</a>
</body>
</html>
