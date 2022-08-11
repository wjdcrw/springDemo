package springIOC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author duanc
 * @version 1.0
 * @description:
 * @date 2022/8/10 15:27
 */
@Component
public class TulingBeanFactoryAware  implements BeanFactoryAware{
    private BeanFactory beanFactory;
    private TulingBeanNameAware tulingBeanNameAware;
    private ApplicationEventPublisher publisher;
    @Override
    public void setBeanFactory(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }
    @Autowired
    public void setTulingBeanNameAware(TulingBeanNameAware tulingBeanNameAware) {
        System.out.println("TulingBeanFactoryAware");
        this.tulingBeanNameAware = tulingBeanNameAware;
    }
    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
