package spring_mybatis202211.spring;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import spring_mybatis202211.mapper.OrderMapper;
import spring_mybatis202211.mapper.UserMapper;

import java.io.IOException;
import java.util.Map;

/**
 * @author duanc
 * @version 1.0
 * @description: 作用类似于BeanDefinitionRegistryPostProcessor
 * @date 2022/11/16 22:15
 */
@Component
public class DcrImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取 @DcrMapperScan 上的value值
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(DcrMapperScan.class.getName());
        String path = (String) annotationAttributes.get("value");
        System.out.println(path);

//        ClassPathBeanDefinitionScanner 为spring默认的扫描器，但是这个类扫描时会忽略接口，因此需要自定义一个扫描器
        DcrBeanDefinitionScanner scanner = new DcrBeanDefinitionScanner(registry);

        // 由于扫描器扫描时会忽略没有@Component 注解的类（isCandidateComponent(MetadataReader)方法），所以如果mapper没有@Component就会扫描不到，故添加如下过滤器，这样mapper就无需添加@Component注解
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });

        scanner.scan(path);
        // 注册bean定义
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
}
