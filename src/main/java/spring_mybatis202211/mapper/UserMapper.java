package spring_mybatis202211.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/11/16 21:11
 */
public interface UserMapper {
    @Select("select 'user'")
    String selectById();
}
