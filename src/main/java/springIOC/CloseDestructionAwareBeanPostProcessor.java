package springIOC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author duanc
 * @version 1.0
 * @description: @PreDestroy 销毁就是通过该方式实现
 * @date 2022/7/21 17:28
 */

//@Component
public class CloseDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("DestructionAwareBeanPostProcessor 销毁bean");
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        if(bean instanceof CloseService){
            return true;
        }
        return false;
    }
}
