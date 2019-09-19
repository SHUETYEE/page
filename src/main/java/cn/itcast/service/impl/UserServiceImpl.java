package cn.itcast.service.impl;


import cn.itcast.mapper.AccountMapper;
import cn.itcast.model.User;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private AccountMapper accountMapper ;

    @Override
    public List<User> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public User findById(Integer userId) {
        return accountMapper.findById(userId);
    }

    @Override
    public void updateUser(User user) {
        accountMapper.updateUser(user);
    }
}
