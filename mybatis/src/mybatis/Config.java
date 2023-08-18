package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Config {
   
   private SqlSession sqlSession;
   
   public Config() {
      
      try {
         String resource = "mybatis-config.xml";
         InputStream inputStream 
         	= Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory 
         	= new SqlSessionFactoryBuilder().build(inputStream);
         sqlSession 
         	= sqlSessionFactory.openSession();
         System.out.println(sqlSession);
      } catch (Exception e) {
          e.printStackTrace();
          // 오류 로그 출력
          System.err.println("Config 클래스에서 오류 발생: " + e.getMessage());
      }
   }
   public SqlSession getSqlSession() {
	   return sqlSession;
   }
}
