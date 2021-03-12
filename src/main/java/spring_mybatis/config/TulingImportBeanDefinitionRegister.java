package spring_mybatis.config;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import spring_mybatis.EnableMapperScanner;
import spring_mybatis.factorybean.TulingMapperFactoryBean;

import java.util.Set;

public class TulingImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    private static Class targetClass= TulingMapperFactoryBean.class;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //手动版的
//        RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(InsA.class);
//        registry.registerBeanDefinition("insB",rootBeanDefinition);

        //包扫描版
        AnnotationAttributes attributes = (AnnotationAttributes) importingClassMetadata.getAnnotationAttributes(EnableMapperScanner.class.getName());
        //配置了EnableMapperScanner注解
        if(attributes==null){
            return;
        }
        String basePackage=attributes.getString("basePackage");
        //扫描bean定义
        TulingClassPathMapperScanner mapperScanner=new TulingClassPathMapperScanner(registry);
        //此时扫描出的bean定义是一个一个的接口
        Set<BeanDefinitionHolder> scannerBds = mapperScanner.doScan(basePackage);
        for(BeanDefinitionHolder bdh:scannerBds){
            //获取bean定义
            GenericBeanDefinition beanDefinition= (GenericBeanDefinition) bdh.getBeanDefinition();
            //拿到bean定义中的接口的class字符串，如 com.tuling.dao.xxxMapper
            String sourceClass=beanDefinition.getBeanClassName();
            System.out.println("原生接口的class类型："+sourceClass);
            //
            beanDefinition.setBeanClass(targetClass);
            //getConstructorArgumentValues方法为调用有参构造器
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(sourceClass);
        }
        System.out.println(scannerBds);
    }
}
