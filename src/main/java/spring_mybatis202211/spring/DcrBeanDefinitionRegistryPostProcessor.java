package spring_mybatis202211.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;
import spring_mybatis202211.mapper.OrderMapper;
import spring_mybatis202211.mapper.UserMapper;

/**
 * @author duanc
 * @version 1.0
 * @description: 注册bean定义 作用类似于DcrImportBeanDefinitionRegistrar 二者选其一即可
 * @date 2022/11/16 22:02
 */
//@Component
public class DcrBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 注册bean定义 此处代码可以参考DcrImportBeanDefinitionRegistrar

//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(DcrFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//        registry.registerBeanDefinition("userMapper",beanDefinition);
//
//        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition2.setBeanClass(DcrFactoryBean.class);
//        beanDefinition2.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//        registry.registerBeanDefinition("orderMapper",beanDefinition2);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 忽略不用
    }
}
