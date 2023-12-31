<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP 게시판 - 글쓰기</title>
</head>
<body>
    <h1>글쓰기</h1>
    <div class="row">
    <form action="write.do" method="post">
    	<table class="table table-striped" style="text-align: left; boarder:1px solid #ccc">
        	<thead>
        		<tr>
        			<th colspan="2" style="background-color:#eeeee; text-align: center;"></th>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td><input type="text" class="form-control" placeholder="작성자" name="bName" maxlength="50"></td>
        		</tr>
        		<tr>
        			<td><input type="text" class="form-control" placeholder="글 제목" name="bTitle" maxlength="50"></td>
        		</tr>
        		<tr>
        			<td><textarea class="form-control" placeholder="글 내용" name="bContent" maxlength="1000" style="width:1000px;, height: 500px;"></textarea></td>
        		</tr>
        		<tr>
					<td colspan="5"> <input type="submit" value="작성완료">
					<a href="list.do">목록보기</a></td>        		
				</tr>
        	</tbody>
        </table>
	</form>
	</div>

</body>
</html>
