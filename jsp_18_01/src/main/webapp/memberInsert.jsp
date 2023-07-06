<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	
	<%! 
		String inputId;
		String inputPasswd;
		String inputName;
		String inputNumber;
	%>
	
	<%
		String inputId = request.getParameter("inputId");
		String inputPasswd = request.getParameter("inputPasswd");
		String inputName = request.getParameter("inputName");
		String inputNumber = request.getParameter("inputNumber");

	%>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.217.202:1521:xe";
		String uid = "da2317";
		String upw = "da17";
	%>
	
	<%
		Connection con;
		PreparedStatement pstmt;
		
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, upw);
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONENUMBER) VALUES (? ,? , ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPasswd);
		pstmt.setString(3, inputName);
		pstmt.setString(4, inputNumber);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>