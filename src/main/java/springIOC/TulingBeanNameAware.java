package springIOC;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * @author duanc
 * @version 1.0
 * @description:
 * @date 2022/8/10 15:16
 */
//@Service
public class TulingBeanNameAware{
    private String name;
//    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
