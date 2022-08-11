package springIOC;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * @ClassName MainConfig
 * @Description TODO
 * @Author duanc
 * @Date 2019/9/19 16:02
 * @Version 1.0
 **/
@Import(value = {TulingService.class})
@Configuration
@ComponentScan(basePackages = "springIOC")
//@Controller
@Service
public class MainConfig {
    @Bean
    public TulingDao tulingDao(){
        return new TulingDao();
    }

//    @Bean(autowire = Autowire.BY_NAME)
    public TulingService tulingService(){
        return new TulingService();
    }
    @Bean(autowire = Autowire.BY_TYPE)
    public TulingBeanNameAware tulingBeanNameAware(){
        return new TulingBeanNameAware();
    }
//    @Bean(autowire = Autowire.BY_TYPE)
    public TulingBeanFactoryAware tulingBeanFactoryAware(){
        return new TulingBeanFactoryAware();
    }
}
