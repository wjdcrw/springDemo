package spring_mybatis.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring_mybatis.factorybean.TulingMapperFactoryBean;

public class TulingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition accountMapperBd= (GenericBeanDefinition) beanFactory.getBeanDefinition("accountMapper");
        System.out.println("accountMapperBd:"+accountMapperBd.toString());
        accountMapperBd.setBeanClass(TulingMapperFactoryBean.class);
    }
}
