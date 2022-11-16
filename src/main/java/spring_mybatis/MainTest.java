package spring_mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_mybatis.dao.AccountMapper;
import spring_mybatis.entity.AccountInfo;

import java.io.IOException;
import java.io.InputStream;

public class MainTest {
    public static void main(String[] args) throws IOException {
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringMybatisConfig.class);
//        AccountMapper accountMapper= (AccountMapper) context.getBean("accountMapper");
//        accountMapper.qryById("1");

       /* InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        AccountInfo accountInfo = mapper.qryById("1");
        sqlSession.commit();
        sqlSession.flushStatements();
        sqlSession.close();*/

    }
}
