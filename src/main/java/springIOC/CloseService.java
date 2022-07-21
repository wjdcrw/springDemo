package springIOC;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/7/13 16:37
 */
@Service
public class CloseService implements AutoCloseable, DisposableBean{

    @PreDestroy
    public void close1(){
        System.out.println("@PreDestroy 注解指定销毁方法");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close AutoCloseable");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("close DisposableBean");
    }

    /*public void close(){
        System.out.println("bean定义中默认销毁方法close");
    }*/

    public void shutdown(){
        System.out.println("bean定义中默认销毁方法shutdown");
    }


}
