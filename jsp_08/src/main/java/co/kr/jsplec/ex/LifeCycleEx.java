package co.kr.jsplec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEx
 */
@WebServlet(urlPatterns={"/LC"}, initParams= {
		@WebInitParam(name="dbName", value="suyoung"),
		@WebInitParam(name="dbPaswd", value="1111"),
		@WebInitParam(name="path", value="path"),
	})

public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String dbnm = getInitParameter("dbName");
		String dbpwd = getInitParameter("dbPaswd");
		String path = getInitParameter("path");
		
		System.out.println("dbName: " + dbnm);
		System.out.println("dbPaswd: " + dbpwd);
		System.out.println("path: " + path);
		
		String dbPublicId = getServletContext().getInitParameter("dbPublicId");
		String dbPublicPwd = getServletContext().getInitParameter("dbPublicPwd");
		String dbPublicSId = getServletContext().getInitParameter("dbPublicSId");
		
		System.out.println("dbPublicId: " + dbPublicId);
		System.out.println("dbPublicPwd: " + dbPublicPwd);
		System.out.println("dbPublicSId: " + dbPublicSId);
		
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter gw = response.getWriter();
		gw.println("<html>");
		gw.println("<head>");
		gw.println("</head>");
		gw.println("<body>");
		gw.println("<br>" + "이름 : " + dbnm + "<br />");
		gw.println("비밀번호 : " + dbpwd + "<br />");
		gw.println("경로 : " + path + "<br />");
		gw.println("</body>");
		gw.println("</html>");
		
		gw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
