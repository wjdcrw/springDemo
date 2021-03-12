package spring_mybatis.config;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * 支持扫描接口的bean定义
 */
public class TulingClassPathMapperScanner extends ClassPathBeanDefinitionScanner {

    public TulingClassPathMapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    //bean定义类型是接口的，可以添加到BeanDefinitiomMap中
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return super.isCandidateComponent(beanDefinition);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
