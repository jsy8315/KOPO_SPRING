package kr.ar.kopo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@ResponseBody	//이 메소드는 데이터만 보내겠다
	@PostMapping("/reply")
	public void writeReply(ReplyVO replyVO) {
		replyService.insertReply(replyVO);
	}
	//http://localhost:8080/springboard/reply/3
	//=>3번 게시글의 댓글 전체, get
	@GetMapping("/reply/{bno}")
	@ResponseBody
	public List<ReplyVO> getAllReply(@PathVariable("bno")int bno) {
		List<ReplyVO> replylist = replyService.getReplybyBoardNo(bno);
		for (ReplyVO replyVO : replylist) {
			System.out.println(replyVO);
		}
		return replylist;
		
	}
}
