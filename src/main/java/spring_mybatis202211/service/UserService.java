package spring_mybatis202211.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_mybatis202211.mapper.OrderMapper;
import spring_mybatis202211.mapper.UserMapper;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/11/16 21:13
 */
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    public void test(){
        System.out.println(userMapper.selectById());
        System.out.println(orderMapper.selectById());
    }
}
