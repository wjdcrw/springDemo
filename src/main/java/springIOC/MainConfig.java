package springIOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
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
//@Service
public class MainConfig {
    @Bean
    public TulingDao tulingDao(){
        return new TulingDao();
    }
}
