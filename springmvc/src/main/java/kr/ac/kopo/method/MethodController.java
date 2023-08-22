package kr.ac.kopo.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class MethodController {
	//http://localhost:8080/springmvc/method/method
	@RequestMapping(value = "/method/method", 
					method = RequestMethod.GET) //get method로 들어올 것이다
	public String get() {
		//view의 이름을 return값으로 준다
		return "method/methodForm";
		//WEB-INF/jsp/method/methodForm.jsp
		//WEB-INF는 건들면 안됨
	}
	
	@RequestMapping(value = "/method/method", 
			method = RequestMethod.POST)	
	public String post() {
		System.out.println("post요청 받았어요");
		return "method/methodProcess";//view name을 리턴하면 됨
		//WEB-INF/jsp/method/methodProcess.jsp
	}
}
