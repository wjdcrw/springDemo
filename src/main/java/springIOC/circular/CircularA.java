package springIOC.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author duanc
 * @version 1.0
 * @description: 循环依赖对象A
 * @date 2022/7/26 14:45
 */
@Component
public class CircularA {
    @Autowired
    private CircularB circularB;
}
