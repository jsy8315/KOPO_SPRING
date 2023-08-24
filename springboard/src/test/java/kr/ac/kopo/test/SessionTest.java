package kr.ac.kopo.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.service.BoardServiceImpl;
import kr.ac.kopo.board.vo.BoardVO;

@ContextConfiguration(locations = {"classpath:config/spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Test
	public void selectByNoTest() {
		BoardVO board = sqlSessionTemplate.selectOne("spring.board.dao.BoardDAO.selectbyNo");
		System.out.println(board);
	}
	
	@Test
	public void BoardServiceTest() {
		List<BoardVO> boardlist=
				boardServiceImpl.getAllBoard();
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
		boardServiceImpl.getAllBoard();
		}
	@Ignore
	@Test
	public void sessionTemplateTest() {
		assertNotNull(sqlSessionTemplate);
		System.out.println(sqlSessionTemplate);
	}
	@Test
	public void boardSelectAllTest() {
		sqlSessionTemplate.selectList("spring.board.dao.BoardDAO.selectAll").stream().forEach(System.out::println);

	}
	@Test
	public void sessionTemplateTest2() {
		//List<MemberVo> boardlist = sqlSessionTemplate.selectList(null)
	}
}
