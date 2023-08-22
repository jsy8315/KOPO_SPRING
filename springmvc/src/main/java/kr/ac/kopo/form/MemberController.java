package kr.ac.kopo.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
		//WEB-INF/jsp/
	}
	//@PostMapping("member/join")
	public String join(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//request.setAttribute(id, password);
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		request.setAttribute("member", member);
		return "member/join";
	}
	//@PostMapping("member/join")
	public String join2(HttpServletRequest request,
			@RequestParam("id") String id2,
			@RequestParam("password") String password2
			) {

		MemberVO member = new MemberVO();
		member.setId(id2);
		member.setPassword(password2);
		request.setAttribute("member", member);
		return "member/join";
	}
	//@PostMapping("member/join")
	public String join3(HttpServletRequest request,
			String id,
			String password
			//@RequestParam 생략가능
			) {

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		request.setAttribute("member", member);
		return "member/join";
	}
	//@PostMapping("member/join")
	//보통 이거 많이 쓴다!
	public String join4(MemberVO member) {
		System.out.println(member.getId() + " : " + member.getPassword());//생략가능, 표시만 하는거니까
		return "member/join";
	}
	
	//@PostMapping("member/join")
	public String join5(@ModelAttribute("member") MemberVO member) {
		return "member/join";
	}
	@PostMapping("member/join")
	//ModelAndView로 만들어보기, 의도하지 않은 버그를 만들 수 있다
	public ModelAndView join6(@ModelAttribute MemberVO member) {
			ModelAndView mav = new ModelAndView("member/join");
			mav.addObject("member", member);
			//member객체와 memberVO 둘다 나오는 이유
			//
		return mav;
	}
}
