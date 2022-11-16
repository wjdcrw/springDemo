package spring_mybatis202211.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/11/16 21:41
 */
public interface OrderMapper {
    @Select("select 'order'")
    String selectById();
}
