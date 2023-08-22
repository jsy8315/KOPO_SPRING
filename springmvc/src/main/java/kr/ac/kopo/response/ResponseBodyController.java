package kr.ac.kopo.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.form.MemberVO;

@RestController
public class ResponseBodyController {
	/*
	 * 1.url
	 * 2.bean 객체 생성
	 * 3.@ResponseBody 붙이기
	 * */
	
	//@ResponseBody
	@RequestMapping("/stringresponse")
	public String response() {
		return "ok.성공";
	}
	//@ResponseBody
	@RequestMapping("/voresponse")
	public MemberVO voresponse() {	//memberVO return
		MemberVO member = new MemberVO();
		member.setId("정수영");
		member.setPassword("1234");
		return member;
	}
	//member list return 해보기
}
