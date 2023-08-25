package kr.ac.kopo.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.vo.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor preHanlde()");
		System.out.println("uri: "+request.getRequestURI());
		System.out.println("servletpath: " +request.getServletPath());
		//로그인 안되어 있는 경우에는 return false, 
		//redirect를 해서 로그인 페이지로 보내버리겠다
		
		HttpSession session = request.getSession();
		//정상 login시에 등록헀음! post/login
		MemberVO memberVO = (MemberVO)session.getAttribute("currentUser");
		session.setAttribute("dest",request.getServletPath());
		if(memberVO != null) {	//로그인되어 있는 경우, ture를 return하여 handler에 제어권넘김
			return true;
		}else {
			System.out.println("로그인 아직 안됐는디요? login페이지로 변경한다");
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
