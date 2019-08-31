package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.UserMapper;
import com.xiaomi.pojo.User;
import com.xiaomi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper = null;

    @Cacheable(value = "user",key = "#root.args[0]",unless = "#result eq null ")
    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public Integer checkUsername(String username) {
        return userMapper.checkUsername(username);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public int UpdateUser(User user) {
        return userMapper.UpdateUser(user);
    }
}
