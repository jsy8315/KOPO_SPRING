package kr.co.jsplec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement stmt;   
	
	private String id, name, pw, gender, phonenumber;
	
	HttpSession httpSession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();
		
		id = request.getParameter("id");
		pw = request.getParameter("pwd");
		name = request.getParameter("name");
		phonenumber = request.getParameter("phone");
		gender = request.getParameter("gender");
		
		if(pwConfirm()) {
			System.out.println("OK");
			
		String query = "UPDATE MEMBER SET PW = '" + pw + "', NAME ='" +  name + "', PHONENUMBER = '" + phonenumber + "', GENDER = '" + gender + "' WHERE ID = '" + id + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.217.202:1521/KOPODA", "da2317", "da17");
			stmt = connection.createStatement();
			int i = stmt.executeUpdate(query);
			if (i == 1) {
				System.out.println("update 성공");
				httpSession.setAttribute("name", name);
				response.sendRedirect("ModifyResult.jsp");
			} else {
				System.out.println("update 실패");
				response.sendRedirect("modify.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(connection != null) connection.close();
			} catch (Exception e) {}
		}
		}
	}

	private boolean pwConfirm() {
		boolean rs = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			rs = true;
		} else {
			rs = false;
		}
		return rs;
	}
}
