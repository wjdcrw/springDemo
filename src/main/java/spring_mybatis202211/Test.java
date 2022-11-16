package spring_mybatis202211;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_mybatis202211.mapper.OrderMapper;
import spring_mybatis202211.mapper.UserMapper;
import spring_mybatis202211.service.UserService;
import spring_mybatis202211.spring.DcrFactoryBean;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/11/16 21:16
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        // userMapper是接口，所以无法使用该方式注入
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(UserMapper.class);
//        context.registerBeanDefinition("userMapper",beanDefinition);

        context.refresh();
        UserService userService = (UserService) context.getBean("userService");
        userService.test();


    }
}
