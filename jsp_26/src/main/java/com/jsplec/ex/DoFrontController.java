package com.jsplec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoFrontController
 */
/*확장자 패턴을 이용하여 *.do로 오는 모든 요청을 한곳에서 다 관리한다 -> FrontController 페턴*/
@WebServlet("*.do")
public class DoFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		//uri = contextPath + 요청한 파일 이름
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
		//command = uri - contextPath 길이만큼 빼면 요청한 파일 이름만 남는다
		String command = uri.substring(contextPath.length());
		System.out.println("command : " + command);
		
		if(command.equals("/memberList.do")) {
			//파일 이름으로 관련된 Dao로 보낸다
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			Action actionInterface = new MemberListAction();
			ArrayList<MemberDTO> dtos = actionInterface.action(request, response);
			
			
		}
}
