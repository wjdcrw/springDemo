package springIOC;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/7/13 17:31
 */
//@Component
public class CloseBeanPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if(beanName.equals("closeService")){
//            beanDefinition.setDestroyMethodName("closeTest");
            // bean定义中将销毁方法置为默认（close或shutdown）,若同时存在 close 和 shutdown 则为 close
            beanDefinition.setDestroyMethodName("(inferred)");
        }
    }
}
