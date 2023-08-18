package mybatis;

public class MybatisMain {
	public static void main(String[] args) {
		Config config = new Config();
		BoardDAO boardDAO = new BoardDAO(config.getSqlSession());
		boardDAO.work();
		config.getSqlSession();
	}
}
