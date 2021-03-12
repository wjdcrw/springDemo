package spring_mybatis.dao;

import org.springframework.stereotype.Component;
import spring_mybatis.anno.TulingSelect;
import spring_mybatis.entity.AccountInfo;
@Component
public interface AccountMapper {
    @TulingSelect("select * from account_info where account_id=?")
    public AccountInfo qryById(String accountId);
}
