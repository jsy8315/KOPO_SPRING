package mybatis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {

	private SqlSession sqlSession;
	
	public BoardDAO() {
		
	}
	
	public BoardDAO(SqlSession session) {
		this.sqlSession = session;
	}
	public void work() {
		//DB에 sql을 호출
		//insertNewPost();
		//selectAllPost();
		//selectbyName();
		//selectbyName2();
		//selectbyNo();
		//selectbyNo2();
		//deletebyName();
		//updatebyNo();
		//selectDynamicSQL();
		//selectDynamicif();
		//selectDynamicif02();
		//selectDforeach01();
		selectDforeach02();
	}
	public void selectDforeach02() {
		BoardVO b1 = new BoardVO();
		int[] a1 = {1,2,3,4,5,6,7,8,9};
		b1.setNumbers(a1);
		List<BoardVO> boardlist
			= sqlSession.selectList("mybatis.BoardDAO.selectDforeach02", b1);
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}		
	}	
	
	public void selectDforeach01() {
		int[] a1 = {1,2,3,4,5,6};
		List<BoardVO> boardlist
			= sqlSession.selectList("mybatis.BoardDAO.selectDforeach01", a1);
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}		
	}
	
	public void selectDynamicif() {
		//selectDSQLif01
		//title "오펜하이머 스포한다"
		List<BoardVO> boardlist = 
				sqlSession.selectList("mybatis.BoardDAO.selectDSQLif01", "오펜하이머 스포한다");
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	public void selectDynamicif02() {
		//selectDSQLif02
		BoardVO inputboardVO = new BoardVO();
		//inputboardVO.setTitle("오펜하이머 스포한다");
		List<BoardVO> boardlist = 
		sqlSession.selectList("mybatis.BoardDAO.selectDSQLif02", inputboardVO);
		
		for (BoardVO resultboardVO : boardlist) {
			System.out.println(resultboardVO);
		}
	}
	public void selectDynamicSQL() {
		BoardVO inputboardVO = new BoardVO();
		inputboardVO.setTitle("오펜하이머 스포한다");
		//inputboardVO.setWriter("정수사점오");
		List<BoardVO> boardlist = 
		sqlSession.selectList("mybatis.BoardDAO.selectDSQL", inputboardVO);
		
		for (BoardVO resultboardVO : boardlist) {
			System.out.println(resultboardVO);
		}
	}
	public void selectbyNo() {
		List<BoardVO> boardlist
			= sqlSession.selectList("mybatis.BoardDAO.selectbyNo", 8);
		for(BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	public void selectbyNo2() {
		//결과로 map을 resultType으로 준다
		Map<String, Object> map
			= sqlSession.selectOne("mybatis.BoardDAO.selectbyNo2", 9);
		Set <String> keyset = map.keySet();
		for(String key: keyset) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	public void selectbyName() {
		BoardVO boardVO1 = new BoardVO();
		boardVO1.setWriter("정수영");
		List<BoardVO> boardlist
			= sqlSession.selectList("mybatis.BoardDAO.selectbyName", boardVO1);
		for(BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	public void selectbyName2() {
		List<BoardVO> boardlist
			= sqlSession.selectList("mybatis.BoardDAO.selectbyName2", "정수칠");
		for(BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	public void selectAllPost() {
		List<BoardVO> boardlist
			= sqlSession.selectList("mybatis.BoardDAO.selectAll");
		
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO.toString());
		}
	}
	
	public void insertNewPost() {
		//sqlSession.insert("mybatis.BoardDAO.insertNewPost");
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("뉴진스vs누진세");
		boardVO.setWriter("정수십");
		boardVO.setContent("ㄷㅈ? ㄷㅎ?");
		
		sqlSession.insert("mybatis.BoardDAO.insertNewPost2", boardVO);
		sqlSession.commit();
	}
	
	public void deletebyName() {
		sqlSession.delete("mybatis.BoardDAO.deletebyName", "정수일");
		sqlSession.commit();
	}
	
	public void updatebyNo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(7);
		boardVO.setTitle("오펜하이머 스포한다");
		boardVO.setWriter("정수사점오");
		boardVO.setContent("결국 일본에 핵 떨굼");
		sqlSession.update("mybatis.BoardDAO.updatebyNo", boardVO);
		sqlSession.commit();
	}
}
