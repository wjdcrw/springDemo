package spring_mybatis202211;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import spring_mybatis202211.spring.DcrImportBeanDefinitionRegistrar;
import spring_mybatis202211.spring.DcrMapperScan;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/11/16 21:18
 */
@ComponentScan("spring_mybatis202211")
@DcrMapperScan("spring_mybatis202211.mapper")
@MapperScan
public class AppConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
