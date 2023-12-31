package com.jsp.ex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jsp.ex.command.BCommand;
import com.jsp.ex.command.BContentCommand;
import com.jsp.ex.command.BDeleteCommand;
import com.jsp.ex.command.BListCommand;
import com.jsp.ex.command.BModifyCommand;
import com.jsp.ex.command.BReplyCommand;
import com.jsp.ex.command.BReplyViewCommand;
import com.jsp.ex.command.BWriteCommand;

/**
 * Servlet implementation class FrontCon
 */
@WebServlet("*.do") /*확장가가 .do이면 무조건 FronController에 해당하는 FronCon으로 온다!*/
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontCon() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		/*일단 viewPage선언하고, 나중에 do에 따라 다른 page선택*/
		BCommand command = null;
		
		System.out.println("모디(초코)파이01(먹고싶다)");
		//확인을 위한 sysout2
		
		String uri = request.getRequestURI();
		//uri = contextPath + 요청한 파일 이름

		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		//conPath만큼 자르고, 프론트컨트롤러를 사용하기 위한 과정
		//command = uri - contextPath 길이만큼 빼면 요청한 파일 이름만 남는다
		
		System.out.println("모디(초코)파이02(먹고싶다)");
		//확인을 위한 sysout2
		
		//커맨드 패턴을 활용하여, 해당 클래스가 처리하도록함
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
			/*글 작성화면*/
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			/*write.do -> list.do로 포워딩*/
		} else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		/*포워딩 기법을 사용하여 dispatcher 객체에 실어서 보냄*/
		dispatcher.forward(request, response);
	}
}
