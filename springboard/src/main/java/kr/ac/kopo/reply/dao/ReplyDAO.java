package kr.ac.kopo.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.reply.vo.ReplyVO;

@Repository
public class ReplyDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertReply(ReplyVO replyVO) {
		sqlSessionTemplate.insert("spring.replyDAO.insertReply", replyVO);
		//replyVO와 같이 넘겨준다
	}
	public List<ReplyVO> getReplybyBoardNo(int bno) {
		List<ReplyVO> replylist = 
		sqlSessionTemplate.selectList("springboard.replyDAO.selectByBoardNo", bno);
		return replylist;
	}
}
