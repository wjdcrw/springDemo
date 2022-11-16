package spring_mybatis202211.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

/**
 * @author duanc
 * @version 1.0
 * @description: ClassPathBeanDefinitionScanner 这个类扫描时会忽略接口，因此需要自定义一个扫描器，重写isCandidateComponent 已达到只扫描接口的作用
 * @date 2022/11/16 22:30
 */
public class DcrBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public DcrBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        // 为了方便调试，所以重写了这个类，只有DcrBeanDefinitionScanner调用doScan方法时才会debug
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        // 此时获取的beanDefinition的类型为接口类型（UserMapper、OrderMapper），不符合我们的要求，所以需要改一下
        for(BeanDefinitionHolder holder:beanDefinitionHolders){
            BeanDefinition beanDefinition = holder.getBeanDefinition();
            // 指定构造器参数
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(DcrFactoryBean.class.getName());
        }
        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }
}
