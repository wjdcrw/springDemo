package spring_mybatis202211.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_mybatis202211.mapper.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author duanc
 * @version 1.0
 * @description:
 * @date 2022/11/16 21:30
 */
//@Component
public class DcrFactoryBean implements FactoryBean {

    private Class mapperInterface;

    private SqlSession sqlSession;

    public DcrFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
//        Object proxyInstance = Proxy.newProxyInstance(DcrFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method.getName());
//                return null;
//            }
//        });
//        return proxyInstance;

        return sqlSession.getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
