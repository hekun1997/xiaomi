package com.xiaomi.user.service.impl;

import com.xiaomi.common.bo.User;
import com.xiaomi.user.mapper.UserMapper;
import com.xiaomi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author hekun
 */
@CacheConfig(cacheNames = "users",cacheManager = "cacheManager")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "#username")
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

    @CacheEvict(key = "#user.username")
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
