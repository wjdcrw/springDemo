package spring_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_mybatis.dao.AccountMapper;
import spring_mybatis.entity.AccountInfo;

@Service
public class AccountServiceImpl {
    @Autowired
    private AccountMapper accountMapper;
    public AccountInfo qryById(String accountId){
        System.out.println(accountMapper);
        return accountMapper.qryById(accountId);
    }
}
