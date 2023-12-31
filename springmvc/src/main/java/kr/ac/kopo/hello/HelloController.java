package kr.ac.kopo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController() 생성자");
	}
	//handler 생성
	//method.client가 요청하면, 요청을 받아줌
	//http://localhost:8080/springmvc + "/hello/hello"
	@RequestMapping("/hello/h1")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("/hello/hello");
		mav.addObject("msg", "HelloWorld");
		//view는 jsp file임
		//WEB-INF/jsp/hello/hello.jsp
		return mav;
	}
	//http://localhost:8080/springmvc/hello/3
	@RequestMapping("hello/{no}")
	public String pathv(@PathVariable("no") int n, Model model) {
		System.out.println("n : " + n);
		model.addAttribute("n", n);
		return "hello/hello";
	}
	
}
