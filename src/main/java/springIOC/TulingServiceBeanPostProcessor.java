package springIOC;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/7/15 21:06
 */
@Component
public class TulingServiceBeanPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if(beanName.equalsIgnoreCase("tulingService")){
//            beanDefinition.getPropertyValues().add("tulingDao",new TulingDao());
            System.out.println();
        }
    }
}
